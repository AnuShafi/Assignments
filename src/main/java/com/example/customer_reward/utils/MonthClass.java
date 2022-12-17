package com.example.customer_reward.utils;

import com.example.customer_reward.utils.ServiceException.StatusCode;

public class MonthClass {
	
	public static String getMonth(int no) {
		String str;
		switch(no) {
		case 0: return "Jan"; 
		case 1: return "Feb"; 
		case 2: return "Mar"; 
		case 3: return "Apr"; 
		case 4: return "May"; 
		case 5: return "Jun"; 
		case 6: return "Jul"; 
		case 7: return "Aug"; 
		case 8: return "Sep"; 
		case 9: return "Oct"; 
		case 10: return "Nov"; 
		case 11: return "Dec"; 
		default:
			throw new ServiceException(StatusCode.INVALID_REQUEST);
		
		}
		
	}

	
}
