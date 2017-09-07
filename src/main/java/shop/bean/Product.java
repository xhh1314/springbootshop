package shop.bean;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
public class Product {
	private String uuid;
	private String name;
	private float originalPrice;
	private float promotePrice;
	private int stock;
	private String createTime;
	private Subdivide subdivide;
	private List<ProductImage> productImage;
	//第一张图片的存储路径
	private String fristImagePath;
	@Id
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="orignalprice")
	public float getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(float originalPrice) {
		this.originalPrice = originalPrice;
	}
	public float getPromotePrice() {
		return promotePrice;
	}
	public void setPromotePrice(float promotePrice) {
		this.promotePrice = promotePrice;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	//@Temporal(TemporalType.TIMESTAMP)
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@ManyToOne
	@JoinColumn(name="sb_uuid",referencedColumnName="uuid")
	public Subdivide getSubdivide() {
		return subdivide;
	}
	public void setSubdivide(Subdivide subdivide) {
		this.subdivide = subdivide;
	}
	@OneToMany(mappedBy="product")
	public List<ProductImage> getProductImage() {
		return productImage;
	}
	public void setProductImage(List<ProductImage> productImage) {
		this.productImage = productImage;
		//初始化第一张图片路径的值
		//this.fristImagePath=productImage.get(0).getValue();
	}
	public String getFristImagePath() {
		return fristImagePath;
	}
	public void setFristImagePath(String fristImagePath) {
		this.fristImagePath = fristImagePath;
	}
	


}
