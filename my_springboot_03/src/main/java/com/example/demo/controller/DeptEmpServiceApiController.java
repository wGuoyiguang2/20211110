//package com.example.demo.controller;
//
//import com.baomidou.mybatisplus.core.conditions.Wrapper;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.example.demo.entity.DeptEmp;
//import com.example.demo.service.DeptEmpService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//import java.time.LocalDate;
//import java.util.*;
//
///**
// * @program: springboot_01
// * @description:
// * @author: guoyiguang
// * @create: 2021-08-14 11:30
// **/
//@RestController("/deptEmp")
//public class DeptEmpServiceApiController {
//
//    @Autowired
//    DeptEmpService deptEmpService;
//
//
//    /**
//     *
//     * * * * * * * * * * * * * * * * * * * * * * * *  * *     Service CRUD 接口 * * * * * * * * * * * *  * * * * * * * * * * * * * *
//     *
//     */
//
//    /**
//     *
//     * * *******************************************   查询 篇  *****************************************************
//     *  一般三种思路：
//     *  ① 传 实体（包括包装类） eg：list（Wrapper），getOne(Wrapper)
//     *  ② 传 map     eg: listByMap(Map)
//     *  ③ 链式查询（这个很实用）   eg:query() ; lambdaQuery()
//     *
//    */
//
//    /**
//     *
//     * SELECT id,emp_no,dept_no,from_date,to_date,description
//     *  FROM dept_emp_59
//     *  WHERE id='5';
//    */
//    @PostMapping(value = "/list")
//    public List<DeptEmp> list() {
//        // 准备参数
//        DeptEmp deptEmp = new DeptEmp();
//        deptEmp.setId("5");
//
//        // 开始查询
//        Wrapper wrapper = new QueryWrapper<>(deptEmp);
//
//        List result = deptEmpService.list(wrapper);
//        return result;
//    }
//
//
//    /**
//     * SELECT id,emp_no,dept_no,from_date,to_date,description
//     *  FROM dept_emp_59
//     *  WHERE id='5';
//     */
//    @PostMapping(value = "/getOne")
//    public DeptEmp getOne() {
//        // 准备参数
//        DeptEmp deptEmp = new DeptEmp();
//        deptEmp.setId("5");
//
//        // 开始查询
//        Wrapper wrapper = new QueryWrapper<>(deptEmp);
//
//        DeptEmp result = deptEmpService.getOne(wrapper);
//        return result;
//    }
//
//
//    /**
//     * 查询（根据 columnMap 条件）
//     * default List<T> listByMap(Map<String, Object> columnMap)
//     * @param
//     *
//     *  SELECT id,emp_no,dept_no,from_date,to_date,description
//     *  FROM dept_emp_59
//     *  WHERE to_date = '2021-08-14 AND id = '5';
//     *
//     */
//    @PostMapping(value = "/listByMap")
//    public List<DeptEmp> listByMap() {
//        Map<String,Object> para = new HashMap<>();
//        para.put("id","5");
//        para.put("to_date","2021-08-14");
//        List<DeptEmp> result = (List<DeptEmp>)deptEmpService.listByMap(para);
//        return result;
//    }
//
//
//
//
//    /**
//     * 链式查询 普通   （实用）
//     *  语法 ：  query().eq("column", value).one();
//     *   default QueryChainWrapper<T> query() {
//     *         return ChainWrappers.queryChain(getBaseMapper());
//     *     }
//     *
//     *
//     *SELECT id,emp_no,dept_no,from_date,to_date,description
//     *  FROM dept_emp_59
//     *  WHERE (id = '5' AND to_date >= '2021-01-23' AND from_date <= '2021-08-14' AND sex IN ('1','2') AND description LIKE '%likeSex%');
//     *
//     *
//     */
//    @PostMapping(value = "/query")
//    public List<DeptEmp> query() {
//        String[] array= {"1","2"};
//        // 返回一个
//        List<DeptEmp> result = deptEmpService.query()
//                .eq("id", "5")
//                .ge("to_date","2021-01-23")
//                .le("from_date","2021-08-14")
//                // in 查询
//                .in("sex", Arrays.asList(array))
//                .like("description","likeSex")
//                .list();
//
//        // 返回一个
//        //DeptEmp result = deptEmpService.query().eq("id", "5").one();
//        return result;
//    }
//
//
//    /**
//     * @Description:
//     *            链式查询(lamda 表达式)
//     *            语法 ：   lambdaQuery().eq(Entity::getId, value).list();
//     *
//     * @return:
//     * @Author: guoyiguang
//     * @Date:
//     */
//    @PostMapping(value = "/lambdaQuery")
//    public List<DeptEmp> lambdaQuery() {
//        List<DeptEmp> result =  deptEmpService.lambdaQuery().eq(DeptEmp::getId, "5").list();
//
//        return result;
//    }
//
//
//
//
//    /**
//     *
//     * * *******************************************   修改篇  *****************************************************
//     *  一般三种思路：
//     *  ① 传 实体（包括包装类） eg：list（Wrapper），getOne(Wrapper)
//     *  ② 传 map     eg: listByMap(Map)
//     *  ③ 链式修改  （支持批量，ps 但是修改的数据都一样的情况下可以）   eg:update() ; lambdaUpdate()
//     */
//
//    /**
//     * @Description: 链式修改(普通) ,支持批量
//     *                 update().eq("column", value).remove();
//     *
//     *
//     *
//     *  生成 sql 如下：
//     *      * UPDATE dept_emp_59
//     *      *   SET dept_no='5',
//     *      *   emp_no=2
//     *      *  WHERE (id IN (4,5));
//     *
//     * @Date:
//     */
//    @PostMapping(value = "/update")
//    public boolean update() {
//        List<Object> idList = new ArrayList<>();
//        idList.add(4);
//        idList.add(5);
//        boolean flag = deptEmpService
//                .update()
//                // .eq("id", "5")
//                .in("id",idList)
//                .set("dept_no", "5")
//                .set("emp_no", 2)
//                .update();
//        return flag;
//    }
//
//
//
//    /**
//     * @Description: 链式修改 （lamda）
//     *               示例： lambdaUpdate().eq(Entity::getId, value).update(entity);
//     *
//     *  生成sql：
//     *       UPDATE dept_emp_59
//     *             SET description=''
//     *             WHERE (id = '5');
//     * @Date:
//     */
//    @PostMapping(value = "/lambdaUpdate")
//    public boolean lambdaUpdate() {
//        DeptEmp  entity = new DeptEmp();
//
//
//        //entity.setDescription(" call lambdaUpdate...... ");
//        entity.setDescription("");
//        // 设置不了空
//        entity.setEmpNo(null);
//        boolean flag = deptEmpService
//                .lambdaUpdate()
//                .eq(DeptEmp::getId, "5")
//                .update(entity);
//
//        return flag;
//    }
//
//
//
//    /**
//    * sql：（即使id 不存在，也不会报错）；可以设置空串；不可以设置 null ；
//     *
//     *==>  Preparing: UPDATE dept_emp_59 SET emp_no=?, from_date=?, to_date=?, description=? WHERE id=?
//     * ==> Parameters: 7(String), 2021-08-14(LocalDate), 2021-08-14(LocalDate), update(String), 2(String)
//     * ==> Parameters: 7(String), 2021-08-14(LocalDate), 2021-08-14(LocalDate), update(String), 3(String)
//     * ==>  Preparing: UPDATE dept_emp_59 SET emp_no=?, dept_no=?, from_date=?, to_date=?, description=? WHERE id=?
//     * ==> Parameters: 7(String), (String), 2021-08-14(LocalDate), 2021-08-14(LocalDate), update(String), 4(String)
//     * ==> Parameters: 7(String), 7(String), 2021-08-14(LocalDate), 2021-08-14(LocalDate), update(String), 1000(String)
//     *
//    */
//    @PostMapping(value = "/updateBatchById")
//    public boolean updateBatchById() {
//
//        List<DeptEmp> list = new ArrayList<>();
//        DeptEmp deptEmp = new DeptEmp();
//        deptEmp.setId("2");
//        deptEmp.setEmpNo("7");
//        deptEmp.setDeptNo(null);
//        deptEmp.setFromDate(LocalDate.now());
//        deptEmp.setToDate(LocalDate.now());
//        deptEmp.setDescription("update");
//
//        DeptEmp deptEmp2 = new DeptEmp();
//        deptEmp2.setId("3");
//        deptEmp2.setEmpNo("7");
//        deptEmp2.setDeptNo(null);
//        deptEmp2.setFromDate(LocalDate.now());
//        deptEmp2.setToDate(LocalDate.now());
//        deptEmp2.setDescription("update");
//
//        list.add(deptEmp);
//        list.add(deptEmp2);
//
//
//
//        // update
//        DeptEmp deptEmp3 = new DeptEmp();
//        deptEmp3.setId("4");
//        deptEmp3.setEmpNo("7");
//        deptEmp3.setDeptNo("");
//        deptEmp3.setFromDate(LocalDate.now());
//        deptEmp3.setToDate(LocalDate.now());
//        deptEmp3.setDescription("update");
//        list.add(deptEmp3);
//
//
//        // 数据不存在
//        DeptEmp deptEmp4= new DeptEmp();
//        deptEmp4.setId("1000");
//        deptEmp4.setEmpNo("7");
//        deptEmp4.setDeptNo("7");
//        deptEmp4.setFromDate(LocalDate.now());
//        deptEmp4.setToDate(LocalDate.now());
//        deptEmp4.setDescription("update");
//        list.add(deptEmp4);
//
//
//        boolean flag = deptEmpService.updateBatchById(list);
//        return flag;
//    }
//
//
//
//    /**
//     *
//     * * *******************************************   增加篇  *****************************************************
//     *
//     *    单条增加；批量增加
//     *
//     */
//
//
//
//    /**
//     *  save 方法只  设置 非 null 的
//     *
//     *  可以设置空串
//     *    INSERT INTO  dept_emp_59
//     *       ( id, emp_no, dept_no, to_date, description )
//     *      VALUES ( '1426436532424015874', '7', '', '2021-08-14', 'insert' );
//     */
//    @PostMapping(value = "/insertOne")
//    public boolean insertOne() {
//        DeptEmp deptEmp = new DeptEmp();
//        deptEmp.setEmpNo("7");
//        deptEmp.setDeptNo("");
//        deptEmp.setFromDate(null);
//        deptEmp.setToDate(LocalDate.now());
//        deptEmp.setDescription("insert");
//        boolean flag = deptEmpService.save(deptEmp);
//        return flag;
//    }
//
//    /**
//     * ==>  Preparing: INSERT INTO dept_emp_59 ( id, emp_no, dept_no, from_date, to_date, description ) VALUES ( ?, ?, ?, ?, ?, ? )
//     * ==> Parameters: 1426436919071735809(String), 7(String), 7(String), 2021-08-14(LocalDate), 2021-08-14(LocalDate), insert(String)
//     * ==> Parameters: 1426436919071735810(String), 7(String), 7(String), 2021-08-14(LocalDate), 2021-08-14(LocalDate), insert(String)
//    */
//    @PostMapping(value = "/saveBatch")
//    public boolean saveBatch() {
//
//        List<DeptEmp> list = new ArrayList<>();
//        DeptEmp deptEmp = new DeptEmp();
//        deptEmp.setEmpNo("7");
//        deptEmp.setDeptNo("7");
//        deptEmp.setFromDate(LocalDate.now());
//        deptEmp.setToDate(LocalDate.now());
//        deptEmp.setDescription("insert");
//
//        DeptEmp deptEmp2 = new DeptEmp();
//        deptEmp2.setEmpNo("7");
//        deptEmp2.setDeptNo("7");
//        deptEmp2.setFromDate(LocalDate.now());
//        deptEmp2.setToDate(LocalDate.now());
//        deptEmp2.setDescription("insert");
//
//        list.add(deptEmp);
//        list.add(deptEmp2);
//
//
//
//        boolean flag = deptEmpService.saveBatch(list);
//        return flag;
//    }
//
//
//
//
//
//    /**
//     *
//     * * *******************************************   增加删除混合篇  *****************************************************
//     * 单个；批量
//     */
//
//
//
//    /**
//     * TableId 注解存在更新记录，否插入一条记录
//     *
//     *  ①  判断数据是否已经存在
//     *
//     * SELECT id,emp_no,dept_no,from_date,to_date,description
//     *  FROM dept_emp_59
//     *  WHERE id='5';
//     *
//     *
//     * ②存在就更新（不存在就插入）
//     * UPDATE dept_emp_59 SET emp_no='7', dept_no='7', from_date='2021-08-14', to_date='2021-08-14', description='update'
//     *  WHERE id='5';
//     */
//    @PostMapping(value = "/saveOrUpdate")
//    public boolean saveOrUpdate() {
//        DeptEmp deptEmp = new DeptEmp();
//        // 数据已经存在
//        deptEmp.setId("5");
//        deptEmp.setEmpNo("7");
//        deptEmp.setDeptNo("7");
//        deptEmp.setFromDate(LocalDate.now());
//        deptEmp.setToDate(LocalDate.now());
//        deptEmp.setDescription("update");
//        boolean flag = deptEmpService.saveOrUpdate(deptEmp);
//        return flag;
//    }
//
//
//    /**
//     *
//     * ① 判断数据是否已经存在
//     * SELECT id,emp_no,dept_no,from_date,to_date,description
//     *  FROM dept_emp_59
//     *  WHERE id='55';
//     *
//     *  ② 不存在就插入
//     * INSERT INTO dept_emp_59 ( id, emp_no, dept_no, from_date, to_date, description ) VALUES ( '55', '7', '7', '2021-08-14', '2021-08-14', 'update' );
//    */
//    @PostMapping(value = "/saveOrUpdate2")
//    public boolean saveOrUpdate2() {
//        DeptEmp deptEmp = new DeptEmp();
//        // 数据不存在
//        deptEmp.setId("55");
//        deptEmp.setEmpNo("7");
//        deptEmp.setDeptNo("7");
//        deptEmp.setFromDate(LocalDate.now());
//        deptEmp.setToDate(LocalDate.now());
//        deptEmp.setDescription("update");
//        boolean flag = deptEmpService.saveOrUpdate(deptEmp);
//        return flag;
//    }
//
//
//
//    /**
//    * @Description: TableId 注解存在更新记录，否插入一条记录（不给出id 那条数据就不处理）
//     * 原理：根据给出的id 去查，有就更新，没有就插入（还是会产生多个会话）
//     *
//     *
//     * Creating a new SqlSession
//     * Registering transaction synchronization for SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@62e5f9ea]
//     * JDBC Connection [ProxyConnection[PooledConnection[com.mysql.cj.jdbc.ConnectionImpl@26c5e52f]]] will be managed by Spring
//     * ==>  Preparing: SELECT id,emp_no,dept_no,from_date,to_date,description FROM dept_emp_59 WHERE id=?
//     * ==> Parameters: 89(String)
//     * <==      Total: 0
//     * Releasing transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@62e5f9ea]
//     * JDBC Connection [ProxyConnection[PooledConnection[com.mysql.cj.jdbc.ConnectionImpl@26c5e52f]]] will be managed by Spring
//     * ==>  Preparing: INSERT INTO dept_emp_59 ( id, emp_no, dept_no, from_date, to_date, description ) VALUES ( ?, ?, ?, ?, ?, ? )
//     * ==> Parameters: 89(String), 7(String), 7(String), 2021-08-14(LocalDate), 2021-08-14(LocalDate), insertBatch(String)
//     * ==> Parameters: 1426440217661272065(String), 7(String), 7(String), 2021-08-14(LocalDate), 2021-08-14(LocalDate), insertBatch(String)
//     * Fetched SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@62e5f9ea] from current transaction
//     * ==>  Preparing: SELECT id,emp_no,dept_no,from_date,to_date,description FROM dept_emp_59 WHERE id=?
//     * ==> Parameters: 5(String)
//     * <==    Columns: id, emp_no, dept_no, from_date, to_date, description
//     * <==        Row: 5, 7, 7, 2021-08-14, 2021-08-14, updateBatch
//     * <==      Total: 1
//     * Releasing transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@62e5f9ea]
//     * ==>  Preparing: UPDATE dept_emp_59 SET emp_no=?, dept_no=?, from_date=?, to_date=?, description=? WHERE id=?
//     * ==> Parameters: 7(String), 7(String), 2021-08-14(LocalDate), 2021-08-14(LocalDate), updateBatch(String), 5(String)
//     * Fetched SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@62e5f9ea] from current transaction
//     * ==>  Preparing: SELECT id,emp_no,dept_no,from_date,to_date,description FROM dept_emp_59 WHERE id=?
//     * ==> Parameters: 2(String)
//     * <==    Columns: id, emp_no, dept_no, from_date, to_date, description
//     * <==        Row: 2, 7, 7, 2021-08-14, 2021-08-14, update
//     * <==      Total: 1
//     * Releasing transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@62e5f9ea]
//     * ==> Parameters: 7(String), 7(String), 2021-08-14(LocalDate), 2021-08-14(LocalDate), updateBatch(String), 2(String)
//    */
//    @PostMapping(value = "/saveOrUpdateBatch")
//    public boolean saveOrUpdateBatch() {
//
//        List<DeptEmp> list = new ArrayList<>();
//
//
//
//        DeptEmp deptEmp0 = new DeptEmp();
//        // 这个id不存在
//        deptEmp0.setId("89");
//        deptEmp0.setEmpNo("7");
//        deptEmp0.setDeptNo("7");
//        deptEmp0.setFromDate(LocalDate.now());
//        deptEmp0.setToDate(LocalDate.now());
//        deptEmp0.setDescription("insertBatch");
//
//        list.add(deptEmp0);
//
//
//        DeptEmp deptEmp = new DeptEmp();
//        deptEmp.setEmpNo("7");
//        deptEmp.setDeptNo("7");
//        deptEmp.setFromDate(LocalDate.now());
//        deptEmp.setToDate(LocalDate.now());
//        deptEmp.setDescription("insertBatch");
//
//        list.add(deptEmp);
//
//
//
//
//
//
//        // update
//        DeptEmp deptEmp3 = new DeptEmp();
//        deptEmp3.setId("5");
//        deptEmp3.setEmpNo("7");
//        deptEmp3.setDeptNo("7");
//        deptEmp3.setFromDate(LocalDate.now());
//        deptEmp3.setToDate(LocalDate.now());
//        deptEmp3.setDescription("updateBatch");
//        list.add(deptEmp3);
//
//        DeptEmp deptEmp2 = new DeptEmp();
//        deptEmp2.setId("2");
//        deptEmp2.setEmpNo("7");
//        deptEmp2.setDeptNo("7");
//        deptEmp2.setFromDate(LocalDate.now());
//        deptEmp2.setToDate(LocalDate.now());
//        deptEmp2.setDescription("updateBatch");
//        list.add(deptEmp2);
//
//
//        boolean flag = deptEmpService.saveOrUpdateBatch(list);
//        return flag;
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
//}
