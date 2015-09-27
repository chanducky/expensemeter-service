/*package com.em.expensemeter.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
class MvcConf extends WebMvcConfigurationSupport {
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(converter());
        addDefaultHttpMessageConverters(converters);
    }

    @Bean
    MappingJacksonHttpMessageConverter converter() {
        MappingJacksonHttpMessageConverter converter = new MappingJacksonHttpMessageConverter();
        //do your customizations here...
        return converter;
    }
}*/