package io.fangsea.auth.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * @author lvhaibao
 * @description 当用户登录成功之后做的处理
 * @date 2019/1/8 0008 10:06
 */
@Component
@Slf4j
public class UaaAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {


    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private AuthorizationServerTokenServices authorizationServerTokenServices;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TokenStore tokenStore;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        log.info("登录成功之后的处理");



        String type = request.getHeader("Accept");
        if(!type.contains("text/html")){

            String clientId = "test";
            String clientSecret = "{noop}123456";

            ClientDetails clientDetails = clientDetailsService.loadClientByClientId(clientId);
            if (null == clientDetails) {
                throw new UnapprovedClientAuthenticationException("clientId不存在" + clientId);
            } else if (!StringUtils.equals(clientDetails.getClientSecret(), clientSecret)) {
                throw new UnapprovedClientAuthenticationException("clientSecret不匹配" + clientId);
            }

            Collection<OAuth2AccessToken> tokens = tokenStore.findTokensByClientId(clientId);
            OAuth2AccessToken token =null;
            if(tokens.isEmpty()){
                TokenRequest tokenRequest = new TokenRequest(MapUtils.EMPTY_MAP, clientId, clientDetails.getScope(), "custom");

                OAuth2Request oAuth2Request = tokenRequest.createOAuth2Request(clientDetails);

                OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(oAuth2Request, authentication);

                token = authorizationServerTokenServices.createAccessToken(oAuth2Authentication);
            }else {
                token = tokens.iterator().next();
            }

            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(token));
        }else {
            super.onAuthenticationSuccess(request, response, authentication);
        }

    }
}
