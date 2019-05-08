package io.fangsea.uaa.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author turningOwei
 * 角色分配表-只对用户组分配角色
 */
@Data
@TableName("fangsea_user_role_map")
public class UserRoleMap {
    /**
     * 主键编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 角色id
     */

    private Integer roleId;
    /**
     * 用户组id
     */

    private Integer groupId;
    /**
     * 状态，1-绑定，0-解绑
     */

    private Byte status;
    /**
     * 记录更新时间
     */

    private Integer updateTime;
    /**
     * 记录创建时间
     */

    private Integer createTime;

}