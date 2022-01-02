import java.util.List;

public class Game {
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
}
