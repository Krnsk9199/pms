package com.project.Dbms.Service.Impl;

import com.project.Dbms.DTO.MessageDTO;
import com.project.Dbms.Domain.Bills;
import com.project.Dbms.Domain.Medicine;
import com.project.Dbms.Repository.BillRepository;
import com.project.Dbms.Service.BillService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository billRepository;
    @Override
    public List<Bills> viewBills() {
     return billRepository.findAll();
    }

    @Override
    public void purchaseAndPrint(List<Medicine> list) {

    }
}
