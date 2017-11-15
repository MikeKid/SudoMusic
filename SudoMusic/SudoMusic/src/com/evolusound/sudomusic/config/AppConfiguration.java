package com.evolusound.sudomusic.config;

import static com.evolusound.sudomusic.constant.SystemConstants.DEFAULT_ENCODING;
import static com.evolusound.sudomusic.constant.SystemConstants.DEFAULT_LOCALE;
import static com.evolusound.sudomusic.constant.SystemConstants.JSP_BASE_DIR;
import static com.evolusound.sudomusic.constant.SystemConstants.JSP_SUFFIX;
import static com.evolusound.sudomusic.constant.SystemConstants.LOCALE_COOKIE_MAX_AGE;
import static com.evolusound.sudomusic.constant.SystemConstants.LOCALE_COOKIE_NAME;
import static com.evolusound.sudomusic.constant.SystemConstants.MESSAGES_BASE_DIR;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration 
@ComponentScan("com.evolusound.sudomusic")
@EnableWebMvc
public class AppConfiguration extends WebMvcConfigurerAdapter {
	
    @Bean  
    public InternalResourceViewResolver viewResolver() {  
	InternalResourceViewResolver resolver = new InternalResourceViewResolver();  
        resolver.setPrefix(JSP_BASE_DIR);  
        resolver.setSuffix(JSP_SUFFIX);
        return resolver;  
    }
    
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename(MESSAGES_BASE_DIR);
        messageSource.setDefaultEncoding(DEFAULT_ENCODING);
        return messageSource;
    }
    
    @Bean
    public LocaleResolver localeResolver() {
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setDefaultLocale(new Locale(DEFAULT_LOCALE));
		resolver.setCookieName(LOCALE_COOKIE_NAME);
		resolver.setCookieMaxAge(LOCALE_COOKIE_MAX_AGE);
		return resolver;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("language");
		registry.addInterceptor(interceptor);
    }
} 