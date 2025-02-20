package tiles;

import tiles.Empty;
import tiles.Wall;
import tiles.units.Unit;
import tiles.units.*;
import tiles.units.enemies.Enemy;
import tiles.units.players.Player;

public interface Visitor {
    public void visit(Enemy e);
    public void visit(Player p);
    public void visit(Wall w);
    public void visit(Empty e);
    public void accept(Unit  v);
}

