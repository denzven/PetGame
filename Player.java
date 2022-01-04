import java.util.*;
import java.io.*;

// Class of Player
public class Player implements Serializable{
	private static final long serialVersionUID = 4L;
	String name;         // Name of User
	String passwd;
	int xpPoints;        // XpPoints of User
	int level;           // Level of User
	int numberOfCommands;// NumberOfCommands of User
	boolean hasPet;      // HasPet of User
	boolean hasSetName;  // HasSetName of User
	List<Pet> petList;   // PetList of the User
	Pet pet;             // Pet of User

	public Player(
			String name,
			String passwd,
			int xpPoints,
			int level,
			int numberOfCommands,
			boolean hasPet,
			boolean hasSetName,
			List<Pet> petList,
			Pet pet
		     ){
				this.name = name;                         //Name of the Player
				this.passwd = passwd;                     //Passwd of the Player
				this.xpPoints = xpPoints;                 //XpPoints of Player
				this.level = level;                       //Level of Player
				this.numberOfCommands = numberOfCommands; //NumberOfCommands of Player
				this.hasPet = hasPet;                     //HasPet
				this.hasSetName = hasSetName;             //HasSet
				this.petList = petList;                   // PetList of the User
				this.pet = pet;                           //Player.Pet
		     }

	// Methods to get all variables in Class
	public String    getName()             {return name;}
	public String    getPasswd()           {return passwd;}
	public int       getXpPoints()         {return xpPoints;}
	public int       getLevel()            {return level;}
	public int       getNumberOfCommands() {return numberOfCommands;}
	public boolean   getHasPet()           {return hasPet;}
	public boolean   getHasSetName()       {return hasSetName;}
	public List<Pet> getPetList()          {return petList;}
	public Pet       getPet()              {return pet;}


	// Method for Getting Stats
	public String getStats(){
		return("\nplayerName: "       + ConsoleColors.GREEN  + this.getName()             + ConsoleColors.RESET +
			                 "\nxpPoints: "         + this.getXpPoints() + LoadingAnim.Bar(this.getXpPoints())               +
			                 "\nlevel: "            + ConsoleColors.RED    + this.getLevel()            + ConsoleColors.RESET +
			                 "\nnumberOfCommands: " + ConsoleColors.RED    + this.getNumberOfCommands() + ConsoleColors.RESET +
			                 "\nhasPet: "           + ConsoleColors.RED    + this.getHasPet()           + ConsoleColors.RESET +
			                 "\nhasSetName: "       + ConsoleColors.RED    + this.getHasSetName()       + ConsoleColors.RESET +
			                 "\npetList: "          + ConsoleColors.RED    + this.getPetList()          + ConsoleColors.RESET +
			                 "\nplayerPet: "        + ConsoleColors.PURPLE + this.getPet()              + ConsoleColors.RESET);
	}

}