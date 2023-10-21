package com.project.Dbms.Domain;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "medicine")
@Data
@ToString

public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "med_id")
    private Long id;

    @Column(name = "med_quantity")
    private Integer quantity;

    @Column(name = "med_name")
    private String name;

    @Column(name = "price_per_unit")
    private Integer pricePerUnit;

    @Column(name = "med_company_name")
    private Integer companyName;


}
