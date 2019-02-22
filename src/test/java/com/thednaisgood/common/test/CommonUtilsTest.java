package com.thednaisgood.common.test;

import static com.thednaisgood.common.utility.GeneralTools.collectionToArray;
import static com.thednaisgood.common.utility.GeneralTools.hasItems;
import static com.thednaisgood.common.utility.GeneralTools.hasNItems;
import static com.thednaisgood.common.utility.GeneralTools.hasNoItems;
import static com.thednaisgood.common.utility.GeneralTools.hasOneItem;
import static com.thednaisgood.common.utility.GeneralTools.parseInteger;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CommonUtilsTest {

	@Test
	public void hasItems_list_positive() {
		List<String> list = new ArrayList<String>();
		list.add("hello");
		assertTrue(hasItems(list));
	}

	@Test
	public void hasItems_list_positive_emptyStringElement() {
		List<String> list = new ArrayList<String>();
		list.add("");
		assertTrue(hasItems(list));
	}

	@Test
	public void hasItems_list_positive_nullElement() {
		List<String> list = new ArrayList<String>();
		list.add(null);
		assertTrue(hasItems(list));
	}

	@Test
	public void hasItems_list_negative_null() {
		List<String> list = null;
		assertFalse(hasItems(list));
	}

	@Test
	public void hasItems_list_negative_empty() {
		List<String> list = new ArrayList<String>();
		assertFalse(hasItems(list));
	}

	@Test
	public void hasNoItems_list_positive_empty() {
		List<String> list = new ArrayList<String>();
		assertTrue(hasNoItems(list));
	}

	@Test
	public void hasNoItems_list_positive_null() {
		List<String> list = null;
		assertTrue(hasNoItems(list));
	}

	@Test
	public void hasNoItems_list_negative() {
		List<String> list = new ArrayList<String>();
		list.add("Hello");
		assertFalse(hasNoItems(list));
	}

	@Test
	public void hasNoItems_list_negative_emptyString() {
		List<String> list = new ArrayList<String>();
		list.add("");
		assertFalse(hasNoItems(list));
	}

	@Test
	public void hasNoItems_list_negative_nullElement() {
		List<String> list = new ArrayList<String>();
		list.add(null);
		assertFalse(hasNoItems(list));
	}

	@Test
	public void hasNItems_list_positive() {
		List<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("world");
		assertTrue(hasNItems(2, list));
	}

	@Test
	public void hasNItems_list_positive_emptyList() {
		List<String> list = new ArrayList<String>();
		assertTrue(hasNItems(0, list));
	}

	@Test
	public void hasNItems_list_negative() {
		List<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("world");
		assertFalse(hasNItems(3, list));
	}

	@Test
	public void hasNItems_list_negative_nullList() {
		List<String> list = null;
		assertFalse(hasNItems(0, list));
	}

	@Test
	public void hasOneItem_list_positive() {
		List<String> list = new ArrayList<String>();
		list.add("hello");
		assertTrue(hasOneItem(list));
	}

	@Test
	public void hasOneItem_list_positive_nullElement() {
		List<String> list = new ArrayList<String>();
		list.add(null);
		assertTrue(hasOneItem(list));
	}

	@Test
	public void hasOneItem_list_negative_empty() {
		List<String> list = new ArrayList<String>();
		assertFalse(hasOneItem(list));
	}

	@Test
	public void hasOneItem_list_negative_two() {
		List<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("world");
		assertFalse(hasOneItem(list));
	}

	@Test
	public void hasOneItem_list_negative_nullList() {
		List<String> list = null;
		assertFalse(hasOneItem(list));
	}

	@Test
	public void hasItems_array_positive() {
		String[] array = { "hello" };
		assertTrue(hasItems(array));
	}

	@Test
	public void hasItems_array_positive_emptyStringElement() {
		String[] array = { "" };
		assertTrue(hasItems(array));
	}

	@Test
	public void hasItems_array_positive_nullElement() {
		String[] array = { null };
		assertTrue(hasItems(array));
	}

	@Test
	public void hasItems_array_negative_null() {
		String[] array = null;
		assertFalse(hasItems(array));
	}

	@Test
	public void hasItems_array_negative_emptyArray() {
		String[] array = {};
		assertFalse(hasItems(array));
	}

	@Test
	public void hasNoItems_array_positive_emptyArray() {
		String[] array = {};
		assertTrue(hasNoItems(array));
	}

	@Test
	public void hasNoItems_array_positive_nullArray() {
		String[] array = null;
		assertTrue(hasNoItems(array));
	}

	@Test
	public void hasNoItems_array_negative() {
		String[] array = { "hello" };
		assertFalse(hasNoItems(array));
	}

	@Test
	public void hasNoItems_array_negative_emptyString() {
		String[] array = { "" };
		assertFalse(hasNoItems(array));
	}

	@Test
	public void hasNoItems_array_negative_nullElement() {
		String[] array = { null };
		assertFalse(hasNoItems(array));
	}

	@Test
	public void hasNItems_array_positive() {
		String[] array = { "hello", "world" };
		assertTrue(hasNItems(2, array));
	}

	@Test
	public void hasNItems_array_positive_emptyArray() {
		String[] array = {};
		assertTrue(hasNItems(0, array));
	}

	@Test
	public void hasNItems_array_negative() {
		String[] array = { "hello", "world" };
		assertFalse(hasNItems(3, array));
	}

	@Test
	public void hasNItems_array_negative_nullArray() {
		String[] array = null;
		assertFalse(hasNItems(0, array));
	}

	@Test
	public void hasOneItem_array_positive() {
		String[] array = { "hello" };
		assertTrue(hasOneItem(array));
	}

	@Test
	public void hasOneItem_array_positive_nullElement() {
		String[] array = { null };
		assertTrue(hasOneItem(array));
	}

	@Test
	public void hasOneItem_array_negative_emptyArray() {
		String[] array = {};
		assertFalse(hasOneItem(array));
	}

	@Test
	public void hasOneItem_array_negative_twoElements() {
		String[] array = { "hello", "world" };
		assertFalse(hasOneItem(array));
	}

	@Test
	public void hasOneItem_array_negative_nullArray() {
		String[] array = null;
		assertFalse(hasOneItem(array));
	}

	@Test
	public void toArray_collection_positive() {
		List<Integer> collection = new ArrayList<Integer>();
		collection.add(1);
		collection.add(2);

		Integer[] expected = { 1, 2 };
		Integer[] actual = collectionToArray(collection, Integer.class);

		assertNotNull(actual);
		assertEquals(expected.length, actual.length);
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], actual[i]);
		}
	}

	@Test
	public void toArray_collection_positive_superClass() {
		ClassB anInstance = new ClassB(1, "", 'a');
		ClassB anotherInstance = new ClassB(2, "dfs", 'b');

		Collection<ClassB> collection = new ArrayList<ClassB>();
		collection.add(anInstance);
		collection.add(anotherInstance);

		ClassA[] expected = { anInstance, anotherInstance };
		ClassA[] actual = collectionToArray(collection, ClassA.class);

		assertNotNull(actual);
		assertEquals(expected.length, actual.length);
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], actual[i]);
		}
	}

	private class ClassA {
		@SuppressWarnings("unused")
		int a;
		@SuppressWarnings("unused")
		String b;

		public ClassA(int a, String b) {
			super();
			this.a = a;
			this.b = b;
		}
	}

	private class ClassB extends ClassA {
		@SuppressWarnings("unused")
		char c;

		public ClassB(int a, String b, char c) {
			super(a, b);
			this.c = c;
		}
	}

	@Test
	public void parseInteger_positive() {
		assertNotNull(parseInteger("0"));
		assertNotNull(parseInteger("1"));
		assertNotNull(parseInteger("-1"));
		assertNotNull(parseInteger("100000"));
		assertNotNull(parseInteger("-100000"));
	}

	@Test
	public void parseInteger_negative() {
		assertNull(parseInteger(null));
		assertNull(parseInteger("a"));
		assertNull(parseInteger("%"));
		assertNull(parseInteger("abcdef"));
		assertNull(parseInteger("*#^#$%:"));
		assertNull(parseInteger("^$3%#5^*"));
		assertNull(parseInteger("a57df4s73"));
	}

}