package gov.nysed.oce.ldgrants.grants.common.domain;

public class Grant {
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getInstId() {
		return instId;
	}
	public void setInstId(Long instId) {
		this.instId = instId;
	}
	public String getSedcode() {
		return sedcode;
	}
	public void setSedcode(String sedcode) {
		this.sedcode = sedcode;
	}
	private Long id;
	private String name;
	private Long instId;
	private String sedcode;
	

}
