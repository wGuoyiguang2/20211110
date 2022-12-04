package com.example.demo.entity;

import lombok.*;


import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@AllArgsConstructor
public class Refundset  {

    private static final long serialVersionUID = 1L;

    /**
     * 公司GUID
     */
    private String xBuguid;

    /**
     * 禁止历史数据发起时间截止
     */
    private LocalDateTime xDsiableendtime;

    /**
     * 禁止历史数据发起起始
     */
    private LocalDateTime xDsiablestarttime;

    /**
     * 频率
     */
    private String xFrequency;

    /**
     * 频率设置
     */
    private String xFrequencyset;

    /**
     * 是否启用自动发起退款
     */
    private Integer xIsautorefund;

    /**
     * 是否禁止退款发起
     */
    private Integer xIsdisablestart;

    /**
     * 是否启用先付后审
     */
    private Integer xIsenablexfhs;

    /**
     * 项目GUID
     */
    private String xProjguid;

    /**
     * 发起时间
     */
    private LocalDateTime xSendtime;


    /**
     * 退款设置表主键
     */
    private String refundsetguid;

    /**
     * 版本号
     */
    private Long versionnumber;



}
