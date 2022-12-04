//package com.example.demo.controller;
//
//import com.example.demo.entity.es.SkuEs;
//import com.example.demo.service.SkuSearchService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import java.util.Map;
//
///**
// * @program: springboot_01  elasticsearch/createIndex
// * @description:
// * @author: guoyiguang
// * @create: 2021-03-07 13:14
// **/
//
//@RestController
//@RequestMapping("/elasticsearch/sku")
//public class ElasticsearchSkuController {
//
//    @Autowired
//    SkuSearchService skuSearchService;
//
//    /*****
//     * 增加文档
//     */
//    @PostMapping(value = "/add")
//    public boolean add(@RequestBody SkuEs skuEs){
//        skuSearchService.add(skuEs);
//        return true;
//    }
//
//
//    /***
//     * 商品搜索
//     *
//     * 前段 传一个JSON ，后台 用 Map 是如何接受的？ 加 @RequestBody  注解
//     *
//     * 说明：  searchMap 也可以 用 一个单独的 实体类代替 (但是动态 属性 不好处理，map 的话 无所谓)
//     *
//     * 实体类的属性：
//     *     name     spu 全名称
//     *     category  三级分类名称
//     *     brand      品牌名称
//     *     price （0-500元  500-1000元  1000元以上） , 用 - 截取，如果长度是两个，就是范围查询，如果 有 以上（or 是一个） ，说明  大于 1000
//     *     sfield 排序字段
//     *     sm 排序方式
//     *
//     */
//    @PostMapping(value = "/search")
//    public Map<String,Object> search(@RequestBody Map<String,Object> searchMap){
//        Map<String, Object> resultMap = skuSearchService.search(searchMap);
//        return resultMap;
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//}
