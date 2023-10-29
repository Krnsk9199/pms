package com.project.Dbms.Repository;

import com.project.Dbms.Domain.PmsUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<PmsUser,Long> {

    Optional<PmsUser> findByName(String name);
    Optional<PmsUser> findByUsername(String username);

    Optional<PmsUser> findById(Long id);
}
