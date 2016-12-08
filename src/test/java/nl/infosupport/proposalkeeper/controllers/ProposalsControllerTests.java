package nl.infosupport.proposalkeeper.controllers;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ProposalsControllerTests {

    private ProposalsController controller;

    @Before
    public void setUp() {
        controller = new ProposalsController();
    }

    @Test
    public void testListProposalsReturnsProposalsListView() {
        ModelAndView result = controller.listProposals();

        assertThat(result.getViewName(), equalTo("/proposals/index"));
    }

    @Test
    public void testCreateProposalReturnsNewProposalView() {
        ModelAndView result = controller.createNewProposal();

        assertThat(result.getViewName(), equalTo("/proposals/new"));
    }

    @Test
    public void testSubmitProposalRedirectsToListView() {
        ModelAndView result = controller.submitProposal();

        assertThat(result.getView().getClass(), typeCompatibleWith(RedirectView.class));
        assertThat(((RedirectView)result.getView()).getUrl(), equalTo("/proposals"));
    }
}
