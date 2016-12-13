package nl.infosupport.proposalkeeper;

import com.microsoft.applicationinsights.web.spring.RequestNameHandlerInterceptorAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Applies additional web configuration to the application
 */
@Configuration
public class WebApplicationConfiguration extends WebMvcConfigurerAdapter {
    /**
     * Adds additional view controllers to the application for rendering the login page
     * @param registry  The view controller registry to register the controllers with
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/account/login").setViewName("/account/login");
    }
}
