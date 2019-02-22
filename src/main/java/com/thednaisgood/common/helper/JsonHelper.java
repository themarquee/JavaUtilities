package com.thednaisgood.common.helper;

import com.google.gson.Gson;

public class JsonHelper {
	private static final Gson gsonService = new Gson();
	
	public static <T> String convertToJson(T object) {
		return gsonService.toJson(object);
	}
	
	public static <T> T convertFromJson(String json, Class<T> clazz) {
		return gsonService.fromJson(json, clazz);
	}
	
	public static <T> String convertToJson(Gson customGsonService, T object) {
		return customGsonService.toJson(object);
	}
	
	public static <T> T convertFromJson(Gson customGsonService, String json, Class<T> clazz) {
		return customGsonService.fromJson(json, clazz);
	}
}
