package entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Product {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ProductId;
	private String ProductName;
	private String ProductCode;
	
	private long categoryId ;
	
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "categoryId_prd", referencedColumnName = "categoryId")
	 Categories category;

	 
	 
	 
	 
	 

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getProductId() {
		return ProductId;
	}

	public void setProductId(Long productId) {
		ProductId = productId;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public String getProductCode() {
		return ProductCode;
	}

	public void setProductCode(String productCode) {
		ProductCode = productCode;
	}
	
	
	



}
