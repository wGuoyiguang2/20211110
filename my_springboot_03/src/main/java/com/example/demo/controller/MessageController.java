package com.example.demo.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.EcMessage;
import com.example.demo.service.IEcMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: pring-boot-mybatis-plus
 * @description:
 * @author: guoyiguang
 * @create: 2021-08-14 15:14
 **/
@RestController
@RequestMapping("/messageController")
public class MessageController {

    @Autowired
    IEcMessageService ecMessageService;





    /**
     *
     * 获取消息列表
     *   pageNum:当前页
     *   pageSize :页面大小
     *
     */
    @RequestMapping(value = "/getPageMessage")
    public  Page<EcMessage> getPageMessage(Integer pageNum , Integer pageSize) {
        Page<EcMessage> pageMessage = ecMessageService.getPageMessage(pageNum, pageSize);
        return pageMessage;

    }



    /**
     *
     * 新增消息 数据
     *
     */
    @RequestMapping(value = "/add")
    public boolean add(String text) {
        if(!StringUtils.isEmpty(text)){
            ecMessageService.insertMessage(text);
            return true;
        }
        return false;

    }



    /**
     *
     *
    */
    @PostMapping(value = "/updateById")
    public boolean updateById() {
        // 用实体更新
        EcMessage message = new EcMessage();
        message.setId(5L);

        boolean result = ecMessageService.updateById(message);
        return result;
    }

}
