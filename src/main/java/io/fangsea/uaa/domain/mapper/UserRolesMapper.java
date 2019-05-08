package io.fangsea.uaa.domain.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.fangsea.uaa.domain.entity.UserRoles;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author turningOwei
 */
@Mapper
public interface UserRolesMapper extends BaseMapper<UserRoles> {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRoles record);

    int insertSelective(UserRoles record);

    UserRoles selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRoles record);

    int updateByPrimaryKey(UserRoles record);
}