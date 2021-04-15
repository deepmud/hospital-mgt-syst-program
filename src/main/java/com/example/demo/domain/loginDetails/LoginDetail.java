package com.example.demo.domain.loginDetails;

import com.example.demo.domain.myStaff.MyStaff;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "logins")
public class LoginDetail{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serial_no;
    private String username;
    private String password;
    @Column(name = "staff_reg_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer staffRegNo;


    public LoginDetail() {
    }

    public LoginDetail(Integer serial_no,String username,String password,Integer staffRegNo) {
        this.serial_no= serial_no;
        this.username = username;
        this.password = password;
        this.staffRegNo = staffRegNo;

    }



    public Integer getSerial_no() {
        return serial_no;
    }

    public void setSerial_no(Integer serial_no) {
        this.serial_no = serial_no;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public Integer getStaffRegNo() {
        return staffRegNo;
    }


}
