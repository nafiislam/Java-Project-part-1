import java.util.List;
import java.util.ArrayList;

public class Club {
    String name;
    private Player[] players;
    private int playerCount;
    Club(){
        players= new Player[7];
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
        players[playerCount-1]=p;
    }
    public void showSalary(){
        double d=0;
        for(int i=0;i<playerCount;i++){
            if(players[i].getSalary()>d)
                d= players[i].getSalary();
        }
        for(int i=0;i<playerCount;i++){
            if(players[i].getSalary()==d)
                players[i].show();
        }
    }
    public void showAge(){
        int d=0;
        for(int i=0;i<playerCount;i++){
            if(players[i].getAge()>d)
                d= players[i].getAge();
        }
        for(int i=0;i<playerCount;i++){
            if(players[i].getAge()==d)
                players[i].show();
        }
    }
    public void showHeight(){
        double d=0;
        for(int i=0;i<playerCount;i++){
            if(players[i].getHeight()>d)
                d= players[i].getHeight();
        }
        for(int i=0;i<playerCount;i++){
            if(players[i].getHeight()==d)
                players[i].show();
        }
    }
    public void showTotalSalary(){
        double d=0;
        for(int i=0;i<playerCount;i++){
            d+= players[i].getSalary()*52;
        }
        System.out.printf("%10f\n",d);;
    }

}
