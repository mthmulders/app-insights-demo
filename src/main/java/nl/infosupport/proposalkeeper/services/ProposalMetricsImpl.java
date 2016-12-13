package nl.infosupport.proposalkeeper.services;

import com.microsoft.applicationinsights.TelemetryClient;
import com.microsoft.applicationinsights.TelemetryConfiguration;
import com.microsoft.applicationinsights.telemetry.EventTelemetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Implementation of the proposal metrics tracking component
 */
@Component
public class ProposalMetricsImpl implements ProposalMetrics {
    private TelemetryClient telemetryClient;

    /**
     * Initializes a new instance of {@link ProposalMetricsImpl}
     * @param telemetryClient Telemetry client to use
     */
    @Autowired
    public ProposalMetricsImpl(TelemetryClient telemetryClient) {

        this.telemetryClient = telemetryClient;
    }

    /**
     * Tracks the submission of a proposal
     * @param id        ID of the proposal
     * @param title     Title of the proposal
     */
    @Override
    public void trackProposalSubmission(Long id, String title) {
        EventTelemetry eventTelemetry = new EventTelemetry("proposal-submitted");
        eventTelemetry.getProperties().put("title", title);
        eventTelemetry.getProperties().put("id", id.toString());

        telemetryClient.trackEvent(eventTelemetry);
        telemetryClient.flush();
    }
}
