package com.tencoding.blog.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tencoding.blog.auth.PrincipalDetail;
import com.tencoding.blog.dto.Image;
import com.tencoding.blog.dto.RequestFileDto;
import com.tencoding.blog.service.StoryService;

import lombok.Data;


@Data
@Controller // ioc, di
@RequestMapping("/story") //
public class StoryController {

		@Autowired
		private StoryService storyService;
		
		
		
		
	// http://localhost:9090/story/home
	@GetMapping({ "", "/home", "/search"})
	public String storyHome(@RequestParam(required = false) String q, Model model, 
			@PageableDefault(size = 6, sort = "id", direction = Direction.DESC) Pageable pageable) {
		
		String searchImage = q == null ? "" : q;
		
		Page<Image> imagePage = storyService.searchStoryText(searchImage, pageable);
		System.out.println("imagePage : " + imagePage.getContent());
//		Page<Image> imagePage = storyService.getImageList(pageable);
		
		
		int PAGENATION_BLOCK_COUNT = 3;
		
		int nowiPage = imagePage.getPageable().getPageNumber() + 1;
		int startiPageNumber = Math.max(nowiPage - PAGENATION_BLOCK_COUNT, 1);
		int endiPageNumber = Math.min(nowiPage + PAGENATION_BLOCK_COUNT, imagePage.getTotalPages());
		
		
		ArrayList<Integer> iPageNumbers = new ArrayList<>();
		for (int i= startiPageNumber; i <= endiPageNumber; i++) {
			iPageNumbers.add(i);
		}
		model.addAttribute("imagePage", imagePage);
		model.addAttribute("nowiPage", nowiPage);
		model.addAttribute("startiPageNumber", startiPageNumber);
		model.addAttribute("endiPageNumber", endiPageNumber);
		model.addAttribute("iPageNumbers", iPageNumbers);
		model.addAttribute("q", searchImage);
		
		
		
		return "story/home";
	}

	
	
	
	
	
	
	// http://localhost:9090/story/upload
	@GetMapping("/upload")
	public String storyUpload() {

		return "story/upload";
	}

	
	// ???????????? ???????????? ?????? ?????? ?????? ????????????.
	@PostMapping("/image/upload")
//	@ResponseBody (redirect:/ ????????????)
	// MutipartFile ????????? 1?????? 
//	public String storyImageUpload(MultipartFile file, String storyText) {
	public String storyImageUpload(RequestFileDto fileDto
			, @AuthenticationPrincipal PrincipalDetail principalDetail) {
		
		
		storyService.imageUpload(fileDto, principalDetail);
		
	
		
//		System.out.println("getContentType???????????? : " + file.getContentType());
//		System.out.println("getName : " + file.getName());
//		System.out.println("getOriginalFilename : " + file.getOriginalFilename());
//		System.out.println("getSize : " + file.getSize());
//		System.out.println("storyText : " + storyText);
		
//		1BYTE -> 1000BYTE(1KB) -> 1,000,000BYTE(1MB) -> 
//		1,000,000,000BYTE (1GB) -> 1,000,000,000,000BYTE (1TB)
//		1Kb ??? ??? 1024 BYTE ?????? ? -> 2??? ???????????? ??? ????????? ???????????? ????????? ,
//		???????????? 2?????? ?????????????????? ?????? ????????? ????????? ????????? 1024??? ????????? ??? ?????????.
		
		
		
		return "redirect:/story/home";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
