package com.example.demo.domain.myStaffRoles;

import com.example.demo.domain.myStaff.MyStaff;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "staff_role")
public class MyStaffRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_no")
    private Integer roleNo;

    private String role;

    @ManyToMany(mappedBy = "roles", cascade = CascadeType.ALL)
    private Collection<MyStaff> staff = new ArrayList<MyStaff>();

    public MyStaffRoles() {
    }

    public MyStaffRoles(Integer roleNo,String role) {
        this.roleNo = roleNo;
        this.role = role;
    }

    public MyStaffRoles(Integer roleNo) {
        this.roleNo = roleNo;
    }

    public void setStaff(Collection<MyStaff> staff) {
        this.staff = staff;
    }

    public Integer getRoleNo() {
        return roleNo;
    }

    public String getRole() {
        return role;
    }

}
