package com.work.logs.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
/**
 * <p>
 * 
 * </p>
 *
 * @author Mr.ZhaoNan
 * @since 2025-04-11
 */
@Getter
@Setter
@ToString
@TableName("work_logs_info")
public class WorkLogsInfo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId
    @TableField("log_id")
    private String logId;

    @TableId
    @TableField("seq")
    private int seq;

    @TableField("log_title")
    private String logTitle;

    @TableField("log_type")
    private String logType;

    @TableField("log_content")
    private String logContent;

    @TableField("update_time")
    private LocalDateTime updateTime;

    @TableField("update_user")
    private String updateUser;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("create_user")
    private String createUser;

    @TableField("status")
    private String status;

    @TableField("delete_flg")
    private Integer deleteFlg;
}
