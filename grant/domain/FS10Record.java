package gov.nysed.oce.ldgrants.grants.grant.domain;

import java.util.Date;

public class FS10Record {

	private Long id;
	private Long graId;
	private Long fyCode;
	private Long extId;
	private Long expCode;
	private Long amountIncr;
	private Long amountDecr;
	private String adminApproval;
	private String createdBy;
	private String description ;
	private String expName;
	private String modifiedBy;
	private Date dateCreated;
	private Date dateModified;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getGraId() {
		return graId;
	}
	public void setGraId(Long graId) {
		this.graId = graId;
	}
	public Long getFyCode() {
		return fyCode;
	}
	public void setFyCode(Long fyCode) {
		this.fyCode = fyCode;
	}
	public Long getExtId() {
		return extId;
	}
	public void setExtId(Long extId) {
		this.extId = extId;
	}
	public Long getExpCode() {
		return expCode;
	}
	public void setExpCode(Long expCode) {
		this.expCode = expCode;
	}
	public Long getAmountIncr() {
		return amountIncr;
	}
	public void setAmountIncr(Long amountIncr) {
		this.amountIncr = amountIncr;
	}
	public Long getAmountDecr() {
		return amountDecr;
	}
	public void setAmountDecr(Long amountDecr) {
		this.amountDecr = amountDecr;
	}
	public String getAdminApproval() {
		return adminApproval;
	}
	public void setAdminApproval(String adminApproval) {
		this.adminApproval = adminApproval;
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
	public String getExpName() {
		return expName;
	}
	public void setExpName(String expName) {
		this.expName = expName;
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
