package shop.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Category implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4345900548033682881L;
	private String uuid;
	private String name;
	private String description;
	private List<Subdivide> subdivide;
	
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
