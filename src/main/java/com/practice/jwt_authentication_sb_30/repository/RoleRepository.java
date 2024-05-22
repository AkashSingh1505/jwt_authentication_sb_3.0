package com.practice.jwt_authentication_sb_30.repository;

import com.practice.jwt_authentication_sb_30.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Set<Role> findByNameIn(Set<String> rolesName);
}
