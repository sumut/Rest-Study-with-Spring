package com.sumutella.reststudy.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

import java.util.List;


/**
 * @author sumutella
 * @time 5:25 PM
 * @since 11/22/2019, Fri
 */

@Configuration
@EnableWebMvc  //annotation driven. formatting, conversion, ...
@ComponentScan(basePackages = "com.sumutella.reststudy")
public class RestStudyConfig implements WebMvcConfigurer {


//    @Bean
//    public ViewResolver viewResolver(){
//        InternalResourceViewResolver viewResolver1 = new InternalResourceViewResolver();
//        viewResolver1.setPrefix("/WEB-INF/view/");
//        viewResolver1.setSuffix(".jsp");
//        return viewResolver1;
//    }


    // BELOW CODE IS TO ESCAPE FROM EXCEPTION IN THE LINK
    // https://stackoverflow.com/questions/26957554/jsonmappingexception-could-not-initialize-proxy-no-session

    public MappingJackson2HttpMessageConverter jacksonMessageConverter(){
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();

        ObjectMapper mapper = new ObjectMapper();
        //Registering Hibernate4Module to support lazy objects
        Hibernate5Module hm = new Hibernate5Module();
        mapper.registerModule(hm);

        messageConverter.setObjectMapper(mapper);
        return messageConverter;

    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //Here we add our custom-configured HttpMessageConverter
        converters.add(jacksonMessageConverter());
        WebMvcConfigurer.super.configureMessageConverters(converters);
    }




}
