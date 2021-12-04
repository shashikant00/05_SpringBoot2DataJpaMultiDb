package in.nareshit.raghu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nareshit.raghu.model.customer.Customer;
import in.nareshit.raghu.model.product.Product;
import in.nareshit.raghu.repo.customer.CustomerRepository;
import in.nareshit.raghu.repo.product.ProductRepository;

@RestController
public class MultiDatabaseRestController {
	@Autowired
	private ProductRepository prodRepo;
	@Autowired
	private CustomerRepository custRepo;

	@GetMapping("/products")
  public List<Product> getAllPeoducts(){
	  return prodRepo.findAll();
  }

	@GetMapping("/customer")
	public List<Customer> getAllCustomer(){
		return custRepo.findAll();
	}
}
