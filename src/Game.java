import java.util.*;
import java.io.*;

//Class of Game
public class Game implements Serializable {
    private static final long serialVersionUID = 4L;
    List<Player> playerList;
    String gameIntro;
    String gameCmds;
    String savedGameFileName;
    boolean isSet;
    boolean isSaved;
    public Game(
            List<Player> playerList,
            boolean isSet,
            boolean isSaved
    ){
        this.playerList = playerList; // PlayerList of the Game
        this.isSet = isSet;
        this.isSaved = isSaved;
        this.savedGameFileName = savedGameFileName;
    }

    public List<Player> getPlayerList()  {return playerList;}
    public boolean      getIsSet()       {return isSet;}
    public boolean      getIsSaved()       {return isSaved;}
    public String      getSavedGameFileName()       {return savedGameFileName;}
    
    public List<String> getPlayerNameList()      {
		List<String> playerNameList = new ArrayList<String>();
		for(Player player : playerList){
			playerNameList.add(player.getName());
		}
		return playerNameList;
	}

    public String getStats(){
        return ("\nplayerList: "       + ConsoleColors.GREEN  + this.getPlayerNameList()      + ConsoleColors.RESET);
    }

    //Game leaderboard
    public String getLeaderboard(){
        String leaderboard = "";
        // List<String> leaderboardList = new ArrayList<String>();;
        for (Player player : playerList){   
            leaderboard = leaderboard + player.getName() + ": " + player.getXpPoints() + "\n";
        }
        return leaderboard;
    }

    public String Save(String savedGameFile){
        try {
            FileOutputStream savedGame = new FileOutputStream(savedGameFile);    
            ObjectOutputStream outPutGame = new ObjectOutputStream(savedGame);    
            outPutGame.writeObject(this);
            for (int i = 0; i < this.playerList.size(); i++) {
                        outPutGame.writeObject(this.playerList.get(i));
                        for (int j = 0; j < this.playerList.get(i).petList.size();j++ ) {
                            outPutGame.writeObject(this.playerList.get(i).petList.get(j));
                        }
                    }    
            outPutGame.flush();      
            outPutGame.close();      
            System.out.println("Successfully Saved the Game to " + savedGameFile);
            return savedGameFile;
        } catch (IOException e) {
            System.err.println("An error occurred.");
            e.printStackTrace();
            return "error";
        } 
    }
    public String getIntro(){
gameIntro = ConsoleColors.GREEN +
" ___       _     ___                   \n"+
"| _ \\ ___ | |_  / __| __ _  _ __   ___ \n"+
"|  _// -_)|  _|| (_ |/ _` || '  \\ / -_)\n"+
"|_|  \\___| \\__| \\___|\\__/_||_|_|_|\\___|\n"+
ConsoleColors.RESET + ConsoleColors.CYAN + "Welcome to PetGame by Denzven! \n This game is made in java and is a starter project of mine! \n Hope you love it!\n\n" + ConsoleColors.RESET;
        return gameIntro;
    }
    public String getCmds(){
        gameCmds = "Enter cmd: \n" +
                    ConsoleColors.CYAN + "1"  + ConsoleColors.YELLOW + " [stats]"          + ConsoleColors.RESET + " | " +
                    ConsoleColors.CYAN + "2"  + ConsoleColors.YELLOW + " [feed]"           + ConsoleColors.RESET + " | " +
                    ConsoleColors.CYAN + "3"  + ConsoleColors.YELLOW + " [play]"           + ConsoleColors.RESET + " | " +
                    ConsoleColors.CYAN + "4"  + ConsoleColors.YELLOW + " [sleep]"          + ConsoleColors.RESET + " | " +
                    ConsoleColors.CYAN + "5"  + ConsoleColors.YELLOW + " [chngpetname]"    + ConsoleColors.RESET + " | " +
                    ConsoleColors.CYAN + "6"  + ConsoleColors.YELLOW + " [newpet]"         + ConsoleColors.RESET + " | " +
                    ConsoleColors.CYAN + "7"  + ConsoleColors.YELLOW + " [chngpet]"        + ConsoleColors.RESET + " | " +
                    ConsoleColors.CYAN + "8"  + ConsoleColors.YELLOW + " [chngplayername]" + ConsoleColors.RESET + " | " +
                    ConsoleColors.CYAN + "9"  + ConsoleColors.YELLOW + " [newplayer]"      + ConsoleColors.RESET + " | " +
                    ConsoleColors.CYAN + "10" + ConsoleColors.YELLOW + " [chngplayer]"     + ConsoleColors.RESET + " | " +
                    ConsoleColors.CYAN + "s"  + ConsoleColors.YELLOW + " [save]"           + ConsoleColors.RESET + " | " +
                    ConsoleColors.CYAN + "l"  + ConsoleColors.YELLOW + " [load]"           + ConsoleColors.RESET + " | " +
                    ConsoleColors.CYAN + "0"  + ConsoleColors.YELLOW + " [help]"           + ConsoleColors.RESET + " | " +
                    ConsoleColors.CYAN + "x"  + ConsoleColors.RED    + " [exit]"           + ConsoleColors.RESET + " | " +
                    ConsoleColors.RESET;
        return gameCmds;
    }
}

