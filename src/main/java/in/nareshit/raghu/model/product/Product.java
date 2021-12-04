package in.nareshit.raghu.model.product;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	private Integer id;
	private String code;
	private String name;
	
	public Product() {}
	public Product(Integer id, String code, String name) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
