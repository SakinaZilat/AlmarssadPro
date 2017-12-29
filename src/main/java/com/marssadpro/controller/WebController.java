package com.marssadpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marssadpro.domain.Player;
import com.marssadpro.service.PlayerService;

@Controller
public class WebController
{
	@Autowired
	private PlayerService playerService;


	@RequestMapping("/")
	String index()
	{
		return "index";
	}
	
	@RequestMapping("properties")
	@ResponseBody
	java.util.Properties properties()
	{
		return System.getProperties();
	}
	
	@ModelAttribute("players")
	List<Player> players()
	{		
		return this.playerService.findAll();
	}
	
	@RequestMapping(value = "player", method = RequestMethod.GET)
	public String exchange(Model model)
	{
		model.addAttribute("players");
		return "player";
	}


}
