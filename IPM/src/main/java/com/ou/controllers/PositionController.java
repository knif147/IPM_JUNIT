package com.ou.controllers;

import java.beans.PropertyEditorSupport;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ou.entity.Major;
import com.ou.entity.Position;
import com.ou.services.MajorService;
import com.ou.services.PositionService;
import com.ou.validator.PositionValidator;

@Controller
public class PositionController {
	@Autowired
	PositionService positionService;
	
	@Autowired
	PositionValidator positionValidator;
	
	@Autowired
	MajorService majorService;
	
	/**
	 * Show list position
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/hr/position")
	public String index(@RequestParam(name = "page", defaultValue = "1") int pageNumber, Model model) {
		Page<Position> page = positionService.findAllPositionPage(pageNumber);
		List<Position> positions = page.getContent();

		int current = page.getNumber() + 1;
		int begin = Math.max(1, current - 5);
		int end = Math.min(begin + 9, page.getTotalPages());

		model.addAttribute("page", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("positions", positions);

		return "positionList";
	}
	
	@GetMapping(value = "/hr/position/add")
	public String add(Model model) {
		model.addAttribute("majors", majorService.findByStatus());
		model.addAttribute("position", new Position());
		return "positionAdd";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Major.class, "major", new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                Major major = majorService.findOne(Integer.parseInt(text));
                setValue(major);
            }
        });
	}	
	
	@GetMapping(value ="/hr/position/save")
	public String save(@ModelAttribute("position") @Valid Position position,
			BindingResult result, RedirectAttributes redirect
			, Model model) throws UnsupportedEncodingException {
		
		System.out.println("demo");
		positionValidator.validate(position, result);
		System.out.println("demo2");
		
		if(position.getId() > 0){
			if(result.hasErrors()) {
				model.addAttribute("majors", majorService.findByStatus());
				return "positionUpdate";
			}
			positionService.update(position);
		}else {
			if(result.hasErrors()) {
				System.out.println("Result " + result);
				model.addAttribute("majors", majorService.findByStatus());
				return "positionAdd";
			}
			positionService.create(position);
		}
		
		redirect.addFlashAttribute("success", "Saved position " + position.getName() + " successfully!");
		return "redirect:/hr/position";
	}
	
	@GetMapping(value ="/hr/position/{id}/update")
	public String edit(@PathVariable("id") long id, Model model) {
		Position position = positionService.findOne(id);
		if(position == null){
			return "404";
		}else {
			model.addAttribute("majors", majorService.findByStatus());
			model.addAttribute("position", position);
			return "positionUpdate";
		}
	}
}
