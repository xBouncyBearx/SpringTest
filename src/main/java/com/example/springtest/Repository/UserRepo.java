package com.example.springtest.Repository;

import com.example.springtest.Entity.LoginDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<LoginDetail, UUID> {

    LoginDetail findByUsername(String username);
}
