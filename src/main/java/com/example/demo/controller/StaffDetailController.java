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

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/")
public class StaffDetailController {

    private StaffDetailServiceInterface dao;
    private StaffLoginDetailsServiceInterface daos;
    private StaffRolesServiceInterface daose;

    public StaffDetailController( @Autowired StaffDetailServiceInterface dao,
                                  @Autowired StaffLoginDetailsServiceInterface daos,
                                  @Autowired StaffRolesServiceInterface daose) {
        this.dao=dao;
        this.daos=daos;
        this.daose=daose;
    }
///////////////////////////////////////////////////////
    @GetMapping(value="ll")
    public List<MyStaff> findByStaff_id(@RequestParam("param")Integer regno){
        return dao.findByStaff_id(regno);
    }
/*
    @PostMapping(value="lls")
    public List<MyStaff> findByStaff_i(
            @RequestParam("regno")Integer regno,
            @RequestParam("roleno")Integer roleno){
        return dao.findByStaff_i(regno,roleno);
    }

   */

/////////////////////////////////////////////////////////////////


    @GetMapping("/")
    public ModelAndView mainstaffpage(ModelAndView mvc){
        mvc = new ModelAndView();
        mvc.setViewName("index");
        return mvc;
    }

    @GetMapping("/loginpageofhomeofstaff")
    public ModelAndView mainstaff(ModelAndView mvc){
        mvc = new ModelAndView();
        mvc.setViewName("loginpageofhomeofstaffs");
        return mvc;
    }
//////////////////////////// login ////////////////////////////////////
    @GetMapping("/loginofhomeofstaff")
    public ModelAndView staffloginpage(
            ModelAndView mvc, @RequestParam("name") String username,
            @RequestParam("password") String password) {

        mvc = new ModelAndView();
        List<LoginDetail> list = daos.findByUsernameAndPassword(username, password);

        if (list.isEmpty()) {
            //mvc.addObject("chose", "zz");
            mvc.setViewName("#");
            return mvc;
        }

        mvc.setViewName("loggedin");
        return mvc;
    }
    /////////////////////////// ADMIN PAGE//////////////////////

    @GetMapping("/centralpageforadmin")
    public ModelAndView centralpageforadmin(ModelAndView mvc){
        mvc = new ModelAndView();
        mvc.setViewName("centralpageforadmin");
        return mvc;
    }
//////////////////////////check last reg no////////////////////////////////////

    @GetMapping("/checklastregno")
    public Integer  getALlPersons() {

        return dao.findTopByOrderByRegnoDesc();
    }
    //////////////////////////// view staff reg no //////////////////////
    @GetMapping("/viewstaff")
    public  Optional<MyStaff>  viewstaff(
            @RequestParam("reg_no") Integer reg_no) {
        if(reg_no!=null){
            Optional<MyStaff> person = dao.findById(reg_no);
            return person;
        }
        return Optional.empty();
    }

/////////////////////////// create staff //////////////////////
    @GetMapping("/createstaff")
    public ModelAndView createstaff(ModelAndView mvc){
        mvc = new ModelAndView();
        mvc.setViewName("createstaff");
        return mvc;
}
    @PostMapping("/createstafffunction")
    public String createstafffunction(
                               @RequestParam("surname") String surname,
                               @RequestParam("middlename") String middlename,
                               @RequestParam("lastname") String lastname,
                               //@RequestParam("age") Integer age,
                               @RequestParam("telephone") String telephone,
                               @RequestParam("referal") String referal,
                               @RequestParam("profession") String profession ,
                               @RequestParam("username") String username,
                               @RequestParam("password") String password,
                               @RequestParam("confirmpassword") String confirmpassword)
                               {


         if(password.equals(confirmpassword)){

            dao.createStaff(
                    surname,middlename,lastname,telephone,referal,
             profession,username);

            daos.createStaffLogin(username,confirmpassword);

            return "registered";
         }

         return "not registered: check your passwords";
    }

/////////////////////////// update staff reg no//////////////////////
    @GetMapping("/updatestaff")
    public ModelAndView updatestaff(ModelAndView mvc){
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
                                       @RequestParam("profession") String profession){


        Optional<MyStaff> list = dao.findById(reg_no);

        if (list.isPresent()) {
            dao.updateStaff(
                    reg_no,surname,middlename,lastname,telephone,referal,
                    profession);

            return "updated" ;
        }
        return "Please you can't register new patient here";

    }



///////////////////////////update Each staff roles //////////////////////

    @GetMapping("/updateEachstaffroles")
    public ModelAndView updateEachstaffroles(ModelAndView mvc){
        mvc = new ModelAndView();
        mvc.setViewName("updateEachstaffroles");
        return mvc;
    }

/////
    @PostMapping("/updateEachstaffrolesfxn")
    public String updateEachstaffrolesfxn(@RequestParam("reg_no") Integer reg_no,
                                      @RequestParam("roleno") Integer roleno){


        Optional<MyStaff> list = dao.findById(reg_no);

        if (list.isPresent()) {
            dao.update_role_of_staff(reg_no,roleno);

            return "updated" ;
        }
        return "Please you can't register new patient here";

    }

//////////////////////////// view staff login reg no //////////////////////
    @GetMapping("/viewstafflogindetail")
    public  List<LoginDetail>  viewstafflogindetail(
            @RequestParam("reg_no") Integer reg_no) {
        List<LoginDetail> person = daos.findByStaffRegNo(reg_no);
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
                                      @RequestParam("role") String role){
        return daose.createRoles(serialNo,role);
    }

//////////////////////////// update roles //////////////////////

    @GetMapping("/updateroles")
    public ModelAndView updateroles(ModelAndView mvc) {
        mvc = new ModelAndView();
        mvc.setViewName("updateroles");
        return mvc; }

/////
    @PostMapping("/updaterolesfunction")
    public MyStaffRoles updaterolesfunction(@RequestParam("serialNo") Integer serialNo,
                                            @RequestParam("role") String role){
        return daose.createRoles(serialNo,role);
    }
//////////////////////////// view roles //////////////////////

    @GetMapping("/viewroles")
    public  List<MyStaffRoles> viewroles() {
        return daose.findAll();

    }

}




//////////////////////////////////////////////////////////////
/*
    @PostMapping("/save")
    public MyStaff savestudent(@RequestParam("password") Integer passwords,
                                 @RequestParam("passwor") String password,
                                 @RequestParam("passwo") String passwor,
                                 @RequestParam("passw") String passwo,
                                 //@RequestParam("pass") Integer passw,
                                 @RequestParam("pas") Long pass,
                                 @RequestParam("pa") String pas,
                                 @RequestParam("p") String pa) {
        MyStaff staff = dao.saveStudent(passwords,password,passwor,passwo,pass,pas,pa);
        return staff;
    }

    @PostMapping("/saves")
    @ResponseBody
    public MyStaff saveStudent(@RequestBody  MyStaff staff) {
        MyStaff  staffs = dao.saveStudents(staff);
        return staffs;
    }

    @GetMapping("/getAllS")
    public List<MyStaff>  getALlPersons(
            @RequestParam("name") String lastname,@RequestParam("password") Integer pass) {
        List<MyStaff> person = dao.findAll();
        return person;
    }
    @GetMapping("/getAl")
    public List<MyStaff>  getALlPerson(
            @RequestParam("name") String lastname, @RequestParam("password") Integer pass) {
        List<MyStaff> person = dao.findByLastname(lastname);
        return person;
    }

/*
    @GetMapping("/getAll")
    public Optional<MyStaff> getALlPersons(
    @RequestParam("password") Integer pass, @RequestParam("passwor")
    Integer pas, @RequestParam("passwo") Integer pa ) {
        Optional<MyStaff> person = dao.findById(pass);
        System.out.println(person);
        Optional<MyStaff> perso = dao.findById(pas);
        System.out.println(perso);
        Optional<MyStaff> pers = dao.findById(pa);
        System.out.println(pers);

        return pers;
    }



    @GetMapping("/getA")
    public List<MyStaff> getALlPerso(
    @RequestParam("password") String pass, @RequestParam("passwor")
    String pas, @RequestParam("passwo") String pa ) {
        System.out.println("hello\nhello");
        List<MyStaff> person = dao.findByLastname(pass);
        System.out.println(person);
        List<MyStaff> perso = dao.findByLastname(pas);
        System.out.println(perso);

        System.out.println(dao.findByLastname(pa));

        return perso;
    }


 */
