package com.marssadpro.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerDTO
{
	
	private long id;
	
	private String firstName;
	
	private String lastName;
	
	private String position;
	
	private String birthPlace;
	
	private String nationality;
	
	private String nowClub;
	
	private Integer age;
	
	private Date birthDate;
	
	private Date registredDate;
	
	private Boolean approved;
	
//	@JsonProperty("playerImage")
//	private PlayerImageDTO playerImageDTO;
	
	public PlayerDTO()
	{
	}
	
	public long getId()
	{
		return id;
	}
	
	public void setId(long id)
	{
		this.id = id;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public Date getRegistredDate()
	{
		return registredDate;
	}
	
	public void setRegistredDate(Date registredDate)
	{
		this.registredDate = new Date();
	}
	
	public String getPosition()
	{
		return position;
	}
	
	public void setPosition(String position)
	{
		this.position = position;
	}
	
	public String getBirthPlace()
	{
		return birthPlace;
	}
	
	public void setBirthPlace(String birthPlace)
	{
		this.birthPlace = birthPlace;
	}
	
	public String getNationality()
	{
		return nationality;
	}
	
	public void setNationality(String nationality)
	{
		this.nationality = nationality;
	}
	
	public String getNowClub()
	{
		return nowClub;
	}
	
	public void setNowClub(String nowClub)
	{
		this.nowClub = nowClub;
	}
	
	public Integer getAge()
	{
		return age;
	}
	
	public void setAge(Integer age)
	{
		this.age = age;
	}
	
	public Date getBirthDate()
	{
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate)
	{
		this.birthDate = birthDate;
	}
	
	public Boolean getApproved()
	{
		return approved;
	}
	
	public void setApproved(Boolean approved)
	{
		this.approved = approved;
	}

//	public PlayerImageDTO getPlayerImageDTO()
//	{
//		return playerImageDTO;
//	}
//
//	public void setPlayerImageDTO(PlayerImageDTO playerImageDTO)
//	{
//		this.playerImageDTO = playerImageDTO;
//	}
//	

	
}
