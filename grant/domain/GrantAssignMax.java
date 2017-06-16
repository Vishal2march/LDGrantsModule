package gov.nysed.oce.ldgrants.grants.grant.domain;

import java.util.Date;

public class GrantAssignMax {

	private Long revId;
	private Long numAccepted;
	private Long id;
	private Long fyCode;
	private String createdBy;
	private String description;
	private String grantProgram;
	private String modifiedBy;
	private Date dateCreated;
	private Date dateModified;
	public Long getRevId() {
		return revId;
	}
	public void setRevId(Long revId) {
		this.revId = revId;
	}
	public Long getNumAccepted() {
		return numAccepted;
	}
	public void setNumAccepted(Long numAccepted) {
		this.numAccepted = numAccepted;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getFyCode() {
		return fyCode;
	}
	public void setFyCode(Long fyCode) {
		this.fyCode = fyCode;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGrantProgram() {
		return grantProgram;
	}
	public void setGrantProgram(String grantProgram) {
		this.grantProgram = grantProgram;
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
}
