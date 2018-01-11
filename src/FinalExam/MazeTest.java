package FinalExam;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class MazeTest {

    @Test
    public void testMaze1() {
    	char maze[][] = new char[][] 
    			{
    			{'X', ' ', 'X', ' ', ' '},
    			{'X', 'X', 'X', ' ', 'X'},
    			{' ', ' ', ' ', ' ', 'X'},
    			{' ', 'X', ' ', 'X', 'X'},
    			{'X', 'X', ' ', 'X', 'X'},
    			};
    	assertTrue(Maze.isTraversable(maze));
    }
    
    @Test
    public void testMaze2() {
    	char maze[][] = new char[][] 
    			{
    			{'X', ' ', ' ', ' ', ' '},
    			{'X', 'X', 'X', 'X', 'X'},
    			{' ', ' ', ' ', ' ', 'X'},
    			{' ', 'X', ' ', 'X', 'X'},
    			{'X', 'X', ' ', 'X', 'X'},
    			};
    	assertFalse(Maze.isTraversable(maze));
    }
   
    @Test
    public void testMaze3() {
    	char maze[][] = new char[][] 
    			{
    			{' ', ' ', ' ', ' ', ' '},
    			{' ', ' ', ' ', ' ', ' '},
    			{' ', ' ', ' ', ' ', ' '},
    			{' ', ' ', ' ', ' ', ' '},
    			{' ', ' ', ' ', ' ', ' '},
    			};
    	assertTrue(Maze.isTraversable(maze));
    }
    
    @Test
    public void testMaze4() {
    	char maze[][] = new char[][] 
    			{
    			{'X', 'X', 'X', 'X', 'X'},
    			{'X', 'X', 'X', 'X', 'X'},
    			{'X', 'X', 'X', 'X', 'X'},
    			{'X', 'X', 'X', 'X', 'X'},
    			{'X', 'X', 'X', 'X', 'X'},
    			};
    	assertFalse(Maze.isTraversable(maze));
    }
    
    @Test
    public void testMaze5() {
    	char maze[][] = new char[][] 
    			{
    			{'X', 'X', 'X', 'X', ' '},
    			{'X', ' ', ' ', ' ', 'X'},
    			{' ', ' ', 'X', ' ', 'X'},
    			{'X', 'X', ' ', ' ', ' '},
    			{'X', 'X', 'X', 'X', ' '},
    			};
    	assertTrue(Maze.isTraversable(maze));
    }
    
    @Test
    public void testMaze6() {
    	char maze[][] = new char[][] 
    			{
    			{' ', ' ', 'X', ' ', ' '},
    			{' ', ' ', 'X', ' ', ' '},
    			{' ', ' ', 'X', ' ', ' '},
    			{' ', ' ', 'X', ' ', ' '},
    			{' ', ' ', 'X', ' ', ' '},
    			};
    	assertFalse(Maze.isTraversable(maze));
    }
    
    @Test
    public void testMaze7() {
    	char maze[][] = new char[][] 
    			{
    			{'X', 'X', 'X', ' ', ' '},
    			{'X', 'X', ' ', ' ', 'X'},
    			{' ', ' ', 'X', ' ', 'X'},
    			{'X', ' ', 'X', ' ', 'X'},
    			{'X', ' ', ' ', ' ', 'X'},
    			};
    	assertTrue(Maze.isTraversable(maze));
    }
    
    @Test
    public void testMaze8() {
    	char maze[][] = new char[][] 
    			{
    			{' ', ' ', 'X', ' ', ' '},
    			{' ', 'X', ' ', ' ', ' '},
    			{' ', ' ', 'X', ' ', ' '},
    			{' ', ' ', ' ', 'X', ' '},
    			{' ', ' ', 'X', ' ', ' '},
    			};
    	assertFalse(Maze.isTraversable(maze));
    }
    

}