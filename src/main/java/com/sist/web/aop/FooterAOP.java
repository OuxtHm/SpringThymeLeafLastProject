package com.sist.web.aop;

import java.util.*;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sist.web.vo.*;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

import com.sist.web.service.*;

/*
	AOP 적용 => JoinPoint / PointCut
			   메소드 어느 영역 
			   
	public void aaa()
	{
		@Before		   
		try{
			-------------- @Around(first) => setAutoCommit(false)
			
			-------------- @Around(last) => commit
		}catch(Exception ex){
			@After-Throwing => rollback()
		} finally {
			@After
		}
		return "" @After-Returning
		
		해당 메소드를 한번에 통합 => 호출
		------------------- 위빙
		
		@After   @Before  @After-Throwing
		after() before() afterthrowing()
		
		public void aaa()
		{
			try{
				----
				----
			} catch(Exception e) {
				afterthrowing()
			} finally {
				after()
			}
		}
	}
	
*/

@Aspect// 공통 모듈 => 모든 HTML에 공통으로 적용
@Component // 관리 => 스프링에서 처리
@RequiredArgsConstructor
public class FooterAOP {
	private final FoodService fService;
	private final RecipeService rService;
	@After("execution(* com.sist.web.controller.*Controller.*(..))")
	public void after()
	{
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		List<FoodVO> fList = fService.foodTop10Data();
		request.setAttribute("fList", fList);
		
		List<RecipeVO> rList = rService.recipeTop10();
		request.setAttribute("rList", rList);
	}
}
