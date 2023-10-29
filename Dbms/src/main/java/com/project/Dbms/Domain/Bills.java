package com.project.Dbms.Domain;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "bills")
@Data
@ToString

public class Bills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "bill_id")
    private String billId;

    @Column(name = "bill_date")
    private LocalDate date;

    @Column(name = "generate_by")
    private String generateBy;

    @Column(name = "total_paid")
    private Integer totalPaid;
}
