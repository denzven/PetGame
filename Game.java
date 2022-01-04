import java.util.*;
import java.io.*;

//Class of Game
public class Game implements Serializable {
    private static final long serialVersionUID = 4L;
    List<Player> playerList;
    String gameIntro;
    public Game(
            List<Player> playerList
    ){
        this.playerList = playerList; // PlayerList of the Game
    }

    public List<Player> getPlayerList()  {return playerList;}

    public String getStats(){
        return ("\nplayerList: "       + ConsoleColors.GREEN  + this.getPlayerList()      + ConsoleColors.RESET);
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
            System.out.println("An error occurred.");
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
}

/*
 * <Game>
 *     |
 *     \---> <Player> 
 *     |           |
 *     |           \---> Pet
 *     |           |     
 *     |           \---> Pet  
 *     |           |
 *     |           \---> Pet   
 *     |
 *     \---> <Player> 
 *     |           |
 *     |           \---> Pet
 *     |           |     
 *     |           \---> Pet  
 *     |           |
 *     |           \---> Pet   
 *     |
 *     \---> <Player> 
 *                 |
 *                 \---> Pet
 *                 |     
 *                 \---> Pet  
 *                 |
 *                 \---> Pet   
 *
 */

/*
 *  Game
 *     |
 *     \--->Liam 
 *     |       |
 *     |       \--->Max
 *     |       |     
 *     |       \--->Charlie  
 *     |       |
 *     |       \--->Cooper  
 *     |
 *     \--->Noah 
 *     |       |
 *     |       \--->Bella
 *     |       |     
 *     |       \--->Luna
 *     |       |
 *     |       \--->Lucy  
 *     |
 *     \--->Olivia 
 *               |
 *               \--->Buddy
 *               |     
 *               \--->Rocky
 *               |
 *               \--->Tucker 
 *
 */
