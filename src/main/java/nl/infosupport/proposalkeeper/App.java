package nl.infosupport.proposalkeeper;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;

/**
 * Main entrypoint for the application
 */
@SpringBootApplication
public class App {
    /**
     * Starts the spring application using the specified arguments
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    /**
     * Overrides the original template engine with a template engine
     * implementation that supports thymeleaf layouts.
     *
     * @return Returns the new instance of the template engine
     */
    @Bean
    public TemplateEngine templateEngine() {
        TemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.addDialect(new LayoutDialect());

        return templateEngine;
    }
}
