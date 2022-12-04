package com.example.demo;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import com.bestvike.linq.Linq;
import com.example.demo.clean.FileCleaner;
import com.example.demo.entity.*;
import com.example.demo.entity.Vo.BoyVo;
import com.example.demo.entity.Vo.LogVo;
import com.example.demo.entity.exception.BizException;
import com.example.demo.entity.linq.Bu;
import com.example.demo.entity.linq.BudgetResult;
import com.example.demo.entity.linq.Org;
import com.example.demo.entity.spring.StandardMultipartFile2;
import com.example.demo.entity.xml2entity.Student;
import com.example.demo.entity.xml2entity.StudentNoOverwrite;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.mapper.QuestionMapper;
import com.example.demo.mapper.RegionMapper;
import com.example.demo.service.Impl.BigDecimalSummaryStatistics;
import com.example.demo.utils.CollectorsUtil;
import com.github.pagehelper.Page;
import lombok.SneakyThrows;
import org.apache.catalina.core.ApplicationPart;
import org.apache.tomcat.util.http.fileupload.DeferredFileOutputStream;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;
import org.springframework.util.PathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static cn.hutool.core.io.IoUtil.DEFAULT_BUFFER_SIZE;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    private final PathMatcher pathMarch = new AntPathMatcher();


    ExecutorService executor = Executors.newCachedThreadPool();


    @Autowired
    QuestionMapper questionMapper;


    @Autowired
    OrderMapper orderMapper;


    @Autowired
    RegionMapper regionMapper;





    @Test
    public void contextLoads() {
        List<Question> list = questionMapper.list();
        System.out.println(list);
    }

    @Test
    public void pageHelperPluginTest() {

//        PageHelperPlugin.startPage(1,10);
        List<Question> list = questionMapper.list();
        //清除 线程 map里的 分页的key，value
//        PageHelperPlugin.endPage();
        System.out.println(list);
    }


    @Test
    public void customePagePluginTest() {
        Page<Question> page = new Page(1,10);
        List<Question> list = questionMapper.listByPage(page);
        System.out.println(list);
    }

    /**
    *  update 插件的 使用
    */
    @Test
    public void insertOrder() {
        Order order = new  Order();
        order.setName("衣服");
        order.setDescription("促销活动的衣服");
        int insert = orderMapper.insert(order);
        System.out.println(insert);
    }


    /**
     *  测试treeMap的有序性
     */
    @Test
    public void testTreeMap() {
        List<Order> orders = new ArrayList<>();
        Order o1 = new Order();
        o1.setName("0001.01");
        o1.setId(1);
        o1.setDescription("111111111");

        Order o2 = new Order();
        o2.setName("0001.01");
        o2.setId(2);
        o2.setDescription("22222222");




        Order o3 = new Order();
        o3.setName("0001.02 ");
        o3.setId(3);
        o3.setDescription("b(银行按揭付款)   333333333333333");

        Order o4 = new Order();
        o4.setName("0001.02");
        o4.setId(4);
        o4.setDescription("d   4444444");

        Order o5 = new Order();
        o5.setName("0001.03");
        o5.setId(5);
        o5.setDescription("5555555555");

        orders.add(o5);
        orders.add(o4);
        orders.add(o3);
        orders.add(o2);
        orders.add(o1);


        // TreeMap底层是根据红黑树的数据结构构建的，默认是根据key的自然排序来组织（比如integer的大小，String的字典排序）。
        // 所以，TreeMap只能根据key来排序
        Map<String, List<Order>> treeMap = orders.stream()
                .collect(Collectors.groupingBy(Order::getName,TreeMap::new,Collectors.toList()));
        System.out.println(treeMap);

        // 让treeMap 降序
        TreeMap<String,List<Order>> descTreeMap= new TreeMap<String,List<Order>>(new Comparator<String>(){
            public int compare(String a,String b){
                return b.compareTo(a);
            }
        });
        Map<String, List<Order>> hashMap = orders.stream()
                .collect(Collectors.groupingBy(Order::getName,HashMap::new,Collectors.toList()));


        // map 在java8的第一种遍历方式
        hashMap.forEach((k, v) ->{
            descTreeMap.put(k,v);

        });

// map 在java8的第二种遍历方式
//        hashMap.keySet().forEach(key ->  descTreeMap.put(key,hashMap.get(key)));
        System.out.println(descTreeMap);


    }


    /**
     *  测试treeMap的有序性
     */
    @Test
    public void testLocalDateTime() {
        String now  = LocalDate.now().toString();
        String  past = "2021-02-01";
        String  n = "2021-03-03";
        String  future = "2021-03-04";
        System.out.println(now.compareTo(past));
        System.out.println(now.compareTo(n));
        System.out.println(now.compareTo(future));
        System.out.println("1234234");


    }





    @Test
    public void testBatch() {
        String operatorGUID = "12345234563456" ;
        List<Order> list = new ArrayList<>();

        Order o1 = new Order();
        o1.setId(16);
        o1.setDescription("测试批量修改");
        o1.setName("测试");
        o1.setUpdatedTime(LocalDateTime.now());
        o1.setUpdatedGUID(operatorGUID);
        o1.setDelFlag("0");

        Order o2 = new Order();
        o2.setId(17);
        o2.setDescription("测试批量修改");
        o2.setName("测试");
        o2.setUpdatedTime(LocalDateTime.now());
        o2.setUpdatedGUID(operatorGUID);
        o2.setDelFlag("0");

        Order o3 = new Order();
        o3.setId(18);
        o3.setDescription("测试批量修改");
        o3.setName("测试");
        o3.setUpdatedTime(LocalDateTime.now());
        o3.setUpdatedGUID(operatorGUID);
        o3.setDelFlag("0");

        Order o4 = new Order();
        o4.setId(19);
        o4.setDescription("测试批量修改");
        o4.setName("测试");
        o4.setUpdatedTime(LocalDateTime.now());
        o4.setUpdatedGUID(operatorGUID);
        o4.setDelFlag("0");

        Order o5 = new Order();
        o5.setId(20);
        o5.setDescription("测试批量修改");
        o5.setName("测试");
        o5.setUpdatedTime(LocalDateTime.now());
        o5.setUpdatedGUID(operatorGUID);
        o5.setDelFlag("0");

        list.add(o1);
        list.add(o2);
        list.add(o3);
        list.add(o4);
        list.add(o5);

        int i = orderMapper.updateBatchOrders(list);
        System.out.println("修改的记录条数为："+ i);

    }











    @Test
    public void testList() {
        List  list = new ArrayList();

        fullList(  list) ;
        System.out.println(list);

        System.out.println(list);


    }


    public void fullList(List  list) {
        list.add("11") ;
        list.add("22") ;
    }



    @Test
    public void RecursionTest() {

        List  list = new ArrayList();
        Boss boss =  new Boss();
        boss.setName("慕容皝1");
        boss.setAge(28);
        Boss boss2 =  new Boss();
        boss2.setName("慕容皝2");
        boss2.setAge(28);
        list.add(boss);
        list.add(boss2);
        Recursion recursion = new Recursion();
        recursion.setBossList(list);
        // 遍历列表
        recursion.proceed();


    }


    @Test
    public void MergeTest() {

        List<StudentScore> studentScoreList = new ArrayList<>();

        StudentScore studentScore1 = new StudentScore("慕容皝","语文",BigDecimal.valueOf(99));
        StudentScore studentScore2 = new StudentScore("慕容皝","数学",BigDecimal.valueOf(99));
        StudentScore studentScore3 = new StudentScore("慕容皝","英语",BigDecimal.valueOf(97));
        StudentScore studentScore4 = new StudentScore("慕容皝","历史",BigDecimal.valueOf(97));
        studentScoreList.add(studentScore1) ;
        studentScoreList.add(studentScore2) ;
        studentScoreList.add(studentScore3) ;
        studentScoreList.add(studentScore4) ;


        StudentScore studentScore5 = new StudentScore("慕容垂","语文",BigDecimal.valueOf(89));
        StudentScore studentScore6 = new StudentScore("慕容垂","数学",BigDecimal.valueOf(89));
        StudentScore studentScore7 = new StudentScore("慕容垂","英语",BigDecimal.valueOf(87));
        StudentScore studentScore8 = new StudentScore("慕容垂","历史",BigDecimal.valueOf(87));
        studentScoreList.add(studentScore5) ;
        studentScoreList.add(studentScore6) ;
        studentScoreList.add(studentScore7) ;
        studentScoreList.add(studentScore8) ;


        StudentScore studentScore9 = new StudentScore("慕容雪","语文",BigDecimal.valueOf(79));
        StudentScore studentScore10 = new StudentScore("慕容雪","数学",BigDecimal.valueOf(79));
        StudentScore studentScore11 = new StudentScore("慕容雪","英语",BigDecimal.valueOf(77));
        StudentScore studentScore12 = new StudentScore("慕容雪","历史",BigDecimal.valueOf(77));

        studentScoreList.add(studentScore9) ;
        studentScoreList.add(studentScore10) ;
        studentScoreList.add(studentScore11) ;
        studentScoreList.add(studentScore12) ;

        // 求得每个学生的总成绩



        // 法③ Java8原生只提供了summingInt、summingLong、summingDouble三种基础类型的方法，想要对BigDecimal类型的数据操作需要自己新建工具类

        System.out.println("-----------------------------sum 3.1 ----------------------");
        Map<String,BigDecimalSummaryStatistics> studentScoreMap4 =
                studentScoreList.stream()
                        .collect(Collectors.groupingBy(StudentScore::getName ,  CollectorsUtil.summarizingBigDecimal(StudentScore::getScore))   );

        studentScoreMap4.forEach((k,v) -> System.out.println("key: " + k + " , " + "value: " + v.getSum()));


    }



    @Test
    public void testList22() {


        // 构建数据
        List<Region> regionList= new ArrayList<>();
        Region  region1 = new Region(1,"山西省","0",null,"0");
        Region  region2 = new Region(2,"晋中市","0_1","0","0");
        Region  region3 = new Region(3,"平遥县","0_1_1","0_1","1");
        Region  region4 = new Region(4,"祁县","0_1_2","0_1","1");

        Region  region5 = new Region(2,"晋城市","0_2","0","1");


        Region  region6 = new Region(5,"北京市","1",null,"0");
        Region  region7 = new Region(6,"海淀区","1_1","1","0");
        Region  region8 = new Region(6,"朝阳区","1_2","1","1");
        Region  region9 = new Region(7,"创客小镇","1_1_1","1_1","1");



        // 生成排序吗 传入：list ；传出 list
        // 格式
        //  省 001 ，002
        //  市 001.001 ，001.002
        //  县 001.001.001 ，001.001.002
        regionList.add(region1);
        regionList.add(region2);
        regionList.add(region3);
        regionList.add(region4);
        regionList.add(region5);
        regionList.add(region6);
        regionList.add(region7);
        regionList.add(region8);
        regionList.add(region9);
        // 思路：拿到 每个 region的 children ，遍历 children ，用 父 的orderCode+ 兄弟的orderCode 码最大的值 + 1
         for (Region root : regionList){
             setRegionOrderCode(regionList  , null ,  root);
         }
        System.out.println(regionList);
    }


    /**
    * 将树的所有节点放到一个list集合里
    */
    @Test
    public void testList23() {

      //|62|吴家堡街道 |吴家堡街道     |370104016000|370104000000|4

        List<Region> allRegions = regionMapper.list();
        Region searchRegion = regionMapper.getRegionByCode("370104016000");
        List<Region> resultList = new ArrayList<>();
        resultList.add(searchRegion);
        getFather( searchRegion ,  allRegions,resultList);

        System.out.println(searchRegion);

    }

    /**
     * 父到子查询
     */
    public  List<Region> getChildren( Region targetRegion , List<Region> regionResultList){

        // 末级
        if ("1".equals(targetRegion.getIsEnd())) {
            // return 代表结束当前分支，进行下一分支的逻辑
            // 递归的终止条件（很重要：节点的结束条件)
            return  new ArrayList<>();
        }

        // childrenRegionList
        List<Region> childrenRegionList = targetRegion.getChildren();

        //  需要重写 Region 的 equals 方法
        if (!regionResultList.contains(targetRegion)) {
            regionResultList.add(targetRegion);
        }

        for (Region children : childrenRegionList) {
            //  将 children 放到集合里
            if (!regionResultList.contains(children)) {
                regionResultList.add(children);
            }
            //获取children ' children
            getChildren(children , regionResultList) ;
        }

        return childrenRegionList;
    }


    /**
     * 子到父查询
     */
    public  Region getFather(Region targetRegion , List<Region> regionListFromDb,List<Region> resultList){

        Region father = null ;
        // root
        if (null ==  targetRegion.getParentCode() || "".equals(targetRegion.getParentCode())) {
            // return 代表结束当前分支，进行下一分支的逻辑
            // 递归的终止条件（很重要：节点的结束条件)
            return  father;
        }

        //get father
        String targetParentCode = targetRegion.getParentCode();

        List<Region> parentList = regionListFromDb.stream()
                .filter(region -> (null != region.getCode() && !"".equals(region.getCode())) && region.getCode().equals(targetParentCode))
                .collect(Collectors.toList());
        if (CollectionUtils.isEmpty(parentList)){
            return  father;
        }

        father = parentList.get(0);
        if (null != father){
            targetRegion.setParentRegion(father);
            // 只放一次
            if(!resultList.contains(father)){
                resultList.add(father);
            }
            //   获取祖父
             getFather(father, regionListFromDb,resultList);

        }

        return father;
    }



    /**
     * 将树的所有节点放到一个list集合里
     */
    @Test
    public void testList24() {
        System.out.println("*********************************************************************************");

        for (int a = 1;a <=3 ;a++){
            for (int b = 1;b <=3 ;b++){
                if (b==1) {
                    // break
                   return;
                }
            }
            // break 会打印 1 2 3
            // return 不会打印  1 2 3 ，直接跳出两个for 循环
            System.out.println(a);

        }
    }




    @Test
    public void reverseListTest() {

        //
        ListNode lastNode = new ListNode(3, null);

        ListNode twoNode = new ListNode();
        ListNode headNode = new ListNode(1, twoNode);
        twoNode.setData(2);
        twoNode.setNext(lastNode);


        // 遍历链表

        ListNode next = headNode.getNext();
        System.out.println(headNode.getData());

        while(null != next) {
            System.out.println(next.getData());
            // 获取下一个
            next = next.getNext();
        }

        System.out.println("翻转后的结果");

        // 翻转
        ListNode reverseHeadNode = reverseList(headNode);

        ListNode next1 = reverseHeadNode.getNext();
        System.out.println(reverseHeadNode.getData());

        while(null != next1) {
            System.out.println(next1.getData());
            // 获取下一个
            next1 = next1.getNext();
        }
    }


    public ListNode  reverseList(ListNode head){
        if (null == head) {
            return null;
        }

        // 前置节点
        ListNode prev = head;
        // 当前节点
        ListNode current = head.getNext();

        // 单链表，翻转后 翻转前的头结点的 变成尾结点，所以他的 next 设置为  null
        prev.setNext(null);

        // current 为 null ，结束循环（while 循环在不知道循环几次的情况下用）
        while(null != current){
            // 后置节点
            ListNode next = current.getNext();
            // 翻转：设置当前节点的 next 节点为  prev 节点（注意：prev 节点是要动态变 的）
            current.setNext(prev);
            // current 节点成为  下一次的 prev 节点
            prev = current;
            // next 节点成为  current节点
            current = next;
        }

        // 返回翻转后的 头节点
        return prev;

    }




    // "{}" 为true
    // "()" 为true
    // "{)" 为false
    // "{()}" 为true
    // "{(}}" 为false
    public boolean isValid(String s) {
        boolean flag = true;

        if("".equals(s) || null == s){
            return flag;
        }


        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if (c == '(' || c == '{' ) {
                // 入栈
                stack.push(c);

                // 出栈
                if (c == '(' ) {
                    if (stack.isEmpty() || stack.pop() != '(' ) {
                        return false;
                    }
                }

                if (c == '{' ) {
                    if (stack.isEmpty() || stack.pop() != '{' ) {
                        return false;
                    }
                }
            }
        }
        return flag;
    }

    @Test
    public void stackTest() {
       boolean flag =  isValid("{}");
        boolean flag2 =  isValid("(}");
        System.out.println(flag2);

    }


//    @Test
//    public void queueTest() {
//
//        List<String> picAndVideo = new ArrayList<>();
//        picAndVideo.add("v_1");
//        picAndVideo.add("v_2");
//        picAndVideo.add("v_3");
//        picAndVideo.add("v_4");
//        picAndVideo.add("p_5");
//        picAndVideo.add("p_6");
//        picAndVideo.add("v_7");
//        picAndVideo.add("v_8");
//        List<String> recommendentResult = getRecommendentResult(picAndVideo,6);
//        for (String  s : recommendentResult) {
//            System.out.println(s);
//        }
//
//    }

//
//    public List<String> getRecommendentResult(List<String> picAndVideo ,int maxInterval) {
//        List<String> result = new ArrayList<>();
//
//        if (null == picAndVideo || picAndVideo.size() == 0) {
//           return result;
//        }
//        Queue<String> videoQueue = new LinkedList<>();
//        Queue<String> picQueue = new LinkedList<>();
//        boolean firstPic = false;
//        int index = 0 ;
//        int picAndVideoSize = picAndVideo.size();
//
//        while (!firstPic && index <picAndVideoSize ) {
//
//             if (isVedio(picAndVideo.get(index))) {
//                 // 指定下标插入
//                 result.add(index,picAndVideo.get(index));
//                 index ++ ;
//             }else{
//                 firstPic = true ;
//             }
//        }
//
//        // 往队列添加
//        while ( index <picAndVideoSize ) {
//
//            if (isVedio(picAndVideo.get(index))) {
//                // 指定下标插入
//                videoQueue.add(picAndVideo.get(index));
//            }else{
//                picQueue.add(picAndVideo.get(index));
//            }
//            index ++ ;
//        }
//
//        //
//        int currentSize = result.size();
//        while(!videoQueue.isEmpty() && !picQueue.isEmpty() ){
//            if (currentSize >= maxInterval) {
//                result.add(picQueue.poll()) ;
//                currentSize = 0;
//            } else {
//                result.add(videoQueue.poll());
//                currentSize ++ ;
//            }
//        }
//
//
//        while(!videoQueue.isEmpty() ){
//            result.add(videoQueue.poll());
//        }
//
//
//        while(currentSize >= maxInterval &&  !picQueue.isEmpty() ){
//            result.add(picQueue.poll());
//        }
//        return result;
//
//    }



    @Test
    public void binarySearchTest1() {
        // 在旋转有序的数组中搜素
        int[] intArray =  new int [4];
        intArray[0] = 0 ;
        intArray[1] = 1 ;
        intArray[2] = 2 ;
        intArray[3] = 3 ;
        int index = getIndex(intArray, 1);
        System.out.println(index);

    }



    public int getIndex(int[] num,int target) {
        // 在旋转有序的数组中搜素
        if (num.length == 0) {
            return -1;
        }

        int end = num.length - 1;
        //int halfLength = length / 2;
        int middleIndex = end / 2;

        int middleValue = num[middleIndex];
        // 找到target 就设置为false
         boolean flag = true;
        // 循环条件
        while(flag){

           if (target == num[0]){
                middleIndex = 0 ;
                flag = false;

            }else if (target == num[end]){
                middleIndex = end ;
                flag = false;
            }else {
               if (target > middleValue) {
                   // target 大，说明在右边
                   // 折半
                   middleIndex =  (middleIndex + end)/2 ;
                   middleValue = num[middleIndex];

               }else if (target < middleValue) {
                   //  target 小，说明在左边
                   middleIndex =  (middleIndex + 0)/2;
                   middleValue = num[middleIndex];
                   // 末端的处理
               }else if (target  ==  middleValue) {
                   flag = false;
               }
           }

        }
        return middleIndex;

    }




    @Test
    public void bubbleSortTest1() {

//        Integer integer = Integer.valueOf("0010");
//        System.out.println(integer);

        String test = "http://10.231.134.228:8080/images/重庆龙湖卓健房地产开发有限责任公司/20200521/何川_20200521153416_退款确认书_F15BD322-55AE-4739-806E-5849629E8675.jpg";
        int i = test.lastIndexOf('/');
        String substring = test.substring(i);
        String[] split = substring.split("_");
        System.out.println( split[2]);;
        System.out.println( split[2]);;

    }



    public void bubbleSort(int[] array) {
        int length = array.length;

        // 外层循环 处理内部有  3 2  的这种
        for (int i = 0 ; i < length ;i++) {
            // 优化   for (int j =1 ;j < length - i  ;j++) {
            // 每个内层排序都会产生一个 此次排序的最大值放到 右边，但是 内部有 3 2  的这种元素
            for (int j =1 ;j < length   ;j++) {
                if (array[j-1] > array[j]) {
                    int temp = array[j-1] ;
                    array[j-1] = array[j];
                    array[j] = temp;
                }

            }

        }

    }


    @Test
    public void PathMatcherTest() {

        AntPathMatcher antPathMatcher = new AntPathMatcher();

        antPathMatcher.isPattern("/user/001");// 返回 false
        antPathMatcher.isPattern("/user/*"); // 返回 true
        antPathMatcher.match("/user/001","/user/001");// 返回 true
        boolean match = antPathMatcher.match("/user/001/002", "/user/001/002");// 返回 true
        boolean match2 = antPathMatcher.match("/user/001/002", "/user/001");// 返回 false
        antPathMatcher.match("/user/*","/user/001");// 返回 true
        antPathMatcher.matchStart("/user/*","/user/001"); // 返回 true
        antPathMatcher.matchStart("/user/*","/user"); // 返回 true
        antPathMatcher.matchStart("/user/*","/user001"); // 返回 false
        antPathMatcher.extractPathWithinPattern("uc/profile*","uc/profile.html"); // 返回 profile.html
        antPathMatcher.combine("uc/*.html","uc/profile.html"); // uc/profile.html



    }


    @Test
    public void scheduleTest() {

        //
        Boy boy1FromDb = new Boy();
        boy1FromDb.setName("王超");
        boy1FromDb.setSex(1);
        // BoyVo::new 创建 Vo
        BoyVo boy1Vo = com.example.demo.utils.BeanUtils.of(boy1FromDb, BoyVo::new);
        System.out.println(" boy1Vo ------ "+boy1Vo.toString());
        BoyVo boy2Vo = com.example.demo.utils.BeanUtils.of(boy1FromDb, BoyVo::new);
        System.out.println(" boy2Vo ------ "+boy2Vo.toString());
        // false
        System.out.println(boy1Vo == boy2Vo);

        List<Boy> sourceList = new ArrayList<>();
        Boy boy2FromDb = new Boy();
        boy2FromDb.setName("王超2");
        boy2FromDb.setSex(2);
        sourceList.add(boy2FromDb);
        System.out.println(" sourceList ------ "+sourceList.toString());
        // of  内部首先会创建一个  List<T> list ；BoyVo::new 创建Vo
        List<BoyVo> resultList = com.example.demo.utils.BeanUtils.of(sourceList, BoyVo::new);

        System.out.println(" resultList ------ "+resultList.toString());




    }



    @Test
    public void AA() {

        StringBuilder sb = new StringBuilder();
        System.out.println("ttttttttttttttttt");
        System.out.println(sb.toString());
        System.out.println(sb.toString());






    }


    /**
     * 将树的所有节点放到一个list集合里
     */
    @Test
    public void testList26() {

        // 构建数据
        List<Region> regionTree = new ArrayList<>();

        Region  region1 = new Region(1,"山西省","0",null,"0");
        Region  region2 = new Region(2,"晋中市","0_1","0","0");
        Region  region3 = new Region(3,"平遥县","0_1_1","0_1","1");
        Region  region4 = new Region(4,"祁县","0_1_2","0_1","1");

        Region  region5 = new Region(2,"晋城市","0_2","0","1");
        List<Region> jinzhongChildren = new ArrayList<>();
        jinzhongChildren.add(region3);
        jinzhongChildren.add(region4);
        region2.setChildren(jinzhongChildren);

        List<Region> shanxiChildren = new ArrayList<>();
        shanxiChildren.add(region2);
        shanxiChildren.add(region5);
        region1.setChildren(shanxiChildren);

        Region  region6 = new Region(5,"北京市","1",null,"0");
        Region  region7 = new Region(6,"海淀区","1_1","1","0");
        Region  region8 = new Region(6,"朝阳区","1_2","1","1");
        Region  region9 = new Region(7,"创客小镇","1_1_1","1_1","1");

        List<Region> haidianChildren = new ArrayList<>();
        haidianChildren.add(region9);
        region7.setChildren(haidianChildren);

        List<Region> beijingChildren = new ArrayList<>();
        beijingChildren.add(region7);
        beijingChildren.add(region8);
        region6.setChildren(beijingChildren);

        regionTree.add(region1);
        regionTree.add(region6);
        System.out.println(regionTree);


        // 存放结果集，
        List<Region> regionList= new ArrayList<>();
        for (Region region : regionTree){
            getChildren( region , regionList) ;
        }


        System.out.println(regionList);

    }


    /**
     * list 存放 没有重复元素的集合（不推荐用法）
     */
    @Test
    public void testList27() {

        Region  region1 = new Region(5,"北京市","1",null,"0");
        Region  region2 = new Region(5,"北京市","1",null,"0");
        Region  region3 = new Region(5,"北京市","1",null,"0");

        List<Region> AllRegionList = new ArrayList<>();
        AllRegionList.add(region1);
        AllRegionList.add(region2);
        AllRegionList.add(region3);


        List<Region> noRepeateRegionList = new ArrayList<>();
        for (Region region : AllRegionList){
            if (!noRepeateRegionList.contains(region)){
                noRepeateRegionList.add(region);
            }
        }


        System.out.println(AllRegionList);
        System.out.println(noRepeateRegionList);

    }



    /**
     * set 转 list (推荐用法)
     */
    @Test
    public void testList28() {


        Region  region1 = new Region(5,"北京市","1",null,"0");
        Region  region2 = new Region(5,"北京市","1",null,"0");
        Region  region3 = new Region(5,"北京市","1",null,"0");


        Set<Region> regionSet = new HashSet<>();
        regionSet.add(region1);
        regionSet.add(region2);
        regionSet.add(region3);


        // 存放结果集
        List<Region> noRepeateRegionList = new ArrayList<>(regionSet);

        System.out.println(regionSet);

        System.out.println(noRepeateRegionList);

    }



    /**
     * 糊涂 工具包
     */
    @Test
    public void testList29() {


        Region  region1 = new Region(5,"北京市","1",null,"0");
        Region  region2 = new Region(5,"北京市","1",null,"0");
        Region  region3 = new Region(5,"北京市","1",null,"0");


        List<Region> regionList = new ArrayList<>();
        regionList.add(region1);
        regionList.add(region2);
        regionList.add(region3);


//
//        List<Region> regionList0 = regionList.stream().map(x -> BeanUtil.toBeanIgnoreCase(x, XSRefundVO.class, true))
//                .collect(Collectors.toList());
//



    }




    /**
     * 糊涂 工具包
     */
    @Test
    public void testList30() {

        List<Region> list = new ArrayList<>() ;
        Region  region1 = new Region(5,"北京市","1",null,"0");
        Region  region2 = new Region(6,"上海市","1",null,"0");
        Region  region3 = new Region(7,null,"1",null,"0");
        list.add(region1);
        list.add(region2);
        list.add(region3);


//        Map<Integer, String> collect = list.stream().collect(Collectors.toMap(Region::getId, Region::getName));
//        System.out.println(collect);

        Map<Integer, String> collect = new HashMap<>() ;
        for (Region r : list){
            collect.put(r.getId(),r.getName());

        }

        System.out.println(collect);





    }





    /**
     * 重写 equals（两个对象属性一样，就认为是同一个业务对象）
     * 重写  hashCode ，两个对象属性一样 ，,就应该是  一个业务对象，放到 map 里就应该 是一个  槽位子  ， 就应该重写  hashCode
     */
    @Test
    public void testList31() {

        Student student0 = new Student("jack","11","aaa");

        Student student1 = new Student("JACK","11","AAA");
        System.out.println(student0.equals(student1));
        int i = student0.hashCode();
        int i1 = student1.hashCode();
        System.out.println("i  value : "+i);
        System.out.println("i1  value : "+i1);
        System.out.println("i  和  i1  比较 result  : "  );
        // true
        System.out.println(i == i1);

        Map<Student,Student>  studentMap = new  HashMap<>() ;
        studentMap.put(student0,student0);
        //
        System.out.println("是否含有key");
        // 重写 hashCode 方法，equals判断一样，就认为一个对象，两个对象生成的hashcode 一样
        System.out.println(studentMap.containsKey(student1));;
        System.out.println("--------");




        StudentNoOverwrite student01 = new StudentNoOverwrite("jack","11","aaa");

        StudentNoOverwrite student11 = new StudentNoOverwrite("JACK","11","AAA");


        Map<StudentNoOverwrite,StudentNoOverwrite>  studentNoOverWriteMap = new  HashMap<>() ;
        studentNoOverWriteMap.put(student01,student01);
        //
        System.out.println("是否含有key");
        // 不重写 hashCode 方法，equals判断一样，一个业务对象，但是没有 重写hashCode ， 两个对象生成的hashcode 不一样 ，返回 false，本来以为可以从map 拿到
        // 结果 拿不到 值
        System.out.println(studentNoOverWriteMap.containsKey(student11));;
        System.out.println("--------");



    }


    @SneakyThrows
    @Test
    public void testList32() {

        // windows  C:\Users\dell\AppData\Local\Temp
        File location =  new  File(System.getProperty("java.io.tmpdir"));

        // sizeThreshold: The threshold (阈值 ) above which uploads will be stored on disk.
        // 封装了临时文件的全路径（包括文件名）
        FileItem item = new DiskFileItem("hh", "image/png",
                false, "fileName.jpg", 1, location);
        OutputStream outputStream = null;
        try {
            //  生成 临时文件 File 对象 和 临时文件名称 （以  .temp  后缀命名）
            outputStream = item.getOutputStream();

            // 写入内容
            // 查看 实际走的OutputStream 接口的  哪个实现类
            // class org.apache.tomcat.util.http.fileupload.DeferredFileOutputStream
            System.out.println(outputStream.getClass());
            // DeferredFileOutputStream  父类的 write 方法
            outputStream.write("DCTK_2021080300011234565432123456543234565432234543234543234543234554323456".getBytes(StandardCharsets.UTF_8));
            ApplicationPart part = new ApplicationPart(item, location);


            MultipartFile multipartFile =  new StandardMultipartFile2(part,"hh");
            System.out.println(multipartFile);

            // multipartFile.getInputStream();

            String s = new String(multipartFile.getBytes());
            System.out.println(s);
            // 删除临时文件(断点 知道  DeferredFileOutputStream  里面 有 path 属性)
            DeferredFileOutputStream outputStream1 = (DeferredFileOutputStream) outputStream;
            System.out.println(" 绑定的目录 为：");
            System.out.println( ((DeferredFileOutputStream) outputStream).getFile().getPath());
            // 生成虚引用 对象
            FileCleaner.getInstance().addTracker(outputStream1.getFile().getPath(), multipartFile);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //  必须关闭 流 ；否则对象回收不了
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.gc();

        System.exit(0);

    }










    @Test
    public void BeanToMapTest() {
        Log log = new Log();
        log.setName("hh");
        log.setLastValue("lastvalue");


        // 用反射创建一个对象并复制属性值
        LogVo logVo = BeanUtil.toBean(log, LogVo.class);
        System.out.println(logVo);
        System.out.println(logVo);


        // 复制属性值给  bean
        LogVo logVoCopyProperties = new  LogVo();
        BeanUtil.copyProperties(log,logVoCopyProperties);
        System.out.println(logVoCopyProperties);
        System.out.println(logVoCopyProperties);


        // 复制属性值给  map
        Map<String, String> map = MapUtil.newHashMap();
        BeanUtil.copyProperties(log,map);
        System.out.println(map);


    }



    @Test
    public void CovertTest() {
       // Object[] a = {"a", "你", "好", "", 1};
        Object[] a = null ;
        // 将数组转集合 (需要 判断 空)
        //List<?> list01 = Arrays.asList(a);

        // 不需要 判断 null ,如果是 null 返回的 是 null
        List<?> list0 = Convert.convert(List.class, a);
        //从4.1.11开始可以这么用 （内部有非空判断）
        List<?> list1 = Convert.toList(a);


        // 字符串 转  LocalDateTime
        LocalDateTime localDateTime1 = Convert.toLocalDateTime("2020-08-14");
        LocalDate localDate = localDateTime1.toLocalDate();

        System.out.println(localDateTime1);
        System.out.println(localDate);



    }


    @Test
    public void MoneyTest() {
     // 金额大小写转换

        //结果为："陆万柒仟伍佰伍拾陆元叁角贰分"
        String digitUppercase1 = Convert.digitToChinese(BigDecimal.valueOf(67556.00d));
        String digitUppercase2 = Convert.digitToChinese(BigDecimal.valueOf(67556.01d));
        System.out.println(digitUppercase1);
        System.out.println(digitUppercase2);

    }



    @Test
    public void IOTest() throws IOException {

        FileUtil.newFile("d:/test.txt");
        FileUtil.newFile("d:/test2.txt");
        // 拷贝(u盘 ，磁盘 etc)
        // 将 test.txt 的内容 拷贝到  test2
        BufferedInputStream in = FileUtil.getInputStream("d:/test.txt");
        BufferedOutputStream out = FileUtil.getOutputStream("d:/test2.txt");
        // 最底层是个 while 循环 ，读一部分，写入到 另一个地方，此方法也不需要 进行关闭流的操作，因为已经封装了
        // 底层代码:
        //  while((readSize = in.read(buffer)) != -1) {
        //                out.write(buffer, 0, readSize);
        //                size += (long)readSize;
        //                out.flush();
        //                if (null != streamProgress) {
        //                    streamProgress.progress(size);
        //                }
        //            }
        long copySize = IoUtil.copy(in, out, DEFAULT_BUFFER_SIZE);


        // copy(InputStream in, OutputStream out)


        // 用工具包
        // BufferedOutputStream out2 = FileUtil.getOutputStream("d:/test2.txt");
        // 自己 new 一个输出流对象
         BufferedOutputStream out2 =  new BufferedOutputStream(new FileOutputStream(new  File("d:/test2.txt")));
         IoUtil.copy(new ByteArrayInputStream("hhhhhhhhhhhhhhhhhh".getBytes()),out2,DEFAULT_BUFFER_SIZE);


        // 可以正常写入
         BufferedOutputStream out3 =  new BufferedOutputStream(new FileOutputStream(new  File("d:/test2.txt")));
         IoUtil.copy(new ByteArrayInputStream("您好a!".getBytes()),out3,DEFAULT_BUFFER_SIZE);


        // 汉字
        OutputStreamWriter out4 =  new OutputStreamWriter(new FileOutputStream(new  File("d:/test2.txt")),CharsetUtil.CHARSET_UTF_8);
        long copy = IoUtil.copy(new InputStreamReader(new ByteArrayInputStream("您好!".getBytes(CharsetUtil.CHARSET_UTF_8))), out4, DEFAULT_BUFFER_SIZE);



        // method
        // byte[] readBytes(InputStream in)
        // 说明：读取一个 流()

        // 不使用工具，自己写
        // ① 获取输入流
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("您好a!".getBytes());

        // ② 创建缓存字节数组，用来存放 从流读取的内容 （假设这个区域很大）
        byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];

        // ③ 读取流 并将内容 放到 buffer 字节数组缓存里
        int read = byteArrayInputStream.read(buffer);

        String result = new String(buffer);
        System.out.println(result);
        System.out.println(result);
        // 上述方法的缺点： 如果读取的内容过大 会有数据丢失情况

        // 使用工具
        ByteArrayInputStream byteArrayInputStream3 = new ByteArrayInputStream("您好a!".getBytes());
//        底层 实现：
//        byte[] buffer = new byte[bufferSize];
//        if (null != streamProgress) {
//            streamProgress.start();
//        }
//
//        long size = 0L;
//
//        int readSize;
//        try {
//            while((readSize = in.read(buffer)) != -1) {
//                out.write(buffer, 0, readSize);
//                size += (long)readSize;
//                out.flush();
//                if (null != streamProgress) {
//                    streamProgress.progress(size);
//                }
//            }
//        } catch (IOException var8) {
//            throw new IORuntimeException(var8);
//        }


        // 然后  out.toByteArray()
        byte[] bytes = IoUtil.readBytes(byteArrayInputStream3);
        String result2 = new String(bytes);
        System.out.println(result2);


    }

    @Test
    public void StringTest() throws IOException{

        String template = "{}爱{}，就像老鼠爱大米";
        String str = StrUtil.format(template, "我", "你"); //str -> 我爱你，就像老鼠爱大米
        System.out.println(str);


    }


    @Test
    public void Test37() throws IOException{

        Log log = new Log();
        System.out.println(log);



    }



    @Test
    public void Test38() throws IOException{

        String  PICTURE_CRM_URI = "crm3" ;
        String  endPoint = "crm333" ;
        String  OLD_DATA = "old" ;

        String str = "old";

//        String posUrl = Arrays.stream(str.split("|")).filter(ele -> ele.contains("IMG"))
//                .collect(Collectors.joining("|"));


        String posUrl = Arrays.stream(str.split("\\|")).filter(ele -> (!ele.contains(PICTURE_CRM_URI)  && !ele.contains(endPoint) &&  !ele.contains(OLD_DATA) ))
                .collect(Collectors.joining("|"));

        System.out.println(posUrl);



    }




    @Test
    public void supplyAsyncTest() throws IOException, ExecutionException, InterruptedException {
        System.out.println("main  thread ......"+Thread.currentThread().getName());
        // 带返回值的
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("run start ...");
            System.out.println("task  thread ......"+Thread.currentThread().getName());
            System.out.println("run end ...");
            // 返回执行结果
            return 1;
        });
//        Integer result = future.get();
//        System.out.println("result = "+result);

    }





    /**
    * @Description:  计算结果完成时的回调方法
    * @Param:
    * @return:
    * @Author: guoyiguang
    * @Date:
    */
    @Test
    public void whenCompleteTest() throws IOException, ExecutionException, InterruptedException {
        System.out.println("main  thread ......"+Thread.currentThread().getName());
        String  token = "token123456789" ;
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("run start ...");
            Long i = 0L;
            while(i<500L){
                System.out.println("task  thread ......"+Thread.currentThread().getName());
            }
            System.out.println(token);
            System.out.println("run end ...");
            // 返回执行结果
            i++;
            return 1;
        });
        //  主线程陷入阻塞
        Integer result = future.get();
        System.out.println("result = "+result);



        // whenCompleteAsync
        future.whenComplete(new BiConsumer<Integer, Throwable>() {
            @Override
            public void accept(Integer t, Throwable action) {
                System.out.println("执行完成！ thread name  为  "+Thread.currentThread().getName());
            }

        });
        future.exceptionally(new Function<Throwable, Integer>() {
            @Override
            public Integer apply(Throwable t) {
                System.out.println("执行失败！"+t.getMessage());
                return null;
            }
        });

    }



    /**
     * @Description:  计算结果完成时的回调方法
     * @Param:
     * @return:
     * @Author: guoyiguang
     * @Date:
     */
    @Test
    public void whenCompleteTest1() throws IOException, ExecutionException, InterruptedException {
        System.out.println("main  thread ......"+Thread.currentThread().getName());
        String  token = "token123456789" ;
        CompletableFuture<Integer> future =   CompletableFuture.supplyAsync(() -> {

            System.out.println("run start ...");
            Long i = 0L;
            while(i<500L){
                // int i1 = 1 / 0;
                throw new RuntimeException("hhhhhh");
            }
            System.out.println(token);
            System.out.println("run end ...");

            // 返回执行结果
            i++;
            return 1;
       }).exceptionally(ex->{
            String message = ex.getMessage();
            System.out.println(message);
            return 0 ;

        });




//        future.exceptionally(new Function<Throwable, Integer>() {
//            @Override
//            public Integer apply(Throwable t) {
//                System.out.println("exception "+Thread.currentThread().getName());
//
//                System.out.println("执行失败！"+t.getMessage());
//
//
//                return null;
//            }
//        });

        Integer integer = future.get();
        System.out.println(integer);
        boolean done = future.isDone();

        System.out.println(done);

        boolean completedExceptionally = future.isCompletedExceptionally();
        System.out.println(completedExceptionally);







    }



    /**
     * @Description:  计算结果完成时的回调方法
     * @Param:
     * @return:
     * @Author: guoyiguang
     * @Date:
     */
    @Test
    public void whenCompleteTest2() throws IOException, ExecutionException, InterruptedException {
        System.out.println("main  thread ......"+Thread.currentThread().getName());
        String  token = "token123456789" ;
        CompletableFuture<Integer> future =   CompletableFuture.supplyAsync(() -> {
            System.out.println("run start ...");
            Long i = 0L;
            while(i<500L){
                throw BizException.wrap("hhhhhh");
            }
            System.out.println(token);
            System.out.println("run end ...");

            // 返回执行结果
            i++;
            return 1;
        });






        try {
            Integer integer = future.get();
            // 获取异常信息
        }catch (ExecutionException  e) {
            System.out.println(e.getMessage());
            System.out.println(e.toString());;
            System.out.println(e.toString());;
        } catch (BizException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }










    }


    @Test
    public void whenCompleteTest3() throws IOException, ExecutionException, InterruptedException, IllegalAccessException, InstantiationException {
        // executor
        System.out.println("main  thread ......"+Thread.currentThread().getName());
        String  token = "token123456789" ;

        Future<Integer> future = executor.submit(new Callable<Integer>() {
            public Integer call() {
                // 以异步方式在新的线程中执行耗时的操作
                Long i = null;
                try {
                    System.out.println("run start ...");
                    i = 0L;
                    while(i<500L){
                        throw BizException.wrap("hhhhhh");
                    }
                    System.out.println(token);
                    System.out.println("run end ...");
                } catch (BizException e) {

                   return 0 ;
                }

                // 返回执行结果
                i++;
                return 1;
            }
        });


        try {
            // 获取异步操作的结果，如果最终被阻塞，无法得到结果，那么在最多等待1秒钟之后退出
            Integer result = future.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException ie) {
        } catch (ExecutionException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getMessage());

        } catch (TimeoutException e) {
        }











    }



    @Test
    public void whenCompleteTest4() throws IOException, ExecutionException, InterruptedException, IllegalAccessException, InstantiationException {
        // executor
        System.out.println("main  thread ......"+Thread.currentThread().getName());
        String  token = "token123456789" ;





        CompletableFuture completableFuture = new CompletableFuture<>();

        new Thread(() -> {
            try {
                System.out.println("run start ...");
                Long i = 0L;
                while(i<=500){
                    if (i==500L){
                        throw BizException.wrap("hhhhhh");
                    }

                    // 返回执行结果
                    i++;
                }
                System.out.println(token);
                System.out.println("run end ...");


            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.getMessage());
                System.out.println(e.getMessage());
                completableFuture.completeExceptionally(e);
            }
        }).start();

        System.out.println("main thread ......");
        System.out.println("main thread ......");












    }





    @Test
    public void test390() throws IOException, ExecutionException, InterruptedException {

        ConcurrentHashMap<String, String> BEAN_COPIER_MAP = new ConcurrentHashMap<>();
        String key = "hhhh";
//        String hh1 = BEAN_COPIER_MAP.put(key, "");
//        String hh2 = BEAN_COPIER_MAP.computeIfAbsent(key, e->null);

//        String hh = BEAN_COPIER_MAP.computeIfAbsent(key, k -> BEAN_COPIER_MAP.put(key, "aaa"));
//
//
//        System.out.println(hh);

        String hh2 = BEAN_COPIER_MAP.computeIfAbsent(key, k -> BEAN_COPIER_MAP.put(key, "hh"));
        //String hh3 = BEAN_COPIER_MAP.putIfAbsent(key, k -> BEAN_COPIER_MAP.put(key, "hh"));


        Thread.currentThread().interrupt();
        System.out.println("hh");
        throw new RuntimeException("hh");

    }


















    /**
     * @Description:  当一个线程依赖另一个线程时，可以使用 thenApply 方法来把这两个线程串行化。
     * @Param: Function<? super T, ? extends U>
     * T：上一个任务返回结果的类型
     * U：当前任务的返回值类型
     * 适用场景 :第二个任务依赖第一个任务的结果
     * @Author: guoyiguang
     * @Date:
     */
    @Test
    public void thenApplyTest() throws IOException, ExecutionException, InterruptedException {
        System.out.println("main  thread ......"+Thread.currentThread().getName());

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("run1 start ...");
            System.out.println("task  thread ......"+Thread.currentThread().getName());
            System.out.println("run1 end ...");
            // 返回执行结果
            return 1;
            // thenApply 同步
        }).thenApplyAsync(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer t) {
                System.out.println("run2 start ...");
                System.out.println("task  thread ......"+Thread.currentThread().getName());
                // t 是 上述线程的执行结果
                Integer result = t*5;
                System.out.println("result2="+result);
                System.out.println("run2 end ...");
                return result;
            }
        });


        Integer result = future.get();
        System.out.println("result = "+result);

    }




    @Test
    public void throwTest() throws IOException, ExecutionException, InterruptedException {

       List  list = new ArrayList();
        list.add("123456");
        list.add("123456");
        list.add("123456");

        Set<String> set = new HashSet<>(list);
        System.out.println(set);
        System.out.println(set);

    }









    @Test
    public void returnTest()  {
        System.out.println(" returnTest main  thread ......"+Thread.currentThread().getName());

        Integer result = getReturn(() -> {
            System.out.println("aaaaa");
            System.out.println("hhhhhh");
            return 1;
        });
        System.out.println(result);
        System.out.println(result);
    }

    public <U> U getReturn(Supplier<U> supplier){


        return supplier.get();


    }


    @Test
    public void returnTest2()  {
        System.out.println(" returnTest2 main  thread ......"+Thread.currentThread().getName());

        // Consumer  的 accept 消费一个对象(业务逻辑)
        Consumer<Integer> consumer = new Consumer<Integer>() {
            // 不带有返回值
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
                System.out.println("aaaaa");
                System.out.println("hhhhhh");

            }
        };
        // 开始调用 目标方法
        consumer.accept(1);

    }



    @Test
    public void returnTest3()  {

        Set<String> projectGuidSet = new HashSet<>();
        for (int i = 0;i<= 2; i++ ){

            projectGuidSet.add(i+"");
        }


        String[] prIdList = projectGuidSet.toArray(new String[0]);
        System.out.println(prIdList);
        System.out.println(prIdList);
    }


    @Test
    public void returnTest4()  {
        String str = null;
        // Hi,小超
        str=String.format("Hi,%s", "小超");
        System.out.println(str);
        // Hi,小超 是个 大帅哥
        str=String.format("Hi,%s %s %s", "小超","是个","大帅哥");
        System.out.println(str);



    }



    @Test
    public void crossJoinTest()  {

        List<Org> stageList =  new ArrayList<>();
        Org org1 = new Org();
        org1.setCode("001");
        Org org2 = new Org();
        org2.setCode("002");
        Org org3 = new Org();
        org3.setCode("003");

        stageList.add(org1);
        stageList.add(org2);
        stageList.add(org3);

       List<String>  subjectList = new ArrayList<>() ;
        subjectList.add("subject_001");
        subjectList.add("subject_001");


        // 不消除笛卡尔： 结果集 3*2 ; 两个集合只要有一个是空集合，结果是空
        // 等同于：
        //  List<BudgetResult> budgetResults = new ArrayList<>();
//        if(!CollectionUtils.isEmpty(stageList) && !CollectionUtils.isEmpty(subjectList)){
//            // for (Org org:stageList){
//            //  for(String s : subjectList){
//            //    BudgetResult budget = new BudgetResult();
//            //    budgetResults.add(budget);
//            //
//            //  }
//            //
//            // }
//
//        }

        List<BudgetResult> budgetResults = Linq.of(stageList)
                .crossJoin(Linq.of(subjectList),
                        (stage, subject) -> {
                            BudgetResult dto = new BudgetResult();
                            dto.setStageCode(stage.getCode());
                            dto.setSubjectCode(subject);
                            return dto;
                        })
                .toList();

        System.out.println(budgetResults);
        System.out.println(budgetResults);


    }


    @Test
    public void leftJoinTest()  {

        List<Org> stageList =  new ArrayList<>();
        Org org1 = new Org();
        org1.setCode("001");
        Org org2 = new Org();
        org2.setCode("002");
        Org org3 = new Org();
        org3.setCode("003");

        stageList.add(org1);
        stageList.add(org2);
        stageList.add(org3);

        List<Bu>  butList = new ArrayList<>() ;
        Bu bu = new  Bu();
        bu.setCode("001");
        butList.add(bu);


        Bu bu2 = new  Bu();
        bu2.setCode("002");
        butList.add(bu2);

        Bu bu4 = new  Bu();
        bu4.setCode("004");
        butList.add(bu4);


        // a left join b  on a.column = b.column
        // 等同于：
          List<BudgetResult> budgetResults = new ArrayList<>();
       if(!CollectionUtils.isEmpty(stageList) ){
           for (Org org : stageList){
               //① b 表满足条件的数据
             List<Bu>  sameBuList = new ArrayList<>() ;
               Bu bu001 = new  Bu();
               bu001.setCode("001");
               sameBuList.add(bu001);
               if (!CollectionUtils.isEmpty(sameBuList) && (org.getCode().equals("001") || org.getCode().equals("002"))){
                   for(Bu bu5 : sameBuList){
                       BudgetResult budget = new BudgetResult();
                       budget.setSubjectCode(bu5.getCode());
                       budget.setStageCode(org.getCode());
                       budgetResults.add(budget);

                   }

                   // ② b 表 没有满足条件的数据
               }else{
                   BudgetResult budget = new BudgetResult();
                   budget.setSubjectCode(null);
                   budget.setStageCode(org.getCode());
                   budgetResults.add(budget);
               }
           }


        }



//        等效于  如上的 方法
//        List<BudgetResult> budgetResults = Linq.of(stageList)
//                .leftJoin(Linq.of(butList),
//                        // ps 关联条件
//                        Org::getCode,
//                        Bu::getCode,
//                        null,
//                        (stage, bu0) -> {
//                            BudgetResult join = new BudgetResult();
//                            join.setStageCode(stage.getCode());
//                            if (null != bu0){
//                                join.setSubjectCode(bu0.getCode());
//                            }
//
//                            return join;
//                        })
//                .toList();

        // [
        // BudgetResult(stageCode=001, subjectCode=001),
        // BudgetResult(stageCode=002, subjectCode=002),
        // BudgetResult(stageCode=003, subjectCode=null)
        // ]
        System.out.println(budgetResults);
        System.out.println(budgetResults);


    }
































































    public  List<Region> getFatherList(List<Region> sourceRegionList ,Region targetRegion){
        List<Region>  fatherList =  sourceRegionList.stream()
                .filter(region ->(null != targetRegion.getParentCode() &&  targetRegion.getParentCode().equals(region.getCode())) )
                .collect(Collectors.toList());
        return fatherList;
    }

    public  List<Region> getBrotherList(List<Region> sourceRegionList ,Region targetRegion){

        List<Region> fatherList = getFatherList(sourceRegionList, targetRegion);
        // 根目标处理
        if (null == targetRegion.getParentCode()) {
            List<Region>  brotherList =  sourceRegionList.stream()
                    .filter(region1 -> null == region1.getParentCode())
                    .filter(region2 ->( !targetRegion.getCode().equals(region2.getCode()) && !StringUtils.isEmpty(region2.getOrderCode())))
                    .sorted((r1,r2)->r1.getOrderCode().compareTo(r2.getOrderCode()))
                    .collect(Collectors.toList());
            return brotherList;
        }else{
            // 非根目标处理
            Region fatherRegion = fatherList.get(0);
            List<Region>  brotherList =  sourceRegionList.stream()
                    .filter(region1 -> (null != region1.getParentCode() && region1.getParentCode().equals(fatherRegion.getCode()) && !StringUtils.isEmpty(region1.getOrderCode())))
                    .filter(region2 -> !targetRegion.getCode().equals(region2.getCode()))
                    .sorted((r1,r2)->r1.getOrderCode().compareTo(r2.getOrderCode()))
                    .collect(Collectors.toList());
            return brotherList;
        }
    }

    public  String  getBrotherMaxOrderCode(List<Region> sourceRegionList ,Region targetRegion){
        List<Region>  brotherList =  getBrotherList(sourceRegionList,targetRegion);
        Region brother = new Region();
        if (!CollectionUtils.isEmpty(brotherList)) {
            brother =  brotherList.get(brotherList.size()-1);
        }
        if (null != brother.getOrderCode() &&  !"".equals(brother.getOrderCode())){
            // 截取字符串最后三位字符
            String lastThree = brother.getOrderCode().substring(brother.getOrderCode().length()-3);
            // 去掉 0 获取 String 类型 的 num
            String  brotherOrderCode = lastThree.replace("0","");
            System.out.println(Integer.valueOf(brotherOrderCode));
            return brotherOrderCode ;
        }else{
            // brothers 目前没有 orderCode 的值，那么就认为  brothers  的 orderCode 值为 "0"
            return "0";
        }
    }




    public  List<Region> setRegionOrderCode(List<Region> sourceRegionList  ,Region fatherRegion , Region targetRegion){

        // 末级
        if ("1".equals(targetRegion.getIsEnd())) {
            // 递归的终止条件（很重要：节点的结束条件），返回 return 才会 进行下一个分支的循环
            return  new ArrayList<>();
        }

        // 非末级
        List<Region> childrenRegionList = sourceRegionList.stream()
                .filter(region ->( null != region.getParentCode() &&  region.getParentCode().equals(targetRegion.getCode())) )
                .collect(Collectors.toList());

        // 获取兄弟节点的orderCode（如果 兄弟节点 的 orderCode 都为null ，默认给个 "0"）
        String brotherMaxOrderCode = getBrotherMaxOrderCode(sourceRegionList, targetRegion);
        // 设置 targetRegion 的 orderCode
        if (null == targetRegion.getParentCode()){
            // 兄弟节点 是 0 ，那么自身的 orderCode 为 0+1 =1
            targetRegion.setOrderCode(fullOrderCode("",String.valueOf(Integer.valueOf(brotherMaxOrderCode)+1)));
        }else{
            // orderCode  为 null 才会 set值，否则跳过
            if (null == targetRegion.getOrderCode() ||  "".equals(targetRegion.getOrderCode())) {
                targetRegion.setOrderCode(fullOrderCode(fatherRegion.getOrderCode(),String.valueOf(Integer.valueOf(brotherMaxOrderCode)+1)));
            }
        }

        for (Region children : childrenRegionList) {
            String brotherMaxOrderCode2 = getBrotherMaxOrderCode(sourceRegionList, children);
            // 设置 children 的orderCode
            children.setOrderCode(fullOrderCode(targetRegion.getOrderCode(),String.valueOf(Integer.valueOf(brotherMaxOrderCode2)+1)));
            //获取children ' children
            setRegionOrderCode(sourceRegionList  ,targetRegion, children);

        }

        return childrenRegionList;
    }

    public String fullOrderCode(String parentOrderCode,String orderCode){
        String resultOrderCode = "";
        if (orderCode.length() == 1) {
            if ("".equals(parentOrderCode)) {
                resultOrderCode = "00"+orderCode;
            }else{
                resultOrderCode = parentOrderCode+".00"+orderCode;
            }
        }else if(orderCode.length() == 2){
            if ("".equals(parentOrderCode)) {
                resultOrderCode = "0"+orderCode;
            }else{
                resultOrderCode = parentOrderCode+".0"+orderCode;
            }
        }else if(orderCode.length() == 3){
            if ("".equals(parentOrderCode)) {
                resultOrderCode = orderCode;
            }else{
                resultOrderCode = parentOrderCode+"."+orderCode;
            }
        }
        return resultOrderCode;

    }


































}
