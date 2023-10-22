package com.project.Dbms.Controller;

import com.project.Dbms.DTO.*;
import com.project.Dbms.Domain.Bills;
import com.project.Dbms.Domain.Medicine;
import com.project.Dbms.Service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("/bills")
@Validated

public class BillController {

    @Autowired
    private BillService billService;

    @PostMapping("/view")
    public Object viewBills(){
        List<Bills> medicines = billService.viewBills();
        MessageDTO message = new MessageDTO();
        message.setData(medicines);
        message.setMessage("All bills fetched successfully");
        message.setStatus("success");
        return message;
    }

    @PostMapping("/printBill")
    public void printBill(@RequestBody Object request) {
           List<MedicineDTO> medicines = (List<MedicineDTO>) ((LinkedHashMap) request).get("list");
           Integer totalPaid = (Integer) ((LinkedHashMap) request).get("totalPaid");
           String generatedBy = (String) ((LinkedHashMap) request).get("name");
           billService.purchaseAndPrint(medicines,generatedBy,totalPaid);
    }

}
