package com.example.demo.entity;

import com.example.demo.custominterface.NotNull;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @program: springboot_01
 * @description:
 **/
public class Employee {
    //@NotNull(value = "姓名",description = "姓名描述：请输入汉字")
    private String name;
    //@NotNull(value = "电话",description = "电话描述：请输入汉字")
    private String phone;
    private Integer age;
    //@NotNull(value = "工资",description = "工资描述：请输入年龄")
    private Double salary;
    //@CutString(maxLength = 3,description = "描述字段")
    private String description;

    private Boss boss;

    /**
     * 住址
     **/
    //@NotNull(value = "住址",description = "工住址描述：请输入年龄")
    private List<String> addresses ;

    /**
     *紧急联系人
     **/
    @NotNull(value = "紧急联系人",description = "紧急联系人描述")
    private Set<String> emergencyName ;

    public Employee() {

    }

    public Employee(String name, Integer age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Employee(String name, Integer age, Double salary,Boss boss) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.boss = boss;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }


    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    public Set<String> getEmergencyName() {
        return emergencyName;
    }

    public void setEmergencyName(Set<String> emergencyName) {
        this.emergencyName = emergencyName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", description='" + description + '\'' +
                ", boss=" + boss +
                ", addresses=" + addresses +
                ", emergencyName=" + emergencyName +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) &&
                Objects.equals(phone, employee.phone) &&
                Objects.equals(age, employee.age) &&
                Objects.equals(salary, employee.salary) &&
                Objects.equals(description, employee.description) &&
                Objects.equals(boss, employee.boss) &&
                Objects.equals(addresses, employee.addresses) &&
                Objects.equals(emergencyName, employee.emergencyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone, age, salary, description, boss, addresses, emergencyName);
    }
}
