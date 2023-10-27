package com.project.Dbms.Repository;

import com.project.Dbms.Domain.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MedicineRepository extends JpaRepository<Medicine,Long> {

    Optional<Medicine> findByMedId(Long medId);

}
