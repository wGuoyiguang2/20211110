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
public class SOrderDto implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 认购主键
     */
    private String orderGUID;

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
     * 协议编号
     */
    private String agreementNo;

    /**
     * 流程审批GUID
     */
    private String auditGUID;

    /**
     * 计价方式值
     */
    private Integer calModeEnum;

    /**
     * 建筑面积
     */
    private BigDecimal bldArea;

    /**
     * 审核日期
     */
    private Date auditDate;

    /**
     * 关闭日期
     */
    private Date closeDate;

    /**
     * 审核状态值
     */
    private Integer auditStatusEnum;

    /**
     * 建筑单价
     */
    private BigDecimal cjBldPrice;

    /**
     * 装修总价
     */
    private BigDecimal zxTotal;

    /**
     * 首次购房
     */
    private Integer isST;

    /**
     * 按揭银行
     */
    private String ajBank;

    /**
     * 装修并入总价
     */
    private Integer isZxkbrht;

    /**
     * 公积金金额
     */
    private BigDecimal gjjTotal;

    /**
     * 按揭金额
     */
    private BigDecimal ajTotal;

    /**
     * 折扣
     */
    private BigDecimal discntValue;

    /**
     * 公积金银行
     */
    private String gjjBank;

    /**
     * 认购日期
     */
    private Date QSDate;

    /**
     * 协议总价
     */
    private BigDecimal cjRmbTotal;

    /**
     * 房间总价
     */
    private BigDecimal cjRoomTotal;

    /**
     * 房间Id
     */
    private String roomGUID;

    /**
     * 附属总价
     */
    private BigDecimal fsTotal;

    /**
     * 房间标准建筑单价
     */
    private BigDecimal roomBldPrice;

    /**
     * 状态值
     */
    private Integer statusEnum;

    /**
     * 套内单价
     */
    private BigDecimal cjTnPrice;

    /**
     * 应签约日期
     */
    private Date yqyDate;

    /**
     * 房间底价建筑单价
     */
    private BigDecimal djBldPrice;

    /**
     * 项目Id
     */
    private String projGUID;

    /**
     * 房间标准套内单价
     */
    private BigDecimal roomTnPrice;

    /**
     * 房间标准总价
     */
    private BigDecimal roomTotal;

    /**
     * 套内面积
     */
    private BigDecimal tnArea;

    /**
     * 交易Id
     */
    private String tradeGUID;

    /**
     * 房间底价总价
     */
    private BigDecimal djTotal;

    /**
     * 房间底价套内单价
     */
    private BigDecimal djTnPrice;

    /**
     * 应交定金
     */
    private BigDecimal earnest;

    /**
     * 前次销售单GUID
     */
    private String lastSaleGUID;

    /**
     * 前次销售单类型
     */
    private String lastSaleType;

    /**
     * 付款方式GUID
     */
    private String payFormGUID;

    /**
     * 业务归属日期
     */
    private Date ywgsDate;

    /**
     * 锁定应收款
     */
    private Integer isLockFee;

    /**
     * 标准基准价
     */
    private BigDecimal baseRoomTotal;

    /**
     * 协议基准价
     */
    private BigDecimal baseCjTotal;

    /**
     * 补充协议基准价
     */
    private BigDecimal bcBaseTotal;

    /**
     * 是否价格变更锁定折扣
     */
    private Integer isLockDisount;

    /**
     * 经办人GUID
     */
    private String jbrGUID;

    /**
     * 置业顾问
     */
    private String zygw;

    /**
     * 单据条码
     */
    private String orderBarcode;

    /**
     * 关闭原因
     */
    private String closeReason;

    /**
     * 订单类型值
     */
    private Integer orderTypeEnum;

    /**
     * 面积状态值
     */
    private Integer areaStatusEnum;

    /**
     * 装修标准
     */
    private String zxBz;

    /**
     * 装修单价
     */
    private BigDecimal zxPrice;

    /**
     * 公积金年限
     */
    private Integer gjjYear;

    /**
     * 按揭年限
     */
    private Integer ajYear;

    /**
     * 基准建筑单价
     */
    private BigDecimal baseRoomBldPrice;

    /**
     * 成交基准建筑单价
     */
    private BigDecimal baseCjBldPrice;

    /**
     * 成交基准套内单价
     */
    private BigDecimal baseCjTnPrice;

    /**
     * 状态
     */
    private String status;

    /**
     * 公司id
     */
    private String BUGUID;

    /**
     * 审核人姓名
     */
    private String auditName;

    /**
     * 前次销售单类型值
     */
    private Integer lastSaleTypeEnum;

    /**
     * 计价方式
     */
    private String calMode;

    /**
     * 订单类型
     */
    private String orderType;

    /**
     * 面积状态
     */
    private String areaStatus;

    /**
     * 付款方式
     */
    private String payFormName;

    /**
     * 经办人
     */
    private String jbrName;

    /**
     * 创建人名称
     */
    private String createdName;

    /**
     * 修改人名称
     */
    private String modifiedName;

    /**
     * 审核状态
     */
    private String auditStatus;

    /**
     * 基准套内单价
     */
    private BigDecimal baseRoomTnPrice;

    /**
     * 关闭原因枚举
     */
    private Integer closeReasonEnum;

    /**
     * 交易线唯一码
     */
    private String idCode;

    /**
     * 备案总价
     */
    private BigDecimal baTotal;

    /**
     * 备案建筑单价
     */
    private BigDecimal baBldPrice;

    /**
     * 备案套内单价
     */
    private BigDecimal baTnPrice;

    /**
     * 税率
     */
    private BigDecimal rate;

    /**
     * 税金
     */
    private BigDecimal taxAmount;

    /**
     * 推荐人GUID
     */
    private String tjrAllGUID;

    /**
     * 推荐人姓名
     */
    private String tjrAllName;

    /**
     * 置业顾问GUID
     */
    private String zygwAllGUID;

    /**
     * 客户证件号码
     */
    private String cstAllCardID;

    /**
     * 客户名称
     */
    private String cstAllName;

    /**
     * 在线开盘活动ID
     */
    private Integer xActivityID;

    /**
     * 按揭比例
     */
    private BigDecimal xAjRate;

    /**
     * 选房号
     */
    private String xchooseRoomcode;

    /**
     * 装修款付款方式
     */
    private String xDecorationPayFormType;

    /**
     * 装修付款方式GUID
     */
    private String xDecorationPayFormTypeGuid;

    /**
     * 装修总价
     */
    private BigDecimal xDecorationTotal;

    /**
     * 电商抵扣金额(万元)
     */
    private BigDecimal xEcommerceD;

    /**
     * 电商POS流水单单号
     */
    private String xEcommercePosID;

    /**
     * 电商折扣金额(万元)
     */
    private BigDecimal xEcommerceZk;

    /**
     * 失效日期
     */
    private Date xEndDate;

    /**
     * 公积金比例
     */
    private BigDecimal xGjjRate;

    /**
     * 是否是在线开盘订单
     */
    private Integer xifzxkp;

    /**
     * 是否齐件
     */
    private String xIsQjState;

    /**
     * 是否搭售车位
     */
    private Integer xIsSaleParking;

    /**
     * 是否发送签约前一日短信
     */
    private Integer xIsSendQyqOneDaySms;

    /**
     * 是否发送认购当天短信
     */
    private Integer xIsSendRgdtSms;

    /**
     * 是否发送认购后两日短信
     */
    private Integer xIsSendRghTwoDaySms;

    /**
     * 是否员工或家属购房
     */
    private Integer xIsStaff;

    /**
     * 是否使用电商
     */
    private Integer xIsUseEcommerce;

    /**
     * 一房一议
     */
    private Integer xIsYfYy;

    /**
     * 主合同付款方式
     */
    private String xMainContractPayFormType;

    /**
     * 主合同单价
     */
    private BigDecimal xMainContractPrice;

    /**
     * 主合同总价
     */
    private BigDecimal xMainContractTotal;

    /**
     * 总经理折扣幅度
     */
    private BigDecimal xManagerDiscount;

    /**
     * 总经理折后优惠金额
     */
    private BigDecimal xManagerDiscountAmount;

    /**
     * 总经理折扣计算方式(1打折;2总价优惠;其它值表示未生效)
     */
    private Integer xManagerDiscountType;

    /**
     * 折扣值（含总经理折扣）
     */
    private BigDecimal xManagerDiscounzValue;

    /**
     * 主定单GUID（用于车位搭售）
     */
    private String xMasterSaleGUID;

    /**
     * 订单编号
     */
    private String xorderCode;

    /**
     * CRM接口id
     */
    private Integer xOrderID;

    /**
     * 1:线下未付款 2：线下已收钱3：订单作废（默认为1）
     */
    private Integer xorderStatus;

    /**
     * 搭售车位金额
     */
    private BigDecimal xParkingAmount;

    /**
     * 搭售车位总额
     */
    private BigDecimal xParkingTotal;

    /**
     * 付款方式类型
     */
    private String xPayFormType;

    /**
     * 付款方式类型枚举
     */
    private Integer xPayFormTypeEnum;

    /**
     * 房间结构
     */
    private String xRoomStru;

    /**
     * 员工姓名
     */
    private String xStaffName;

    /**
     * 是否作业触发的关闭
     */
    private Integer xIsJobClosed;

    /**
     * 业务变更执行日期
     */
    private Date xChgDate;

    /**
     * 推荐人房号
     */
    private String xTjrRoomInfo;

    /**
     * 推荐人证件类型
     */
    private String xTjrCardType;

    /**
     * 推荐人证件号码
     */
    private String xTjrCardID;

    /**
     * 推荐人联系电话
     */
    private String xTjrTel;

    /**
     * 推荐人备选电话
     */
    private String xTjrAlternativePhone;

    /**
     * 主房间销售单
     */
    private String xMainRoomSaleGUID;

    /**
     * 按揭银行(装修合同)
     */
    private String xAjBankZX;

    /**
     * 按揭比例(装修合同)
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
     * 公积金银行(装修合同)
     */
    private String xGjjBankZX;

    /**
     * 公积金比例(装修合同)
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
     * 共有方式
     */
    private Integer xShareOut;

    /**
     * 共有方式文本
     */
    private String xShareOutText;

    /**
     * 是否老业主购买车位
     */
    private Integer xIsOldOwner;

    /**
     * 是否二手业主购买车位
     */
    private Integer xIsSecondOwner;

    /**
     * 老业主合同GUID
     */
    private String xMainContractGUID;

    /**
     * 老业主主房间
     */
    private String xMainRoom;

    /**
     * 二手业主合同GUID
     */
    private String xSeMainContractGUID;

    /**
     * 主房间
     */
    private String xSendMainRoom;

    /**
     * 97折购房神券（核销码）
     */
    private String xRoomHxCode;

    /**
     * 客户备用手机号
     */
    private String xCstAllAlternativePhone;

    /**
     * 所有客户手机号
     */
    private String xCstAllTel;

    /**
     * 是否启用双合同状态
     */
    private Integer xDoubleContractStatus;

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
     * 折扣说明
     */
    private String remark;

    /**
     * 折扣说明
     */
    private String discntRemark;

    /**
     * 相关附件
     */
    private String addition;

    /**
     * 已收按揭资料
     */
    private String xAjCodeList;

    /**
     * 已收按揭资料
     */
    private String xAjFileCounts;

    /**
     * 自定义资料（已收取）
     */
    private String xSelfdefinedZl;

    /**
     * 自定义资料（未收取）
     */
    private String xSelfdefinedZlWsq;

    /**
     * 流程审批GUID
     */
    private String xProcessAuditGUIDs;

    /**
     * 流程审批名称
     */
    private String xProcessAuditNames;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table s_order
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
        sb.append(", orderGUID=").append(orderGUID);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", createdGUID=").append(createdGUID);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", modifiedGUID=").append(modifiedGUID);
        sb.append(", agreementNo=").append(agreementNo);
        sb.append(", auditGUID=").append(auditGUID);
        sb.append(", calModeEnum=").append(calModeEnum);
        sb.append(", bldArea=").append(bldArea);
        sb.append(", auditDate=").append(auditDate);
        sb.append(", closeDate=").append(closeDate);
        sb.append(", auditStatusEnum=").append(auditStatusEnum);
        sb.append(", cjBldPrice=").append(cjBldPrice);
        sb.append(", zxTotal=").append(zxTotal);
        sb.append(", isST=").append(isST);
        sb.append(", ajBank=").append(ajBank);
        sb.append(", isZxkbrht=").append(isZxkbrht);
        sb.append(", gjjTotal=").append(gjjTotal);
        sb.append(", ajTotal=").append(ajTotal);
        sb.append(", discntValue=").append(discntValue);
        sb.append(", gjjBank=").append(gjjBank);
        sb.append(", QSDate=").append(QSDate);
        sb.append(", cjRmbTotal=").append(cjRmbTotal);
        sb.append(", cjRoomTotal=").append(cjRoomTotal);
        sb.append(", roomGUID=").append(roomGUID);
        sb.append(", fsTotal=").append(fsTotal);
        sb.append(", roomBldPrice=").append(roomBldPrice);
        sb.append(", statusEnum=").append(statusEnum);
        sb.append(", cjTnPrice=").append(cjTnPrice);
        sb.append(", yqyDate=").append(yqyDate);
        sb.append(", djBldPrice=").append(djBldPrice);
        sb.append(", projGUID=").append(projGUID);
        sb.append(", roomTnPrice=").append(roomTnPrice);
        sb.append(", roomTotal=").append(roomTotal);
        sb.append(", tnArea=").append(tnArea);
        sb.append(", tradeGUID=").append(tradeGUID);
        sb.append(", djTotal=").append(djTotal);
        sb.append(", djTnPrice=").append(djTnPrice);
        sb.append(", earnest=").append(earnest);
        sb.append(", lastSaleGUID=").append(lastSaleGUID);
        sb.append(", lastSaleType=").append(lastSaleType);
        sb.append(", payFormGUID=").append(payFormGUID);
        sb.append(", ywgsDate=").append(ywgsDate);
        sb.append(", isLockFee=").append(isLockFee);
        sb.append(", baseRoomTotal=").append(baseRoomTotal);
        sb.append(", baseCjTotal=").append(baseCjTotal);
        sb.append(", bcBaseTotal=").append(bcBaseTotal);
        sb.append(", isLockDisount=").append(isLockDisount);
        sb.append(", jbrGUID=").append(jbrGUID);
        sb.append(", zygw=").append(zygw);
        sb.append(", orderBarcode=").append(orderBarcode);
        sb.append(", closeReason=").append(closeReason);
        sb.append(", orderTypeEnum=").append(orderTypeEnum);
        sb.append(", areaStatusEnum=").append(areaStatusEnum);
        sb.append(", zxBz=").append(zxBz);
        sb.append(", zxPrice=").append(zxPrice);
        sb.append(", gjjYear=").append(gjjYear);
        sb.append(", ajYear=").append(ajYear);
        sb.append(", baseRoomBldPrice=").append(baseRoomBldPrice);
        sb.append(", baseCjBldPrice=").append(baseCjBldPrice);
        sb.append(", baseCjTnPrice=").append(baseCjTnPrice);
        sb.append(", status=").append(status);
        sb.append(", BUGUID=").append(BUGUID);
        sb.append(", auditName=").append(auditName);
        sb.append(", lastSaleTypeEnum=").append(lastSaleTypeEnum);
        sb.append(", calMode=").append(calMode);
        sb.append(", orderType=").append(orderType);
        sb.append(", areaStatus=").append(areaStatus);
        sb.append(", payFormName=").append(payFormName);
        sb.append(", jbrName=").append(jbrName);
        sb.append(", createdName=").append(createdName);
        sb.append(", modifiedName=").append(modifiedName);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", baseRoomTnPrice=").append(baseRoomTnPrice);
        sb.append(", closeReasonEnum=").append(closeReasonEnum);
        sb.append(", idCode=").append(idCode);
        sb.append(", baTotal=").append(baTotal);
        sb.append(", baBldPrice=").append(baBldPrice);
        sb.append(", baTnPrice=").append(baTnPrice);
        sb.append(", rate=").append(rate);
        sb.append(", taxAmount=").append(taxAmount);
        sb.append(", tjrAllGUID=").append(tjrAllGUID);
        sb.append(", tjrAllName=").append(tjrAllName);
        sb.append(", zygwAllGUID=").append(zygwAllGUID);
        sb.append(", cstAllCardID=").append(cstAllCardID);
        sb.append(", cstAllName=").append(cstAllName);
        sb.append(", xActivityID=").append(xActivityID);
        sb.append(", xAjRate=").append(xAjRate);
        sb.append(", xchooseRoomcode=").append(xchooseRoomcode);
        sb.append(", xDecorationPayFormType=").append(xDecorationPayFormType);
        sb.append(", xDecorationPayFormTypeGuid=").append(xDecorationPayFormTypeGuid);
        sb.append(", xDecorationTotal=").append(xDecorationTotal);
        sb.append(", xEcommerceD=").append(xEcommerceD);
        sb.append(", xEcommercePosID=").append(xEcommercePosID);
        sb.append(", xEcommerceZk=").append(xEcommerceZk);
        sb.append(", xEndDate=").append(xEndDate);
        sb.append(", xGjjRate=").append(xGjjRate);
        sb.append(", xifzxkp=").append(xifzxkp);
        sb.append(", xIsQjState=").append(xIsQjState);
        sb.append(", xIsSaleParking=").append(xIsSaleParking);
        sb.append(", xIsSendQyqOneDaySms=").append(xIsSendQyqOneDaySms);
        sb.append(", xIsSendRgdtSms=").append(xIsSendRgdtSms);
        sb.append(", xIsSendRghTwoDaySms=").append(xIsSendRghTwoDaySms);
        sb.append(", xIsStaff=").append(xIsStaff);
        sb.append(", xIsUseEcommerce=").append(xIsUseEcommerce);
        sb.append(", xIsYfYy=").append(xIsYfYy);
        sb.append(", xMainContractPayFormType=").append(xMainContractPayFormType);
        sb.append(", xMainContractPrice=").append(xMainContractPrice);
        sb.append(", xMainContractTotal=").append(xMainContractTotal);
        sb.append(", xManagerDiscount=").append(xManagerDiscount);
        sb.append(", xManagerDiscountAmount=").append(xManagerDiscountAmount);
        sb.append(", xManagerDiscountType=").append(xManagerDiscountType);
        sb.append(", xManagerDiscounzValue=").append(xManagerDiscounzValue);
        sb.append(", xMasterSaleGUID=").append(xMasterSaleGUID);
        sb.append(", xorderCode=").append(xorderCode);
        sb.append(", xOrderID=").append(xOrderID);
        sb.append(", xorderStatus=").append(xorderStatus);
        sb.append(", xParkingAmount=").append(xParkingAmount);
        sb.append(", xParkingTotal=").append(xParkingTotal);
        sb.append(", xPayFormType=").append(xPayFormType);
        sb.append(", xPayFormTypeEnum=").append(xPayFormTypeEnum);
        sb.append(", xRoomStru=").append(xRoomStru);
        sb.append(", xStaffName=").append(xStaffName);
        sb.append(", xIsJobClosed=").append(xIsJobClosed);
        sb.append(", xChgDate=").append(xChgDate);
        sb.append(", xTjrRoomInfo=").append(xTjrRoomInfo);
        sb.append(", xTjrCardType=").append(xTjrCardType);
        sb.append(", xTjrCardID=").append(xTjrCardID);
        sb.append(", xTjrTel=").append(xTjrTel);
        sb.append(", xTjrAlternativePhone=").append(xTjrAlternativePhone);
        sb.append(", xMainRoomSaleGUID=").append(xMainRoomSaleGUID);
        sb.append(", xAjBankZX=").append(xAjBankZX);
        sb.append(", xAjRateZX=").append(xAjRateZX);
        sb.append(", xAjTotalZX=").append(xAjTotalZX);
        sb.append(", xAjYearZX=").append(xAjYearZX);
        sb.append(", xGjjBankZX=").append(xGjjBankZX);
        sb.append(", xGjjRateZX=").append(xGjjRateZX);
        sb.append(", xGjjTotalZX=").append(xGjjTotalZX);
        sb.append(", xGjjYearZX=").append(xGjjYearZX);
        sb.append(", xShareOut=").append(xShareOut);
        sb.append(", xShareOutText=").append(xShareOutText);
        sb.append(", xIsOldOwner=").append(xIsOldOwner);
        sb.append(", xIsSecondOwner=").append(xIsSecondOwner);
        sb.append(", xMainContractGUID=").append(xMainContractGUID);
        sb.append(", xMainRoom=").append(xMainRoom);
        sb.append(", xSeMainContractGUID=").append(xSeMainContractGUID);
        sb.append(", xSendMainRoom=").append(xSendMainRoom);
        sb.append(", xRoomHxCode=").append(xRoomHxCode);
        sb.append(", xCstAllAlternativePhone=").append(xCstAllAlternativePhone);
        sb.append(", xCstAllTel=").append(xCstAllTel);
        sb.append(", xDoubleContractStatus=").append(xDoubleContractStatus);
        sb.append(", is_testdata=").append(is_testdata);
        sb.append(", is_deleted=").append(is_deleted);
        sb.append(", versionNumber=").append(versionNumber);
        sb.append(", remark=").append(remark);
        sb.append(", discntRemark=").append(discntRemark);
        sb.append(", addition=").append(addition);
        sb.append(", xAjCodeList=").append(xAjCodeList);
        sb.append(", xAjFileCounts=").append(xAjFileCounts);
        sb.append(", xSelfdefinedZl=").append(xSelfdefinedZl);
        sb.append(", xSelfdefinedZlWsq=").append(xSelfdefinedZlWsq);
        sb.append(", xProcessAuditGUIDs=").append(xProcessAuditGUIDs);
        sb.append(", xProcessAuditNames=").append(xProcessAuditNames);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}