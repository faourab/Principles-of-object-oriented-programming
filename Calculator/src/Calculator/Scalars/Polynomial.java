package Calculator.Scalars;

import java.util.HashMap;
import java.lang.Integer;
public class Polynomial{
    //private  List<Calculator.Scalars.Monomial> monomials;
    private  HashMap<Integer,Monomial> monomials ;

    public Polynomial(HashMap<Integer,Monomial> other){
        monomials = new HashMap<>();
        this.monomials = other;
        //this.monomials = m;
    }

    public HashMap<Integer,Monomial> getMonomials(){
        return monomials;
    }

    public static Polynomial build(String input) {
        //Calculator.Scalars.Polynomial pol = new Calculator.Scalars.Polynomial();
        input = input + ' ';
        HashMap<Integer,Monomial> finallist = new HashMap<>();
        int exp = 0;
        int index_of_space;
        int index_of_dev;
        while (!input.equals("")) {
            index_of_space = input.indexOf(' ');
            String sub = input.substring(0, index_of_space);
            index_of_dev = sub.indexOf('/');

            if (index_of_dev == -1) {
                finallist.put(exp,new Monomial(exp, new IntegerScalar(Integer.parseInt(sub))));
                exp++;
            }
            else{
                String numerator = sub.substring(0, index_of_dev);
                String denumrator = sub.substring(index_of_dev + 1);
                finallist.put(exp,new Monomial(exp, new RationalScalar(Integer.parseInt(numerator), Integer.parseInt(denumrator))));
                exp++;
            }
            input = input.substring(index_of_space + 1);
        }
        return new Polynomial(finallist);//////////////////// i dont know what i should return
    }

    public Polynomial add(Polynomial p) {
        HashMap<Integer, Monomial> finallist = new HashMap<>();
        int localsize = this.monomials.size();
        int newsize = p.monomials.size();
        int i;
        for (i = 0; i < localsize && i < newsize; i++){
            finallist.put(p.monomials.get(i).getExponent(),new Monomial(p.monomials.get(i).getExponent(), p.monomials.get(i).getCoefficient().add(this.monomials.get(i).getCoefficient())));
        }
        if( localsize!=newsize){

            if (newsize>localsize) {
                for (int j = i; j < newsize; j++) {
                    finallist.put(p.monomials.get(j).getExponent(),new Monomial(p.monomials.get(j).getExponent(), p.monomials.get(j).getCoefficient()));
                }
            }else {
                for (int j = i; j < localsize; j++) {
                    finallist.put(this.monomials.get(j).getExponent(),new Monomial(this.monomials.get(j).getExponent(), this.monomials.get(j).getCoefficient()));
                }
            }
        }
        return new Polynomial(finallist);
    }


    public Scalar evaluate(Scalar s){
        Scalar res = this.monomials.get(0).evaluate(s);
        for (int i = 1; i <= this.monomials.size()-1; i++){
            res = res.add(this.monomials.get(i).evaluate(s));
        }
        return res;


    }

    public Polynomial derivative(){
        HashMap<Integer,Monomial> finallist = new HashMap<>();
        for (int i = 1; i < this.monomials.size(); i++) {
            finallist.put(this.monomials.get(i).getExponent()-1,this.monomials.get(i).derivative());
        }
        return new Polynomial(finallist);//////////////////// i dont know what i should return
    }



    public Polynomial mul(Polynomial p){

        HashMap<Integer,Monomial> finallist = new HashMap<>();
        for (Monomial M :p.monomials.values()){
            for (Monomial mo: this.monomials.values()){
                int newExponent = M.getExponent()+mo.getExponent();
                if(!finallist.containsKey(newExponent)) finallist.put(newExponent,M.mulMon(mo));
                else finallist.put(newExponent,finallist.get(newExponent).addMon(M.mulMon(mo)));
            }
        }
        return new Polynomial(finallist);//////////////////// i dont know what i should return
    }

    public boolean equals(Object o){
        if (!(o instanceof Polynomial))
            return false;
        Polynomial pol = (Polynomial) o;
        if (pol.monomials.size() != this.monomials.size())
            return false;
        for (int i = 0; i <= this.monomials.size()-1; i++) {
            if (!this.monomials.get(i).equals(pol.monomials.get(i)))
            return false;
        }
        return true;
    }
    public String toString(){
        String res = "";
        for (int i = 0; i <= this.monomials.keySet().size()-1; i++){
            if (i<1)
                res += this.monomials.get(i).toString();
            else if (this.monomials.get(i).getCoefficient().sign()!=0){
                if (this.monomials.get(i).sign() < 0) {
                    res += " - ";
                    res += this.monomials.get(i).neg().toString();
                } else {
                    res += " + ";
                    res += this.monomials.get(i).toString();
                }
            }
        }
        return res;
    }
}
