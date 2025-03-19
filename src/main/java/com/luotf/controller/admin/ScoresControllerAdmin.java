package com.luotf.controller.admin;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luotf.annotation.AccessLimit;
import com.luotf.annotation.SystemLog;
import com.luotf.model.Scores;
import com.luotf.service.ScoresService;
import com.luotf.util.ConstantUtil;
import com.luotf.util.subStringUtil;

@Controller
@RequestMapping(value = "/admin")
public class ScoresControllerAdmin {

  @Resource(name = "scoresServiceImpl")
  private ScoresService scoresService;

//  /**
//   * 实现添加成绩功能
//   *
//   * @param Scores
//   * @return
//   * @throws Exception
//   */
//  @RequestMapping(value = "/addScores", method = RequestMethod.POST)
//  @ResponseBody
//  @SystemLog(description = ConstantUtil.Scores_ADD, userType = ConstantUtil.USERTYPE_ADMIN)
//  public Map<String, Object> addScores(String prarm, Scores Scores) throws Exception {
//    Map<String, Object> map = new HashMap<String, Object>();
//    // 将中文的分号转换成英文的分号
//    if (Scores.getKeyword() != null && Scores.getKeyword() != "") {
//      Scores.setKeyword(subStringUtil.subKeyword(Scores.getKeyword()));
//    }
//    Scores.setAddtime(new Date());
//    if (scoresService.insertScores(Scores) != 0) {
//      map.put("status", 200);
//    } else {
//      // 0表示：插入失败
//      map.put("status", 0);
//    }
//    return map;
//  }
//
//  /**
//   * 实现删除成绩功能
//   *
//   * @param Scores
//   * @return
//   * @throws Exception
//   */
//  @RequestMapping(value = "/deleteScores", method = RequestMethod.POST)
//  @ResponseBody
//  @SystemLog(description = ConstantUtil.Scores_DELETE, userType = ConstantUtil.USERTYPE_ADMIN)
//  public Map<String, Object> deleteScores(Integer id,HttpSession session) throws Exception {
//    Map<String, Object> map = new HashMap<String, Object>();
//    String username = (String)session.getAttribute("username");
//	Scoreser Scoreser = ScoreserService.findUserByLoginName(username);
//	if(Scoreser.getHasPermission() == 0){
//		map.put("status", 0);
//		map.put("msg", "没有删除权限");
//		return map;
//	}
//    if (scoresService.deleteScoresById(id) != 0) {
//      map.put("status", 200);
//      map.put("msg", "删除成功");
//    } else {
//      // 0表示：删除失败
//      map.put("status", 0);
//      map.put("msg", "删除失败");
//    }
//    return map;
//  }
//
// 
//  /**
//   * 按成绩id查询成绩信息
//   *
//   * @param Scores
//   * @return
//   * @throws Exception
//   */
//  @RequestMapping(value = "/selectScoresById", method = RequestMethod.POST)
//  @ResponseBody
//  public Map<String, Object> selectScoresById(Integer id) throws Exception {
//    Map<String, Object> map = new HashMap<String, Object>();
//    Scores Scores = scoresService.selectScoresById(id);
//    if (Scores != null) {
//      map.put("status", 200);
//    } else {
//      // 500表示：返回值为Null
//      map.put("status", 500);
//    }
//    map.put("Scores", Scores);
//    return map;
//  }
//
//
//
//  /**
//   * 多条件模糊分页查询成绩信息(or)
//   *
//   * @param id
//   * @return
//   * @throws Exception
//   */
//  @RequestMapping(value = "/selectLikeScoresListByPage", method = RequestMethod.POST)
//  @ResponseBody
//  @AccessLimit(seconds = 1, maxCount = 13)
//  public Map<String, Object> selectLikeScoresListByPage(
//      Scores Scores,
//      @RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
//      @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize)
//      throws Exception {
//    Map<String, Object> map = new HashMap<String, Object>();
//
//    if (Scores.getTitle() != null && Scores.getTitle() != "") {
//      map.put("title", Scores.getTitle());
//    }
//    if (Scores.getIntroduction() != null && Scores.getIntroduction() != "") {
//      map.put("introduction", Scores.getIntroduction());
//    }
//    if (Scores.getKeyword() != null && Scores.getKeyword() != "") {
//      map.put("keyword", Scores.getKeyword());
//    }
//    if (Scores.getContent() != null && Scores.getContent() != "") {
//      map.put("content", Scores.getContent());
//    }
//    if (Scores.getIstop() != null) {
//      map.put("isTop", Scores.getIstop());
//    }
//    if (Scores.getType() != null) {
//      map.put("type_id", Scores.getType().getId());
//    }
//    if (Scores.getStatus() != null) {
//      map.put("status", Scores.getStatus());
//    }
//    if (Scores.getIsrecommend() != null) {
//      map.put("isRecommend", Scores.getIsrecommend());
//    }
//    if (Scores.getAddtime() != null) {
//      map.put("addTime", Scores.getAddtime());
//    }
//    // 分页显示：第1页开始，每页显示10条记录
//    PageHelper.startPage(page, pageSize);
//    List<Scores> ScoresList = scoresService.selectLikeScoresListByPage(map);
//    PageInfo<Scores> pageInfo = new PageInfo<Scores>(ScoresList);
//    Map<String, Object> returnMap = new HashMap<String, Object>();
//    if (ScoresList.size() > 0) {
//      returnMap.put("status", 200);
//
//    } else {
//      // 500表示：返回值为Null
//      returnMap.put("status", 500);
//    }
//    returnMap.put("ScoresList", ScoresList);
//    returnMap.put("pageInfo", pageInfo);
//    return returnMap;
//  }

  /**
   * 模糊组合分页查询成绩信息(and)
   *
   * @param id
   * @return
   * @throws Exception
   */
  @RequestMapping(value = "/selectGroupLikeScoresListByPage")
  @ResponseBody
  @AccessLimit(seconds = 1, maxCount = 15)
  public Map<String, Object> selectGroupLikeScoresListByPage(
      Scores Scores,
      @RequestParam(value = "sort", required = true, defaultValue = "addTime") String sort,
      @RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
      @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize)
      throws Exception {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("sort", sort);
    if (Scores.getCourse() != null && Scores.getCourse() != "") {
      map.put("course", Scores.getCourse());
    }
    if (Scores.getIntroduction() != null && Scores.getIntroduction() != "") {
      map.put("introduction", Scores.getIntroduction());
    }
    if (Scores.getClasss() != null && Scores.getClasss() != "") {
      map.put("classs", Scores.getClasss());
    }
    if (Scores.getContent() != null && Scores.getContent() != "") {
      map.put("content", Scores.getContent());
    }
    if (Scores.getStudent() != null) {
      map.put("student", Scores.getStudent());
    }
    if (Scores.getYear() != null) {
      map.put("year", Scores.getYear());
    }
    if (Scores.getTime() != null) {
      map.put("time", Scores.getTime());
    }
    // 分页显示：第1页开始，每页显示10条记录
    PageHelper.startPage(page, pageSize);
    List<Scores> ScoresList = scoresService.selectGroupLikeScoresListByPage(map);
    PageInfo<Scores> pageInfo = new PageInfo<Scores>(ScoresList);
    Map<String, Object> returnMap = new HashMap<String, Object>();
    if (ScoresList.size() > 0) {
      returnMap.put("status", 200);
    } else {
      // 500表示：返回值为Null
      returnMap.put("status", 500);
    }
    returnMap.put("ScoresList", ScoresList);
    returnMap.put("pageInfo", pageInfo);
    return returnMap;
  }

//  /**
//   * 按照不同条件分页查询成绩信息
//   *
//   * @param id
//   * @return
//   * @throws Exception
//   */
//  @RequestMapping(value = "/selectScoresListByPage", method = RequestMethod.POST)
//  @ResponseBody
//  @AccessLimit(seconds = 1, maxCount = 13)
//  public Map<String, Object> selectScoresListByPage(
//      Scores Scores,
//      @RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
//      @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize)
//      throws Exception {
//    Map<String, Object> map = new HashMap<String, Object>();
//
//    if (Scores.getTitle() != null && Scores.getTitle() != "") {
//      map.put("title", Scores.getTitle());
//    }
//    if (Scores.getIntroduction() != null && Scores.getIntroduction() != "") {
//      map.put("introduction", Scores.getIntroduction());
//    }
//    if (Scores.getKeyword() != null && Scores.getKeyword() != "") {
//      map.put("keyword", Scores.getKeyword());
//    }
//    if (Scores.getContent() != null && Scores.getContent() != "") {
//      map.put("content", Scores.getContent());
//    }
//    if (Scores.getIstop() != null) {
//      map.put("isTop", Scores.getIstop());
//    }
//    if (Scores.getType() != null) {
//      map.put("type_id", Scores.getType().getId());
//    }
//    if (Scores.getStatus() != null) {
//      map.put("status", Scores.getStatus());
//    }
//    if (Scores.getIsrecommend() != null) {
//      map.put("isRecommend", Scores.getIsrecommend());
//    }
//    if (Scores.getAddtime() != null) {
//      map.put("addTime", Scores.getAddtime());
//    }
//    // 分页显示：第1页开始，每页显示10条记录
//    PageHelper.startPage(page, pageSize);
//    List<Scores> ScoresList = scoresService.selectScoresListByPage(map);
//    PageInfo<Scores> pageInfo = new PageInfo<Scores>(ScoresList);
//    Map<String, Object> returnMap = new HashMap<String, Object>();
//
//    if (ScoresList.size() > 0) {
//      returnMap.put("status", 200);
//
//    } else {
//      // 500表示：返回值为Null
//      returnMap.put("status", 500);
//    }
//    returnMap.put("ScoresList", ScoresList);
//    returnMap.put("pageInfo", pageInfo);
//    return returnMap;
//  }
//
//  /**
//   * 按照不同时间查询成绩的发表数量
//   *
//   * @param id
//   * @return
//   * @throws Exception
//   */
//  @RequestMapping(value = "/selectScoresListByDate", method = RequestMethod.POST)
//  @ResponseBody
//  @AccessLimit(seconds = 1, maxCount = 10)
//  public Map<String, Object> selectScoresListByDate(
//      @RequestParam(value = "status") String status,
//      @RequestParam(value = "startTime") String startTime,
//      @RequestParam(value = "endTime") String endTime)
//      throws Exception {
//    Map<String, Object> map = new HashMap<String, Object>();
//    if (status != "" && status != null) {
//      map.put("status", status);
//    }
//    if (startTime != "" && startTime != null) {
//      map.put("startTime", startTime);
//    }
//    if (endTime != "" && endTime != null) {
//      map.put("endTime", endTime);
//    }
//    List<?> list = scoresService.selectScoresListByDate(map);
//    Map<String, Object> returnMap = new HashMap<String, Object>();
//    if (list.size() > 0) {
//      returnMap.put("status", 200);
//    } else {
//      // 500表示：返回值为Null
//      returnMap.put("status", 500);
//    }
//    returnMap.put("list", list);
//    return returnMap;
//  }
//
//  /**
//   * 按照不同条件查询成绩的数量
//   *
//   * @param id
//   * @return
//   * @throws Exception
//   */
//  @RequestMapping(value = "/selectScoresCount", method = RequestMethod.POST)
//  @ResponseBody
//  @AccessLimit(seconds = 1, maxCount = 10)
//  public Map<String, Object> selectScoresCount(Scores Scores) throws Exception {
//    Map<String, Object> map = new HashMap<String, Object>();
//    if (Scores.getKeyword() != null && Scores.getKeyword() != "") {
//      map.put("keyword", Scores.getKeyword());
//    }
//    if (Scores.getType() != null) {
//      map.put("type_id", Scores.getType().getId());
//    }
//    if (Scores.getStatus() != null) {
//      map.put("status", Scores.getStatus());
//    }
//    if (Scores.getIsrecommend() != null) {
//      map.put("isRecommend", Scores.getIsrecommend());
//    }
//    if (Scores.getAddtime() != null) {
//      map.put("addTime", Scores.getAddtime());
//    }
//    Long count = scoresService.selectScoresCount(map);
//    Map<String, Object> returnMap = new HashMap<String, Object>();
//    if (count > 0) {
//      returnMap.put("status", 200);
//    } else {
//      // 500表示：返回值为Null
//      returnMap.put("status", 500);
//    }
//    returnMap.put("count", count);
//    return returnMap;
//  }
//
//  /**
//   * 查询前一篇成绩信息
//   *
//   * @param id
//   * @return
//   * @throws Exception
//   */
//  @RequestMapping(value = "/selectPrevScores", method = RequestMethod.POST)
//  @ResponseBody
//  @AccessLimit(seconds = 1, maxCount = 5)
//  public Map<String, Object> selectPrevScores(Integer id) throws Exception {
//    Map<String, Object> map = new HashMap<String, Object>();
//    Scores Scores = scoresService.selectPrevScores(id);
//    if (Scores != null) {
//      map.put("status", 200);
//
//    } else {
//      // 500表示：返回值为Null
//      map.put("status", 500);
//    }
//    map.put("Scores", Scores);
//    return map;
//  }
//
//  /**
//   * 查询后一篇成绩信息
//   *
//   * @param id
//   * @return
//   * @throws Exception
//   */
//  @RequestMapping(value = "/selectNextScores", method = RequestMethod.POST)
//  @ResponseBody
//  @AccessLimit(seconds = 1, maxCount = 5)
//  public Map<String, Object> selectNextScores(Integer id) throws Exception {
//    Map<String, Object> map = new HashMap<String, Object>();
//    Scores Scores = scoresService.selectNextScores(id);
//    if (Scores != null) {
//      map.put("status", 200);
//
//    } else {
//      // 500表示：返回值为Null
//      map.put("status", 500);
//    }
//    map.put("Scores", Scores);
//    return map;
//  }


 
}
