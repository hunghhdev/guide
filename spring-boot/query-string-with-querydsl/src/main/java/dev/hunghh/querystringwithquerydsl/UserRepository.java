package dev.hunghh.querystringwithquerydsl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>, QuerydslPredicateExecutor<User> {

    @Query("FROM User t1 " +
            "WHERE :username IS NULL OR t1.username = :username " +
            "AND :address IS NULL OR t1.address = :address " +
            "AND :password IS NULL OR t1.password = :password")
    List<User> findAll(String username, String address, String password);
}
