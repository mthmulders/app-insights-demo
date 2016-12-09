package nl.infosupport.proposalkeeper.controllers;

import nl.infosupport.proposalkeeper.forms.ProposalSubmission;
import nl.infosupport.proposalkeeper.models.Proposal;
import nl.infosupport.proposalkeeper.services.ProposalService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import static org.mockito.Mockito.*;

public class ProposalsControllerTests {
    private ProposalService proposalService;
    private ProposalsController controller;

    @Before
    public void setUp() {
        proposalService = mock(ProposalService.class);
        controller = new ProposalsController(proposalService);
    }

    @Test
    public void testListProposalsReturnsProposalsListView() {
        ModelAndView result = controller.listAllProposals();

        assertThat(result.getViewName(), equalTo("/proposals/index"));
    }

    @Test
    public void testCreateProposalReturnsNewProposalView() {
        ModelAndView result = controller.createNewProposal();

        assertThat(result.getViewName(), equalTo("/proposals/new"));
    }

    @Test
    public void testSubmitProposalRedirectsToListView() {
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.hasErrors()).thenReturn(false);

        when(proposalService.submit(any(), any(), any()))
            .thenReturn(new Proposal(1L, 1L, "Sample", "Sample"));

        ModelAndView result = controller.submitProposal(
            new ProposalSubmission(),
            bindingResult);

        assertThat(result.getViewName(), equalTo("redirect:/proposals"));
    }

    @Test
    public void testSubmitInvokesProposalService() {
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.hasErrors()).thenReturn(false);

        when(proposalService.submit(any(), any(), any()))
            .thenReturn(new Proposal(1L, 1L, "Sample", "Sample"));

        ModelAndView result = controller.submitProposal(new ProposalSubmission(), bindingResult);

        verify(proposalService).submit(any(),any(),any());
    }
}
