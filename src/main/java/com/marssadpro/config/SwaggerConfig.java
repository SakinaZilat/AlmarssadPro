package com.marssadpro.config;

import static com.google.common.base.Predicates.or;
import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.schema.AlternateTypeRules.newRule;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.classmate.TypeResolver;
import com.google.common.base.Predicate;

import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableAutoConfiguration
@EnableSwagger2
@ConditionalOnWebApplication
public class SwaggerConfig extends WebMvcConfigurerAdapter
{
	@Autowired
	private TypeResolver typeResolver;
	
	@Autowired
	Environment env;
	
	/**
	 * @return
	 * Here is an example where we select any api that matches one of these paths
	 */
	@SuppressWarnings("unchecked")
	private Predicate<String> paths()
	{
		return or(regex(".*?"));
	}
	
	@Bean
	public Docket petApi()
	{
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(new ApiInfo("MarssadProService REST API", "MarssadProService REST API", env.getProperty("info.build.version"), "", "zilatsakina@hotmail.com", "", "")).select().paths(paths()).build().directModelSubstitute(LocalDate.class, String.class).genericModelSubstitutes(ResponseEntity.class).alternateTypeRules(newRule(typeResolver.resolve(DeferredResult.class, typeResolver.resolve(ResponseEntity.class, WildcardType.class)), typeResolver.resolve(WildcardType.class))).useDefaultResponseMessages(false).globalResponseMessage(RequestMethod.GET, newArrayList(new ResponseMessageBuilder().code(500).message("500 message").responseModel(new ModelRef("Error")).build())).enableUrlTemplating(false).directModelSubstitute(Date.class, String.class);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	

}
