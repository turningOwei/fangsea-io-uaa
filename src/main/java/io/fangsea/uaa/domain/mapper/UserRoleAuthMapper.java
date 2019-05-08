package io.fangsea.uaa.domain.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.fangsea.uaa.domain.entity.UserRoleAuth;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author turningOwei
 */
@Mapper
public interface UserRoleAuthMapper extends BaseMapper<UserRoleAuth> {
    List<UserRoleAuth> selectByUserId(Integer userId);
}