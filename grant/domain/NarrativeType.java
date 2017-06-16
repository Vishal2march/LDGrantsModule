package gov.nysed.oce.ldgrants.grants.grant.domain;

import java.util.Date;

public class NarrativeType {

	Long catId;
	String createdBy;
	Date dateCreated;
	Date dateModified;
	String displayInstruction;
	String displayName;
	Long id;
	String modifiedBy;
	String narrativeName;
	Long sortOrder;
	
	public Long getCatId() {
		return catId;
	}
	public void setCatId(Long catId) {
		this.catId = catId;
	}
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
	public Date getDateModified() {
		return dateModified;
	}
	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}
	public String getDisplayInstruction() {
		return displayInstruction;
	}
	public void setDisplayInstruction(String displayInstruction) {
		this.displayInstruction = displayInstruction;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getNarrativeName() {
		return narrativeName;
	}
	public void setNarrativeName(String narrativeName) {
		this.narrativeName = narrativeName;
	}
	public Long getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(Long sortOrder) {
		this.sortOrder = sortOrder;
	}
}
