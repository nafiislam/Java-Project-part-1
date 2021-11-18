import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main extends Method {
    public static void main(String[] args) throws Exception {
        List<Player> playerList = readFromFile();
        List<Club> clubList = new ArrayList();
        List<Country> countryList= new ArrayList();
        for(Player s: playerList){
            clubListAdder(clubList,s);
        }
        for(Player s: playerList){
            countryListAdder(countryList,s);
        }
        menu(playerList,clubList,countryList);
        writeToFile(playerList);
    }
}
