package com.example.demo.service.myStaffRolesService;

import com.example.demo.domain.myStaffRoles.MyStaffRoles;
import com.example.demo.repository.myStaffRolesRepository.MyMainStaffRolesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffRolesServiceInterfaceImpl implements StaffRolesServiceInterface {
    private final MyMainStaffRolesRepo myMainStaffRolesRepo;

    public StaffRolesServiceInterfaceImpl(@Autowired MyMainStaffRolesRepo myMainStaffRolesRepo)
    {
        this.myMainStaffRolesRepo = myMainStaffRolesRepo;
    }

    @Override
    public List<MyStaffRoles> findAll() {
        return myMainStaffRolesRepo.findAll();
    }

    @Override
    public    MyStaffRoles createRoles( Integer serialNo, String role) {
        MyStaffRoles myStaffRoles= new MyStaffRoles(serialNo,role);
        return myMainStaffRolesRepo.saveAndFlush(myStaffRoles);
    }
}
