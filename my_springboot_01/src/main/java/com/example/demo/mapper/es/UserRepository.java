//package com.example.demo.mapper.es;
//
//
//import com.example.demo.entity.es.SysUser;
//import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
//
//import java.util.List;
//
///**
// * @ClassName ElasticSerarchRepository
// *
// * SysUser  指定了 要访问  哪个eS 库
// *
// **/
//public interface UserRepository extends ElasticsearchRepository<SysUser,Long> {
//    /**
//     * 根据昵称查找用户
//     * @param nickName
//     * @return
//     */
//    List<SysUser> findByNickname(String nickName);
//
//    /**
//     * 根据昵称或者用户名进行查找
//     * @param nickName
//     * @param Password
//     * @return
//     */
//    List<SysUser> findByNicknameOrPassword(String nickName,String Password);
//}