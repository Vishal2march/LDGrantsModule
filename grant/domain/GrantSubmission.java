package gov.nysed.oce.ldgrants.grants.grant.domain;

import java.util.Date;

public class GrantSubmission {

	private String createdBy;
	private String grasUser;
	private String modifiedBy;
	private String version;
	private Date dateCreated;
	private Date dateModified;
	private Date dateSubmitted;
	private Long fmtId;
	private Long graId;
	private Long id;
	private Long fyFyCode;
	
	
	public Long getFyFyCode() {
		return fyFyCode;
	}
	public void setFyFyCode(Long fyFyCode) {
		this.fyFyCode = fyFyCode;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getGrasUser() {
		return grasUser;
	}
	public void setGrasUser(String grasUser) {
		this.grasUser = grasUser;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
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
	public Date getDateSubmitted() {
		return dateSubmitted;
	}
	public void setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}
	public Long getFmtId() {
		return fmtId;
	}
	public void setFmtId(Long fmtId) {
		this.fmtId = fmtId;
	}
	public Long getGraId() {
		return graId;
	}
	public void setGraId(Long graId) {
		this.graId = graId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
