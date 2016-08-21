package com.kiran.software.entity.manytomany;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.kiran.software.entity.onetomany.Customer;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name="[FGROUP]")
public class Group {

	@Id
	@SequenceGenerator(initialValue=1, name="group_seq", sequenceName="group_seq")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="group_seq")
	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	@JoinTable(
			name="FGroup_Student",
			joinColumns=@JoinColumn(name="Group_Id"),
			inverseJoinColumns=@JoinColumn(name="Student_Id"))
	@ManyToMany(cascade=CascadeType.ALL)
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	private List<Student> students = new ArrayList<Student>();

	private String groupName;
	
	private int groupId;
}
