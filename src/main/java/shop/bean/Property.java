package shop.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Property {
	private String uuid;
	private String name;
	private Subdivide subdivide;
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
	@ManyToOne
	@JoinColumn(name="sb_uuid",referencedColumnName="uuid")
	public Subdivide getSubdivide() {
		return subdivide;
	}
	public void setSubdivide(Subdivide subdivide) {
		this.subdivide = subdivide;
	}
	
	

}
