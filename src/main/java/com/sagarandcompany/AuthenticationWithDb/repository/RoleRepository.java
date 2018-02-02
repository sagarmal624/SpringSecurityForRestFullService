package com.sagarandcompany.AuthenticationWithDb.repository;

import com.sagarandcompany.AuthenticationWithDb.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);

}
