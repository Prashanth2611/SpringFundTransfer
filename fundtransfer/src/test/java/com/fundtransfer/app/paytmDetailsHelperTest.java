/**
 * 
 */
package com.fundtransfer.app;

import java.lang.reflect.Field;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.util.ReflectionUtils;

import com.fundtransfer.dao.CustomerDao;
import com.fundtransfer.model.CustomerDetails;
import com.fundtransfer.service.CustomerDetailsServiceImpl;

/**
 * @author Prashu
 *
 */
@RunWith(EasyMockRunner.class)
public class paytmDetailsHelperTest {

	@Mock
	private CustomerDetailsServiceImpl customerDetailsService;

	@Mock
	private CustomerDao customerDaoMock;

	CustomerDetails customerDetails = new CustomerDetails();

	private void setAccessible(Class<?> clazz, Object target, Object value, String attribute) {

		Field field = ReflectionUtils.findField(clazz, attribute);
		ReflectionUtils.makeAccessible(field);
		ReflectionUtils.setField(field, target, value);
	}

	@Test
	public void fetchMemberTest() {

		EasyMock.expect(customerDaoMock.fetchAllUserDetails(EasyMock.anyObject(String.class)))
				.andReturn(customerDetails);
		EasyMock.replay(customerDaoMock);
		setAccessible(CustomerDetailsServiceImpl.class, customerDetailsService, customerDaoMock, "customerDao");

		customerDetailsService.loadUserByUsername("abc");
	}

}
