import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


import org.junit.Test;



public class CardTest {

	@Test
	public void testRank() {
		// This test evaluates whether the
		// getRank function has been implemented correctly

		Card c = new Card("Queen", "Diamonds");
		int actual = c.getRankValue();
		int expected = 12;

		assertEquals(expected, actual);

	}

	@Test
	public void testRankString() {
		// This test evaluates whether the
		// getRankString function has been implemented correctly
		Card c = new Card("Queen", "Diamonds");
		String actual = c.getRankString();
		String expected = "Queen";


		assertEquals(expected, actual);

	}

	@Test
	public void testSuit() {
		// create a card object with appropriate parameters
		// Now, test whetehr the getSuit function
		// is working as expected
		Card c = new Card("Ace", "Hearts");
		String actual = c.getSuit();
		String expected = "Hearts";
		assertEquals(expected, actual);
	}

	@Test
	public void testCompareNegative() {
		// remove the following line when you complete
		// implementing the test
		// create two Card objects with appropriate parameters
		// now test the two objects by using the compareTo function
		// compare the two objects in a way so that the
		// expected value is negative

		Card lower = new Card("10", "Diamonds");
		Card higher = new Card("Queen", "Diamonds");
		int result = lower.compareTo(higher);
		if (result >= 0)
		{
			fail("Expected a negative value but got " + result);
		}
	}

	@Test
	public void testComparePositive() {
		// remove the following line when you complete
		// implementing the test
		// create two Card objects with appropriate parameters
		// now test the two objects by using the compareTo function
		// compare the two objects in a way so that the
		// expected value is positive

		Card lower = new Card("10", "Diamonds");
		Card higher = new Card("Queen", "Diamonds");
		int result = higher.compareTo(lower);
		if (result <= 0)
		{
			fail("Expected a positive value but got " + result);
		}
	}

	@Test
	public void testPrintObjectName() {
		// remove the following line when you complete
		// implementing the test
		// create an object of the Card class with appropriate parameters
		// test the toString function of the class

		Card c = new Card("King", "Spades");
		String actual = c.toString();
		String expected = "13S";
		assertEquals(expected, actual);
	}

	@Test
	public void testPrintObjectInvalidCard() {
		// remove the following line when you complete
		// implementing the test
		// create an object of the Card class with invalid parameters
		// test the toString function of the class.
		// Test to make sure that the toString function
		// returns "invalid card"

		Card invalid = new Card("11", "Tokens");
		String actual = invalid.toString();
		String expected = "invalid card";
		assertEquals(expected, actual);
	}


	@Test
	public void testJoker() {
		// remove the following line when you complete
		// implementing the test
		// see the sample input/output section of the assignment description
		// in the attached assignment description
		// create a joker card and test the
		// getSuit, getRankValue, getRankString functions
		// in this test, use assertEquals three times

		Card joker = new Card("Joker", "Joker");
		assertEquals("Joker", joker.getSuit());
		assertEquals(15, joker.getRankValue());
		assertEquals("Joker", joker.getRankString());
	}

	@Test
	public void testCompareJoker() {
		// remove the following line when you complete
		// implementing the test
		// see the sample input/output section of the assignment description
		// create a joker card and test the
		// compareTo function by creating another valid card object
		// the joker card's rank value would always be higher compared to the other card object
		// therefore, first, compare the rank value of the joker card with another card
		// second, use the compareTo method to compare the joker card with another card
		// in this test, use assertEquals two times

		Card joker = new Card("Joker", "Joker");
		Card aceOfSpades = new Card("Ace", "Spades");

		int rankComparison = Integer.compare(joker.getRankValue(), aceOfSpades.getRankValue());
		if (rankComparison <= 0)
		{
			fail("Expected Joker to have a higher rank value than Ace of Spades.");
		}

		int comparisonResult = joker.compareTo(aceOfSpades);
		if(comparisonResult <= 0)
		{
			fail("Expected comparing Joker to any card to result in a positive value but got " + comparisonResult);
}
	}

}