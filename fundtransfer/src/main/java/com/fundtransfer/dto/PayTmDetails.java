package com.fundtransfer.dto;

import java.util.Map;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Prashu
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
@ConfigurationProperties("paytm.payment.sandbox")
public class PayTmDetails {

	@NotEmpty
	private String merchantId;

	@NotEmpty
	private String merchantKey;

	private String channelId;

	private String website;

	@NotEmpty
	private String industryTypeId;

	@NotEmpty
	private String paytmUrl;

	private Map<String, String> details;

	/**
	 * @return the merchantId
	 */
	public String getMerchantId() {
		return merchantId;
	}

	/**
	 * @param merchantId the merchantId to set
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	/**
	 * @return the merchantKey
	 */
	public String getMerchantKey() {
		return merchantKey;
	}

	/**
	 * @param merchantKey the merchantKey to set
	 */
	public void setMerchantKey(String merchantKey) {
		this.merchantKey = merchantKey;
	}

	/**
	 * @return the channelId
	 */
	public String getChannelId() {
		return channelId;
	}

	/**
	 * @param channelId the channelId to set
	 */
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * @return the industryTypeId
	 */
	public String getIndustryTypeId() {
		return industryTypeId;
	}

	/**
	 * @param industryTypeId the industryTypeId to set
	 */
	public void setIndustryTypeId(String industryTypeId) {
		this.industryTypeId = industryTypeId;
	}

	/**
	 * @return the paytmUrl
	 */
	public String getPaytmUrl() {
		return paytmUrl;
	}

	/**
	 * @param paytmUrl the paytmUrl to set
	 */
	public void setPaytmUrl(String paytmUrl) {
		this.paytmUrl = paytmUrl;
	}

	/**
	 * @return the details
	 */
	public Map<String, String> getDetails() {
		return details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(Map<String, String> details) {
		this.details = details;
	}

	
}
