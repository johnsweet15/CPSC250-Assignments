package FinalExam;

public enum RockGenre {
	ALTERNATIVE, 
	GRUNGE, 
	POP, 
	EMO;
	
	@Override
	  public String toString() {
	    switch(this) {
	      case ALTERNATIVE: return "alternative";
	      case GRUNGE: return "grunge";
	      case POP: return "pop";
	      case EMO: return "emo";
	      default: throw new IllegalArgumentException();
	    }
	  }

}
