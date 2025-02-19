import Calculator.Scalars.IntegerScalar;
import Calculator.Scalars.RationalScalar;
import Calculator.Scalars.Scalar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RationalScalarTest {
    RationalScalar s1 = new RationalScalar(1,2);
    RationalScalar s_1 = new RationalScalar(-1,2);
    RationalScalar s2 = new RationalScalar(1,4);
    RationalScalar s222 = new RationalScalar(1,-4);
    RationalScalar s_2 = new RationalScalar(-1,4);
    RationalScalar s1Pluss2 = new RationalScalar(3,4);
    RationalScalar s2PlussS_1 =new RationalScalar(-1,4);
    RationalScalar s_2PlusS_1= new RationalScalar(-3,4);
    RationalScalar s1Mulss2 = new RationalScalar(1,8);
    RationalScalar s1Mulss3 = new RationalScalar(-1,8);
    IntegerScalar s4 = new IntegerScalar(3);
    IntegerScalar s5 = new IntegerScalar(-2) ;
    IntegerScalar Zero = new IntegerScalar(0);
    IntegerScalar s44 = new IntegerScalar(1);
    IntegerScalar s33 = new IntegerScalar(-1);
    RationalScalar s4Muls1 = new RationalScalar(3,2);
    RationalScalar s5Muls3 = new RationalScalar(-3,2);
    RationalScalar s5MulS2 = new RationalScalar(3,2);
    Scalar resscalar;


    @Test
    void getNumerator() {//////////////////DONE
        int x = 1;
        assertEquals(x,s1.getNumerator());
        x = -1;
        assertEquals(x,s_1.getNumerator());
        x = 1;
        assertEquals(x,s222.getNumerator());
    }

    @Test
    void getDenominator() {////////////DONE
        int y = 2;
        assertEquals(y,s1.getDenominator());
        y = 2;
        assertEquals(y,s_1.getDenominator());
        y = -4;
        assertEquals(y,s222.getDenominator());
    }

    @Test
    void add() {////////////////////DONE
        resscalar = s1.add(s_1);
        assertEquals(resscalar.toString(),Zero.toString());
        resscalar = s2.add(s222);
        assertEquals(resscalar.toString(),Zero.toString());
        resscalar = s1.add(s2);
        assertEquals(resscalar,s1Pluss2);
        resscalar = s2.add(s_1);
        assertEquals(resscalar,s2PlussS_1);
        resscalar = s_2.add(s_1);
        assertEquals(resscalar,s_2PlusS_1);
        resscalar = s4.add(s1);
        assertEquals(resscalar,new RationalScalar(7,2));
        resscalar = s4.add(s_1);
        assertEquals(resscalar,new RationalScalar(5,2));
        resscalar = s33.add(s2);
        assertEquals(resscalar,new RationalScalar(-3,4));
    }

    @Test
    void addRat() {//////////////////////DONE
        resscalar = s1.addRat(s_1);
        assertEquals(resscalar.toString(),Zero.toString());
        resscalar = s2.addRat(s222);
        assertEquals(resscalar.toString(),Zero.toString());
        resscalar = s1.addRat(s2);
        assertEquals(resscalar,s1Pluss2);
        resscalar = s2.addRat(s_1);
        assertEquals(resscalar,s2PlussS_1);
        resscalar = s_2.addRat(s_1);
        assertEquals(resscalar,s_2PlusS_1);
    }

    @Test
    void addInt() {////////////////////////DONE
        resscalar = s1.addInt(s4);
        assertEquals(resscalar,new RationalScalar(7,2));
        resscalar = s_1.addInt(s4);
        assertEquals(resscalar,new RationalScalar(5,2));
        resscalar = s2.addInt(s33);
        assertEquals(resscalar,new RationalScalar(-3,4));
    }

    @Test
    void mul() {////////////////////DONE
        resscalar = s1.mul(s2);
        assertEquals(resscalar, s1Mulss2);
        resscalar = s1.mul(s_2);
        assertEquals(resscalar, s1Mulss3);
        resscalar = s4.mul(s1);
        assertEquals(resscalar, s4Muls1);
        resscalar = s5.mul(s_1);
        assertEquals(resscalar.toString(), s44.toString());
    }

    @Test
    void mulRat() {
        resscalar = s1.mulRat(s2);
        assertEquals(resscalar, s1Mulss2);
        resscalar = s1.mulRat(s_2);
        assertEquals(resscalar, s1Mulss3);
    }

    @Test
    void mulInt() {////////////////////DONE
        resscalar = s1.mulInt(s4);
        assertEquals(resscalar.toString(), s4Muls1.toString());
        resscalar = s_1.mulInt(s5);
        assertEquals(resscalar.toString(), s44.toString());
    }

    @Test
    void neg() {////////////////DONE
        resscalar = s1.neg();
        assertEquals(resscalar, s_1);
        resscalar = s_1.neg();
        assertEquals(resscalar, s1);
    }

    @Test
    void power() {///////////////////DONE
        resscalar = s1.power(2);
        assertEquals(resscalar, new RationalScalar(1, 4));
        resscalar = s_1.power(3);
        assertEquals(resscalar, new RationalScalar(-1, 8));
    }

    @Test
    void sign() {//////////////DONE
        assertEquals(1, s1.sign());
        assertEquals(-1, s_1.sign());
        assertEquals(0, Zero.sign());
    }

    @Test
    void testEquals() {
        assertTrue(s1.equals(new RationalScalar(1, 2)));
        assertFalse(s1.equals(s_1));
        assertTrue(s4.equals(new IntegerScalar(3)));
        assertFalse(s4.equals(s5));
    }

    @Test
    void reduce() {//////////////DONE
        RationalScalar rs = new RationalScalar(2, 4).reduce();
        assertEquals(new RationalScalar(1, 2), rs);
        rs = new RationalScalar(-2, 4).reduce();
        assertEquals(new RationalScalar(-1, 2), rs);
    }

    @Test
    void testToString() { ///////////////////DONE
        assertEquals("1/2", s1.toString());
        assertEquals("-1/2", s_1.toString());
        assertEquals("3", s4.toString());
        assertEquals("-2", s5.toString());
    }
}