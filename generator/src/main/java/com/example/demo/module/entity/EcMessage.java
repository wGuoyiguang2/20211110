package com.example.demo.module.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 消息表
 * </p>
 *
 * @author gyg
 * @since 2021-11-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EcMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标题内容
     */
    private String title;

    /**
     * 发送时间（接收到报文的时间）
     */
    private LocalDateTime sendTime;

    /**
     * 预警开始时间
     */
    private LocalDateTime startsAt;

    /**
     * 预警结束时间
     */
    private LocalDateTime endsAt;

    /**
     * 发送者
     */
    private String sender;

    /**
     * 节点IP（普罗米修斯获取当前用户所监控的所有IP）
     */
    private String remoteAddress;

    /**
     * 取自普罗米修斯报文字段 pod
     */
    private String pod;

    /**
     * 分类   0 :工作消息 ;   1 : 系统消息
     */
    private Boolean type;

    /**
     * 创建时间
     */
    private LocalDateTime createAt;

    /**
     * 创建人
     */
    private Long createBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateAt;

    /**
     * 更新人
     */
    private Long updateBy;

    /**
     * 删除   0-未删除  1-已删除
     */
    private Boolean deleted;

    /**
     * 已读状态   0-未读   1-已读
     */
    private Boolean status;

    /**
     * 风险级别(warning ，error)
     */
    private String severity;

    /**
     * 警告类型 (PodMemoryUsage)
     */
    private String alertname;


}
