import java.util.*;

// Class of Player
public class Player{
	String Name;         // Name of User
	String Passwd;
	int XpPoints;        // XpPoints of User
	int Level;           // Level of User
	int NumberOfCommands;// NumberOfCommands of User
	boolean HasPet;      // HasPet of User
	boolean HasSetName;  // HasSetName of User
	List<Pet> PetList;   // PetList of the User
	Pet Pet;             // Pet of User

	public Player(
			String Name,
			String Passwd,
			int XpPoints,
			int Level,
			int NumberOfCommands,
			boolean HasPet,
			boolean HasSetName,
			List<Pet> PetList,
			Pet Pet
		     ){
				this.Name = Name;                         //Name of the Player
				this.Passwd = Passwd;                     //Passwd of the Player
				this.XpPoints = XpPoints;                 //XpPoints of Player
				this.Level = Level;                       //Level of Player
				this.NumberOfCommands = NumberOfCommands; //NumberOfCommands of Player
				this.HasPet = HasPet;                     //HasPet
				this.HasSetName = HasSetName;             //HasSet
				this.PetList = PetList;                   // PetList of the User
				this.Pet = Pet;                           //Player.Pet
		     }

	// Methods to get all variables in Class
	public String    getName()             {return Name;}
	public String    getPasswd()           {return Passwd;}
	public int       getXpPoints()         {return XpPoints;}
	public int       getLevel()            {return Level;}
	public int       getNumberOfCommands() {return NumberOfCommands;}
	public boolean   getHasPet()           {return HasPet;}
	public boolean   getHasSetName()       {return HasSetName;}
	public List<Pet> getPetList()          {return PetList;}
	public Pet       getPet()              {return Pet;}


	// Method for Getting Stats
	public String getStats(){
		return("\nPlayerName: "       + ConsoleColors.GREEN  + this.getName()             + ConsoleColors.RESET +
			                 "\nXpPoints: "         + this.getXpPoints() + LoadingAnim.Bar(this.getXpPoints())               +
			                 "\nLevel: "            + ConsoleColors.RED    + this.getLevel()            + ConsoleColors.RESET +
			                 "\nNumberOfCommands: " + ConsoleColors.RED    + this.getNumberOfCommands() + ConsoleColors.RESET +
			                 "\nHasPet: "           + ConsoleColors.RED    + this.getHasPet()           + ConsoleColors.RESET +
			                 "\nHasSetName: "       + ConsoleColors.RED    + this.getHasSetName()       + ConsoleColors.RESET +
			                 "\nPetList: "          + ConsoleColors.RED    + this.getPetList()          + ConsoleColors.RESET +
			                 "\nPlayerPet: "        + ConsoleColors.PURPLE + this.getPet()              + ConsoleColors.RESET);
	}

}