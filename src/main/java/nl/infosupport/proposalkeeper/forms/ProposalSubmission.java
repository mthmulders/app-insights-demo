package nl.infosupport.proposalkeeper.forms;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * A single submission of a proposal from the website
 */
public @Data class ProposalSubmission {
    @NotEmpty(message = "Please provide a valid title for your session")
    private String sessionTitle;

    @NotEmpty(message = "Please provide a valid abstract for your session")
    private String sessionAbstract;
}
