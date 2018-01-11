package JediInheritance;

public class Pilot extends Trooper{
	
	private XWing xwing;
	
	public Pilot(String name, XWing xwing){
		super(name);
		this.xwing = xwing;
	}
	
	public XWing getXWing(){
		return this.xwing;
	}
	
	public boolean equals(Object other){
		if(other instanceof Pilot){
			Pilot pilot = (Pilot)other;
			String name = pilot.getName();
			Blaster blaster = pilot.getBlaster();
			XWing xwing = pilot.getXWing();
			
			if(this.getName().equals(name) && this.getBlaster().equals(blaster) && this.xwing.equals(xwing))
				return true;
		}
		return false;
	}

}
