package io.fangsea.uaa.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 描述: 局部权限表(资源)
 *
 * @author turningOwei
 * @date 2019/5/8 11:24
 */
@Data
@TableName("fangsea_user_part_permissions")
public class UserPartPermissions {
    /**
     * 权限编号--from权限表
     */
    private Integer id;
    /**
     * 记录更新时间
     */
    private Integer createTime;
}