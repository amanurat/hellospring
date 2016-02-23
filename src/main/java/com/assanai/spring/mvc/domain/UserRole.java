package com.assanai.spring.mvc.domain;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "USER_ROLES")
public class UserRole extends AbstractEntity {

    @Column(name = "ROLE")
    private String role;


    @OneToMany(mappedBy = "userRole")
    @Column(name = "USER_ROLE")
    @JsonIgnore
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
