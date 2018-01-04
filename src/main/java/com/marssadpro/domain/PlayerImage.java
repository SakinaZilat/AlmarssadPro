package com.marssadpro.domain;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Player_Image")
public class PlayerImage
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false, precision = 19)
	private long id;
	
	@Column(name = "fileName")
	private String fileName;
	
	@Column(name = "fileData")
	@Lob
	private byte[] fileData;
	
	@JsonIgnore
	@OneToOne(mappedBy = "playerImage")
	private Player player;
	
	public PlayerImage()
	{
	}
	
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
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
	
	public Player getPlayer()
	{
		return player;
	}
	
	public void setPlayer(Player player)
	{
		this.player = player;
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(fileData);
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((player == null) ? 0 : player.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerImage other = (PlayerImage) obj;
		if (!Arrays.equals(fileData, other.fileData))
			return false;
		if (fileName == null)
		{
			if (other.fileName != null)
				return false;
		}
		else if (!fileName.equals(other.fileName))
			return false;
		if (id != other.id)
			return false;
		if (player == null)
		{
			if (other.player != null)
				return false;
		}
		else if (!player.equals(other.player))
			return false;
		return true;
	}
	
}
