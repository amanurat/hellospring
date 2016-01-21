package com.assanai.domain;

import java.sql.Timestamp;

/**
 * Created by amanurat on 12/27/2015 AD.
 */
public class Account {

    private Long id;

    private String ownerName;

    private Double balance;

    private Timestamp accessTimestamp;

    private Boolean locked;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Timestamp getAccessTimestamp() {
        return accessTimestamp;
    }

    public void setAccessTimestamp(Timestamp accessTimestamp) {
        this.accessTimestamp = accessTimestamp;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }
}
