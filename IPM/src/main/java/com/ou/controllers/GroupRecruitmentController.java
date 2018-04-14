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
import com.ou.entity.Major;
import com.ou.services.GroupRecruitmentService;
import com.ou.services.MajorService;
import com.ou.services.RecruitmentService;
import com.ou.validator.GroupRecruitmentValidator;

@Controller
public class GroupRecruitmentController {
	@Autowired
	RecruitmentService recruitmentService;
	
	@Autowired
	GroupRecruitmentService groupRecruitmentService;
	
	@Autowired
	GroupRecruitmentValidator groupRecruitmentValidator;
	
	@Autowired
	MajorService majorService;
	
	@GetMapping(value = "/hr/recruitment/group")
	public String index(@RequestParam(name = "page", defaultValue = "1") int pageNumber, Model model) {
		Page<GroupRecruitment> page = groupRecruitmentService.findAllGroupRecruitmentPage(pageNumber);
		List<GroupRecruitment> groupRecruitments = page.getContent();

		int current = page.getNumber() + 1;
		int begin = Math.max(1, current - 5);
		int end = Math.min(begin + 9, page.getTotalPages());

		model.addAttribute("page", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("groupRecruitments", groupRecruitments);

		return "recruitmentGroupList";
	}
	
	@GetMapping(value = "/hr/recruitment/group/add")
	public String add(Model model) {
		model.addAttribute("majors", majorService.findByStatus());
		model.addAttribute("groupRecruitment", new GroupRecruitment());
		return "recruitmentGroupAdd";
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
	
	@GetMapping(value = "/hr/recruitment/group/save")
	public String save(@ModelAttribute("groupRecruitment") @Valid GroupRecruitment groupRecruitment,
			BindingResult result, RedirectAttributes redirect
			, Model model){
		groupRecruitmentValidator.validate(groupRecruitment, result);
		
		if(result.hasErrors()){
			model.addAttribute("majors", majorService.findByStatus());
			return "recruitmentGroupAdd";
		}
		
		groupRecruitmentService.create(groupRecruitment);
		
		redirect.addFlashAttribute("success", "Saved recruitment group " + groupRecruitment.getName() + " successfully!");
		return "redirect:/hr/recruitment/group";
	}
	
	@GetMapping(value = "/hr/recruitment/group/{id}/update")
	public String edit(@PathVariable("id") long id, Model model) {
		GroupRecruitment groupRecruitment = groupRecruitmentService.findOne(id);
		
		if(groupRecruitment == null){
			return "404";
		}else {
			model.addAttribute("majors", majorService.findByStatus());
			model.addAttribute("groupRecruitment", groupRecruitment);
			return "recruitmentGroupUpdate";
		}
	}
}
