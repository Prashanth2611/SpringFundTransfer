/**
 * 
 */
package com.fundtransfer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fundtransfer.service.PaytmDetailsHelper;

/**
 * @author Prashu
 *
 */

@RestController
public class MainController {

	@Autowired
	PaytmDetailsHelper paytmDetailsHelper;

	
	/**
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	@ResponseBody
	public ModelAndView Homepage(Model model) {

		paytmDetailsHelper.setModelAttribute(model);

		return new ModelAndView("home", "model", model);
	}
	

	/**
	 * @param customerId
	 * @param transactionAmount
	 * @param orderId
	 * @param mobileNumber
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/pgredirect")
	public ModelAndView getRedirect(@RequestParam(name = "CUST_ID") String customerId,
			@RequestParam(name = "TXN_AMOUNT") String transactionAmount,
			@RequestParam(name = "ORDER_ID") String orderId, @RequestParam(name = "MOBILE NUMBER") String mobileNumber)
			throws Exception {

		ModelAndView modelAndView = paytmDetailsHelper.paytmRequestDetails(customerId, transactionAmount, orderId,
				mobileNumber);
		return modelAndView;
	}

	
	
	/**
	 * @param request
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/pgresponse")
	public ModelAndView getResponseRedirect(HttpServletRequest request, Model model) {

		paytmDetailsHelper.paytmResponseDetails(request, model);

		return new ModelAndView("report", "model", model);
	}

	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping("/login-error.html")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "Login.html";
	}

}
