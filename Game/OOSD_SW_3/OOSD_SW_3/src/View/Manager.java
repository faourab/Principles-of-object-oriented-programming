package View;
import GameBoard.Board;
import GameBoard.SingletonPE;
import View.CLI;
import java.util.List;
public class Manager {

    private List<List<String>>_listOfLevls;
    private CLI cli;

    public Manager(List<List<String>> listOfLevls){
        this._listOfLevls=listOfLevls;
        this.cli=  new CLI();
    }
    public void start(){
        boolean playerIsAlive = true;
        int playerchoosed =choosePlayer();
        for(int l = 0 ;l<_listOfLevls.size() & playerIsAlive;l++){
            CLI.display("Welcome to level "+(1+l));
            Board board = new Board();
            List<String> currLevel =  _listOfLevls.get(l);
            board.createBoard(currLevel,playerchoosed);
            board.startTheGame();
            playerIsAlive= SingletonPE.getPlayer().getHealthAmount()>0;
        }
        if(playerIsAlive) CLI.display("WIIIIIIIIIIIIIIIIIN");
        else CLI.display("GAME OVER, TRY AGAIN");
    }

    private int choosePlayer(){
        cli.display("^^^^^^^ >Welcome to the mohamad AND aed GAME< ^^^^^^^^");
        cli.display("your rule is to kill all the enemys in the board");
        cli.display("chose your hero:");
        cli.display("1. Warrior >> Jon Snow has 300 Health, 30 Attack, 4 Defense, and a Cooldown of 3");
        cli.display("2. Warrior >> The Hound has 400 Health, 20 Attack, 6 Defense, and a Cooldown of 5");
        cli.display("3. Mage >> Melisandre has 100 Health, 5 Attack, 1 Defense, a Mana Pool of 300, Mana Cost of 30, Spell Power of 15, Hit Count of 5, and a Range of 6");
        cli.display("4. Mage >> Thoros of Myr has 250 Health, 25 Attack, 4 Defense, a Mana Pool of 150, Mana Cost of 20, Spell Power of 20, Hit Count of 3, and a Range of 4.");
        cli.display("5. Rogue >> Arya Stark has 150 Health, 40 Attack, 2 Defense, and costs 20.");
        cli.display("6. Rogue >> Bronn has 250 Health, 35 Attack, 3 Defense, and costs 50.");
        cli.display("7. Hunter  >> Ygritte has 220 Health, 30 Attack, 2 Defense, and a Range of 6.");


        int inputInt =-1;
        while(inputInt<=0 | inputInt>8){
            cli.display("ENTER THE NUMBER OF YOUR CHOICE");
            String input = CLI.readFromuser();
            char inputChar = input.charAt(input.length()-1);
            inputInt = inputChar-'0';
        }
        return inputInt;

    }

}
