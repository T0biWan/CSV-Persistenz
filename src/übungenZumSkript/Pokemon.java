package übungenZumSkript;

public class Pokemon {
	//Attribute
	String name;
	int nummer;
	String typ;
	int level;
	
	//Konstruktor
	public Pokemon(String name, int nummer, String typ, int level) {
		setName(name);
		setNummer(nummer);
		setTyp(typ);
		setLevel(level);
	}
	
	public Pokemon() {
	}

	//Setter
	public void setName(String name) {
		this.name = name;
	}
	public void setNummer(int nummer) {
		this.nummer = nummer;
	}
	public void setTyp(String typ) {
		this.typ = typ;
	}
	public void setLevel(int level) {
		this.level = level;
	}


	//Getter
	public String getName() {
		return name;
	}
	public int getNummer() {
		return nummer;
	}
	public String getTyp() {
		return typ;
	}
	public int getLevel() {
		return level;
	}
	
	public String toString() {
		return "Name: " + getName() + "\nNummer: " + getNummer() + "\nTyp: " + getTyp() + "\nLevel: " + getLevel();
	}
}
