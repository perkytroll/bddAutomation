package utils;

import org.assertj.core.api.Assertions;

/**
 * <p>
 * Wrapper class for Assertions to be used throughout the framework
 * </p>
 * @author Singh
 *
 */
public class TestAssertions {
	
	/**
	 * <p>
	 * Asserts whether the two provided String values are equal
	 * </p>
	 * @param actual
	 * @param expected
	 * @throws AssertionError
	 */
	public static void verifyAssertEqual(String actual, String expected) throws AssertionError {
        Assertions.assertThat(expected).isEqualTo(actual);
    }
}
