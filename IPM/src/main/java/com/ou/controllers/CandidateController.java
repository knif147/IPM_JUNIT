package com.ou.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ou.entity.Candidate;
import com.ou.services.CandidateService;
import com.ou.utils.Constant;
import com.ou.utils.GenerateFileCVName;
import com.ou.validator.CandidateValidator;

@Controller
public class CandidateController {
	@Autowired
	CandidateService candidateService;

	@Autowired
	CandidateValidator candidateValidator;
	
	@GetMapping(value = "/hr/candidate")
	public String index(@RequestParam(name = "page", defaultValue = "1") int pageNumber, Model model) {
		Page<Candidate> page = candidateService.findAllCandidatePage(pageNumber);
		List<Candidate> candidates = page.getContent();

		int current = page.getNumber() + 1;
		int begin = Math.max(1, current - 5);
		int end = Math.min(begin + 9, page.getTotalPages());

		model.addAttribute("page", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("candidates", candidates);
		
		return "candidateList";
	}

	@GetMapping(value = "/hr/candidate/{id}/update")
	public String edit(@PathVariable int id, Model model) {
		Candidate candidate =  candidateService.findByID(id);
		if(candidate == null) {
			return "404";
		}else {
			model.addAttribute("candidate", candidate);
			return "candidateUpdate";
		}
	}
	

	@GetMapping(value = "/hr/candidate/add")
	public String add(Model model) {
		model.addAttribute("candidate", new Candidate());
		return "candidateAdd";
	}

	@PostMapping(value = "/hr/candidate/save")
	public String save(@ModelAttribute("candidate") @Valid Candidate candidate, BindingResult result,
			RedirectAttributes redirect, HttpServletRequest request,
			@RequestParam(value = "fileCV", required = false) MultipartFile fileCV) {
		candidateValidator.validate(candidate, result);
		
		if (result.hasErrors()) {
			return "candidateAdd";
		}

		// Upload file
		InputStream inputStream = null;
		OutputStream outputStream = null;
		String fileCVExtension = GenerateFileCVName.getExtentionFile(fileCV);
		System.out.println("file extension: " + fileCVExtension);
		String fileName = GenerateFileCVName.generateFileName() + "." + fileCVExtension;
		System.out.println("file name:" + fileName);

		try {
			inputStream = fileCV.getInputStream();
			File newFile = new File(
					request.getServletContext().getRealPath(File.separator) + Constant.FOLDER_UPLOAD + fileName);
			System.out.println("Path: " + newFile.getAbsolutePath());
			if (!newFile.exists())
				newFile.createNewFile();
			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}

			outputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != inputStream) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (null != outputStream) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		candidate.setLinkCV(fileName);
		candidateService.create(candidate);
		redirect.addFlashAttribute("success", "Save candidate " + candidate.getEmail() + "successfully!");
		return "redirect:/hr/candidate";
	}
	
	@PostMapping(value = "/hr/candidate/update")
	public String update(@ModelAttribute("candidate") @Valid Candidate candidate, BindingResult result,
			RedirectAttributes redirect, HttpServletRequest request,
			@RequestParam(value = "fileCV") MultipartFile fileCV) {
		candidateValidator.validate(candidate, result);
		if (result.hasErrors()) {
			return "candidateAdd";
		}

		// Upload file
		if(!fileCV.isEmpty()){
			InputStream inputStream = null;
			OutputStream outputStream = null;

			try {
				inputStream = fileCV.getInputStream();
				File newFile = new File(
						request.getServletContext().getRealPath(File.separator) + Constant.FOLDER_UPLOAD + candidate.getLinkCV());
				System.out.println("Path: " + newFile.getAbsolutePath());
				if (!newFile.exists())
					newFile.createNewFile();
				outputStream = new FileOutputStream(newFile);
				int read = 0;
				byte[] bytes = new byte[1024];

				while ((read = inputStream.read(bytes)) != -1) {
					outputStream.write(bytes, 0, read);
				}

				outputStream.flush();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (null != inputStream) {
					try {
						inputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				if (null != outputStream) {
					try {
						outputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		candidateService.update(candidate);
		redirect.addFlashAttribute("success", "Save candidate " + candidate.getEmail() + "successfully!");
		return "redirect:/hr/candidate";
	}
}
