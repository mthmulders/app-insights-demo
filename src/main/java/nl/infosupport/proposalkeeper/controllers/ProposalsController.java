package nl.infosupport.proposalkeeper.controllers;

import com.google.common.collect.ImmutableMap;
import nl.infosupport.proposalkeeper.forms.ProposalSubmission;
import nl.infosupport.proposalkeeper.models.Proposal;
import nl.infosupport.proposalkeeper.services.ProposalMetrics;
import nl.infosupport.proposalkeeper.services.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

/**
 * MVC controller for the proposals page
 */
@Controller
public class ProposalsController {
    private ProposalService proposalService;
    private ProposalMetrics metrics;

    /**
     * Initializes a new instance of {@link ProposalsController}
     * @param proposalService   The proposal service to use
     * @param metrics
     */
    @Autowired
    public ProposalsController(ProposalService proposalService, ProposalMetrics metrics) {
        this.proposalService = proposalService;
        this.metrics = metrics;
    }

    /**
     * Lists all the proposals submitted by the current user
     *
     * @return Returns the model and view for the action
     */
    @RequestMapping(path = "/proposals", method = RequestMethod.GET)
    public ModelAndView listAllProposals() {
        return new ModelAndView("/proposals/index", ImmutableMap.of("proposals", proposalService.findAllProposals()));
    }

    /**
     * Lists the proposals the user has submitted
     *
     * @return Returns the model and view for the action
     */
    @RequestMapping("/proposals/submitted")
    public ModelAndView listSubmittedProposals() {
        return new ModelAndView("/proposals/submitted", ImmutableMap.of("proposals", proposalService.findProposalsForUser(1)));
    }

    /**
     * Displays a page to create a new proposal
     *
     * @return Returns the model and view for the action
     */
    @RequestMapping("/proposals/new")
    public ModelAndView createNewProposal() {
        ProposalSubmission submission = new ProposalSubmission();
        submission.setSessionTitle("Test session");

        Map<String, Object> model = ImmutableMap.of("submission", submission);

        return new ModelAndView("/proposals/new", model);
    }

    /**
     * Submits a new proposal for review
     *
     * @param submission    The submitted proposal data
     * @param bindingResult The outcome of the form binding operation
     * @return Returns the model and view for the action
     */
    @RequestMapping(path = "/proposals", method = RequestMethod.POST)
    public ModelAndView submitProposal(@Valid @ModelAttribute("submission") final ProposalSubmission submission, final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("/proposals/new", ImmutableMap.of("submission", submission));
        }

        //TODO: Fix this so it uses the currently logged on user.
        Proposal submittedProposal = proposalService.submit(
            1L, submission.getSessionTitle(), submission.getSessionAbstract());

        metrics.trackProposalSubmission(submittedProposal.getId(),submittedProposal.getTitle());

        return new ModelAndView("redirect:/proposals");
    }
}
