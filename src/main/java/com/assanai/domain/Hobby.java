package com.assanai.domain;

/**
 * Created by amanurat on 1/3/2016 AD.
 */

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name = "hobby")
public class Hobby implements Serializable {
    private String hobbyId;

    @Id
    @Column(name = "hobby_id")
    public String getHobbyId() {
        return this.hobbyId;
    }

    public void setHobbyId(String hobbyId) {
        this.hobbyId = hobbyId;
    }

    public String toString() {
        return "Hobby :" + getHobbyId();
    }
}
