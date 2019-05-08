package io.fangsea.uaa.domain.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.fangsea.uaa.domain.entity.UserGroupMap;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author turningOwei
 */
@Mapper
public interface UserGroupMapMapper extends BaseMapper<UserGroupMap> {
    int deleteByPrimaryKey(Integer id);

    int insert(UserGroupMap record);

    int insertSelective(UserGroupMap record);

    UserGroupMap selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserGroupMap record);

    int updateByPrimaryKey(UserGroupMap record);
}