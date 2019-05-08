package io.fangsea.uaa.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author turningOwei
 */
@Data
@TableName("fangsea_user_group_map")
public class UserGroupMap {
    /**
     * 主键编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户组id
     */

    private Integer groupId;
    /**
     * 用户id
     */

    private Integer userId;
    /**
     * 状态，1-绑定，0-解绑
     */

    private Byte state;
    /**
     * 记录创建时间
     */

    private Integer updateTime;
    /**
     * 记录创建时间
     */

    private Integer createTime;

}