/**
 * 
 */
package com.example.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 * junaid.khan
 *
 */
@Table("simple_table")
public class SimpleTable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PrimaryKeyColumn(name="id",ordinal=0,type=PrimaryKeyType.PARTITIONED)
	@Column("id")
	private String id;
	@PrimaryKeyColumn(name="name",ordinal=0,type=PrimaryKeyType.PARTITIONED)
	@Column("id")
	private String name;
	@Column("created_time")
	private Date createdDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
	
}
