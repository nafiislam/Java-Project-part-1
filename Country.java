import java.util.ArrayList;
import java.util.List;
public class Country {
    private String name;
    private List<Player> players;
    private int playerCount;
    Country(){
        players= new ArrayList();
        playerCount=0;
    }

    public String getName() {
        return name;
    }
    public int getPlayerCount() {
        return playerCount;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void addPlayer(Player p){
        playerCount++;
        players.add(p);
    }
    public void showFull(){
        for(int i=0;i<playerCount;i++){
            players.get(i).show();
        }
    }
    public void showPartial(String club) {
        boolean isClub = false;
        for (int i = 0; i < playerCount; i++) {
            if (players.get(i).getClub().equalsIgnoreCase(club)) {
                players.get(i).show();
                isClub = true;
            }
        }
        if (!isClub)
            System.out.println("No such player with this country and club");
    }
}
