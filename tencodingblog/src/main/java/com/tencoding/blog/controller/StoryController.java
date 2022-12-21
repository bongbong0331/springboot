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

	
	// 여기서는 데이터를 전달 받고 처리 해야한다.
	@PostMapping("/image/upload")
//	@ResponseBody (redirect:/ 나오게함)
	// MutipartFile 다루는 1단계 
//	public String storyImageUpload(MultipartFile file, String storyText) {
	public String storyImageUpload(RequestFileDto fileDto
			, @AuthenticationPrincipal PrincipalDetail principalDetail) {
		
		
		storyService.imageUpload(fileDto, principalDetail);
		
	
		
//		System.out.println("getContentType마임타입 : " + file.getContentType());
//		System.out.println("getName : " + file.getName());
//		System.out.println("getOriginalFilename : " + file.getOriginalFilename());
//		System.out.println("getSize : " + file.getSize());
//		System.out.println("storyText : " + storyText);
		
//		1BYTE -> 1000BYTE(1KB) -> 1,000,000BYTE(1MB) -> 
//		1,000,000,000BYTE (1GB) -> 1,000,000,000,000BYTE (1TB)
//		1Kb 가 왜 1024 BYTE 일까 ? -> 2의 제곱으로 된 단위를 사용하기 때문에 ,
//		컴퓨터는 2진수 계산하는것이 가장 빠르기 때문에 약속을 1024로 지정한 것 뿐이다.
		
		
		
		return "redirect:/story/home";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
