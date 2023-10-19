package com.example.restdemo.repository;

import com.example.restdemo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long>{

}
