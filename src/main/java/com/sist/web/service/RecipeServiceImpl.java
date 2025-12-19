package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.RecipeMapper;
import com.sist.web.vo.RecipeDetailVO;
import com.sist.web.vo.RecipeVO;

import lombok.RequiredArgsConstructor;

/*
	VO => Mapper(SQL) ==> Service에서 구현 ====> Controller ===> HTML/JSP
			|순수 SQL			|						|
							|					데이터베이스에서 읽은 값을 브라우저
							|						|Spring에서 처리
							|						|@Controller
							|						|	|ThymeLeaf/JSP
							|						|	| router
							|						|	| return
							|						|Spring에서 데이터 전송
							|						| @RestController
							|							| Vue / React / Next.js
							SQL 여러개 모아 하나의		=> JS / TS
							기능 수행 => hitIncrement	  ---------
														일반 데이터형은 동일
														Object / Array
														|			| List => []
														|VO, Map=> {}
														
														
		class A
		{
			int no;
			String name, sex, address;
		}
		TS
		intserface A
		{
			no:int,
			name:string,
			sex:string,
			address:string
		}
		JS
		{no:1, name:'', sex:'', address:''} => JSON


*/
@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService{
	private final RecipeMapper mapper;
	
	@Override
	public List<RecipeVO> recipeListDate(int start) {
		return mapper.recipeListDate(start);
	}
	@Override
	public int recipeTotalPage() {
		return mapper.recipeTotalPage();
	}
	
	@Override
	public RecipeDetailVO recipeDetailData(int no) {
		mapper.recipeHitIncrement(no);
		return mapper.recipeDetailData(no);
	}
	
	@Override
	public List<RecipeVO> recipeTop10() {
		return mapper.recipeTop10();
	}
	@Override
	public List<RecipeVO> recipeChefListData(int start, String chef) {
		// TODO Auto-generated method stub
		return mapper.recipeChefListData(start, chef);
	}
	
	@Override
	public int recipeChefTotalPage(String chef) {
		return mapper.recipeChefTotalPage(chef);
	}
}
