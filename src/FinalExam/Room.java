package FinalExam;

public class Room {

	private int number;
	private int price;
	
	public Room(int number, int price){
		this.number = number;
		this.price = price;
	}
	
	public int getNumber(){
		return this.number;
	}
	
	
	public int getPrice(){
		return this.price;
	}
	
	public boolean equals(Object other){
		if(other instanceof Room){
			Room room = (Room)other;
			
			if(this.getNumber() == room.getNumber())
				return true;
		}
		return false;
	}
	
	@Override
	public String toString(){
		return "Room #" + getNumber() + " $" + getPrice();
	}
	
	public	static	void	main(String[]	args)	{
		Object	a	=	new	Room						(	1,	55	);
		Object	b	=	new	Business		(	4,	90	);
		Object	c	=	new	Executive(	3,	110	);
		System.out.println(	a	);
		System.out.println( b	);
		System.out.println(	c	);
		}
}
