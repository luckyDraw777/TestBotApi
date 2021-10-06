package com.luckydraw.testbotapi.repository;

import com.luckydraw.testbotapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User getByChatId(Long id);

}
