import java.io.*;

// Class of Pet
public class Pet implements Serializable{
	String Name;   //Name of the Pet
	String Type;   //Type of pet
	int Age;       //Age of Pet
	int Hunger;    //Hunger lvl of Pet
	int Happiness; //Happiness lvl of Pet

	public Pet(
			String Name,
			String Type,
			int Age,
			int Hunger,
			int Happiness
		  ){
			this.Name = Name;           //Name of the Pet
			this.Type = Type;           //Type of pet
			this.Age = Age;             // Age of Pet
			this.Hunger = Hunger;       //Hunger lvl of Pet
			this.Happiness = Happiness; //Happiness lvl of Pet
		  }

	// Methods to get all variables in Class
	public String getName()     {return Name;}
	public String getType()     {return Type;}
	public int    getAge()      {return Age;}
	public int    getHunger()   {return Hunger;}
	public int    getHappiness(){return Happiness;}

	// Method for Getting Stats
	public String getStats(){
		return("\nName: "      + ConsoleColors.PURPLE + this.getName()       + ConsoleColors.RESET +
					   "\nType: "      + ConsoleColors.CYAN   + this.getType()       + ConsoleColors.RESET +
					   "\nAge: "       + ConsoleColors.RED    + this.getAge()        + ConsoleColors.RESET +
					   "\nHunger: "    + LoadingAnim.Bar(this.getHunger())           +
					   "\nHappiness: " + LoadingAnim.Bar(this.getHappiness()));
	}
}