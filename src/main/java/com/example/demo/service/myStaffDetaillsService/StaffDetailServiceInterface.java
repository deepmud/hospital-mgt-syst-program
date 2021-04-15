package com.example.demo.service.myStaffDetaillsService;

import com.example.demo.domain.myStaff.MyStaff;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface StaffDetailServiceInterface {

    void createStaff(
            String surname,String middlename,
            String lastname,String telephone,String referal,
            String profession,String username);

    Integer findTopByOrderByRegnoDesc();


    void updateStaff(
   Integer reg_no,String surname,String middlename,String lastname,
   String telephone,String referal, String profession);

    MyStaff saveStudents(MyStaff staffss);

    Optional<MyStaff> findById(Integer id);

    MyStaff updateStudent(MyStaff student);

    List<MyStaff> findByLastname(String lastname);

    java.util.List<MyStaff> findAll();

    void update_role_of_staff(Integer reg_no,Integer roleno);

     List<MyStaff> findByStaff_id(Integer id);

    //List<MyStaff> findByStaff_i(Integer regno,Integer roleno);

}
