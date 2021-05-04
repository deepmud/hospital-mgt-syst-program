package com.example.demo;

import com.example.demo.domain.loginDetails.LoginDetail;
import com.example.demo.repository.myStaffLoginDetailrepository.MyJpaStaffLoginRepo;
import com.example.demo.repository.myStaffLoginDetailrepository.MyMainStaffLoginRepo;
import com.example.demo.repository.myStaffRepository.MyMainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private MyMainStaffLoginRepo myMainRepo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        LoginDetail loginDetail = myMainRepo.findByUsername(s);
        if(loginDetail == null){
            throw new UsernameNotFoundException("usersss not found");
        }

        return new UserDetailImpl(loginDetail);

    }


}


