package com.example.easynotes.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="space")
public class Space implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_idspace", referencedColumnName = "id")
    List<Satelite> satellites=new ArrayList<>();
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Satelite> getSatellites() {
		return satellites;
	}
	public void setSatellites(List<Satelite> satellites) {
		this.satellites = satellites;
	}


}
