package Robot;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RobotTest {

	private final String EOL = System.getProperty("line.separator");
	private static String INPUT = "input.txt";
	private static String OUTPUT = "output.txt";

	private PrintStream console;
	private ByteArrayOutputStream buffer;

	/*
	 * Testing bad input
	 */

	@Test
	public void testNoInputFile() {
		// redirect output to a stream
		console = System.out;
		buffer = new ByteArrayOutputStream();
		System.setOut(new PrintStream(buffer));

		INPUT = "input0.txt";
		OUTPUT = "output0.txt";

		File inputFile = new File(INPUT);
		File outputFile = new File(OUTPUT);
		// delete I/O file (if one existed)
		inputFile.delete();
		outputFile.delete();

		// invoke program
		Robot.readInstructions(INPUT, OUTPUT);
		// program should print to console: "Input file not found."
		final String FILE_NOT_FOUND = "Input file not found." + EOL;
		assertEquals(FILE_NOT_FOUND, buffer.toString());

		// return console to its rightful owner
		System.setOut(console);
	}

	/*
	 * Testing Correct Non-Destruction Instructions
	 */

	@Test
	public void testOneLineWithNoCommands() {
		try {
			INPUT = "input1.txt";
			OUTPUT = "output1.txt";

			File inputFile = new File(INPUT);
			File outputFile = new File(OUTPUT);

			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("9   8  7   6");
			input.close();

			// invoke program
			Robot.readInstructions(INPUT, OUTPUT);

			// verify OUTPUT file exists and is correct
			assertTrue(outputFile.exists());
			Scanner output = new Scanner(outputFile);
			assertTrue("Output file was not closed OR no output was written.", output.hasNext());
			String actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "7 6", actual);
			assertFalse("There should not be more data in output file.", output.hasNext());
			output.close();

			// delete I/O files (if they exist)
			assertTrue("Input file was not closed in program.", inputFile.delete());
			outputFile.delete();
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		}
	}

	@Test
	public void testOneLineMoveNorth() {
		try {
			INPUT = "input2.txt";
			OUTPUT = "output2.txt";

			File inputFile = new File(INPUT);
			File outputFile = new File(OUTPUT);

			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("9 8 7 6 N 1 N 2 N 1");
			input.close();

			// invoke program
			Robot.readInstructions(INPUT, OUTPUT);

			// verify OUTPUT file exists and is correct
			assertTrue(outputFile.exists());
			Scanner output = new Scanner(outputFile);
			assertTrue("Output file was not closed OR no output was written.", output.hasNext());
			String actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "3 6", actual);
			assertFalse("There should not be more data in output file.", output.hasNext());
			output.close();

			// delete I/O files (if they exist)
			inputFile.delete();
			outputFile.delete();
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		}
	}

	@Test
	public void testOneLineMoveSouth() {
		try {
			INPUT = "input3.txt";
			OUTPUT = "output3.txt";

			File inputFile = new File(INPUT);
			File outputFile = new File(OUTPUT);

			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("9 8 3 6 S 2 S 3");
			input.close();

			// invoke program
			Robot.readInstructions(INPUT, OUTPUT);

			// verify OUTPUT file exists and is correct
			assertTrue(outputFile.exists());
			Scanner output = new Scanner(outputFile);
			assertTrue("Output file was not closed OR no output was written.", output.hasNext());
			String actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "8 6", actual);
			assertFalse("There should not be more data in output file.", output.hasNext());
			output.close();

			// delete I/O files (if they exist)
			inputFile.delete();
			outputFile.delete();
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		}
	}

	@Test
	public void testOneLineMoveEast() {
		try {
			INPUT = "input4.txt";
			OUTPUT = "output4.txt";

			File inputFile = new File(INPUT);
			File outputFile = new File(OUTPUT);

			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("9 12 7 4 E 3 E 2 E 1");
			input.close();

			// invoke program
			Robot.readInstructions(INPUT, OUTPUT);

			// verify OUTPUT file exists and is correct
			assertTrue(outputFile.exists());
			Scanner output = new Scanner(outputFile);
			assertTrue("Output file was not closed OR no output was written.", output.hasNext());
			String actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "7 10", actual);
			assertFalse("There should not be more data in output file.", output.hasNext());
			output.close();

			// delete I/O files (if they exist)
			inputFile.delete();
			outputFile.delete();
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		}
	}

	@Test
	public void testOneLineMoveWest() {
		try {
			INPUT = "input5.txt";
			OUTPUT = "output5.txt";

			File inputFile = new File(INPUT);
			File outputFile = new File(OUTPUT);

			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("9 12 7 8 W 2 W 3 W 2");
			input.close();

			// invoke program
			Robot.readInstructions(INPUT, OUTPUT);

			// verify OUTPUT file exists and is correct
			assertTrue(outputFile.exists());
			Scanner output = new Scanner(outputFile);
			assertTrue("Output file was not closed OR no output was written.", output.hasNext());
			String actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "7 1", actual);
			assertFalse("There should not be more data in output file.", output.hasNext());
			output.close();

			// delete I/O files (if they exist)
			inputFile.delete();
			outputFile.delete();
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		}
	}

	@Test
	public void testOneLineMoveEastWest() {
		try {
			INPUT = "input6.txt";
			OUTPUT = "output6.txt";

			File inputFile = new File(INPUT);
			File outputFile = new File(OUTPUT);

			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("9 12 7 4 E 3 W 2 E 1");
			input.close();

			// invoke program
			Robot.readInstructions(INPUT, OUTPUT);

			// verify OUTPUT file exists and is correct
			assertTrue(outputFile.exists());
			Scanner output = new Scanner(outputFile);
			assertTrue("Output file was not closed OR no output was written.", output.hasNext());
			String actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "7 6", actual);
			assertFalse("There should not be more data in output file.", output.hasNext());
			output.close();

			// delete I/O files (if they exist)
			inputFile.delete();
			outputFile.delete();
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		}
	}

	@Test
	public void testOneLineMoveNorthSouth() {
		try {
			INPUT = "input7.txt";
			OUTPUT = "output7.txt";

			File inputFile = new File(INPUT);
			File outputFile = new File(OUTPUT);

			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("9 8 3 6 S 2 S 3 N 1");
			input.close();

			// invoke program
			Robot.readInstructions(INPUT, OUTPUT);

			// verify OUTPUT file exists and is correct
			assertTrue(outputFile.exists());
			Scanner output = new Scanner(outputFile);
			assertTrue("Output file was not closed OR no output was written.", output.hasNext());
			String actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "7 6", actual);
			assertFalse("There should not be more data in output file.", output.hasNext());
			output.close();

			// delete I/O files (if they exist)
			inputFile.delete();
			outputFile.delete();
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		}
	}

	@Test
	public void testOneLineMoveAllDirections() {
		try {
			INPUT = "input8.txt";
			OUTPUT = "output8.txt";

			File inputFile = new File(INPUT);
			File outputFile = new File(OUTPUT);

			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("12 15 6 8 N 1 W 3 S 4 N 2 E 2 N 2 E 2 S 3 W 5");
			input.close();

			// invoke program
			Robot.readInstructions(INPUT, OUTPUT);

			// verify OUTPUT file exists and is correct
			assertTrue(outputFile.exists());
			Scanner output = new Scanner(outputFile);
			assertTrue("Output file was not closed OR no output was written.", output.hasNext());
			String actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "8 4", actual);
			assertFalse("There should not be more data in output file.", output.hasNext());
			output.close();

			// delete I/O files (if they exist)
			inputFile.delete();
			outputFile.delete();
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		}
	}

	/*
	 * Testing Correct Destruction Instructions
	 */

	@Test
	public void testOneLineDestroyedAtDeploymentNorth() {
		try {
			INPUT = "input9.txt";
			OUTPUT = "output9.txt";

			File inputFile = new File(INPUT);
			File outputFile = new File(OUTPUT);

			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("4 5 -1 3 S 2 W 5");
			input.close();

			// invoke program
			Robot.readInstructions(INPUT, OUTPUT);

			// verify OUTPUT file exists and is correct
			assertTrue(outputFile.exists());
			Scanner output = new Scanner(outputFile);
			assertTrue("Output file was not closed OR no output was written.", output.hasNext());
			String actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "terminated", actual);
			assertFalse("There should not be more data in output file.", output.hasNext());
			output.close();

			// delete I/O files (if they exist)
			inputFile.delete();
			outputFile.delete();
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		}
	}

	@Test
	public void testOneLineDestroyedAtDeploymentSouth() {
		try {
			INPUT = "input10.txt";
			OUTPUT = "output10.txt";

			File inputFile = new File(INPUT);
			File outputFile = new File(OUTPUT);

			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("4 5 7 3 S 2 W 5");
			input.close();

			// invoke program
			Robot.readInstructions(INPUT, OUTPUT);

			// verify OUTPUT file exists and is correct
			assertTrue(outputFile.exists());
			Scanner output = new Scanner(outputFile);
			assertTrue("Output file was not closed OR no output was written.", output.hasNext());
			String actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "terminated", actual);
			assertFalse("There should not be more data in output file.", output.hasNext());
			output.close();

			// delete I/O files (if they exist)
			inputFile.delete();
			outputFile.delete();
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		}
	}

	@Test
	public void testOneLineDestroyedAtDeploymentEast() {
		try {
			INPUT = "input11.txt";
			OUTPUT = "output11.txt";

			File inputFile = new File(INPUT);
			File outputFile = new File(OUTPUT);

			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("4 5 2 7 S 2 W 5");
			input.close();

			// invoke program
			Robot.readInstructions(INPUT, OUTPUT);

			// verify OUTPUT file exists and is correct
			assertTrue(outputFile.exists());
			Scanner output = new Scanner(outputFile);
			assertTrue("Output file was not closed OR no output was written.", output.hasNext());
			String actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "terminated", actual);
			assertFalse("There should not be more data in output file.", output.hasNext());
			output.close();

			// delete I/O files (if they exist)
			inputFile.delete();
			outputFile.delete();
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		}
	}

	@Test
	public void testOneLineDestroyedAtDeploymentWest() {
		try {
			INPUT = "input12.txt";
			OUTPUT = "output12.txt";

			File inputFile = new File(INPUT);
			File outputFile = new File(OUTPUT);

			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("4 5 2 -3 S 2 W 5");
			input.close();

			// invoke program
			Robot.readInstructions(INPUT, OUTPUT);

			// verify OUTPUT file exists and is correct
			assertTrue(outputFile.exists());
			Scanner output = new Scanner(outputFile);
			assertTrue("Output file was not closed OR no output was written.", output.hasNext());
			String actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "terminated", actual);
			assertFalse("There should not be more data in output file.", output.hasNext());
			output.close();

			// delete I/O files (if they exist)
			inputFile.delete();
			outputFile.delete();
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		}
	}

	@Test
	public void testOneLineDestroyedGoingNorth() {
		try {
			INPUT = "input13.txt";
			OUTPUT = "output13.txt";

			File inputFile = new File(INPUT);
			File outputFile = new File(OUTPUT);

			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("7 6 5 4 N 5 N 3");
			input.close();

			// invoke program
			Robot.readInstructions(INPUT, OUTPUT);

			// verify OUTPUT file exists and is correct
			assertTrue(outputFile.exists());
			Scanner output = new Scanner(outputFile);
			assertTrue("Output file was not closed OR no output was written.", output.hasNext());
			String actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "terminated", actual);
			assertFalse("There should not be more data in output file.", output.hasNext());
			output.close();

			// delete I/O files (if they exist)
			inputFile.delete();
			outputFile.delete();
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		}
	}

	@Test
	public void testOneLineDestroyedGoingSouth() {
		try {
			INPUT = "input14.txt";
			OUTPUT = "output14.txt";

			File inputFile = new File(INPUT);
			File outputFile = new File(OUTPUT);

			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("7 6 4 5 S 1 S 4");
			input.close();

			// invoke program
			Robot.readInstructions(INPUT, OUTPUT);

			// verify OUTPUT file exists and is correct
			assertTrue(outputFile.exists());
			Scanner output = new Scanner(outputFile);
			assertTrue("Output file was not closed OR no output was written.", output.hasNext());
			String actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "terminated", actual);
			assertFalse("There should not be more data in output file.", output.hasNext());
			output.close();

			// delete I/O files (if they exist)
			inputFile.delete();
			outputFile.delete();
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		}
	}

	@Test
	public void testOneLineDestroyedGoingEast() {
		try {
			INPUT = "input15.txt";
			OUTPUT = "output15.txt";

			File inputFile = new File(INPUT);
			File outputFile = new File(OUTPUT);

			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("7 6 5 4 E 1 E 1 E 1 E 1");
			input.close();

			// invoke program
			Robot.readInstructions(INPUT, OUTPUT);

			// verify OUTPUT file exists and is correct
			assertTrue(outputFile.exists());
			Scanner output = new Scanner(outputFile);
			assertTrue("Output file was not closed OR no output was written.", output.hasNext());
			String actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "terminated", actual);
			assertFalse("There should not be more data in output file.", output.hasNext());
			output.close();

			// delete I/O files (if they exist)
			inputFile.delete();
			outputFile.delete();
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		}
	}

	@Test
	public void testOneLineDestroyedGoingWest() {
		try {
			INPUT = "input16.txt";
			OUTPUT = "output16.txt";

			File inputFile = new File(INPUT);
			File outputFile = new File(OUTPUT);

			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("7 6 5 4 W 1 W 2 W 3");
			input.close();

			// invoke program
			Robot.readInstructions(INPUT, OUTPUT);

			// verify OUTPUT file exists and is correct
			assertTrue(outputFile.exists());
			Scanner output = new Scanner(outputFile);
			assertTrue("Output file was not closed OR no output was written.", output.hasNext());
			String actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "terminated", actual);
			assertFalse("There should not be more data in output file.", output.hasNext());
			output.close();

			// delete I/O files (if they exist)
			inputFile.delete();
			outputFile.delete();
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		}
	}

	@Test
	public void testOneLineDestroyedGoingNorthAfterMovement() {
		try {
			INPUT = "input17.txt";
			OUTPUT = "output17.txt";

			File inputFile = new File(INPUT);
			File outputFile = new File(OUTPUT);

			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("7 6 5 4 S 1 W 3 E 2 N 5 N 3");
			input.close();

			// invoke program
			Robot.readInstructions(INPUT, OUTPUT);

			// verify OUTPUT file exists and is correct
			assertTrue(outputFile.exists());
			Scanner output = new Scanner(outputFile);
			assertTrue("Output file was not closed OR no output was written.", output.hasNext());
			String actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "terminated", actual);
			assertFalse("There should not be more data in output file.", output.hasNext());
			output.close();

			// delete I/O files (if they exist)
			inputFile.delete();
			outputFile.delete();
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		}
	}

	@Test
	public void testOneLineDestroyedGoingSouthAfterMovement() {
		try {
			INPUT = "input18.txt";
			OUTPUT = "output18.txt";

			File inputFile = new File(INPUT);
			File outputFile = new File(OUTPUT);

			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("7 6 4 5 W 3 E 2 N 1 S 1 S 4");
			input.close();

			// invoke program
			Robot.readInstructions(INPUT, OUTPUT);

			// verify OUTPUT file exists and is correct
			assertTrue(outputFile.exists());
			Scanner output = new Scanner(outputFile);
			assertTrue("Output file was not closed OR no output was written.", output.hasNext());
			String actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "terminated", actual);
			assertFalse("There should not be more data in output file.", output.hasNext());
			output.close();

			// delete I/O files (if they exist)
			inputFile.delete();
			outputFile.delete();
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		}
	}

	@Test
	public void testOneLineDestroyedGoingEastAfterMovement() {
		try {
			INPUT = "input19.txt";
			OUTPUT = "output19.txt";

			File inputFile = new File(INPUT);
			File outputFile = new File(OUTPUT);

			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("7 6 5 4 W 1 N 4 S 1 S 1 E 4");
			input.close();

			// invoke program
			Robot.readInstructions(INPUT, OUTPUT);

			// verify OUTPUT file exists and is correct
			assertTrue(outputFile.exists());
			Scanner output = new Scanner(outputFile);
			assertTrue("Output file was not closed OR no output was written.", output.hasNext());
			String actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "terminated", actual);
			assertFalse("There should not be more data in output file.", output.hasNext());
			output.close();

			// delete I/O files (if they exist)
			inputFile.delete();
			outputFile.delete();
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		}
	}

	@Test
	public void testOneLineDestroyedGoingWestAfterMovement() {
		try {
			INPUT = "input20.txt";
			OUTPUT = "output20.txt";

			File inputFile = new File(INPUT);
			File outputFile = new File(OUTPUT);

			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("7 6 5 4 N 3 E 1 S 2 W 1 W 2 W 3");
			input.close();

			// invoke program
			Robot.readInstructions(INPUT, OUTPUT);

			// verify OUTPUT file exists and is correct
			assertTrue(outputFile.exists());
			Scanner output = new Scanner(outputFile);
			assertTrue("Output file was not closed OR no output was written.", output.hasNext());
			String actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "terminated", actual);
			assertFalse("There should not be more data in output file.", output.hasNext());
			output.close();

			// delete I/O files (if they exist)
			inputFile.delete();
			outputFile.delete();
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		}
	}

	/*
	 * Testing Incorrect Instructions
	 */

	@Test
	public void testExceptionTooFewNumbersInSetup() {
		INPUT = "input21.txt";
		OUTPUT = "output21.txt";

		File inputFile = new File(INPUT);
		File outputFile = new File(OUTPUT);

		try {
			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("7 6 5");
			input.close();

			// invoke program, should throw exception
			Robot.readInstructions(INPUT, OUTPUT);
			fail("InvalidRobotInstructionException should be thrown.");
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		} catch (InvalidRobotInstructionException e) {
			// delete I/O files (if they exist)
			assertTrue("Input file was not closed in program.", inputFile.delete());
			if (outputFile.exists()) {
				assertFalse("Output file should not contain text.", outputFile.length() > 0);
				assertTrue("Output file was not closed in program.", outputFile.delete());
			}
		}
	}

	@Test
	public void testExceptionNonnumbersInSetup() {
		INPUT = "input22.txt";
		OUTPUT = "output22.txt";

		File inputFile = new File(INPUT);
		File outputFile = new File(OUTPUT);

		try {
			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("7 ! 5 E 3 4");
			input.close();

			// invoke program, should throw exception
			Robot.readInstructions(INPUT, OUTPUT);
			fail("InvalidRobotInstructionException should be thrown.");
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		} catch (InvalidRobotInstructionException e) {
			// delete I/O files (if they exist)
			assertTrue("Input file was not closed in program.", inputFile.delete());
			if (outputFile.exists()) {
				assertFalse("Output file should not contain text.", outputFile.length() > 0);
				assertTrue("Output file was not closed in program.", outputFile.delete());
			}
		}
	}

	@Test
	public void testExceptionIncorrectDirection() {
		INPUT = "input23.txt";
		OUTPUT = "output23.txt";

		File inputFile = new File(INPUT);
		File outputFile = new File(OUTPUT);

		try {
			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("12 15 6 8 N 1 W 3 S 4 X 2 E 2 N 2 E 2 S 3 W 5");
			input.close();

			// invoke program, should throw exception
			Robot.readInstructions(INPUT, OUTPUT);
			fail("InvalidRobotInstructionException should be thrown.");
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		} catch (InvalidRobotInstructionException e) {
			// delete I/O files (if they exist)
			assertTrue("Input file was not closed in program.", inputFile.delete());
			if (outputFile.exists()) {
				assertFalse("Output file should not contain text.", outputFile.length() > 0);
				assertTrue("Output file was not closed in program.", outputFile.delete());
			}
		}
	}

	@Test
	public void testExceptionIncorrectNumberSpaces() {
		INPUT = "input24.txt";
		OUTPUT = "output24.txt";

		File inputFile = new File(INPUT);
		File outputFile = new File(OUTPUT);

		try {
			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("12 15 6 8 N 1 W 3 S 4 N Z E 2 N 2 E 2 S 3 W 5");
			input.close();

			// invoke program, should throw exception
			Robot.readInstructions(INPUT, OUTPUT);
			fail("InvalidRobotInstructionException should be thrown.");
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		} catch (InvalidRobotInstructionException e) {
			// delete I/O files (if they exist)
			assertTrue("Input file was not closed in program.", inputFile.delete());
			if (outputFile.exists()) {
				assertFalse("Output file should not contain text.", outputFile.length() > 0);
				assertTrue("Output file was not closed in program.", outputFile.delete());
			}
		}
	}

	@Test
	public void testExceptionMissingInstruction() {
		INPUT = "input25.txt";
		OUTPUT = "output25.txt";

		File inputFile = new File(INPUT);
		File outputFile = new File(OUTPUT);

		try {
			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("12 15 6 8 N 1 W 3 S 4 N 2 E 2 N 2 E 2 S 3 W ");
			input.close();

			// invoke program, should throw exception
			Robot.readInstructions(INPUT, OUTPUT);
			fail("InvalidRobotInstructionException should be thrown.");
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		} catch (InvalidRobotInstructionException e) {
			// delete I/O files (if they exist)
			assertTrue("Input file was not closed in program.", inputFile.delete());
			if (outputFile.exists()) {
				assertFalse("Output file should not contain text.", outputFile.length() > 0);
				assertTrue("Output file was not closed in program.", outputFile.delete());
			}
		}
	}

	@Test
	public void testExceptionBadAreaZero() {
		INPUT = "input26.txt";
		OUTPUT = "output26.txt";

		File inputFile = new File(INPUT);
		File outputFile = new File(OUTPUT);

		try {
			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("5 0 6 8 N 1 W 3 S 4 N 2 E 2 N 2 E 2 S 3 W 5");
			input.close();

			// invoke program, should throw exception
			Robot.readInstructions(INPUT, OUTPUT);
			fail("InvalidRobotInstructionException should be thrown.");
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		} catch (InvalidRobotInstructionException e) {
			// delete I/O files (if they exist)
			assertTrue("Input file was not closed in program.", inputFile.delete());
			if (outputFile.exists()) {
				assertFalse("Output file should not contain text.", outputFile.length() > 0);
				assertTrue("Output file was not closed in program.", outputFile.delete());
			}
		}
	}

	@Test
	public void testExceptionBadAreaNegative() {
		INPUT = "input27.txt";
		OUTPUT = "output27.txt";

		File inputFile = new File(INPUT);
		File outputFile = new File(OUTPUT);

		try {
			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("-2 3 6 8 N 1 W 3 S 4 N 2 E 2 N 2 E 2 S 3 W 5");
			input.close();

			// invoke program, should throw exception
			Robot.readInstructions(INPUT, OUTPUT);
			fail("InvalidRobotInstructionException should be thrown.");
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		} catch (InvalidRobotInstructionException e) {
			// delete I/O files (if they exist)
			assertTrue("Input file was not closed in program.", inputFile.delete());
			if (outputFile.exists()) {
				assertFalse("Output file should not contain text.", outputFile.length() > 0);
				assertTrue("Output file was not closed in program.", outputFile.delete());
			}
		}
	}

	/*
	 * Testing Correct Instructions on Multiple Lines
	 */

	@Test
	public void testMultiLineOkOKDestroyed() {
		try {
			INPUT = "input28.txt";
			OUTPUT = "output28.txt";

			File inputFile = new File(INPUT);
			File outputFile = new File(OUTPUT);

			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("12 15 6 8 N 1 W 3 S 4 N 2 E 2 N 2 E 2 S 3 W 5");
			input.println("9 7 1 1 S 1 E 1 S 1 E 1 S 1 E 1 S 1 E 1 N 3 W 3");
			input.println("7 6 5 4 N 3 E 1 S 2 W 1 W 3 W 2");
			input.close();

			// invoke program
			Robot.readInstructions(INPUT, OUTPUT);

			// verify OUTPUT file exists and has values
			assertTrue(outputFile.exists());
			Scanner output = new Scanner(outputFile);
			assertTrue("Output file was not closed OR no output was written.", output.hasNext());
			String actual;
			actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "8 4", actual);
			actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "2 2", actual);
			actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "terminated", actual);
			assertFalse("There should not be more data in output file.", output.hasNext());
			output.close();

			// delete I/O files (if they exist)
			inputFile.delete();
			outputFile.delete();
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		}
	}

	@Test
	public void testMultiLineOkDestroyedOk() {
		try {
			INPUT = "input29.txt";
			OUTPUT = "output29.txt";

			File inputFile = new File(INPUT);
			File outputFile = new File(OUTPUT);

			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("12 15 6 8 N 1 W 3 S 4 N 2 E 2 N 2 E 2 S 3 W 4");
			input.println("7 6 5 4 E 1 E 1 E 1 E 1");
			input.println("9 7 1 1 S 1 E 1 S 1 E 1 S 1 E 1 S 1 E 1 N 3 W 3 E 1");
			input.close();

			// invoke program
			Robot.readInstructions(INPUT, OUTPUT);

			// verify OUTPUT file exists and has values
			assertTrue(outputFile.exists());
			Scanner output = new Scanner(outputFile);
			assertTrue("Output file was not closed OR no output was written.", output.hasNext());
			String actual;
			actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "8 5", actual);
			actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "terminated", actual);
			actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "2 3", actual);
			assertFalse("There should not be more data in output file.", output.hasNext());
			output.close();

			// delete I/O files (if they exist)
			inputFile.delete();
			outputFile.delete();
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		}

	}

	@Test
	public void testMultiLineDestroyedOkOk() {
		try {
			INPUT = "input30.txt";
			OUTPUT = "output30.txt";

			File inputFile = new File(INPUT);
			File outputFile = new File(OUTPUT);

			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("7 6 5 4 E 1 E 1 E 1 E 1");
			input.println("12 15 6 8 N 1 W 3 S 4 N 1 E 2 N 2 E 2 S 3 W 4");
			input.println("9 7 1 1 S 1 E 1 S 1 E 1 S 1 E 2 S 1 E 1 N 3 W 3 E 1");
			input.close();

			// invoke program
			Robot.readInstructions(INPUT, OUTPUT);

			// verify OUTPUT file exists and has values
			assertTrue(outputFile.exists());
			Scanner output = new Scanner(outputFile);
			assertTrue("Output file was not closed OR no output was written.", output.hasNext());
			String actual;
			actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "terminated", actual);
			actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "9 5", actual);
			actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "2 4", actual);
			assertFalse("There should not be more data in output file.", output.hasNext());
			output.close();

			// delete I/O files (if they exist)
			inputFile.delete();
			outputFile.delete();
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		}
	}

	@Test
	public void testMultiLineManyTests() {
		try {
			INPUT = "input31.txt";
			OUTPUT = "output31.txt";

			File inputFile = new File(INPUT);
			File outputFile = new File(OUTPUT);

			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("12 15 6 8 N 1 W 3 S 4 N 2 E 2 N 2 E 2 S 3 W 4");
			input.println("7 6 5 4 E 1 E 1 E 1 E 1");
			input.println("9 7 1 1 S 1 E 1 S 1 E 1 S 1 E 1 S 1 E 1 N 3 W 3 E 1");
			input.println("4 5 7 3 S 2 W 5");
			input.println("9 8 3 6 S 2 S 3 N 1");
			input.println("9 12 7 4 E 3 E 2 E 1");
			input.println("10 10 5 5 E 2 N 3 E 1 S 2 W 3 N 2 S 6");
			input.println("7 6 5 4 S 1 W 3 E 2 N 5 N 3");
			input.close();

			// invoke program
			Robot.readInstructions(INPUT, OUTPUT);

			// verify OUTPUT file exists and has values
			assertTrue(outputFile.exists());
			Scanner output = new Scanner(outputFile);
			assertTrue("Output file was not closed OR no output was written.", output.hasNext());
			String actual;
			actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "8 5", actual);
			actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "terminated", actual);
			actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "2 3", actual);
			actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "terminated", actual);
			actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "7 6", actual);
			actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "7 10", actual);
			actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "8 5", actual);
			actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "terminated", actual);
			assertFalse("There should not be more data in output file.", output.hasNext());
			output.close();

			// delete I/O files (if they exist)
			assertTrue("Input file was not closed in program.", inputFile.delete());
			assertTrue(outputFile.delete());

		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		}
	}

	/*
	 * Testing Mixture of Correct and Incorrect Instructions on Multiple Lines
	 */

	@Test
	public void testMultiLineOkDestroyedException() {
		INPUT = "input32.txt";
		OUTPUT = "output32.txt";

		File inputFile = new File(INPUT);
		File outputFile = new File(OUTPUT);

		try {
			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("12 15 6 8 N 1 W 3 S 4 N 2 E 2 N 2 E 2 S 3 W 4");
			input.println("7 6 5 4 E 1 E 1 E 1 E 1");
			input.println("7 ! 5 E 3 4");
			input.close();

			// invoke program, should throw exception
			Robot.readInstructions(INPUT, OUTPUT);
			fail("InvalidRobotInstructionException should be thrown.");
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		} catch (InvalidRobotInstructionException e) {
			// delete I/O files (if they exist)
			assertTrue("Input file was not closed in program.", inputFile.delete());
			try { // outputFile should still contain data from previous correct
					// experiments
				assertTrue(outputFile.exists());
				Scanner output = new Scanner(outputFile);
				assertTrue("Output file was not closed OR no output was written.", output.hasNext());
				String actual;
				actual = output.nextLine();
				assertEquals("Expected value in output file doesn't match.", "8 5", actual);
				actual = output.nextLine();
				assertEquals("Expected value in output file doesn't match.", "terminated", actual);
				assertFalse("There should not be more data in output file.", output.hasNext());
				output.close();
				outputFile.delete();

			} catch (IOException e2) {
				fail("No IOException should be thrown in this Robot scenario.");
			}
		}
	}

	@Test
	public void testMultiLineOkExceptionDestroyed() {
		INPUT = "input33.txt";
		OUTPUT = "output33.txt";

		File inputFile = new File(INPUT);
		File outputFile = new File(OUTPUT);

		try {
			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("12 15 6 8 N 1 W 3 S 4 N 2 E 2 N 2 E 2 S 3 W 4");
			input.println("7 ! 5 E 3 4");
			input.println("7 6 5 4 E 1 E 1 E 1 E 1");
			input.close();

			// invoke program, should throw exception
			Robot.readInstructions(INPUT, OUTPUT);
			fail("InvalidRobotInstructionException should be thrown.");
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		} catch (InvalidRobotInstructionException e) {
			// delete I/O files (if they exist)
			assertTrue("Input file was not closed in program.", inputFile.delete());
			try { // outputFile should still contain data from previous correct
					// experiments
				assertTrue(outputFile.exists());
				Scanner output = new Scanner(outputFile);
				assertTrue("Output file was not closed OR no output was written.", output.hasNext());
				String actual;
				actual = output.nextLine();
				assertEquals("Expected value in output file doesn't match.", "8 5", actual);
				assertFalse("There should not be more data in output file.", output.hasNext());
				output.close();
				outputFile.delete();

			} catch (IOException e2) {
				fail("No IOException should be thrown in this Robot scenario.");
			}
		}
	}

	@Test
	public void testMultiLineExceptionOkDestroyed() {
		INPUT = "input34.txt";
		OUTPUT = "output34.txt";

		File inputFile = new File(INPUT);
		File outputFile = new File(OUTPUT);

		try {
			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("7 ! 5 E 3 4");
			input.println("12 15 6 8 N 1 W 3 S 4 N 2 E 2 N 2 E 2 S 3 W 4");
			input.println("7 6 5 4 E 1 E 1 E 1 E 1");
			input.close();

			// invoke program, should throw exception
			Robot.readInstructions(INPUT, OUTPUT);
			fail("InvalidRobotInstructionException should be thrown.");
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		} catch (InvalidRobotInstructionException e) {
			// delete I/O files (if they exist)
			assertTrue("Input file was not closed in program.", inputFile.delete());
			if (outputFile.exists()) {
				assertFalse("Output file should not contain text.", outputFile.length() > 0);
				assertTrue("Output file was not closed in program.", outputFile.delete());
			}
		}
	}

}
