package io.fangsea.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:
 *
 * @author turningOwei
 * @date 2019-05-08 17:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccountVo {
    private long userId;

    private String userName;

    private String password;
}
