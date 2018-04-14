package com.yidu.tencloud.dao.taketosend.propaganda;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.taketosend.propaganda.Propaganda;
/**
 * 宣传任务的数据访问层的实现类
 * @author 袁棋凡
 * @since 2017/12/25
 */
public interface PropagandaMapper {
	  /**
       * 查询所有宣传任务
       * @param paramMap map接口
       * @return 宣传任务集合 
       */
       public List<Propaganda> propagandaPageQuery(Map<String,Object> paramMap);
       /**
  	   * 添加宣传任务
  	   * @param propaganda 宣传任务对象
  	   * @return 是否添加成功
  	   */
       public int addPropaganda(Propaganda propaganda);
       /**
  	   * 删除宣传任务
  	   * @param propagandaId 宣传任务Id
  	   * @return 是否删除成功
  	   */
       public int deletePropaganda(String propagandaId);
       /**
 	   * 修改宣传任务
 	   * @param paramMap map接口
 	   * @return 是否修改成功
 	   */
       public int updatePropaganda(Map<String,Object> paramMap);
       /**
  	   * 记录宣传任务的总数
  	   * @return 总数
  	   */
       public int countPropaganda();
       /**
  	   * 记录宣传任务的总数带条件
  	   * @param paramMap map接口
  	   * @return 总数
  	   */
       public int countPropagandaWithCriteria(Map<String,Object> paramMap);
       /**
  	   * 查询所有宣传任务带条件
  	   * @param paramMap map接口
  	   * @return 宣传任务集合
  	   */
       public List<Propaganda> propagandaPageQueryWithCriteria(Map<String,Object> paramMap);
       /**
  	   * 查询一个星期内的宣传任务
  	   * @param paramMap
  	   * @return
  	   */
       public int findWeekPropaganda();
}
