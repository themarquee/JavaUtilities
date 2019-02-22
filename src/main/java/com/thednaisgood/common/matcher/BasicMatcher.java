package com.thednaisgood.common.matcher;

import com.thednaisgood.common.utility.GeneralTools;

public class BasicMatcher<T> implements Matcher<T> {

	private T target;

	public BasicMatcher(T target) {
		this.target = target;
	}

	@Override
	public boolean matches(T candidate) {
		return GeneralTools.isEqual(target, candidate);
	}
}
