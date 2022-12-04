package com.example.demo;


import com.alibaba.druid.sql.visitor.functions.Char;
import com.example.demo.entity.*;
import com.example.demo.entity.Vo.BoyVo;
import com.example.demo.entity.Vo.RoomDto;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.mapper.QuestionMapper;
import com.example.demo.service.Impl.BigDecimalSummaryStatistics;
import com.example.demo.utils.CollectorsUtil;
import com.github.pagehelper.Page;
import com.sun.beans.TypeResolver;
import com.sun.beans.finder.MethodFinder;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;
import org.springframework.util.PathMatcher;
import org.springframework.util.StringUtils;
import sun.reflect.misc.ReflectUtil;

import java.beans.Introspector;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    private final PathMatcher pathMarch = new AntPathMatcher();


    @Autowired
    QuestionMapper questionMapper;


    @Autowired
    OrderMapper orderMapper;


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
        o3.setDescription("b   333333333333333");

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
    public void testNull() {

        Order order = new  Order();
        order.setName(null);
        System.out.println("234545");

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
    public void testBigDecimal() {

//        BigDecimal bigDecimal = BigDecimal.valueOf(0.01);
//        BigDecimal bigDecimal2 = BigDecimal.valueOf(0.02);
//        bigDecimal2.add(bigDecimal);
//        BigDecimal add = bigDecimal2.add(bigDecimal);
//        System.out.println(bigDecimal2);
//        System.out.println(add);

          Integer i = new Integer(1) ;
          String s = "1" ;
        System.out.println(i.equals(s));
        System.out.println(i.equals(s));

    }


    @Test
    public void testPayForm() {


      List<Integer>  payItems = new ArrayList();
//        5000 1500 50000 3500
        payItems.add(1500);
      payItems.add(50000);
      payItems.add(3500);


     Integer dingjin = 5000;
//        Integer dingjin = 310;

      List<Integer>  lastItems = new ArrayList();

      Integer weikouchudedingjin = dingjin;

      for (Integer in : payItems) {

          if (in-weikouchudedingjin>=0) {
              if (weikouchudedingjin > 0){
                  // 第一笔
                  // 定金的付款日期固定为认购当天
                  lastItems.add(dingjin);
                  // TODO 加判断 非0
                  if (in-weikouchudedingjin > 0) {
                      lastItems.add(in-weikouchudedingjin) ;
                  }
                  weikouchudedingjin= 0;
                  continue;
              }

              if (in-weikouchudedingjin == 0) {
                  // 第一笔
                  lastItems.add(dingjin);
                  weikouchudedingjin= 0;
              }
              // 其他
              if (in-weikouchudedingjin>0) {
                  lastItems.add(in);
              }

          }else{
              weikouchudedingjin =  weikouchudedingjin - in;
          }

      }


        System.out.println(lastItems);
        System.out.println(lastItems.size());


    }

    @Test
    public void tetstAtomic() {
        List<Integer> list = new ArrayList<>();
        AtomicInteger ai = new AtomicInteger(1);
        for (int a = 0 ; a <  6;a++) {
            list.add(ai.getAndIncrement());
        }
        System.out.println(list);

    }




    @Test
    public void testSort() {
       List<Order> list = new ArrayList<>();

        Order o1 = new Order();
        o1.setId(16);
        o1.setDescription("b");
        o1.setName("1");


        Order o2 = new Order();
        o2.setId(16);
        o2.setDescription("b");
        o2.setName("2");





        Order o3 = new Order();
        o3.setId(16);
        o3.setDescription("b");
        o3.setName("3");



        Order o4 = new Order();
        o4.setId(18);
        o4.setDescription("c");
        o4.setName("1");


        list.add(o3);
        list.add(o2);
        list.add(o1);
        list.add(o4);


//        list.sort(Comparator.comparing(Order::getId)
//                .thenComparing((Order::getDescription)
//                ).thenComparing(Order::getName));


//        list.sort(Comparator.comparing((a ,b) ->a.get)
//                .thenComparing((Order::getDescription)
//                ).thenComparing(Order::getName));

//        Collections.sort(list, Comparator.comparing(Order::getId).thenComparing(Order::getDescription).reversed());
//        employees.forEach(System.out::println);


        System.out.println(list);

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


        // 存放结果集
        List<Region> regionList= new ArrayList<>();
        for (Region region : regionTree){
            getChildren( region , regionList) ;
        }


        System.out.println(regionList);

    }

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
