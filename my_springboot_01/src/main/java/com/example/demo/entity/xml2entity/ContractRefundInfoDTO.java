package com.example.demo.entity.xml2entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 合同退款信息修改
 *
 * @Author zhouliang
 */
@ToString
@JacksonXmlRootElement(localName = "data")
@Data
//@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.ANY,getterVisibility= JsonAutoDetect.Visibility.NONE)
public class ContractRefundInfoDTO implements Serializable {

    /**
     * 交易GUID
     */
    private String SaleGUID;


    /**
     * 退款卡号
     */
    private String YHNumber;

    /**
     * 退款人
     */
    private String KZName;

    /**
     * 省
     */
    private String Province;


    /**
     * 市
     */
    @JsonProperty("City")
    private String City;


    /**
     * 省退款总行
     */
    @JsonProperty("Bankheadoffice")
    private String Bankheadoffice;

    /**
     * 市退款支行
     */
    @JsonProperty("BankBranch")
    private String BankBranch;

    /**
     * 附件校验  UrlList  Url
     */
    @JacksonXmlProperty(localName = "UrlList")
    @JacksonXmlElementWrapper(localName ="Url")
    @JsonProperty("UrlList")
    private List<Url> UrlList;


}
