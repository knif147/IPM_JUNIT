package com.ou.support;

import com.ou.entity.Account;
import com.ou.entity.User;

public class UserBuilder extends EntityBuilder<User> {
	@Override
	void initProduct() {
		this.product = new User();
	}

	public UserBuilder credentials(String userName,String fullName,String phoneNumber,
			String email,String password,int role,Boolean status,Boolean gender,String address) {
		this.product.setUserName(userName);
		this.product.setFullName(fullName);
		this.product.setPhoneNumber(phoneNumber);
		this.product.setEmail(email);
		this.product.setPassword(password);
		this.product.setRole(role);
		this.product.setStatus(status);
		this.product.setGender(gender);
		this.product.setAddress(address);
		return this;
	}
	@Override
	User assembleProduct() {
		return this.product;
	}

}
