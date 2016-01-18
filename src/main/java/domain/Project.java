package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Project {
	private Long id;
	
	private String name;
	
	private List<Employee> employees = new ArrayList<Employee>();
	
	public Project(){
		super();
	}
	
	public Project(String name){
		this.name=name;
	}
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id=id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	
	@OneToMany(mappedBy = "project", cascade = CascadeType.PERSIST)
	public List<Employee> getEmployees(){
		return employees;
	}
	
	public void setEmployees(List<Employee> employees){
		this.employees=employees;
	}
	
}
