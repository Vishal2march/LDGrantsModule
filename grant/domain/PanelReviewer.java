package gov.nysed.oce.ldgrants.grants.grant.domain;

import java.util.Date;

public class PanelReviewer {

	private String createdBy;
	private String modifiedBy;
	private Date dateCreated;
	private Date dateModified;
	private Long id;
	private Long panId;
	private Long revId;
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getDateModified() {
		return dateModified;
	}
	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPanId() {
		return panId;
	}
	public void setPanId(Long panId) {
		this.panId = panId;
	}
	public Long getRevId() {
		return revId;
	}
	public void setRevId(Long revId) {
		this.revId = revId;
	}
	
	
}
