package com.example.customer_reward.utils;

import java.util.Comparator;

import com.example.customer_reward.models.CustomerDTO;

public class CustomerDateComparator implements Comparator<CustomerDTO>  {

	@Override
	public int compare(CustomerDTO o1, CustomerDTO o2) {
		// TODO Auto-generated method stub
		return o1.getPurchase_date().compareTo(o2.getPurchase_date());
	}

}
