package JediInheritance;

public class Trooper extends Resistance{
	
	private Blaster blaster;
	
	public Trooper(String name){
		super(name);
		blaster = new Blaster(25);
	}
	
	public Trooper(String name, Blaster blaster){
		super(name);
		this.blaster = blaster;
	}
	
	public Blaster getBlaster(){
		return blaster;
	}
	
	@Override
	public boolean equals(Object other){
		if(other instanceof Trooper){
			Trooper trooper = (Trooper)other;
			String name = trooper.getName();
			Blaster blaster = trooper.getBlaster();
			
			if(this.getName().equals(name) && this.getBlaster().equals(blaster))
				return true;
		}
		return false;
	}
	
}
