package br.com.alexmdo.codecademy.portfolioproject.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByDisplayName(String displayName);

}
