package com.onuz.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import com.onuz.entity.PersonDetail;

@Entity
@Table(name = "person", catalog = "oto_test", uniqueConstraints = {
		@UniqueConstraint(columnNames = "PERSON_NAME"),
		@UniqueConstraint(columnNames = "PERSON_SURNAME") })
public class Person implements java.io.Serializable {

	private Integer personId;
	private String personSurname;
	private String personName;
	private PersonDetail personDetail;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "PERSON_ID", unique = true, nullable = false)
	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	@Column(name = "PERSON_NAME", unique = true, nullable = false, length = 10)
	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	@Column(name = "PERSON_SURNAME", unique = true, nullable = false, length = 20)
	public String getPersonSurname() {
		return personSurname;
	}

	public void setPersonSurname(String personSurname) {
		this.personSurname = personSurname;
	}


	@OneToOne(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.ALL)
	public PersonDetail getPersonDetail() {
		return this.personDetail;
	}

	public void setPersonDetail(PersonDetail personDetail) {
		this.personDetail = personDetail;
	}
	
	
	public Person() {
	}

	public Person(String personName, String personSurname) {
		this.personName = personName;
		this.personSurname = personSurname;
	}

	public Person(String personName, String personSurname, PersonDetail personDetail) {
		this.personName = personName;
		this.personSurname = personSurname;
		this.personDetail = personDetail;
	}

}
