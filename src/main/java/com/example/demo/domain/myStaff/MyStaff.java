package com.example.demo.domain.myStaff;

import com.example.demo.domain.loginDetails.LoginDetail;
import com.example.demo.domain.myStaffRoles.MyStaffRoles;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name= "goo")
public class MyStaff{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Stafffid")
    private Integer regno;
    @Column(name = "Suname")
    private String surname;
    @Column(name = "Middlename")
    private String middlename;
    @Column(name = "Lastname")
    private String lastname;
    //  @Column(name = "Age")
    //private Integer age;
    private String telephone;
    @Column(name = "Referal")
    private String referaladresss;
    @Column(name = "Professiion")
    private String professiion;
    private String username;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "goMystaffr",
            inverseJoinColumns =
                    {@JoinColumn(name = "rol_no", referencedColumnName = "role_no")},
            joinColumns =
                          {@JoinColumn(name = "Staid", referencedColumnName = "stafffid")}
    )
    private Collection<MyStaffRoles> roles = new ArrayList<MyStaffRoles>();

    public MyStaff(){
    }

    public MyStaff(Integer reg_no, String surname, String middlename,
                   String lastname, String telephone,
                   String referaladresss, String professiion,String username) {
        this.regno =reg_no;
        this.surname=surname;
        this.middlename=middlename;
        this.lastname=lastname;
        this.telephone=telephone;
        this.referaladresss=referaladresss;
        this.professiion=professiion;
        this.username=username;
    }
    public MyStaff(Integer reg_no, String surname, String middlename,
                   String lastname, String telephone,
                   String referaladresss, String professiion) {
        this.regno =reg_no;
        this.surname=surname;
        this.middlename=middlename;
        this.lastname=lastname;
        this.telephone=telephone;
        this.referaladresss=referaladresss;
        this.professiion=professiion;

    }

    public void setRegno(Integer regno) {
        this.regno = regno;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public Integer getRegno() {
        return regno;
    }

    public String getProfessiion() {
        return professiion;
    }

    public void setRoles(Collection<MyStaffRoles> roles) {
        this.roles = roles;
    }

    public String getReferaladresss() {
        return referaladresss;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getSurname() {
        return surname;
    }

    public String getMiddlename() {
        return middlename;
    }
}
