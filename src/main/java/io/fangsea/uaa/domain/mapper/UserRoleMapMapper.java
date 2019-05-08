package io.fangsea.uaa.domain.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.fangsea.uaa.domain.entity.UserRoleMap;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author turningOwei
 */
@Mapper
public interface UserRoleMapMapper extends BaseMapper<UserRoleMap> {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRoleMap record);

    int insertSelective(UserRoleMap record);

    UserRoleMap selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRoleMap record);

    int updateByPrimaryKey(UserRoleMap record);
}