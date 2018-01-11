package JediInheritance;

public abstract class Weapon {
	
	private int strength;
	
	public Weapon(int strength){
		this.strength = strength;
	}
	
	public int getStrength(){
		return strength;
	}
	
	public void changeStrength(int change){
		strength += change;
		if(strength < 0)
			strength = 0;
	}
	
	@Override
	public boolean equals(Object other){
		if(other instanceof Weapon){
			Weapon weapon = (Weapon)other;
			int strength = weapon.getStrength();
			
			if(this.strength == strength)
				return true;
		}
		return false;
	}
}
