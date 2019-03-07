package bunn.common;

public abstract interface Converter<S, T> {
	public abstract T convert(S source);
}