package com.demo.d.repositiry;


import com.demo.d.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositry extends JpaRepository<User,Long> {
    User findByUsername(String username );
    User findById(long id);
}
