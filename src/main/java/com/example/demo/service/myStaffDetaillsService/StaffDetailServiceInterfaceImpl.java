package com.example.demo.service.myStaffDetaillsService;


import com.example.demo.domain.myStaff.MyStaff;
import com.example.demo.domain.myStaffRoles.MyStaffRoles;
import com.example.demo.repository.myStaffLoginDetailrepository.MyMainStaffLoginRepo;
import com.example.demo.repository.myStaffRepository.MyMainRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class StaffDetailServiceInterfaceImpl implements StaffDetailServiceInterface {


    private final MyMainRepo staffRepo;
    private MyMainStaffLoginRepo loginRepo;


    public StaffDetailServiceInterfaceImpl(
            @Autowired MyMainRepo repository,@Autowired MyMainStaffLoginRepo loginRepo) {
        this.staffRepo = repository;
        this.loginRepo = loginRepo;
    }

    @Override
    public List<MyStaff> findByStaff_id(Integer regno) {
        return staffRepo.findByStaff_id(regno);
    }
/*
    public List<MyStaff> findByStaff_i(Integer regno,Integer roleno) {
        return staffRepo.findByStaff_i( regno,roleno);
    }

 */


    @Override
    public void createStaff(
            String surname, String middlename,
            String lastname, String telephone, String referal,
            String profession,String username) {

       Integer reg_no=0;

        MyStaff staff= new MyStaff(reg_no,surname,middlename,lastname,telephone,
                referal,profession,username);

        Collection<MyStaffRoles> roles = new ArrayList<>();
        roles.add(new MyStaffRoles(2));

        staff.setRoles(roles);
         staffRepo.save(staff);
    }


    @Override
    public void update_role_of_staff(Integer reg_no,Integer roleno) {


        Collection<MyStaffRoles> roles = new ArrayList<>();
        roles.add(new MyStaffRoles(2));

        MyStaff staff= new MyStaff();
        staff.setRegno(reg_no);
        staff.setRoles(roles);
        staffRepo.save(staff);
    }

    @Override
    public Integer findTopByOrderByRegnoDesc() {
        return staffRepo.findTopByOrderBy();
    }


    @Override
    public void updateStaff(
            Integer reg_no,String surname,String middlename,String lastname,
            String telephone,String referal, String profession) {

        MyStaff Staff= new MyStaff(reg_no,surname,middlename,lastname,telephone,
                referal,profession,loginRepo.findTopByBy(reg_no));

        MyStaff myStaff = staffRepo.saveAndFlush(Staff);

    }


    public MyStaff saveStudents(MyStaff staffss){
        MyStaff myStaff = staffRepo.save(staffss);
        return myStaff;
    }


    @Override
    public Optional<MyStaff> findById(Integer id) {
        Optional<MyStaff> staff = staffRepo.findById(id);

        return staff;
    }


    @Override
    public MyStaff updateStudent(MyStaff student) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public List<MyStaff> findByLastname(String lastname) {
        List<MyStaff>  staff = staffRepo.findByLastname(lastname);
        return staff;
    }

    @Transactional(readOnly = true)
    @Override
    public List<MyStaff> findAll() {
        List<MyStaff>  staff = staffRepo.findAll();
        return staff;
    }
}







/*

    // private StaffBiosRepositories staffRepo;
    @Modifying
    @Query(
            value =
                    "insert into Users (stafid, , Suname, Middlename,Lastname,telephone," +
                            "Referal," +
                            "Professiion)" +
                            " values (:pleaseer,:pleasee,:please,:pleas,:plea,:ple,:pl,:p)",
            nativeQuery = true)
    @Override
    public StaffBios savestudent(@Param("pleaseer")Integer pleaseer, @Param("pleasee")String pleasee,
                                 @Param("please")String please, @Param("pleas")String pleas,
                                 @Param("plea")Long ple, @Param("ple")String pl, @Param("p")String p){
        StaffBios staffs = new StaffBios(pleaseer,pleasee,please,pleas,ple,pl,p);
        return save(staffs);
    }



 */



