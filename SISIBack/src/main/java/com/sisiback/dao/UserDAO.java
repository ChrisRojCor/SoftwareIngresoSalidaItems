package com.sisiback.dao;

import com.sisiback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {



}
