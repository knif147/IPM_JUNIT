package com.ou.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ou.entity.Major;
import com.ou.services.MajorService;
import com.ou.validator.MajorValidator;

@Controller
public class MajorController {
	@Autowired
	MajorService majorService;

	@Autowired
	MajorValidator majorValidator;
	
	/**
	 * Show list major
	 * @param pageNumber
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/hr/major")
	public String index(@RequestParam(name = "page", defaultValue = "1") int pageNumber, Model model) {
		Page<Major> page = majorService.findAllPage(pageNumber);
		List<Major> majors = majorService.findAllPage(pageNumber).getContent();

		int current = page.getNumber() + 1;
		int begin = Math.max(1, current - 5);
		int end = Math.min(begin + 9, page.getTotalPages());

		model.addAttribute("page", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("majors", majors);

		return "majorList";
	}
	
	/**
	 * Show page add new Major
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/hr/major/add")
	public String add(Model model) {
		model.addAttribute("major", new Major());
		return "majorAdd";
	}
	
	/**
	 * Handle add new major
	 * @param major
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/hr/major/save")
	public String save(@ModelAttribute("major") @Valid Major major,
			 BindingResult result, RedirectAttributes redirect) {
		majorValidator.validate(major, result);
		
		if(major.getId() > 0){
			if(result.hasErrors()) return "majorUpdate";
			majorService.update(major);
		}else {
			if(result.hasErrors()) return "majorAdd";
			majorService.create(major);
		}
		
		redirect.addFlashAttribute("success", "Saved major " + major.getName() + " successfully!");
		return "redirect:/hr/major";
	}
	/**
	 * Show update major
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/hr/major/{id}/update")
	public String edit(@PathVariable("id") long id,
			Model model) {
		Major major = majorService.findOne(id);
		if(major == null){
			return "404";
		}else {
			model.addAttribute("major", major);
			return "majorUpdate";
		}
	}

	/**
	 * Search advance major
	 * @param pageNumber
	 * @param name
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/hr/major/search")
	public String search(@RequestParam(name = "page", defaultValue = "1") int pageNumber,
			@RequestParam(name = "name") String name, Model model) {
		Page<Major> page = majorService.findByNamePage(pageNumber, name);
		List<Major> majors = majorService.findAllPage(pageNumber).getContent();

		int current = page.getNumber() + 1;
		int begin = Math.max(1, current - 5);
		int end = Math.min(begin + 9, page.getTotalPages());

		model.addAttribute("page", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("majors", majors);
		model.addAttribute("majors", majors);
		return "majorSearch";
	}
}
