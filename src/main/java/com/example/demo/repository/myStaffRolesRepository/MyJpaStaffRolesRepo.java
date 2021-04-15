package com.example.demo.repository.myStaffRolesRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MyJpaStaffRolesRepo<T,ID> extends JpaRepository<T,ID> {

}



