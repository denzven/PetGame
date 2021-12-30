// PetGame.java

import java.util.*;

public class PetGame{

	public static void main(String[] args) {

		//intro
		System.out.println("Welcome to PetGame by Denzven! \n This game is made in java and is a starter project of mine! \n Hope you love it!\n\n");
		
		//Default objects of Pet and player
		Pet PlayerPet = new Pet("DEFUALT_PET","DEFAULT_TYPE",0,100,100);
		Player Player = new Player("DEFUALT_PLAYER",0,0,0,false);

		//PlayerInput
		Scanner sc = new Scanner(System.in);
		if (Player.PlayerHasPet == false){
			System.out.println("You dont have a Pet, do you want to buy one?[type 1 for yes]");
			int PlayerInputPet = sc.nextInt();
			
			if(PlayerInputPet == 1){
				System.out.println("What do you want to Name your Pet?");
				String PlayerPetName = sc.next();

				System.out.println("What type of Pet do you want " + PlayerPetName + " to be?");
				String PlayerPetType = sc.next();
				
				PlayerPet = new Pet(PlayerPetName,PlayerPetType,0,100,100);
				Player.PlayerHasPet = true;
			}else{
				System.out.println("idk what to do now... maybe restart?");
				System.exit(0);
			}
		}

		//main while loop
		while(true){
			System.out.println("Enter cmd: ");
			System.out.println(" [stats] [feed] [play] [chngname]");
			String PlayerInput = sc.next();
			Player.NumberOfCommands = Player.NumberOfCommands + 1;
			if(Player.NumberOfCommands % 10 == 0){PlayerPet.PetAge++;}

			switch (PlayerInput) {
			case "stats":
				System.out.println("getting Pet stats...");
				System.out.println(PlayerPet.getStats());
				System.out.println(Player.getStats());
				break;

			case "feed":
				System.out.println("You fed " + PlayerPet.PetName + " some tasty food");

				// Range of Values for getting behaviour
				if(PlayerPet.PetHunger <= 100 && PlayerPet.PetHunger >= 80){
					System.out.println(PlayerPet.PetName + "");
				}
				PlayerPet.PetHunger = PlayerPet.PetHunger + 10;
				System.out.println(PlayerPet.PetHunger);
				break;

			case "play":
				System.out.println("You played catch with " + PlayerPet.PetName);
				PlayerPet.PetHunger = PlayerPet.PetHunger - 10;
				PlayerPet.PetHappiness = PlayerPet.PetHappiness + 10;
				break;

			case "chngname":
				System.out.println("Enter the new name of your Pet: ");
				String PlayerPetName = sc.next();
				PlayerPet.PetName = PlayerPetName;
				System.out.println("Your Pet is now named: " + PlayerPet.PetName);
				break;
			}
		}
	}
}

// Class of Pet
class Pet{
	String PetName; //Name of the Pet
	String PetType; //Type of pet
	int PetAge; // Age of Pet
	int PetHunger; //Hunger lvl of Pet
	int PetHappiness; //Hapiness lvl of Pet

	public Pet(
		String PetName,
		String PetType,
		int PetAge,
		int PetHunger,
		int PetHappiness
	){
		this.PetName = PetName; //Name of the Pet
		this.PetType = PetType; //Type of pet
		this.PetAge = PetAge; // Age of Pet
		this.PetHunger = PetHunger; //Hunger lvl of Pet
		this.PetHappiness = PetHappiness; //Hapiness lvl of Pet
	}

	public String getPetName(){return PetName;}
	public String getPetType(){return PetType;}
	public int getPetAge(){return PetAge;}
	public int getPetHunger(){return PetHunger;}
	public int getPetHappiness(){return PetHappiness;}

	// Method for Getting Stats
	
	public String getStats(){
		String PetStats = "\nPetName: "     + this.getPetName()       + 
						  "\nPetType: "     + this.getPetType()       +
						  "\nPetAge: "      + this.getPetAge()        + 
						  "\nPetHunger: "   + this.getPetHunger()     +
						  "\nPetHappiness: " + this.getPetHappiness(); 
		return(PetStats);
	}
}

// Class of Player
class Player{
	String PlayerName;
	int PlayerAge;
	int PlayerXpPoints;
	int NumberOfCommands;
	boolean PlayerHasPet;

	public Player(
		String PlayerName,
		int PlayerAge,
		int PlayerXpPoints,
		int NumberOfCommands,
		boolean PlayerHasPet

	){
		this.PlayerName = PlayerName; //Name of the Player
		this.PlayerAge = PlayerAge; // Age of Player
		this.PlayerXpPoints = PlayerXpPoints; //XpPoints of Player
		this.NumberOfCommands = NumberOfCommands; //NumberOfCommands of Player
		this.PlayerHasPet = PlayerHasPet; //HasPet
	}

	public String getPlayerName(){return PlayerName;}
	public int getPlayerAge(){return PlayerAge;}
	public int getPlayerXpPoints(){return PlayerXpPoints;}
	public int getNumberOfCommands(){return NumberOfCommands;}
	public boolean getPlayerHasPet(){return PlayerHasPet;}


	// Method for Getting Stats
	public String getStats(){
		String PlayerStats = "\nPlayerName: "       + this.getPlayerName()       + 
						  	 "\nPlayerAge: "        + this.getPlayerAge()        + 
						  	 "\nPlayerXpPoints: "   + this.getPlayerXpPoints()        + 
						  	 "\nNumberOfCommands: " + this.getNumberOfCommands()        + 
						  	 "\nPlayerHasPet: "     + this.getPlayerHasPet(); 
		return(PlayerStats);
	}
}