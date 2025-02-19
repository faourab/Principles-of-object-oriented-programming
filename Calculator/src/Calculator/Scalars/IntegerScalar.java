package Calculator.Scalars;

public class IntegerScalar implements Scalar {

    private int number;
    public IntegerScalar(int num){
        this.number=num;
    }
    public int getNumber(){
        return this.number;
    }

    public Scalar add(Scalar s){
    return s.addInt(this);
    }

    public Scalar addInt(IntegerScalar s){
        return new IntegerScalar( s.number+this.number);
    }
    public Scalar addRat(RationalScalar s){
        return new RationalScalar((s.getDenominator() * this.number) +( s.getNumerator()),s.getDenominator());
    }

    public Scalar mul(Scalar s){
        return s.mulInt(this);
    }
    public Scalar mulInt(IntegerScalar s){
        return new IntegerScalar(s.number*this.number);
    }
    public Scalar mulRat(RationalScalar r){
        return r.mulInt(this);
    }
    public Scalar neg(){
        return new IntegerScalar(-this.number);
    }
    public Scalar power (int exponent){
        double m = Math.pow((double) (this.number),(double) (exponent));
        return new IntegerScalar((int)m);
    }
    public int sign() {
        if (this.number == 0 )
            return 0;
        else if (this.number > 0 )
            return 1;
        else
            return -1;


    }
    public boolean equals(Object other){
        if (!(other instanceof IntegerScalar))
            return false;
        IntegerScalar o = (IntegerScalar)other;
        return o.number == this.number;
    }
    public String toString(){
        int n = this.number;
        return  "" + n;
    }


}
