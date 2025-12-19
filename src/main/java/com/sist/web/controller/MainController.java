package com.sist.web.controller;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.web.service.SeoulService;
import com.sist.web.vo.SeoulVO;

import lombok.RequiredArgsConstructor;

/*
	1. 서버에서 HTML을 완성해서 => 브라우저로 전송
	2. 초기로딩 속도가 빠르다 / 보안에유리
	3. JSP를 대체하기 위한 기술
		--- STS : 3.9.3
		
	
	4. 프로젝트 구조
		src/main/resource
			  |
			templates
			  |
			main => html (layout)
			food
			board
			seoul
		  static
		  	| 정적 폴더 => js / css / image
	5. 출력
		| 제어문 / 출력문
			| th:each="변수:${collection}"
			  th:if="조건문"
			  th:else=""
			  th:text="" => <>[[${변수}]]<>
			  ---------
			  | th:utext="" => html 파싱 후에 출력
			| index, count, size
			| even odd
			| first / last
				<a th:href="@{경로명(전송할 데이터)}">
							@{/food/list(page=1, fno=1)}
				<script th:src="@{/js/app.js}">
				
			| 속성
				<input type=text th:value="${값}">
				<img th:src="@{${파일명}}">
			| layout
				<th:block th:include="|">
									 변수
				<div th:fragment="header">
			| Form
				<form th:action="@{/user}">
				
			| 서버 Controller에서 전송
				return "폴더/파일명"; => forward 방식 => request를 전송
				return "redirect:/" => sendRedirect => request를 전송X
			| security
				<div sec:autohoize="isAuthoize()">
					----- security 태그
				=> 보안 : session 기반 / cookie 기반
							| 일반보안 	| JWT(권장)
			| Vue => delimiter="(())"
			
			| 자주 오류발생
				favicon.ico
			
				${} => EL
				#{} => numbers
				@{} => link => 파일읽기
				
			=====> 화면 UI => 항상 태그 안에서 속성으로 처리(vue)
							태그 밖에서 처리 : JSP / React
			=====> CI/CD : Git Actions
								|
							Docker => Docker Hub
								|
							Docker-Compose
								|
							MiniKube : 우분투
								|
							Jenkins
*/
@Controller
@RequiredArgsConstructor
public class MainController {
	private final SeoulService sService;
	@GetMapping("/")
	public String main_page(Model model)
	{
		Map map = new HashMap();
		map.put("table_name", "seoul_location");
		List<SeoulVO> lList = sService.seoulMainData(map);
		
		map = new HashMap();
		map.put("table_name", "seoul_nature");
		List<SeoulVO> nList = sService.seoulMainData(map);
		
		map = new HashMap();
		map.put("table_name", "seoul_shop");
		List<SeoulVO> sList = sService.seoulMainData(map);
		
		// main에 전송
		model.addAttribute("lList", lList);
		model.addAttribute("nList", nList);
		model.addAttribute("sList", sList);
		
		
		model.addAttribute("main_html", "main/home");
		return "main/main";
	}
}
















