package com.nearme.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface Category {

	/*
	 * (non-Javadoc)
	 */
	public abstract Long getId();

	/*
	 * (non-Javadoc)
	 */
	public abstract void setId(Long id);

	/*
	 * (non-Javadoc)
	 */
	public abstract Date getCreatedDate();

	/*
	 * (non-Javadoc)
	 */
	public abstract void setCreatedDate(Date createdDate);

	/*
	 * (non-Javadoc)
	 */
	public abstract Date getUpdatedDate();

	public abstract void setUpdatedDate(Date updatedDate);

	public abstract String getName();

	public abstract void setName(String name);

	public abstract Date getDeletedDate();

	public abstract void setDeletedDate(Date deletedDate);

	public abstract Boolean getEnabled();

	public abstract void setEnabled(Boolean enabled);

}