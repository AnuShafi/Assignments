package com.example.customer_reward.models;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;



public class CustomerDTO implements Comparable<CustomerDTO> {
	
	@Min(message="id should be greater than 0", value = 1)
	private int id;
	
	@NotBlank(message="Name cannot be b")
	private String name;
	
	@Min(message="Purchase amount should be greater than 0", value = 0)
	private float purchase_amount;
	
	@NotNull(message="Date cannot be null")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM-dd-yyyy")
	private Date purchase_date;
	
	public CustomerDTO() {
		super();
	}
	
	
	public CustomerDTO(int id,String name, float purchase_amount, Date purchase_date) {
		super();
		this.id = id;
		this.name=name;
		this.purchase_amount = purchase_amount;
		this.purchase_date = purchase_date;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getPurchase_amount() {
		return purchase_amount;
	}


	public void setPurchase_amount(float purchase_amount) {
		this.purchase_amount = purchase_amount;
	}


	public Date getPurchase_date() {
		return purchase_date;
	}


	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(purchase_amount);
		result = prime * result + ((purchase_date == null) ? 0 : purchase_date.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDTO other = (CustomerDTO) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(purchase_amount) != Float.floatToIntBits(other.purchase_amount))
			return false;
		if (purchase_date == null) {
			if (other.purchase_date != null)
				return false;
		} else if (!purchase_date.equals(other.purchase_date))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", purchase_amount=" + purchase_amount + ", purchase_date="
				+ purchase_date + "]";
	}


	
	@Override
	public int compareTo(CustomerDTO o) {
		// TODO Auto-generated method stub
		return this.id-o.id;
	}
	
	
}
