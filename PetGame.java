// PetGame.java
/**
 * @author Denzven
 */
import java.util.*;

// Main Game class
public class PetGame{
	public static void main(String[] args) {

		//Intro String
		System.out.println(ConsoleColors.CYAN + "Welcome to PetGame by Denzven! \n This game is made in java and is a starter project of mine! \n Hope you love it!\n\n" + ConsoleColors.RESET);

		//Default objects of Pet and player
		List<Pet> PetList = new ArrayList<>();
		List<Player> PlayerList = new ArrayList<>();
		Pet Pet = new Pet("DEFAULT_PET","DEFAULT_TYPE",0,100,100);
		Player Player = new Player("DEFAULT_PLAYER","DEFAULT_PASSWD",0,0,0,false,false,PetList,Pet);
		Game Game = new Game(PlayerList);


		//Main while loop
		while(true){
			//PlayerInput
			Scanner sc = new Scanner(System.in);

			// Setting Player Name
			if (!Player.HasSetName){
				System.out.println(ConsoleColors.GREEN + "Enter your Name: " + ConsoleColors.RESET);
				String Name = sc.nextLine();
				System.out.println(ConsoleColors.GREEN + "Enter your Passwd: " + ConsoleColors.RESET);
				String Passwd = sc.nextLine();

				Player = new Player(Name,Passwd,0,0,0,false,false,PetList,Pet);
				Game.PlayerList.add(Player);
				System.out.println(ConsoleColors.GREEN + Player.Name + ConsoleColors.RESET +", good to see you here!");
				Player.HasSetName = true;
			}

			// Adopting a Pet
			if (!Player.HasPet){

				System.out.println("What do you want to Name your New Pet? " + ConsoleColors.RED + "[Type Name of your Pet]" + ConsoleColors.RESET);
				String PetName = sc.nextLine();

				System.out.println("What type of Pet do you want " + ConsoleColors.YELLOW + PetName  + ConsoleColors.RESET + " to be?");
				String PlayerPetType = sc.nextLine();

				Pet = new Pet(PetName,PlayerPetType,0,100,100);
				Player.Pet = Pet;
				Player.PetList.add(Pet);
				Player.HasPet = true;
				System.out.println(ConsoleColors.GREEN + Player.Name + ConsoleColors.RESET + ", you are all set and ready! take good care of your " + Player.Pet.Type + " ," + ConsoleColors.PURPLE + Player.Pet.Name + ConsoleColors.RESET + ConsoleColors.RESET + "! ");
			}

			System.out.println("Enter cmd: ");
			System.out.println(ConsoleColors.CYAN + "1" + ConsoleColors.YELLOW + " [stats]"    + ConsoleColors.RESET + " | " +
							   ConsoleColors.CYAN + "2" + ConsoleColors.YELLOW + " [feed]"     + ConsoleColors.RESET + " | " +
							   ConsoleColors.CYAN + "3" + ConsoleColors.YELLOW + " [play]"     + ConsoleColors.RESET + " | " +
							   ConsoleColors.CYAN + "4" + ConsoleColors.YELLOW + " [sleep]"    + ConsoleColors.RESET + " | " +
							   ConsoleColors.CYAN + "5" + ConsoleColors.YELLOW + " [chngpetname]" + ConsoleColors.RESET + " | " +
							   ConsoleColors.CYAN + "6" + ConsoleColors.YELLOW + " [newpet]"   + ConsoleColors.RESET + " | " +
							   ConsoleColors.CYAN + "7" + ConsoleColors.YELLOW + " [chngpet]"  + ConsoleColors.RESET + " | " +
							   ConsoleColors.CYAN + "8" + ConsoleColors.YELLOW + " [chngplayername]" + ConsoleColors.RESET + " | " +
							   ConsoleColors.CYAN + "9" + ConsoleColors.YELLOW + " [newplayer]"   + ConsoleColors.RESET + " | " +
							   ConsoleColors.CYAN + "10" + ConsoleColors.YELLOW + " [chngplayer]"  + ConsoleColors.RESET + " | " +

							   ConsoleColors.CYAN + "s" + ConsoleColors.YELLOW + " [save]"     + ConsoleColors.RESET + " | " +
							   ConsoleColors.CYAN + "0" + ConsoleColors.YELLOW + " [help]"     + ConsoleColors.RESET + " | " +
							   ConsoleColors.CYAN + "x" + ConsoleColors.RED    + " [exit]"     + ConsoleColors.RESET + " | " +
							   ConsoleColors.RESET);

			String Input = sc.nextLine();

			//Counts the Number of Commands and gets the Age of Pet with it
			Player.NumberOfCommands = Player.NumberOfCommands + 1;
			if(Player.NumberOfCommands % 20 == 0){Player.Pet.Age++;}
			if(Player.XpPoints % 100 == 0){
				Player.Level++;
				Player.XpPoints = 1;
			}
			if(Player.XpPoints > 100){
				Player.Level++;
				Player.XpPoints = Player.XpPoints - 100;
			}
			if(Player.XpPoints < 0){
				Player.XpPoints = 1;
			}

			// Switch for the commands
			switch (Input.toLowerCase()) {

				// Stats of User and Player
				case "stats":
				case "1":
					System.out.println(ConsoleColors.CYAN + "Getting Pet & Player stats...\n" + ConsoleColors.RESET);
					System.out.println(Player.Pet.getStats());
					System.out.println(Player.getStats());
					System.out.println(Game.getStats());
					System.out.println(ConsoleColors.RESET + "\n\n");

					break;

				// Feed Command
				case "feed":
				case "2":
					System.out.println("You fed "+ ConsoleColors.PURPLE + Player.Pet.Name + ConsoleColors.RESET + " some tasty food");

					// Range of Values for getting behaviour
					if(Player.Pet.Hunger <= 100 && Player.Pet.Hunger > 80){
						System.out.println(ConsoleColors.PURPLE + Player.Pet.Name + ConsoleColors.RESET + " is too full! it wants to Sleep!");
					}
					else if(Player.Pet.Hunger <= 80 && Player.Pet.Hunger > 60){
						System.out.println(ConsoleColors.PURPLE + Player.Pet.Name + ConsoleColors.RESET + " is not very hungry! it wants to play!");
					}
					else if(Player.Pet.Hunger <= 60 && Player.Pet.Hunger > 40){
						System.out.println(ConsoleColors.PURPLE + Player.Pet.Name + ConsoleColors.RESET + " was pretty hungry!");
						Player.Pet.Hunger = Player.Pet.Hunger + 10;
					}
					else if(Player.Pet.Hunger <= 40 && Player.Pet.Hunger > 20){
						System.out.println(ConsoleColors.PURPLE + Player.Pet.Name + ConsoleColors.RESET + " was famished! it ate all the food!");
						Player.Pet.Hunger = Player.Pet.Hunger + 20;
					}
					else if(Player.Pet.Hunger < 20){
						System.out.println(ConsoleColors.PURPLE + Player.Pet.Name + ConsoleColors.RESET + " was starving! it ate it all!");
						Player.Pet.Hunger = Player.Pet.Hunger + 20;
					}else{
						System.out.println("Error Occurred");
					}

					//Xp points
					Player.XpPoints = Player.XpPoints + 10;
					break;

				//Play Command
				case "play":
				case "3":
					System.out.println("You played catch with " + Player.Pet.Name);

					// Range of Values for getting behaviour
					if(Player.Pet.Happiness <= 100 && Player.Pet.Happiness > 80){
						System.out.println(ConsoleColors.PURPLE + Player.Pet.Name + ConsoleColors.RESET + " has played and had fun already! it wants to Sleep!");
					}
					else if(Player.Pet.Happiness <= 80 && Player.Pet.Happiness > 60){
						System.out.println(ConsoleColors.PURPLE + Player.Pet.Name + ConsoleColors.RESET + " was not very bored... but had fun!");
						Player.Pet.Happiness = Player.Pet.Happiness + 3;

					}
					else if(Player.Pet.Happiness <= 60 && Player.Pet.Happiness > 40){
						System.out.println(ConsoleColors.PURPLE + Player.Pet.Name + ConsoleColors.RESET + " was pretty bored! now its lively and happy!");
						Player.Pet.Happiness = Player.Pet.Happiness + 10;
					}
					else if(Player.Pet.Happiness <= 40 && Player.Pet.Happiness > 20){
						System.out.println(ConsoleColors.PURPLE + Player.Pet.Name + ConsoleColors.RESET + " was extremely bored! it wants to play more!!");
						Player.Pet.Happiness = Player.Pet.Happiness + 20;
					}
					else if(Player.Pet.Happiness < 20){
						System.out.println(ConsoleColors.PURPLE + Player.Pet.Name + ConsoleColors.RESET + " was bored to death! good that it didn't run away!");
						Player.Pet.Happiness = Player.Pet.Happiness + 20;
					}
					else{
						System.out.println("Error Occurred");
					}


					//Xp points
					Player.XpPoints = Player.XpPoints + 10;

					break;

				//Sleep Command
				case "sleep":
				case "4":
					System.out.println(ConsoleColors.PURPLE + Player.Pet.Name + ConsoleColors.RESET + " had a long peaceful sleep!");
					Player.Pet.Happiness = 10;
					Player.Pet.Hunger = 10;
					Player.XpPoints = Player.XpPoints + 10;

					break;

				// Change name command
				case "chngpetname":
				case "5":
					System.out.println("Enter the new name of your Pet: ");
					Player.Pet.Name = sc.next();
					System.out.println("Your Pet is now named: " + Player.Pet.Name);

					break;

				case "newpet":
				case "6":
					System.out.println("What do you want to Name your New Pet? " + ConsoleColors.RED + "[Type Name of your Pet]" + ConsoleColors.RESET);
					String NewPetName = sc.next();

					System.out.println("What type of Pet do you want " + ConsoleColors.YELLOW + NewPetName  + ConsoleColors.RESET + " to be?");
					String NewPlayerPetType = sc.next();

					Pet = new Pet(NewPetName,NewPlayerPetType,0,100,100);
					Player.Pet = Pet;
					Player.PetList.add(Pet);
					Player.HasPet = true;
					System.out.println(ConsoleColors.GREEN + Player.Name + ConsoleColors.RESET + ", you are all set and ready! take good care of your " + Player.Pet.Type + " ," + ConsoleColors.PURPLE + Player.Pet.Name + ConsoleColors.RESET + ConsoleColors.RESET + "! ");
					System.out.println("this is your " + Player.PetList.size() + " pet!");
					break;

				case "chngpet":
				case "7":
					System.out.println("Which Pet do you want to take care of?");
					for (int i = 0; i < Player.PetList.size(); i++) {
						Pet =  Player.PetList.get(i);
						System.out.println("[" + i + "] " + Pet.Name);
					}

					int PlayerInput = sc.nextInt();
					Player.Pet = Player.PetList.get(PlayerInput);
					System.out.println("you are now taking care of " + Player.Pet.Name);
					break;

				// Change name command
				case "chngplayername":
				case "8":
					System.out.println("Enter your new name : ");
					Player.Name = sc.next();
					System.out.println("You are now named: " + Player.Name);

					break;

				case "newplayer":
				case "9":
					System.out.println(ConsoleColors.GREEN + "Enter your Name: " + ConsoleColors.RESET);
					String Name = sc.nextLine();
					System.out.println(ConsoleColors.GREEN + "Enter your Passwd: " + ConsoleColors.RESET);
					String Passwd = sc.nextLine();
					PetList = new ArrayList<Pet>();
					Player = new Player(Name,Passwd,0,0,0,false,false,PetList,Pet);
					System.out.println(ConsoleColors.GREEN + Player.Name + ConsoleColors.RESET +", have a great time here!");
					Game.PlayerList.add(Player);
					Player.HasSetName = true;

					break;

				case "chngplayer":
				case "10":
					System.out.println("Which Player do you want to change to?");
					for (int i = 0; i < Player.PetList.size(); i++) {
						Player =  Game.PlayerList.get(i);
						System.out.println("[" + i + "] " + Player.Name);
					}

					PlayerInput = sc.nextInt();
					Player = Game.PlayerList.get(PlayerInput);
					System.out.println("you are now " + Player.Name);
					break;



				case "save":
				case "s":
					Game.Save();

					break;

				case "load":
				case "l":
					Game.Load();
					//Game = Game.Load();
					Game = new Game(Game.Load());

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

				default:
					System.err.println("Invalid operation");
					System.out.println("\n\n");
			}
		}
	}
}

