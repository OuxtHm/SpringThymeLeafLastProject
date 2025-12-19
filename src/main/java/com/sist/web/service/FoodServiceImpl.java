package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.FoodMapper;
import com.sist.web.vo.FoodVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService{
	private final FoodMapper mapper;
	
	@Override
	public List<FoodVO> foodListData(int start) {
		return mapper.foodListData(start);
	}
	@Override
	public int foodTotalPage() {
		return mapper.foodTotalPage();
	}
	
	@Override
	public List<FoodVO> foodTop10Data() {
		return mapper.foodTop10Data();
	}
	
	@Override
	public FoodVO foodDetailData(int fno) {
		mapper.foodHitIncrement(fno);
		return mapper.foodDetailData(fno);
	}
}
