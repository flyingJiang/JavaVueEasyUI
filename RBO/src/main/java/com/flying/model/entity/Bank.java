package com.flying.model.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Bank {
    private Integer id;
    private String bank_code;
    private String headquarters_code;
    private String branch_bank_code;
    private String bank_name;
    private String status;
    private String creator;
    private Date cdate;
    private String editor;
    private Date edate;
}
