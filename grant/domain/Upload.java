package gov.nysed.oce.ldgrants.grants.grant.domain;

import java.sql.Blob;
import java.util.Date;

public class Upload {

	private Blob blobContent;
	private String contentType;
	private String createdBy;
	private String dadCharset;
	private String docType;
	private String mimeType;
	private String modifiedBy;
	private String name;
	
	private Date dateCreated;
	private Date dateModified;
	private Long docSize;
	private Long graId;
	private Long id;
	private Date lastUpdated;
	public Blob getBlobContent() {
		return blobContent;
	}
	public void setBlobContent(Blob blobContent) {
		this.blobContent = blobContent;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getDadCharset() {
		return dadCharset;
	}
	public void setDadCharset(String dadCharset) {
		this.dadCharset = dadCharset;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Long getDocSize() {
		return docSize;
	}
	public void setDocSize(Long docSize) {
		this.docSize = docSize;
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
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	
	
}
