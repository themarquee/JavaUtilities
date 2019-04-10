package bunn.common.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import bunn.common.Converter;
import bunn.common.Visitor;
import bunn.common.helper.CollectionHelper;
import bunn.common.matcher.BasicMatcher;
import bunn.common.matcher.Matcher;

public class CollectionTools {

	private CollectionTools() {}

	public static <O> O findMatch(Matcher<O> matcher, Collection<O> candidates) {
		return new CollectionHelper<O>(candidates).findMatch(matcher);
	}

	@SuppressWarnings("unchecked")
	public static <O> O findMatch(Matcher<O> matcher, O... candidates) {
		return new CollectionHelper<O>(candidates).findMatch(matcher);
	}

	public static <O> O findMatch(O target, Collection<O> candidates) {
		return new CollectionHelper<O>(candidates).findMatch(new BasicMatcher<>(target));
	}

	@SuppressWarnings("unchecked")
	public static <O> O findMatch(O target, O... candidates) {
		return new CollectionHelper<O>(candidates).findMatch(new BasicMatcher<>(target));
	}

	public static <O> Collection<O> findAllMatches(Matcher<O> matcher, Collection<O> candidates) {
		return new CollectionHelper<O>(candidates).findAllMatches(matcher);
	}

	@SuppressWarnings("unchecked")
	public static <O> Collection<O> findAllMatches(Matcher<O> matcher, O... candidates) {
		return new CollectionHelper<O>(candidates).findAllMatches(matcher);
	}

	public static <T, O> Collection<T> convert(Converter<O, T> converter, Collection<O> candidates) {
		return new CollectionHelper<O>(candidates).convert(converter);
	}

	@SuppressWarnings("unchecked")
	public static <T, O> Collection<T> convert(Converter<O, T> converter, O... candidates) {
		return new CollectionHelper<O>(candidates).convert(converter);
	}

	public static <O> void visit(Visitor<O> visitor, Collection<O> items) {
		new CollectionHelper<O>(items).visit(visitor);
	}

	@SuppressWarnings("unchecked")
	public static <O> void convert(Visitor<O> visitor, O... candidates) {
		new CollectionHelper<O>(candidates).visit(visitor);
	}

	public static Set<String> mergeToSet(Collection<String> collectionA, Collection<String> collectionB) {
		return Stream.concat(collectionA.stream(), collectionB.stream()).collect(Collectors.toSet());
	}

	public static List<String> mergeToList(Collection<String> collectionA, Collection<String> collectionB) {
		return Stream.concat(collectionA.stream(), collectionB.stream()).collect(Collectors.toList());
	}

	public static <T> Set<T> arrayToSet(T[] array) {
		return (Set<T>) arrayToCollection(array, new HashSet<>());
	}

	public static <T> List<T> arrayToList(T[] array) {
		return (List<T>) arrayToCollection(array, new ArrayList<>());
	}

	public static <T> Collection<T> arrayToCollection(T[] array, Collection<T> collection) {
		Arrays.stream(array).forEach(item -> collection.add(item));
		return collection;
	}

	@SuppressWarnings("unchecked")
	public static <T> Set<T> collectToSet(T... items) {
		return Arrays.stream(items).collect(Collectors.toSet());
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> collectToList(T... items) {
		return Arrays.stream(items).collect(Collectors.toList());
	}

	public static <T> List<T> emptyList() {
		return new ArrayList<>(0);
	}

	public static <K, E> Map<K, E> emptyMap() {
		return new HashMap<>(0);
	}
}
