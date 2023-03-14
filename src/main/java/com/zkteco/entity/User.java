package com.zkteco.entity;

import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.type.TrueFalseConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_table")

public class User {

	@Id
	@Column(name = "user_Id", length = 36, unique = true)
	@NotBlank(message = "Please Enter userId")
	private String userId;
	
	@Column(name = "first_Name", length = 50, nullable = false)
	@NotBlank(message = "Please Enter firstName")
	private String firstName;
	
	@Column(name = "Last_Name", length = 50)
	private String lastName;
	
	@Column(name = "Gender")
	@Size(max = 1,message = "Maximum Size Should be 1")
	private String gender;
	
	@Column(name = "Email", nullable = false, unique = true)
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+[a-zA-Z]{2,}", message = "Please Write a Valid Email")
	@NotBlank(message = "Please Enter Email Address")
	private String email;
	
	@Column(name = "Phone", unique = true)
	@Pattern(regexp = "[+]+[0-9]{2}+[-]+[0-9]{10}", message = "Please Enter Valid Phone Number")
	private String phone;
	
	@Column(name = "Password", nullable = false)
//	@Pattern(regexp = "^(?=.*[A-Z])[A-Za-z0-9].{8,16}")
	@NotBlank(message = "Please Enter Password")
	private String password;
	
	@Column(name = "Date_of_Birth")
	private Date dateOfBirth;
	
	@Column(name = "Profile_Photo")
	private Boolean profilePhoto;
	
	@Column(name = "Create_Date")
	private LocalDate createDate;
	
	@Column(name = "Update_Date")
	private LocalDate updateDate;
	
}
