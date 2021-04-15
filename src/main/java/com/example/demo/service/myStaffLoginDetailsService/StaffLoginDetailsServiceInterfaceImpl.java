package com.example.demo.service.myStaffLoginDetailsService;

import com.example.demo.domain.loginDetails.LoginDetail;
import com.example.demo.domain.myStaff.MyStaff;
import com.example.demo.repository.myStaffLoginDetailrepository.MyMainStaffLoginRepo;
import com.example.demo.service.myStaffDetaillsService.StaffDetailServiceInterface;
import com.example.demo.service.myStaffDetaillsService.StaffDetailServiceInterfaceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffLoginDetailsServiceInterfaceImpl implements StaffLoginDetailsServiceInterface
{

    private final MyMainStaffLoginRepo loginrepo;
    private final StaffDetailServiceInterface ses;

    public StaffLoginDetailsServiceInterfaceImpl(
            @Autowired MyMainStaffLoginRepo repo,@Autowired StaffDetailServiceInterface ses) {
        this.loginrepo = repo;
        this.ses = ses;
    }

    @Override
    public List<LoginDetail> findAll() {
        return loginrepo.findAll();
    }

    @Override
    public Optional<LoginDetail> findById(Integer myStaff) {
        return loginrepo.findById(myStaff);
    }

    @Override
    public List<LoginDetail> findByStaffRegNo(Integer reg_no){
        return loginrepo.findByStaffRegNo(reg_no);
    }

    @Override
    public List<LoginDetail> findByUsernameAndPassword(String username,String password) {
        return loginrepo.findByUsernameAndPassword(username,password);
    }

    @Override
    public String findTopByBy(Integer staffRegNo) {
        return loginrepo.findTopByBy(staffRegNo);

    }

    @Override
    public void createStaffLogin(String username, String confirmpassword) {
        Integer serial_no = 0;
        //Integer reg_no=0;

        LoginDetail login = new LoginDetail(
                serial_no,username,confirmpassword,ses.findTopByOrderByRegnoDesc());
        loginrepo.save(login);
    }

}
