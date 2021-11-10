package com.stockmarket.stockpro.Entities;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
// import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "StockPrice")
public class StockPrice {

    @Id
    @GeneratedValue
    private long id;
    private String exchangename;
    private String companycode;
    private LocalDateTime localdatetime;
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;
    private Date datee;
    private Time timee;
    private float shareprice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExchangename() {
        return exchangename;
    }

    public void setExchangename(String exchangename) {
        this.exchangename = exchangename;
    }

    public String getCompanycode() {
        return companycode;
    }

    public void setCompanycode(String companycode) {
        this.companycode = companycode;
    }

    public StockPrice(long id, String exchangename, String companycode, LocalDateTime localdatetime, Company company, Date datee, Time timee, float shareprice) {
        super();
        this.id = id;
        this.exchangename = exchangename;
        this.companycode = companycode;
        this.localdatetime = localdatetime;
        this.company = company;
        this.datee = datee;
        this.timee = timee;
        this.shareprice = shareprice;
    }

    public StockPrice(String exchangename, String companycode, Date datee, Time timee, float shareprice) {
        super();

        this.exchangename = exchangename;
        this.companycode = companycode;
        // this.localdatetime = localdatetime;
        // this.company = company;
        this.datee = datee;
        this.timee = timee;
        this.shareprice = shareprice;
    }

    public LocalDateTime getLocaldatetime() {
        return localdatetime;
    }

    public void setLocaldatetime(LocalDateTime localdatetime) {
        this.localdatetime = localdatetime;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Date getDatee() {
        return datee;
    }

    public void setDatee(Date datee) {
        this.datee = datee;
    }

    public Time getTimee() {
        return timee;
    }

    public void setTimee(Time timee) {
        this.timee = timee;
    }

    public float getShareprice() {
        return shareprice;
    }

    public void setShareprice(float shareprice) {
        this.shareprice = shareprice;
    }

    public StockPrice() {
        super();
    }
}
