package com.tony.aop;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tony.aop.service.AnnoService;

/**
 * @author songyu.li@yeepay.com
 * @createDatetime 2016年5月4日 下午3:31:04
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class AnnoServiceTest {

	@Autowired
	private AnnoService annoService;
	
	@Test
	public void testRetry() {
		annoService.retryDoSomes();
	}

}
