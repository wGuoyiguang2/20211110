package com.example.demo;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.container.Alert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    private final PathMatcher pathMarch = new AntPathMatcher();







    @Test
    public void aa() {

    }


//    @Test
//    public void parseTest() {
//
//        String plmxs = "{\n" +
//                "        'receiver': 'webhook',\n" +
//                "        'status': 'firing',\n" +
//                "        'alerts': [{\n" +
//                "                'status': 'firing',\n" +
//                "                'labels': {\n" +
//                "                        'alertname': 'PodMemoryUsage',\n" +
//                "                        'namespace': 'ops',\n" +
//                "                        'pod': 'kube-state-metrics-d779c6774-2dzg4',\n" +
//                "                        'severity': 'warning'\n" +
//                "                },\n" +
//                "                'annotations': {\n" +
//                "                        'summary': '命名空间: ops | Pod名称: kube-state-metrics-d779c6774-2dzg4 内存使用大于80% (当前值: 257.8515625)'\n" +
//                "                },\n" +
//                "                'startsAt': '2021-09-16T09:06:13.167936072Z',\n" +
//                "                'endsAt': '2021-09-16T09:10:13.167936072Z',\n" +
//                "                'generatorURL': 'http://prometheus-59cfb9bfdc-ghqlz:9090/graph?g0.expr=sum+by%28pod%2C+namespace%29+%28container_memory_rss%7Bimage%21%3D%22%22%7D%29+%2F+sum+by%28pod%2C+namespace%29+%28container_spec_memory_limit_bytes%7Bimage%21%3D%22%22%7D%29+%2A+100+%21%3D+%2BInf+%3E+80&g0.tab=1'\n" +
//                "        }],\n" +
//                "        'groupLabels': {\n" +
//                "                'alertname': 'PodMemoryUsage'\n" +
//                "        },\n" +
//                "        'commonLabels': {\n" +
//                "                'alertname': 'PodMemoryUsage',\n" +
//                "                'namespace': 'ops',\n" +
//                "                'pod': 'kube-state-metrics-d779c6774-2dzg4',\n" +
//                "                'severity': 'warning'\n" +
//                "        },\n" +
//                "        'commonAnnotations': {\n" +
//                "                'summary': '命名空间: ops | Pod名称: kube-state-metrics-d779c6774-2dzg4 内存使用大于80% (当前值: 257.8515625)'\n" +
//                "        },\n" +
//                "        'externalURL': '',\n" +
//                "        'version': '4',\n" +
//                "        'groupKey': '{}:{alertname=\"PodMemoryUsage\"}'\n" +
//                "}";
//
//
//        String replace01 = plmxs.replace("\"", "@");
//        System.out.println(replace01);
//        String replace02 = replace01.replace("'", "\"");
//        System.out.println("hhhhhhhhhh");
//
//        System.out.println(replace02);
//
//        System.out.println("heiheiheiheiheihei");
//        String result = replace02.replace("@", "'");
//        System.out.println(result);
//
//        System.out.println("ddddddd");
//        JSONObject jsonObject = JSON.parseObject(result);
//        String alertsStr = jsonObject.getString("alerts");
//        System.out.println(alertsStr);
//
//
//
//        List<Alert> alerts = JSONObject.parseArray(alertsStr, Alert.class);//把字符串转换成集合
//        System.out.println(alerts);
//
//        System.out.println("aa");
//        System.out.println("aa");
//
//
//    }

    @Test
    public void localDateTime() {

        String timeStr = "2021-09-16T09:06:13.167936072Z" ;
        String replace = timeStr.replace("T", " ").replace("Z", "");
        String substring = replace.substring(0, 19);

        LocalDateTime ldt = LocalDateTime.now();

        System.out.println(ldt.toString());

        System.out.println(ldt.toString());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(substring, dateTimeFormatter);
        System.out.println(parse.toString());
        System.out.println(parse.toString());


    }





































}
