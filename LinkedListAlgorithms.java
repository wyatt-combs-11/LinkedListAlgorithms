import java.util.NoSuchElementException;

/**
 * @author 
 * 		Wyatt O. Combs
 * @apiNote
 * 		Project-02
 * 		Linked Algorithms
 * 		Due Date: 9/22/2020 @ 11:59 pm    
 *
 */

// This is a class for a data structure known as the Linked List. It includes constructors, utility methods,
// search methods, retrieval methods, insert methods, removal methods, list manipulation methods, and
// methods to return properties of the Linked List object. There is a directory below with the layout of the
// class and its methods.

/**
 * 
 * @author wyattcombs
 *
 *
 * DIRECTORY																		LINE #
 * ----------------------------------------------------------------------------------------
 * Internal Node Class: 															line 71
 * Properties: 																		line 93
 * 	- Node head, int size
 * Constructors: 																	line 97
 *  - LinkedListAlgorithms(): 														line 101
 *  - LinkedListAlgorithms(String[] data): 											line 114
 *  - LinkedListAlgorithms(LinkedListAlgorithms original): 							line 128
 * Utility Methods:
 *  - String toArray(): 															line 145
 *  - boolean isEmpty(): 															line 161
 *  - String toString(): 															line 174
 *  - int size(): 																	line 195
 *  - boolean equalsLinkedList(LinkedListAlgorithms other): 						line 206
 * Search Methods:
 *  - boolean contains(String data):												line 225
 *  - int find(String data):														line 242
 * Retrieval Methods:
 *  - String getFirst():															line 258
 *  - String getLast():																line 271
 *  - String getAt(int i):															line 288
 * Insert Methods:
 *  - insertFirst(String data):														line 302
 *  - void insertLast(String data):													line 316
 *  - void insertAt(int i, String data):											line 337
 *  - void insertBefore(StringnewData, String existingData):						line 367
 *  - void insertAfter(StringnewData, String existingData):							line 383
 * 	- void clear():																	line 401
 * Removal Methods:
 *  - String removeFirst():															line 418
 *  - String removeLast():															line 440
 *  - String removeAt(int i):														line 466
 *  - boolean removeFirstOccurrenceOf(String data):									line 494
 *  - int removeAllOccurrencesOf(String data):										line 510
 * List Manipulation Methods:
 *  - void reverse():																line 525
 *  - void toUpper():																line 542
 * Methods to Return Properties:
 *  - String getConcatenation():													line 558
 *  - String getAlphabeticallyLast():												line 573
 *  - int indexOfAlphabeticallyLast():												line 592
 *  - boolean anagrams(LinkedListAlgorithms other):									line 605
 * 
 */

public class LinkedListAlgorithms {

	//==================================================================== Internal Node Class
	private class Node {
		String data;
		Node next;
		
		Node(String data) {
			this(data, null);
		}
		
		Node(String data, Node next) {
			this.data = data;
			this.next = next;
		}
		
		
		// You may add helper methods here
		
	}
	//========================================================================================
	
	

	//==================================================================== Properties
	public Node head;
	public int size;

	//==================================================================== Constructors
	/**
	 * Creates the empty list.
	 */
	public LinkedListAlgorithms() {
		size = 0;
		head = null;
	}

	/**
	 * Creates a list containing all the elements of the passed array.
	 * {@code data[0]} will be the first element of the list, {@code data[1]} will
	 * be the second element of the list, and so on.
	 * 
	 * @param data The array of values
	 * @throws NullPointerException - data is null
	 */
	public LinkedListAlgorithms(String[] data) {
		this();
		if(data == null)
			throw new NullPointerException();
		for(int i = 0; i < data.length; i++)
			insertLast(data[i]);
	}

	/**
	 * Constructs a deep copy of the linked list {@code original}
	 * 
	 * @param original The list to be copied
	 * @throws NullPointerException - original is null
	 */
	public LinkedListAlgorithms(LinkedListAlgorithms original) {
		this();
		if(original == null)
			throw new NullPointerException();
		Node tmp = original.head;
		for(int i = 0; i < original.size; i++) {
			insertLast(tmp.data);
			tmp = tmp.next;
		}
	}

	//==================================================================== Methods
	/**
	 * Returns array with all the elements.
	 * 
	 * @return Array containing all elements.
	 */
	public String[] toArray() {
		Node chk = head;
		String[] ret = new String[size];
		for(int i = 0; i < size; i++) {
			ret[i] = chk.data;
			chk = chk.next;
		}
		
		return ret;
	}
	
	/**
	 * Returns if LinkedListAlgorithms is empty.
	 * 
	 * @return boolean (true if empty, otherwise false).
	 */
	private boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Formats the elements in the list using leading and ending brackets (i.e., []), with the values comma separated. 
	 * There will be one space between each of these but none at the beginning nor at the end.
	 * Some examples:
	 * if the list is empty, toString() gives []
	 * if the list has these three elements in this order: "hello", "world", "everyone", then the result should be 
	 *      [hello, world, everyone]
	 */
	@Override
	public String toString() {
		if(isEmpty())
			return "[]";
		String[] elem = toArray();
		StringBuilder ret = new StringBuilder();
		ret.append("[");
		int i = 0;
		while(i < elem.length) {
			ret.append(elem[i++] + ", ");
		}
		ret.delete(ret.length() - 2, ret.length()).append("]");
		
		return ret.toString();
		
	}

	/**
	 * Returns the number of items in the list
	 * 
	 * @return Number of items in the list
	 */
	public int size() {
		return size;
	}

	/**
	 * Determines if two lists contain exactly the same values, in exactly the same
	 * order.
	 * 
	 * @return {@code true} if and only if obj is an list that is equivalent to the
	 *         incoming list.
	 */
	public boolean equalsLinkedList(LinkedListAlgorithms obj) {
		if(!(obj instanceof LinkedListAlgorithms) || size != ((LinkedListAlgorithms)obj).size)
			return false;
		String[] s1 = obj.toArray();
		String[] s2 = toArray();
		
		for(int i = 0; i < s1.length; i++)
			if(!(s1[i].equals(s2[i])))
				return false;
		
		return true;
	}

	/**
	 * Determines if {@code key} is in the linked list.
	 * 
	 * @param key The value to be found
	 * @return true if and only if {@code key} is in the list
	 */
	public boolean contains(String key) {
		String[] s1 = toArray();
		for(int i = 0; i < s1.length; i++)
			if(s1[i].equals(key))
				return true;
		
		return false;
	}

	/**
	 * Determines the index of {@code key}. -1 is returned if the value is not
	 * present in the linked list. If {@code key} is present present more than once,
	 * the first index is returned.
	 * 
	 * @param key The value to be found
	 * @return The index of the {@code key}
	 */
	public int find(String key) {
		String[] s1 = toArray();
		for(int i = 0; i < s1.length; i++)
			if(s1[i].equals(key)) {
				return i;
			}
		
		return -1;
	}

	/**
	 * Returns the value of the first element of the list.
	 * 
	 * @return The first element of the list.
	 * @throws NoSuchElementException the list is empty
	 */
	public String getFirst() {
		if(isEmpty())
			throw new NoSuchElementException();
		
		return head.data;
	}

	/**
	 * Returns the value of the last element of the list.
	 * 
	 * @return The last element of the list.
	 * @throws NoSuchElementException the list is empty
	 */
	public String getLast() {
		if(isEmpty())
			throw new NoSuchElementException();
		Node last = head;
		while(last.next != null)
			last = last.next;
		
		return last.data;
	}

	/**
	 * Returns the value of the {@code ith} element of the list (0 based).
	 * 
	 * @param i The target index
	 * @return The value of the ith element of the list.
	 * @throws IndexOutOfBoundsException {@code i} is illegal
	 */
	public String getAt(int i) {
		if(i < 0 || i >= size)
			throw new IndexOutOfBoundsException();
		String[] s1 = toArray();
		
		return s1[i];
	}

	/**
	 * Adds {@code data} to the beginning of the list. All other values in the list
	 * remain but they are "shifted to the right."
	 * 
	 * @param data The value to add to the list
	 */
	public void insertFirst(String data) {
		Node tmp = null;
		if(!(isEmpty()))
			tmp = new Node(head.data, head.next);
		head = new Node(data, tmp);
		size++;
	}

	/**
	 * Adds {@code data} to the end of the list. All other values in the list remain
	 * in their current positions.
	 * 
	 * @param data The value to add to the list
	 */
	public void insertLast(String data) {
		if(isEmpty())
			insertFirst(data);
		else {
			Node last = head;
			while(last.next != null)
				last = last.next;
			last.next = new Node(data);
			size++;
		}
	}

	/**
	 * Adds data to a specific spot in the list. The values in the list remain
	 * intact but {@code data} is inserted in the list at position {@code i}. When
	 * {@code i=0}, the result is the same as {@code insertFirst}.
	 * 
	 * @param i    The target index
	 * @param data The value to add to the list
	 * @throws IndexOutOfBoundsException {@code i} is illegal
	 */
	public void insertAt(int i, String data) {
		if(i < 0 || i > size)
			throw new IndexOutOfBoundsException();
		if(i == size)
			insertLast(data);
		else if(i == 0) {
			insertFirst(data);
		} else {
			Node tmp = new Node(data);
			Node chk = head;
			for(int j = 1; j < i; j++)
				chk = chk.next;
	
			tmp.next = new Node(chk.next.data, chk.next.next);
			chk.next = new Node(tmp.data, tmp.next);
			size++;
		}
		
	}

	/**
	 * Adds {@code newData} the position immediately preceding {@code existingData}.
	 * If the {@code existingData} appears multiple times, only the first one is
	 * used.
	 * 
	 * @param newData      The value to add to the list
	 * @param existingData The value used to control where insertion is to take
	 *                     place
	 * @throws NoSuchElementException {@code existingData} is not in the list
	 */
	public void insertBefore(String newData, String existingData) {
		int index = find(existingData);
		if(index == -1)
			throw new NoSuchElementException();
		insertAt(index, newData);
	}

	/**
	 * Adds {@code newData} the position immediately after {@code existingData}. If
	 * the {@code existingData} appears multiple times, only the first one is used.
	 * 
	 * @param newData      The value to add to the list
	 * @param existingData The value used to control where insertion is to take
	 *                     place
	 * @throws NoSuchElementException {@code existingData} is not in the list
	 */
	public void insertAfter(String newData, String existingData) {
		int index = find(existingData);
		if(index++ == -1)
			throw new NoSuchElementException();
		
		if(index == size) {
			insertLast(newData);
		}
		else
			insertAt(index, newData);
	}
	
	/**
	 * Removes only element in list when size is 1.
	 * 
	 * @return The value removed from the list
	 * @throws NoSuchElementException if the list is empty.
	 */
	private String clear() {
		if(isEmpty())
			throw new NoSuchElementException();
		String val = head.data;
		head = null;
		size = 0;
		
		return val;
	}

	/**
	 * Removes the first element of the list. The remaining elements are kept in
	 * their existing order.
	 * 
	 * @return The value removed from the list
	 * @throws NoSuchElementException if the list is empty.
	 */
	public String removeFirst() {
		if(isEmpty())
			throw new NoSuchElementException();
		String val = "";
		if(size == 1)
			val = clear();
		else {
			val = head.data;
			head = head.next;
			size--;
		}
		
		return val;
	}

	/**
	 * Removes the last element of the list. The remaining elements are kept in
	 * their existing order.
	 * 
	 * @return The value removed from the list
	 * @throws NoSuchElementException if the list is empty.
	 */
	public String removeLast() {
		if(isEmpty())
			throw new NoSuchElementException();
		String val = "";
		if(size == 1)
			val = clear();
		else {
			Node tmp = head;
			while(tmp.next.next != null)
				tmp = tmp.next;
			val = tmp.next.data;
			tmp.next = null;
			size--;
		}
		
		return val;
	}

	/**
	 * Removes the ith element of the list. The remaining elements are kept in their
	 * existing order.
	 * 
	 * @param i The target index
	 * @return The value removed from the list
	 * @throws IndexOutOfBoundsException i does not represent a legal index
	 */
	public String removeAt(int i) {
		if(i < 0 || i >= size)
			throw new IndexOutOfBoundsException();
		String ret = "";
		Node tmp = null;
		if(i == size - 1)
			 ret = removeLast();
		else if(i == 0) 
			ret = removeFirst();
		else {
			Node chk = head;
			for(int j = 1; j < i; j++)
				chk = chk.next;
	
			chk.next = chk.next.next;
			size--;
		}
		
		return ret;
	}

	/**
	 * Removes the first occurrence of data in the linked list.
	 * 
	 * @param data The value to be removed.
	 * @return {@code true} if and only if {@code data} was removed
	 */
	public boolean removeFirstOccurrenceOf(String data) {
		int index = find(data);
		if(index == -1)
			return false;
		else 
			removeAt(index);
		
		return true;
	}

	/**
	 * Removes the all occurrence of {@code data} in the linked list.
	 * 
	 * @param data The value to be removed.
	 * @return The number of times {@code data} was removed
	 */
	public int removeAllOccurrencesOf(String data) {
		int numOcc = 0;
		int index = find(data);
		while(index != -1) {
			removeAt(index);
			index = find(data);
			numOcc++;
		}
		
		return numOcc;
	}

	/**
	 * Reverses the elements in the incoming linked list.
	 */
	public void reverse() {
        if(head == null || head.next == null) {
        } else {
	        Node prev = null;
	        while(head != null) {
	            Node next = head.next;
	            head.next = prev;
	            prev = head;
	            head = next;
	        }
	        head = prev;
        }
	}

	/**
	 * Puts all the elements in the list to uppercase.
	 */
	public void toUpper() {
		Node chk = head;
		while(chk != null) {
			chk.data = chk.data.toUpperCase();
			chk = chk.next;
		}
	}

	/**
	 * Returns the comma concatenation of all strings, from left to right.
	 * NO additional characters should be added between words
	 *		Example: 	Linked List = ["Hello", "World" ] 
	 *					the output should be: HelloWorld
	 * 
	 * @return Concatenation of all string in the list
	 */
	public String getConcatenation() {
		String[] arr = toArray();
		String ret = "";
		for(int i = 0; i < arr.length; i++)
			ret += arr[i];
		
		return ret;
	}

	/**
	 * Returns the alphabetically last value in the list.
	 * 
	 * @return The alphabetically last value in the list
	 * @throws NoSuchElementException list is empty
	 */
	public String getAlphabeticallyLast() {
		if(isEmpty())
			throw new NoSuchElementException();
		String[] arr = toArray();
		String ret = arr[0];
		for(int i = 1; i < arr.length; i++)
			if(ret.compareToIgnoreCase(arr[i]) < 0)
				ret = arr[i];
		
		return ret;
	}

	/**
	 * Returns the index where the alphabetically last value resides. If this
	 * value appears multiple times, the first occurrence is used.
	 * 
	 * @return Index value of where maximum value resides
	 * @throws NoSuchElementException list is empty
	 */
	public int indexOfAlphabeticallyLast() {
		if(isEmpty())
			throw new NoSuchElementException();
		
		return find(getAlphabeticallyLast());
	}

	/**
	 * Determines if the two list contain elements that have exactly the same
	 * value, with the same list sizes, but with the elements perhaps in different order.
	 * 
	 * @returns true only if the two lists are permutations of one another.
	 */
	public boolean anagrams(LinkedListAlgorithms other) {
		if(!(other instanceof LinkedListAlgorithms) || size != other.size)
			return false;
		LinkedListAlgorithms llaCopy = new LinkedListAlgorithms(other);
		for(String s1 : toArray())
			for(String s2 : llaCopy.toArray())
				if(s1.equals(s2)) {
					llaCopy.removeFirstOccurrenceOf(s2);
					break;
				}
		
		return llaCopy.isEmpty();
	}

	//==================================================================== Internal Testing
	public static void main(String[] args) {
		String[] items = { "hello", "world" };
		LinkedListAlgorithms LL1 = new LinkedListAlgorithms();
		LinkedListAlgorithms LL2 = new LinkedListAlgorithms(items);
		LinkedListAlgorithms LL3 = new LinkedListAlgorithms(LL1);
	}
}
