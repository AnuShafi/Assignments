package com.example.customer_reward.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.customer_reward.models.CustomerDTO;
import com.example.customer_reward.models.CustomerDetailsDTO;
import com.example.customer_reward.models.CustomerRewardsDTO;
import com.example.customer_reward.models.RewardsDTO;
import com.example.customer_reward.utils.CustomerDateComparator;
import com.example.customer_reward.utils.MonthClass;



@Service
@Validated
public class CustomerService {
	
	public CustomerRewardsDTO getCustomerRewards(@Valid CustomerDetailsDTO customerDetailsDTO) {
		HashSet<Integer> customerSet=new HashSet<Integer>();
		Collections.sort(customerDetailsDTO.getCustRewardList());
		ArrayList<CustomerDTO> customerList=customerDetailsDTO.getCustRewardList();
		customerList.stream().
				forEach(c->customerSet.add(c.getId()));
		HashMap<String,Float> custMnthRewardMap= null;
		CustomerRewardsDTO finalDto=null;
		List<RewardsDTO> customerRewardDetailsList=null;
		finalDto=new CustomerRewardsDTO();
		customerRewardDetailsList= new ArrayList<RewardsDTO>();
		
		for(Integer i:customerSet) {
			float rewards=0;
			float totalReward=0;
			ArrayList<CustomerDTO> eachCustList=null;
			custMnthRewardMap= new HashMap<String,Float>();
			int month=0;
			int preMonth=0;
			RewardsDTO rewardObj=null;
			float month_totalReward=0;
			boolean mnthFlag=true;
			int cust_id =0;
			String cust_name= "";
			eachCustList=getCustomer(customerList, i);
			for(CustomerDTO c:eachCustList) {
				month=c.getPurchase_date().getMonth();
				if(mnthFlag) {
					preMonth=month;
					cust_id=c.getId();
					cust_name=c.getName();
					mnthFlag=false;
				}
				rewards = findRewardsForMonth(rewards, c);
				if(checkIfSameMonth(month, preMonth)) {
						totalReward+=rewards;
						custMnthRewardMap.put(MonthClass.getMonth(month),totalReward);
						preMonth=month;
					}
					else {
						custMnthRewardMap.put(MonthClass.getMonth(month),rewards);
						preMonth=month;
					}
				month_totalReward+=rewards;
				
			}
			rewardObj= new RewardsDTO(cust_id, cust_name,month_totalReward, custMnthRewardMap);
			customerRewardDetailsList.add(rewardObj);
			finalDto.setCustomerRewardDetailsList(customerRewardDetailsList);
			
			}
		return finalDto;
		
	}

	private boolean checkIfSameMonth(int month, int preMonth) {
		return month==preMonth;
	}

	private float findRewardsForMonth(float rewards, CustomerDTO c) {
		if(c.getPurchase_amount()>100) {
			rewards=50+(c.getPurchase_amount()-100)*2;
		}
		else if(c.getPurchase_amount()>50 && c.getPurchase_amount()<100) {
			rewards= c.getPurchase_amount()-50;
			}
		return rewards;
	}

	private ArrayList<CustomerDTO> getCustomer(ArrayList<CustomerDTO> customerList,int intValue) {
		ArrayList<CustomerDTO> eachCustList=(ArrayList<CustomerDTO>) customerList.stream().filter(c->c.getId()==intValue).collect(Collectors.toList());
		Collections.sort(eachCustList, new CustomerDateComparator());
		return eachCustList;
	}

}
