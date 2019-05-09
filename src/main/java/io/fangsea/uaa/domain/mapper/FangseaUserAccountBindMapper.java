package io.fangsea.uaa.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.fangsea.uaa.domain.entity.FangseaUserAccountBind;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户绑定信息 Mapper 接口
 * </p>
 *
 * @author yuanqiang.liu
 * @since 2019-04-11
 */
@Mapper
public interface FangseaUserAccountBindMapper extends BaseMapper<FangseaUserAccountBind> {

}
