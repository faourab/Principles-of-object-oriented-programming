import Calculator.Scalars.IntegerScalar;
import Calculator.Scalars.RationalScalar;
import Calculator.Scalars.Scalar;

import static org.junit.jupiter.api.Assertions.*;

class IntegerScalarTest {
    IntegerScalar s1 = new IntegerScalar(1);
    IntegerScalar s_1 = new IntegerScalar(-1);
    IntegerScalar s2 = new IntegerScalar(2);
    IntegerScalar s2_power3 =new IntegerScalar(8);

    IntegerScalar s3 = new IntegerScalar(3);
    IntegerScalar s4 = new IntegerScalar(6);
    IntegerScalar s5 = new IntegerScalar(-4);
    IntegerScalar s5_power2 = new IntegerScalar(16);
    IntegerScalar s6 = new IntegerScalar(-5);
    IntegerScalar s7 = new IntegerScalar(-9);
    IntegerScalar s8 = new IntegerScalar(1);
    IntegerScalar s9 = new IntegerScalar(0);
    IntegerScalar s10 = new IntegerScalar(9);
    IntegerScalar s11 = new IntegerScalar(-2);
    IntegerScalar s11_power3 =new IntegerScalar(-8);
    IntegerScalar s12 = new IntegerScalar(20);
    RationalScalar s13 = new RationalScalar(1,2);
    RationalScalar s14 = new RationalScalar(-1,2);
    RationalScalar s15 = new RationalScalar(-1,4);
    RationalScalar s16 = new RationalScalar(5,2);
    RationalScalar s17 = new RationalScalar(12,8);
    Scalar resScalar ;





    @org.junit.jupiter.api.Test
    void getNumber() {/////////////////////DONE
        assertEquals(s1.getNumber(),1);
        assertEquals(s5.getNumber(),-4);
        assertEquals(s9.getNumber(),0);


    }
    //@org.junit.jupiter.api.BeforeAll
    void stam(){
    }

    @org.junit.jupiter.api.Test
    void add() {///////////////////////////////////DONE
        resScalar = s1.add(s2);
        assertEquals(resScalar,s3);
        resScalar = s5.add(s6);
        assertEquals(resScalar,s7);
        resScalar = s4.add(s5);
        assertEquals(resScalar,s2);
        resScalar = s4.add(s9);
        assertEquals(resScalar,s4);
        resScalar = s1.add(s9);
        assertEquals(resScalar,s1);
        resScalar = s11.add(s2);
        assertEquals(resScalar,s9);
    }

    @org.junit.jupiter.api.Test
    void addInt() {/////////////////////DONE
     resScalar = s1.addInt(s2);
     assertEquals(resScalar,s3);
     resScalar = s5.addInt(s6);
     assertEquals(resScalar,s7);
     resScalar = s7.addInt(s10);
     assertEquals(resScalar,s9);
     resScalar = s5.addInt(s6);
     assertEquals(resScalar,s7);
    }

    @org.junit.jupiter.api.Test
    void addRat() {/////////////////DONE
        resScalar = s2.addRat(s13);
        assertTrue(s16.equals(resScalar));
        resScalar = s2.addRat(s14);
        assertTrue(s17.equals(resScalar));
        resScalar = s11.addRat(s13);
        assertTrue(s17.neg().equals(resScalar));
        resScalar = s11.addRat(s14);
        assertTrue(s16.neg().equals(resScalar));
    }

    @org.junit.jupiter.api.Test
    void mul() {////////////////////DONE
        resScalar = s1.mul(s9);
        assertEquals(resScalar,s9);
        resScalar = s2.mul(s3);
        assertEquals(resScalar,s4);
        resScalar = s5.mul(s6);
        assertEquals(resScalar,s12);
        resScalar = s2.mul(s11);
        assertEquals(resScalar,s5);
        resScalar = s5.mul(s9);
        assertEquals(resScalar,s9);



    }

    @org.junit.jupiter.api.Test
    void mulInt() {////////////////////////DONE
        resScalar = s1.mulInt(s9);
        assertEquals(resScalar,s9);
        resScalar = s2.mulInt(s3);
        assertEquals(resScalar,s4);
        resScalar = s5.mulInt(s6);
        assertEquals(resScalar,s12);
        resScalar = s2.mulInt(s11);
        assertEquals(resScalar,s5);
        resScalar = s5.mulInt(s9);
        assertEquals(resScalar,s9);
    }

    @org.junit.jupiter.api.Test
    void mulRat() {//////////////////DONE
        resScalar = s2.mulRat(s13);
        assertEquals(s1.toString(),resScalar.toString());
        resScalar = s9.mulRat(s13);
        assertEquals(s9.toString(),(resScalar).toString());
        resScalar = s2.mulRat(s14);
        assertEquals(s_1.toString(),(resScalar).toString());
        resScalar = s11.mulRat(s13);
        assertEquals(s_1.toString(),(resScalar).toString());
        resScalar = s11.mulRat(s14);
        assertEquals(s1.toString(),(resScalar).toString());
    }

    @org.junit.jupiter.api.Test
    void neg() {////////////////////////DONE
        resScalar = s1.neg();
        assertEquals(resScalar,s_1);
        resScalar = s11.neg();
        assertEquals(resScalar,s2);
        resScalar = s9.neg();
        assertEquals(resScalar,s9);

    }

    @org.junit.jupiter.api.Test
    void power() {////////////////////////DONE
        resScalar = s2.power(3);
        assertEquals(resScalar,s2_power3);
        resScalar = s11.power(3);
        assertEquals(resScalar,s11_power3);
        resScalar = s5.power(2);
        assertEquals(resScalar,s5_power2);
        resScalar = s2.power(0);
        assertEquals(resScalar,s1);
    }

    @org.junit.jupiter.api.Test
    void sign() {//////////////////////////DONE
        int res = s1.sign();
        assertEquals(res,1);
        res = s6.sign();
        assertEquals(res,-1);
        res = s9.sign();
        assertEquals(res,0);
    }

    @org.junit.jupiter.api.Test
    void testEquals() {///////////////DONE
        resScalar = s1;
        assertEquals(resScalar,s1);
        resScalar = s5;
        assertEquals(resScalar,s5);
        resScalar = s9;
        assertEquals(resScalar,s9);
    }

    @org.junit.jupiter.api.Test
    void testToString() {//////////////////////DONE
        String res = "1";
        assertEquals(res,s1.toString());
        res = "-4";
        assertEquals(res,s5.toString());
        res = "0";
        assertEquals(res,s9.toString());

    }
}