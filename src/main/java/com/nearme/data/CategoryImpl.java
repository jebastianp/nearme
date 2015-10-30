package com.nearme.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jebastian Ponsekar
 * 
 */
@Entity
@Table(name = "category" , catalog = "nearme_schema")
public class CategoryImpl implements Category {

	private Long id;
	private String name;
	private Date createdDate;
	private Date updatedDate;
	private Date deletedDate;
	private Boolean enabled;

	/*
	 * (non-Javadoc)
	 */
	/* (non-Javadoc)
	 * @see com.nearme.data.Category#getId()
	 */
	@Override
	@Id
	@Column(name = "category_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("category_id")
	public Long getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 */
	/* (non-Javadoc)
	 * @see com.nearme.data.Category#setId(java.lang.Long)
	 */

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 */
	/* (non-Javadoc)
	 * @see com.nearme.data.Category#getCreatedDate()
	 */

	@Override
	@Column(name = "created_date")
	public Date getCreatedDate() {
		return createdDate;
	}

	/*
	 * (non-Javadoc)
	 */
	/* (non-Javadoc)
	 * @see com.nearme.data.Category#setCreatedDate(java.util.Date)
	 */

	@Override
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/*
	 * (non-Javadoc)
	 */
	/* (non-Javadoc)
	 * @see com.nearme.data.Category#getUpdatedDate()
	 */

	@Override
	@Column(name = "updated_date")
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/* (non-Javadoc)
	 * @see com.nearme.data.Category#setUpdatedDate(java.util.Date)
	 */

	@Override
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	/* (non-Javadoc)
	 * @see com.nearme.data.Category#getName()
	 */

	@Override
	@Column(name = "name")
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see com.nearme.data.Category#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see com.nearme.data.Category#getDeletedDate()
	 */

	@Override
	@Column(name = "deleted_date")
	public Date getDeletedDate() {
		return deletedDate;
	}

	/* (non-Javadoc)
	 * @see com.nearme.data.Category#setDeletedDate(java.util.Date)
	 */
	@Override
	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}

	/* (non-Javadoc)
	 * @see com.nearme.data.Category#getEnabled()
	 */

	@Override
	@Column(name = "enabled")
	public Boolean getEnabled() {
		return enabled;
	}

	/* (non-Javadoc)
	 * @see com.nearme.data.Category#setEnabled(java.lang.Boolean)
	 */
	@Override
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
}
