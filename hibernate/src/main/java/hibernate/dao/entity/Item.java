package hibernate.dao.entity;

import java.util.Set;

import javax.persistence.GenerationType;

public class Item {
	
//	@Id
//	@generatedValue(strategy = GenerationType.IDENTITY)
//	@column(name = "id")
	private Integer itemId;
	private String itemName;

	private Set<Category> categorys;
	
	
	
	public Set<Category> getCategorys() {
		return categorys;
	}

	public void setCategorys(Set<Category> categorys) {
		this.categorys = categorys;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	

	public Item(Integer itemId, String itemName, Set<Category> categorys) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.categorys = categorys;
	}

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

}
