/*
 * @author John Sweet with help from Nick Mojica
 */

package GameOfLife;

public class GameOfLife {
	
	private boolean[][] grid;
	private int time;
	
	public GameOfLife(){
		grid = new boolean[10][10];
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				grid[i][j] = false;
			}
		}
		time = 0;
	}
	
	public GameOfLife(int rows, int cols){
		if(rows <= 0)
			rows = 10;
		if(cols <= 0)
			cols = 10;
		grid = new boolean[rows][cols];
		
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				grid[i][j] = false;
			}
		}
		time = 0;
	}
	
	public boolean[][] getGrid(){
		boolean[][] newGrid = new boolean[grid.length][grid[0].length];
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				newGrid[i][j] = grid[i][j];
			}
		}
		return newGrid;
	}
	
	public int getTime(){
		return time;
	}
	
	public void simpleSetUp(int[][] array){
		if(time == 0){
			for(int i = 0; i < array.length; i++){
				int a = array[i][0];
				int b = array[i][1];
				if(a < 0 || a > grid.length || b < 0 || b > grid[i].length) {
					array[i] = null;
				}
				else
					grid[array[i][0]][array[i][1]] = true;
			}
		}
	}
	public void clearGrid(){
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				grid[i][j] = false;
			}
		}
		time = 0;
	}
	
	public int searchGrid(boolean[][] grid, int rows, int cols){
		int count = 0;
		if(rows > 0 && rows < grid.length && cols > 0 && cols < grid[rows].length && grid[rows - 1][cols - 1] == true)
			count++;
		if(rows > 0 && rows < grid.length && cols > 0 && cols < grid[rows].length && grid[rows - 1][cols] == true)
			count++;
		if(rows > 0 && rows < grid.length && cols > 0 && cols < grid[rows].length - 1 && grid[rows - 1][cols + 1] == true)
			count++;
		if(rows > 0 && rows < grid.length - 1 && cols > 0 && cols < grid[rows].length && grid[rows + 1][cols] == true)
			count++;
		if(rows > 0 && rows < grid.length - 1 && cols > 0 && cols < grid[rows].length && grid[rows + 1][cols - 1] == true)
			count++;
		if(rows > 0 && rows < grid.length - 1 && cols > 0 && cols < grid[rows].length - 1 && grid[rows + 1][cols + 1] == true)
			count++;
		if(rows > 0 && rows < grid.length && cols > 0 && cols < grid[rows].length - 1 && grid[rows][cols + 1] == true)
			count++;
		if(rows > 0 && rows < grid.length && cols > 0 && cols < grid[rows].length && grid[rows][cols - 1] == true)
			count++;
		return count;
	}
	
	public void runRound(){
		boolean[][] temp = getGrid();
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				if(grid[i][j] == true){
					if(searchGrid(grid, i, j) == 0 || searchGrid(grid, i, j) == 1)
						temp[i][j] = false;
					if(searchGrid(grid, i, j) >= 4)
						temp[i][j] = false;
					if(searchGrid(grid, i, j) == 2 || searchGrid(grid, i, j) == 3)
						temp[i][j] = true;
				}
				if(grid[i][j] == false){
					if(searchGrid(grid, i, j) == 3)
						temp[i][j] = true;
				}
			}
		}
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				grid[i][j] = temp[i][j];
			}
		}
		time++;
	}
	
	public void runGame(int x){
		for(int i = 1; i <= x; i++)
			runRound();
	}
}
