package hibernate.dao.entity;

import java.io.Serializable;

public class Job implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int clerk_id;
	
	private String job_name;
	
	private Clerk clerk;
	
	

	public Clerk getClerk() {
		return clerk;
	}

	public void setClerk(Clerk clerk) {
		this.clerk = clerk;
	}

	public int getClerk_id() {
		return clerk_id;
	}

	public void setClerk_id(int clerk_id) {
		this.clerk_id = clerk_id;
	}

	public String getJob_name() {
		return job_name;
	}

	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}

	

	public Job(int clerk_id, String job_name, Clerk clerk) {
		super();
		this.clerk_id = clerk_id;
		this.job_name = job_name;
		this.clerk = clerk;
	}

	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
