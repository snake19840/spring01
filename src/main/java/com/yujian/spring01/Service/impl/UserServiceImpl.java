package com.yujian.spring01.Service.impl;

import com.yujian.spring01.Dao.UsersRepository;
import com.yujian.spring01.Entity.Users;
import com.yujian.spring01.Service.UserService;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserService接口实现类
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersRepository usersRepository;


    @Override
    @Cacheable(value="users")
    public Users findUserById(Integer id) {
        return this.usersRepository.getOne(id);
    }

    @Override
    @Cacheable(value = "users" ,key = "#pageable.pageSize")
    public Page<Users> findUserByPage(Pageable pageable) {
        return this.usersRepository.findAll(pageable);
    }

    @Override
    @Cacheable(value="users")
    public List<Users> findUserAll() {
        return this.usersRepository.findAll();
    }

    @Override
    //表示清除以users为策略的缓存对象
    @CacheEvict(value = "users",allEntries = true)
    public void saveUser(Users users) {
        this.usersRepository.save(users);
    }
}
