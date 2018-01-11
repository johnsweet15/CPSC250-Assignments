package JediInheritance;

public class Resistance {

	private String name;
	
	public Resistance(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	@Override
	public boolean equals(Object other){
		if(other instanceof Resistance){
			Resistance resistance = (Resistance)other;
			String name = resistance.getName();
			
			if(this.name.equals(name))
				return true;
		}
		return false;
	}
	
}
