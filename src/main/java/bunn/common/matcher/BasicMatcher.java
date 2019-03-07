package bunn.common.matcher;

import bunn.common.tools.GeneralTools;

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
