package io.fangsea.uaa.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.fangsea.uaa.domain.entity.FangseaUserAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * <p>
 *  用户信息Mapper 接口
 * </p>
 *
 * @author yuanqiang.liu
 * @since 2019-04-11
 */
@Mapper
public interface FangseaUserAccountMapper extends BaseMapper<FangseaUserAccount> {

    @Override
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int insert(FangseaUserAccount entity);
}
