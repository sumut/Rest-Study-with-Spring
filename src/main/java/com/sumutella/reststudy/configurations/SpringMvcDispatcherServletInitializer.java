package com.sumutella.reststudy.configurations;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author sumutella
 * @time 5:25 PM
 * @since 11/22/2019, Fri
 */
public class SpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{RestStudyConfig.class};
    }


    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
