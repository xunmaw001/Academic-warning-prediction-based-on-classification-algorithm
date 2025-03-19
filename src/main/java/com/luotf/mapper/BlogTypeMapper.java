package com.luotf.mapper;

import java.util.List;
import java.util.Map;

import com.luotf.model.BlogType;

public interface BlogTypeMapper {
    
    int deleteBlogTypeById(Integer id);

    int insertBlogType(BlogType record);

    int insertBlogTypeSelective(BlogType BlogType);
    
    BlogType selectBlogTypeById(Integer id);

    int updateBlogTypeSelective(BlogType record);

    int updateBlogType(BlogType record);
    
    int refreshCache();
    /**
 	 * 按不同条件组合 分页查询成绩类别
 	 * @param map
 	 * @return
 	 */
 	List<BlogType> selectBlogTypeListByPage(Map<String, Object> map);
 	 
 	/**
 	 * 根据成绩名称查询成绩信息
 	 * @param typename
 	 * @return
 	 */
 	BlogType selectBlogTypeByName(String typename);
 	
}