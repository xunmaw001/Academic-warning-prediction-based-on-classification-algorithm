package com.luotf.mapper;

import java.util.List;
import java.util.Map;

import com.luotf.model.Blog;

public interface BlogMapper {
    
    int deleteBlogById(Integer id);

    int insertBlog(Blog record);
    
    int refreshCache();

    int insertBlogSelective(Blog record);

    Blog selectBlogById(Integer id);
    
    Blog selectBlogUserById(Integer id);
    
    List<Blog> selectBlogByTypeId(Integer id);

    /**
     *  获取上一篇成绩
     * @param id
     * @return
     */
 	Blog selectPrevBlog(Integer id);

 	/**
 	 *  获取下一篇一篇成绩
 	 * @param id
 	 * @return
 	 */
 	Blog selectNextBlog(Integer id);

 	/**
 	 *  获取成绩信息，根据日期月份分组查询
 	 * @return
 	 */
 	List<?>  selectBlogListByDate(Map<String, Object> map);

 	/**
 	 *  获取成绩信息，根据状态分组查询
 	 * @return
 	 */
 	List<?>  selectBlogListByStatus();
 	
 	List<?> selectBlogByClick();
 	
 	/**
 	 * 按不同条件组合 分页查询成绩
 	 * @param map
 	 * @return
 	 */
 	
 	List<Blog> selectBlogListByPage(Map<String, Object> map);
 	
 	/**
 	 * 模糊分页查询成绩
 	 * @param map
 	 * @return
 	 */

 	List<Blog> selectLikeBlogListByPage(Map<String, Object> map);
 	
 	/**
 	 * 模糊分页组合查询成绩 (不含内容)
 	 * @param map
 	 * @return
 	 */

 	List<Blog> selectGroupLikeBlogListByPage(Map<String, Object> map);
 	
 	/**
     * 取得每个类别下的前N条记录
     * @param map
     * @return
     */
    List<Blog> selectBlogByAllType();
 	
 	/**
 	 * 模糊分页组合查询成绩 含内容
 	 * @param map
 	 * @return
 	 */
 	List<Blog> selectLikeBlogListByPageWithBlobs(Map<String, Object> map);
 	/**
 	 *  根据组合条件获取Blog条数
 	 * @param map
 	 * @return
 	 */
 	Long selectBlogCount(Map<String, Object> map);

 	
    int updateBlogSelective(Blog record);

    
    int updateBlogWithBLOBs(Blog record);

    
    int updateBlog(Blog record);
}