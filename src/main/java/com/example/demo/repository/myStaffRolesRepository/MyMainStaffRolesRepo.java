package com.example.demo.repository.myStaffRolesRepository;

import com.example.demo.domain.myStaff.MyStaff;
import com.example.demo.domain.myStaffRoles.MyStaffRoles;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MyMainStaffRolesRepo extends MyJpaStaffRolesRepo<MyStaffRoles,Integer>{

}



