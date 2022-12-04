package com.example.demo.entity.xml2;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program: crm3-finance5
 * @description: 发起退款申请
 * @author: guoyiguang
 * @create: 2021-07-05 15:39
 **/
@Data
@JacksonXmlRootElement(localName ="data")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
@NoArgsConstructor
@AllArgsConstructor
public class PubUpdateTkApplyInfoDTO {

    @JacksonXmlProperty(localName ="UpdateRePayRefundList")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<PubUpdateTkApplyInfo> UpdateRePayRefundList;
}
