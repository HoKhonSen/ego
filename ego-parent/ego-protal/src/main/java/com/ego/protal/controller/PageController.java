package com.ego.protal.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ego.protal.service.TbContentService;

@Controller
public class PageController {

	@RequestMapping("/")
	public String welcome() {
		return "forward:/showBigPic";
	}
}
