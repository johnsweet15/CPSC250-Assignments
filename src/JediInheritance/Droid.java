package JediInheritance;

public class Droid extends Resistance{

	public Droid(String name){
		super(name);
	}
	
	@Override
	public boolean equals(Object other){
		if(other instanceof Droid){
			Droid droid = (Droid)other;
			String name = droid.getName();
			
			if(this.getName().equals((name)))
				return true;
		}
		return false;
	}
	
}
