package Homework;

public class Phone{
	private String name;
    Phone(String name) {
        this.name = name;
    }
    public boolean equals(Phone p) {
        if (p == null) 
        	return false;
        return (this.name.equals(p.name));
    }
}
