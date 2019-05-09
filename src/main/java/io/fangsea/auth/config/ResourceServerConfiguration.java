package io.fangsea.auth.config;

import io.fangsea.auth.constants.FromLoginConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    @Autowired
    private AuthenticationSuccessHandler uaaAuthenticationSuccessHandler;
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .antMatchers("/webjars/**").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic()
                .and().csrf().disable();

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
                //"/myLogout",
                //"/code/sms")
                "/oauth/**")
                .permitAll().anyRequest().authenticated()
                //禁用跨站伪造
                .and().csrf().disable();
    }
}