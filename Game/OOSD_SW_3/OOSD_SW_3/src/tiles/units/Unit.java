package tiles.units;
import tiles.Tile;
import GameBoard.Position;
public abstract class Unit extends Tile {
    protected String Name;
    protected Health health;
    protected  int Attackpoints;
    protected int Defensepoints;


    public Unit(Position pos ,char tile, String name, int hitPoints, int attack, int defense) {
        super(pos,tile);
        this.Name = name;
        this.health = new Health(hitPoints);
        this.Attackpoints = attack;
        this.Defensepoints = defense;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name){
        this.Name =name;
    }

    public int getHealthPool(){
        return (int) this.health.getCapacity();
    }
    abstract public Position gameTick();

    public void setHealthPool(int h){
        this.health.setCapacity(h);
    }

    public int getHealthAmount(){
        return (int) this.health.getCurrent();
    }
    public void setHealthAmount(int h){
        this.health.setCurrent(h);
    }
    public int getAttackPoints(){
        return this.Attackpoints;
    }
    public void setAttackPoints(int a){
        this.Attackpoints = a;
    }

    public int getDefensePoints(){
        return this.Defensepoints;
    }
    public void setDefensePoints(int a){
        this.Defensepoints = a;
    }





    public boolean alive(){
        return health.getCurrent() > 0;
    }


    public void interact(Tile t){
        t.accept(this);
    }
    public Position MoveUp(){
        return new Position(this.getPosition().getRow()-1,this.getPosition().getCol());
    }
    public Position MoveDown(){return new Position(this.getPosition().getRow()+1,this.getPosition().getCol());
    }
    public Position MoveLeft(){
        return new Position(this.getPosition().getRow(),this.getPosition().getCol()-1);
    }
    public Position MoveRight(){
        return new Position(this.getPosition().getRow(),this.getPosition().getCol()+1);
    }

    public String toString(){
        String ans = ""+Name+" with tile "+getTile();
        return ans;
    }





}
