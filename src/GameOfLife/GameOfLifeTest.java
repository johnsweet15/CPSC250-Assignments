package GameOfLife;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class GameOfLifeTest {

	@Test
	public void testReflection() {
		Class<?> cClass = GameOfLife.class;
		Field[] cFields = cClass.getDeclaredFields();

		for (Field f : cFields) {
			if (!f.isSynthetic()) {
				assertTrue("Field \"" + f.getName() + "\" should be private", Modifier.isPrivate(f.getModifiers()));
				assertFalse("Field \"" + f.getName() + "\" can't be static", Modifier.isStatic(f.getModifiers()));
			}
		}
	}

	@Test
	public void testDefaultConstructor() {
		GameOfLife game = new GameOfLife();
		boolean[][] grid = game.getGrid();
		int time = game.getTime();

		assertEquals("Number of rows should be 10.", 10, grid.length);

		for (int i = 0; i < grid.length; i++) {
			assertEquals("Number of columns at row " + i + " should be 10.", 10, grid[i].length);
			for (int k = 0; k < grid[i].length; k++) {
				assertFalse("All cells should initialize to false.", grid[i][k]);
			}
		}

		assertEquals("Starting time should be 0.", 0, time);
	}

	@Test
	public void testConstructorGood() {
		GameOfLife game = new GameOfLife(5, 5);
		boolean[][] grid = game.getGrid();
		int time = game.getTime();

		// test 5 x 5 grid
		assertEquals("Number of rows should be 5.", 5, grid.length);

		for (int i = 0; i < grid.length; i++) {
			assertEquals("Number of columns at row " + i + " should be 5.", 5, grid[i].length);
			for (int k = 0; k < grid[i].length; k++) {
				assertFalse("All cells should initialize to false.", grid[i][k]);
			}
		}

		assertEquals("Starting time should be 0.", 0, time);

		// test 12 x 20 grid
		game = new GameOfLife(12, 20);
		grid = game.getGrid();
		time = game.getTime();

		assertEquals("Number of rows should be 12.", 12, grid.length);

		for (int i = 0; i < grid.length; i++) {
			assertEquals("Number of columns at row " + i + " should be 20.", 20, grid[i].length);
			for (int k = 0; k < grid[i].length; k++) {
				assertFalse("All cells should initialize to false.", grid[i][k]);
			}
		}

		assertEquals("Starting time should be 0.", 0, time);
	}

	@Test
	public void testConstructorBad() {
		GameOfLife game = new GameOfLife(0, 5);
		boolean[][] grid = game.getGrid();
		int time = game.getTime();

		// test 0 x 5 grid --> 10 x 5 grid
		assertEquals("Number of rows should be default 10.", 10, grid.length);

		for (int i = 0; i < grid.length; i++) {
			assertEquals("Number of columns at row " + i + " should be 5.", 5, grid[i].length);
			for (int k = 0; k < grid[i].length; k++) {
				assertFalse("All cells should initialize to false.", grid[i][k]);
			}
		}

		assertEquals("Starting time should be 0.", 0, time);

		// test 12 x 0 grid --> 12 x 10 grid
		game = new GameOfLife(12, 0);
		grid = game.getGrid();
		time = game.getTime();

		assertEquals("Number of rows should be 12.", 12, grid.length);

		for (int i = 0; i < grid.length; i++) {
			assertEquals("Number of columns at row " + i + " should be default 10.", 10, grid[i].length);
			for (int k = 0; k < grid[i].length; k++) {
				assertFalse("All cells should initialize to false.", grid[i][k]);
			}
		}

		assertEquals("Starting time should be 0.", 0, time);

		// test -10 x -12 grid --> 10 x 10 grid
		game = new GameOfLife(-10, -12);
		grid = game.getGrid();
		time = game.getTime();

		assertEquals("Number of rows should be default 10.", 10, grid.length);

		for (int i = 0; i < grid.length; i++) {
			assertEquals("Number of columns at row " + i + " should be default 10.", 10, grid[i].length);
			for (int k = 0; k < grid[i].length; k++) {
				assertFalse("All cells should initialize to false.", grid[i][k]);
			}
		}

		assertEquals("Starting time should be 0.", 0, time);
	}

	@Test
	public void testGetGrid() {
		GameOfLife game = new GameOfLife();
		boolean[][] grid = game.getGrid();	//get grid

		// this line should not affect the grid in the game
		// should be a copy of the game grid
		grid[0][0] = true;

		// get game grid
		grid = game.getGrid();

		assertFalse("getGrid() should return a copy of the grid.", grid[0][0]);
	}

	@Test
	public void testSimpleSetUpGood() {
		GameOfLife game = new GameOfLife();

		int[][] setup = { { 1, 3 }, { 2, 1 }, { 2, 3 }, { 3, 2 }, { 3, 3 } };

		game.simpleSetUp(setup);	//setup

		// using x to represent false, o to represent true
		// for ease of typing/reading
		boolean x = false;
		boolean o = true;
		boolean[][] expected = { { x, x, x, x, x, x, x, x, x, x }, 
								 { x, x, x, o, x, x, x, x, x, x },
								 { x, o, x, o, x, x, x, x, x, x }, 	
								 { x, x, o, o, x, x, x, x, x, x }, 
								 { x, x, x, x, x, x, x, x, x, x },
								 { x, x, x, x, x, x, x, x, x, x }, 
								 { x, x, x, x, x, x, x, x, x, x }, 
								 { x, x, x, x, x, x, x, x, x, x },
								 { x, x, x, x, x, x, x, x, x, x }, 
								 { x, x, x, x, x, x, x, x, x, x } };	//expected game grid

		boolean[][] actual = game.getGrid();							//actual game grid

		assertEquals("Game grid has incorrect number of rows.", expected.length, actual.length);
		for (int i = 0; i < expected.length; i++) {
			assertEquals("Game grid has incorrect number of columns at row " + i + ".", expected[i].length,
					actual[i].length);
			for (int k = 0; k < expected[i].length; k++) {
				if (expected[i][k]) {
					assertTrue("Game cell [" + i + "][" + k + "] should be on.", actual[i][k]);
				} else {
					assertFalse("Game cell [" + i + "][" + k + "] should be off.", actual[i][k]);
				}
			}
		}
	}
	
	@Test
	public void testSimpleSetUpBad() {
		GameOfLife game = new GameOfLife(12, 12);

		int[][] setup = { { 1, 3 }, { 2, -1 }, { 2, 3 }, { 3, 20 }, { 3, 3 } };

		game.simpleSetUp(setup);	//setup

		// using x to represent false, o to represent true
		// for ease of typing/reading
		boolean x = false;
		boolean o = true;
		boolean[][] expected = { { x, x, x, x, x, x, x, x, x, x, x, x }, 
								 { x, x, x, o, x, x, x, x, x, x, x, x },
								 { x, x, x, o, x, x, x, x, x, x, x, x }, 	
								 { x, x, x, o, x, x, x, x, x, x, x, x }, 
								 { x, x, x, x, x, x, x, x, x, x, x, x },
								 { x, x, x, x, x, x, x, x, x, x, x, x }, 
								 { x, x, x, x, x, x, x, x, x, x, x, x }, 
								 { x, x, x, x, x, x, x, x, x, x, x, x },
								 { x, x, x, x, x, x, x, x, x, x, x, x },
								 { x, x, x, x, x, x, x, x, x, x, x, x },
								 { x, x, x, x, x, x, x, x, x, x, x, x }, 
								 { x, x, x, x, x, x, x, x, x, x, x, x } };	//expected game grid

		boolean[][] actual = game.getGrid();								//actual game grid

		assertEquals("Game grid has incorrect number of rows.", expected.length, actual.length);
		for (int i = 0; i < expected.length; i++) {
			assertEquals("Game grid has incorrect number of columns at row " + i + ".", expected[i].length,
					actual[i].length);
			for (int k = 0; k < expected[i].length; k++) {
				if (expected[i][k]) {
					assertTrue("Game cell [" + i + "][" + k + "] should be on.", actual[i][k]);
				} else {
					assertFalse("Game cell [" + i + "][" + k + "] should be off.", actual[i][k]);
				}
			}
		}
	}
	
	@Test
	public void testClearGrid(){
		GameOfLife game = new GameOfLife();

		int[][] setup = { { 1, 3 }, { 2, -1 }, { 2, 3 }, { 3, 20 }, { 3, 3 } };

		game.simpleSetUp(setup);	//change grid
		game.runRound();			//change time
		game.clearGrid();			//clear grid
		
		boolean[][] grid = game.getGrid();
		int time = game.getTime();

		for (int i = 0; i < grid.length; i++) {
			for (int k = 0; k < grid[i].length; k++) {
				assertFalse("All cells should clear to false.", grid[i][k]);
			}
		}

		assertEquals("Starting time should clear to 0.", 0, time);
		
	}
	
	@Test 
	public void testRunStep1(){
		GameOfLife game = new GameOfLife();

		int[][] setup = { { 1, 3 }, { 2, 1 }, { 2, 3 }, { 3, 2 }, { 3, 3 } };

		game.simpleSetUp(setup);	//setup
		game.runRound(); 			//run once

		// using x to represent false, o to represent true
		// for ease of typing/reading
		boolean x = false;
		boolean o = true;
		boolean[][] expected = { { x, x, x, x, x, x, x, x, x, x }, 
								 { x, x, o, x, x, x, x, x, x, x },
								 { x, x, x, o, o, x, x, x, x, x }, 	
								 { x, x, o, o, x, x, x, x, x, x }, 
								 { x, x, x, x, x, x, x, x, x, x },
								 { x, x, x, x, x, x, x, x, x, x }, 
								 { x, x, x, x, x, x, x, x, x, x }, 
								 { x, x, x, x, x, x, x, x, x, x },
								 { x, x, x, x, x, x, x, x, x, x }, 
								 { x, x, x, x, x, x, x, x, x, x } };	//expected game grid

		boolean[][] actual = game.getGrid();							//actual game grid
		int time = game.getTime();										//game time
		
		assertEquals("Game should be run once.", 1, time);
		
		assertEquals("Game grid has incorrect number of rows.", expected.length, actual.length);
		for (int i = 0; i < expected.length; i++) {
			assertEquals("Game grid has incorrect number of columns at row " + i + ".", expected[i].length,
					actual[i].length);
			for (int k = 0; k < expected[i].length; k++) {
				if (expected[i][k]) {
					assertTrue("Game cell [" + i + "][" + k + "] should be on.", actual[i][k]);
				} else {
					assertFalse("Game cell [" + i + "][" + k + "] should be off.", actual[i][k]);
				}
			}
		}
	}
	
	@Test 
	public void testRunStep2(){
		GameOfLife game = new GameOfLife(12, 12);

		int[][] setup = { { 1, 3 }, { 2, 1 }, { 2, 3 }, { 3, 2 }, { 3, 3 } };

		game.simpleSetUp(setup);	//setup
		game.runRound(); 			//run once
		game.runRound(); 			//run twice

		// using x to represent false, o to represent true
		// for ease of typing/reading
		boolean x = false;
		boolean o = true;
		boolean[][] expected = { { x, x, x, x, x, x, x, x, x, x, x, x }, 
								 { x, x, x, o, x, x, x, x, x, x, x, x },
								 { x, x, x, x, o, x, x, x, x, x, x, x }, 	
								 { x, x, o, o, o, x, x, x, x, x, x, x }, 
								 { x, x, x, x, x, x, x, x, x, x, x, x },
								 { x, x, x, x, x, x, x, x, x, x, x, x }, 
								 { x, x, x, x, x, x, x, x, x, x, x, x }, 
								 { x, x, x, x, x, x, x, x, x, x, x, x },
								 { x, x, x, x, x, x, x, x, x, x, x, x },
								 { x, x, x, x, x, x, x, x, x, x, x, x },
								 { x, x, x, x, x, x, x, x, x, x, x, x }, 
								 { x, x, x, x, x, x, x, x, x, x, x, x } };	//expected game grid

		boolean[][] actual = game.getGrid();								//actual game grid
		int time = game.getTime();											//game time
		
		assertEquals("Game should be run twice.", 2, time);
		
		assertEquals("Game grid has incorrect number of rows.", expected.length, actual.length);
		for (int i = 0; i < expected.length; i++) {
			assertEquals("Game grid has incorrect number of columns at row " + i + ".", expected[i].length,
					actual[i].length);
			for (int k = 0; k < expected[i].length; k++) {
				if (expected[i][k]) {
					assertTrue("Game cell [" + i + "][" + k + "] should be on.", actual[i][k]);
				} else {
					assertFalse("Game cell [" + i + "][" + k + "] should be off.", actual[i][k]);
				}
			}
		}
	}
	
	@Test 
	public void testRunGameClearGridSetUp(){
		GameOfLife game = new GameOfLife();

		int[][] setup = { { 1, 3 }, { 2, 1 }, { 2, 3 }, { 3, 2 }, { 3, 3 } };

		game.simpleSetUp(setup);	//setup
		game.runGame(1);			//run once
		game.clearGrid(); 			//clear to 0
		game.simpleSetUp(setup);	//setup
		game.runGame(1);			//run once

		// using x to represent false, o to represent true
		// for ease of typing/reading
		boolean x = false;
		boolean o = true;
		boolean[][] expected = { { x, x, x, x, x, x, x, x, x, x }, 
								 { x, x, o, x, x, x, x, x, x, x },
								 { x, x, x, o, o, x, x, x, x, x }, 	
								 { x, x, o, o, x, x, x, x, x, x }, 
								 { x, x, x, x, x, x, x, x, x, x },
								 { x, x, x, x, x, x, x, x, x, x }, 
								 { x, x, x, x, x, x, x, x, x, x }, 
								 { x, x, x, x, x, x, x, x, x, x },
								 { x, x, x, x, x, x, x, x, x, x }, 
								 { x, x, x, x, x, x, x, x, x, x } };	//expected game grid

		boolean[][] actual = game.getGrid();							//actual game grid
		int time = game.getTime();										//game time

		//Note: You may have issues here if your setup method doesn't
		//allow you to setup after a clear OR if your clear is not
		//not working appropriately
		
		assertEquals("Game should be cleared, setup, and run once.", 1, time);
		
		assertEquals("Game grid has incorrect number of rows.", expected.length, actual.length);
		for (int i = 0; i < expected.length; i++) {
			assertEquals("Game grid has incorrect number of columns at row " + i + ".", expected[i].length,
					actual[i].length);
			for (int k = 0; k < expected[i].length; k++) {
				if (expected[i][k]) {
					assertTrue("Game cell [" + i + "][" + k + "] should be on.", actual[i][k]);
				} else {
					assertFalse("Game cell [" + i + "][" + k + "] should be off.", actual[i][k]);
				}
			}
		}
	}
	
	@Test 
	public void testRunGameSetUp(){
		GameOfLife game = new GameOfLife();

		int[][] setup = { { 1, 3 }, { 2, 1 }, { 2, 3 }, { 3, 2 }, { 3, 3 } };

		game.simpleSetUp(setup);	//setup
		game.runGame(3);			//run 3 times
		game.simpleSetUp(setup); 	//setup should not be allowed after time 0
									//should not affect game whatsoever

		// using x to represent false, o to represent true
		// for ease of typing/reading
		boolean x = false;
		boolean o = true;
		boolean[][] expected = { { x, x, x, x, x, x, x, x, x, x }, 
								 { x, x, x, x, x, x, x, x, x, x },
								 { x, x, o, x, o, x, x, x, x, x }, 	
								 { x, x, x, o, o, x, x, x, x, x }, 
								 { x, x, x, o, x, x, x, x, x, x },
								 { x, x, x, x, x, x, x, x, x, x }, 
								 { x, x, x, x, x, x, x, x, x, x }, 
								 { x, x, x, x, x, x, x, x, x, x },
								 { x, x, x, x, x, x, x, x, x, x }, 
								 { x, x, x, x, x, x, x, x, x, x } };	//expected game grid

		boolean[][] actual = game.getGrid();							//actual game grid
		int time = game.getTime();										//game time

		//Note: You may have issues here if your setup method
		//changes the grid when the time is not zero
		
		assertEquals("Game should be run 3 times.", 3, time);
		
		assertEquals("Game grid has incorrect number of rows.", expected.length, actual.length);
		for (int i = 0; i < expected.length; i++) {
			assertEquals("Game grid has incorrect number of columns at row " + i + ".", expected[i].length,
					actual[i].length);
			for (int k = 0; k < expected[i].length; k++) {
				if (expected[i][k]) {
					assertTrue("Game cell [" + i + "][" + k + "] should be on.", actual[i][k]);
				} else {
					assertFalse("Game cell [" + i + "][" + k + "] should be off.", actual[i][k]);
				}
			}
		}
	}
	
	
	@Test 
	public void testRunGame1(){
		GameOfLife game = new GameOfLife(5,5);

		int[][] setup = { { 1, 3 }, { 2, 1 }, { 2, 3 }, { 3, 2 }, { 3, 3 } };

		game.simpleSetUp(setup);	//setup
		game.runGame(8);			//run 8 rounds

		// using x to represent false, o to represent true
		// for ease of typing/reading
		boolean x = false;
		boolean o = true;
		boolean[][] expected = { { x, x, x, x, x }, 
								 { x, x, x, x, x },
								 { x, x, x, x, x }, 	
								 { x, x, x, o, o }, 
								 { x, x, x, o, o } };	//expected game grid

		boolean[][] actual = game.getGrid();			//actual game grid
		int time = game.getTime();						//game time
		
		assertEquals("Game should be run 8 times.", 8, time);

		assertEquals("Game grid has incorrect number of rows.", expected.length, actual.length);
		for (int i = 0; i < expected.length; i++) {
			assertEquals("Game grid has incorrect number of columns at row " + i + ".", expected[i].length,
					actual[i].length);
			for (int k = 0; k < expected[i].length; k++) {
				if (expected[i][k]) {
					assertTrue("Game cell [" + i + "][" + k + "] should be on.", actual[i][k]);
				} else {
					assertFalse("Game cell [" + i + "][" + k + "] should be off.", actual[i][k]);
				}
			}
		}
	}
	
	@Test 
	public void testRunGame2(){
		GameOfLife game = new GameOfLife();

		int[][] setup = { { 1, 3 }, { 2, 1 }, { 2, 3 }, { 3, 2 }, { 3, 3 } };

		game.simpleSetUp(setup);	//setup
		game.runGame(10); 			//run 10 rounds
		game.runGame(5);  			//run 5 more rounds
		
		// using x to represent false, o to represent true
		// for ease of typing/reading
		boolean x = false;
		boolean o = true;
		boolean[][] expected = { { x, x, x, x, x, x, x, x, x, x }, 
								 { x, x, x, x, x, x, x, x, x, x },
								 { x, x, x, x, x, x, x, x, x, x }, 	
								 { x, x, x, x, x, x, x, x, x, x }, 
								 { x, x, x, x, x, x, x, x, x, x },
								 { x, x, x, x, x, o, x, o, x, x }, 
								 { x, x, x, x, x, x, o, o, x, x }, 
								 { x, x, x, x, x, x, o, x, x, x },
								 { x, x, x, x, x, x, x, x, x, x }, 
								 { x, x, x, x, x, x, x, x, x, x } };	//expected game grid

		boolean[][] actual = game.getGrid();							//actual game grid
		int time = game.getTime();										//game time
		
		assertEquals("Game should be run 15 times.", 15, time);

		assertEquals("Game grid has incorrect number of rows.", expected.length, actual.length);
		for (int i = 0; i < expected.length; i++) {
			assertEquals("Game grid has incorrect number of columns at row " + i + ".", expected[i].length,
					actual[i].length);
			for (int k = 0; k < expected[i].length; k++) {
				if (expected[i][k]) {
					assertTrue("Game cell [" + i + "][" + k + "] should be on.", actual[i][k]);
				} else {
					assertFalse("Game cell [" + i + "][" + k + "] should be off.", actual[i][k]);
				}
			}
		}
	}
	

}
