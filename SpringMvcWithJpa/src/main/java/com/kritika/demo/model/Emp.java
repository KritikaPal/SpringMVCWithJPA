package com.kritika.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Emp 
{
	@Id
	private Integer empNo;
	private String empName;
	private Float empSal;
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Float getEmpSal() {
		return empSal;
	}
	public void setEmpSal(Float empSal) {
		this.empSal = empSal;
	}
}
