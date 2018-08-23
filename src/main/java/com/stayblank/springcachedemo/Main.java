package com.stayblank.springcachedemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        /*MyAccountService s = new MyAccountService();
        // 开始查询账号
        s.getAccountByName("somebody");// 第一次查询，应该是数据库查询
        s.getAccountByName("somebody");// 第二次查询，应该直接从缓存返回

        s.reload();// 重置缓存
        System.out.println("after reload...");

        s.getAccountByName("somebody");// 应该是数据库查询
        s.getAccountByName("somebody");// 第二次查询，应该直接从缓存返回*/


        ApplicationContext context = new ClassPathXmlApplicationContext("spring-cache-anno.xml");// 加载 spring 配置文件

        NewAccountService s = (NewAccountService) context.getBean("accountServiceBean");
        // 第一次查询，应该走数据库
        System.out.print("first query...");
        s.getAccountByName("somebody");
        // 第二次查询，应该不查数据库，直接返回缓存的值
        System.out.print("second query...");
        s.getAccountByName("somebody");
        System.out.println();

    }

}
