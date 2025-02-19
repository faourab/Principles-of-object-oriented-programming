package Calculator.Scalars;

public class Monomial {
    private int exponent;
    private Scalar coefficient;

    public Monomial(int exp, Scalar coeff){
        this.exponent = exp;
        this.coefficient = coeff;
    }
    public int getExponent(){
        return this.exponent;
    }
    public Scalar getCoefficient(){
        return this.coefficient;
    }

    public Monomial addMon(Monomial s) {
        if (this.exponent != s.exponent)
            return null;
        else {
            return new Monomial(s.exponent , this.coefficient.add(s.coefficient));
        }
    }

    public Monomial mulMon(Monomial s){
        return new Monomial(s.exponent + this.exponent,s.coefficient.mul(this.coefficient));
    }
    public Monomial neg(){
        return new Monomial(this.exponent,this.coefficient.neg());
    }
    public Scalar evaluate(Scalar s){
        Scalar e = s.power(this.exponent);
        return e.mul(this.coefficient);
    }
    public Monomial derivative(){
        IntegerScalar oldexp = new IntegerScalar(this.exponent);
        int newexp = this.exponent-1;
        return new Monomial(newexp,oldexp.mul(this.coefficient));
    }

    public int sign() {
        return coefficient.sign();
    }

    public boolean equals(Object o){
        if ( (!(o instanceof Monomial)))
            return false;
        Monomial newM = (Monomial)o;
        if (newM.exponent != this.exponent)
            return false;
        return newM.coefficient.equals(this.coefficient);
    }


    public String toString(){
        if(exponent == 0 )
            return this.coefficient.toString();
        else if (exponent == 1 && this.coefficient.sign() != 0) {
            if (this.coefficient.toString().equals("1"))
                return "x";
            else
                return this.coefficient.toString() + "x";
        }

        else if (this.coefficient.sign() != 0){
            String res = this.coefficient.toString();
            if (res.equals("1")){
                res = "x^";
                res += this.exponent;
                return res;
            }
            else {
                res += "x^";
                res += this.exponent;
                return res;
            }
        }
        return "";
    }

}
