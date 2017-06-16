package gov.nysed.oce.ldgrants.grants.grant.domain;

import java.util.Date;

public class Approval {

	private Date dateCreated;
	private Date dateModified;
	private String createdBy;
	private String modifiedBy;
	
	private Long amountDecline;
	private Long fmtId;
	private Long fyFyCode;
	private Long graId;
	private Long id;
	private String admin;
	private String approvalType;
	private String version;
	private Date dateAccepted;
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
	public Long getAmountDecline() {
		return amountDecline;
	}
	public void setAmountDecline(Long amountDecline) {
		this.amountDecline = amountDecline;
	}
	public Long getFmtId() {
		return fmtId;
	}
	public void setFmtId(Long fmtId) {
		this.fmtId = fmtId;
	}
	public Long getFyFyCode() {
		return fyFyCode;
	}
	public void setFyFyCode(Long fyFyCode) {
		this.fyFyCode = fyFyCode;
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
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getApprovalType() {
		return approvalType;
	}
	public void setApprovalType(String approvalType) {
		this.approvalType = approvalType;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Date getDateAccepted() {
		return dateAccepted;
	}
	public void setDateAccepted(Date dateAccepted) {
		this.dateAccepted = dateAccepted;
	}
	
	
}
