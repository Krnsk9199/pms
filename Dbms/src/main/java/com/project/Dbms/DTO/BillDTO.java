package com.project.Dbms.DTO;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString

public class BillDTO {

    private String generateBy;
    private Long totalPaid;
    private Date date;
    private String billId;

}
