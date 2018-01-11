package FinalExam;

public class Maze {
	
	public static boolean isTraversable(char[][] maze){
		for(int i = 0; i < maze[0].length; i++){
			for(int j = 0; j < maze.length; j++){
				if(i == 0 && maze[j][i] == ' '){
					maze[j][i] = '+';
				}
				if(i > 0 && maze[j][i] == ' ' && maze[j][i - 1] == '+'){
					maze[j][i] = '+';
					if(maze[j + 1][i] == '+' && j < maze.length - 1)
						maze[j + 1][i] = '+';
					if(maze[j - 1][i] == '+'&& j > 0)
						maze[j - 1][i] = '+';
				}
				if(maze[j][0] == '+')
					return true;
			}
		}
		return false;
	}

}
