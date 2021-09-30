package com.example.multipledb.dao.user;

import com.example.multipledb.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo  extends JpaRepository<User,Integer> {
}
