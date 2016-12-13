package nl.infosupport.proposalkeeper.services;

/**
 * Tracks metrics for proposals
 */
public interface ProposalMetrics {
    /**
     * Tracks the submission of a proposal in the application
     * @param id        ID of the proposal
     * @param title     Title of the proposal
     */
    void trackProposalSubmission(Long id, String title);
}
