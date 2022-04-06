package com.example.learnitem.bean.assist;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @BelongsProject: learn-item
 * @BelongsPackage: com.example.learnitem.bean
 * @Author: ZhenShanXu
 * @CreateTime: 2021-11-02 13:39.
 * @Description:
 */
@ApiModel("实体协助详情")
@Data
@NoArgsConstructor
public class AssistBean {

    /**
     * 创建者
     */
    private int creator;
    /**
     * 修改者
     */
    private int mender;
    /**
     * 创建时间
     */
    private long createTime;
    /**
     * 修改时间
     */
    private long modifyTime;
    /**
     * 当前页数
     */
    private int page;
    /**
     * 每页数量
     */
    private int pageSize;
    /**
     * 总数
     */
    private int total;

    /**
     * 状态，是否删除 1：正常，-1:删除
     */
    private int isDelete;

}
