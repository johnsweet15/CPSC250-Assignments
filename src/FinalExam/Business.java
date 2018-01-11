package FinalExam;

public class Business extends Room{

	public Business(int number, int price){
		super(number, price);
	}
	
	@Override
	public boolean equals(Object other){
		if(other instanceof Business){
			Business room = (Business)other;
			
			if(this.getNumber() == room.getNumber())
				return true;
		}
		return false;
	}
	
	@Override
	public String toString(){
		return "Room #" + getNumber() + " $" + getPrice() + " [Business]";
	}
	
}
