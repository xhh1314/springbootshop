package shop.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Category {
	private int id;
	private String uuid;
	private String name;
	private String description;
	private List<Subdivide> subdivide;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@OneToMany(mappedBy="category")
	public List<Subdivide> getSubdivide() {
		return subdivide;
	}
	public void setSubdivide(List<Subdivide> subdivide) {
		this.subdivide = subdivide;
	}
	

}
