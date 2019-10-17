package hibernate.dao.entity;

import java.util.HashSet;
import java.util.Set;

public class Category {

	    private Integer categoryId;
	    private String categoryName;

	    private Set<Item> items = new HashSet<Item>();

		public Integer getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(Integer categoryId) {
			this.categoryId = categoryId;
		}

		public String getCategoryName() {
			return categoryName;
		}

		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}

		public Set<Item> getItems() {
			return items;
		}

		public void setItems(Set<Item> items) {
			this.items = items;
		}

		public Category(Integer categoryId, String categoryName, Set<Item> items) {
			super();
			this.categoryId = categoryId;
			this.categoryName = categoryName;
			this.items = items;
		}

		public Category() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Category(Integer categoryId, String categoryName) {
			super();
			this.categoryId = categoryId;
			this.categoryName = categoryName;
		}

		
	  
	    
	    
}
