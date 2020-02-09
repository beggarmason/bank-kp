package edu.tusur.kp.jpa.dto;

import edu.tusur.kp.jpa.model.*;

import java.util.Date;
import java.util.List;

public class DepositDto {

    private Long id;
    private String name;
    private String currency;
    private Integer year;
    private Date fromDate;
    private Date toDate;
    private Person person;
    private Plan plan;
    private Type type;
    private List<Restriction> restriction;
    private Bonus bonus;

}
