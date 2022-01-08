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
        gameCmds = //"Enter cmd: \n" +
                    ConsoleColors.CYAN + "[" + ConsoleColors.RESET + "1"   + ConsoleColors.CYAN + "]" + ConsoleColors.YELLOW + " stats"          + ConsoleColors.RESET + " | " +
                    ConsoleColors.CYAN + "[" + ConsoleColors.RESET + "2"   + ConsoleColors.CYAN + "]" + ConsoleColors.YELLOW + " feed"           + ConsoleColors.RESET + " | " +
                    ConsoleColors.CYAN + "[" + ConsoleColors.RESET + "3"   + ConsoleColors.CYAN + "]" + ConsoleColors.YELLOW + " play"           + ConsoleColors.RESET + " | " +
                    ConsoleColors.CYAN + "[" + ConsoleColors.RESET + "4"   + ConsoleColors.CYAN + "]" + ConsoleColors.YELLOW + " sleep"          + ConsoleColors.RESET + " | " +
                    ConsoleColors.CYAN + "[" + ConsoleColors.RESET + "5"   + ConsoleColors.CYAN + "]" + ConsoleColors.YELLOW + " chngpetname"    + ConsoleColors.RESET + " | " +
                    ConsoleColors.CYAN + "[" + ConsoleColors.RESET + "6"   + ConsoleColors.CYAN + "]" + ConsoleColors.YELLOW + " newpet"         + ConsoleColors.RESET + " | " +
                    ConsoleColors.CYAN + "[" + ConsoleColors.RESET + "7"   + ConsoleColors.CYAN + "]" + ConsoleColors.YELLOW + " chngpet"        + ConsoleColors.RESET + " | " +
                    ConsoleColors.CYAN + "[" + ConsoleColors.RESET + "8"   + ConsoleColors.CYAN + "]" + ConsoleColors.YELLOW + " chngplayername" + ConsoleColors.RESET + " | " +
                    ConsoleColors.CYAN + "[" + ConsoleColors.RESET + "9"   + ConsoleColors.CYAN + "]" + ConsoleColors.YELLOW + " newplayer"      + ConsoleColors.RESET + " | " +
                    ConsoleColors.CYAN + "[" + ConsoleColors.RESET + "10"  + ConsoleColors.CYAN + "]" + ConsoleColors.YELLOW + " chngplayer"     + ConsoleColors.RESET + " | " +
                    ConsoleColors.CYAN + "[" + ConsoleColors.RESET + "s"   + ConsoleColors.CYAN + "]" + ConsoleColors.YELLOW + " save"           + ConsoleColors.RESET + " | " +
                    ConsoleColors.CYAN + "[" + ConsoleColors.RESET + "lb"  + ConsoleColors.CYAN + "]" + ConsoleColors.YELLOW + " leaderboard"    + ConsoleColors.RESET + " | " +
                    ConsoleColors.CYAN + "[" + ConsoleColors.RESET + "cmds"+ ConsoleColors.CYAN + "]" + ConsoleColors.YELLOW + " commands"       + ConsoleColors.RESET + " | " +
                    ConsoleColors.CYAN + "[" + ConsoleColors.RESET + "l"   + ConsoleColors.CYAN + "]" + ConsoleColors.YELLOW + " load"           + ConsoleColors.RESET + " | " +
                    ConsoleColors.CYAN + "[" + ConsoleColors.RESET + "0"   + ConsoleColors.CYAN + "]" + ConsoleColors.YELLOW + " help"           + ConsoleColors.RESET + " | " +
                    ConsoleColors.CYAN + "[" + ConsoleColors.RESET + "x"   + ConsoleColors.CYAN + "]" + ConsoleColors.RED    + " exit"           + ConsoleColors.RESET + " | " +
                    ConsoleColors.RESET;
        return gameCmds;
    }
}