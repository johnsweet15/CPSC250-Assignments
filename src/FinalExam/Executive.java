package FinalExam;

public class Executive extends Room{

	public Executive(int number, int price){
		super(number, price);
	}
	
	@Override
	public boolean equals(Object other){
		if(other instanceof Executive){
			Executive room = (Executive)other;
			
			if(this.getNumber() == room.getNumber())
				return true;
		}
		return false;
	}
	
	@Override
	public String toString(){
		return "Room #" + getNumber() + " $" + getPrice() + " [Executive]";
	}
	
	
}
