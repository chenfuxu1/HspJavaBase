package chapter14.set.hashset.exercse;

import java.util.HashSet;
import java.util.Objects;


/**
 * 定义一个 Employee 类，包括 private 成员属性 name, sal, birthday(MyDate 类型)，其中 birthday 为 MyDate
 * 类型，属性包括 year, month, day, 要求
 * 1.创建 3 个 Employee 放入 HashSet 中
 * 2.当 name 和 birthday 相同时，认为是相同员工，不能添加到HashSet集合中
 */
public class Exercise02 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new Employee_("路飞", 11234, new MyDate("12", "5", "6")));
        hashSet.add(new Employee_("路飞", 11235, new MyDate("12", "5", "6")));
        hashSet.add(new Employee_("路娜", 11236, new MyDate("12", "5", "6")));
        System.out.println(hashSet);
    }
}

class Employee_ {
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee_(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee_ employee_ = (Employee_) o;
        return Objects.equals(name, employee_.name) &&
                Objects.equals(birthday, employee_.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }

    @Override
    public String toString() {
        return "Employee_{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }
}

class MyDate {
    private String year;
    private String month;
    private String day;

    public MyDate(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return Objects.equals(year, myDate.year) &&
                Objects.equals(month, myDate.month) &&
                Objects.equals(day, myDate.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
