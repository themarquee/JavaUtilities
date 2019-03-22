package bunn.common.matcher;

import java.util.Collection;

import bunn.common.Extractor;
import bunn.common.tools.CollectionTools;

public class ExtractorMatcher<T, O> implements Matcher<O> {
	private Extractor<T, O> candidateExtractor;
	Matcher<T> matcher;

	public ExtractorMatcher(T target, Extractor<T, O> candidateExtractor) {
		this(candidateExtractor, new BasicMatcher<T>(target));
	}

	public ExtractorMatcher(Extractor<T, O> extractor, O container) {
		this(extractor, new BasicMatcher<T>(extractor.extract(container)));
	}

	public ExtractorMatcher(Extractor<T, O> candidateExtractor, Matcher<T> matcher) {
		if (candidateExtractor == null) throw new NullPointerException("Extractor cannot be null.");
		if (matcher == null) throw new NullPointerException("Matcher cannot be null.");
		this.candidateExtractor = candidateExtractor;
		this.matcher = matcher;
	}

	@Override
	public boolean matches(O candidate) {
		return matcher.matches(candidateExtractor.extract(candidate));
	}

	public static <T, O> O findMatch(T target, Extractor<T, O> candidateExtractor, Collection<O> candidates) {
		return CollectionTools.findMatch(new ExtractorMatcher<T, O>(target, candidateExtractor), candidates);
	}

	@SuppressWarnings("unchecked")
	public static <T, O> O findMatch(T target, Extractor<T, O> candidateExtractor, O... candidates) {
		return CollectionTools.findMatch(new ExtractorMatcher<T, O>(target, candidateExtractor), candidates);
	}

	public static <T, O> Collection<O> findAllMatches(T target, Extractor<T, O> candidateExtractor, Collection<O> candidates) {
		return CollectionTools.findAllMatches(new ExtractorMatcher<T, O>(target, candidateExtractor), candidates);
	}

	@SuppressWarnings("unchecked")
	public static <T, O> Collection<O> findAllMatches(T target, Extractor<T, O> candidateExtractor, O... candidates) {
		return CollectionTools.findAllMatches(new ExtractorMatcher<T, O>(target, candidateExtractor), candidates);
	}

	public static <T, O> O findMatch(Extractor<T, O> candidateExtractor, Matcher<T> matcher, Collection<O> candidates) {
		return CollectionTools.findMatch(new ExtractorMatcher<T, O>(candidateExtractor, matcher), candidates);
	}

	@SuppressWarnings("unchecked")
	public static <T, O> O findMatch(Extractor<T, O> candidateExtractor, Matcher<T> matcher, O... candidates) {
		return CollectionTools.findMatch(new ExtractorMatcher<T, O>(candidateExtractor, matcher), candidates);
	}

	public static <T, O> Collection<O> findAllMatches(Extractor<T, O> candidateExtractor, Matcher<T> matcher, Collection<O> candidates) {
		return CollectionTools.findAllMatches(new ExtractorMatcher<T, O>(candidateExtractor, matcher), candidates);
	}

	@SuppressWarnings("unchecked")
	public static <T, O> Collection<O> findAllMatches(Extractor<T, O> candidateExtractor, Matcher<T> matcher, O... candidates) {
		return CollectionTools.findAllMatches(new ExtractorMatcher<T, O>(candidateExtractor, matcher), candidates);
	}
}
