import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Method {
    private static final String INPUT_FILE_NAME = "players.txt";
    private static final String OUTPUT_FILE_NAME = "players.txt";

    public static void menu(List<Player> playerList, List<Club>clubList, List<Country>countryList){
        System.out.println("Main Menu:\n" +
                "(1) Search Players\n" +
                "(2) Search Clubs\n" +
                "(3) Add Player\n" +
                "(4) Exit System");
        System.out.print("Input Option:");
        Scanner scn=new Scanner(System.in);
        int a=scn.nextInt();
        if(a==1){
            search(playerList,clubList,countryList);
        }
        else if(a==2){
            find(playerList,clubList,countryList);

        }
        else if(a==3){
            addPlayer(playerList,clubList,countryList);
        }
        else if(a==4){
        }
        else {
            System.out.println("Error:Inputs must be between 1-4");
            menu(playerList,clubList,countryList);
        }
    }
    public static void search(List<Player>playerList, List<Club>clubList, List<Country>countryList){
        Scanner scn = new Scanner(System.in);
        System.out.println("Player Searching Options:\n" +
                "(1) By Player Name\n" +
                "(2) By Club and Country\n" +
                "(3) By Position\n" +
                "(4) By Salary Range\n" +
                "(5) Country-wise player count\n" +
                "(6) Back to Main Menu");
        System.out.print("Input Option:");
        int b = scn.nextInt();
        scn.nextLine();
        if (b == 1) {
            System.out.print("Input Player Name:");
            String n = scn.nextLine();
            search1(n, playerList);
            scn.nextLine();
            search(playerList,clubList,countryList);

        }
        else if (b == 2) {
            System.out.print("Input Country Name:");
            String country = scn.nextLine();
            //scn.nextLine();
            System.out.print("Input Club Name:");
            String club = scn.nextLine();
            search2(country, club, countryList);
            scn.nextLine();
            search(playerList,clubList,countryList);
        }
        else if (b == 3) {
            System.out.print("Input Position:");
            String position = scn.nextLine();
            search3(position, playerList);
            scn.nextLine();
            search(playerList,clubList,countryList);
        }
        else if (b == 4) {
            System.out.print("Input Salary low limit:");
            while(!scn.hasNextDouble()){
                System.out.println("Error:Input Salary low limit in double type");
                scn.next();
                System.out.print("Input Salary low limit:");
            }
            double low = scn.nextDouble();
            System.out.print("Input Salary high limit:");
            while(!scn.hasNextDouble()){
                System.out.println("Error:Input Salary high limit in double type");
                scn.next();
                System.out.print("Input Salary low limit:");
            }
            double high = scn.nextDouble();
            search4(low, high, playerList);
            scn.nextLine();
            scn.nextLine();
            search(playerList,clubList,countryList);
        }
        else if (b == 5) {
            search5(countryList);
            scn.nextLine();
            search(playerList,clubList,countryList);
        }
        else if (b == 6)
            menu(playerList,clubList,countryList);
        else {
            System.out.println("Error:Inputs must be between 1-6");
            search(playerList,clubList,countryList);
        }
    }
    public static void find(List<Player>playerList, List<Club>clubList, List<Country>countryList){
        Scanner scn = new Scanner(System.in);
        System.out.println("Club Searching Options:\n" +
                "(1) Player(s)with the maximum salary of a club\n" +
                "(2) Player(s)with the maximum age of a club\n" +
                "(3) Player(s)with the maximum height of a club\n" +
                "(4) Total yearly salary of a club\n" +
                "(5) Back to Main Menu");
        System.out.print("Input Option:");
        int d=scn.nextInt();
        scn.nextLine();
        if(d==1) {
            System.out.print("Input Club Name:");
            String nc=scn.nextLine();
            find1(nc,clubList);
            scn.nextLine();
            find(playerList,clubList,countryList);
        }
        else if(d==2) {
            System.out.print("Input Club Name:");
            String nc=scn.nextLine();
            find2(nc,clubList);
            scn.nextLine();
            find(playerList,clubList,countryList);
        }
        else if(d==3) {
            System.out.print("Input Club Name:");
            String nc=scn.nextLine();
            find3(nc,clubList);
            scn.nextLine();
            find(playerList,clubList,countryList);
        }
        else if(d==4){
            System.out.print("Input Club Name:");
            String nc=scn.nextLine();
            find4(nc,clubList);
            scn.nextLine();
            find(playerList,clubList,countryList);
        }
        else if(d==5)
            menu(playerList,clubList,countryList);
        else{
            System.out.println("Error:Inputs must be between 1-5");
            find(playerList,clubList,countryList);
        }
    }
    public static void addPlayer(List<Player>playerList, List<Club>clubList, List<Country>countryList){
        Scanner scn = new Scanner(System.in);
        double d;
        int i;
        Player pl = new Player();
        System.out.println("Input Player:");
        System.out.print("Input player name: ");
        pl.setName(scn.nextLine());
        System.out.print("Input country name: ");
        pl.setCountry(scn.nextLine());
        System.out.print("Input age: ");
        while(true){
            while(!scn.hasNextInt()){
                scn.next();
                System.out.println("Error: Input integer");
                System.out.print("Input age: ");
            }
            i=scn.nextInt();
            if(i>0){
                pl.setAge(i);
                break;
            }
            else {
                System.out.println("Error: Input positive integer");
                System.out.print("Input age: ");
            }
        }
        System.out.print("Input height: ");
        while(true) {
            while(!scn.hasNextDouble()){
                scn.next();
                System.out.println("Error: Input should be double type");
                System.out.print("Input height: ");
            }
            d=scn.nextDouble();
            if(d>0){
                pl.setHeight(d);
                break;
            }
            else{
                System.out.println("Error: Input should be positive double type");
                System.out.print("Input height: ");
            }
        }

        System.out.print("Input club name: ");
        scn.next();
        pl.setClub(scn.nextLine());
        System.out.print("Input position: ");
        pl.setPosition(scn.nextLine());
        System.out.print("Input number: ");
        while(true){
            while(!scn.hasNextInt()){
                scn.next();
                System.out.println("Error: Input integer");
                System.out.print("Input number: ");
            }
            i=scn.nextInt();
            if(i>0){
                pl.setNumber(i);
                break;
            }
            else{
                System.out.println("Error: Input positive integer");
                System.out.print("Input number: ");
            }
        }

        System.out.print("Input Weekly Salary: ");
        while(true){
            while(!scn.hasNextDouble()){
                scn.next();
                System.out.println("Error: Input should be double type");
                System.out.print("Input Weekly Salary: ");
            }
            d=scn.nextDouble();
            if(d>0){
                pl.setSalary(d);
                break;
            }
            else{
                System.out.println("Error: Input should be positive double type");
                System.out.print("Input Weekly Salary: ");
            }
        }
        if(!playerNameChecker(playerList,pl)&& !numberChecker(playerList,pl)&& positionChecker(pl)){
            if(clubListAdder(clubList,pl)){
                playerList.add(pl);
                countryListAdder(countryList,pl);
            }
        }
        scn.nextLine();
        menu(playerList,clubList,countryList);
    }
    public static boolean playerNameChecker(List<Player> playerList,Player pl){
        for(Player p :playerList){
            if(p.getName().equalsIgnoreCase(pl.getName())){
                System.out.println("Error: Player already present");
                return true;
            }
        }
        return false;
    }
    public static boolean numberChecker(List<Player> playerList,Player pl){
        for(Player p :playerList){
            if(p.getNumber()==pl.getNumber()){
                System.out.println("Error: Player with same number is already present in the club");
                return true;
            }
        }
        return false;
    }
    public static boolean positionChecker(Player pl){
        if(pl.getPosition().equalsIgnoreCase("Goalkeeper")||pl.getPosition().equalsIgnoreCase("Defender")||pl.getPosition().equalsIgnoreCase("Midfielder") || pl.getPosition().equalsIgnoreCase("Forward")){
            System.out.println("Error: position can only be Goalkeeper ,Defender ,Midfielder or Forward");
            return true;
        }
        return false;
    }
    public static List<Player> readFromFile() throws Exception {
        List<Player> playerList = new ArrayList();
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            Player s = new Player();
            playerCreation(s,line);
            playerList.add(s);
        }
        br.close();
        return playerList;
    }

    public static void writeToFile(List<Player> playerList) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
        for (Player s : playerList) {
            bw.write(s.getName() + "," + s.getCountry() + "," + s.getAge() + "," + s.getHeight()+ "," + s.getClub()+ "," + s.getPosition()+ "," + s.getNumber()+ "," + s.getSalary());
            bw.write("\n");
        }
        bw.close();
    }
    public static void playerCreation(Player pl,String line){
        String[] tokens1 =line.split(",");
        pl.setName(tokens1[0]);
        pl.setCountry(tokens1[1]);
        pl.setAge((Integer.parseInt(tokens1[2])));
        pl.setHeight(Double.parseDouble(tokens1[3]));
        pl.setClub(tokens1[4]);
        pl.setPosition(tokens1[5]);
        pl.setNumber(Integer.parseInt(tokens1[6]));
        pl.setSalary(Double.parseDouble(tokens1[7]));
    }
    public static boolean clubListAdder(List<Club> clubList,Player pl){
        boolean isClubPresent=false;
        for (Club c:clubList){
            if(c.getName().equalsIgnoreCase(pl.getClub())){
                isClubPresent=true;
                if(c.getPlayerCount()==7) {
                    System.out.println("Club is not available");
                    break;
                }
                else{
                    c.addPlayer(pl);
                    return true;
                }
            }
        }
        if(!isClubPresent){
            Club c2=new Club();
            c2.setName(pl.getClub());
            c2.addPlayer(pl);
            clubList.add(c2);
            return true;
        }
        return false;
    }

    public static void countryListAdder(List<Country> countryList,Player s){
        Country co=new Country();
        co.setName(s.getCountry());
        co.addPlayer(s);
        boolean isCountry=false;
        for(int i=0;i<countryList.size();i++){
            if(s.getCountry().equalsIgnoreCase(countryList.get(i).getName())){
                countryList.get(i).addPlayer(s);
                isCountry=true;
                break;
            }
        }
        if(!isCountry){
            countryList.add(co);
        }
    }

    public static void search1(String name,List<Player> playerList ){
        boolean isPlayer=false;
        for(Player s:playerList){
            if(s.getName().equalsIgnoreCase(name)){
                s.show();
                isPlayer=true;
            }
        }
        if(!isPlayer)
            System.out.println("No such player with this name");
    }
    public static void search2(String country, String club, List<Country> countryList){
        boolean isCountry=false;
        for(Country c:countryList){
            if(c.getName().equalsIgnoreCase(country)){
                if(club.equalsIgnoreCase("any")){
                    c.showFull();
                }
                else{
                    c.showPartial(club);
                }
                isCountry=true;
                break;
            }
        }
        if(!isCountry)
            System.out.println("No such player with this country and club");
    }
    public static void search3(String position, List<Player>playerList){
        boolean isPosition=false;
        for(Player s:playerList){
            if(s.getPosition().equalsIgnoreCase(position)){
                s.show();
                isPosition=true;
            }
        }
        if(!isPosition)
            System.out.println("No such player with this position");
    }
    public static void search4(double low, double high, List<Player> playerList){
        boolean isSalary=false;
        for(Player s:playerList){
            if(s.getSalary()>=low && s.getSalary()<=high){
                s.show();
                isSalary=true;
            }
        }
        if(!isSalary)
            System.out.println("No such player with this weekly salary range");
    }
    public static void search5(List<Country> countryList){
        boolean isC=false;
        for(Country c:countryList){
            System.out.println(c.getName()+ " has "+c.getPlayerCount()+ " players");
            isC=true;
        }
        if(!isC)
            System.out.println("No such country available");
    }
    public static void find1(String name, List<Club> clubList){
        boolean isClub=false;
        for( Club c:clubList){
            if(c.getName().equalsIgnoreCase(name)){
                c.showSalary();
                isClub=true;
                break;
            }
        }
        if(!isClub)
            System.out.println("No such club with this name");

    }
    public static void find2(String name, List<Club> clubList){
        boolean isClub=false;
        for( Club c:clubList){
            if(c.getName().equalsIgnoreCase(name)){
                c.showAge();
                isClub=true;
                break;
            }
        }
        if(!isClub)
            System.out.println("No such club with this name");
    }
    public static void find3(String name, List<Club> clubList){
        boolean isClub=false;
        for( Club c:clubList){
            if(c.getName().equalsIgnoreCase(name)){
                c.showHeight();
                isClub=true;
                break;
            }
        }
        if(!isClub)
            System.out.println("No such club with this name");
    }
    public static void find4(String name, List<Club> clubList){
        boolean isClub=false;
        for( Club c:clubList){
            if(c.getName().equalsIgnoreCase(name)){
                c.showTotalSalary();
                isClub=true;
                break;
            }
        }
        if(!isClub)
            System.out.println("No such club with this name");
    }
}
