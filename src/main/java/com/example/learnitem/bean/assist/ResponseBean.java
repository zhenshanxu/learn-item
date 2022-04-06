package com.example.learnitem.bean.assist;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @BelongsProject: learn-item
 * @BelongsPackage: com.example.learnitem.bean.assist
 * @Author: ZhenShanXu
 * @CreateTime: 2021-11-02 13:47.
 * @Description:
 */
@ApiModel("请求实体")
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ResponseBean {
    /**
     * 请求状态 true：成功 false：失败
     */
    private Boolean success;

    /**
     * 请求结果
     */
    private Object result;

    /**
     * 错误信息
     */
    private String errorMessage;

    /**
     * 额外信息
     */
    private Object extraMessage;
}
