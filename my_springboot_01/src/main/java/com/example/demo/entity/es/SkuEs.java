//package com.example.demo.entity.es;
//import lombok.Data;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.elasticsearch.annotations.Field;
//import org.springframework.data.elasticsearch.annotations.FieldType;
//
//import java.util.Date;
//import java.util.Map;
///**
// * @program: springboot_01
// * @description:
// * @author: guoyiguang
// * @create: 2021-10-10 14:29
// **/
//
//@Data
//@Document(indexName = "shopsearch",type = "skues")
//public class SkuEs {
//
//    @Id
//    private String id;
//    @Field(type = FieldType.Text,analyzer = "ik_smart",searchAnalyzer = "ik_smart")
//    private String name;
//    private Integer price;
//    private Integer num;
//    private String image;
//    private String images;
//    private Date createTime;
//    private Date updateTime;
//    private String spuId;
//    private Integer categoryId;
//    //Keyword：不分词  精确查找()
//    @Field(type= FieldType.Keyword)
//    private String categoryName;
//    private Integer brandId;
//    //   精确查找
//    @Field(type=FieldType.Keyword)
//    private String brandName;
//    // 商品属性 {"就业薪资":"6K起","学习费用":"2万"}  是不分词的
//    @Field(type=FieldType.Keyword)
//    private String skuAttribute;
//    private Integer status;
//
//    //属性映射(动态创建域信息)
//    //key=就业薪资
//    //value=1万
//    //attrMap.就业薪资.keyword=1万
//    // es 里 会存入这个 字段
//    private Map<String,String> attrMap;
//}
