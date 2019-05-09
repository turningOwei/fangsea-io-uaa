package io.fangsea.uaa.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *  用户绑定信息
 * </p>
 *
 * @author yuanqiang.liu
 * @since 2019-04-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class FangseaUserAccountBind implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 社交账号
     */
    private String account;

    /**
     * 账号种类如手机号
     */
    private String accountType;

    /**
     * 账号描述
     */
    private String accountDesc;

    /**
     * 绑定类型，如用于登录，用于安全验证等
     */
    private String bindType;

    /**
     * 状态如冻结，可用等
     */
    private Integer state;

    /**
     * 记录创建时间
     */
    private Integer createTime;

    /**
     * 创建添加 绑定数据
     * @param userId 用户ID
     * @param account 用户账号
     * @return 绑定数据
     */
    /*public static FangseaUserAccountBind createAdd(int userId, String account) {
        AccountType accountType = UserUtils.getAccountType(account);
        FangseaUserAccountBind  fangseaUserAccountBind = new FangseaUserAccountBind();
        fangseaUserAccountBind.setAccount(account);
        fangseaUserAccountBind.setAccountDesc(accountType.getName());
        fangseaUserAccountBind.setAccountType(accountType.getName());
        fangseaUserAccountBind.setBindType(UserBindType.LOGIN.getType());
        fangseaUserAccountBind.setState(UserStateType.NORMAL.getType());
        fangseaUserAccountBind.setUserId(userId);
        fangseaUserAccountBind.setCreateTime(Integer.valueOf(DateConVertUtil.getPhpStampDate()));
        return fangseaUserAccountBind;
    }*/

    /**
     * 创建 修改 绑定
     * @param account 账号信息
     * @return 绑定数据
     */
    /*public static FangseaUserAccountBind createUpdate(String account) {
        AccountType accountType = UserUtils.getAccountType(account);
        FangseaUserAccountBind  fangseaUserAccountBind = new FangseaUserAccountBind();
        fangseaUserAccountBind.setAccount(account);
        fangseaUserAccountBind.setAccountType(accountType.getName());
        fangseaUserAccountBind.setCreateTime(Integer.valueOf(DateConVertUtil.getPhpStampDate()));

        return fangseaUserAccountBind;
    }*/
}
