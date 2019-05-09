package io.fangsea.auth.controller;

import io.fangsea.auth.pojo.MyUserDetails;
import io.fangsea.auth.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private TokenStore tokenStore;

    @PostMapping("/bar")
    public String bar(@RequestHeader("Authorization") String auth) {
        MyUserDetails userDetails = (MyUserDetails) tokenStore.readAuthentication(auth.split(" ")[1]).getPrincipal();
        User user = userDetails.getUser();
        return user.getUserName() + ":" + user.getPassword();
    }

    @PostMapping("/test")
    public String test(){
        return "测试test";
    }
}
