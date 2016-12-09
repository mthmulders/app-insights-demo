package nl.infosupport.proposalkeeper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Provides configuration for the application security
 */
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {
    /**
     * Configures the security for the web application
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/proposals/**")
                .authenticated()
                .and()
            .formLogin()
                .loginPage("/account/login")
                .permitAll()
                .and()
            .logout()
                .logoutUrl("/account/logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("/account/logout"))
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/")
                .permitAll()
                .and()
            .csrf()
                .csrfTokenRepository(csrfTokenRepository());
    }

    /**
     * Configures the authentication manager builder
     * @param auth  Authentication manager builder to configure
     * @throws Exception    Gets thrown when configuration failed to load
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("admin")
                .password("P@ssw0rd")
                .roles("ADMINISTRATOR");
    }

    /**
     * Defines how to store CSRF tokens
     * @return  Returns the repository for storing CSRF tokens
     */
    private CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository =  new HttpSessionCsrfTokenRepository();
        repository.setSessionAttributeName("_csrf");

        return repository;
    }
}
