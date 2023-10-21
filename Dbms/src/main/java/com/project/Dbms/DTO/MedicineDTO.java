package com.project.Dbms.DTO;


import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@ToString
public class MedicineDTO {

    private Long id;
    private Long medId;
    private Integer quantity;
    private String name;
    private Integer pricePerUnit;
    private String companyName;

}
