package FinalExam;

public class RockBand {
	
	private String name;
	private RockGenre genre;

	public RockBand(String name, RockGenre genre){
		this.name = name;
		this.genre = genre;
	}
	
	public String getName(){
		return this.name;
	}
	
	public RockGenre getGenre(){
		return this.genre;
	}
	
}
