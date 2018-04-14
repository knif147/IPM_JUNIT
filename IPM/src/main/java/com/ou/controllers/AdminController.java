package com.ou.controllers;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ou.entity.User;
import com.ou.services.UserService;
import com.ou.utils.Constant;
import com.ou.validator.UserValidator;

@Controller
public class AdminController {
	@Autowired
	UserService userService;

	@Autowired
	UserValidator userValidator;
	
	/**
	 * Controller display list information human resource
	 * @param model: send data for view
	 * @return: display screen list human resource
	 */
	@GetMapping(value = "/admin/hr")
	public String showListHR(@RequestParam(name = "page", defaultValue = "1") int pageNumber, Model model) {
		Page<User> page = userService.findAllUserPage(pageNumber, Constant.ROLE.HR);
		List<User> users = page.getContent();

		int current = page.getNumber() + 1;
		int begin = Math.max(1, current - 5);
		int end = Math.min(begin + 9, page.getTotalPages());

		model.addAttribute("page", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("users", users);

		return "hrList";
	}

	
	/**
	 * Controller display screen add new human resource
	 * @param model: send data for view
	 * @return: display screen add new human resource
	 */
	@GetMapping(value = "/admin/hr/add")
	public String addHumanResource(Model model) {
		model.addAttribute("user", new User());
		return "hrAdd";
	}
	
	/**
	 * Controller handle save human resource
	 * @param user: User object
	 * @param result: binding result 
	 * @param redirect: redirect view
	 * @return display screen show list human resource
	 */
	@GetMapping(value = "/admin/hr/save")
	public String saveHumanResource(@ModelAttribute("user") @Valid User user, BindingResult result,
			RedirectAttributes redirect) {
		userValidator.validate(user, result);
		if (result.hasErrors()) return "hrAdd";
		
		userService.create(user, Constant.ROLE.HR);
		
		redirect.addFlashAttribute("success", "Saved user " + user.getEmail() + " successfully!");
		return "redirect:/admin/hr";
	}
	
	/**
	 * Controller show information human resource
	 * @param id: id of human resource
	 * @param model: send data for view
	 * @return display screen update human resource
	 */
	@GetMapping(value = "/admin/hr/{id}/update")
	public String updateHumanResource(@PathVariable long id, Model model) {
		User user = userService.findById(id);
		if (user == null) {
			return "404";
		} else {
			model.addAttribute("user", user);
			return "hrUpdate";
		}
	}
	
	/**
	 * Update information Human Resource
	 * @param user
	 * @param result
	 * @param redirect
	 * @return
	 */
	@GetMapping(value = "/admin/hr/update")
	public String updateHumanResource(@ModelAttribute("user") @Valid User user, BindingResult result,
			RedirectAttributes redirect) {
		System.out.println("Method Update");
		userValidator.validate(user, result);
		if (result.hasErrors())
			return "hrUpdate";
		
		System.out.println("Update Human Resource");
		userService.update(user);
		
		redirect.addFlashAttribute("success", "Saved user " + user.getEmail() + " successfully!");
		return "redirect:/admin/hr";
	}

	/**
	 * Controller display list information interviewer
	 * @param model: send data for view
	 * @return display screen list interviewer
	 */
	@GetMapping(value = "/admin/interviewer")
	public String showListInterviewer(@RequestParam(name = "page", defaultValue = "1") int pageNumber, Model model) {
		Page<User> page = userService.findAllUserPage(pageNumber, Constant.ROLE.INTERVIEWER);
		List<User> users = page.getContent();

		int current = page.getNumber() + 1;
		int begin = Math.max(1, current - 5);
		int end = Math.min(begin + 9, page.getTotalPages());

		model.addAttribute("page", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("users", users);

		return "interviewerList";
	}

	/**
	 * Controller display screen add new interviewer
	 * @param model: send data for view
	 * @return: display screen add new interviewer
	 */
	@GetMapping(value = "/admin/interviewer/add")
	public String addInterviewer(Model model) {
		model.addAttribute("user", new User());
		return "interviewerAdd";
	}

	/**
	 * Controller handle save interviewer
	 * @param user: User object
	 * @param result: binding result 
	 * @param redirect: redirect view
	 * @return display screen show list interviewers
	 */
	@GetMapping(value = "/admin/interviewer/save")
	public String saveInterviewer(@ModelAttribute("user") @Valid User user, BindingResult result,
			RedirectAttributes redirect) {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "interviewerAdd";
		}
		
		userService.create(user, Constant.ROLE.INTERVIEWER);
		
		redirect.addFlashAttribute("success", "Saved user " + user.getEmail() + " successfully");
		return "redirect:/admin/interviewer";
	}
	
	/**
	 * Controller show information of interviewer 
	 * @param id: id of interviewer
	 * @param model: send data for view
	 * @return display screen update interviewer
	 */
	@GetMapping(value = "/admin/interviewer/{id}/update")
	public String updateInterviewer(@PathVariable long id, Model model) {
		User user = userService.findById(id);
		if (user == null) {
			return "404";
		} else {
			model.addAttribute("user", user);
			return "interviewerUpdate";
		}
	}
	
	/**
	 * Update information Interviewer
	 * @param user Object user
	 * @param result 
	 * @param redirect
	 * @return
	 */
	@GetMapping(value = "/admin/interviewer/update")
	public String updateInterviewer(@ModelAttribute("user") @Valid User user, BindingResult result,
			RedirectAttributes redirect) {
		userValidator.validate(user, result);
		if (result.hasErrors())
			return "interviewerUpdate";
		
		userService.update(user);
		
		redirect.addFlashAttribute("success", "Saved user " + user.getEmail() + " successfully!");
		return "redirect:/admin/interviewer";
	}
	
	/**
	 * Update profile Admin account
	 * @param model handle return view profile admin
	 * @return show view profile admin
	 */
	@GetMapping(value = "/admin/info")
	public String updateProfile(Model model){
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User currentUser = ((CustomUserDetails) principal).getUser();
//        
//        User user = userService.findById(currentUser.getId());
//        if (user == null) {
//			return "404";
//		} else {
//			model.addAttribute("user", user);
//			return "profileAdmin";
//		}
		
		return "profileAdmin";
	}
	// profile admin
		@GetMapping(value = "/admin/info/change")
	public @ResponseBody String changePassword(@RequestParam("type") String type) throws IOException {
		System.out.println("gia tri select .... " + type);
		String res = "doi mat khau thanh cong";
		return res;
	}
	
}
