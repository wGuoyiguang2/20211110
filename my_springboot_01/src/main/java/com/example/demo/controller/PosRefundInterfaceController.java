package com.example.demo.controller;

import com.example.demo.entity.xml2entity.ContractRefundInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 收款机退款接口
 *
 * @Author zhouliang
 */
@Slf4j
@Validated
@RestController
@RequestMapping(value = "/")
public class PosRefundInterfaceController {


    /**
     * 合同退款信息修改
     *
     * @return
     */
    @PostMapping(value = "/crmin_pub_update_tkinfo",  consumes = MediaType.APPLICATION_XML_VALUE)
    public String updateTkInfo(@RequestBody ContractRefundInfoDTO dto) {
        System.out.println(dto);
        return dto.toString();
    }


}
