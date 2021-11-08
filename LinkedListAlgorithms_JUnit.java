import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class LinkedListAlgorithms_JUnit {

	LinkedListAlgorithms[] llas;
	String[] data;
	static final int LLA_CAPACITY = 15;
	
	public LinkedListAlgorithms_JUnit() {
		llas = new LinkedListAlgorithms[LLA_CAPACITY];
		
		data = new String[] {"first", "second", "third"};
		llas[0] = new LinkedListAlgorithms(data);
		
		data = new String[] {"fourth", "fifth", "sixth"};
		llas[1] = new LinkedListAlgorithms(data);
		
		data = new String[] {};
		llas[2] = new LinkedListAlgorithms(data);
		
		data = new String[] {"first", "first", "first"};
		llas[3] = new LinkedListAlgorithms(data);
		
		data = new String[] {"first"};
		llas[4] = new LinkedListAlgorithms(data);
		
		data = new String[] {"a", "b", "c", "d", "e", "f"};
		llas[5] = new LinkedListAlgorithms(data);
		
		data = new String[] {"f", "e", "d", "c", "b", "a"};
		llas[6] = new LinkedListAlgorithms(data);
		
		data = new String[] {"a", "f", "b", "e", "c", "d"};
		llas[7] = new LinkedListAlgorithms(data);
		
		data = new String[] {"first", "second", "first"};
		llas[8] = new LinkedListAlgorithms(data);
		
		data = new String[] {"first", "second", "second"};
		llas[9] = new LinkedListAlgorithms(data);
		
	}
	
	@Test
	public void constructorAndEqualsLinkedListTests() {
		assertTrue(llas[2].equalsLinkedList(new LinkedListAlgorithms()));
		assertTrue(llas[0].equalsLinkedList(llas[0]));
		assertTrue(llas[1].equalsLinkedList(llas[1]));
		assertTrue(llas[0].equalsLinkedList(new LinkedListAlgorithms(new String[] {"first", "second", "third"})));
		assertTrue(llas[2].equalsLinkedList(new LinkedListAlgorithms(new String[] {})));
	}
	
	@Test
	public void toArrayTest() {
		assertArrayEquals(llas[0].toArray(), llas[0].toArray());
		assertArrayEquals(llas[1].toArray(), llas[1].toArray());
		assertArrayEquals(llas[2].toArray(), llas[2].toArray());
		assertArrayEquals(llas[3].toArray(), llas[3].toArray());
	}
	
	@Test
	public void toStringTest() {
		assertEquals(llas[0].toString(), "[first, second, third]");
		assertEquals(llas[2].toString(), "[]");
		assertEquals(llas[4].toString(), "[first]");
		assertEquals(llas[6].toString(), "[f, e, d, c, b, a]");
		
		assertNotEquals(llas[0].toString(), llas[2].toString());
		assertNotEquals(llas[0].toString(), llas[1].toString());
		
	}
	
	@Test
	public void sizeTest() {
		assertEquals(llas[0].size(), 3);	
		assertEquals(llas[2].size(), 0);
	}
	
	@Test
	public void containsTest() {
		assertTrue(llas[0].contains("first"));
		assertTrue(llas[1].contains("fifth"));
		assertTrue(llas[3].contains("first"));
		assertTrue(llas[4].contains("first"));
		assertTrue(llas[5].contains("a"));
		assertTrue(llas[6].contains("a"));
		
		assertFalse(llas[2].contains("first"));
		assertFalse(llas[1].contains("first"));
		assertFalse(llas[3].contains("f"));
		assertFalse(llas[4].contains("a"));
		assertFalse(llas[5].contains("first"));
	}
	
	@Test
	public void findTest() {
		assertEquals(llas[0].find("first"), 0);
		assertEquals(llas[0].find("second"), 1);
		assertEquals(llas[0].find("third"), 2);
		assertEquals(llas[0].find("f"), -1);
		assertEquals(llas[3].find("first"), 0);
		assertEquals(llas[1].find("first"), -1);
		assertEquals(llas[2].find("first"), -1);
	}
	
	@Test
	public void getFirstTest() {
		assertEquals(llas[0].getFirst(), "first");
		assertEquals(llas[1].getFirst(), "fourth");
		assertEquals(llas[5].getFirst(), "a");
		assertEquals(llas[6].getFirst(), "f");
		
		// Check exceptions thrown
		assertThrows(Exception.class, () -> {	llas[2].getFirst();	});
	}
	
	@Test
	public void getLastTest() {
		assertEquals(llas[0].getLast(), "third");
		assertEquals(llas[1].getLast(), "sixth");
		assertEquals(llas[3].getLast(), "first");
		assertEquals(llas[5].getLast(), "f");
		assertEquals(llas[6].getLast(), "a");
		
		// Check exceptions thrown
		assertThrows(Exception.class, () -> {	llas[2].getLast();	});
	}
	
	@Test
	public void insertFirstTest() {
		llas[0].insertFirst("zero");
		assertTrue(llas[0].equalsLinkedList(new LinkedListAlgorithms(new String[] {"zero","first", "second", "third"})));
		llas[1].insertFirst("third");
		assertTrue(llas[1].equalsLinkedList(new LinkedListAlgorithms(new String[] {"third", "fourth", "fifth", "sixth"})));
		llas[2].insertFirst("first");
		assertTrue(llas[2].equalsLinkedList(new LinkedListAlgorithms(new String[] {"first"})));
	}
	
	@Test
	public void insertLastTest() {
		llas[0].insertLast("zero");
		assertTrue(llas[0].equalsLinkedList(new LinkedListAlgorithms(new String[] {"first", "second", "third","zero"})));
		llas[1].insertLast("third");
		assertTrue(llas[1].equalsLinkedList(new LinkedListAlgorithms(new String[] {"fourth", "fifth", "sixth", "third"})));
		llas[2].insertLast("first");
		assertTrue(llas[2].equalsLinkedList(new LinkedListAlgorithms(new String[] {"first"})));
	}
	
	@Test
	public void insertAtTest() {
		llas[0].insertAt(0, "zero");
		assertTrue(llas[0].equalsLinkedList(new LinkedListAlgorithms(new String[] {"zero","first", "second", "third"})));
		llas[1].insertAt(3, "zero");
		assertTrue(llas[1].equalsLinkedList(new LinkedListAlgorithms(new String[] {"fourth", "fifth", "sixth", "zero"})));
		llas[2].insertAt(0, "zero");
		assertTrue(llas[2].equalsLinkedList(new LinkedListAlgorithms(new String[] {"zero"})));
		
		// Check exceptions thrown
		assertThrows(Exception.class, () -> {	llas[2].insertAt(2, "zero");	});
		assertThrows(Exception.class, () -> {	llas[2].insertAt(-1, "zero");	});
	}
	
	@Test
	public void insertBeforeTest() {
		llas[0].insertBefore("zero", "first");
		assertTrue(llas[0].equalsLinkedList(new LinkedListAlgorithms(new String[] {"zero","first", "second", "third"})));
		llas[1].insertBefore("zero", "sixth");
		assertTrue(llas[1].equalsLinkedList(new LinkedListAlgorithms(new String[] {"fourth", "fifth", "zero", "sixth"})));
		
		// Check exceptions thrown
		assertThrows(Exception.class, () -> {	llas[2].insertBefore("zero", "first");	});
		assertThrows(Exception.class, () -> {	llas[0].insertBefore("zero", "");	});
	}
	
	@Test
	public void insertAfterTest() {
		llas[0].insertAfter("zero", "first");
		assertTrue(llas[0].equalsLinkedList(new LinkedListAlgorithms(new String[] {"first", "zero", "second", "third"})));
		llas[1].insertAfter("zero", "sixth");
		assertTrue(llas[1].equalsLinkedList(new LinkedListAlgorithms(new String[] {"fourth", "fifth", "sixth", "zero"})));
		
		// Check exceptions thrown
		assertThrows(Exception.class, () -> {	llas[2].insertBefore("zero", "first");	});
		assertThrows(Exception.class, () -> {	llas[0].insertBefore("zero", "");	});
	}
	
	@Test
	public void removeFirstTest() {
		llas[0].removeFirst();
		assertTrue(llas[0].equalsLinkedList(new LinkedListAlgorithms(new String[] {"second", "third"})));
		llas[1].removeFirst();
		assertTrue(llas[1].equalsLinkedList(new LinkedListAlgorithms(new String[] {"fifth", "sixth"})));
		llas[4].removeFirst();
		assertTrue(llas[4].equalsLinkedList(new LinkedListAlgorithms(new String[] {})));
		
		// Check exceptions thrown
		assertThrows(Exception.class, () -> {	llas[2].removeFirst();	});
		assertThrows(Exception.class, () -> {	llas[4].removeFirst();	});
	}
	
	@Test
	public void removeLastTest() {
		llas[0].removeLast();
		assertTrue(llas[0].equalsLinkedList(new LinkedListAlgorithms(new String[] {"first", "second"})));
		llas[0].removeLast();
		assertTrue(llas[0].equalsLinkedList(new LinkedListAlgorithms(new String[] {"first"})));
		llas[0].removeLast();
		assertTrue(llas[0].equalsLinkedList(new LinkedListAlgorithms(new String[] {})));
		llas[1].removeLast();
		assertTrue(llas[1].equalsLinkedList(new LinkedListAlgorithms(new String[] {"fourth", "fifth"})));
		llas[4].removeLast();
		assertTrue(llas[4].equalsLinkedList(new LinkedListAlgorithms(new String[] {})));
		
		// Check exceptions thrown
		assertThrows(Exception.class, () -> {	llas[0].removeLast();	});
		assertThrows(Exception.class, () -> {	llas[2].removeLast();	});
		assertThrows(Exception.class, () -> {	llas[4].removeLast();	});
	}
	
	@Test
	public void removeAtTest() {
		llas[0].removeAt(0);
		assertTrue(llas[0].equalsLinkedList(new LinkedListAlgorithms(new String[] {"second", "third"})));
		llas[0].removeAt(1);
		assertTrue(llas[0].equalsLinkedList(new LinkedListAlgorithms(new String[] {"second"})));
		llas[1].removeAt(1);
		assertTrue(llas[1].equalsLinkedList(new LinkedListAlgorithms(new String[] {"fourth", "sixth"})));
		llas[5].removeAt(1);
		llas[5].removeAt(2);
		llas[5].removeAt(3);
		assertTrue(llas[5].equalsLinkedList(new LinkedListAlgorithms(new String[] {"a", "c", "e"})));
		
		// Check exceptions thrown
		assertThrows(Exception.class, () -> {	llas[4].removeAt(1);	});
		assertThrows(Exception.class, () -> {	llas[2].removeAt(0);	});
		assertThrows(Exception.class, () -> {	llas[4].removeAt(-1);	});
	}
	
	@Test
	public void removeFirstOccurenceOfTest() {
		llas[0].removeFirstOccurrenceOf("second");
		assertTrue(llas[0].equalsLinkedList(new LinkedListAlgorithms(new String[] {"first", "third"})));
		llas[3].removeFirstOccurrenceOf("first");
		assertTrue(llas[3].equalsLinkedList(new LinkedListAlgorithms(new String[] {"first", "first"})));
		llas[8].removeFirstOccurrenceOf("first");
		assertTrue(llas[8].equalsLinkedList(new LinkedListAlgorithms(new String[] { "second", "first"})));
		
		// Check if words are not in list
		assertFalse(llas[4].removeFirstOccurrenceOf(""));
		assertFalse(llas[4].removeFirstOccurrenceOf("second"));
		assertFalse(llas[2].removeFirstOccurrenceOf("first"));
	}
	
	@Test
	public void removeAllOccurrencesOfTest() {
		llas[0].removeAllOccurrencesOf("second");
		assertTrue(llas[0].equalsLinkedList(new LinkedListAlgorithms(new String[] {"first", "third"})));
		llas[0].removeAllOccurrencesOf("");
		assertTrue(llas[0].equalsLinkedList(new LinkedListAlgorithms(new String[] {"first", "third"})));
		LinkedListAlgorithms llaCopy = new LinkedListAlgorithms(llas[3]);
		llas[3].removeAllOccurrencesOf("first");
		assertTrue(llas[3].equalsLinkedList(new LinkedListAlgorithms(new String[] {})));
		
		// Check number of occurrences
		assertEquals(llaCopy.removeAllOccurrencesOf("first"), 3);
		assertEquals(llas[4].removeAllOccurrencesOf(""), 0);
		assertEquals(llas[8].removeAllOccurrencesOf("first"), 2);
	}
	
	@Test
	public void reverseTest() {
		llas[0].reverse();
		assertTrue(llas[0].equalsLinkedList(new LinkedListAlgorithms(new String[] {"third", "second", "first"})));
		llas[5].reverse();
		assertTrue(llas[5].equalsLinkedList(llas[6]));
		llas[2].reverse();
		assertTrue(llas[2].equalsLinkedList(llas[2]));
		llas[1].reverse();
		assertTrue(llas[1].equalsLinkedList(new LinkedListAlgorithms(new String[] {"sixth", "fifth", "fourth"})));
		
		// Check for false
		assertFalse(llas[0].equalsLinkedList(llas[1]));
		LinkedListAlgorithms llaCopy = new LinkedListAlgorithms(llas[0]);
		llaCopy.reverse();
		assertFalse(llas[0].equalsLinkedList(llaCopy));
	}
	
	@Test
	public void toUpperTest() {
		llas[0].toUpper();
		assertTrue(llas[0].equalsLinkedList(new LinkedListAlgorithms(new String[] {"FIRST", "SECOND", "THIRD"})));
		llas[1].toUpper();
		assertTrue(llas[1].equalsLinkedList(new LinkedListAlgorithms(new String[] {"FOURTH", "FIFTH", "SIXTH"})));
		llas[2].toUpper();
		assertTrue(llas[2].equalsLinkedList(new LinkedListAlgorithms(new String[] {})));
		llas[5].toUpper();
		assertTrue(llas[5].equalsLinkedList(new LinkedListAlgorithms(new String[] {"A", "B", "C", "D", "E", "F"})));
		
		// Check for false
		LinkedListAlgorithms llaCopy = new LinkedListAlgorithms(llas[6]);
		llaCopy.toUpper();
		assertFalse(llas[6].equalsLinkedList(llaCopy));
		assertFalse(llas[0].equalsLinkedList(llas[1]));
	}
	
	@Test
	public void getConcatenationTest() {
		assertEquals(llas[0].getConcatenation(), "firstsecondthird");
		assertEquals(llas[1].getConcatenation(), "fourthfifthsixth");
		assertEquals(llas[2].getConcatenation(), "");
		assertEquals(llas[3].getConcatenation(), "firstfirstfirst");
		assertEquals(llas[4].getConcatenation(), "first");
		assertEquals(llas[5].getConcatenation(), "abcdef");
	}
	
	@Test
	public void getAlphabeticallyLastTest() {
		assertEquals(llas[0].getAlphabeticallyLast(), "third");
		assertEquals(llas[1].getAlphabeticallyLast(), "sixth");
		assertEquals(llas[3].getAlphabeticallyLast(), "first");
		assertEquals(llas[4].getAlphabeticallyLast(), "first");
		assertEquals(llas[5].getAlphabeticallyLast(), "f");
		assertEquals(llas[6].getAlphabeticallyLast(), "f");
		assertNotEquals(llas[0].getAlphabeticallyLast(), "first");
		assertNotEquals(llas[1].getAlphabeticallyLast(), "first");
		
		// Check exceptions thrown
		assertThrows(Exception.class, () -> {	llas[2].getAlphabeticallyLast();	});
	}
	
	@Test
	public void indexOfAlphabeticallyLastTest() {
		assertEquals(llas[0].indexOfAlphabeticallyLast(), 2);
		assertEquals(llas[1].indexOfAlphabeticallyLast(), 2);
		assertEquals(llas[3].indexOfAlphabeticallyLast(), 0);
		assertEquals(llas[4].indexOfAlphabeticallyLast(), 0);
		assertEquals(llas[5].indexOfAlphabeticallyLast(), 5);
		assertEquals(llas[6].indexOfAlphabeticallyLast(), 0);
		
		// Check exceptions thrown
		assertThrows(Exception.class, () -> {	llas[2].indexOfAlphabeticallyLast();	});
	}
	
	@Test
	public void anagramsTest() {
		assertTrue(llas[5].anagrams(llas[6]));
		assertFalse(llas[5].equalsLinkedList(llas[6]));
		assertTrue(llas[6].anagrams(llas[7]));
		assertFalse(llas[6].equalsLinkedList(llas[7]));
		assertTrue(llas[7].anagrams(llas[5]));
		assertFalse(llas[7].equalsLinkedList(llas[5]));
		assertTrue(llas[2].anagrams(llas[2]));
		
		// Linked List Algorithm objects that should not be anagrams
		assertFalse(llas[8].anagrams(llas[9]));
		assertFalse(llas[3].anagrams(llas[4]));
		assertFalse(llas[0].anagrams(llas[2]));
	}

}
