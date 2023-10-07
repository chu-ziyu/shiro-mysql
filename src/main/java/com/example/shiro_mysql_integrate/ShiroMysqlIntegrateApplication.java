package com.example.shiro_mysql_integrate;

import org.apache.shiro.authz.AuthorizationException;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@SpringBootApplication
@RestControllerAdvice
public class ShiroMysqlIntegrateApplication {

	private static Logger log = LoggerFactory.getLogger(ShiroMysqlIntegrateApplication.class);

	@ExceptionHandler(AuthorizationException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public void handlerException(AuthorizationException exception) {
		log.debug("{} was throw", exception.getClass(), exception);
	}

	@Bean
	public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator(){
		DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator=new DefaultAdvisorAutoProxyCreator();
		defaultAdvisorAutoProxyCreator.setUsePrefix(true);

		return defaultAdvisorAutoProxyCreator;
	}

	public static void main(String[] args) {
		SpringApplication.run(ShiroMysqlIntegrateApplication.class, args);
	}

}