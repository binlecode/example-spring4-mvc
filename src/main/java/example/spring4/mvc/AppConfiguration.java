package example.spring4.mvc;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "example.spring4.mvc")  // referes to package locations to find the associated beans
public class AppConfiguration {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    /**
     * ContentNegotiatingViewResolver considers the Accept header and uses whatever
     * media types it asks for, but only after it first looks at the URL’s file extension.
     * If the URL has a file extension on the end, ContentNegotiatingViewResolver tries to
     * figure out the desired type based on that extension.
     */
//    @Bean
//    public ViewResolver contentNegotiatingViewResolver() {
//        return new ContentNegotiatingViewResolver();
//    }

    /**
     * for working with form submission, validating user input (via JSR303 annotations).
     * In case of validation failure, default error messages are shown.
     * To override those default by your own custom [internationalized] messages from
     * an external Message bundle [.properties file], we need to configure a ResourceBundleMessageSource.
     * Method messageSource is there for same purpose.
     *
     * Notice the parameter provided (messages) to basename method. Spring will search for a file named
     * messages.properties in application class path.
     * @return
     */
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }



}
