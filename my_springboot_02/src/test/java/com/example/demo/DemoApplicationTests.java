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
        //?????? ?????? map?????? ?????????key???value
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
    *  update ????????? ??????
    */
    @Test
    public void insertOrder() {
        Order order = new  Order();
        order.setName("??????");
        order.setDescription("?????????????????????");
        int insert = orderMapper.insert(order);
        System.out.println(insert);
    }


    /**
     *  ??????treeMap????????????
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


        // TreeMap??????????????????????????????????????????????????????????????????key?????????????????????????????????integer????????????String?????????????????????
        // ?????????TreeMap????????????key?????????
        Map<String, List<Order>> treeMap = orders.stream()
                .collect(Collectors.groupingBy(Order::getName,TreeMap::new,Collectors.toList()));
        System.out.println(treeMap);

        // ???treeMap ??????
        TreeMap<String,List<Order>> descTreeMap= new TreeMap<String,List<Order>>(new Comparator<String>(){
            public int compare(String a,String b){
                return b.compareTo(a);
            }
        });
        Map<String, List<Order>> hashMap = orders.stream()
                .collect(Collectors.groupingBy(Order::getName,HashMap::new,Collectors.toList()));


        // map ???java8????????????????????????
        hashMap.forEach((k, v) ->{
            descTreeMap.put(k,v);

        });

// map ???java8????????????????????????
//        hashMap.keySet().forEach(key ->  descTreeMap.put(key,hashMap.get(key)));
        System.out.println(descTreeMap);


    }


    /**
     *  ??????treeMap????????????
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
        o1.setDescription("??????????????????");
        o1.setName("??????");
        o1.setUpdatedTime(LocalDateTime.now());
        o1.setUpdatedGUID(operatorGUID);
        o1.setDelFlag("0");

        Order o2 = new Order();
        o2.setId(17);
        o2.setDescription("??????????????????");
        o2.setName("??????");
        o2.setUpdatedTime(LocalDateTime.now());
        o2.setUpdatedGUID(operatorGUID);
        o2.setDelFlag("0");

        Order o3 = new Order();
        o3.setId(18);
        o3.setDescription("??????????????????");
        o3.setName("??????");
        o3.setUpdatedTime(LocalDateTime.now());
        o3.setUpdatedGUID(operatorGUID);
        o3.setDelFlag("0");

        Order o4 = new Order();
        o4.setId(19);
        o4.setDescription("??????????????????");
        o4.setName("??????");
        o4.setUpdatedTime(LocalDateTime.now());
        o4.setUpdatedGUID(operatorGUID);
        o4.setDelFlag("0");

        Order o5 = new Order();
        o5.setId(20);
        o5.setDescription("??????????????????");
        o5.setName("??????");
        o5.setUpdatedTime(LocalDateTime.now());
        o5.setUpdatedGUID(operatorGUID);
        o5.setDelFlag("0");

        list.add(o1);
        list.add(o2);
        list.add(o3);
        list.add(o4);
        list.add(o5);

        int i = orderMapper.updateBatchOrders(list);
        System.out.println("???????????????????????????"+ i);

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
                  // ?????????
                  // ??????????????????????????????????????????
                  lastItems.add(dingjin);
                  // TODO ????????? ???0
                  if (in-weikouchudedingjin > 0) {
                      lastItems.add(in-weikouchudedingjin) ;
                  }
                  weikouchudedingjin= 0;
                  continue;
              }

              if (in-weikouchudedingjin == 0) {
                  // ?????????
                  lastItems.add(dingjin);
                  weikouchudedingjin= 0;
              }
              // ??????
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
        boss.setName("?????????1");
        boss.setAge(28);
        Boss boss2 =  new Boss();
        boss2.setName("?????????2");
        boss2.setAge(28);
        list.add(boss);
        list.add(boss2);
        Recursion recursion = new Recursion();
        recursion.setBossList(list);
        // ????????????
        recursion.proceed();


    }


    @Test
    public void MergeTest() {

        List<StudentScore> studentScoreList = new ArrayList<>();

        StudentScore studentScore1 = new StudentScore("?????????","??????",BigDecimal.valueOf(99));
        StudentScore studentScore2 = new StudentScore("?????????","??????",BigDecimal.valueOf(99));
        StudentScore studentScore3 = new StudentScore("?????????","??????",BigDecimal.valueOf(97));
        StudentScore studentScore4 = new StudentScore("?????????","??????",BigDecimal.valueOf(97));
        studentScoreList.add(studentScore1) ;
        studentScoreList.add(studentScore2) ;
        studentScoreList.add(studentScore3) ;
        studentScoreList.add(studentScore4) ;


        StudentScore studentScore5 = new StudentScore("?????????","??????",BigDecimal.valueOf(89));
        StudentScore studentScore6 = new StudentScore("?????????","??????",BigDecimal.valueOf(89));
        StudentScore studentScore7 = new StudentScore("?????????","??????",BigDecimal.valueOf(87));
        StudentScore studentScore8 = new StudentScore("?????????","??????",BigDecimal.valueOf(87));
        studentScoreList.add(studentScore5) ;
        studentScoreList.add(studentScore6) ;
        studentScoreList.add(studentScore7) ;
        studentScoreList.add(studentScore8) ;


        StudentScore studentScore9 = new StudentScore("?????????","??????",BigDecimal.valueOf(79));
        StudentScore studentScore10 = new StudentScore("?????????","??????",BigDecimal.valueOf(79));
        StudentScore studentScore11 = new StudentScore("?????????","??????",BigDecimal.valueOf(77));
        StudentScore studentScore12 = new StudentScore("?????????","??????",BigDecimal.valueOf(77));

        studentScoreList.add(studentScore9) ;
        studentScoreList.add(studentScore10) ;
        studentScoreList.add(studentScore11) ;
        studentScoreList.add(studentScore12) ;

        // ??????????????????????????????



        // ?????? Java8??????????????????summingInt???summingLong???summingDouble???????????????????????????????????????BigDecimal????????????????????????????????????????????????

        System.out.println("-----------------------------sum 3.1 ----------------------");
        Map<String,BigDecimalSummaryStatistics> studentScoreMap4 =
                studentScoreList.stream()
                        .collect(Collectors.groupingBy(StudentScore::getName ,  CollectorsUtil.summarizingBigDecimal(StudentScore::getScore))   );

        studentScoreMap4.forEach((k,v) -> System.out.println("key: " + k + " , " + "value: " + v.getSum()));
        

    }



    @Test
    public void testList22() {


        // ????????????
        List<Region> regionList= new ArrayList<>();
        Region  region1 = new Region(1,"?????????","0",null,"0");
        Region  region2 = new Region(2,"?????????","0_1","0","0");
        Region  region3 = new Region(3,"?????????","0_1_1","0_1","1");
        Region  region4 = new Region(4,"??????","0_1_2","0_1","1");

        Region  region5 = new Region(2,"?????????","0_2","0","1");


        Region  region6 = new Region(5,"?????????","1",null,"0");
        Region  region7 = new Region(6,"?????????","1_1","1","0");
        Region  region8 = new Region(6,"?????????","1_2","1","1");
        Region  region9 = new Region(7,"????????????","1_1_1","1_1","1");



        // ??????????????? ?????????list ????????? list
        // ??????
        //  ??? 001 ???002
        //  ??? 001.001 ???001.002
        //  ??? 001.001.001 ???001.001.002
        regionList.add(region1);
        regionList.add(region2);
        regionList.add(region3);
        regionList.add(region4);
        regionList.add(region5);
        regionList.add(region6);
        regionList.add(region7);
        regionList.add(region8);
        regionList.add(region9);
        // ??????????????? ?????? region??? children ????????? children ?????? ??? ???orderCode+ ?????????orderCode ??????????????? + 1
         for (Region root : regionList){
             setRegionOrderCode(regionList  , null ,  root);
         }
        System.out.println(regionList);
    }


    /** 
    * ?????????????????????????????????list?????????
    */ 
    @Test
    public void testList23() {

        // ????????????
        List<Region> regionTree = new ArrayList<>();

        Region  region1 = new Region(1,"?????????","0",null,"0");
        Region  region2 = new Region(2,"?????????","0_1","0","0");
        Region  region3 = new Region(3,"?????????","0_1_1","0_1","1");
        Region  region4 = new Region(4,"??????","0_1_2","0_1","1");

        Region  region5 = new Region(2,"?????????","0_2","0","1");
        List<Region> jinzhongChildren = new ArrayList<>();
        jinzhongChildren.add(region3);
        jinzhongChildren.add(region4);
        region2.setChildren(jinzhongChildren);

        List<Region> shanxiChildren = new ArrayList<>();
        shanxiChildren.add(region2);
        shanxiChildren.add(region5);
        region1.setChildren(shanxiChildren);

        Region  region6 = new Region(5,"?????????","1",null,"0");
        Region  region7 = new Region(6,"?????????","1_1","1","0");
        Region  region8 = new Region(6,"?????????","1_2","1","1");
        Region  region9 = new Region(7,"????????????","1_1_1","1_1","1");

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


        // ???????????????
        List<Region> regionList= new ArrayList<>();
        for (Region region : regionTree){
            getChildren( region , regionList) ;
        }


        System.out.println(regionList);

    }

    public  List<Region> getChildren( Region targetRegion , List<Region> regionResultList){

        // ??????
        if ("1".equals(targetRegion.getIsEnd())) {
            // return ??????????????????????????????????????????????????????
            // ?????????????????????????????????????????????????????????)
            return  new ArrayList<>();
        }

        // childrenRegionList
        List<Region> childrenRegionList = targetRegion.getChildren();

        //  ???????????? Region ??? equals ??????
        if (!regionResultList.contains(targetRegion)) {
            regionResultList.add(targetRegion);
        }

        for (Region children : childrenRegionList) {
            //  ??? children ???????????????
            if (!regionResultList.contains(children)) {
                regionResultList.add(children);
            }
            //??????children ' children
            getChildren(children , regionResultList) ;
        }

        return childrenRegionList;
    }



    /**
     * ?????????????????????????????????list?????????
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
            // break ????????? 1 2 3
            // return ????????????  1 2 3 ?????????????????????for ??????
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


        // ????????????

        ListNode next = headNode.getNext();
        System.out.println(headNode.getData());

        while(null != next) {
            System.out.println(next.getData());
            // ???????????????
            next = next.getNext();
        }

        System.out.println("??????????????????");

        // ??????
        ListNode reverseHeadNode = reverseList(headNode);

        ListNode next1 = reverseHeadNode.getNext();
        System.out.println(reverseHeadNode.getData());

        while(null != next1) {
            System.out.println(next1.getData());
            // ???????????????
            next1 = next1.getNext();
        }
    }


    public ListNode  reverseList(ListNode head){
        if (null == head) {
            return null;
        }

        // ????????????
        ListNode prev = head;
        // ????????????
        ListNode current = head.getNext();

        // ????????????????????? ???????????????????????? ?????????????????????????????? next ?????????  null
        prev.setNext(null);

        // current ??? null ??????????????????while ????????????????????????????????????????????????
        while(null != current){
            // ????????????
            ListNode next = current.getNext();
            // ?????????????????????????????? next ?????????  prev ??????????????????prev ????????????????????? ??????
            current.setNext(prev);
            // current ????????????  ???????????? prev ??????
            prev = current;
            // next ????????????  current??????
            current = next;
        }

        // ?????????????????? ?????????
        return prev;

    }




    // "{}" ???true
    // "()" ???true
    // "{)" ???false
    // "{()}" ???true
    // "{(}}" ???false
    public boolean isValid(String s) {
        boolean flag = true;

        if("".equals(s) || null == s){
            return flag;
        }


        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if (c == '(' || c == '{' ) {
                // ??????
                stack.push(c);

                // ??????
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
//                 // ??????????????????
//                 result.add(index,picAndVideo.get(index));
//                 index ++ ;
//             }else{
//                 firstPic = true ;
//             }
//        }
//
//        // ???????????????
//        while ( index <picAndVideoSize ) {
//
//            if (isVedio(picAndVideo.get(index))) {
//                // ??????????????????
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
        // ?????????????????????????????????
        int[] intArray =  new int [4];
        intArray[0] = 0 ;
        intArray[1] = 1 ;
        intArray[2] = 2 ;
        intArray[3] = 3 ;
        int index = getIndex(intArray, 1);
        System.out.println(index);

    }



    public int getIndex(int[] num,int target) {
        // ?????????????????????????????????
        if (num.length == 0) {
            return -1;
        }

        int end = num.length - 1;
        //int halfLength = length / 2;
        int middleIndex = end / 2;

        int middleValue = num[middleIndex];
        // ??????target ????????????false
         boolean flag = true;
        // ????????????
        while(flag){

           if (target == num[0]){
                middleIndex = 0 ;
                flag = false;

            }else if (target == num[end]){
                middleIndex = end ;
                flag = false;
            }else {
               if (target > middleValue) {
                   // target ?????????????????????
                   // ??????
                   middleIndex =  (middleIndex + end)/2 ;
                   middleValue = num[middleIndex];

               }else if (target < middleValue) {
                   //  target ?????????????????????
                   middleIndex =  (middleIndex + 0)/2;
                   middleValue = num[middleIndex];
                   // ???????????????
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

        String test = "http://10.231.134.228:8080/images/???????????????????????????????????????????????????/20200521/??????_20200521153416_???????????????_F15BD322-55AE-4739-806E-5849629E8675.jpg";
        int i = test.lastIndexOf('/');
        String substring = test.substring(i);
        String[] split = substring.split("_");
        System.out.println( split[2]);;
        System.out.println( split[2]);;

    }



    public void bubbleSort(int[] array) {
        int length = array.length;

        // ???????????? ???????????????  3 2  ?????????
        for (int i = 0 ; i < length ;i++) {
            // ??????   for (int j =1 ;j < length - i  ;j++) {
            // ???????????????????????????????????? ?????????????????????????????? ??????????????? ????????? 3 2  ???????????????
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

        antPathMatcher.isPattern("/user/001");// ?????? false
        antPathMatcher.isPattern("/user/*"); // ?????? true
        antPathMatcher.match("/user/001","/user/001");// ?????? true
        boolean match = antPathMatcher.match("/user/001/002", "/user/001/002");// ?????? true
        boolean match2 = antPathMatcher.match("/user/001/002", "/user/001");// ?????? false
        antPathMatcher.match("/user/*","/user/001");// ?????? true
        antPathMatcher.matchStart("/user/*","/user/001"); // ?????? true
        antPathMatcher.matchStart("/user/*","/user"); // ?????? true
        antPathMatcher.matchStart("/user/*","/user001"); // ?????? false
        antPathMatcher.extractPathWithinPattern("uc/profile*","uc/profile.html"); // ?????? profile.html
        antPathMatcher.combine("uc/*.html","uc/profile.html"); // uc/profile.html



    }


    @Test
    public void scheduleTest() {

        //
        Boy boy1FromDb = new Boy();
        boy1FromDb.setName("??????");
        boy1FromDb.setSex(1);
        // BoyVo::new ?????? Vo
        BoyVo boy1Vo = com.example.demo.utils.BeanUtils.of(boy1FromDb, BoyVo::new);
        System.out.println(" boy1Vo ------ "+boy1Vo.toString());
        BoyVo boy2Vo = com.example.demo.utils.BeanUtils.of(boy1FromDb, BoyVo::new);
        System.out.println(" boy2Vo ------ "+boy2Vo.toString());
        // false
        System.out.println(boy1Vo == boy2Vo);

        List<Boy> sourceList = new ArrayList<>();
        Boy boy2FromDb = new Boy();
        boy2FromDb.setName("??????2");
        boy2FromDb.setSex(2);
        sourceList.add(boy2FromDb);
        System.out.println(" sourceList ------ "+sourceList.toString());
        // of  ???????????????????????????  List<T> list ???BoyVo::new ??????Vo
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
        // ???????????????
        if (null == targetRegion.getParentCode()) {
            List<Region>  brotherList =  sourceRegionList.stream()
                    .filter(region1 -> null == region1.getParentCode())
                    .filter(region2 ->( !targetRegion.getCode().equals(region2.getCode()) && !StringUtils.isEmpty(region2.getOrderCode())))
                    .sorted((r1,r2)->r1.getOrderCode().compareTo(r2.getOrderCode()))
                    .collect(Collectors.toList());
            return brotherList;
        }else{
            // ??????????????????
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
            // ?????????????????????????????????
            String lastThree = brother.getOrderCode().substring(brother.getOrderCode().length()-3);
            // ?????? 0 ?????? String ?????? ??? num
            String  brotherOrderCode = lastThree.replace("0","");
            System.out.println(Integer.valueOf(brotherOrderCode));
            return brotherOrderCode ;
        }else{
            // brothers ???????????? orderCode ????????????????????????  brothers  ??? orderCode ?????? "0"
            return "0";
        }
    }




    public  List<Region> setRegionOrderCode(List<Region> sourceRegionList  ,Region fatherRegion , Region targetRegion){

        // ??????
        if ("1".equals(targetRegion.getIsEnd())) {
            // ????????????????????????????????????????????????????????????????????? return ?????? ??????????????????????????????
            return  new ArrayList<>();
        }

        // ?????????
        List<Region> childrenRegionList = sourceRegionList.stream()
                .filter(region ->( null != region.getParentCode() &&  region.getParentCode().equals(targetRegion.getCode())) )
                .collect(Collectors.toList());

        // ?????????????????????orderCode????????? ???????????? ??? orderCode ??????null ??????????????? "0"???
        String brotherMaxOrderCode = getBrotherMaxOrderCode(sourceRegionList, targetRegion);
        // ?????? targetRegion ??? orderCode
        if (null == targetRegion.getParentCode()){
            // ???????????? ??? 0 ?????????????????? orderCode ??? 0+1 =1
            targetRegion.setOrderCode(fullOrderCode("",String.valueOf(Integer.valueOf(brotherMaxOrderCode)+1)));
        }else{
            // orderCode  ??? null ?????? set??????????????????
            if (null == targetRegion.getOrderCode() ||  "".equals(targetRegion.getOrderCode())) {
                targetRegion.setOrderCode(fullOrderCode(fatherRegion.getOrderCode(),String.valueOf(Integer.valueOf(brotherMaxOrderCode)+1)));
            }
        }

        for (Region children : childrenRegionList) {
            String brotherMaxOrderCode2 = getBrotherMaxOrderCode(sourceRegionList, children);
            // ?????? children ???orderCode
            children.setOrderCode(fullOrderCode(targetRegion.getOrderCode(),String.valueOf(Integer.valueOf(brotherMaxOrderCode2)+1)));
            //??????children ' children
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
