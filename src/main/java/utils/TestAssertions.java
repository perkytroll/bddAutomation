package utils;

import org.assertj.core.api.Assertions;

public class TestAssertions {
	public static void verifyAssertEqual(String actual, String expected) throws AssertionError {
        Assertions.assertThat(expected).isEqualTo(actual);
    }
}
