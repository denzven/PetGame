import java.io.*;

// Class of Pet
public class Pet implements Serializable{
	private static final long serialVersionUID = 4L;
	String name;   //Name of the Pet
	String type;   //Type of pet
	int age;       //Age of Pet
	int hunger;    //Hunger lvl of Pet
	int happiness; //Happiness lvl of Pet

	public Pet(
			String name,
			String type,
			int age,
			int hunger,
			int happiness
		  ){
			this.name = name;           //Name of the Pet
			this.type = type;           //Type of pet
			this.age = age;             // Age of Pet
			this.hunger = hunger;       //Hunger lvl of Pet
			this.happiness = happiness; //Happiness lvl of Pet
		  }

	// Methods to get all variables in Class
	public String getName()     {return name;}
	public String getType()     {return type;}
	public int    getAge()      {return age;}
	public int    getHunger()   {return hunger;}
	public int    getHappiness(){return happiness;}

	// Method for Getting Stats
	public String getStats(){
		return("\nname: "      + ConsoleColors.PURPLE + this.getName()       + ConsoleColors.RESET +
					   "\ntype: "      + ConsoleColors.CYAN   + this.getType()       + ConsoleColors.RESET +
					   "\nage: "       + ConsoleColors.RED    + this.getAge()        + ConsoleColors.RESET +
					   "\nhunger: "    + LoadingAnim.Bar(this.getHunger())           +
					   "\nhappiness: " + LoadingAnim.Bar(this.getHappiness()));
	}
}