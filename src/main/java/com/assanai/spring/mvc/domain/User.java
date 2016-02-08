package com.assanai.spring.mvc.domain;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "USERS")
public class User extends AbstractEntity {

    enum GenderEnum {
        MALE("Male"), FEMALE("Female");

        private final String gender;
        private GenderEnum(String gender) {
            this.gender = gender;
        }
    }

    @Column(name = "USERNAME")
    @NotEmpty
    @Size(min = 5, max = 10)
    private String userName;

    @Column(name = "PASSWORD")
    @NotEmpty
    @Size
    private String password;

    @Column(name = "GENDER")
    //Not using annotations
    private String gender;

    @Column(name = "BIRTHDAY")
    @Temporal(value = TemporalType.TIMESTAMP)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date birthDay;


    @ManyToOne
    @JoinColumn(name = "USER_ROLE")
    @JsonIgnore
    private UserRole userRole;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("gender", gender)
                .append("userName", userName)
                .append("password", password)
                .toString();
    }
}
