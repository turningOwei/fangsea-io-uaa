package io.fangsea.uaa.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 描述: 权限表(资源)
 *
 * @author turningOwei
 * @date 2019/5/8 11:24
 */
@Data
@TableName("fangsea_user_permissions")
public class UserPermissions {
    /**
     * 权限编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 权限名
     */

    private String pemName;
    /**
     * 权限描述
     */

    private String pemDesc;
    /**
     * 访问资源
     */

    private String accessUri;
    /**
     * 对资源的操作权限列表，如查询-1，修改-2，添加-3，删除-4，查询+添加-5等
     */
    private Byte actionType;
    /**
     * 状态，1-可用，0-失效
     */

    private Byte state;
    /**
     * 记录更新时间
     */

    private Integer updateTime;
    /**
     * 记录创建时间
     */

    private Integer createTime;

}