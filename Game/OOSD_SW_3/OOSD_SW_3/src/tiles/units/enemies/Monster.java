package tiles.units.enemies;
import GameBoard.SingletonPE;
import tiles.units.players.Player;
import GameBoard.Position;

public class Monster extends Enemy {

    private int vision_range;

    public Monster(Position p, char tile, String name, int hitPoints, int attack, int defense,int vision_range, int experienceValue) {
        super(p, tile, name, hitPoints, attack, defense, experienceValue);
        this.vision_range = vision_range;
    }

    public Position gameTick() {
        Player p = SingletonPE.getPlayer();
        if (p.getRange(this) < vision_range) {
            int dx = this.position.getCol() - p.getPosition().getCol();
            int dy = this.position.getRow() - p.getPosition().getRow();
            if (Math.abs(dx) > Math.abs(dy)) {
                if (dx > 0)
                    MoveLeft();
                else MoveRight();
            } else {
                if (dy > 0)
                    MoveUp();
                else
                    MoveDown();
            }
        }
        else {
            int pick = ((int) (Math.random() * 5));
            switch (pick){
                case 0:
                    return this.position;
                case 1:
                    return MoveLeft();
                case 2:
                    return MoveRight();
                case 3:
                    return MoveUp();
                case 4:
                    return MoveDown();
            }
        }
        return this.position;
    }
}

