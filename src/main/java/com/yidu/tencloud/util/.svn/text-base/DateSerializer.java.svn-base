package com.yidu.tencloud.util;

import java.util.Date;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;

import aj.org.objectweb.asm.Type;

public class DateSerializer {

	public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {              
        return new JsonPrimitive(src.getTime());    
    }
	
}
