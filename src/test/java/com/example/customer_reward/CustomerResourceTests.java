package com.example.customer_reward;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.customer_reward.models.CustomerDTO;
import com.example.customer_reward.models.CustomerDetailsDTO;
import com.example.customer_reward.models.CustomerRewardsDTO;
import com.example.customer_reward.models.RewardsDTO;
import com.example.customer_reward.services.CustomerService;

@SpringBootTest
class CustomerResourceTests {
	@Mock
	CustomerService customerService;

	DateFormat df=new SimpleDateFormat("MM-dd-yyyy");
	
	
	@Test
	void test() throws ParseException {
		CustomerDetailsDTO customerDetailsDTO =new CustomerDetailsDTO();
		ArrayList<CustomerDTO> custRewardList = new ArrayList<CustomerDTO>();
		CustomerDTO cust1=new CustomerDTO(1,"Anu",60, df.parse("10-12-2022"));
		custRewardList.add(cust1);
		customerDetailsDTO.setCustRewardList(custRewardList);
		
		CustomerRewardsDTO customerRewardsDTO=new CustomerRewardsDTO();
		List<RewardsDTO> customerRewardDetailsList= new ArrayList<RewardsDTO>();
		customerRewardsDTO.setCustomerRewardDetailsList(customerRewardDetailsList);
		HashMap<String, Float> custMnthRewardMap=new HashMap<String, Float>();
		custMnthRewardMap.put("Oct", 10f);
		RewardsDTO rewardsDTO=new RewardsDTO(1, "Anu", 10, custMnthRewardMap);
		customerRewardDetailsList.add(rewardsDTO);
		//CustomerRewardsDTO customerRewardsDTO1=;
		when(customerService.getCustomerRewards(customerDetailsDTO)).thenReturn(customerRewardsDTO);
		assertEquals(1, customerRewardDetailsList.size());
	}

}
