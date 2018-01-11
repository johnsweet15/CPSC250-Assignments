package JediInheritance;

public class Blaster extends Weapon{

	public Blaster(int strength){
		super(strength);
	}
	
	public boolean equals(Object other){
		if(other instanceof Blaster){
			Blaster blaster = (Blaster)other;
			int strength = blaster.getStrength();
			
			if(this.getStrength() == strength)
				return true;
		}
		return false;
	}
}
