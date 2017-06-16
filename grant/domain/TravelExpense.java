package gov.nysed.oce.ldgrants.grants.grant.domain;

import java.util.Date;

public class TravelExpense {

	private Long amendAmount;
	private Long amountApproved;
	private String createdBy;
	private String modifiedBy;
	private Date dateCreated;
	private Date dateModified;
	private String costSummary;
	private Long expApproved;
	private Long expSubmitted;
	private Long fyCode;
	private Long grantRequest;
	private Long graId;
	private Long id;
	private Long instCont;
	private Long projTotal;
	private String description;
	private String isTotal;
	private String travellerName;
	private String travelPeriod;
	private String purpose;
	private String journalEntry;
	
	
	
	public String getJournalEntry() {
		return journalEntry;
	}
	public void setJournalEntry(String journalEntry) {
		this.journalEntry = journalEntry;
	}
	public Long getAmendAmount() {
		return amendAmount;
	}
	public void setAmendAmount(Long amendAmount) {
		this.amendAmount = amendAmount;
	}
	public Long getAmountApproved() {
		return amountApproved;
	}
	public void setAmountApproved(Long amountApproved) {
		this.amountApproved = amountApproved;
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
	
	public String getCostSummary() {
		return costSummary;
	}
	public void setCostSummary(String costSummary) {
		this.costSummary = costSummary;
	}
	public Long getExpApproved() {
		return expApproved;
	}
	public void setExpApproved(Long expApproved) {
		this.expApproved = expApproved;
	}
	public Long getExpSubmitted() {
		return expSubmitted;
	}
	public void setExpSubmitted(Long expSubmitted) {
		this.expSubmitted = expSubmitted;
	}
	public Long getFyCode() {
		return fyCode;
	}
	public void setFyCode(Long fyCode) {
		this.fyCode = fyCode;
	}
	public Long getGrantRequest() {
		return grantRequest;
	}
	public void setGrantRequest(Long grantRequest) {
		this.grantRequest = grantRequest;
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
	public Long getInstCont() {
		return instCont;
	}
	public void setInstCont(Long instCont) {
		this.instCont = instCont;
	}
	public Long getProjTotal() {
		return projTotal;
	}
	public void setProjTotal(Long projTotal) {
		this.projTotal = projTotal;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIsTotal() {
		return isTotal;
	}
	public void setIsTotal(String isTotal) {
		this.isTotal = isTotal;
	}
	public String getTravellerName() {
		return travellerName;
	}
	public void setTravellerName(String travellerName) {
		this.travellerName = travellerName;
	}
	public String getTravelPeriod() {
		return travelPeriod;
	}
	public void setTravelPeriod(String travelPeriod) {
		this.travelPeriod = travelPeriod;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
	
	
}
