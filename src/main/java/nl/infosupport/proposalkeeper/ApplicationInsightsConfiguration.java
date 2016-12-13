package nl.infosupport.proposalkeeper;

import com.microsoft.applicationinsights.TelemetryConfiguration;
import com.microsoft.applicationinsights.web.internal.WebRequestTrackingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Provides configuration for application insights
 */
@Configuration
public class ApplicationInsightsConfiguration {
    /**
     * Registers a filter for tracking HTTP Requests with application insights
     * @return  Returns the filter registration for the HTTP request tracking
     */
    @Bean
    public FilterRegistrationBean metricsHttpFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();

        registration.setFilter(metricsHttpFilter());
        registration.addUrlPatterns("/*");
        registration.setName("http-request-metrics");
        registration.setOrder(1);

        return registration;
    }

    /**
     * The instance of the HTTP request tracking filter
     * @return
     */
    @Bean
    public WebRequestTrackingFilter metricsHttpFilter() {
        return new WebRequestTrackingFilter();
    }
}
