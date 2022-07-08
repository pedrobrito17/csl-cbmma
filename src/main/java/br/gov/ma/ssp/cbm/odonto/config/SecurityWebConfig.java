package br.gov.ma.ssp.cbm.odonto.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityWebConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DataSource dataSource;

    private static final String bombeiroQuery = "SELECT matricula, senha, ativo FROM bombeiro_militar WHERE matricula=?";

    private static final String rolesQuery = "SELECT u.matricula, r.role FROM bombeiro_militar u "
                                + "INNER JOIN bombeiro_role br ON u.id=br.bombeiro_id "
                                + "INNER JOIN role r ON br.role_id = r.id WHERE u.matricula=?";

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/img/**").permitAll()
                .antMatchers("/public/**").permitAll()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/cadastro").permitAll()

                .antMatchers("/cleanbd").permitAll() /*ATENÇÃO: RETIRAR DEPOIS DE CONCLUÍDO */
                
                .antMatchers("/cadastrar-novo-bombeiro").permitAll()
                .antMatchers("/**").hasAuthority("PACIENTE")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout").permitAll();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .jdbcAuthentication()
            .usersByUsernameQuery(bombeiroQuery)
            .authoritiesByUsernameQuery(rolesQuery)
            .dataSource(dataSource)
            .passwordEncoder(bCryptPasswordEncoder);
    }

    
}