package hibernate.dao.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
//@Entity
//@Table(name = "tab_role")
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id")
	private Integer id;

//	@Column(name = "code")
	private String code;

//	@Column(name = "name")
	private String name;

//	@Column(name = "createUserName")
	private String createUserName;

//	@Column(name = "createUserCode")
	private String createUserCode;

//	@Column(name = "createTime")
	private Date createTime;

//	@Column(name = "modifierName")
	private String modifierName;

//	@Column(name = "modifierCode")
	private String modifierCode;

//	@Column(name = "modifyTime")
	private Date modifyTime;

//	@Column(name = "isDel")
	private int isDel;
	
//	@Column(name = "version")
	private int version;

	Set<Test> tests = new HashSet<Test>();

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

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getCreateUserCode() {
		return createUserCode;
	}

	public void setCreateUserCode(String createUserCode) {
		this.createUserCode = createUserCode;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getModifierName() {
		return modifierName;
	}

	public void setModifierName(String modifierName) {
		this.modifierName = modifierName;
	}

	public String getModifierCode() {
		return modifierCode;
	}

	public void setModifierCode(String modifierCode) {
		this.modifierCode = modifierCode;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public int getIsDel() {
		return isDel;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Set<Test> getTests() {
		return tests;
	}

	public void setTests(Set<Test> tests) {
		this.tests = tests;
	}

	public Role(Integer id, String code, String name, String createUserName, String createUserCode, Date createTime,
			String modifierName, String modifierCode, Date modifyTime, int isDel, int version, Set<Test> tests) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.createUserName = createUserName;
		this.createUserCode = createUserCode;
		this.createTime = createTime;
		this.modifierName = modifierName;
		this.modifierCode = modifierCode;
		this.modifyTime = modifyTime;
		this.isDel = isDel;
		this.version = version;
		this.tests = tests;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
