package org.example.hpcl.repositories;

import org.example.hpcl.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepositories extends JpaRepository<User, Long> {

    @Override
    Optional<User> findById(Long id);

    Optional<User> findUserByEmail(String email);

    List<User> findAll();
}
