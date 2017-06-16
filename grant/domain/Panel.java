package gov.nysed.oce.ldgrants.grants.grant.domain;

import java.util.Date;

public class Panel {

	 public long id;
	  public String name;
	  public String status;
	  public String descr;
	  public String modifiedBy;
	  public String createdBy;
	  public Long amtAvailable;
	  public String fyCode;
	  public String fundRatio;
	  public Date dateCreated;
	  public Date dateModified;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Long getAmtAvailable() {
		return amtAvailable;
	}
	public void setAmtAvailable(Long amtAvailable) {
		this.amtAvailable = amtAvailable;
	}
	public String getFyCode() {
		return fyCode;
	}
	public void setFyCode(String fyCode) {
		this.fyCode = fyCode;
	}
	public String getFundRatio() {
		return fundRatio;
	}
	public void setFundRatio(String fundRatio) {
		this.fundRatio = fundRatio;
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
