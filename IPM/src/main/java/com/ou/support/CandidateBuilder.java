package com.ou.support;

import org.springframework.stereotype.Component;

import com.ou.entity.Candidate;

@Component
public class CandidateBuilder extends EntityBuilder<Candidate> {
	private Candidate product;

	@Override
	void initProduct() {
		product = new Candidate();
	}

	public CandidateBuilder idCard(String idCard) {
		product.setIdCard(idCard);
		return this;
	}

	public CandidateBuilder fullName(String fullName) {
		product.setFullName(fullName);
		return this;
	}

	public CandidateBuilder email(String email) {
		product.setEmail(email);
		return this;
	}

	public CandidateBuilder phoneNumber(String phoneNumber) {
		product.setPhoneNumber(phoneNumber);
		return this;
	}

	public CandidateBuilder address(String address) {
		product.setAddress(address);
		return this;
	}

	public CandidateBuilder status(Boolean status) {
		product.setStatus(status);
		return this;
	}

	public CandidateBuilder gender(Boolean gender) {
		product.setGender(gender);
		return this;
	}

	@Override
	Candidate assembleProduct() {
		return product;
	}
}
