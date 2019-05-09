package io.fangsea.auth.config;

import io.fangsea.auth.pojo.MyUserDetails;
import io.fangsea.auth.pojo.User;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Primary
@Service("userService")
public class UserServiceImpl implements UserService {

    private final static Set<User> users = new HashSet<>();

    static {
        users.add(new User(1, "test-user1", "123451"));
        users.add(new User(2, "test-user2", "123452"));
        users.add(new User(3, "test-user3", "123453"));
        users.add(new User(4, "120135497@qq.com1", "b123456"));
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //TODO 从数据库中验证登录
        Optional<User> userWrapper = users.stream()
                .filter((u) -> u.getUserName().equals(s))
                .findFirst();
        return userWrapper
                .map(user -> new MyUserDetails(userWrapper.get()))
                .orElseThrow(()->new UsernameNotFoundException("用户" + s + "不存在!"));
    }

    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        System.out.println(a|b);
    }
}
