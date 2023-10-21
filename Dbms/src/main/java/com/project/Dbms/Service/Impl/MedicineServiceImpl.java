package com.project.Dbms.Service.Impl;

import com.project.Dbms.DTO.MedicineDTO;
import com.project.Dbms.DTO.MessageDTO;
import com.project.Dbms.Domain.Medicine;
import com.project.Dbms.Domain.PmsUser;
import com.project.Dbms.Repository.MedicineRepository;
import com.project.Dbms.Service.MedicineService;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;
    @Override
    public MessageDTO addMedicine(MedicineDTO medicineDTO) {

        Medicine med = new Medicine();
        med.setMedId(medicineDTO.getMedId());
        med.setCompanyName(medicineDTO.getCompanyName());
        med.setName(medicineDTO.getName());
        med.setQuantity(medicineDTO.getQuantity());
        med.setPricePerUnit(medicineDTO.getPricePerUnit());
        medicineRepository.save(med);
        log.info(medicineDTO.getName() +" added successfully");
        MessageDTO message = new MessageDTO();
        message.setData(null);
        message.setMessage(medicineDTO.getName() +" added successfully");
        message.setStatus("success");
        return message;

    }

    @Override
    public MessageDTO removeMedicine(MedicineDTO medicineDTO) {
        MessageDTO message = new MessageDTO();
        message.setData(null);
        message.setMessage(medicineDTO.getName() +" deleted successfully");
        message.setStatus("success");

        Long id = medicineDTO.getId();
        Optional<Medicine> medicineOptional = medicineRepository.findById(id);
        if(medicineOptional.isPresent()){
            Medicine med = medicineOptional.get();
            medicineRepository.delete(med);
            log.info(med.getName() + " deleted successfully");
        }
        return message;
    }

    @Override
    public List<Medicine> viewMedicines() {
        List<Medicine> allMedicines = medicineRepository.findAll();
        return allMedicines;
    }

    @Override
    public MessageDTO search(Long medId) {
        MessageDTO message = new MessageDTO();
        message.setData(null);
        message.setMessage("searched successfully");
        message.setStatus("success");

        Optional<Medicine> med = medicineRepository.findByMedId(medId);
        if(med.isPresent()){
            message.setData(med);
        }
        else{
            message.setMessage("Med not found");
        }
        return message;
    }

    @Override
    public MessageDTO updateMedicine(MedicineDTO medicineDTO) {
        MessageDTO message = new MessageDTO();
        message.setData(null);
        message.setMessage("updated successfully");
        message.setStatus("success");

        Optional<Medicine> medicineOptional = medicineRepository.findByMedId(medicineDTO.getMedId());
        if(medicineOptional.isPresent()){
            Medicine med = medicineOptional.get();
            med.setMedId(medicineDTO.getMedId());
            med.setCompanyName(medicineDTO.getCompanyName());
            med.setName(medicineDTO.getName());
            med.setQuantity(medicineDTO.getQuantity());
            med.setPricePerUnit(medicineDTO.getPricePerUnit());
            medicineRepository.save(med);
            log.info(medicineDTO.getName() +" updated successfully");
        }

        return message;

    }
}
