package FinalExam;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoomTest {
	@Test
	public void test0() {
		Object room      = new Room     ( 1, 42 );
		Object business  = new Business ( 1, 42 );
		Object executive = new Executive( 1, 42 );
		
		assertFalse( "Incorrect result", room instanceof Business );
		assertFalse( "Incorrect result", room instanceof Executive );
		
		assertTrue ( "Incorrect result", business instanceof Room );
		assertFalse( "Incorrect result", business instanceof Executive );
		
		assertTrue ( "Incorrect result", executive instanceof Room );
		assertFalse( "Incorrect result", executive instanceof Business );
	}
	@Test
	public void test1a() {
		Object a = new Room( 5, 50 ) { };
		assertEquals( "Incorrect result", a, a );
		
		Object b = new Room( 5, 50 ) { };
		assertEquals( "Incorrect result", a, b );
		
		Object c = new Room( 5, 99 ) { };
		assertEquals( "Incorrect result", a, c );
		
		Object d = new Room( 7, 50 ) { };
		assertFalse ( "Incorrect result", a.equals( d ));
		
		assertFalse ( "Incorrect result", a.equals( null ));
		assertFalse ( "Incorrect result", a.equals( "Room" ));
		assertFalse ( "Incorrect result", a.equals( 'x' ));
		assertFalse ( "Incorrect result", a.equals( 42 ));
		assertFalse ( "Incorrect result", a.equals( 3.1416 ));
	}
	@Test
	public void test1b() {
		Object a = new Room     ( 1, 20 ) { };
		Object b = new Business ( 1, 30 ) { };
		Object c = new Executive( 1, 40 ) { };

		assertTrue ( "Incorrect result", a.equals( b ));
		assertTrue ( "Incorrect result", a.equals( c ));
				
		assertFalse( "Incorrect result", c.equals( b ));
		assertFalse( "Incorrect result", b.equals( c ));
	}
	@Test
	public void test2() {
		Object a = new Room( 4, 42 ) { };
		assertEquals( "Incorrect result", "Room #4 $42", a.toString() );
		
		Object b = new Business( 2, 24 ) { };
		assertEquals( "Incorrect result", "Room #2 $24 [Business]", b.toString() );
		
		Object c = new Executive( 1, 99 ) { };
		assertEquals( "Incorrect result", "Room #1 $99 [Executive]", c.toString() );
	}
}