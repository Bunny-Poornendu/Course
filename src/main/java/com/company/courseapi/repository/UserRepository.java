package com.company.courseapi.repository;

import com.company.courseapi.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
