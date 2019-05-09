package io.fangsea.auth.pojo;

import org.springframework.security.core.userdetails.User;

import java.util.Collections;


/**
 * 自定义UserDetails类 携带User实例
 */
public class MyUserDetails extends User {

    private io.fangsea.auth.pojo.User user;

    public MyUserDetails(io.fangsea.auth.pojo.User user) {
        super(user.getUserName(), user.getPassword(), true, true, true, true, Collections.EMPTY_SET);
        this.user = user;
    }

    public io.fangsea.auth.pojo.User getUser() {
        return user;
    }

    public void setUser(io.fangsea.auth.pojo.User user) {
        this.user = user;
    }
}
