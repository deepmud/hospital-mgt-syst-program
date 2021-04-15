package com.example.demo.service.myStaffLoginDetailsService;

import com.example.demo.domain.loginDetails.LoginDetail;
import com.example.demo.domain.myStaff.MyStaff;

import java.util.List;
import java.util.Optional;

public interface StaffLoginDetailsServiceInterface {
    List<LoginDetail> findAll();

    Optional<LoginDetail> findById(Integer myStaff);

    List<LoginDetail> findByStaffRegNo(Integer reg_no);

    List<LoginDetail> findByUsernameAndPassword(String username,String password);

    void createStaffLogin(
            String username,String confirmpassword);

    String findTopByBy(Integer staffRegNo);
}
