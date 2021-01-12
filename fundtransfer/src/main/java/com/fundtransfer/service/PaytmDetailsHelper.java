/**
 * 
 */
package com.fundtransfer.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.fundtransfer.dto.PayTmDetails;
import com.fundtransfer.model.CustomerDetails;
import com.fundtransfer.repo.CustomerRepository;
import com.paytm.pg.merchant.PaytmChecksum;

/**
 * @author Prashu
 *
 */
@Service
public class PaytmDetailsHelper {

	@Autowired
	private PayTmDetails payTmDetails;

	@Autowired
	private CustomerRepository customRepo;

	/**
	 * Construct the Request details
	 * @param customerId
	 * @param transactionAmount
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public ModelAndView paytmRequestDetails(String customerId, String transactionAmount, String orderId,
			String mobileNumber) throws Exception {

		CustomerDetails customerDetails = customRepo.findbyUsercred(getUserName());

		ModelAndView modelAndView = new ModelAndView("redirect:" + payTmDetails.getPaytmUrl());
		TreeMap<String, String> parameters = new TreeMap<>();
		if (customerDetails != null) {
			payTmDetails.getDetails().forEach((k, v) -> parameters.put(k, v));
			parameters.put("MOBILE_NO", mobileNumber);
			parameters.put("EMAIL", customerDetails.getEmail());
			parameters.put("ORDER_ID", orderId);
			parameters.put("TXN_AMOUNT", transactionAmount);
			parameters.put("CUST_ID", customerId);
			String checkSum = getCheckSum(parameters);
			parameters.put("CHECKSUMHASH", checkSum);

		}
		modelAndView.addAllObjects(parameters);
		return modelAndView;
	}

	/**
	 * fetches user name from current thread
	 * @return
	 */
	public static String getUserName() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		String userName = null;
		if (authentication != null) {

			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			userName = userDetails.getUsername();

		}
		return userName;
	}

	/**
	 * Construct the Response details
	 * @param request
	 * @param model
	 */
	public void paytmResponseDetails(HttpServletRequest request, Model model) {
		Map<String, String[]> mapData = request.getParameterMap();
		TreeMap<String, String> parameters = new TreeMap<String, String>();
		mapData.forEach((key, val) -> parameters.put(key, val[0]));
		String paytmChecksum = "";
		if (mapData.containsKey("CHECKSUMHASH")) {
			paytmChecksum = mapData.get("CHECKSUMHASH")[0];
		}
		String result;

		boolean isValideChecksum = false;
		try {
			isValideChecksum = validateCheckSum(parameters, paytmChecksum);
			if (isValideChecksum && parameters.containsKey("RESPCODE")) {
				if (parameters.get("RESPCODE").equals("01")) {
					result = "Payment Successful";
				} else {
					result = "Payment Failed";
				}
			} else {
				result = "Checksum mismatched";
			}
		} catch (Exception e) {
			result = e.toString();
		}
		List<String> status = Arrays.asList("Payment Successful", "TXN_FAILURE", "Checksum mismatched");

		model.addAttribute("result", result);
		parameters.remove("CHECKSUMHASH");
		model.addAttribute("parameters", parameters);
	}

	/**
	 * @param model
	 */
	public void setModelAttribute(Model model) {
		CustomerDetails customerDetails = customRepo.findbyUsercred(getUserName());
		model.addAttribute("firstName", customerDetails.getFirstName());
		model.addAttribute("lastName", customerDetails.getLastName());
		model.addAttribute("mobileno", customerDetails.getPhoneNumber());
		model.addAttribute("email", customerDetails.getEmail());
		model.addAttribute("custid", customerDetails.getCustomerId().toString());
	}

	/**
	 * @param parameters
	 * @param paytmChecksum
	 * @return
	 * @throws Exception
	 */
	public boolean validateCheckSum(TreeMap<String, String> parameters, String paytmChecksum) throws Exception {
		return PaytmChecksum.verifySignature(parameters, payTmDetails.getMerchantKey(), paytmChecksum);
	}

	/**
	 * @param parameters
	 * @return
	 * @throws Exception
	 */
	public String getCheckSum(TreeMap<String, String> parameters) throws Exception {
		return PaytmChecksum.generateSignature(parameters, payTmDetails.getMerchantKey());
	}
}
