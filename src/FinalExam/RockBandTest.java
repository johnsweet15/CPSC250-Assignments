package FinalExam;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class RockBandTest {

	@Test
	public void testStructure() {
		Class<?> cClass = RockBand.class;
		Field[] cFields = cClass.getDeclaredFields();

		for (Field f : cFields) {
			if (!f.isSynthetic()) {
				assertTrue("Field \"" + f.getName() + "\" should be private",
						Modifier.isPrivate(f.getModifiers()));
				assertFalse("Field \"" + f.getName() + "\" can't be static",
						Modifier.isStatic(f.getModifiers()));
			}
		}
	}

	@Test
	public void testBands() {
		RockBand rb1 = new RockBand("Weezer", RockGenre.ALTERNATIVE);
		RockBand rb2 = new RockBand("Maroon 5", RockGenre.POP);
		RockBand rb3 = new RockBand("Nirvana", RockGenre.GRUNGE);
		RockBand rb4 = new RockBand("Jimmy Eat World", RockGenre.EMO);
		String rn1 = rb1.getName();
		String rn2 = rb2.getName();
		String rn3 = rb3.getName();
		String rn4 = rb4.getName();
		RockGenre rg1 = rb1.getGenre();
		RockGenre rg2 = rb2.getGenre();
		RockGenre rg3 = rb3.getGenre();
		RockGenre rg4 = rb4.getGenre();
		assertEquals("Weezer", rn1);
		assertEquals("Maroon 5", rn2);
		assertEquals("Nirvana", rn3);
		assertEquals("Jimmy Eat World", rn4);
		assertEquals(RockGenre.ALTERNATIVE, rg1);
		assertEquals(RockGenre.POP, rg2);
		assertEquals(RockGenre.GRUNGE, rg3);
		assertEquals(RockGenre.EMO, rg4);
		assertEquals("alternative", rg1.toString());
		assertEquals("pop", rg2.toString());
		assertEquals("grunge", rg3.toString());
		assertEquals("emo", rg4.toString());
	}

}