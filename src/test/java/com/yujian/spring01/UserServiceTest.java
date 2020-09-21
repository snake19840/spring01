package com.yujian.spring01;


import com.yujian.spring01.Entity.Users;
import com.yujian.spring01.Service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
@ActiveProfiles("test")

public class UserServiceTest {
    @Autowired
    private UserService userService;


    @Test
    public void testFindUserById(){
//        第一次查询
        System.out.println("-------第一次查询------");
        System.out.println(this.userService.findUserById(15));
//        第二次查询
        System.out.println("-------第二次查询------");
        System.out.println(this.userService.findUserById(15));

    }

    @Test
    public void  testFindPage(){

        Pageable pageable=PageRequest.of(0,3);
        System.out.println("-------第一次-------");
        System.out.println(this.userService.findUserByPage(pageable).getTotalElements());

        System.out.println("-------第二次-------");
        System.out.println(this.userService.findUserByPage(pageable).getTotalElements());

        System.out.println("-------第三次-------");
         pageable=PageRequest.of(1,3);
        System.out.println(this.userService.findUserByPage(pageable).getTotalElements());
    }

@Test
    public void testFindAll(){
    System.out.println("-------第一次-------");
        System.out.println(this.userService.findUserAll().size());

    Users users=new Users();
    users.setName("ABSC12123");
    users.setPassword("12343213343");
    this.userService.saveUser(users);
    System.out.println("-------第二次-------");
    System.out.println(this.userService.findUserAll().size());
}

}
