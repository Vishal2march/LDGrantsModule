package gov.nysed.oce.ldgrants.grants.grant.domain;

import java.util.Date;

public class SystemFiscalYearDetail {

	private Date dateCreated;
	private Date dateModified;
	private String createdBy;
	private String modifiedBy;
	private Date dueDate;
	private Long fcCode;
	private Long finalAllocation;
	private Long finalRecommendation;
	private Long fyCode;
	private Long id;
	private Long initialAllocation;
	private Long lsmId;
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
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Long getFcCode() {
		return fcCode;
	}
	public void setFcCode(Long fcCode) {
		this.fcCode = fcCode;
	}
	public Long getFinalAllocation() {
		return finalAllocation;
	}
	public void setFinalAllocation(Long finalAllocation) {
		this.finalAllocation = finalAllocation;
	}
	public Long getFinalRecommendation() {
		return finalRecommendation;
	}
	public void setFinalRecommendation(Long finalRecommendation) {
		this.finalRecommendation = finalRecommendation;
	}
	public Long getFyCode() {
		return fyCode;
	}
	public void setFyCode(Long fyCode) {
		this.fyCode = fyCode;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getInitialAllocation() {
		return initialAllocation;
	}
	public void setInitialAllocation(Long initialAllocation) {
		this.initialAllocation = initialAllocation;
	}
	public Long getLsmId() {
		return lsmId;
	}
	public void setLsmId(Long lsmId) {
		this.lsmId = lsmId;
	}
	
	
	
}
