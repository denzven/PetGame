// LoadingAnim.java

// Main Game class
public class LoadingAnim{
	int InputLevel;
	public static String Bar(
		int InputLevel
	){
		     if(InputLevel <=100 && InputLevel > 90){return ConsoleColors.GREEN  + "[====================]" + ConsoleColors.RESET + " " +InputLevel + "%";}
		else if(InputLevel <= 90 && InputLevel > 80){return ConsoleColors.GREEN  + "[==================--]" + ConsoleColors.RESET + " " +InputLevel + "%";}
		else if(InputLevel <= 80 && InputLevel > 70){return ConsoleColors.GREEN  + "[================----]" + ConsoleColors.RESET + " " +InputLevel + "%";}
		else if(InputLevel <= 70 && InputLevel > 60){return ConsoleColors.YELLOW + "[==============------]" + ConsoleColors.RESET + " " +InputLevel + "%";}
		else if(InputLevel <= 60 && InputLevel > 50){return ConsoleColors.YELLOW + "[============--------]" + ConsoleColors.RESET + " " +InputLevel + "%";}
		else if(InputLevel <= 50 && InputLevel > 40){return ConsoleColors.YELLOW + "[==========----------]" + ConsoleColors.RESET + " " +InputLevel + "%";}
		else if(InputLevel <= 40 && InputLevel > 30){return ConsoleColors.RED    + "[========------------]" + ConsoleColors.RESET + " " +InputLevel + "%";}
		else if(InputLevel <= 30 && InputLevel > 20){return ConsoleColors.RED    + "[======--------------]" + ConsoleColors.RESET + " " +InputLevel + "%";}
		else if(InputLevel <= 20 && InputLevel > 10){return ConsoleColors.RED    + "[====----------------]" + ConsoleColors.RESET + " " +InputLevel + "%";}
		else if(InputLevel <= 10 && InputLevel > 0 ){return ConsoleColors.RED    + "[==------------------]" + ConsoleColors.RESET + " " +InputLevel + "%";}
		else if(InputLevel == 0)                    {return ConsoleColors.RED    + "[--------------------]" + ConsoleColors.RESET + " " +InputLevel + "%";}
		else{return "Error Ocurred";}
	}
}