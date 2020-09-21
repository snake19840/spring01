package com.yujian.spring01;

import com.yujian.spring01.Entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

//    添加一个字符串
    @Test
    public void setTest(){
        this.redisTemplate.opsForValue().set("key","北京");
    }

//    获取一个字符串
@Test
    public void testGet(){
     String value= (String) this.redisTemplate.opsForValue().get("key");
     System.out.println(value);
}
/**
 * 添加Users对象
 */

@Test
    public void testSetUsers(){
    Users users=new Users();
    users.setName("王五");
    users.setPassword("yujian");
    users.setId(1);
//    this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
    this.redisTemplate.opsForValue().set("users",users);

}

@Test
    public void testGetUsers(){
//    this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
    Users users= (Users) this.redisTemplate.opsForValue().get("users");
    System.out.println(users);

}

@Test
    public void testSetJson(){
    Users users=new Users();
    users.setName("王五1");
    users.setPassword("yujian1");
    users.setId(2);
    this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
    this.redisTemplate.opsForValue().set("users_Json",users);
}
}
