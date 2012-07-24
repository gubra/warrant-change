package com.organic.service.impl;

import org.junit.Assert;

import com.liferay.portal.service.persistence.BasePersistenceTestCase;
import com.organic.model.Warrant;
import com.organic.service.WarrantLocalServiceUtil;

public class WarrantLocalServiceImplTest extends BasePersistenceTestCase {

	public void testAddWarrant() throws Exception {
		long userId = 1L;
		String summary = "MySummary";
		int quantity = 33;
		long price = 499;
		
		Warrant result = WarrantLocalServiceUtil.addWarrant(userId , summary, quantity, price);
		
		assertNotNull(result);
		assertNotNull(result.getId());
		assertEquals(userId, result.getId());
		assertEquals(summary, result.getSummary());
		assertEquals(quantity, result.getQuantity());
		assertEquals(price, result.getPrice());
		assertNotNull(result.getCreateDate());
		assertNotNull(result.getModifiedDate());
		assertEquals(result.getCreateDate(), result.getModifiedDate());
	}
}
