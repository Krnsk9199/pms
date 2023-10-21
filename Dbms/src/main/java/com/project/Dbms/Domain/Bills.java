package com.project.Dbms.Domain;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bills")
@Data
@ToString

public class Bills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Long id;

    @Column(name = "bill_date")
    private Date date;

    @Column(name = "generate_by")
    private String generateBy;

    @Column(name = "total_paid")
    private Integer totalPaid;

//    @ManyToOne
//    @JoinColumn(name = "", referencedColumnName = "aut_id")
//    private User bok_aut_id;
}
