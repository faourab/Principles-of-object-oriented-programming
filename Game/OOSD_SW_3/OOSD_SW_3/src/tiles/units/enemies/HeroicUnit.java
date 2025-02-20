package tiles.units.enemies;

import GameBoard.SingletonPE;
import tiles.units.players.Player;
import GameBoard.Position;

public class HeroicUnit extends Enemy{
    int vision_range;
    int ability_frequency;
    int combat_tickes;

    public HeroicUnit(Position p,char tile, String name, int hitPoints, int attack, int defense, int vision_range,int experienceValue,  int ability_frequency) {
        super(p,tile, name, hitPoints, attack, defense, experienceValue);
        this.vision_range = vision_range;
        this.ability_frequency = ability_frequency;
        this.combat_tickes = 0;
    }

    public Position gameTick() {
        Player p = SingletonPE.getPlayer();
        if (p.getRange(this) < vision_range) {
            if (combat_tickes == ability_frequency) {
                combat_tickes = 0;
                this.battlep(p);
            } else {
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
