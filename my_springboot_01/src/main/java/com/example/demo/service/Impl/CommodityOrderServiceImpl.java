package com.example.demo.service.Impl;

import com.example.demo.entity.CommodityOrder;
import com.example.demo.entity.CommodityOrderDetail;
import com.example.demo.entity.Vo.CommodityOrderVo;
import com.example.demo.mapper.CommodityOrderMapper;
import com.example.demo.service.CommodityOrderDetailService;
import com.example.demo.service.CommodityOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-01-16 13:09
 **/
@Service
public class CommodityOrderServiceImpl implements CommodityOrderService {
    @Autowired
    CommodityOrderMapper commodityOrderMapper;
    @Autowired
    CommodityOrderDetailService commodityOrderDetailService;
    @Override
    public CommodityOrder getByOrderId(Integer id){
       return  commodityOrderMapper.getByOrderId(id);
    }

    @Override
    public int updateOrderAndDetails(CommodityOrderVo commodityOrderVo) {
        // 新增数据的容器
        List<CommodityOrderDetail> addList = new ArrayList();
        // 获取表里数据
        CommodityOrder orderFromDb = commodityOrderMapper.getByOrderId(commodityOrderVo.getId());
        if (!CollectionUtils.isEmpty(orderFromDb.getDetailsList())) {
            List<CommodityOrderDetail> detailsFromDb = orderFromDb.getDetailsList();
            //  前段返回的订单明细 集合 中有数据
            if (!CollectionUtils.isEmpty(commodityOrderVo.getDetailsList())) {
                // 过滤出 detailsFromDb 没有的数据为新增 (也可以考虑 removeAll 不过原来的集合会改变)
                addList = commodityOrderVo.getDetailsList()
                        .stream()
                        //  contains 涉及到自定义对象的 是否一样，需要重写 equals 和 hasCode 方法；此处只需要 id，和orderId一样就认为是同一个对象
                        //  如果把CommodityOrderDetail 里的所有属性 都参与 equals 和 hasCode，数据库里的一条数据 和前端 传过来根据id ，name 等其他字段判断的时候
                        // 发现不一样，就认为这是两条不同的数据,所以重写 equals和hashCode 的时候只需要让id 和 orderId 参与运算即可
                        .filter(detail -> !detailsFromDb.contains(detail))
                        .collect(Collectors.toList());
            }
        }
        // 新增
        if (!CollectionUtils.isEmpty(addList)) {
            // 批量入库
            int count = commodityOrderDetailService.batchInsertDetails(addList);
            System.out.println("批量插入 明细表的 条数为-------------------------->  "+ count);
        }

        // 修改（编辑 + 逻辑删除）
        // 修改 前端一般不传要删掉的订单明细id，只传要编辑的订单明细id和业务数据 commodityOrderVo.getEditList() 只包含了要编辑的业务数据
        // 获取要逻辑删除的数据 :（库里有,前端没有传的）
        List<CommodityOrderDetail> logicDeleteList = orderFromDb.getDetailsList()
                .stream()
                .filter(detail ->!commodityOrderVo.getDetailsList().contains(detail) )
                .map(de -> {
                  // 设置成删除
                    de.setIsDelete(1);
                    return de;
                })
                .collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(commodityOrderVo.getDetailsList()) &&!CollectionUtils.isEmpty(logicDeleteList) ) {
            // 要编辑的业务数据 + 要删除的业务数据
            commodityOrderVo.getDetailsList().addAll(logicDeleteList);
        }
        return commodityOrderMapper.updateOrderAndDetails(commodityOrderVo);
    }
}
