package com.thednaisgood.common.utility;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class GeneralTools {

	public static final String SPECIAL_CHARS = "!@,.\\/|?:;#$%^&*()[]{}<>`~-+\"'";

	public static <T> boolean hasItems(Collection<T> collection) {
		if (collection == null) return false;
		return !collection.isEmpty();
	}

	public static <T> boolean hasNoItems(Collection<T> collection) {
		return !hasItems(collection);
	}

	public static <T> boolean hasNItems(int n, Collection<T> collection) {
		if (collection == null) return false;
		return collection.size() == n;
	}

	public static <T> boolean hasOneItem(Collection<T> collection) {
		return hasNItems(1, collection);
	}

	public static <T> boolean hasItems(T[] array) {
		if (array == null) return false;
		return array.length != 0;
	}

	public static <T> boolean hasNoItems(T[] array) {
		return !hasItems(array);
	}

	public static <T> boolean hasNItems(int n, T[] array) {
		if (array == null) return false;
		return array.length == n;
	}

	public static <T> boolean hasOneItem(T[] array) {
		return hasNItems(1, array);
	}

	public static String formatPhoneNumber(String phoneNumber) {
		if (phoneNumber.length() == 10) return "(" + phoneNumber.substring(0, 3) + ") " + phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6);
		if (phoneNumber.length() == 7) return phoneNumber.substring(0, 3) + "-" + phoneNumber.substring(3);
		return phoneNumber;
	}

	public static <T> boolean isEqual(T target, T candidate) {
		if (target == null) return candidate == null;
		if (candidate == null) return false;
		return target.equals(candidate);
	}

	public static <T> boolean isNotEqual(T target, T candidate) {
		return !isEqual(target, candidate);
	}

	public static boolean isEqual(String target, String candidate) {
		return StringUtils.equals(target, candidate);
	}

	public static boolean isNotEqual(String target, String candidate) {
		return !isEqual(target, candidate);
	}

	public static <T> boolean isEqual(Collection<? extends T> target, Collection<? extends T> candidate) {
		if (target == null) return candidate == null;
		if (candidate == null) return false;

		if (target.isEmpty()) return candidate.isEmpty();
		if (candidate.isEmpty()) return false;

		return candidate.containsAll(target);
	}

	public static <T> boolean isNotEqual(Collection<? extends T> target, Collection<? extends T> candidate) {
		return !isEqual(target, candidate);
	}

	@SuppressWarnings("unchecked")
	public static <T> boolean isEqual(T[] target, T... candidate) {
		if (target == null) return candidate == null;
		if (candidate == null) return false;

		return isEqual(Arrays.asList(target), Arrays.asList(candidate));
	}

	@SuppressWarnings("unchecked")
	public static <T> boolean isNotEqual(T[] target, T... candidate) {
		return !isEqual(target, candidate);
	}

	public static <C, T extends C> C[] collectionToArray(Collection<T> collection, Class<C> clazz) throws ClassCastException {
		if (collection == null) return null;
		@SuppressWarnings("unchecked")
		C[] a = (C[]) java.lang.reflect.Array.newInstance(clazz, collection.size());
		return collection.toArray(a);
	}

	@SuppressWarnings("unchecked")
	public static <T> T[] arrayOf(T... items) {
		return items;
	}

	public static Integer parseInteger(String text) {
		try {
			return Integer.parseInt(text);
		} catch (Exception e) {
			return null;
		}
	}

	public static Double parseDouble(String text) {
		try {
			return Double.parseDouble(text);
		} catch (Exception e) {
			return null;
		}
	}

	public static String removeSpecialCharacters(String string) {
		StringBuilder sb = new StringBuilder();
		for (char c : string.toCharArray()) {
			if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) sb.append(c);
		}
		return sb.toString();
	}

	public static String buildStackTrace(Exception e) {
		String trace = " Error trace\n" + e.toString() + "\n";
		for (StackTraceElement element : e.getStackTrace()) {
			trace += "\tat " + element.toString() + "\n";
		}
		return trace;
	}

	public static String toStringNonNullFields(Object ofInterest, ToStringStyle style) {
		ReflectionToStringBuilder builder = new ReflectionToStringBuilder(ofInterest, style) {
			@Override
			protected boolean accept(Field field) {
				try {
					return super.accept(field) && field.get(ofInterest) != null;
				} catch (IllegalAccessException e) {
					return super.accept(field);
				}
			}
		};
		return builder.toString();
	}
}