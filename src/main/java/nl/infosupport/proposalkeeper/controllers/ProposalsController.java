package nl.infosupport.proposalkeeper.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * MVC controller for the proposals page
 */
@Controller
public class ProposalsController {
    /**
     * Lists all the proposals submitted by the current user
     * @return  Returns the model and view for the action
     */
    @RequestMapping("/proposals")
    public ModelAndView listProposals() {
        return new ModelAndView("/proposals/index");
    }

    /**
     * Displays a page to create a new proposal
     * @return  Returns the model and view for the action
     */
    @RequestMapping("/proposals/new")
    public ModelAndView createNewProposal() {
        return new ModelAndView("/proposals/new");
    }

    /**
     * Submits a new proposal for review
     * @return  Returns the model and view for the action
     */
    @RequestMapping(path = "/proposals/", method = RequestMethod.POST)
    public ModelAndView submitProposal() {
        return new ModelAndView(new RedirectView("/proposals"));
    }
}
