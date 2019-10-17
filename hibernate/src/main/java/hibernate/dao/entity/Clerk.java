package hibernate.dao.entity;

import java.io.Serializable;

public class Clerk implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String name;
	
	private int age;

	private Job job;
	
	
	
	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Clerk() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Clerk(int id, String name, int age, Job job) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.job = job;
	}

	
	
}
