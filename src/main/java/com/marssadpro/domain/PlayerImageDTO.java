package com.marssadpro.domain;

public class PlayerImageDTO
{
	
	private long id;
	
	private String fileName;
	
	private byte[] fileData;
	
	public PlayerImageDTO()
	{
	}
	
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long uploadId)
	{
		this.id = uploadId;
	}
	
	public String getFileName()
	{
		return fileName;
	}
	
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}
	
	public byte[] getFileData()
	{
		return fileData;
	}
	
	public void setFileData(byte[] fileData)
	{
		this.fileData = fileData;
	}
	
}
