package com.example.customer_reward.models;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import io.micrometer.core.lang.NonNull;

public class CustomerRewardsDTO {
	

	private List<RewardsDTO> customerRewardDetailsList= new ArrayList<RewardsDTO>();
	
	public List<RewardsDTO> getCustomerRewardDetailsList() {
		return customerRewardDetailsList;
	}

	public void setCustomerRewardDetailsList(List<RewardsDTO> customerRewardDetailsList) {
			
		this.customerRewardDetailsList = customerRewardDetailsList;
	}
	
	
	

}
