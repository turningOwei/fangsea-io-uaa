package io.fangsea.auth.config;

import io.fangsea.auth.constants.FromLoginConstant;
import io.fangsea.auth.handler.UaaAuthenticationSuccessHandler;
import io.fangsea.auth.service.DomainUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 描述:
 *
 * @author turningOwei
 * @date 2019-05-08 21:32
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @SuppressWarnings("deprecation")
    @Autowired
    private AuthenticationSuccessHandler uaaAuthenticationSuccessHandler;
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
    //需要正常运行的话，需要取消这段注释，原因见下面小节
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        //表单登录,loginPage为登录请求的url,loginProcessingUrl为表单登录处理的URL
        /*http.formLogin()
                .loginPage(FromLoginConstant.LOGIN_PAGE)
                .loginProcessingUrl(FromLoginConstant.LOGIN_PROCESSING_URL)
                //登录成功之后的处理
                .successHandler(uaaAuthenticationSuccessHandler)
                .and()
                .authorizeRequests().antMatchers(FromLoginConstant.LOGIN_PROCESSING_URL);
        http
                .requestMatchers()
                .antMatchers("/oauth/**")
                .and()
                .authorizeRequests()
                //,"/user/login"
                .antMatchers("/oauth/**").authenticated();*/
        /*http
                .requestMatchers()
                .antMatchers("/oauth/**")
                .and()
                .authorizeRequests()
                //,"/user/login"
                .antMatchers("/oauth/**").authenticated();*/
        http
                //表单登录,loginPage为登录请求的url,loginProcessingUrl为表单登录处理的URL
                .formLogin().loginPage(FromLoginConstant.LOGIN_PAGE)
                .loginProcessingUrl(FromLoginConstant.LOGIN_PROCESSING_URL)
                //登录成功之后的处理
                .successHandler(uaaAuthenticationSuccessHandler)
                //允许访问
                .and().authorizeRequests().antMatchers(
                FromLoginConstant.LOGIN_PROCESSING_URL,
                FromLoginConstant.LOGIN_PAGE,
                //securityProperties.getOauthLogin().getOauthLogin(),
                //securityProperties.getOauthLogin().getOauthGrant(),
                "/myLogout",
                "/code/sms")
//                "/oauth/**")
                .permitAll().anyRequest().authenticated()
                //禁用跨站伪造
                .and().csrf().disable();
                //短信验证码配置
                //.apply(smsCodeAuthenticationSecurityConfig)
                //社交登录
                //.and().apply(mySocialSecurityConfig)
                //openID登录
                //.and().apply(openIdAuthenticationConfig);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }
    //配置内存模式的用户
    @Bean
    @Override
    protected UserDetailsService userDetailsService(){
        /*InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin").password("123456").authorities("USER").build());
        manager.createUser(User.withUsername("120135497@qq.com").password("b123456").authorities("USER").build());
        return manager;*/
        return new DomainUserDetailsService();
    }

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

}
