package com.yidu.tencloud.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;

public class TreeUtil {

	private String primaryName;

	private String parentName;
	
	private String nodesName;
	
	
	public String getPrimaryName() {
		return primaryName;
	}

	public void setPrimaryName(String primaryName) {
		this.primaryName = primaryName;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getNodesName() {
		return nodesName;
	}

	public void setNodesName(String nodesName) {
		this.nodesName = nodesName;
	}
	
	

	public TreeUtil(String primaryName, String parentName, String nodesName) {
		super();
		this.primaryName = primaryName;
		this.parentName = parentName;
		this.nodesName = nodesName;
	}

	public List<? extends T> listToTree(List<T> listData){
		//挑出父节点和字节点
		List<T> parentNode = new ArrayList<T>();
		List<T> childrenNode = new ArrayList<T>();
		//分离子节点和父节点
		for (T t : listData) {
			String pname = getByName(parentName,t);
			if (pname==null) {
				parentNode.add(t);
			} else {
				childrenNode.add(t);
			}
		}
		
		//递归生成树
		for (T t : parentNode) {
			String primaryKey = getByName(primaryName,t);
			setByName(t,getChildren(primaryKey,childrenNode));
		}
		
		return parentNode;
	}

	private List<T> getChildren(String primaryKey, List<T> childrenNode) {
		//子集合
		List<T> cNode = new ArrayList<T>();
		//遍历集合寻找符合主键的记录
		for (T t : childrenNode) {
			String pname = getByName(parentName,t);
			if(pname.equals(primaryKey)) {
				cNode.add(t);
			}
		}
		
		//递归子集合
		for (T t : cNode) {
			setByName(t,getChildren(getByName(primaryName,t),childrenNode));
		}
		
		if(cNode.size()==0) {
			return null;
		}
		
		return cNode;
		
		
	}

	private String getByName(String name,T t) {
		Class<? extends T> clazz = t.getClass();
		try {
			Method method = clazz.getDeclaredMethod(name);
			String result = (String) method.invoke(t);
			return result;
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void setByName(T t,Object data) {
		Class<? extends T> clazz = t.getClass();
		try {
			Method method = clazz.getDeclaredMethod(nodesName);
			method.invoke(t,data);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	
	
	
}
