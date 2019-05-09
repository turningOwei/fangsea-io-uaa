package io.fangsea.auth.model;

import org.springframework.security.core.userdetails.User;

import java.util.Collections;


/**
 * 自定义UserDetails类 携带User实例
 */
public class UaaUserDetails extends User {

    private UserAccountVo user;

    public UaaUserDetails(UserAccountVo user) {
        super(user.getUserName(), user.getPassword(), true, true, true, true, Collections.EMPTY_SET);
        this.user = user;
    }

    public UserAccountVo getUser() {
        return user;
    }

    public void setUser(UserAccountVo user) {
        this.user = user;
    }
}
