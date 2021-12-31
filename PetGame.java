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
		Pet Pet = new Pet("DEFUALT_PET","DEFAULT_TYPE",0,100,100);
		Player Player = new Player("DEFUALT_PLAYER",0,0,false,false,Pet);

		//PlayerInput
		Scanner sc = new Scanner(System.in);

		// Setting Player Name
		if (Player.HasSetName == false){
			System.out.println("Enter your Name: ");
			String Name = sc.next();
			Player = new Player(Name,0,0,false,false,Pet);
			System.out.println(Player.Name + ", good to see you here!");
			}

		// Adopting a Pet
		if (Player.HasPet == false){
			System.out.println("You dont have a Pet, Do you want to buy one? [type 1 for yes]");
			int InputPet = sc.nextInt();

			if(InputPet == 1){
				System.out.println("What do you want to Name your New Pet?");
				String PetName = sc.next();

				System.out.println("What type of Pet do you want? [Dog,Cat,Dragon any] " + PetName + " to be?");
				String PlayerPetType = sc.next();

				Pet = new Pet(PetName,PlayerPetType,0,100,100);
				Player.Pet = Pet;
				Player.HasPet = true;
			} else {
				System.out.println("idk what to do now... maybe restart?");
				System.exit(0);
			}
		}


		//Main while loop
		while(true){
			System.out.println("Enter cmd: ");
			System.out.println("1[stats] 2[feed] 3[play] 4[sleep] 5[chngname] 0[help] x[exit]");
			String Input = sc.next();

			//Counts the Number of Commands and gets the Age of Pet with it
			Player.NumberOfCommands = Player.NumberOfCommands + 1;
			if(Player.NumberOfCommands % 20 == 0){Player.Pet.Age++;}

			// Switch for the commands
			switch (Input.toLowerCase()) {

				// Stats of User and Player
				case "stats":
				case "1":
					System.out.println("Getting Pet & Player stats...\n");
					System.out.println(Player.Pet.getStats());
					System.out.println(Player.getStats());
					System.out.println("\n\n");

					break;

				// Feed Command
				case "feed":
				case "2":
					System.out.println("You fed " + Player.Pet.Name + " some tasty food");

					// Range of Values for getting behaviour
					if(Player.Pet.Hunger <= 100 && Player.Pet.Hunger > 80){
						System.out.println(Player.Pet.Name + " is too full! it wants to Sleep!");
					}
					else if(Player.Pet.Hunger <= 80 && Player.Pet.Hunger > 60){
						System.out.println(Player.Pet.Name + " is not very hungry! it wants to play!");
					}
					else if(Player.Pet.Hunger <= 60 && Player.Pet.Hunger > 40){
						System.out.println(Player.Pet.Name + " was pretty hungry!");
						Player.Pet.Hunger = Player.Pet.Hunger + 10;
					}
					else if(Player.Pet.Hunger <= 40 && Player.Pet.Hunger > 20){
						System.out.println(Player.Pet.Name + " was famished! it ate all the food!");
						Player.Pet.Hunger = Player.Pet.Hunger + 20;
					}
					else if(Player.Pet.Hunger < 20){
						System.out.println(Player.Pet.Name + " was starving! it ate it all!");
						Player.Pet.Hunger = Player.Pet.Hunger + 20;
					}else{
						System.out.println("Error Ocurred");
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
						System.out.println(Player.Pet.Name + " has played and had fun already! it wants to Sleep!");
					}
					else if(Player.Pet.Happiness <= 80 && Player.Pet.Happiness > 60){
						System.out.println(Player.Pet.Name + " was not very bored... but had fun!");
						Player.Pet.Happiness = Player.Pet.Happiness + 3;

					}
					else if(Player.Pet.Happiness <= 60 && Player.Pet.Happiness > 40){
						System.out.println(Player.Pet.Name + " was pretty bored! now its lively and happy!");
						Player.Pet.Happiness = Player.Pet.Happiness + 10;
					}
					else if(Player.Pet.Happiness <= 40 && Player.Pet.Happiness > 20){
						System.out.println(Player.Pet.Name + " was extremly bored! it wants to play more!!");
						Player.Pet.Happiness = Player.Pet.Happiness + 20;
					}
					else if(Player.Pet.Happiness < 20){
						System.out.println(Player.Pet.Name + " was bored to death! good that it didnt run away!");
						Player.Pet.Happiness = Player.Pet.Happiness + 20;
					}
					else{
						System.out.println("Error Ocurred");
					}


					//Xp points
					Player.XpPoints = Player.XpPoints + 10;

					break;

				//Sleep Command
				case "sleep":
				case "4":
					System.out.println(Player.Pet.Name + " had a long peaceful sleep!");
					Player.Pet.Happiness = 10;
					Player.Pet.Hunger = 10;
					Player.XpPoints = Player.XpPoints + 10;

					break;

				// Change name command
				case "chngname":
				case "5":
					System.out.println("Enter the new name of your Pet: ");
					String PetName = sc.next();
					Player.Pet.Name = PetName;
					System.out.println("Your Pet is now named: " + Player.Pet.Name);

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

