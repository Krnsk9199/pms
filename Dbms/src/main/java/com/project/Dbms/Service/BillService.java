package com.project.Dbms.Service;

import com.project.Dbms.DTO.MedicineDTO;
import com.project.Dbms.DTO.MessageDTO;
import com.project.Dbms.Domain.Bills;
import com.project.Dbms.Domain.Medicine;

import java.util.LinkedHashMap;
import java.util.List;

public interface BillService {

    List<Bills> viewBills();

    void purchaseAndPrint(List<LinkedHashMap> list, String generatedBy, Integer totalPaid);
}
