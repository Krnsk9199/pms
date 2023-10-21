package com.project.Dbms.DTO;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MessageDTO {
    private String message;
    private String status;
    private String data;

}
