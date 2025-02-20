package tiles.units.players;
import View.CLI;
import tiles.Visitor;
import tiles.Wall;
import tiles.units.Unit;
import tiles.units.enemies.Enemy;
import tiles.units.Health;
import GameBoard.Position;

public abstract class Player extends Unit implements Visitor {
    public static final char PLAYER_TILE = '@';
    protected static final int LEVEL_REQUIREMENT = 50;
    protected static final int HEALTH_GAIN = 10;
    protected static final int ATTACK_GAIN = 4;
    protected static final int DEFENSE_GAIN = 1;
    protected int level;
    protected int experience;

    public Player(Position pos, String name, int hitPoints, int attack, int defense) {
        super(pos, PLAYER_TILE, name, hitPoints, attack, defense);
        this.level = 1;
        this.experience = 0;
    }
    public Health getHealth(){
        return this.health;
    }

    public void addExperience(int experienceValue) {
        this.experience += experienceValue;
       if(experience >= levelRequirement()) {
            levelUp();
        }
    }

    public void levelUp() {
        this.experience -= levelRequirement();
        this.level++;
        int healthGain = healthGain();
        int attackGain = attackGain();
        int defenseGain = defenseGain();
        health.increaseMax(healthGain);
        health.heal();
        Attackpoints += attackGain;
        Defensepoints += defenseGain;
    }

    public void gain(Enemy e) {
        int EnemyExperience = e.experienceValue();
        setExperience(this.experience + EnemyExperience);
        setPosition(e.getPosition());
    }


    protected int levelRequirement() {
        return LEVEL_REQUIREMENT * level;
    }

    protected int healthGain() {
        return HEALTH_GAIN * level;
    }

    protected int attackGain() {
        return ATTACK_GAIN * level;
    }

    protected int defenseGain() {
        return DEFENSE_GAIN * level;
    }

    public void setPlayerLevel(int playerLevel) {
        level = playerLevel;
    }

    public void setExperience(int _experience) {
        experience = _experience;
    }


    public int getPlayerLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }


    public void visit(Wall w) {

    }

    public void visit(Player p) {

    }

    public Position gameTick() {
        String s = CLI.readFromuser();
        char input = s.charAt(s.length() - 1);
        OnGameTick();
        if (input == 'a')
            return MoveLeft();
        if (input == 's')
            return MoveDown();
        if (input == 'd')
            return MoveRight();
        if (input == 'w')
            return MoveUp();
        if (input == 'e')
            this.ability();
        else {
            //Do nothing
        }
        return getPosition();

    }

    public abstract void ability() ;
    public abstract void OnGameTick();


    public void accept(Unit v) {
        v.visit(this);
    }

    public void battle(Enemy e) {
        CLI.sendMessage("The waaaaaaar is started");
        int defenderEnemy = (int) (e.getDefensePoints() * Math.random());
        int thisattacker = (int) (this.getAttackPoints() * Math.random());
        if (thisattacker - defenderEnemy > 0) {
            e.getHealth().takeDamage(thisattacker - defenderEnemy);

        }

    }

    public void visit(Enemy e) {
        battle(e);
        if (!e.alive()) {
            addExperience(e.experienceValue());
            e.onDeath();
        }
    }

    public void onDeath() {
        //TODO: Implement onDeath
        super.setTile('X');
    }
}
