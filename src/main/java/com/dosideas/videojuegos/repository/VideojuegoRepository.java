package com.dosideas.videojuegos.repository;

import com.dosideas.videojuegos.domain.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author alopezorozco
 */
public interface VideojuegoRepository extends JpaRepository <Videojuego, Integer> {
    
}
