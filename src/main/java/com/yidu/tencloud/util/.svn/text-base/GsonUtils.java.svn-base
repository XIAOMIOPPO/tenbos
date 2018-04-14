package com.yidu.tencloud.util;

import java.text.DateFormat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtils {
	 private static Gson instance = null;
	    public synchronized static Gson getGson(){
	        if(instance == null) {
	            GsonBuilder builder = new GsonBuilder();
	            builder.registerTypeAdapter(java.util.Date.class, new DateSerializer()).setDateFormat(DateFormat.LONG);
	            builder.registerTypeAdapter(java.util.Date.class, new DateDeserializer()).setDateFormat(DateFormat.LONG);
	            instance = builder.create();
	        }
	        return instance;
	    }


}
