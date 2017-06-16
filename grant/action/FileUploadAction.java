package gov.nysed.oce.ldgrants.grants.grant.action;

import java.io.File;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport {

	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	
	public File getFileUpload() {
		return fileUpload;
	}
	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}
	public String getFileUploadContentType() {
		return fileUploadContentType;
	}
	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}
	public String getFileUploadFileName() {
		return fileUploadFileName;
	}
	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}
	
	public String execute() throws Exception{
		System.out.println("this is the success message");
		return SUCCESS;
	}
	public String display(){
		
		System.out.println("this is the display message");
		return NONE;
	}
}
