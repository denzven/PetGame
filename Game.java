import java.util.*;
import java.io.*;

//Class of Game
public class Game implements Serializable {
    private static final long serialVersionUID = 4L;
    List<Player> PlayerList;
    public Game(
            List<Player> PlayerList
    ){
        this.PlayerList = PlayerList; // PlayerList of the Game
    }

    public List<Player> getPlayerList()  {return PlayerList;}

    public String getStats(){
        return ("\nPlayerList: "       + ConsoleColors.GREEN  + this.getPlayerList()      + ConsoleColors.RESET);
    }

    public String Save(String SavedGameFile){
        try {
            FileOutputStream SavedGame = new FileOutputStream(SavedGameFile);    
            ObjectOutputStream out = new ObjectOutputStream(SavedGame);    
            out.writeObject(this);
            for (int i = 0; i < this.PlayerList.size(); i++) {
                        out.writeObject(this.PlayerList.get(i));
                        for (int j = 0; j < this.PlayerList.get(i).PetList.size();j++ ) {
                            out.writeObject(this.PlayerList.get(i).PetList.get(j));
                        }
                    }    
            out.flush();      
            out.close();      
            System.out.println("Successfully Saved the Game to " + SavedGameFile);
            return SavedGameFile;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return "error";
        } 
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
