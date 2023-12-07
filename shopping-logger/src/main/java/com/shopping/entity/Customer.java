package com.shopping.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
@Entity
public class Customer {
	

   
	public Customer() {
		super();
	}

	public Customer(Long cId, @NotNull(message = "Name is mandatory") String cName,
			@NotBlank(message = "Address is required") @Size(max = 255, message = "Address must be at most 255 characters") String cAddress,
			@NotBlank(message = "Contact is required") @Pattern(regexp = "\\d{10}", message = "Contact must be a 10-digit number") String cContact) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cAddress = cAddress;
		this.cContact = cContact;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cId;

    @NotNull(message = "Name is mandatory")
    private String cName;

    @Override
	public String toString() {
		return "Customer [cId=" + cId + ", cName=" + cName + ", cAddress=" + cAddress + ", cContact=" + cContact + "]";
	}

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcAddress() {
		return cAddress;
	}

	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}

	public String getcContact() {
		return cContact;
	}

	public void setcContact(String cContact) {
		this.cContact = cContact;
	}

	@NotBlank(message = "Address is required")
    @Size(max = 255, message = "Address must be at most 255 characters")
    private String cAddress;

    @NotBlank(message = "Contact is required")
    @Pattern(regexp = "\\d{10}", message = "Contact must be a 10-digit number")
    private String cContact;

	
}
