package io.fangsea.uaa.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 描述: 角色表
 *
 * @author turningOwei
 * @date 2019/5/8 11:29
 */
@Data
@TableName("fangsea_user_roles")
public class UserRoles {
    /**
     * 角色编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 角色名
     */
    private String roleName;
    /**
     * 角色描述
     */
    private String roleDesc;
    /**
     * 记录创建时间
     */
    private Integer createTime;

}