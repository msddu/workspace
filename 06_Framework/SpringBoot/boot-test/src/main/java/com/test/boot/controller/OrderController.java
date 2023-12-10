package com.test.boot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/order")
public class OrderController {

	@PostMapping
	public String order(Model model,
			@RequestParam("blackPen") int blackPen,
			@RequestParam("redPen") int redPen,
			@RequestParam("bluePen") int bluePen,
			@RequestParam("white") int white,
			@RequestParam("name") String name) {

		int total = (blackPen * 500) + (redPen * 700) + (bluePen * 700) + (white * 1000);
		Map<String, Object> map = new HashMap<>();
		map.put("blackPen", blackPen);
		map.put("redPen", redPen);
		map.put("bluePen", bluePen);
		map.put("white", white);
		map.put("name", name);

		if (total != 0) {
			model.addAttribute("total", total);
			model.addAttribute("map", map);
			return "resultPage";
		} else {
			return "redirect:/order/error";
		}
	}

	@GetMapping("/error")
	public String error() {
		return "errorPage";
	}
}