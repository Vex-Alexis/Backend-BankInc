package com.alexis.nexos.credibanco.bankinc.repository;

import com.alexis.nexos.credibanco.bankinc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
