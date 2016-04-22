package com.onuz.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "person_detail", catalog = "oto_test")
public class PersonDetail implements java.io.Serializable {

	private Integer personId;
	private Person person;
	private Date birthDate;
	private String birthPlace;
	private String city;
	private String identityNo;

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "person"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "PERSON_ID", unique = true, nullable = false)
	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTH_DATE", nullable = false, length = 100)
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	@Column(name = "BIRTH_PLACE", nullable = false)
	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	@Column(name = "CITY", nullable = false)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "IDENTITY_NO", nullable = false)
	public String getIdentityNo() {
		return identityNo;
	}

	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}

	public PersonDetail() {
	}

	public PersonDetail(Person person, String birthPlace, String city,
			String identityNo, Date birthDate) {
		this.person = person;
		this.birthDate = birthDate;
		this.birthPlace = birthPlace;
		this.city = city;
		this.identityNo = identityNo;
	}
	
}
