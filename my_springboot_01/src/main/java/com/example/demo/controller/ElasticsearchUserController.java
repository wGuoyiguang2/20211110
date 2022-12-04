//package com.example.demo.controller;
//
//import com.example.demo.entity.es.SysUser;
//import com.example.demo.mapper.es.UserRepository;
//import com.github.pagehelper.Page;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
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
//@RequestMapping("/elasticsearch/user")
//public class ElasticsearchUserController {
//
//
//
//    // org.springframework.core.env.Environment
//    @Autowired
//    Environment environment;
//
//
//    @Autowired
//    UserRepository repository;
//
//
//
//    @Autowired
//    private ElasticsearchTemplate elasticsearchTemplate;
//
//    /**
//     * @Description:  创建索引
//     * @Param:
//     * @return:
//     * @Author: guoyiguang
//     * @Date:
//     */
//    @PostMapping("/createIndex")
//    public Boolean createIndex(){
//        return  elasticsearchTemplate.createIndex(SysUser.class);
//    }
//
//
//    /**
//     * @Description:  删除索引
//     * @Param:
//     * @return:
//     * @Author: guoyiguang
//     * @Date:
//     */
//    @PostMapping("/deleteIndex")
//    public Boolean deleteIndex(@RequestParam String indexName){
//        // return elasticsearchTemplate.deleteIndex(SysUser.class);
//        return  elasticsearchTemplate.deleteIndex(indexName);
//    }
//
//
//    @PostMapping("/save")
//    public SysUser save(@RequestBody SysUser user){
//        return repository.save(user);
//    }
//
//    @PostMapping("/saveAll")
//    public Iterable<SysUser> saveAll(@RequestBody List<SysUser> users){
//        return  repository.saveAll(users);
//    }
//
//
//    @PostMapping("/findByNickname")
//    public List<SysUser> findByNickname(@RequestParam("nickname")String nickName){
//        List<SysUser> list =  repository.findByNickname(nickName);
//        return list;
//    }
//
//    @PostMapping("/findByNicknameOrPassword")
//    public List<SysUser> findByNicknameOrPassword(@RequestParam("nickname")String nickName,@RequestParam("password")String Password){
//        List<SysUser> list =  repository.findByNicknameOrPassword(nickName,Password);
//        return list;
//    }
//
//
//    @PostMapping("/query")
//    public Page<SysUser> query(@RequestBody Map<String,Object> searchMap){
//        NativeSearchQueryBuilder builder=new NativeSearchQueryBuilder();
//        if (null != searchMap.get("username")){
//            builder.withQuery(QueryBuilders.matchQuery("username",searchMap.get("username")));
//        }
//
//        if (null != searchMap.get("password")){
//            builder.withQuery(QueryBuilders.termQuery("password",searchMap.get("password")));
//        }
//
//
//        //如果实体和数据的名称对应就会自动封装，pageable分页参数
//        Page<SysUser> items = this.repository.search(builder.build());
//        // Iterator：迭代器，本身实现了Iterator接口，因此可直接迭代得到当前页的数据
//        List<SysUser> content = items.getContent();
//
//        long total = items.getTotalElements();
//        System.out.println("查询数量为:"+total);
//        return items;
//    }
//
//
//    /**
//     * 模糊查找
//     * @param userName
//     * @return
//     */
//    @PostMapping("/fuzzyQuery")
//    public Page<SysUser> fuzzyQuery(@RequestParam("username") String userName){
//        NativeSearchQueryBuilder builder=new NativeSearchQueryBuilder();
//        builder.withQuery(QueryBuilders.fuzzyQuery("username",userName));
//        // 查找
//        Page<SysUser> page = this.repository.search(builder.build());
//        return page;
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
