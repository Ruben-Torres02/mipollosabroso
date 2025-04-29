package com.mipollosabroso.web.sprintboot_mipollosabroso.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mipollosabroso.web.sprintboot_mipollosabroso.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
