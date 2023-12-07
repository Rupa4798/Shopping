package com.shopping.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.shopping.repository.CustomerRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerServiceTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CustomerRepository repo;
	
	
	/*@Test
	
	 void findProductById_OK() throws Exception{
		
		mockMvc.perform(get("/api/department/1"))
       .andExpect(content().contentType("application/json"))
       .andExpect(status().isOk())
       .andExpect(jsonPath("$.deptID", is(1)))
       .andExpect(jsonPath("$.deptName", is("rupa")))
       .andExpect(jsonPath("$.deptCode", is(67)));

			verify(deptrepo, times(1)).findById(1);
}*/
	
	
}
