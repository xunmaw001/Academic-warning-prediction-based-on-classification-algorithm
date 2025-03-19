package com.luotf.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luotf.mapper.ScoresMapper;
import com.luotf.model.Scores;
import com.luotf.service.ScoresService;

@Service
public class ScoresServiceImpl implements ScoresService {

	@Autowired
	private ScoresMapper scoresMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return scoresMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Scores record) {
		// TODO Auto-generated method stub
		return scoresMapper.insert(record);
	}

	@Override
	public int insertSelective(Scores record) {
		// TODO Auto-generated method stub
		return scoresMapper.insertSelective(record);
	}

	@Override
	public Scores selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return scoresMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Scores record) {
		// TODO Auto-generated method stub
		return scoresMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Scores record) {
		// TODO Auto-generated method stub
		return scoresMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Scores> selectLikeScoresListByPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return scoresMapper.selectLikeScoresListByPage(map);
	}

	@Override
	public List<Scores> selectGroupLikeScoresListByPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return scoresMapper.selectGroupLikeScoresListByPage(map);
	}

}
