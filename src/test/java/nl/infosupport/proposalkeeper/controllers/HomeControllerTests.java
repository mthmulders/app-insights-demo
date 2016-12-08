package nl.infosupport.proposalkeeper.controllers;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class HomeControllerTests {
    @Test
    public void testHomeReturnsHomepage() {
        HomeController controller = new HomeController();
        ModelAndView result = controller.homepage();

        assertThat(result.getViewName(), equalTo("/home/index"));
    }
}
