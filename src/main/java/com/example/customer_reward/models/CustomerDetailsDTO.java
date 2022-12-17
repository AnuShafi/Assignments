package com.example.customer_reward.models;

import java.util.ArrayList;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;



public class CustomerDetailsDTO {
	
	@Valid	
	@NotEmpty(message="List cannot be null")
	private ArrayList<CustomerDTO> custRewardList = new ArrayList<CustomerDTO>();

	public ArrayList<CustomerDTO> getCustRewardList() {
		
		return custRewardList;
	}

	public void setCustRewardList(ArrayList<CustomerDTO> custRewardList) {
		this.custRewardList = custRewardList;
	}
	
	

}
