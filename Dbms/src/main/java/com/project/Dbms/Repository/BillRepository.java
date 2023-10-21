package com.project.Dbms.Repository;

import com.project.Dbms.Domain.Bills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bills,Long> {
}
