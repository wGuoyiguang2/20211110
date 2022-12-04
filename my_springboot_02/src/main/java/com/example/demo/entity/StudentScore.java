package com.example.demo.entity;

import java.math.BigDecimal;

/**
 * @program: springboot_01
 * @create: 2021-04-04 15:41
 **/
public class StudentScore {
    private String  name;
    private String  subject;
    private BigDecimal score;

    public StudentScore() {

    }

    public StudentScore(String name, String subject, BigDecimal score) {
        this.name = name;
        this.subject = subject;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }
}
