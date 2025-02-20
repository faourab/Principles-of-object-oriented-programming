package tiles;

import tiles.units.Unit;
import tiles.units.enemies.Enemy;
import tiles.units.players.Player;
import GameBoard.Position;

public class Empty extends Tile {
    public static final char EMPTY_TILE = '.';

   public Empty(Position pos) {
            super(pos, EMPTY_TILE);
        }
        public void accept(Unit v){
            v.visit(this);
        }

    @Override
    public void visit(Enemy e) {

    }

    @Override
    public void visit(Player p) {

    }

    @Override
    public void visit(Wall w) {

    }
}








