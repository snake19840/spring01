package com.yujian.spring01.Dao;

import com.yujian.spring01.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Integer> {
}
