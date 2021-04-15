package com.example.demo.service.myStaffRolesService;

import com.example.demo.domain.myStaffRoles.MyStaffRoles;

import java.util.List;

public interface StaffRolesServiceInterface {
    List<MyStaffRoles> findAll();

     MyStaffRoles createRoles( Integer serialNo, String role);
}
