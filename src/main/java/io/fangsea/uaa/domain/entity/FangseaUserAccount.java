package io.fangsea.uaa.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author yuanqiang.liu
 * @since 2019-04-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class FangseaUserAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 按规则生成的会员编号
     */
    private String userCode;

    /**
     * 账号名
     */
    private String userName;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 注册时间
     */
    private Integer registerTime;

    /**
     * 状态，0-正常，1-冻结
     */
    private Integer state;

    /**
     *  图片数字验证码
     */
    private String validataCode;
    /**
     * 社交账号（手机或邮箱）
     */
    private String account;

}