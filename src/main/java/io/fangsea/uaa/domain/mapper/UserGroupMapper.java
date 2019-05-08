package io.fangsea.uaa.domain.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.fangsea.uaa.domain.entity.UserGroup;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author turningOwei
 */
@Mapper
public interface UserGroupMapper extends BaseMapper<UserGroup> {
    int deleteByPrimaryKey(Integer groupId);

    int insert(UserGroup record);

    int insertSelective(UserGroup record);

    UserGroup selectByPrimaryKey(Integer groupId);

    int updateByPrimaryKeySelective(UserGroup record);

    int updateByPrimaryKey(UserGroup record);
}