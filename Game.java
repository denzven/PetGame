import java.util.*;
import java.io.*;

//Class of Game
public class Game implements Serializable {
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

    public String Save(){
        try {
             String SavedGameFile = "SavedGame.txt";
            // FileWriter SavedGame = new FileWriter(SavedGameFile);
            // SavedGame.write("Game is Saved to this file");
            // // any better way?
            // SavedGame.close();

            FileOutputStream SavedGame = new FileOutputStream(SavedGameFile);    
            ObjectOutputStream out = new ObjectOutputStream(SavedGame);    
            out.writeObject(this);    
            out.flush();    
            //closing the stream    
            out.close();      
            System.out.println("Successfully Saved the Game to " + SavedGameFile);
            return SavedGameFile;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return "error";
        } 
    }
    public List Load(){
        try{
            String SavedGameFile = "SavedGame.txt";  
            //Creating stream to read the object  
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(SavedGameFile));  
            Game Game=(Game)in.readObject();
            System.out.println(Game.PlayerList.get(0).getName());   
            //closing the stream 
            //in.close();  
            return Game.PlayerList; 
        }catch(Exception e){
            System.out.println(e);
            return null;
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
