package bunn.common.tools;

import static java.util.stream.Collectors.toList;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class StringTools {

	public static String join(String... items) {
		return StringUtils.join(items, ',');
	}

	public static String toStringNonNullFields(Object ofInterest, ToStringStyle style) {
		ReflectionToStringBuilder builder = new ReflectionToStringBuilder(ofInterest, style) {
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

	public static String toStringNonNullFields(Collection<?> ofInterest, ToStringStyle style) {
		if (ofInterest == null) return "null";
		return ofInterest.stream().map(item -> toStringNonNullFields(item, style)).collect(toList()).toString();
	}

	public static String toStringNonNullFields(Map<?, ?> ofInterest, ToStringStyle style) {
		if (ofInterest == null) return "null";
		return "{\n"
				+ StringUtils.join( //
						ofInterest.entrySet().stream() //
								.map(entry -> toStringNonNullFields(entry, style)) //
								.collect(toList()), "\n")
				+ "\n}";
	}

	/////

	public static String toStringNonBlankFields(Object ofInterest, ToStringStyle style) {
		ReflectionToStringBuilder builder = new ReflectionToStringBuilder(ofInterest, style) {
			protected boolean accept(Field field) {
				try {
					if (!super.accept(field)) return false;
					Object value = field.get(ofInterest);
					if (value == null) return false;
					return StringUtils.isNotBlank(value.toString());
				} catch (IllegalAccessException e) {
					return super.accept(field);
				}
			}
		};
		return builder.toString();
	}

	public static String toStringNonBlankFields(Collection<?> ofInterest, ToStringStyle style) {
		if (ofInterest == null) return "null";
		return StringUtils.join(ofInterest.stream().map(item -> toStringNonBlankFields(item, style)).collect(toList()), "\n");
	}

	public static String toStringNonBlankFields(Map<?, ?> ofInterest, ToStringStyle style) {
		if (ofInterest == null) return "null";
		return "{\n"
				+ StringUtils.join( //
						ofInterest.entrySet().stream() //
								.map(entry -> toStringNonBlankFields(entry, style)) //
								.collect(toList()), "\n")
				+ "\n}";
	}

}
