package com.epam.spring.hometask.config;

import com.epam.spring.ws.rest.converter.PdfMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

import java.text.SimpleDateFormat;
import java.util.List;

@Configuration
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter {

    /**
     * Setup a simple strategy:
     * 1. Only path extension taken into account, Accept headers ignored.
     * 2. Return HTML by default when not sure.
     */
    @Override
    public void configureContentNegotiation
    (ContentNegotiationConfigurer configurer) {
        configurer.ignoreAcceptHeader(true)
                .defaultContentType(MediaType.TEXT_HTML);
    }

    /**
     * Create the CNVR. Get Spring to inject the ContentNegotiationManager
     * created by the configurer (see previous method).
     */
    @Bean
    public ViewResolver contentNegotiatingViewResolver(
            ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver =
                new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);
        return resolver;
    }


    @Override
    public void configureMessageConverters(final List<HttpMessageConverter<?>> messageConverters) {
        final Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.indentOutput(true)
                .dateFormat(new SimpleDateFormat("dd-MM-yyyy hh:mm"));
        messageConverters.add(new MappingJackson2HttpMessageConverter(builder.build()));
        messageConverters.add(new PdfMessageConverter());


        super.configureMessageConverters(messageConverters);
    }

    private HttpMessageConverter<Object> createXmlHttpMessageConverter() {
        final MarshallingHttpMessageConverter xmlConverter = new MarshallingHttpMessageConverter();

        final XStreamMarshaller xstreamMarshaller = new XStreamMarshaller();
        xmlConverter.setMarshaller(xstreamMarshaller);
        xmlConverter.setUnmarshaller(xstreamMarshaller);

        return xmlConverter;
    }

}