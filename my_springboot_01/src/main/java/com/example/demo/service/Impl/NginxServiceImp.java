package com.example.demo.service.Impl;

import com.example.demo.entity.Vo.BoyVo;
import com.example.demo.service.NginxService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-10-18 19:06
 **/
@Service
public class NginxServiceImp  implements NginxService {
    @Override
    public void deal() {
        List<BoyVo> list = new ArrayList<>();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                    BoyVo boyVo = new BoyVo();
                    list.add(boyVo);
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

    }

    @Override
    public void dealMap() {
        Map<Long,BoyVo> map = new HashMap<>();
        Thread thread = new Thread(()->{
            Long i = 1L;
            for(;;){
                BoyVo boyVo = new BoyVo();
                map.put(i,boyVo);
                i++;
            }

        });
        thread.start();
    }
}
