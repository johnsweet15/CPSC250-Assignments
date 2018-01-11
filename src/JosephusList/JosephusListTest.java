package JosephusList;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class JosephusListTest {

	private static final String[] dragon = { "Antipodean Opaleye", "Catalonian Fireball", "Chinese Fireball",
			"Common Welsh Green", "Hebridean Black", "Hungarian Horntail", "Norwegian Ridgeback", "Peruvian Vipertooth",
			"Portuguese Long-Snout", "Romanian Longhorn", "Swedish Short-Snout", "Ukrainian Ironbelly" };

	@Test
	public void testReflection() {
		Class<?> cClass = JosephusList.class;
		Field[] cFields = cClass.getDeclaredFields();

		for (Field f : cFields) {
			if (!f.isSynthetic()) {
				assertTrue("Field \"" + f.getName() + "\" should be public", Modifier.isPublic(f.getModifiers()));
				assertFalse("Field \"" + f.getName() + "\" can't be static", Modifier.isStatic(f.getModifiers()));
			}
		}
	}

	@Test
	public void testConstructor() {
		JosephusList<String> stringList = new JosephusList<String>();
		assertTrue("first should be null", stringList.first == null);
		assertTrue("last should be null", stringList.last == null);
		assertTrue("size should be 0", stringList.size == 0);

		JosephusList<Exception> exList = new JosephusList<Exception>();
		assertTrue("first should be null", exList.first == null);
		assertTrue("last should be null", exList.last == null);
		assertTrue("size should be 0", exList.size == 0);
	}

	@Test
	public void testAddOne() {
		JosephusList<String> list = new JosephusList<String>();

		try {
			list.add(dragon[0]);

			assertEquals("first should contain " + dragon[0], dragon[0], list.first.value);
			assertTrue("first.next should be null", list.first.next == null);
			assertEquals("last should contain " + dragon[0], dragon[0], list.last.value);
			assertTrue("last.next should be null", list.last.next == null);
			assertTrue("size should be 1", list.size == 1);
		} catch (Exception e) {
			fail("No exception should be thrown, but was: \n" + e);

		}

	}

	@Test
	public void testAddTwo() {
		JosephusList<String> list = new JosephusList<String>();

		try {
			list.add(dragon[0]);
			list.add(dragon[1]);

			assertEquals("first should contain " + dragon[0], dragon[0], list.first.value);
			assertEquals("first.next should be last", dragon[1], list.first.next.value);
			assertEquals("last should contain " + dragon[1], dragon[1], list.last.value);
			assertEquals("last.next should be first", dragon[0], list.last.next.value);
			assertTrue("size should be 2", list.size == 2);
		} catch (Exception e) {
			fail("No exception should be thrown, but was: \n" + e);

		}

	}

	@Test
	public void testAddMany() {
		JosephusList<String> list = new JosephusList<String>();

		try {
			list.add(dragon[0]);
			list.add(dragon[1]);
			list.add(dragon[2]);
			list.add(dragon[3]);
			list.add(dragon[4]);

			assertEquals("first should contain " + dragon[0], dragon[0], list.first.value);
			assertEquals("last should contain " + dragon[4], dragon[4], list.last.value);
			assertEquals("last.next should be first", dragon[0], list.last.next.value);

			int i;
			Node<String> current;
			for (i = 1, current = list.first; i < 5; i++, current = current.next) {
				assertEquals("At node " + i + " next node should contain " + dragon[i], dragon[i], current.next.value);
			}

			assertTrue("size should be 5", list.size == 5);
		} catch (Exception e) {
			fail("No exception should be thrown, but was: \n" + e);

		}

	}

	@Test
	public void testRemoveEmptyList() {
		JosephusList<String> list = new JosephusList<String>();

		try {
			String result = list.remove();

			assertTrue("empty list should remove null", result == null);
			assertTrue("first should be null", list.first == null);
			assertTrue("last should be null", list.last == null);
			assertTrue("size should be 0", list.size == 0);
		} catch (Exception e) {
			fail("No exception should be thrown, but was: \n" + e);

		}

	}

	@Test
	public void testRemoveFromListOfOne() {
		JosephusList<String> list = new JosephusList<String>();

		try {
			list.add(dragon[11]);
			String result = list.remove();

			assertEquals("list should remove " + dragon[11], dragon[11], result);
			assertTrue("first should be null", list.first == null);
			assertTrue("last should be null", list.last == null);
			assertTrue("size should be 0", list.size == 0);
		} catch (Exception e) {
			fail("No exception should be thrown, but was: \n" + e);

		}
	}

	@Test
	public void testRemoveFromListOfTwo() {
		JosephusList<String> list = new JosephusList<String>();

		try {
			list.add(dragon[10]);
			list.add(dragon[9]);
			String result = list.remove();

			assertEquals("list should remove " + dragon[10], dragon[10], result);
			assertEquals("first should contain " + dragon[9], dragon[9], list.first.value);
			assertTrue("first.next should be null", list.first.next == null);
			assertEquals("last should contain " + dragon[9], dragon[9], list.last.value);
			assertTrue("last.next should be null", list.last.next == null);
			assertTrue("size should be 1", list.size == 1);
		} catch (Exception e) {
			fail("No exception should be thrown, but was: \n" + e);

		}

	}

	@Test
	public void testRemoveFromListOfMany() {
		JosephusList<String> list = new JosephusList<String>();

		try {
			list.add(dragon[5]);
			list.add(dragon[0]);
			list.add(dragon[1]);
			list.add(dragon[2]);
			list.add(dragon[3]);
			list.add(dragon[4]);
			String result = list.remove();

			assertEquals("list should remove " + dragon[5], dragon[5], result);
			assertEquals("first should contain " + dragon[0], dragon[0], list.first.value);
			assertEquals("last should contain " + dragon[4], dragon[4], list.last.value);
			assertEquals("last.next should be first", dragon[0], list.last.next.value);

			int i;
			Node<String> current;
			for (i = 1, current = list.first; i < 5; i++, current = current.next) {
				assertEquals("At node " + i + " next node should contain " + dragon[i], dragon[i], current.next.value);
			}

			assertTrue("size should be 5", list.size == 5);
		} catch (Exception e) {
			fail("No exception should be thrown, but was: \n" + e);

		}

	}

	@Test
	public void testRotateListOfZeroOrOne() {
		JosephusList<String> list = new JosephusList<String>();

		// empty list
		try {
			list.rotate();

			assertTrue("first should be null", list.first == null);
			assertTrue("last should be null", list.last == null);
			assertTrue("size should be 0", list.size == 0);
		} catch (Exception e) {
			fail("No exception should be thrown, but was: \n" + e);

		}

		// list of one
		try {
			list.add(dragon[0]);
			list.rotate();

			assertEquals("first should contain " + dragon[0], dragon[0], list.first.value);
			assertTrue("first.next should be null", list.first.next == null);
			assertEquals("last should contain " + dragon[0], dragon[0], list.last.value);
			assertTrue("last.next should be null", list.last.next == null);
			assertTrue("size should be 1", list.size == 1);
		} catch (Exception e) {
			fail("No exception should be thrown, but was: \n" + e);

		}
	}

	@Test
	public void testRotateListOfTwo() {
		JosephusList<String> list = new JosephusList<String>();

		try {
			list.add(dragon[1]);
			list.add(dragon[0]);
			list.rotate();

			assertEquals("first should contain " + dragon[0], dragon[0], list.first.value);
			assertEquals("first.next should be last", dragon[1], list.first.next.value);
			assertEquals("last should contain " + dragon[1], dragon[1], list.last.value);
			assertEquals("last.next should be first", dragon[0], list.last.next.value);
			assertTrue("size should be 2", list.size == 2);
		} catch (Exception e) {
			fail("No exception should be thrown, but was: \n" + e);

		}

	}

	@Test
	public void testRotateListOfMany() {
		JosephusList<String> list = new JosephusList<String>();

		try {
			list.add(dragon[4]);
			list.add(dragon[0]);
			list.add(dragon[1]);
			list.add(dragon[2]);
			list.add(dragon[3]);
			list.rotate();

			assertEquals("first should contain " + dragon[0], dragon[0], list.first.value);
			assertEquals("last should contain " + dragon[4], dragon[4], list.last.value);
			assertEquals("last.next should be first", dragon[0], list.last.next.value);

			int i;
			Node<String> current;
			for (i = 1, current = list.first; i < 5; i++, current = current.next) {
				assertEquals("At node " + i + " next node should contain " + dragon[i], dragon[i], current.next.value);
			}

			assertTrue("size should be 5", list.size == 5);
		} catch (Exception e) {
			fail("No exception should be thrown, but was: \n" + e);

		}
	}

	@Test
	public void testCopyListOfZeroOrOne() {
		JosephusList<String> original = new JosephusList<String>();

		// empty list
		try {
			JosephusList<String> list = original.copy();

			assertTrue("first should be null", list.first == null);
			assertTrue("last should be null", list.last == null);
			assertTrue("size should be 0", list.size == 0);
		} catch (Exception e) {
			fail("No exception should be thrown, but was: \n" + e);

		}

		// list of one
		try {
			original.add(dragon[0]);
			JosephusList<String> list = original.copy();

			assertEquals("first should contain " + dragon[0], dragon[0], list.first.value);
			assertTrue("first.next should be null", list.first.next == null);
			assertEquals("last should contain " + dragon[0], dragon[0], list.last.value);
			assertTrue("last.next should be null", list.last.next == null);
			assertTrue("size should be 1", list.size == 1);

			list.remove();
			assertTrue("Removing from copy should not affect original.", original.size == 1);
		} catch (Exception e) {
			fail("No exception should be thrown, but was: \n" + e);

		}
	}

	@Test
	public void testCopyListOfTwo() {
		JosephusList<String> original = new JosephusList<String>();

		try {
			original.add(dragon[0]);
			original.add(dragon[1]);
			JosephusList<String> list = original.copy();

			assertEquals("first should contain " + dragon[0], dragon[0], list.first.value);
			assertEquals("first.next should be last", dragon[1], list.first.next.value);
			assertEquals("last should contain " + dragon[1], dragon[1], list.last.value);
			assertEquals("last.next should be first", dragon[0], list.last.next.value);
			assertTrue("size should be 2", list.size == 2);

			list.remove();
			assertTrue("Removing from copy should not affect original.", original.size == 2);
		} catch (Exception e) {
			fail("No exception should be thrown, but was: \n" + e);

		}

	}

	@Test
	public void testCopyListOfMany() {
		JosephusList<String> original = new JosephusList<String>();

		try {
			original.add(dragon[0]);
			original.add(dragon[1]);
			original.add(dragon[2]);
			original.add(dragon[3]);
			original.add(dragon[4]);
			JosephusList<String> list = original.copy();

			assertEquals("first should contain " + dragon[0], dragon[0], list.first.value);
			assertEquals("last should contain " + dragon[4], dragon[4], list.last.value);
			assertEquals("last.next should be first", dragon[0], list.last.next.value);

			int i;
			Node<String> current;
			for (i = 1, current = list.first; i < 5; i++, current = current.next) {
				assertEquals("At node " + i + " next node should contain " + dragon[i], dragon[i], current.next.value);
			}

			assertTrue("size should be 5", list.size == 5);
		} catch (Exception e) {
			fail("No exception should be thrown, but was: \n" + e);

		}
	}

	@Test
	public void testJosephusOnSmallList() {
		JosephusList<String> list = new JosephusList<String>();

		// empty list
		try {
			String result = list.runProblem(3);

			assertTrue("empty list should result in null", result == null);
			assertTrue("first should be null", list.first == null);
			assertTrue("last should be null", list.last == null);
			assertTrue("size should be 0", list.size == 0);
		} catch (Exception e) {
			fail("No exception should be thrown, but was: \n" + e);

		}

		// list of one
		try {
			list.add(dragon[0]);
			String result = list.runProblem(3);

			assertEquals("list with one item should return that item: " + dragon[0], dragon[0], result);
			assertEquals("first should contain " + dragon[0], dragon[0], list.first.value);
			assertTrue("first.next should be null", list.first.next == null);
			assertEquals("last should contain " + dragon[0], dragon[0], list.last.value);
			assertTrue("last.next should be null", list.last.next == null);
			assertTrue("size should be 1", list.size == 1);
		} catch (Exception e) {
			fail("No exception should be thrown, but was: \n" + e);

		}

		// list of two
		try {
			list.add(dragon[1]);
			String result = list.runProblem(3);

			assertEquals("this problem should return " + dragon[1], dragon[1], result);
			assertEquals("first should contain " + dragon[0], dragon[0], list.first.value);
			assertEquals("first.next should be last", dragon[1], list.first.next.value);
			assertEquals("last should contain " + dragon[1], dragon[1], list.last.value);
			assertEquals("last.next should be first", dragon[0], list.last.next.value);

			assertTrue("size should be 2", list.size == 2);
		} catch (Exception e) {
			fail("No exception should be thrown, but was: \n" + e);

		}

	}

	@Test
	public void testJosephusOnLargeList1() {
		JosephusList<String> list = new JosephusList<String>();
		int size = 10;
		int out = 4;
		int answer = 4; //fifth dragon

		try {
			for (int i = 0; i < size; i++) {
				list.add(dragon[i]);
			}

			String result = list.runProblem(out);
			
			assertEquals("this problem should return " + dragon[answer], dragon[answer], result);
			assertTrue("size should be " + size, list.size == size);
		} catch (Exception e) {
			fail("No exception should be thrown, but was: \n" + e);

		}
	}
	
	@Test
	public void testJosephusOnLargeList2() {
		JosephusList<String> list = new JosephusList<String>();
		int size = 12;
		int out = 5;
		int answer = 0; //first dragon

		try {
			for (int i = 0; i < size; i++) {
				list.add(dragon[i]);
			}

			String result = list.runProblem(out);
			
			assertEquals("this problem should return " + dragon[answer], dragon[answer], result);
			assertTrue("size should be " + size, list.size == size);
		} catch (Exception e) {
			fail("No exception should be thrown, but was: \n" + e);

		}
	}

}