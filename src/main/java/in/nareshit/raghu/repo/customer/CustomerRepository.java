package in.nareshit.raghu.repo.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.nareshit.raghu.model.customer.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
