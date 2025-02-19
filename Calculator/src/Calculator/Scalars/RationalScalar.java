package Calculator.Scalars;

public class RationalScalar implements Scalar {
    private int numerator;

    private int denominator;

    public RationalScalar(int nume, int deno){
        this.numerator=nume;
        this.denominator=deno;
    }
    public int getNumerator(){
        return numerator;
    }
    public int getDenominator(){
        return denominator;
    }

    public Scalar add(Scalar s){
        return s.addRat(this);
    }

    public Scalar addRat(RationalScalar s){
        if (this.denominator == s.denominator) {
            return (new RationalScalar(s.numerator + this.numerator, this.denominator).reduce());
        }
        int new_numerator;
        int new_denominator;
        new_numerator = this.numerator * s.denominator + s.numerator * this.denominator;
        new_denominator = this.denominator * s.denominator;
        return new RationalScalar(new_numerator,new_denominator).reduce();
    }

    public Scalar addInt(IntegerScalar s){

        return new RationalScalar((this.denominator * s.getNumber()) +( this.numerator),this.denominator);
    }

    public Scalar mul(Scalar s){
        return s.mulRat(this);
    }

    public Scalar mulRat(RationalScalar s){
        return new RationalScalar(s.numerator*this.numerator,s.denominator*this.denominator).reduce();
    }

    public Scalar mulInt(IntegerScalar s){
        return new RationalScalar(this.numerator*s.getNumber(),this.denominator).reduce();
    }


    public Scalar neg(){
        return new RationalScalar(-this.numerator,this.denominator).reduce();
    }

    public Scalar power (int exponent){
        double m = Math.pow((double) (this.numerator),(double) (exponent));
        double n = Math.pow((double) (this.denominator),(double) (exponent));
        return new RationalScalar((int) m,(int) n).reduce();
    }

    public int sign() {
        if (this.numerator == 0 )
            return 0;
        else if (this.numerator * this.denominator > 0)
            return 1;
        else
            return -1;


    }

    public boolean equals(Object other){
        if (!(other instanceof RationalScalar))
            return false;
        RationalScalar o = ((RationalScalar) other).reduce();
        RationalScalar red =this.reduce();
        return red.numerator == o.numerator && red.denominator == o.denominator;
    }

    public RationalScalar reduce() {
        int nu = numerator;
        int de = denominator;
        if (nu%de==0){
            return new RationalScalar(numerator/ denominator,1);
//            numerator=numerator/ denominator;
//            denominator=1;
        }
        else {
            int r = nu % de;
            while (r != 0) {
                nu = de;
                de = r;
                r = nu % de;
            }
            return new RationalScalar(numerator / de,denominator / de);

////            numerator = numerator / de;
//            denominator = denominator / de;
        }
        }


    public String toString(){
        RationalScalar red = this.reduce();
        int nu = red.numerator;
        int de = red.denominator;
        String res = "";
        if (nu % de == 0){
            int ret = nu /de ;
            res += ret;
        }
        else if (red.sign() > 0) {
            if (red.numerator > 0)
                res = res + nu + "/" + de;
            else
                res = res+ (-nu) +"/"+ (-de);
        }
        else {
            if (red.numerator < 0)
                res = res + "-" +  (-nu) +"/"+ de;
            else
                res = res + "-" +  nu +"/"+ (-de);
        }
        return res;
    }
}
