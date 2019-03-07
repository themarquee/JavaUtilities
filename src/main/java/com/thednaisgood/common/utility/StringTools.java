package com.thednaisgood.common.utility;

import org.apache.commons.lang3.StringUtils;

public class StringTools {

	public static String join(String... items) {
		return StringUtils.join(items, ',');
	}

}
