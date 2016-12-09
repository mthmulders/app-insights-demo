package nl.infosupport.proposalkeeper.services;

import nl.infosupport.proposalkeeper.models.Proposal;
import nl.infosupport.proposalkeeper.repositories.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProposalServiceImpl implements ProposalService {
    private ProposalRepository proposalRepository;

    /**
     * Initializes a new instance of {@link ProposalServiceImpl}
     *
     * @param proposalRepository The proposal repository for submitted storing proposals
     */
    @Autowired
    public ProposalServiceImpl(ProposalRepository proposalRepository) {
        this.proposalRepository = proposalRepository;
    }

    /**
     * Submits a new proposal
     *
     * @param userId          ID of the user who wrote the proposal
     * @param sessionTitle    Title of the proposal
     * @param sessionAbstract Abstract of the proposal
     * @return Returns the submitted proposal
     */
    @Override
    public Proposal submit(Long userId, String sessionTitle, String sessionAbstract) {
        return proposalRepository.save(new Proposal(0L, userId, sessionTitle, sessionAbstract));
    }

    /**
     * Finds all proposals for a user
     *
     * @param userId ID of the user
     * @return Returns a list of proposals submitted by the user
     */
    @Override
    public Iterable<Proposal> findProposalsForUser(long userId) {
        return proposalRepository.findByUserId(userId);
    }

    /**
     * Finds a list of proposals
     *
     * @return A list of proposals
     */
    @Override
    public Iterable<Proposal> findAllProposals() {
        return proposalRepository.findAll();
    }
}
