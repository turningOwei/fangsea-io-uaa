package io.fangsea.uaa.domain.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.fangsea.uaa.domain.entity.UserPermissions;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author turningOwei
 */
@Mapper
public interface UserPermissionsMapper extends BaseMapper<UserPermissions> {
    List<UserPermissions> selectByAccessUri(String accessUri);
}
