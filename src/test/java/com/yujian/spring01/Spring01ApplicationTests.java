package com.yujian.spring01;

import com.yujian.spring01.Service.Test1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Spring01ApplicationTests {

    @Autowired
    private  Test1 test1;

    @Test
    void contextLoads() {
        System.out.println("1111");
    }

    @Test
    void addtest(){
      int a=  new Test1().Add(1,2);
      System.out.println(a);
    }

    @Test
    void add2(){
       int a= this.test1.Add(1,3);
       System.out.println(a);
    }

}
