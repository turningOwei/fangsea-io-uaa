package io.fangsea.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * 描述:
 *
 * @author turningOwei
 * @date 2019-05-09 23:03
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 需要配置这个支持password模式
     * support password grant type
     * @return
     * @throws Exception
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
//    There is no PasswordEncoder mapped for the id "null"
//     solution  configure或者userDetailsService
   // @Override
   // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
   //     auth.inMemoryAuthentication()
   //             .withUser("120135497@qq.com1").password("{noop}120135497@qq.com1").roles("USER")
   //             .and()
   //             .withUser("120135497@qq.com1").password("{noop}120135497@qq.com1").roles("ADMIN");
   // }
 // @Override
 // @Bean
 // public UserDetailsService userDetailsService() {
 //     User.UserBuilder users = User.withDefaultPasswordEncoder();
 //     InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
 //     manager.createUser(users.username("120135497@qq.com1").password("b123456").roles("USER").build());
 //     manager.createUser(users.username("120135497@qq.com1").password("b123456").roles("USER", "ADMIN").build());
 //     User.withUsername("user").password("{noop}user").roles("USER").build();

 //     return manager;
 // }
//    @Configuration
//    public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//
//        @Bean
//        public UserDetailsService userDetailsService() {
//
//            User.UserBuilder users = User.withDefaultPasswordEncoder();
//            InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//            manager.createUser(users.username("user").password("password").roles("USER").build());
//            manager.createUser(users.username("admin").password("password").roles("USER", "ADMIN").build());
//            return manager;
//
//        }
//
//    }
}
