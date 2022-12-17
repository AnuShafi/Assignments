package com.example.customer_reward.resources;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.customer_reward.models.CustomerDetailsDTO;
import com.example.customer_reward.models.CustomerRewardsDTO;
import com.example.customer_reward.services.CustomerService;

@RestController
@Validated
@RequestMapping("/rewards")
public class CustomerResource {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value="/list",method = RequestMethod.POST,consumes = {"application/JSON", "application/XML"})
	public ResponseEntity<CustomerRewardsDTO> getTotalAmount(@RequestBody @Valid CustomerDetailsDTO customerDetailsDTO) {
		CustomerRewardsDTO customerRewardsDTO=customerService.getCustomerRewards(customerDetailsDTO);
		return new ResponseEntity<CustomerRewardsDTO>(customerRewardsDTO, HttpStatus.CREATED);
	}

}
