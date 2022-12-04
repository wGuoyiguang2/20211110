package com.example.demo.chain.context;



import com.example.demo.chain.config.OperateTypeEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;


@Getter
@Setter
public class SaveOrderContext {

    /**
     * 当前操作类型
     */
    private OperateTypeEnum operateTypeEnum;

    /********** 以下为缓存的上下文对象 **********/

    /**
     * 异步任务列表
     */
    private List<Future<?>> futures = new ArrayList<>();

    /**
     * 房间ID
     */
    private String roomGUID;



}
