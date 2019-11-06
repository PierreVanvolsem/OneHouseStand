package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    DataSource datasource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(datasource)
                .usersByUsernameQuery("select username, password, true as enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, role as authority from users" +
                        " where username=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/aanbod", false)
                .failureUrl("/login-error")
                .and()
                .logout().logoutSuccessUrl("/byebye")
                .and()
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/pand").permitAll()
                .antMatchers("/gvd").permitAll()
                .antMatchers("/aanbod/**").permitAll()
                .antMatchers("/login*").permitAll()
                .antMatchers("/registreer*").permitAll()

                .antMatchers("/api/**").permitAll()
                .antMatchers("/circusapi/**").permitAll()
                .antMatchers("/verimpexapi/**").permitAll()

                .antMatchers("/screener/**").hasAuthority("SCREENER")
                .antMatchers("/klant/**").hasAuthority("KLANT")
                .antMatchers("/syndicus/**").hasAuthority("SYNDICUS")


                .antMatchers("/byebye*").permitAll()
                .antMatchers("/403*").permitAll()

                .antMatchers("/style.css").permitAll()

                .anyRequest().authenticated()
                .and()
                .csrf().disable() //stackoverflow.com/questions/24655203/enable-http-request-post-in-spring-boot
                .exceptionHandling().accessDeniedPage("/403");
    }


    /**
     * The default PasswordEncoder is now DelegatingPasswordEncoder which is a non-passive change.
     * This change ensures that passwords are now encoded using BCrypt by default
     */
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
