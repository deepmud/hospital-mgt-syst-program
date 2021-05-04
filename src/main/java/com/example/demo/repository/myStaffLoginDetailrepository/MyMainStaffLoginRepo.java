package com.example.demo.repository.myStaffLoginDetailrepository;

import com.example.demo.domain.loginDetails.LoginDetail;
import com.example.demo.domain.myStaff.MyStaff;
import com.example.demo.repository.myStaffRepository.MyJpaRepo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MyMainStaffLoginRepo extends MyJpaStaffLoginRepo<LoginDetail,Integer> {
    List<LoginDetail> findByStaffRegNo(Integer reg_no);

    List<LoginDetail> findByUsernameAndPassword(String username,String password);

    @Query(value = "select (s.username) from LoginDetail s where s.staffRegNo = ?1" )
    String findTopByBy(Integer staffRegNo);

    LoginDetail findByUsername(String username);

}
