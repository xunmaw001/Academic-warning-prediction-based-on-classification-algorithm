package com.luotf.service;

import java.util.List;
import java.util.Map;

import com.luotf.model.BlogType;

public interface BlogTypeService {
	
	/**
 	 * 按不同条件组合 分页查询成绩类别
 	 * @param map
 	 * @return
 	 */
 	List<BlogType> selectBlogTypeListByPage(Map<String, Object> map);
 	
 	/**
 	 * 插入成绩类别
 	 * @param map
 	 * @return
 	 */
 	int insertBlogType(BlogType record);
 	
 	/**
 	 * 根据成绩名称查询成绩信息
 	 * @param typename
 	 * @return
 	 */
 	BlogType selectBlogTypeByName(String typename);
 	
 	
 	BlogType selectBlogTypeById(Integer id);
 	
 	int updateBlogTypeSelective(BlogType record);
 	
 	 int deleteBlogTypeById(Integer id);
}
