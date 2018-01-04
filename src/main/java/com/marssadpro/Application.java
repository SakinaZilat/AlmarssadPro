package com.marssadpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

/**
 * Created by zilat on 29.12.2017.
 */
@SpringBootApplication
public class Application
{
    public static void main(String[] args) throws Exception
    {
        SpringApplication.run(Application.class, args);
    }

   
    

    @Bean
	public MultipartResolver multipartResolver()
	{
		 return new StandardServletMultipartResolver();
//		return new CommonsMultipartResolver();
	}
}