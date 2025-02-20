package GameBoard;

import tiles.units.enemies.Enemy;
import tiles.units.players.Player;

import java.util.*;
public class SingletonPE {
    private static List<Enemy> aliveEnemys;
    private static Player player;
    public static List<Enemy> getAllEnemys(){
        return aliveEnemys;
    }
    public static void addEnemy(Enemy e){
        aliveEnemys.add(e);
    }
    public static void removeEnemy(Enemy e){
        aliveEnemys.remove(e);
    }
    public static void setSingleton(List<Enemy> ens){
        aliveEnemys=ens;
    }

    public static Player getPlayer(){
        return player;
    }
    public static void setPlayer(Player p){
        player = p;
    }

    public static List<Enemy> getEnsInRange(int range, Position pos){
        List<Enemy> toReturn = new LinkedList<>();
        for (Enemy enemy:
                aliveEnemys) {
            if(enemy.getRange(player)<range) toReturn.add(enemy);
        }
        return toReturn;
    }
}
