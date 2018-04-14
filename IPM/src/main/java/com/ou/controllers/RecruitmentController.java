package com.ou.controllers;

import java.beans.PropertyEditorSupport;
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

import com.ou.entity.GroupRecruitment;
import com.ou.entity.Position;
import com.ou.entity.Recruitment;
import com.ou.services.GroupRecruitmentService;
import com.ou.services.PositionService;
import com.ou.services.RecruitmentService;
import com.ou.validator.RecruitmentValidator;

@Controller
public class RecruitmentController {
	@Autowired
	RecruitmentService recruitmentService;
	
	@Autowired
	GroupRecruitmentService groupRecruitmentService;
	
	@Autowired
	PositionService positionService;
	
	@Autowired
	RecruitmentValidator recruitmentValidator;
	
	@GetMapping(value = "/hr/recruitment/group/{group}")
	public String index(@PathVariable long group, @RequestParam(name = "page", defaultValue = "1") int pageNumber
			, Model model) {
		
		GroupRecruitment groupRecruitment = groupRecruitmentService.findOne(group);
		
		if(groupRecruitment == null){
			return "404";
		}else {
			Page<Recruitment> page = recruitmentService.findByGroupRecruitment(pageNumber, group);
			List<Recruitment> recruitments = page.getContent();
			
			int current = page.getNumber() + 1;
			int begin = Math.max(1, current - 5);
			int end = Math.min(begin + 9, page.getTotalPages());

			model.addAttribute("page", page);
			model.addAttribute("beginIndex", begin);
			model.addAttribute("endIndex", end);
			model.addAttribute("currentIndex", current);
			model.addAttribute("group", group);
			model.addAttribute("recruitments", recruitments);
			
			return "recruitmentList";
		}
	}
	
	@GetMapping(value = "/hr/recruitment/group/{group}/add")
	public String add(@PathVariable long group, Model model) {
		GroupRecruitment groupRecruitment = groupRecruitmentService.findOne(group);
		if(groupRecruitment == null){
			return "404";
		}else {
			List<Position> positions = positionService.findByStatus(groupRecruitment.getMajor().getId());
			model.addAttribute("recruitment", new Recruitment());
			model.addAttribute("positions", positions);
			model.addAttribute("group", group);
			return "recruitmentAdd";
		}
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Position.class, "position", new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                Position position = positionService.findOne(Long.parseLong(text));
                setValue(position);
            }
        });
	}
	
	@GetMapping(value = "/hr/recruitment/group/{group}/save")
	public String save(@PathVariable long group, @ModelAttribute("recruitment") @Valid Recruitment recruitment,
			 BindingResult result, RedirectAttributes redirect, Model model){
		GroupRecruitment groupRecruitment = groupRecruitmentService.findOne(group);
		if(groupRecruitment == null){
			return "404";
		}else {
			recruitmentValidator.validate(recruitment, result);
			if(result.hasErrors()){
				model.addAttribute("group", group);
				model.addAttribute("positions", positionService.findByStatus(groupRecruitment.getMajor().getId()));
				return "recruitmentAdd";
			}else {
				recruitment.setGroupRecruitment(groupRecruitment);
				recruitmentService.create(recruitment);
				
				redirect.addFlashAttribute("success", "Saved recruitment " + recruitment.getName() + " successfully!");
				return "redirect:/hr/recruitment/group";
			}
		}
	}
//	
//	@GetMapping(value = "")
//	public String save() {
//		return "";
//	}
//	
//	@GetMapping(value = "")
//	public String edit() {
//		return "";
//	}
}
