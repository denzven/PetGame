// PetGame.java
/**
 * @author Denzven
 */
import java.util.*;

// Main Game class
public class PetGame{

	public static void main(String[] args) {

		//Intro String
		System.out.println("Welcome to PetGame by Denzven! \n This game is made in java and is a starter project of mine! \n Hope you love it!\n\n");

		//Default objects of Pet and player
		Pet PlayerPet = new Pet("DEFUALT_PET","DEFAULT_TYPE",0,100,100);
		Player Player = new Player("DEFUALT_PLAYER",0,0,false,false);

		//PlayerInput
		Scanner sc = new Scanner(System.in);

		// Setting Player Name
		if (Player.PlayerHasSetName == false){
			System.out.println("Enter your Name: ");
			String PlayerName = sc.next();
			Player = new Player(PlayerName,0,0,false,false);
			System.out.println(Player.PlayerName + ", good to see you here!");
			}

		// Adopting a Pet
		if (Player.PlayerHasPet == false){
			System.out.println("You dont have a Pet, Do you want to buy one? [type 1 for yes]");
			int PlayerInputPet = sc.nextInt();

			if(PlayerInputPet == 1){
				System.out.println("What do you want to Name your New Pet?");
				String PlayerPetName = sc.next();

				System.out.println("What type of Pet do you want? [Dog,Cat,Dragon any] " + PlayerPetName + " to be?");
				String PlayerPetType = sc.next();

				PlayerPet = new Pet(PlayerPetName,PlayerPetType,0,100,100);
				Player.PlayerHasPet = true;
			} else {
				System.out.println("idk what to do now... maybe restart?");
				System.exit(0);
			}
		}


		//Main while loop
		while(true){
			System.out.println("Enter cmd: ");
			System.out.println("1[stats] 2[feed] 3[play] 4[sleep] 5[chngname] 0[help] x[exit]");
			String PlayerInput = sc.next();

			//Counts the Number of Commands and gets the Age of Pet with it
			Player.NumberOfCommands = Player.NumberOfCommands + 1;
			if(Player.NumberOfCommands % 20 == 0){PlayerPet.PetAge++;}

			// Switch for the commands
			switch (PlayerInput.toLowerCase()) {

				// Stats of User and Player
				case "stats":
				case "1":
					System.out.println("Getting Pet & Player stats...\n");
					System.out.println(PlayerPet.getStats());
					System.out.println(Player.getStats());
					System.out.println("\n\n");

					break;

				// Feed Command
				case "feed":
				case "2":
					System.out.println("You fed " + PlayerPet.PetName + " some tasty food");

					// Range of Values for getting behaviour
					if(PlayerPet.PetHunger <= 100 && PlayerPet.PetHunger > 80){
						System.out.println(PlayerPet.PetName + " is too full! it wants to Sleep!");
					}
					else if(PlayerPet.PetHunger <= 80 && PlayerPet.PetHunger > 60){
						System.out.println(PlayerPet.PetName + " is not very hungry! it wants to play!");
					}
					else if(PlayerPet.PetHunger <= 60 && PlayerPet.PetHunger > 40){
						System.out.println(PlayerPet.PetName + " was pretty hungry!");
						PlayerPet.PetHunger = PlayerPet.PetHunger + 10;
					}
					else if(PlayerPet.PetHunger <= 40 && PlayerPet.PetHunger > 20){
						System.out.println(PlayerPet.PetName + " was famished! it ate all the food!");
						PlayerPet.PetHunger = PlayerPet.PetHunger + 20;
					}
					else if(PlayerPet.PetHunger < 20){
						System.out.println(PlayerPet.PetName + " was starving! it ate it all!");
						PlayerPet.PetHunger = PlayerPet.PetHunger + 20;
					}else{
						System.out.println("Error Ocurred");
					}

					//Xp points
					Player.PlayerXpPoints = Player.PlayerXpPoints + 10;
					break;

				//Play Command
				case "play":
				case "3":
					System.out.println("You played catch with " + PlayerPet.PetName);

					// Range of Values for getting behaviour
					if(PlayerPet.PetHappiness <= 100 && PlayerPet.PetHappiness > 80){
						System.out.println(PlayerPet.PetName + " has played and had fun already! it wants to Sleep!");
					}
					else if(PlayerPet.PetHappiness <= 80 && PlayerPet.PetHappiness > 60){
						System.out.println(PlayerPet.PetName + " was not very bored... but had fun!");
						PlayerPet.PetHappiness = PlayerPet.PetHappiness + 3;

					}
					else if(PlayerPet.PetHappiness <= 60 && PlayerPet.PetHappiness > 40){
						System.out.println(PlayerPet.PetName + " was pretty bored! now its lively and happy!");
						PlayerPet.PetHappiness = PlayerPet.PetHappiness + 10;
					}
					else if(PlayerPet.PetHappiness <= 40 && PlayerPet.PetHappiness > 20){
						System.out.println(PlayerPet.PetName + " was extremly bored! it wants to play more!!");
						PlayerPet.PetHappiness = PlayerPet.PetHappiness + 20;
					}
					else if(PlayerPet.PetHappiness < 20){
						System.out.println(PlayerPet.PetName + " was bored to death! good that it didnt run away!");
						PlayerPet.PetHunger = PlayerPet.PetHunger + 20;
					}else{
						System.out.println("Error Ocurred");
					}


					//Xp points
					Player.PlayerXpPoints = Player.PlayerXpPoints + 10;

					break;

				//Sleep Command
				case "sleep":
				case "4":
					System.out.println(PlayerPet.PetName + " had a long peaceful sleep!");
					PlayerPet.PetHappiness = 10;
					PlayerPet.PetHunger = 10;
					Player.PlayerXpPoints = Player.PlayerXpPoints + 10;

					break;

				// Change name command
				case "chngname":
				case "5":
					System.out.println("Enter the new name of your Pet: ");
					String PlayerPetName = sc.next();
					PlayerPet.PetName = PlayerPetName;
					System.out.println("Your Pet is now named: " + PlayerPet.PetName);

					break;

				case "help":
				case "0":
					System.out.println("The Help Command isn't ready yet");

					break;

				case "exit":
				case "x":
					System.out.println("Sad to see you go :(");
					System.out.println("Star the repo if you loved this program!");
					System.exit(0);

					break;

			}
		}
	}
}

// Class of Pet
class Pet{
	String PetName;   //Name of the Pet
	String PetType;   //Type of pet
	int PetAge;       //Age of Pet
	int PetHunger;    //Hunger lvl of Pet
	int PetHappiness; //Hapiness lvl of Pet

	public Pet(
			String PetName,
			String PetType,
			int PetAge,
			int PetHunger,
			int PetHappiness
		  ){
			this.PetName = PetName;           //Name of the Pet
			this.PetType = PetType;           //Type of pet
			this.PetAge = PetAge;             // Age of Pet
			this.PetHunger = PetHunger;       //Hunger lvl of Pet
			this.PetHappiness = PetHappiness; //Hapiness lvl of Pet
		  }

	// Methods to get all variables in Class
	public String getPetName(){return PetName;}
	public String getPetType(){return PetType;}
	public int getPetAge(){return PetAge;}
	public int getPetHunger(){return PetHunger;}
	public int getPetHappiness(){return PetHappiness;}

	// Method for Getting Stats
	public String getStats(){
		String PetStats = "\nPetName: "      + this.getPetName()       +
						  "\nPetType: "      + this.getPetType()       +
						  "\nPetAge: "       + this.getPetAge()        +
						  "\nPetHunger: "    + this.getPetHunger()     +
						  "\nPetHappiness: " + this.getPetHappiness();
		return(PetStats);
	}
}

// Class of Player
class Player{
	String PlayerName;    // Name of User
	int PlayerXpPoints;   // XpPoints of User
	int NumberOfCommands; // NumberOfCommands of User
	boolean PlayerHasPet; // HasPet of User
	boolean PlayerHasSetName; // HasSetName of User

	public Player(
			String PlayerName,
			int PlayerXpPoints,
			int NumberOfCommands,
			boolean PlayerHasPet,
			boolean PlayerHasSetName

		     ){
				this.PlayerName = PlayerName;             //Name of the Player
				this.PlayerXpPoints = PlayerXpPoints;     //XpPoints of Player
				this.NumberOfCommands = NumberOfCommands; //NumberOfCommands of Player
				this.PlayerHasPet = PlayerHasPet;         //HasPet
				this.PlayerHasPet = PlayerHasSetName;         //HasSet
		     }

	// Methods to get all variables in Class
	public String getPlayerName(){return PlayerName;}
	public int getPlayerXpPoints(){return PlayerXpPoints;}
	public int getNumberOfCommands(){return NumberOfCommands;}
	public boolean getPlayerHasPet(){return PlayerHasPet;}
	public boolean getPlayerHasSetName(){return PlayerHasSetName;}


	// Method for Getting Stats
	public String getStats(){
		String PlayerStats = "\nPlayerName: "       + this.getPlayerName()       +
			                 "\nPlayerXpPoints: "   + this.getPlayerXpPoints()   +
			                 "\nNumberOfCommands: " + this.getNumberOfCommands() +
			                 "\nPlayerHasPet: "     + this.getPlayerHasPet()     +
			                 "\nPlayerHasPet: "     + this.getPlayerHasSetName();
		return(PlayerStats);
	}
}