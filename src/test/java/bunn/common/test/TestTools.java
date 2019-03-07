package bunn.common.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.opentest4j.AssertionFailedError;

public class TestTools {

	public static <T> void assertEquivalent(T expected, T actual) {
		assertNullEquivalence(expected, actual);
		if (expected == null) return;
		if (expected.equals(actual)) return;
		throw new AssertionFailedError("\nExpected:\n" + expected + "\ndoes not match\nactual:\n " + actual);
	}

	public static <T> void assertEquivalentCollection(List<T> expected, List<T> actual) {
		assertNullEquivalence(expected, actual);
		if (expected == null) return;
		assertEquals(expected.size(), actual.size());
		assertTrue(actual.containsAll(expected));
	}

	public static <T> List<T> cloneList(List<T> list) {
		List<T> clone = new ArrayList<T>();
		for (T item : list)
			clone.add(item);
		return clone;
	}

	public static <T> void assertEquivalentCollection(T[] expected, T[] actual) {
		assertEquivalentCollection(Arrays.asList(expected), Arrays.asList(actual));
	}

	public static <T> void assertNullEquivalence(T expected, T actual) throws AssertionFailedError {
		if (expected == null && actual != null) throw new AssertionFailedError("\nExpected was null, but \nactual = " + actual);
		if (expected != null && actual == null) throw new AssertionFailedError("\nExpected = " + expected + "\nbut actual was null");
	}

	public static String longString(int fieldLength) {
		return longString(fieldLength, "a");
	}

	public static String longString(int fieldLength, String filler) {
		return StringUtils.leftPad(filler, fieldLength + 1, filler);
	}
}
