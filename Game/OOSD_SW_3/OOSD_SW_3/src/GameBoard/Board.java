package GameBoard;

import View.CLI;
import tiles.Empty;
import tiles.Tile;
import tiles.Wall;
import tiles.units.Unit;
import tiles.units.enemies.Enemy;
import tiles.units.enemies.HeroicUnit;
import tiles.units.enemies.Monster;
import tiles.units.enemies.Trap;
import tiles.units.players.*;

import java.util.LinkedList;
import java.util.List;

public class Board {

    private Tile[][] tiles;
    private List<Enemy> deadEnms;


    public void createBoard(List<String> level, int player) {
        tiles = new Tile[level.size()][level.get(0).length()];
        deadEnms = new LinkedList<>();
        boolean playerChosed = false;
        List<Enemy> enms = new LinkedList<>();
        for (int i = 0; i < tiles.length; i++) {
            String stringRow = level.get(i);
            for (int j = 0; j < stringRow.length(); j++) {
                char cube = stringRow.charAt(j);

                switch (cube) {
                    case '.':
                        Empty e = new Empty(new Position(i, j));
                        tiles[i][j] = e;
                        break;
                    case '#':
                        Wall w = new Wall(new Position(i, j));
                        tiles[i][j] = w;
                        break;
                    case '@':
                        if (!playerChosed) {
                            Player p = getChosenPlayer(player, new Position(i, j));
                            SingletonPE.setPlayer(p);
                            tiles[i][j] = p;
                        } else {
                            tiles[i][j] = SingletonPE.getPlayer();
                        }
                        break;
                    default:
                        Enemy enemy = (getUnitByChar(cube, new Position(i, j)));
                        tiles[i][j] = enemy;
                        enms.add(enemy);
                        break;
                }
            }
        }
        SingletonPE.setSingleton(enms);
        printBoard();
    }

    public void printBoard() {
        String board = "";
        for (Tile[] tile : tiles) {
            board += "\n";
            for (int i = 0; i < tile.length; i++) {
                if (tile[i] != null) {
                    board += tile[i].getTile();
                }
            }
        }
        board = board + "\n";
        CLI.display(board);
    }


    public void startTheGame() {
        Player p = SingletonPE.getPlayer();
        while (p.getHealthAmount() > 0 & !SingletonPE.getAllEnemys().isEmpty()) {

            GameAction(p);
            DeathUnits();
            List<Enemy> ens = SingletonPE.getAllEnemys();
            for (Enemy e : ens) {
                GameAction(e);
            }
            CLI.printAllMessages();
            printBoard();
        }
        if (p.getHealthAmount() <= 0) {
            p.onDeath();
            printBoard();
        } else {
            CLI.display("level achieved ;)");
            p.levelUp();
        }

    }
    private void GameAction(Unit p){
        Position lastPos= p.getPosition();

        Position newPos = p.gameTick();
        if(!newPos.equals(lastPos)){
            Tile visitedTile = tiles[newPos.getRow()][newPos.getCol()];
            visitedTile.accept(p);

            if(p.getPosition().equals(newPos)){
                tiles[lastPos.getRow()][lastPos.getCol()] = new Empty(lastPos);
                tiles[newPos.getRow()][newPos.getCol()] = p;
            }
        }
    }

    private void DeathUnits(){
        for (Enemy e:SingletonPE.getAllEnemys()) {
            if(e.getHealth().getCurrent()<=0) {
                Position p = e.getPosition();
                tiles[p.getRow()][p.getCol()] = new Empty(p);
                deadEnms.add(e);
            }
        }
        for (Enemy e:deadEnms) {
            Position pos = e.getPosition();
            SingletonPE.getAllEnemys().remove(e);
            tiles[pos.getRow()][pos.getCol()]= SingletonPE.getPlayer();
            Position playerPos = SingletonPE.getPlayer().getPosition();
            SingletonPE.getPlayer().gain(e);
            tiles[playerPos.getRow()][playerPos.getCol()] = new Empty(playerPos);
        }
        deadEnms =new LinkedList<>();
    }




    private Enemy getUnitByChar(char tile, Position pos) {
        if (tile == 's') {

            return new Monster(pos, tile, "Lannister Soldier", 80, 8, 3, 3, 25);
        }
        if (tile == 'k') {

            return new Monster(pos, tile, "Lannister Knight", 200, 14, 8, 4, 50);
        }
        if (tile == 'q') {
            return new Monster(pos, tile, "Queen’s Guard", 400, 20, 15, 5, 100);
        }
        if (tile == 'z') {
            return new Monster(pos, tile, "Wright", 600, 30, 15, 3, 100);
        }
        if (tile == 'b') {
            return new Monster(pos, tile, "Bear-Wright", 1000, 75, 30, 4, 250);
        }
        if (tile == 'g') {
            return new Monster(pos, tile, "Giant-Wright", 1500, 100, 40, 5, 500);
        }
        if (tile == 'w') {
            return new Monster(pos, tile, "White Walker", 2000, 150, 50, 6, 1000);
        }
        if (tile == 'M') {
            return new HeroicUnit(pos, tile, "The Mountain", 1000, 60, 25, 6, 500,5);
        }
        if (tile == 'C') {
            return new HeroicUnit(pos, tile, "Queen Cersei", 100, 10, 10, 1, 1000,8);
        }
        if (tile == 'K') {
            return new HeroicUnit(pos, tile, "Night’s King", 5000, 300, 150, 8, 5000,3);
        }
        if (tile == 'B') {
            return new Trap(pos, tile, "Bonus Trap", 1, 1, 1, 250, 1, 5);
        }
        if (tile == 'Q') {
            return new Trap(pos, tile, "Queen's Trap", 250, 50, 10, 100, 3, 7);
        }
        if (tile == 'D') {
            return new Trap(pos, tile, "Death Trap", 500, 100, 20, 250, 1, 10);
        } else {
            throw new IllegalArgumentException("the level have undefined char " + tile);
        }
    }

    private Player getChosenPlayer(int choice, Position pos) {
        if (choice == 1) {
            return new Warrior(pos, "Jon Snow", 5, 300, 30, 4);
        }
        if (choice == 2) {
            return new Warrior(pos, "The Hound", 5, 400, 20, 6);
        }
        if (choice == 3) {
            return new Mage(pos, "Melisandre", 100, 5, 1, 300, 30, 15, 5, 6);
        }
        if (choice == 4) {
            return new Mage(pos, "Thoros of Myr", 250, 25, 4, 150, 20, 20, 3, 4);
        }
        if (choice == 5) {
            return new Rogue(pos, "Arya Stark", 150, 40, 2, 20);
        }
        if (choice == 6) {
            return new Rogue(pos, "Bronn", 250, 35, 3, 50);
        }
        if (choice == 7) {
            return new Hunter(pos, "Ygritte", 220, 30, 2, 6);
        }

        throw new IllegalArgumentException();
    }


}
