package com.shopping.test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.test.web.servlet.MockMvc;

import com.shopping.entity.Customer;
import com.shopping.repository.CustomerRepository;
import com.shopping.service.CustomerService;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerServiceTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private CustomerRepository repo;
	
	@InjectMocks
    private CustomerService customerService;
	
	
	  @Test
	    public void testGetAllCustomers() {
	        // Arrange
	        List<Customer> mockCustomers = new ArrayList<>();
	        when(repo.findAll()).thenReturn(mockCustomers);

	        // Act
	        List<Customer> result = customerService.getAllCustomers();

	        // Assert
	        assertEquals(mockCustomers, result);
	    }
	  
	  @Test
	    public void testGetCustomerById() {
	        // Arrange
	        Long customerId = 1L;
	        Customer mockCustomer = new Customer();
	        when(repo.findById(customerId)).thenReturn(Optional.of(mockCustomer));

	        // Act
	        Customer result = customerService.getCustomerById(customerId);

	        // Assert
	        assertEquals(mockCustomer, result);
	    }
	  
	  @Test
	    public void testAddCustomer() {
	        // Arrange
	        Customer newCustomer = new Customer();
	        when(repo.save(newCustomer)).thenReturn(newCustomer);

	        // Act
	        Customer result = customerService.addCustomer(newCustomer);

	        // Assert
	        assertEquals(newCustomer, result);
	        verify(repo, times(1)).save(newCustomer);
	    }

	  @Test
	  public void testUpdateCustomer() {
	      // Arrange
	      Long customerId = 1L;
	      Customer existingCustomer = new Customer();
	      when(repo.findById(customerId)).thenReturn(Optional.of(existingCustomer));

	      Customer updatedCustomer = new Customer();
	      updatedCustomer.setcName("UpdatedName");

	      // Mock the save method to return the updated customer
	      when(repo.save(existingCustomer)).thenReturn(updatedCustomer);

	      // Act
	      Customer result = customerService.updateCustomer(customerId, updatedCustomer);

	      // Assert
	      assertNotNull(result);
	      assertEquals(updatedCustomer.getcName(), result.getcName());
	      verify(repo, times(1)).findById(customerId);
	      verify(repo, times(1)).save(existingCustomer);
	  }
	  
	
}
