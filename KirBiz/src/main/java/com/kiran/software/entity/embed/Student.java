package com.kiran.software.entity.embed;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Student {

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	@Embedded
	@ElementCollection
	@AttributeOverride(name="zipcode", column=@Column(name="ZIP_CODE"))
	@JoinTable(name="Stud_Add", joinColumns={@JoinColumn(name="STUD_ID")})
	@NotFound(action=NotFoundAction.IGNORE)
	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	
	
	@Id
	@SequenceGenerator(name="student_seq", sequenceName="student_seq", initialValue=1000)
	@GeneratedValue(generator="student_seq", strategy=GenerationType.AUTO)
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	private String studentName;
	
	private int studentId;
	
	private Set<Address> addresses = new HashSet<Address>();

}
