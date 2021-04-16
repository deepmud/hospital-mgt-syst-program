package com.example.demo.domain.myStaff;

import com.example.demo.domain.myStaffRoles.MyStaffRoles;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name= "staff_detail")
public class MyStaff{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Integer regNo;
    @Column(name = "sur_name")
    private String surName;
    @Column(name = "middle_name")
    private String middleName;
    private String lastName;
    private String telephone;
    @Column(name = "referal")
    private String referalOrAdresss;
    private String profession;
    private String userName;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "goMystaffr",
            inverseJoinColumns =
                    {@JoinColumn(name = "role_no", referencedColumnName = "role_no")},
            joinColumns =
                          {@JoinColumn(name = "Staff_id", referencedColumnName = "staff_id")}
    )
    private Collection<MyStaffRoles> roles = new ArrayList<MyStaffRoles>();

    public MyStaff(){
    }

    public MyStaff(Integer reg_no, String surName, String middleName,
                   String lastName, String telephone,
                   String referalOrAdresss, String profession, String userName) {
        this.regNo =reg_no;
        this.surName = surName;
        this.middleName=middleName;
        this.lastName = lastName;
        this.telephone=telephone;
        this.referalOrAdresss = referalOrAdresss;
        this.profession = profession;
        this.userName = userName;
    }
    public MyStaff(Integer reg_no, String surName, String middleName,
                   String lastName, String telephone,
                   String referalOrAdresss, String profession) {
        this.regNo =reg_no;
        this.surName = surName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.telephone=telephone;
        this.referalOrAdresss = referalOrAdresss;
        this.profession = profession;

    }

    public void setRegNo(Integer regNo) {
        this.regNo = regNo;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public Integer getRegNo() {
        return regNo;
    }

    public String getProfession() {
        return profession;
    }

    public void setRoles(Collection<MyStaffRoles> roles) {
        this.roles = roles;
    }

    public String getReferalOrAdresss() {
        return referalOrAdresss;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getSurName() {
        return surName;
    }

    public String getMiddleName() {
        return middleName;
    }
}
