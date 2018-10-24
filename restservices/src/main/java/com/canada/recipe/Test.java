/**
 * 
 */
package com.canada.recipe;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author MENAD
 *
 */
@Entity
@Table(name = "myTable")
public class Test {

	@Id
	@GeneratedValue
	private UUID id;
	@NotNull
	@Column(name = "name")
	private String name;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
