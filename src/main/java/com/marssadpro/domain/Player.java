package com.marssadpro.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by zilat on 31.05.2017.
 */
@Entity
@Table(name = "Player")
public class Player
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false, precision = 19)
	private long id;
	
	@Column(name = "firstName", length = 255, nullable = false)
	private String firstName;
	
	@Column(name = "lastName", length = 255, nullable = false)
	private String lastName;
	
	@Column(name = "position", length = 255, nullable = false)
	private String position;
	
	@Column(name = "birthPlace", length = 255, nullable = false)
	private String birthPlace;
	
	@Column(name = "nationality", length = 255, nullable = false)
	private String nationality;
	
	@Column(name = "nowClub", length = 255, nullable = false)
	private String nowClub;
	
	@Column(name = "age", precision = 19)
	private Integer age;
	
	@Column(name = "birthDate", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date birthDate;
	
	@Column(name = "registredDate", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date registredDate;
	
	@Column(name = "approved")
	@Type(type = "yes_no")
	private Boolean approved;
	
	@JoinColumn(name = "imageId", nullable = true)
	@OneToOne(cascade=CascadeType.ALL ,fetch=FetchType.EAGER)
	private PlayerImage playerImage;
	
	public Player()
	{
	}
	

	public Player(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.registredDate = new Date();
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
	
	//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public Date getRegistredDate()
	{
		return registredDate;
	}
	
	//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public void setRegistredDate(Date registredDate)
	{
		if (registredDate == null)
		{
			this.registredDate = new Date();
		}
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
	
	public PlayerImage getPlayerImage()
	{
		return playerImage;
	}
	
	public void setPlayerImage(PlayerImage playerImage)
	{
		this.playerImage = playerImage;
	}
	
}
