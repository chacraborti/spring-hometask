package com.epam.spring.hometask.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
import com.epam.view.PdfView;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {


//    @Bean
//    public FreeMarkerViewResolver freemarkerViewResolver() {
//        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
//        resolver.setCache(true);
//        resolver.setPrefix("");
//        resolver.setSuffix(".ftl");
//        return resolver;
//    }
//
//
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.freeMarker();
//        registry.beanName();
//    }
//
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }
//
//    @Bean
//    public FreeMarkerViewResolver freeMarkerViewResolver() {
//        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
//        resolver.setCache(false);
//        resolver.setPrefix("");
//        resolver.setSuffix(".ftl");
//        return resolver;
//    }
//
//    @Bean
//    public FreeMarkerConfigurer freeMarkerConfigurer() {
//        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
//       // configurer.setTemplateLoaderPath("WEB-INF/views/ftl/");
//        return configurer;
//    }
//
//    @Bean
//    public CommonsMultipartResolver multipartResolver() {
//        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//      //  resolver.setMaxUploadSize(MAX_UPLOAD_SIZE);
//        return resolver;
//    }
//
//    @Bean
//    public PdfView pdfView() {
//        return new PdfView();
//    }
}

