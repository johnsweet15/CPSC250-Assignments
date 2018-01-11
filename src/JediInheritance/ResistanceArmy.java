package JediInheritance;

import java.util.ArrayList;

public class ResistanceArmy {

	ArrayList<Resistance> list;
	
	public ResistanceArmy(){
		list = new ArrayList<Resistance>();
	}
	
	public void addSoldier(Resistance member){
		list.add(member);
	}
	
	public ArrayList<Resistance> getArmy(){
		return list;
	}
	
}
