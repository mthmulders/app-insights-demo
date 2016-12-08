package nl.infosupport.proposalkeeper.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Renders the homepage
 */
@Controller
public class HomeController {
    /**
     * Displays the homepage
     *
     * @return Returns the model and view for the homepage
     */
    @RequestMapping("/")
    public ModelAndView homepage() {
        return new ModelAndView("/home/index");
    }
}
