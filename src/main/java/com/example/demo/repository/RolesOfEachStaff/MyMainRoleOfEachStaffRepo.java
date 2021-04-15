package com.example.demo.repository.RolesOfEachStaff;

import com.example.demo.domain.myStaff.MyStaff;
import com.example.demo.repository.myStaffRepository.MyJpaRepo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyMainRoleOfEachStaffRepo extends MyJpaRoleOfEachstaffRepo<MyStaff,Integer> {

    List<MyStaff> findByLastname(String lastname);
}
