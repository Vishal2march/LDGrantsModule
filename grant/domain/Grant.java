package gov.nysed.oce.ldgrants.grants.grant.domain;

import java.sql.Date;

public class Grant {
	
	private String createdBy;
	private String modifiedBy;
	private Date dateCreated;
	private Long fcCode;
	private Long fyCode;
	private Long id;
	private Long prmId;
	private String lockApp;
	private String name;
	
	private String amtApprovedYn;
	private String amtRequestedYn;
	private String attachComp;
	private String authorizedBy;
	private String authComp;
	private String awaitingAppr;
	private String budgetComp;
	private String contractNum;
	private String coversheetComp;
	private String coversheetYn;
	private Date dateModified;
	private String descriptionComp;
	private String dorisFlag;
	private String dorisName;
	private Long duration;
	private String educationApp;
	private String expApprovedYn;
	private String expSubmittedYn;
	private String finalBudgetComp;
	private String finalNarrativeYn;
	private String finalNarrComp;
	private String finalSignoffYn;
	private String fs10aYn;
	private String fs10fYn;
	private String fs20Yn;
	private String instAuthYn;
	private String microformYn;
	private String paidInFullYn;
	private String payeeComp;
	private Long pcId;
	private String photoComp;
	private String projDescYn;
	private Long projSeqNum;
	private String religiousAfill;
	private String seafComp;
	private String shpoComp;
	private String signoffComp;
	
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Long getFcCode() {
		return fcCode;
	}
	public void setFcCode(Long fcCode) {
		this.fcCode = fcCode;
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
	public Long getPrmId() {
		return prmId;
	}
	public void setPrmId(Long prmId) {
		this.prmId = prmId;
	}
	public String getLockApp() {
		return lockApp;
	}
	public void setLockApp(String lockApp) {
		this.lockApp = lockApp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getAmtApprovedYn() {
		return amtApprovedYn;
	}
	public void setAmtApprovedYn(String amtApprovedYn) {
		this.amtApprovedYn = amtApprovedYn;
	}
	public String getAmtRequestedYn() {
		return amtRequestedYn;
	}
	public void setAmtRequestedYn(String amtRequestedYn) {
		this.amtRequestedYn = amtRequestedYn;
	}
	public String getAttachComp() {
		return attachComp;
	}
	public void setAttachComp(String attachComp) {
		this.attachComp = attachComp;
	}
	public String getAuthorizedBy() {
		return authorizedBy;
	}
	public void setAuthorizedBy(String authorizedBy) {
		this.authorizedBy = authorizedBy;
	}
	public String getAuthComp() {
		return authComp;
	}
	public void setAuthComp(String authComp) {
		this.authComp = authComp;
	}
	public String getAwaitingAppr() {
		return awaitingAppr;
	}
	public void setAwaitingAppr(String awaitingAppr) {
		this.awaitingAppr = awaitingAppr;
	}
	public String getBudgetComp() {
		return budgetComp;
	}
	public void setBudgetComp(String budgetComp) {
		this.budgetComp = budgetComp;
	}
	public String getContractNum() {
		return contractNum;
	}
	public void setContractNum(String contractNum) {
		this.contractNum = contractNum;
	}
	public String getCoversheetComp() {
		return coversheetComp;
	}
	public void setCoversheetComp(String coversheetComp) {
		this.coversheetComp = coversheetComp;
	}
	public Date getDateModified() {
		return dateModified;
	}
	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}
	public String getDescriptionComp() {
		return descriptionComp;
	}
	public void setDescriptionComp(String descriptionComp) {
		this.descriptionComp = descriptionComp;
	}
	public String getDorisFlag() {
		return dorisFlag;
	}
	public void setDorisFlag(String dorisFlag) {
		this.dorisFlag = dorisFlag;
	}
	public String getDorisName() {
		return dorisName;
	}
	public void setDorisName(String dorisName) {
		this.dorisName = dorisName;
	}
	public Long getDuration() {
		return duration;
	}
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	public String getEducationApp() {
		return educationApp;
	}
	public void setEducationApp(String educationApp) {
		this.educationApp = educationApp;
	}
	public String getExpApprovedYn() {
		return expApprovedYn;
	}
	public void setExpApprovedYn(String expApprovedYn) {
		this.expApprovedYn = expApprovedYn;
	}
	public String getExpSubmittedYn() {
		return expSubmittedYn;
	}
	public void setExpSubmittedYn(String expSubmittedYn) {
		this.expSubmittedYn = expSubmittedYn;
	}
	public String getFinalBudgetComp() {
		return finalBudgetComp;
	}
	public void setFinalBudgetComp(String finalBudgetComp) {
		this.finalBudgetComp = finalBudgetComp;
	}
	public String getFinalNarrativeYn() {
		return finalNarrativeYn;
	}
	public void setFinalNarrativeYn(String finalNarrativeYn) {
		this.finalNarrativeYn = finalNarrativeYn;
	}
	public String getFinalNarrComp() {
		return finalNarrComp;
	}
	public void setFinalNarrComp(String finalNarrComp) {
		this.finalNarrComp = finalNarrComp;
	}
	public String getFinalSignoffYn() {
		return finalSignoffYn;
	}
	public void setFinalSignoffYn(String finalSignoffYn) {
		this.finalSignoffYn = finalSignoffYn;
	}
	public String getFs10aYn() {
		return fs10aYn;
	}
	public void setFs10aYn(String fs10aYn) {
		this.fs10aYn = fs10aYn;
	}
	public String getFs10fYn() {
		return fs10fYn;
	}
	public void setFs10fYn(String fs10fYn) {
		this.fs10fYn = fs10fYn;
	}
	public String getFs20Yn() {
		return fs20Yn;
	}
	public void setFs20Yn(String fs20Yn) {
		this.fs20Yn = fs20Yn;
	}
	public String getInstAuthYn() {
		return instAuthYn;
	}
	public void setInstAuthYn(String instAuthYn) {
		this.instAuthYn = instAuthYn;
	}
	public String getMicroformYn() {
		return microformYn;
	}
	public void setMicroformYn(String microformYn) {
		this.microformYn = microformYn;
	}
	public String getPayeeComp() {
		return payeeComp;
	}
	public void setPayeeComp(String payeeComp) {
		this.payeeComp = payeeComp;
	}
	public String getPhotoComp() {
		return photoComp;
	}
	public void setPhotoComp(String photoComp) {
		this.photoComp = photoComp;
	}
	public String getProjDescYn() {
		return projDescYn;
	}
	public void setProjDescYn(String projDescYn) {
		this.projDescYn = projDescYn;
	}
	public Long getProjSeqNum() {
		return projSeqNum;
	}
	public void setProjSeqNum(Long projSeqNum) {
		this.projSeqNum = projSeqNum;
	}
	public String getReligiousAfill() {
		return religiousAfill;
	}
	public void setReligiousAfill(String religiousAfill) {
		this.religiousAfill = religiousAfill;
	}
	public String getSeafComp() {
		return seafComp;
	}
	public void setSeafComp(String seafComp) {
		this.seafComp = seafComp;
	}
	public String getShpoComp() {
		return shpoComp;
	}
	public void setShpoComp(String shpoComp) {
		this.shpoComp = shpoComp;
	}
	public String getSignoffComp() {
		return signoffComp;
	}
	public void setSignoffComp(String signoffComp) {
		this.signoffComp = signoffComp;
	}
	public String getCoversheetYn() {
		return coversheetYn;
	}
	public void setCoversheetYn(String coversheetYn) {
		this.coversheetYn = coversheetYn;
	}
	public String getPaidInFullYn() {
		return paidInFullYn;
	}
	public void setPaidInFullYn(String paidInFullYn) {
		this.paidInFullYn = paidInFullYn;
	}
	public Long getPcId() {
		return pcId;
	}
	public void setPcId(Long pcId) {
		this.pcId = pcId;
	}	
}
