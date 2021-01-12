/**
 * 
 */
package com.fundtransfer.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * @author Prashu
 *
 */
@Component
public class AuthenticationEntryPointConfig extends BasicAuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
		response.addHeader("WWW-Authenticate", "");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		PrintWriter writer = response.getWriter();
		writer.println("HTTP STATUS 401 -" + authException.getMessage());
	}

	@Override
	public void afterPropertiesSet() {
		setRealmName("fundTransfer");
		super.afterPropertiesSet();
	}
}
