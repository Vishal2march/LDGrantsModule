package gov.nysed.oce.ldgrants.grants.grant.domain;

import java.util.Date;

public class PanelGrant {

	private String recommendation;
	private String raoComments;
	private String raoChanges;
	private String panelNotes;
	private String modifiedBy;
	private String justification;
	private String decisionNotes;
	private String createdBy;
	
	private Long recommendAmt;
	private Long panId;
	private Long id;
	private Long graId;
	private Long finalScore;
	private Long bonusPoints;
	private Date dateCreated;
	private Date dateModified;
	
	public String getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}
	public String getRaoComments() {
		return raoComments;
	}
	public void setRaoComments(String raoComments) {
		this.raoComments = raoComments;
	}
	public String getRaoChanges() {
		return raoChanges;
	}
	public void setRaoChanges(String raoChanges) {
		this.raoChanges = raoChanges;
	}
	public String getPanelNotes() {
		return panelNotes;
	}
	public void setPanelNotes(String panelNotes) {
		this.panelNotes = panelNotes;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	public String getDecisionNotes() {
		return decisionNotes;
	}
	public void setDecisionNotes(String decisionNotes) {
		this.decisionNotes = decisionNotes;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Long getRecommendAmt() {
		return recommendAmt;
	}
	public void setRecommendAmt(Long recommendAmt) {
		this.recommendAmt = recommendAmt;
	}
	public Long getPanId() {
		return panId;
	}
	public void setPanId(Long panId) {
		this.panId = panId;
	}
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
	public Long getFinalScore() {
		return finalScore;
	}
	public void setFinalScore(Long finalScore) {
		this.finalScore = finalScore;
	}
	public Long getBonusPoints() {
		return bonusPoints;
	}
	public void setBonusPoints(Long bonusPoints) {
		this.bonusPoints = bonusPoints;
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
