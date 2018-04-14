package com.test.restapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.ou.services.CandidateService;
import com.ou.validator.CandidateValidator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/applicationContext.xml"})
@WebAppConfiguration
public class CandidateControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	CandidateService candidateService;

	@Autowired
	CandidateValidator candidateValidator;
	
	@Test
	public void HrCandidate()  throws Exception {
		 
	}
}
