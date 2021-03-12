package com.wallethub.Assertion;

import org.testng.Assert;

public class homePageAssertions {
    public static final String ExpectedQuote = "Test Insurance Company";

    public static Boolean quoteAssertions(String actualFaceBookQuote) {
        Assert.assertEquals(actualFaceBookQuote, ExpectedQuote);
        return true;
    }
}
