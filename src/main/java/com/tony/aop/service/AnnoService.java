package com.tony.aop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @author songyu.li@yeepay.com
 * @createDatetime 2016年5月4日 下午3:25:10
 */

@Service
@EnableRetry
//@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AnnoService {
	
	private static final Logger logger = LoggerFactory.getLogger(AnnoService.class);
	
	@Retryable(maxAttempts = 5, backoff = @Backoff(random = true))
	public String retryDoSomes() {
		int random = (int) (Math.random() * 10);
		if (random < 4) {
			logger.info("random={} Null Pointer Excep", random);
			throw new NullPointerException();
		} else if (random < 9) {
			logger.info("random={} Arithmetic Excep", random);
			throw new ArithmeticException();
		}
		logger.info("random={} ok !!!!", random);
		return "ok";
	}
	
	@Recover
	public String recover(NullPointerException ne) {
		logger.info("{}", "NullPointerException");
		return "null pointer recover";
	}
	
	@Recover
	public String recover(ArithmeticException ne) {
		logger.info("{}", "ArithmeticException");
		return "ArithmeticException recover";
	}
}