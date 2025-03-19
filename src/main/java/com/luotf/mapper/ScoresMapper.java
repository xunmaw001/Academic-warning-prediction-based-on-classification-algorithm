package com.luotf.mapper;

import java.util.List;
import java.util.Map;

import com.luotf.model.Scores;

public interface ScoresMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Scores record);

    int insertSelective(Scores record);

    Scores selectByPrimaryKey(Integer id);
    
    /**
    * 模糊查询
    * @param map
    * @return
    */
   List<Scores> selectLikeScoresListByPage(Map<String, Object> map);
   
   
   List<Scores> selectGroupLikeScoresListByPage(Map<String, Object> map);
   
    /**
 	 *  根据日期月份分组查询
 	 * @return
 	 */
 	List<?>  selectScoresListByDate(Map<String, Object> map);
 	
 	/**
 	 *  根据学生分组查询
 	 * @return
 	 */
 	List<?>  selectScoresListByStudent(Map<String, Object> map);
 	
    int updateByPrimaryKeySelective(Scores record);

    int updateByPrimaryKey(Scores record);
}