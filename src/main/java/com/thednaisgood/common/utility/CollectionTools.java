package com.thednaisgood.common.utility;

import java.util.Collection;

import com.thednaisgood.common.Converter;
import com.thednaisgood.common.helper.CollectionHelper;
import com.thednaisgood.common.matcher.Matcher;

public class CollectionTools {

	public static <O> O findMatch(Matcher<O> matcher, Collection<O> candidates) {
		CollectionHelper<O> helper = new CollectionHelper<O>(candidates);
		return helper.findMatch(matcher);
	}

	@SuppressWarnings("unchecked")
	public static <O> O findMatch(Matcher<O> matcher, O... candidates) {
		CollectionHelper<O> helper = new CollectionHelper<O>(candidates);
		return helper.findMatch(matcher);
	}

	public static <O> Collection<O> findAllMatches(Matcher<O> matcher, Collection<O> candidates) {
		CollectionHelper<O> helper = new CollectionHelper<O>(candidates);
		return helper.findAllMatches(matcher);
	}

	@SuppressWarnings("unchecked")
	public static <O> Collection<O> findAllMatches(Matcher<O> matcher, O... candidates) {
		CollectionHelper<O> helper = new CollectionHelper<O>(candidates);
		return helper.findAllMatches(matcher);
	}

	public static <T, O> Collection<T> convert(Converter<O, T> converter, Collection<O> candidates) {
		CollectionHelper<O> helper = new CollectionHelper<O>(candidates);
		return helper.convert(converter);
	}

	@SuppressWarnings("unchecked")
	public static <T, O> Collection<T> convert(Converter<O, T> converter, O... candidates) {
		CollectionHelper<O> helper = new CollectionHelper<O>(candidates);
		return helper.convert(converter);
	}
}
