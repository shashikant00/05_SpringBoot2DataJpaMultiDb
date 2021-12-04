package in.nareshit.raghu.repo.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.nareshit.raghu.model.product.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
