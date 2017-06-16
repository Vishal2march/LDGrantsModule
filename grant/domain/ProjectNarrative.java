package gov.nysed.oce.ldgrants.grants.grant.domain;

import java.sql.Clob;
import java.util.Date;

public class ProjectNarrative {

	private String createdBy;
	private Date dateCreated;
	private Date dateModified;
	private Long graId;
	private Long id;
	private String modifiedBy;
	private Clob narrativeDescr;
	private Long natId;
	private String statisticDescr;
	
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
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Clob getNarrativeDescr() {
		return narrativeDescr;
	}
	public void setNarrativeDescr(Clob narrativeDescr) {
		this.narrativeDescr = narrativeDescr;
	}
	public Long getNatId() {
		return natId;
	}
	public void setNatId(Long natId) {
		this.natId = natId;
	}
	public String getStatisticDescr() {
		return statisticDescr;
	}
	public void setStatisticDescr(String statisticDescr) {
		this.statisticDescr = statisticDescr;
	}
	
	
}
