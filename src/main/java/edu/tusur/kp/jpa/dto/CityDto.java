package edu.tusur.kp.jpa.dto;

import edu.tusur.kp.jpa.model.Bank;
import java.util.List;

public class CityDto {

    private Long id;
    private List<Bank> banks;
    private Integer year;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Bank> getBanks() {
        return banks;
    }

    public void setBanks(List<Bank> banks) {
        this.banks = banks;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
