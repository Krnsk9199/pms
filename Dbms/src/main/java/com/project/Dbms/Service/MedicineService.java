package com.project.Dbms.Service;

import com.project.Dbms.DTO.MedicineDTO;
import com.project.Dbms.DTO.MessageDTO;
import com.project.Dbms.Domain.Medicine;

import java.util.List;

public interface MedicineService {
    MessageDTO addMedicine(MedicineDTO medicineDTO);
    MessageDTO removeMedicine(MedicineDTO medicineDTO);
    List<Medicine> viewMedicines();
    MessageDTO search(Long medId);
    MessageDTO updateMedicine(MedicineDTO medicineDTO);
}
