package com.example.demo.entity.xml2;

import com.example.demo.entity.xml2entity.Url;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.Valid;
import java.util.List;

/**
 * @program: crm3-finance5
 * @description:  退款发起 接参
 * @author: guoyiguang
 * @create: 2021-07-05 15:52
 **/
@Data
@JacksonXmlRootElement
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
@NoArgsConstructor
@AllArgsConstructor
public class PubUpdateTkApplyInfo {


    private String  TkMxGUID ;

    private String  KZName ;

    private String  YHNumber ;

    private String  Province ;

    private String  City ;

    private String  Bankheadoffice ;

    private String  BankBranch ;

    @Valid
    @JacksonXmlElementWrapper(localName ="UrlList")
    @JacksonXmlProperty(localName = "Url")
    private List<Url> UrlList;


    /**
     *  是否原卡原退（1表示是原卡原退，0表示否）
     * */
    private String isOldCard;

}
