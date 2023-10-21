package com.project.Dbms.Repository;

import com.project.Dbms.Domain.PmsUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<PmsUser,Long> {

}
