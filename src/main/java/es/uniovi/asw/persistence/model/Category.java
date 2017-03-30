package es.uniovi.asw.persistence.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Category")
public class Category {
	@Id
	@GeneratedValue
	private Long id;
	String name;
	@OneToMany(mappedBy="category")
	private List<Proposal> proposals= new ArrayList<Proposal>();
	
	public Category(String name) {
		this.name = name;
	}

}
