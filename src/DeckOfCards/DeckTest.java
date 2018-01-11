package DeckOfCards;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Test;

public class DeckTest {
	
	@Test
	public void testClassStructure() {
		Deck deck = new Deck();
		Class<?> deckClass = deck.getClass();
		Field[] fields = deckClass.getFields();
		for (Field field : fields) {
			boolean privateField = false;
			try {
				field.get(deck);
			} catch (IllegalAccessException e) {
				privateField = true;
			}
			if (!privateField) {
				fail(field.getName() + " needs to be a private field.");
			}
		}
	}

	@Test
	public void findAceOfSpades() {
		String expected = "Ace of Spades";
		String actual = (new Deck()).cardAt(1);
		assertEquals(expected, actual);
	}

	@Test
	public void findTwoOfSpades() {
		String expected = "2 of Spades";
		String actual = (new Deck()).cardAt(2);
		assertEquals(expected, actual);
	}

	@Test
	public void findFiveOfSpades() {
		String expected = "5 of Spades";
		String actual = (new Deck()).cardAt(5);
		assertEquals(expected, actual);
	}

	@Test
	public void findJackOfSpades() {
		String expected = "Jack of Spades";
		String actual = (new Deck()).cardAt(11);
		assertEquals(expected, actual);
	}

	@Test
	public void findAceOfHearts() {
		String expected = "Ace of Hearts";
		String actual = (new Deck()).cardAt(14);
		assertEquals(expected, actual);
	}

	@Test
	public void findThreeOfHearts() {
		String expected = "3 of Hearts";
		String actual = (new Deck()).cardAt(16);
		assertEquals(expected, actual);
	}

	@Test
	public void findQueenOfHearts() {
		String expected = "Queen of Hearts";
		String actual = (new Deck()).cardAt(25);
		assertEquals(expected, actual);
	}

	@Test
	public void findNineOfClubs() {
		String expected = "9 of Clubs";
		String actual = (new Deck()).cardAt(35);
		assertEquals(expected, actual);
	}

	@Test
	public void findKingOfDiamonds() {
		String expected = "King of Diamonds";
		String actual = (new Deck()).cardAt(52);
		assertEquals(expected, actual);
	}

}