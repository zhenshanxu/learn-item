package com.example.learnitem.bean.userInfo;

import com.example.learnitem.bean.assist.AssistBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @BelongsProject: learn-item
 * @BelongsPackage: com.example.learnitem.bean
 * @Author: ZhenShanXu
 * @CreateTime: 2021-11-02 10:35.
 * @Description: 用户详情
 */
@ApiModel("用户详情")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserInfoBean extends AssistBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private int id;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String name;

    /**
     * 邮件
     */
    @ApiModelProperty("邮件")
    private String email;

    /**
     * 联系方式
     */
    @ApiModelProperty("联系方式")
    private String phone;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;

}
