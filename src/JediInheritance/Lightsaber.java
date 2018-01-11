package JediInheritance;

public class Lightsaber extends Weapon implements Force{

	private int force;
	
	public Lightsaber(int strength, int force){
		super(strength);
		this.force = force;
	}
	
	@Override
	public int getForce() {
		return force;
	}
	
	@Override
	public boolean equals(Object other){
		if(other instanceof Lightsaber){
			Lightsaber lightsaber = (Lightsaber)other;
			int force = lightsaber.getForce();
			int strength = lightsaber.getStrength();
			
			if(this.force == force && this.getStrength() == (strength))
				return true;
		}
		return false;
	}

	@Override
	public int compareTo(Object other) {
		Lightsaber lightsaber = (Lightsaber)other;
		int force = lightsaber.getForce();
		return (this.force - force);
	}
	
}
