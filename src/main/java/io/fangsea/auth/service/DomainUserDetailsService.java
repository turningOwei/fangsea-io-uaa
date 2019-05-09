package io.fangsea.auth.service;

import io.fangsea.uaa.domain.mapper.FangseaUserAccountBindMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wangyunfei
 * @date 2017/6/9
 */
@Slf4j
public class DomainUserDetailsService implements UserDetailsService {
    @Autowired
    private FangseaUserAccountBindMapper fangseaUserAccountBindMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO 这个地方可以通过username从数据库获取正确的用户信息，包括密码和权限等。
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        //fangseaUserAccountBindMapper.selectbyAccount(username);
        /*if(true){
            throw new UsernameNotFoundException("未找到");
        }*/
        return new User(username, "b123456", grantedAuthorityList);
    }
}
