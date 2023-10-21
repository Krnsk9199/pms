package com.project.Dbms.Controller;


import com.project.Dbms.DTO.MedicineDTO;
import com.project.Dbms.DTO.MessageDTO;
import com.project.Dbms.Domain.Medicine;
import com.project.Dbms.Service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/medicine")
@Validated

public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @PostMapping("/add")
    public  Object addMedicine(@RequestBody MedicineDTO medicineDTO){
        MessageDTO message =  medicineService.addMedicine(medicineDTO);
        return message;
    }

    @PostMapping("/remove")
    public  Object removeMedicine(@RequestBody MedicineDTO medicineDTO){
        MessageDTO message =  medicineService.removeMedicine(medicineDTO);
        return message;
    }

    @PostMapping("/search")
    public  Object searchMedicine(@RequestBody MedicineDTO medicineDTO){
        MessageDTO message =  medicineService.search(medicineDTO.getMedId());
        return message;
    }

    @PostMapping("/update")
    public  Object updateMedicine(@RequestBody MedicineDTO medicineDTO){
        MessageDTO message =  medicineService.updateMedicine(medicineDTO);
        return message;
    }

    @PostMapping("/view")
    public  Object viewAllMedicines(){
        List<Medicine> medicines = medicineService.viewMedicines();
        MessageDTO message = new MessageDTO();
        message.setData(medicines);
        message.setMessage("All medicines fetched successfully");
        message.setStatus("success");
        return message;
    }
}
