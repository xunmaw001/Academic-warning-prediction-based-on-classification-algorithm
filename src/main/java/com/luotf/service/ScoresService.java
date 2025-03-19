package com.luotf.service;

import java.util.List;
import java.util.Map;

import com.luotf.model.Scores;

public interface ScoresService {

	int deleteByPrimaryKey(Integer id);

    int insert(Scores record);

    int insertSelective(Scores record);

    Scores selectByPrimaryKey(Integer id);
    
    int updateByPrimaryKeySelective(Scores record);
    
    int updateByPrimaryKey(Scores record);
    
    List<Scores> selectLikeScoresListByPage(Map<String, Object> map);
    
    List<Scores> selectGroupLikeScoresListByPage(Map<String, Object> map);
    
}
