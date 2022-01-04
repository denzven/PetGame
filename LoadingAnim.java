// LoadingAnim.java

// Main Game class
public class LoadingAnim{
	int inputLevel;
	public static String Bar(
		int inputLevel
	){
		     if(inputLevel <=100 && inputLevel > 90){return ConsoleColors.GREEN  + "[====================]" + ConsoleColors.RESET + " " +inputLevel + "%";}
		else if(inputLevel <= 90 && inputLevel > 80){return ConsoleColors.GREEN  + "[==================--]" + ConsoleColors.RESET + " " +inputLevel + "%";}
		else if(inputLevel <= 80 && inputLevel > 70){return ConsoleColors.GREEN  + "[================----]" + ConsoleColors.RESET + " " +inputLevel + "%";}
		else if(inputLevel <= 70 && inputLevel > 60){return ConsoleColors.YELLOW + "[==============------]" + ConsoleColors.RESET + " " +inputLevel + "%";}
		else if(inputLevel <= 60 && inputLevel > 50){return ConsoleColors.YELLOW + "[============--------]" + ConsoleColors.RESET + " " +inputLevel + "%";}
		else if(inputLevel <= 50 && inputLevel > 40){return ConsoleColors.YELLOW + "[==========----------]" + ConsoleColors.RESET + " " +inputLevel + "%";}
		else if(inputLevel <= 40 && inputLevel > 30){return ConsoleColors.RED    + "[========------------]" + ConsoleColors.RESET + " " +inputLevel + "%";}
		else if(inputLevel <= 30 && inputLevel > 20){return ConsoleColors.RED    + "[======--------------]" + ConsoleColors.RESET + " " +inputLevel + "%";}
		else if(inputLevel <= 20 && inputLevel > 10){return ConsoleColors.RED    + "[====----------------]" + ConsoleColors.RESET + " " +inputLevel + "%";}
		else if(inputLevel <= 10 && inputLevel > 0 ){return ConsoleColors.RED    + "[==------------------]" + ConsoleColors.RESET + " " +inputLevel + "%";}
		else if(inputLevel == 0)                    {return ConsoleColors.RED    + "[--------------------]" + ConsoleColors.RESET + " " +inputLevel + "%";}
		else{return "Error Ocurred";}
	}
}