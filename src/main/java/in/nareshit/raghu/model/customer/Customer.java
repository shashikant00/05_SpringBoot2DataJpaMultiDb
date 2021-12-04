package in.nareshit.raghu.model.customer;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	private Integer id;
	private String email;
	private String name;
	
	public Customer() {}
	public Customer(Integer id, String email, String name) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	
}
