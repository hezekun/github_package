package hibernate.dao.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Test implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private Integer role_id;
	
	private String testName;

	
	
	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	

	public Test(Integer id, Integer role_id, String testName) {
		super();
		this.id = id;
		this.role_id = role_id;
		this.testName = testName;
	}

	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	
	
	
	
}
