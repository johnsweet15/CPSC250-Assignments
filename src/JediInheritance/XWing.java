package JediInheritance;

public class XWing extends Weapon{

	public XWing(int strength){
		super(strength);
	}
	
	public boolean equals(Object other){
		if(other instanceof XWing){
			XWing xwing = (XWing)other;
			int strength = xwing.getStrength();
			
			if(this.getStrength() == strength)
				return true;
		}
		return false;
	}
}
