package com.yidu.tencloud.util;

import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import aj.org.objectweb.asm.Type;

public class DateDeserializer {
	public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {        
        return new java.util.Date(json.getAsJsonPrimitive().getAsLong());    
    }
}
