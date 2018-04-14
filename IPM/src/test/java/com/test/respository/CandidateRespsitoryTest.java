package com.test.respository;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ou.entity.Candidate;
import com.ou.repository.CandidateRepository;
import com.ou.support.CandidateBuilder;
import com.ou.support.EntityBuilder.EntityBuilderManager;

public class CandidateRespsitoryTest {
	@Autowired
	private CandidateRepository candidateRepository;
	@PersistenceContext
	private EntityManager entityManager;

	private Candidate candidate;

	@Before
	public void setupData() {
		EntityBuilderManager.setEntityManager(entityManager);

		candidate = new CandidateBuilder() {
			{

				idCard("111111");
				fullName("TranTrungKien");
				email("kiencaothang@gmail.com");
				phoneNumber("0163650607052");
				address("12.5 duong quang ham go vap");
				status(true);
				gender(true);
			}
		}.build();
	}

	@After
	public void tearDown() {
		EntityBuilderManager.clearEntityManager();
	}
	@Test
	public void testFindById() {
		entityManager.flush();
		Candidate candidate = candidateRepository.findOne(this.candidate.getId());
		assertEquals(this.candidate.getId(), candidate.getId());
}

}
