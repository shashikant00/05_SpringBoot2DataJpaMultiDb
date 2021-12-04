package in.nareshit.raghu;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.nareshit.raghu.model.customer.Customer;
import in.nareshit.raghu.model.product.Product;
import in.nareshit.raghu.repo.customer.CustomerRepository;
import in.nareshit.raghu.repo.product.ProductRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	public ProductRepository prodRepo;
	@Autowired
	private CustomerRepository custRepo;
	
	@Override
	public void run(String... args) throws Exception {
		prodRepo.saveAll(
				Arrays.asList(
						new Product(10,"p1","Pen"),
						new Product(11,"p1","book"),
						new Product(12,"p1","Keyboard")));
	    
		custRepo.saveAll(Arrays.asList(
				new Customer(55,"sam@gmail.com","sam"),
				new Customer(56,"syed@gmail.com","syed"),
				new Customer(57,"ram@gmail.com","Ram")));
	
	}
  
}
