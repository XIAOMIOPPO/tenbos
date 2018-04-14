package com.yidu.tencloud.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.apache.commons.beanutils.PropertyUtils;

public class BeanUtil {
	
	@SuppressWarnings("hiding")
	public static <T> T convertListToBean(List<Object> lists,Class<T> class1){
		
		T tempObj = null;
		
		try {
			tempObj = (T) class1.newInstance();
            Field[] fields = class1.getDeclaredFields();
            int start = 0;
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                String fieldName = fields[i].getName();
                Object object = lists.get(start);
                object = autoTransObject(fields[i],object);
                PropertyUtils.setProperty(tempObj,fieldName,object);
                start++;
			}
              return (T) tempObj;
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		
		
		return null;
		
	}
	
	public static Object autoTransObject(Field field, Object object) {
		
		Object temp = null;
		DecimalFormat df = new DecimalFormat("0");
		
		switch (field.getType().getName())
        {
            case "java.lang.Integer":
            case "int":
            	System.out.println("error:"+object+field.getName());
            	temp=Integer.valueOf(df.format(object));
                break;
            case "float":
            case "double":
            case "java.lang.Double":
            case "java.lang.Float":
            case "java.lang.Long":
            case "java.lang.Short":
            	temp=object;
            	break;
            case "java.math.BigDecimal":
            	Double tobj= Double.valueOf(String.valueOf(object));
            	temp=BigDecimal.valueOf(tobj);
                break;
            case "java.util.Date":
            	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            	String sdate = format.format(object); 
				try {
					temp=format.parse(sdate); 
				} catch (ParseException e) {
					e.printStackTrace();
				}
            	break;
            default:
            	temp=String.valueOf(object);
            	
                break;
        }
		
		
		return temp;
		
	}

	

}
