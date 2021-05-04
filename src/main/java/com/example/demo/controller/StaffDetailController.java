package com.example.demo.controller;

import com.example.demo.domain.loginDetails.LoginDetail;
import com.example.demo.domain.myStaff.MyStaff;
import com.example.demo.domain.myStaffRoles.MyStaffRoles;
import com.example.demo.service.myStaffDetaillsService.StaffDetailServiceInterface;
import com.example.demo.service.myStaffLoginDetailsService.StaffLoginDetailsServiceInterface;
import com.example.demo.service.myStaffRolesService.StaffRolesServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class StaffDetailController {

    private final StaffDetailServiceInterface staffDetailServiceInterface;
    private final StaffLoginDetailsServiceInterface loginDetailsServiceInterface;
    private final StaffRolesServiceInterface rolesServiceInterface;

    public StaffDetailController(@Autowired StaffDetailServiceInterface
                                         staffDetailServiceInterface,
                                 @Autowired StaffLoginDetailsServiceInterface
                                         loginDetailsServiceInterface,
                                 @Autowired StaffRolesServiceInterface rolesServiceInterface)
    {
        this.staffDetailServiceInterface = staffDetailServiceInterface;
        this.loginDetailsServiceInterface = loginDetailsServiceInterface;
        this.rolesServiceInterface = rolesServiceInterface;
    }


    @GetMapping("/")
    public ModelAndView viewindexpage(ModelAndView mvc) {
        mvc = new ModelAndView();
        mvc.setViewName("index");
        return mvc;
    }

    @GetMapping("/loginpageofhomeofstaff")
    public ModelAndView bringloginform(ModelAndView mvc) {
        mvc = new ModelAndView();
        mvc.setViewName("loginpageofhomeofstaffs");
        return mvc;
    }

    //////////////////////////// login ////////////////////////////////////
    @GetMapping("/loginofhomeofstaff")
    public ModelAndView loginstaffpage(
            ModelAndView mvc, @RequestParam("name") String username,
            @RequestParam("password") String password) {

        mvc = new ModelAndView();
        List<LoginDetail> list = loginDetailsServiceInterface.findByUsernameAndPassword(
                username, password);

        if (list.isEmpty()) {
            mvc.setViewName("#");
            return mvc;
        }

        mvc.setViewName("loggedin");
        return mvc;
    }
    /////////////////////////// ADMIN PAGE//////////////////////

    @GetMapping("/centralpageforadmin")
    public ModelAndView centralpageforadmin(ModelAndView mvc) {
        mvc = new ModelAndView();
        mvc.setViewName("centralpageforadmin");
        return mvc;
    }
//////////////////////////check last reg no////////////////////////////////////

    @GetMapping("/checklastregno")
    public Integer getALlPersons() {

        return staffDetailServiceInterface.findTopByOrderByRegnoDesc();
    }

    //////////////////////////// view staff reg no //////////////////////
    @GetMapping("/viewstaff")
    public Optional<MyStaff> viewstaff(
            @RequestParam("reg_no") Integer reg_no) {
        if (reg_no != null) {
            Optional<MyStaff> person = staffDetailServiceInterface.findById(reg_no);
            return person;
        }
        return Optional.empty();
    }

    /////////////////////////// create staff //////////////////////
    @GetMapping("/createstaff")
    public ModelAndView createstaff(ModelAndView mvc) {
        mvc = new ModelAndView();
        mvc.setViewName("createstaff");
        return mvc;
    }

    @PostMapping("/createstafffunction")
    public String createstafffunction(
            @RequestParam("surName") String surname,
            @RequestParam("middleName") String middlename,
            @RequestParam("lastName") String lastname,
            @RequestParam("telephone") String telephone,
            @RequestParam("referal") String referal,
            @RequestParam("profession") String profession,
            @RequestParam("userName") String username,
            @RequestParam("password") String password,
            @RequestParam("confirmpassword") String confirmpassword) {


        if (password.equals(confirmpassword)) {

            staffDetailServiceInterface.createStaff(
                    surname, middlename, lastname, telephone, referal,
                    profession, username);

            loginDetailsServiceInterface.createStaffLogin(username, confirmpassword);

            return "registered";
        }

        return "not registered: check your passwords";
    }

    /////////////////////////// update staff reg no//////////////////////
    @GetMapping("/updatestaff")
    public ModelAndView updatestaff(ModelAndView mvc) {
        mvc = new ModelAndView();
        mvc.setViewName("updatestaff");
        return mvc;
    }

//////

    @PostMapping("/updatestafffunction")
    public String updatestafffunction(@RequestParam("reg_no") Integer reg_no,
                                      @RequestParam("surname") String surname,
                                      @RequestParam("middlename") String middlename,
                                      @RequestParam("lastname") String lastname,
                                      //@RequestParam("age") Integer age,
                                      @RequestParam("telephone") String telephone,
                                      @RequestParam("referal") String referal,
                                      @RequestParam("profession") String profession) {


        Optional<MyStaff> list = staffDetailServiceInterface.findById(reg_no);

        if (list.isPresent()) {
            staffDetailServiceInterface.updateStaff(
                    reg_no, surname, middlename, lastname, telephone, referal,
                    profession);

            return "updated";
        }
        return "Please you can't register new patient here";

    }


///////////////////////////update Each staff roles //////////////////////

    @GetMapping("/updateEachstaffroles")
    public ModelAndView updateEachstaffroles(ModelAndView mvc) {
        mvc = new ModelAndView();
        mvc.setViewName("updateEachstaffroles");
        return mvc;
    }

    /////
    @PostMapping("/updateEachstaffrolesfxn")
    public String updateEachstaffrolesfxn(@RequestParam("reg_no") Integer reg_no,
                                          @RequestParam("roleno") Integer roleno) {


        Optional<MyStaff> list = staffDetailServiceInterface.findById(reg_no);

        if (list.isPresent()) {
            staffDetailServiceInterface.update_role_of_staff(reg_no, roleno);

            return "updated";
        }
        return "Please you can't register new patient here";

    }

    //////////////////////////// view staff login reg no //////////////////////
    @GetMapping("/viewstafflogindetail")
    public List<LoginDetail> viewstafflogindetail(
            @RequestParam("reg_no") Integer reg_no) {
        List<LoginDetail> person = loginDetailsServiceInterface.findByStaffRegNo(reg_no);
        return person;
    }

//////////////////////////// create roles //////////////////////

    @GetMapping("/createroles")
    public ModelAndView createroles(ModelAndView mvc) {
        mvc = new ModelAndView();
        mvc.setViewName("createroles");
        return mvc;
    }

    @PostMapping("/createrolesfunction")
    public MyStaffRoles createrolesfunction(@RequestParam("serialNo") Integer serialNo,
                                            @RequestParam("role") String role) {
        return rolesServiceInterface.createRoles(serialNo, role);
    }

//////////////////////////// update roles //////////////////////

    @GetMapping("/updateroles")
    public ModelAndView updateroles(ModelAndView mvc) {
        mvc = new ModelAndView();
        mvc.setViewName("updateroles");
        return mvc;
    }

    /////
    @PostMapping("/updaterolesfunction")
    public MyStaffRoles updaterolesfunction(@RequestParam("serialNo") Integer serialNo,
                                            @RequestParam("role") String role) {
        return rolesServiceInterface.createRoles(serialNo, role);
    }
//////////////////////////// view roles //////////////////////

    @GetMapping("/viewroles")
    public List<MyStaffRoles> viewroles() {
        return rolesServiceInterface.findAll();

    }
///////////////////////////////////////////////////////
    @GetMapping(value = "ll")
    public List<MyStaff> findByStaff_id(@RequestParam("param") Integer regno) {
        return staffDetailServiceInterface.findByStaff_id(regno);
    }

/////////////////////////////////////////////////////////////////
}