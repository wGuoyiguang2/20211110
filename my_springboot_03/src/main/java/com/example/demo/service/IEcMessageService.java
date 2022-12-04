package com.example.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.EcMessage;
import java.util.List;

/**
 * <p>
 * 消息表 服务类
 * </p>
 *
 * @author gyg
 * @since 2021-11-10
 */
public interface IEcMessageService extends IService<EcMessage> {

    void  insertMessage(String text);



    /**
     *  消息分页
    */ 
    Page<EcMessage> getPageMessage(Integer pageNum , Integer pageSize);


    /**
     *  详情
     */
    EcMessage getMessageDetail(Long id);


    /**
     *  选中操作 （设置为已读，删除）
     */
    void chooseOperate(List<Long> idList,String operate);



    /**
     *  全部操作（已读，删除）
     */
    void allOperate(String operate);






}
