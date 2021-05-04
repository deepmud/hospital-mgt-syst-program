package com.example.demo.repository.myStaffLoginDetailrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MyJpaStaffLoginRepo<T,ID> extends JpaRepository<T,ID> {
}


