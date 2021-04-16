package com.example.demo.repository.myStaffRepository;

import com.example.demo.domain.myStaff.MyStaff;
//import com.example.demo.repository.myStaffRepository.MyJpaRepo;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyMainRepo extends MyJpaRepo<MyStaff,Integer> {

    List<MyStaff> findByLastname(String lastname);

    @Query(value="select MAX(s.regno) from MyStaff s")
    Integer findTopByOrderBy();


    @Query("FROM MyStaff AS rdt INNER JOIN rdt.roles AS cm WHERE rdt.regno = ?1")
    List<MyStaff> findByStaff_id(Integer id);

}
