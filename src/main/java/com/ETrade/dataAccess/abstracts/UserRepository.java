package com.ETrade.dataAccess.abstracts;

import com.ETrade.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
