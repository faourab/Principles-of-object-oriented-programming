package tiles.units.enemies;
import View.CLI;
import tiles.Visitor;
import tiles.Wall;
import tiles.units.Unit;
import tiles.units.players.Player;
import tiles.units.Health;
import GameBoard.Position;


public class Enemy extends Unit implements Visitor {
    protected int experienceValue;

    public Enemy(Position position,char tile, String name, int hitPoints, int attack, int defense, int experienceValue) {
        super(position,tile, name, hitPoints, attack, defense);
        this.experienceValue = experienceValue;
    }

    public int experienceValue() {
        return experienceValue;
    }

    public void onDeath() {
        CLI.sendMessage("You killed this enemy "+this.Name);


    }
    public Health getHealth(){
        return this.health;
    }

    @Override
    public void accept(Unit unit) {
        unit.visit(this);
    }

    public void visit(Enemy e) {
        // Do nothing
    }

    public void battlep(Player p){
        CLI.sendMessage("The waaaaaaar is started");
        int attack = (int) (this.getAttackPoints()*Math.random());
        int defense = (int)(p.getDefensePoints()*Math.random());
        if(attack-defense>0){
             p.getHealth().takeDamage(attack - defense);
        }
    }

    public void visit(Player p) {
        battlep(p);
        if (!p.alive()) {
            p.onDeath();
        }

    }

    @Override
    public void visit(Wall w) {
    }


    @Override
    public Position gameTick() {
        return new Position(0,0);
    }
}