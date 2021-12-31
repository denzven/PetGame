// Class of Player
public class Player{
	String Name;    // Name of User
	int XpPoints;   // XpPoints of User
	int NumberOfCommands; // NumberOfCommands of User
	boolean HasPet; // HasPet of User
	boolean HasSetName; // HasSetName of User
	Pet Pet;              // Pet of User

	public Player(
			String Name,
			int XpPoints,
			int NumberOfCommands,
			boolean HasPet,
			boolean HasSetName,
			Pet Pet
		     ){
				this.Name = Name;             //Name of the Player
				this.XpPoints = XpPoints;     //XpPoints of Player
				this.NumberOfCommands = NumberOfCommands; //NumberOfCommands of Player
				this.HasPet = HasPet;         //HasPet
				this.HasPet = HasSetName;     //HasSet
				this.Pet = Pet;                           //Player.Pet
		     }

	// Methods to get all variables in Class
	public String getName(){return Name;}
	public int getXpPoints(){return XpPoints;}
	public int getNumberOfCommands(){return NumberOfCommands;}
	public boolean getHasPet(){return HasPet;}
	public boolean getHasSetName(){return HasSetName;}
	public Pet getPet(){return Pet;}


	// Method for Getting Stats
	public String getStats(){
		String PlayerStats = "\nPlayerName: "       + this.getName()       +
			                 "\nXpPoints: "         + this.getXpPoints()   +
			                 "\nNumberOfCommands: " + this.getNumberOfCommands() +
			                 "\nHasPet: "           + this.getHasPet()     +
			                 "\nHasSetName: "           + this.getHasSetName() +
			                 "\nPlayerPet: "        + this.getPet();
		return(PlayerStats);
	}
}