package com.kritika.demo.repoistory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kritika.demo.model.Emp;

public interface EmpRepoistory extends JpaRepository<Emp, Integer>
{

}
