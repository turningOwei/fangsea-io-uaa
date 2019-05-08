package io.fangsea.uaa.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 描述: 用户组
 *
 * @author turningOwei
 * @date 2019/5/8 11:24
 */
@Data
@TableName("fangsea_user_group")
public class UserGroup {
    /**
     * 用户组编号
     */
    @TableId(value = "group_id", type = IdType.AUTO)
    private Integer groupId;
    /**
     * 用户组名称
     */

    private String groupName;
    /**
     * 用户组描述
     */

    private String groupDesc;
    /**
     * 创建者id
     */

    private Integer creatorId;
    /**
     * 分组状态，1-有效，0-无效
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