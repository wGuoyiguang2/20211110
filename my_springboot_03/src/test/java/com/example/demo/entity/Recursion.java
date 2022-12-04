package com.example.demo.entity;
import java.util.List;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-03-29 18:34
 **/
public class Recursion {

    List<Boss> bossList  ;

    int currentIndex = 0 ;

    public void proceed() {
        // 结束递归的条件
        if (this.currentIndex == this.bossList.size() - 1) {
            System.out.println(bossList.get(currentIndex).toString());
            return ;
        }
        Boss boss = this.bossList.get(this.currentIndex);
        if (this.currentIndex <= this.bossList.size() - 2) {
            System.out.println(boss.toString());
            this.currentIndex++;
            proceed();
        }


    }

    public List<Boss> getBossList() {
        return bossList;
    }

    public void setBossList(List<Boss> bossList) {
        this.bossList = bossList;
    }
}
