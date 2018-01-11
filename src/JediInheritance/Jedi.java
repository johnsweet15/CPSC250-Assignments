package JediInheritance;

public class Jedi extends Resistance implements Force{

	private int force;
	private Lightsaber lightsaber;
	
	public Jedi(String name, Lightsaber lightsaber){
		super(name);
		this.lightsaber = lightsaber;
		force = 10;
	}
	
	public int getForce(){
		return force;
	}
	
	public void setForce(int force){
		if(force > 0)
			this.force = force;
	}
	
	public Lightsaber getLightsaber(){
		return lightsaber;
	}
	
	public boolean equals(Object other){
		if(other instanceof Jedi){
			Jedi jedi = (Jedi)other;
			String name = jedi.getName();
			int force = jedi.getForce();
			Lightsaber lightsaber = jedi.getLightsaber();
			
			if(this.getName().equals(name) && this.force == force && this.lightsaber.equals(lightsaber))
				return true;
		}
		return false;
	}

	@Override
	public int compareTo(Object other) {
		Jedi jedi = (Jedi)other;
		int force = jedi.getForce();
		return (this.force - force);
	}

}
