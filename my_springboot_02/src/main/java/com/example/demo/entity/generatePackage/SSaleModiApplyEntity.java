package com.example.demo.entity.generatePackage;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Created by Mybatis Generator on 2021/03/21
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SSaleModiApplyEntity implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 新销售单GUID
     */
    private String saleGUID;

    /**
     * 申请日期
     */
    private Date applyDate;

    /**
     * 手续费
     */
    private BigDecimal handCharge;

    /**
     * 已交金额
     */
    private BigDecimal getAmount;

    /**
     * 项目Guid
     */
    private String projGUID;

    /**
     * 退款金额
     */
    private BigDecimal refundment;

    /**
     * 批准日期
     */
    private Date auditDate;

    /**
     * 执行日期
     */
    private Date execDate;

    /**
     * 房间Guid
     */
    private String roomGUID;

    /**
     * 作废日期
     */
    private Date zfDate;

    /**
     * 销售变更申请主键
     */
    private String saleModiApplyGUID;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 创建人
     */
    private String createdGUID;

    /**
     * 修改时间
     */
    private Date modifiedTime;

    /**
     * 修改人
     */
    private String modifiedGUID;

    /**
     * 作废人GUID
     */
    private String zfrGUID;

    /**
     * 申请类型
     */
    private Integer applyTypeEnum;

    /**
     * 申请人
     */
    private String applyGUID;

    /**
     * 批准人
     */
    private String auditGUID;

    /**
     * 执行人
     */
    private String execGUID;

    /**
     * 是否同意
     */
    private Integer isApproved;

    /**
     * 销售单类型
     */
    private Integer saleTypeEnum;

    /**
     * 审批状态
     */
    private Integer auditStatusEnum;

    /**
     * 申请单状态
     */
    private Integer applyStatusEnum;

    /**
     * 交易Id
     */
    private String tradeGUID;

    /**
     * 创建人名称
     */
    private String createdName;

    /**
     * 修改人名称
     */
    private String modifiedName;

    /**
     * 公司GUID
     */
    private String BUGUID;

    /**
     * 申请人
     */
    private String applyName;

    /**
     * 申请状态
     */
    private String applyStatus;

    /**
     * 执行人
     */
    private String execName;

    /**
     * 销售类型
     */
    private String saleType;

    /**
     * 作废人
     */
    private String zfr;

    /**
     * 审核状态
     */
    private String auditStatus;

    /**
     * 申请单类型
     */
    private String applyType;

    /**
     * 是否特殊审批
     */
    private Integer isSpecialApproval;

    /**
     * 审核人名称
     */
    private String auditName;

    /**
     * 附属房产信息
     */
    private String attachRoomInfo;

    /**
     * 建筑面积
     */
    private BigDecimal bldArea;

    /**
     * 套内面积
     */
    private BigDecimal tnArea;

    /**
     * 协议总价
     */
    private BigDecimal cjRmbTotal;

    /**
     * 建筑单价
     */
    private BigDecimal cjBldPrice;

    /**
     * 付款方式
     */
    private String payFormName;

    /**
     * 新销售单GUID
     */
    private String newSaleGUID;

    /**
     * 房间名称
     */
    private String roomInfo;

    /**
     * 买方
     */
    private String buyer;

    /**
     * 折扣值
     */
    private BigDecimal discntValue;

    /**
     * 启用销售变更审核
     */
    private String enableSaleModiAudit;

    /**
     * 付款方式GUID
     */
    private String payFormGUID;

    /**
     * 签署日期
     */
    private Date QSDate;

    /**
     * 成交套内单价
     */
    private BigDecimal cjTnPrice;

    /**
     * 房间标准总价
     */
    private BigDecimal roomTotal;

    /**
     * 房间建筑单价
     */
    private BigDecimal roomBldPrice;

    /**
     * 房间套内单价
     */
    private BigDecimal roomTnPrice;

    /**
     * 计价模式
     */
    private Integer calModeEnum;

    /**
     * 计价方式
     */
    private String calMode;

    /**
     * 房间总价
     */
    private BigDecimal cjRoomTotal;

    /**
     * 已收按揭资料
     */
    private String xAjFileCounts;

    /**
     * 按揭金额
     */
    private BigDecimal xAjTotal;

    /**
     * 按揭年限
     */
    private Integer xAjYear;

    /**
     * 退款金额
     */
    private BigDecimal xCheckOutAmout;

    /**
     * 违约金
     */
    private BigDecimal xDefaultingAmount;

    /**
     * 实收违约金
     */
    private BigDecimal xDefaultingAmountSS;

    /**
     * 应收违约金
     */
    private BigDecimal xDefaultingAmountYS;

    /**
     * 房间底价建筑单价
     */
    private BigDecimal xDjBldPrice;

    /**
     * 房间底价套内单价
     */
    private BigDecimal xDjTnPrice;

    /**
     * 房间底价总价
     */
    private BigDecimal xDjTotal;

    /**
     * 公积金金额
     */
    private BigDecimal xGjjTotal;

    /**
     * 公积金年限
     */
    private Integer xGjjYear;

    /**
     * POS机手续费
     */
    private BigDecimal xHandChargePOS;

    /**
     * 是否齐件
     */
    private String xIsQjState;

    /**
     * 是否重新定价
     */
    private Integer xIsRePriced;

    /**
     * 是否签订换房申请表
     */
    private Integer xIsSignChangeRoomApply;

    /**
     * 是否签订退房手续申请表
     */
    private Integer xIsSignCheckOutApply;

    /**
     * 网签日期
     */
    private Date xNetContractDate;

    /**
     * 付款方式类型
     */
    private String xPayFormType;

    /**
     * 付款方式类型枚举
     */
    private Integer xPayFormTypeEnum;

    /**
     * 产品类型名称
     */
    private String xProductTypeName;

    /**
     * 网址
     */
    private String xURL;

    /**
     * 置业顾问
     */
    private String xZygw;

    /**
     * 工作联系单链接
     */
    private String xUrlOA;

    /**
     * 装修合同付款方式类型
     */
    private String xDecorationPayFormType;

    /**
     * 装修合同付款方式类型枚举
     */
    private Integer xDecorationPayFormTypeEnum;

    /**
     * 装修合同付款方式
     */
    private String xDecorationPayForm;

    /**
     * 装修合同付款方式GUID
     */
    private String xDecorationPayFormGUID;

    /**
     * 退房预计销售价格（表总价）
     */
    private BigDecimal xModiExpectedPrice;

    /**
     */
    private BigDecimal xAjRateZX;

    /**
     * 按揭金额(装修合同)
     */
    private BigDecimal xAjTotalZX;

    /**
     * 按揭年限(装修合同)
     */
    private Integer xAjYearZX;

    /**
     * 按揭银行经办人
     */
    private String xBankAjJbr;

    /**
     * 按揭银行经办人(装修合同)
     */
    private String xBankAjJbrZX;

    /**
     * 装修合同金额
     */
    private BigDecimal xDecorationTotal;

    /**
     */
    private BigDecimal xGjjRateZX;

    /**
     * 公积金金额(装修合同)
     */
    private BigDecimal xGjjTotalZX;

    /**
     * 公积金年限(装修合同)
     */
    private Integer xGjjYearZX;

    /**
     * 主合同金额
     */
    private BigDecimal xMainContractTotal;

    /**
     * 组合变更是否包含权益人变更
     */
    private Integer xApplyTypeBuyer;

    /**
     * 组合变更是否包含付款方式变更
     */
    private Integer xApplyTypePayform;

    /**
     * 原因分类(组合变更_付款方式)
     */
    private String xReasonTypePayform;

    /**
     * 原因分类(组合变更_权益人)
     */
    private String xx_ReasonTypeBuyer;

    /**
     * 已交房款
     */
    private BigDecimal xGetHouseAmount;

    /**
     * 已交税费
     */
    private BigDecimal xGetTaxAmount;

    /**
     * 可退税费
     */
    private BigDecimal xReturnTaxAmount;

    /**
     * 可退房款
     */
    private BigDecimal xReturnHouseAmount;

    /**
     * 预计销售价格(表总价)
     */
    private BigDecimal xPreSalePrice;

    /**
     */
    private Integer xIsDGDC;

    /**
     * 是否测试数据
     */
    private Integer is_testdata;

    /**
     * 是否删除
     */
    private Integer is_deleted;

    /**
     * 版本号
     */
    private Long versionNumber;

    /**
     * 原因说明
     */
    private String reason;

    /**
     * 审批意见
     */
    private String opinion;

    /**
     * 作废原因
     */
    private String zfReason;

    /**
     * 附件
     */
    private String attachFiles;

    /**
     * 原因分类
     */
    private String reasonType;

    /**
     * 折扣说明
     */
    private String discntRemark;

    /**
     * 变更说明
     */
    private String modiRemark;

    /**
     * 减免原因
     */
    private String xDerateReason;

    /**
     * 新附件
     */
    private String xNewAttachFiles;

    /**
     * 自定义资料（已收取）
     */
    private String xSelfdefinedZl;

    /**
     * 自定义资料（未收取）
     */
    private String xSelfdefinedZlWsq;

    /**
     * 变更说明(组合变更_权益人)
     */
    private String xModiRemarkBuyer;

    /**
     * 变更说明(组合变更_付款方式)
     */
    private String xModiRemarkPayform;

    /**
     * 违约金说明
     */
    private String xDefaultingRemark;

    /**
     * 退款金额说明
     */
    private String xRetunRemark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table s_salemodiapply
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", saleGUID=").append(saleGUID);
        sb.append(", applyDate=").append(applyDate);
        sb.append(", handCharge=").append(handCharge);
        sb.append(", getAmount=").append(getAmount);
        sb.append(", projGUID=").append(projGUID);
        sb.append(", refundment=").append(refundment);
        sb.append(", auditDate=").append(auditDate);
        sb.append(", execDate=").append(execDate);
        sb.append(", roomGUID=").append(roomGUID);
        sb.append(", zfDate=").append(zfDate);
        sb.append(", saleModiApplyGUID=").append(saleModiApplyGUID);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", createdGUID=").append(createdGUID);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", modifiedGUID=").append(modifiedGUID);
        sb.append(", zfrGUID=").append(zfrGUID);
        sb.append(", applyTypeEnum=").append(applyTypeEnum);
        sb.append(", applyGUID=").append(applyGUID);
        sb.append(", auditGUID=").append(auditGUID);
        sb.append(", execGUID=").append(execGUID);
        sb.append(", isApproved=").append(isApproved);
        sb.append(", saleTypeEnum=").append(saleTypeEnum);
        sb.append(", auditStatusEnum=").append(auditStatusEnum);
        sb.append(", applyStatusEnum=").append(applyStatusEnum);
        sb.append(", tradeGUID=").append(tradeGUID);
        sb.append(", createdName=").append(createdName);
        sb.append(", modifiedName=").append(modifiedName);
        sb.append(", BUGUID=").append(BUGUID);
        sb.append(", applyName=").append(applyName);
        sb.append(", applyStatus=").append(applyStatus);
        sb.append(", execName=").append(execName);
        sb.append(", saleType=").append(saleType);
        sb.append(", zfr=").append(zfr);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", applyType=").append(applyType);
        sb.append(", isSpecialApproval=").append(isSpecialApproval);
        sb.append(", auditName=").append(auditName);
        sb.append(", attachRoomInfo=").append(attachRoomInfo);
        sb.append(", bldArea=").append(bldArea);
        sb.append(", tnArea=").append(tnArea);
        sb.append(", cjRmbTotal=").append(cjRmbTotal);
        sb.append(", cjBldPrice=").append(cjBldPrice);
        sb.append(", payFormName=").append(payFormName);
        sb.append(", newSaleGUID=").append(newSaleGUID);
        sb.append(", roomInfo=").append(roomInfo);
        sb.append(", buyer=").append(buyer);
        sb.append(", discntValue=").append(discntValue);
        sb.append(", enableSaleModiAudit=").append(enableSaleModiAudit);
        sb.append(", payFormGUID=").append(payFormGUID);
        sb.append(", QSDate=").append(QSDate);
        sb.append(", cjTnPrice=").append(cjTnPrice);
        sb.append(", roomTotal=").append(roomTotal);
        sb.append(", roomBldPrice=").append(roomBldPrice);
        sb.append(", roomTnPrice=").append(roomTnPrice);
        sb.append(", calModeEnum=").append(calModeEnum);
        sb.append(", calMode=").append(calMode);
        sb.append(", cjRoomTotal=").append(cjRoomTotal);
        sb.append(", xAjFileCounts=").append(xAjFileCounts);
        sb.append(", xAjTotal=").append(xAjTotal);
        sb.append(", xAjYear=").append(xAjYear);
        sb.append(", xCheckOutAmout=").append(xCheckOutAmout);
        sb.append(", xDefaultingAmount=").append(xDefaultingAmount);
        sb.append(", xDefaultingAmountSS=").append(xDefaultingAmountSS);
        sb.append(", xDefaultingAmountYS=").append(xDefaultingAmountYS);
        sb.append(", xDjBldPrice=").append(xDjBldPrice);
        sb.append(", xDjTnPrice=").append(xDjTnPrice);
        sb.append(", xDjTotal=").append(xDjTotal);
        sb.append(", xGjjTotal=").append(xGjjTotal);
        sb.append(", xGjjYear=").append(xGjjYear);
        sb.append(", xHandChargePOS=").append(xHandChargePOS);
        sb.append(", xIsQjState=").append(xIsQjState);
        sb.append(", xIsRePriced=").append(xIsRePriced);
        sb.append(", xIsSignChangeRoomApply=").append(xIsSignChangeRoomApply);
        sb.append(", xIsSignCheckOutApply=").append(xIsSignCheckOutApply);
        sb.append(", xNetContractDate=").append(xNetContractDate);
        sb.append(", xPayFormType=").append(xPayFormType);
        sb.append(", xPayFormTypeEnum=").append(xPayFormTypeEnum);
        sb.append(", xProductTypeName=").append(xProductTypeName);
        sb.append(", xURL=").append(xURL);
        sb.append(", xZygw=").append(xZygw);
        sb.append(", xUrlOA=").append(xUrlOA);
        sb.append(", xDecorationPayFormType=").append(xDecorationPayFormType);
        sb.append(", xDecorationPayFormTypeEnum=").append(xDecorationPayFormTypeEnum);
        sb.append(", xDecorationPayForm=").append(xDecorationPayForm);
        sb.append(", xDecorationPayFormGUID=").append(xDecorationPayFormGUID);
        sb.append(", xModiExpectedPrice=").append(xModiExpectedPrice);
        sb.append(", xAjRateZX=").append(xAjRateZX);
        sb.append(", xAjTotalZX=").append(xAjTotalZX);
        sb.append(", xAjYearZX=").append(xAjYearZX);
        sb.append(", xBankAjJbr=").append(xBankAjJbr);
        sb.append(", xBankAjJbrZX=").append(xBankAjJbrZX);
        sb.append(", xDecorationTotal=").append(xDecorationTotal);
        sb.append(", xGjjRateZX=").append(xGjjRateZX);
        sb.append(", xGjjTotalZX=").append(xGjjTotalZX);
        sb.append(", xGjjYearZX=").append(xGjjYearZX);
        sb.append(", xMainContractTotal=").append(xMainContractTotal);
        sb.append(", xApplyTypeBuyer=").append(xApplyTypeBuyer);
        sb.append(", xApplyTypePayform=").append(xApplyTypePayform);
        sb.append(", xReasonTypePayform=").append(xReasonTypePayform);
        sb.append(", xx_ReasonTypeBuyer=").append(xx_ReasonTypeBuyer);
        sb.append(", xGetHouseAmount=").append(xGetHouseAmount);
        sb.append(", xGetTaxAmount=").append(xGetTaxAmount);
        sb.append(", xReturnTaxAmount=").append(xReturnTaxAmount);
        sb.append(", xReturnHouseAmount=").append(xReturnHouseAmount);
        sb.append(", xPreSalePrice=").append(xPreSalePrice);
        sb.append(", xIsDGDC=").append(xIsDGDC);
        sb.append(", is_testdata=").append(is_testdata);
        sb.append(", is_deleted=").append(is_deleted);
        sb.append(", versionNumber=").append(versionNumber);
        sb.append(", reason=").append(reason);
        sb.append(", opinion=").append(opinion);
        sb.append(", zfReason=").append(zfReason);
        sb.append(", attachFiles=").append(attachFiles);
        sb.append(", reasonType=").append(reasonType);
        sb.append(", discntRemark=").append(discntRemark);
        sb.append(", modiRemark=").append(modiRemark);
        sb.append(", xDerateReason=").append(xDerateReason);
        sb.append(", xNewAttachFiles=").append(xNewAttachFiles);
        sb.append(", xSelfdefinedZl=").append(xSelfdefinedZl);
        sb.append(", xSelfdefinedZlWsq=").append(xSelfdefinedZlWsq);
        sb.append(", xModiRemarkBuyer=").append(xModiRemarkBuyer);
        sb.append(", xModiRemarkPayform=").append(xModiRemarkPayform);
        sb.append(", xDefaultingRemark=").append(xDefaultingRemark);
        sb.append(", xRetunRemark=").append(xRetunRemark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}