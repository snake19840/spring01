package com.yujian.spring01.Service;

import com.yujian.spring01.Entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    List<Users> findUserAll();
    Users findUserById(Integer id);
    Page<Users> findUserByPage(Pageable pageable);
    void saveUser(Users users);
}
