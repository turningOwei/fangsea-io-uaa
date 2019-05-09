package io.fangsea.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.util.Arrays;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userService;

    @Autowired
    private TokenStore tokenStore;

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        final JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        KeyStoreKeyFactory keyStoreKeyFactory =
                new KeyStoreKeyFactory(new ClassPathResource("mytest.jks"), "mypass".toCharArray());
        converter.setKeyPair(keyStoreKeyFactory.getKeyPair("mytest"));
        converter.setAccessTokenConverter(new CustomerAccessTokenConverter());
        return converter;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                //客户端ID
                .withClient("test")
                //设置验证方式
                .authorizedGrantTypes("password", "refresh_token")
                .scopes("all", "write")
                //.secret("123456")
                .secret("{noop}123456")
                //token过期时间
                //refresh过期时间
                .accessTokenValiditySeconds(10000)
                .refreshTokenValiditySeconds(10000);
        //数据库存储
        //clients.jdbc(dataSource);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        //自定义token
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(customerEnhancer(),accessTokenConverter()));
        endpoints.tokenEnhancer(tokenEnhancerChain);
        endpoints.tokenStore(tokenStore)
                //jwt加密
                //.accessTokenConverter(accessTokenConverter())
                .authenticationManager(authenticationManager)
                //配置userService 这样每次认证的时候会去检验用户是否锁定，有效等
                .userDetailsService(userService);
       // 配置TokenServices参数
       //DefaultTokenServices tokenServices = (DefaultTokenServices) endpoints.getDefaultAuthorizationServerTokenServices();
       //tokenServices.setTokenStore(endpoints.getTokenStore());
       //tokenServices.setSupportRefreshToken(true);
       //tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
       //tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
         //一天
       //tokenServices.setAccessTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(1));
       //endpoints.tokenServices(tokenServices);
    }

    /**
     * 注入自定义token生成方式
     *
     * @return
     */
    @Bean
    public TokenEnhancer customerEnhancer() {
        return new CustomTokenEnhancer();
    }
    @Bean
    public TokenStore tokenStore() {
        //使用内存的tokenStore
        return new InMemoryTokenStore();
        //return new JdbcTokenStore(dataSource);
    }

    /*@Bean
    public ClientDetailsService clientDetails() {
        return new JdbcClientDetailsService(dataSource);
    }*/
}
