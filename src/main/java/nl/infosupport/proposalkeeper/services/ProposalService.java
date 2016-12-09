package nl.infosupport.proposalkeeper.services;

import nl.infosupport.proposalkeeper.models.Proposal;

/**
 * Provides a way to submit proposals on the website
 */
public interface ProposalService {
    /**
     * Submits a new proposal
     *
     * @param userId          ID of the user who wrote the proposal
     * @param sessionTitle    Title of the proposal
     * @param sessionAbstract Abstract of the proposal
     * @return Returns the submitted proposal
     */
    Proposal submit(Long userId, String sessionTitle, String sessionAbstract);

    /**
     * Finds all proposals for a user
     * @param userId    ID of the user
     * @return  Returns a list of proposals submitted by the user
     */
    Iterable<Proposal> findProposalsForUser(long userId);

    /**
     * Finds a list of proposals
     * @return
     */
    Iterable<Proposal> findAllProposals();
}
