package io.fangsea.auth.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述: 自定义token生成携带的信息
 *
 * @author turningOwei
 * @date 2019-05-06 15:46
 */
public class CustomTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        final Map<String, Object> additionalInfo = new HashMap<>(16);
        //获取登录信息
        UserDetails user = (UserDetails) oAuth2Authentication.getUserAuthentication().getPrincipal();
        additionalInfo.put("userName", user.getUsername());
        additionalInfo.put("authorities", user.getAuthorities());
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(additionalInfo);
        //TODO
        //userName作为key放入redis,value为基本信息(ip,登录的客户端--浏览器,app)
        //RedisUtil.save2Redis();
        return oAuth2AccessToken;
    }
}
