package com.dh.dentalclinicmvc.repository;

import com.dh.dentalclinicmvc.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {
  Optional<User> findByEmail(String email);
}
