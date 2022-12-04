//package com.example.demo.entity.es;
//
//
//import lombok.Data;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.elasticsearch.annotations.Field;
//import org.springframework.data.elasticsearch.annotations.FieldType;
//import java.io.Serializable;
///**
// * <p>
// *
// * </p>
// *
// * @author gaoleijie
// * @since 2019-04-09
// */
//@Data
//@Document(indexName = "user_index",type = "user")
//public class SysUser implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//    @Id
//    private Integer id;
//
//
////    @Field(type = FieldType.Keyword)
//    @Field(type = FieldType.Text)
//    private String username;
//
//
//    @Field(type = FieldType.Keyword)
//    private String password;
//
//
//
//    @Field(type = FieldType.Text,analyzer = "ik_max_word")
//    private String nickname;
//
//
//    @Field(type = FieldType.Keyword)
//    private String email;
//
//    @Field(type = FieldType.Integer)
//    private Integer status;
//
//
//    @Field(type = FieldType.Keyword)
//    private String createUser;
//
//
//    @Field(type = FieldType.Keyword)
//    private String updateUser;
//
//
//    @Field(type = FieldType.Double)
//    private Double age;
//
//
//}
