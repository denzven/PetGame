/**
 * @author Denzven
 * Welcome to PetGame.java! a simple and cute game made in java by Denzven
 * in this small game you can adopt pets and take car of them and gain XpPoints
 * this is inspired by tamacotchi and dank memer pet system
 * since java is Object Oriented Programming Language
 * this game can create almost infinte Pet Objects and Player Objects too
 * Have fun
 * 
 * Please do Star the repo on Github
 * {@link https://github.com/denzven/PetGame }
 */

import java.util.*;
import java.io.*;


// Main Game class
public class PetGame{
	/**
	 * This is the Main class of the PetGame,
	 * this includes the main "while loop" and all input fields like player name,
	 * pet name, etc.
	 */

	public static void main(String[] args) {
		/**
		 * Main function of PetGame
		 * @param None
		 */ 

		//Default objects of Pet and player
		List<Pet> petList = new ArrayList<>();
		List<Player> playerList = new ArrayList<>();
		Pet pet = new Pet("DEFAULT_PET","DEFAULT_TYPE",0,100,100);
		Player player = new Player("DEFAULT_PLAYER","DEFAULT_PASSWD",0,0,0,false,false,petList,pet);
		Game game = new Game(playerList,false,false);

		//Intro String
		System.out.println(game.getIntro());
		//Main while loop
		while(true){
			/**
			 * Main while loop that keeps the game going.
			 */
			
			Scanner sc = new Scanner(System.in); //PlayerInput

			// Setting Player Name
			if (!game.getIsSet()){
				System.out.println(ConsoleColors.GREEN + "Do you want to start a NewGame or Load an Existing Game?: " + ConsoleColors.RESET);
				System.out.println(ConsoleColors.RED + "0" + ConsoleColors.YELLOW + " [NewGame]"            + ConsoleColors.RESET + " | " +
							       ConsoleColors.RED + "1" + ConsoleColors.YELLOW + " [Existing Game]"      + ConsoleColors.RESET + " | " +
							       ConsoleColors.RED + "2" + ConsoleColors.YELLOW + " [Load a Sample Game]" + ConsoleColors.RESET + " | ");
				
				String isSetOpt = sc.nextLine();
				if (isSetOpt.equals("0")) {
					System.out.println("Starting NewGame...");
					game.isSet = true;
					game.isSaved = false;
				}
				if (isSetOpt.equals("1")) {
				    try{
						System.out.println("Enter the FileName of you Saved Game: ");
				        String savedGameFile = sc.nextLine() + ".PetGameSavedGame";  
				        ObjectInputStream inputGame = new ObjectInputStream(new FileInputStream(savedGameFile));  
				        game = (Game)inputGame.readObject();
				        player = (Player)inputGame.readObject();
				        pet = (Pet)inputGame.readObject(); 
				        System.out.println("Game of " + player.name + " Loaded!"); 
						inputGame.close();
						game.isSet = true;
						game.isSaved = true;
				    }catch(Exception e){
				        System.err.println(e);
				    }  
				}
				if (isSetOpt.equals("2")) {
				    try{
						System.out.println("Loading a Sample Game...");
				        String savedGameFile = "Sample.PetGameSavedGame";  
				        ObjectInputStream inputGame = new ObjectInputStream(new FileInputStream(savedGameFile));  
				        game = (Game)inputGame.readObject();
				        player = (Player)inputGame.readObject();
				        pet = (Pet)inputGame.readObject(); 
				        System.out.println("Sample Game of " + player.name + " Loaded!"); 
						inputGame.close();
						game.isSet = true;
						game.isSaved = false;
				    }catch(Exception e){
				        System.err.println(e);
				    }  
				}
			}

			// Setting Player Name
			if (!player.getHasSetName()){
				System.out.println(ConsoleColors.GREEN + "Enter your Name: " + ConsoleColors.RESET);
				String name = sc.nextLine();
				System.out.println(ConsoleColors.GREEN + "Enter your Passwd: " + ConsoleColors.RESET);
				String passwd = sc.nextLine();
				player = new Player(name,passwd,0,0,0,false,false,petList,pet);
				game.playerList.add(player);
				System.out.println(ConsoleColors.GREEN + player.name + ConsoleColors.RESET +", good to see you here!");
				player.hasSetName = true;
			}

			// Adopting a Pet
			if (!player.getHasPet()){
				System.out.println("What do you want to Name your New Pet? " + ConsoleColors.RED + "[Type Name of your Pet]" + ConsoleColors.RESET);
				String petName = sc.nextLine();
				System.out.println("What type of Pet do you want " + ConsoleColors.YELLOW + petName  + ConsoleColors.RESET + " to be?");
				String playerPetType = sc.nextLine();
				pet = new Pet(petName,playerPetType,0,100,100);
				player.pet = pet;
				player.getPetList().add(pet);
				player.hasPet = true;
				System.out.println(ConsoleColors.GREEN + player.name + ConsoleColors.RESET + ", you are all set and ready! take good care of your " + player.pet.getType() + " ," + ConsoleColors.PURPLE + player.pet.getName() + ConsoleColors.RESET + ConsoleColors.RESET + "! ");
			}

			System.out.println(game.getCmds());
			String input = sc.nextLine();

			//Counts the Number of Commands and gets the Age of Pet with it
			player.numberOfCommands = player.getNumberOfCommands() + 1;
			if(player.getNumberOfCommands() % 20 == 0){player.pet.age++;}
			if(player.getXpPoints() % 100 == 0){
				player.level++;
				player.xpPoints = 1;
			}
			if(player.getXpPoints() > 100){
				player.level++;
				player.xpPoints = player.getXpPoints() - 100;
			}
			if(player.getXpPoints() < 0){
				player.xpPoints = 1;
			}

			// Switch for the commands
			switch (input.toLowerCase()) {
				/**
				 * Switch case style of input,
				 * to evaluate the action by Player.
				 */

				case "stats":
				case "1":
					/**
					 * Stats of Pet,Player and Game Classes,
					 * this includes info like:
					 * 1. How many Pets does the Player have.
					 * 2. How many Players are there in the Game.
					 * 3. Name and other info of the pet and player.
					 */
					System.out.println(ConsoleColors.CYAN + "Getting Pet & Player stats...\n" + ConsoleColors.RESET);
					System.out.println(player.pet.getStats());
					System.out.println(player.getStats());
					System.out.println(game.getStats());
					System.out.println(ConsoleColors.RESET + "\n\n");
					break;

				case "feed":
				case "2":
					/**
					 * Feed command for the Pet,
					 * This command increases the Hunger Stat of the Pet "dynamically",
					 * and grants the player 10 XpPoints.
					 */
					System.out.println("You fed "+ ConsoleColors.PURPLE + player.pet.getName() + ConsoleColors.RESET + " some tasty food");
					// Range of Values for getting behaviour
					if(player.pet.getHunger() <= 100 && player.pet.getHunger() > 80){
						System.out.println(ConsoleColors.PURPLE + player.pet.getName() + ConsoleColors.RESET + " is too full! it wants to Sleep!");
					}
					else if(player.pet.getHunger() <= 80 && player.pet.getHunger() > 60){
						System.out.println(ConsoleColors.PURPLE + player.pet.getName() + ConsoleColors.RESET + " is not very hungry! it wants to play!");
					}
					else if(player.pet.getHunger() <= 60 && player.pet.getHunger() > 40){
						System.out.println(ConsoleColors.PURPLE + player.pet.getName() + ConsoleColors.RESET + " was pretty hungry!");
						player.pet.hunger = player.pet.getHunger() + 10;
						player.xpPoints = player.getXpPoints() + 10;
					}
					else if(player.pet.getHunger() <= 40 && player.pet.getHunger() > 20){
						System.out.println(ConsoleColors.PURPLE + player.pet.getName() + ConsoleColors.RESET + " was famished! it ate all the food!");
						player.pet.hunger = player.pet.getHunger() + 20;
						player.xpPoints = player.getXpPoints() + 10;
					}
					else if(player.pet.getHunger() < 20){
						System.out.println(ConsoleColors.PURPLE + player.pet.getName() + ConsoleColors.RESET + " was starving! it ate it all!");
						player.pet.hunger = player.pet.getHunger() + 20;
						player.xpPoints = player.getXpPoints() + 10;
					}else{
						System.out.println("Error Occurred");
					}
					game.isSaved = false;
					break;

				case "play":
				case "3":
					/**
					 * 
					 */
					System.out.println("You played " + ConsoleColors.GREEN + player.pet.getRandGame() + ConsoleColors.RESET + " with "+ ConsoleColors.PURPLE + player.pet.getName() + ConsoleColors.RESET + "!");
					// Range of Values for getting behaviour
					if(player.pet.getHappiness() <= 100 && player.pet.getHappiness() > 80){
						System.out.println(ConsoleColors.PURPLE + player.pet.getName() + ConsoleColors.RESET + " has played and had fun already! it wants to Sleep!");
					}
					else if(player.pet.getHappiness() <= 80 && player.pet.getHappiness() > 60){
						System.out.println(ConsoleColors.PURPLE + player.pet.getName() + ConsoleColors.RESET + " was not very bored... but had fun!");
						player.pet.happiness = player.pet.getHappiness() + 3;
						player.xpPoints = player.getXpPoints() + 3;
					}
					else if(player.pet.getHappiness() <= 60 && player.pet.getHappiness() > 40){
						System.out.println(ConsoleColors.PURPLE + player.pet.getName() + ConsoleColors.RESET + " was pretty bored! now its lively and happy!");
						player.pet.happiness = player.pet.getHappiness() + 10;
						player.xpPoints = player.getXpPoints() + 10;
					}
					else if(player.pet.getHappiness() <= 40 && player.pet.getHappiness() > 20){
						System.out.println(ConsoleColors.PURPLE + player.pet.getName() + ConsoleColors.RESET + " was extremely bored! it wants to play more!!");
						player.pet.happiness = player.pet.getHappiness() + 20;
						player.xpPoints = player.getXpPoints() + 10;
					}
					else if(player.pet.getHappiness() < 20){
						System.out.println(ConsoleColors.PURPLE + player.pet.getName() + ConsoleColors.RESET + " was bored to death! good that it didn't run away!");
						player.pet.happiness = player.pet.getHappiness() + 20;
						player.xpPoints = player.getXpPoints() + 10;
					}
					else{
						System.out.println("Error Occurred");
					}
					game.isSaved = false;
					break;

				case "sleep":
				case "4":
					/**
					 * 
					 */ 
					System.out.println(ConsoleColors.PURPLE + player.pet.getName() + ConsoleColors.RESET + " had a long peaceful sleep!");
					player.pet.happiness = 10;
					player.pet.hunger = 10;
					player.xpPoints = player.getXpPoints() + 5;
					game.isSaved = false;
					break;

				case "chngpetname":
				case "5":
					/**
					 * 
					 */ 
					System.out.println("Enter the new name of your Pet: ");
					player.pet.name = sc.nextLine();
					System.out.println("Your Pet is now named: " + player.pet.getName());
					game.isSaved = false;
					break;

				case "newpet":
				case "6":
					/**
					 * 
					 */ 
					System.out.println("What do you want to Name your New Pet? " + ConsoleColors.RED + "[Type Name of your Pet]" + ConsoleColors.RESET);
					String newPetName = sc.nextLine();
					System.out.println("What type of Pet do you want " + ConsoleColors.YELLOW + newPetName  + ConsoleColors.RESET + " to be?");
					String newPlayerPetType = sc.nextLine();
					pet = new Pet(newPetName,newPlayerPetType,0,100,100);
					player.pet = pet;
					player.getPetList().add(pet);
					player.hasPet = true;
					System.out.println(ConsoleColors.GREEN + player.getName() + ConsoleColors.RESET + ", you are all set and ready! take good care of your " + player.pet.getType() + " ," + ConsoleColors.PURPLE + player.pet.getName() + ConsoleColors.RESET + ConsoleColors.RESET + "! ");
					System.out.println(player.getName() + ", you have a total of " + player.getPetList().size() + " pets!");
					game.isSaved = false;
					break;

				case "chngpet":
				case "7":
					/**
					 * 
					 */ 
					System.out.println("Which Pet do you want to take care of?");
					for (int i = 0; i < player.getPetList().size(); i++) {
						pet =  player.getPetList().get(i);
						System.out.println(ConsoleColors.CYAN + "[" + ConsoleColors.RESET + i + ConsoleColors.CYAN + "] " + ConsoleColors.YELLOW + pet.name + ConsoleColors.RESET);
					}
					int playerInput = sc.nextInt();
					player.pet = player.getPetList().get(playerInput);
					System.out.println("you are now taking care of " + player.pet.getName());
					game.isSaved = false;
					break;

				case "chngplayername":
				case "8":
					/**
					 * 
					 */ 
					System.out.println("Enter your new name : ");
					player.name = sc.nextLine();
					System.out.println("You are now named: " + player.name);
					game.isSaved = false;
					break;
					
				case "newplayer":
				case "9":
					/**
					 * 
					 */ 
					System.out.println(ConsoleColors.GREEN + "Enter your Name: " + ConsoleColors.RESET);
					String name = sc.nextLine();
					System.out.println(ConsoleColors.GREEN + "Enter your Passwd: " + ConsoleColors.RESET);
					String passwd = sc.nextLine();
					petList = new ArrayList<Pet>();
					player = new Player(name,passwd,0,0,0,false,false,petList,pet);
					System.out.println(ConsoleColors.GREEN + player.name + ConsoleColors.RESET +", have a great time here!");
					game.playerList.add(player);
					player.hasSetName = true;
					game.isSaved = false;
					break;

				case "chngplayer":
				case "10":
					/**
					 * 
					 */ 
					System.out.println("Which Player do you want to change to?");
					for (int i = 0; i < player.getPetList().size(); i++) {
						player =  game.playerList.get(i);
						System.out.println(ConsoleColors.CYAN + "[" + ConsoleColors.RESET + i + ConsoleColors.CYAN + "] " + ConsoleColors.YELLOW + player.name + ConsoleColors.RESET);
					}
					playerInput = sc.nextInt();
					player = game.playerList.get(playerInput);
					System.out.println("you are now " + player.name);
					game.isSaved = false;
					break;

				case "save":
				case "s":
					/**
					 * 
					 */ 
					if (game.savedGameFileName != null) {
						game.Save(game.savedGameFileName);
					}else{
					System.out.println("Enter the FileName of you Saved Game: ");
					String savedGameFile = sc.nextLine() + ".PetGameSavedGame";
					game.savedGameFileName = savedGameFile;
					game.Save(savedGameFile);
					}
					String savedGameFile = game.savedGameFileName;
					game.isSaved = true;
					break;

				case "leaderboard":
				case "lb":
					/**
					 * 
					 */ 
					System.out.println("Leaderboard:");
					System.out.println(game.getLeaderboard());
					game.isSaved = false;
					break;

				case "List of Commands":
				case "cmds":
					/**
					 * 
					 */ 
					System.out.println(game.getCmds());
					game.isSaved = false;
					break;

				case "load":
				case "l":
					/**
					 * 
					 */ 
				    try{
						System.out.println("Enter the FileName of you Saved Game: ");
				        savedGameFile = sc.nextLine() + ".PetGameSavedGame";  
				        ObjectInputStream inputGame = new ObjectInputStream(new FileInputStream(savedGameFile));  
				        game = (Game)inputGame.readObject();
				        player = (Player)inputGame.readObject();
				        pet = (Pet)inputGame.readObject(); 
				        System.out.println("Game of " + player.name + " Loaded!"); 
						inputGame.close();
				    }catch(Exception e){
				        System.err.println(e);
				    }  
					break;

				case "help":
				case "0":
					/**
					 * 
					 */ 
					System.out.println("The Help Command isn't ready yet");
					game.isSaved = false;
					break;

				case "exit":
				case "x":
					/**
					 * 
					 */ 
					if (!game.isSaved) {
						System.out.println("Game is not Saved!");
						System.out.println(game.savedGameFileName);
						System.out.println("Do you wish to save?[y/n]:");
						String SaveInput = sc.nextLine();
						if (SaveInput.toLowerCase().equals("y")) {
							System.out.println("Type s to save game");
							break;
						}
						if (SaveInput.toLowerCase().equals("n")) {
							System.out.println("");							
						}
						else{
							System.out.println("Invalid operation");
						}
					}
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