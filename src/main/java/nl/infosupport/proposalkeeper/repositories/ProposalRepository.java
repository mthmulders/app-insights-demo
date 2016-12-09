package nl.infosupport.proposalkeeper.repositories;

import nl.infosupport.proposalkeeper.models.Proposal;
import org.springframework.data.repository.CrudRepository;

/**
 * Provides access to proposals
 */
public interface ProposalRepository extends CrudRepository<Proposal, Long> {
    /**
     * Finds all proposals for a specific user
     *
     * @param userId ID of the user
     * @return Returns an iterable list of proposals
     */
    Iterable<Proposal> findByUserId(long userId);
}
