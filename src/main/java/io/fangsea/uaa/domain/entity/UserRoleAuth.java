package io.fangsea.uaa.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 描述: 角色关联权限表
 * 
 * @author turningOwei
 * @date 2019/5/8 11:26
 */
@Data
@TableName("fangsea_user_role_auth")
public class UserRoleAuth {
    /**
     * 主键编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 权限id
     */

    private Integer pemId;
    /**
     * 角色id
     */

    private Integer roleId;
    /**
     * 备注描述
     */

    private String authDesc;
    /**
     * 状态，1-正常，0-失效
     */

    private Byte status;
    /**
     * 授权人id
     */

    private Integer authorId;
    /**
     * 记录更新时间
     */

    private Integer updateTime;
    /**
     * 记录创建时间
     */

    private Integer createTime;

}