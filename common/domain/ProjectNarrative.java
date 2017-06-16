package gov.nysed.oce.ldgrants.grants.common.domain;

public class ProjectNarrative {
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNarrative() {
		return narrative;
	}
	public void setNarrative(String narrative) {
		this.narrative = narrative;
	}
	public Long getNarrativeTypeId() {
		return narrativeTypeId;
	}
	public void setNarrativeTypeId(Long narrativeTypeId) {
		this.narrativeTypeId = narrativeTypeId;
	}
	private Long id;
	private String narrative;
	private Long narrativeTypeId;
	

}
