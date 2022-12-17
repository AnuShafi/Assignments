package com.example.customer_reward.models;

import java.util.HashMap;

public class RewardsDTO {
	
	private int id;
	
	private String name;
	
	private float total_reward;
	
	private HashMap<String, Float> month_reward=new HashMap<String, Float>();
	
	public RewardsDTO() {
		super();
	}
	
	
	
	public RewardsDTO(int id, String name, float total_reward, HashMap<String, Float> custMnthRewardMap) {
		super();
		this.id = id;
		this.name = name;
		this.total_reward = total_reward;
		this.month_reward = custMnthRewardMap;
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

	/*
	 * public String getReward_month() { return reward_month; }
	 * 
	 * public void setReward_month(String reward_month) { this.reward_month =
	 * reward_month; }
	 */

	public float getTotal_reward() {
		return total_reward;
	}

	public void setTotal_reward(float total_reward) {
		this.total_reward = total_reward;
	}

	public HashMap<String, Float> getMonth_reward() {
		return month_reward;
	}

	public void setMonth_reward(HashMap<String, Float> month_reward) {
		this.month_reward = month_reward;
	}



	@Override
	public String toString() {
		return "Rewards [id=" + id + ", name=" + name + ", total_reward="
				+ total_reward + ", month_reward=" + month_reward + "]";
	}

	

	}
