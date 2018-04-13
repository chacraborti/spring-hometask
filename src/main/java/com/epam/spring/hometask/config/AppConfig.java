package com.epam.spring.hometask.config;

import com.epam.spring.hometask.App;
import com.epam.view.PdfView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@EnableWebMvc
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.epam.spring.hometask")
@Import({ SecurityConfig.class })
public class AppConfig {

    @Bean
    public FreeMarkerViewResolver freemarkerViewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setPrefix("");
        resolver.setSuffix(".ftl");
        return resolver;
    }

    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() {
        FreeMarkerConfigurer fmc = new FreeMarkerConfigurer();
        fmc.setTemplateLoaderPath("WEB-INF/template/");
        return fmc;
    }

    @Bean
    public MultipartResolver multipartResolver() {
        return new CommonsMultipartResolver();
    }
    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {

        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);

        List<ViewResolver> resolvers = new ArrayList<>();
        resolvers.add(freemarkerViewResolver());
        resolvers.add(new PDFViewResolver());

        resolver.setViewResolvers(resolvers);

        return resolver;
    }

    public class PDFViewResolver implements ViewResolver {

        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return new PdfView();
        }
    }

    @Bean
    public HandlerExceptionResolver exceptionResolver() {
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        resolver.setDefaultErrorView("error");
        return resolver;
    }

    @Autowired
    private Environment environment;

    @Bean
    public App app(){
        return new App();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        return jdbcTemplate;
    }

    @Bean
    public DataSource dataSource() {

        // no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder
                .setType(EmbeddedDatabaseType.H2)
                .addScript("db/sql/create-db.sql")
                .addScript("db/sql/insert-data.sql")
                .build();
        return db;
    }
}
