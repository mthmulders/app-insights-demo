package nl.infosupport.proposalkeeper;

import com.microsoft.applicationinsights.TelemetryClient;
import com.microsoft.applicationinsights.TelemetryConfiguration;
import com.microsoft.applicationinsights.web.internal.WebRequestTrackingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * Provides configuration for application insights
 */
@Configuration
public class ApplicationInsightsConfiguration {
    /**
     * Gets the current telemetry configuration
     *
     * @return The current telemetry configuration
     */
    @Bean
    public TelemetryConfiguration telemetryConfiguration() {
        return TelemetryConfiguration.getActive();
    }

    /**
     * Gets the telemetry client to use for sending metrics and other telemetry data
     *
     * @param telemetryConfiguration Configuration to use for the client
     * @return Returns the instance of the telemetry client to use
     */
    @Bean
    public TelemetryClient telemetryClient(TelemetryConfiguration telemetryConfiguration) {
        return new TelemetryClient(telemetryConfiguration);
    }

    /**
     * Registers a filter for tracking HTTP Requests with application insights
     *
     * @return Returns the filter registration for the HTTP request tracking
     */
    @Bean
    @Order(0)
    public FilterRegistrationBean metricsHttpFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();

        registration.setFilter(metricsHttpFilter());
        registration.addUrlPatterns("/*");
        registration.setName("http-request-metrics");
        registration.setOrder(0);

        return registration;
    }

    /**
     * The instance of the HTTP request tracking filter
     *
     * @return
     */
    @Bean
    public WebRequestTrackingFilter metricsHttpFilter() {
        return new WebRequestTrackingFilter();
    }
}
