package org.example.hpcl.repositories;

import org.example.hpcl.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositories extends JpaRepository<User,Integer> {
    @Override
    Optional<User> findById(Integer integer);

    User save(User user);
}
