package com.example.demo;

import com.example.demo.domain.loginDetails.LoginDetail;
import com.example.demo.domain.myStaff.MyStaff;
import com.example.demo.domain.myStaffRoles.MyStaffRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class UserDetailImpl implements UserDetails {

    private LoginDetail loginDetail;


    public UserDetailImpl(@Autowired LoginDetail loginDetail) {
        this.loginDetail = loginDetail;
    }

    
 @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return new LoginDetail().getPassword();
    }

    @Override
    public String getUsername() {
        return new LoginDetail().getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }




}
