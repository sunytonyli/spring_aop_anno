package com.tony.aop.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

/**
 * @author songyu.li@yeepay.com
 * @createDatetime 2016年5月5日 下午1:41:09
 */

//@Configuration
//@EnableRetry
public class RetryExampleApplication {

//	@Bean
//    public RetryTemplate retryTemplate() {
//        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
//        retryPolicy.setMaxAttempts(5);
//
//        FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
//        backOffPolicy.setBackOffPeriod(1500); // 1.5 seconds
//
//        RetryTemplate template = new RetryTemplate();
//        template.setRetryPolicy(retryPolicy);
//        template.setBackOffPolicy(backOffPolicy);
//
//        return template;
//    }
	
}
