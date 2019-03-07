package bunn.common.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import bunn.common.Converter;
import bunn.common.Visitor;
import bunn.common.matcher.Matcher;
import bunn.common.tools.GeneralTools;

public class CollectionHelper<O> {

	private Collection<O> collection;

	public CollectionHelper(Collection<O> collection) {
		if (collection == null) throw new NullPointerException("Collection cannot be null");
		this.collection = collection;
	}

	public CollectionHelper(O[] collection) {
		if (collection == null) throw new NullPointerException("Collection cannot be null");
		this.collection = Arrays.asList(collection);
	}

	public void visit(Visitor<O> visitor) {
		if (visitor == null) throw new NullPointerException("Visitor cannot be null.");
		for (O item : this.collection)
			visitor.visit(item);
	}

	public O findMatch(Matcher<O> matcher) {
		if (matcher == null) throw new NullPointerException("Matcher cannot be null.");
		for (O item : this.collection) {
			if (matcher.matches(item)) return item;
		}
		return null;
	}

	public Collection<O> findAllMatches(Matcher<O> matcher) {
		if (matcher == null) throw new NullPointerException("Matcher cannot be null.");
		Collection<O> allMatches = new ArrayList<O>();
		if (GeneralTools.hasNoItems(this.collection)) return allMatches;
		for (O item : this.collection) {
			if (!matcher.matches(item)) continue;
			allMatches.add(item);
		}
		return allMatches;
	}

	public <T> Collection<T> convert(Converter<O, T> converter) {
		if (converter == null) throw new NullPointerException("Converter cannot be null.");
		Collection<T> convertedItems = new ArrayList<T>();
		if (GeneralTools.hasNoItems(this.collection)) return convertedItems;
		for (O item : this.collection) {
			convertedItems.add(converter.convert(item));
		}
		return convertedItems;
	}
}
