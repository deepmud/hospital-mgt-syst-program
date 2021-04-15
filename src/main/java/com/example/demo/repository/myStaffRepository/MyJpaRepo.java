package com.example.demo.repository.myStaffRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MyJpaRepo<T,ID> extends JpaRepository<T,ID> {
}
