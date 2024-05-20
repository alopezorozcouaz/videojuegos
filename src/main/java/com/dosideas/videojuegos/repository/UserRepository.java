package com.dosideas.videojuegos.repository;

import com.dosideas.videojuegos.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author alopezorozco
 */
public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);
}
