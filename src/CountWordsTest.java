

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.Test;

public class CountWordsTest {
    private static final String INPUT = "input.txt";
    private static final String OUTPUT = "output.txt";

    @Test
    public void testOneWord() {
        try {
            File inputFile = new File(INPUT);
            File outputFile = new File(OUTPUT);

            // If assert fails it is (usually) because the file was (wrongly)
            // left open in an earlier run.
            // Using a file manager application (e.g. explorer), go to project
            // directory and delete it.
            // Make sure that your program closes these files before ending.
            if (inputFile.exists()) {
                assertTrue("Your program left \"" + INPUT
                        + "\" open in a previous test.", inputFile.delete());
            }
            if (outputFile.exists()) {
                assertTrue("Your program left \"" + OUTPUT
                        + "\" open in a previous test.", outputFile.delete());
            }

            // create INPUT file
            PrintWriter input = new PrintWriter(inputFile);
            input.println("fiSH");
            input.close();

            // invoke program
            CountWords.main(null);

            // verify OUTPUT file exists and is empty
            assertTrue("Output file doesn't exist", outputFile.exists());
            Scanner output = new Scanner(outputFile);
            String actual;
            actual = output.nextLine();
            assertEquals("Incorrect result", "  1 words total:", actual);
            actual = output.nextLine();
            assertEquals("Incorrect result", "fish", actual);
            assertFalse("There should be no more data", output.hasNext());
            output.close();

            // delete I/O files
            assertTrue("Input file could not be deleted", inputFile.delete());
            assertTrue("Output file could not be deleted", outputFile.delete());
        } catch (IOException e) {
            fail("No exception should be thrown");
        }

    }

    @Test
    public void testTwoWords() {
        try {
            File inputFile = new File(INPUT);
            File outputFile = new File(OUTPUT);
    
            // If assert fails it is (usually) because the file was (wrongly)
            // left open in an earlier run.
            // Using a file manager application (e.g. explorer), go to project
            // directory and delete it.
            // Make sure that your program closes these files before ending.
            if (inputFile.exists()) {
                assertTrue("Your program left \"" + INPUT
                        + "\" open in a previous test.", inputFile.delete());
            }
            if (outputFile.exists()) {
                assertTrue("Your program left \"" + OUTPUT
                        + "\" open in a previous test.", outputFile.delete());
            }
    
            // create INPUT file
            PrintWriter input = new PrintWriter(inputFile);
            input.println("King");
            input.println("");
            input.println("");
            input.println("");
            input.println("hill");
            input.close();
    
            // invoke program
            CountWords.main(null);
    
            // verify OUTPUT file exists and is empty
            assertTrue("Output file doesn't exist", outputFile.exists());
            Scanner output = new Scanner(outputFile);
            String actual;
            actual = output.nextLine();
            assertEquals("Incorrect result", "  2 words total:", actual);
            actual = output.nextLine();
            assertEquals("Incorrect result", "hill", actual);
            actual = output.nextLine();
            assertEquals("Incorrect result", "king", actual);
            assertFalse("There should be no more data", output.hasNext());
            output.close();
    
            // delete I/O files
            assertTrue("Input file could not be deleted", inputFile.delete());
            assertTrue("Output file could not be deleted", outputFile.delete());
        } catch (IOException e) {
            fail("No exception should be thrown");
        }
    
    }

    @Test
    public void testManyWords() {
        try {
            File inputFile = new File(INPUT);
            File outputFile = new File(OUTPUT);
    
            // If assert fails it is (usually) because the file was (wrongly)
            // left open in an earlier run.
            // Using a file manager application (e.g. explorer), go to project
            // directory and delete it.
            // Make sure that your program closes these files before ending.
            if (inputFile.exists()) {
                assertTrue("Your program left \"" + INPUT
                        + "\" open in a previous test.", inputFile.delete());
            }
            if (outputFile.exists()) {
                assertTrue("Your program left \"" + OUTPUT
                        + "\" open in a previous test.", outputFile.delete());
            }
    
            // create INPUT file
            PrintWriter input = new PrintWriter(inputFile);
            input.println("ONE FISH");
            input.println("two fish");
            input.println("red fish");
            input.println("blue");
            input.println("fish");
            input.println("Hop on pop");
            input.println("STOP");
            input.println("Do NOT hop on pop");
            input.close();
    
            // invoke program
            CountWords.main(null);
    
            // verify OUTPUT file exists and is empty
            assertTrue("Output file doesn't exist", outputFile.exists());
            Scanner output = new Scanner(outputFile);
            String actual;
            actual = output.nextLine();
            assertEquals("Incorrect result", " 11 words total:", actual);
            actual = output.nextLine();
            assertEquals("Incorrect result", "blue", actual);
            actual = output.nextLine();
            assertEquals("Incorrect result", "do", actual);
            actual = output.nextLine();
            assertEquals("Incorrect result", "fish", actual);
            actual = output.nextLine();
            assertEquals("Incorrect result", "hop", actual);
            actual = output.nextLine();
            assertEquals("Incorrect result", "not", actual);
            actual = output.nextLine();
            assertEquals("Incorrect result", "on", actual);
            actual = output.nextLine();
            assertEquals("Incorrect result", "one", actual);
            actual = output.nextLine();
            assertEquals("Incorrect result", "pop", actual);
            actual = output.nextLine();
            assertEquals("Incorrect result", "red", actual);
            actual = output.nextLine();
            assertEquals("Incorrect result", "stop", actual);
            actual = output.nextLine();
            assertEquals("Incorrect result", "two", actual);
            assertFalse("There should be no more data", output.hasNext());
            output.close();
    
            // delete I/O files
            assertTrue("Input file could not be deleted", inputFile.delete());
            assertTrue("Output file could not be deleted", outputFile.delete());
        } catch (IOException e) {
            fail("No exception should be thrown");
        }
    
    }

    
}