import Calculator.Scalars.IntegerScalar;
import Calculator.Scalars.Monomial;
import Calculator.Scalars.RationalScalar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonomialTest {
    Monomial mon1 = new Monomial(2, new RationalScalar(1, 2));
    Monomial mon2 = new Monomial(2, new RationalScalar(1, 2));
    Monomial mon3 = new Monomial(2, new IntegerScalar(1));
    Monomial mon4 = new Monomial(3, new RationalScalar(3, 4));
    Monomial monNeg = new Monomial(2, new RationalScalar(-1, 2));
    Monomial monexp0 = new Monomial(0, new RationalScalar(-1, 2));
    Monomial monexp1 = new Monomial(1, new RationalScalar(-1, 2));


    @Test
    void getExponent() {///////////////DONE
        assertEquals(2, mon1.getExponent());
        assertEquals(3, mon4.getExponent());
    }

    @Test
    void getCoefficient() {//////////////////DONE
        assertEquals(new RationalScalar(1, 2), mon1.getCoefficient());
        assertEquals(new RationalScalar(3, 4), mon4.getCoefficient());
        assertEquals(new IntegerScalar(1),mon3.getCoefficient());
    }

    @Test
    void addMon() {//////////////////////DONE
        Monomial result = mon1.addMon(mon2);
        assertEquals(new Monomial(2, new RationalScalar(1,1)), result);

        Monomial result2 = mon3.addMon(new Monomial(2, new IntegerScalar(2)));
        assertEquals(new Monomial(2, new IntegerScalar(3)), result2);
        result2 = mon3.addMon(mon4);
        assertEquals(null, result2);
    }

    @Test
    void mulMon() {////////////////////DONE
        Monomial result = mon1.mulMon(mon2);
        assertEquals(new Monomial(4, new RationalScalar(1, 4)), result);

        Monomial result2 = mon3.mulMon(new Monomial(1, new IntegerScalar(2)));
        assertEquals(new Monomial(3, new IntegerScalar(2)), result2);
        result2 = mon3.mulMon(mon4);
        assertEquals(new Monomial(5, new RationalScalar(3,4)), result2);
    }

    @Test
    void neg() {/////////////////////////DONE
        Monomial result = mon1.neg();
        assertEquals(monNeg, result);
    }

    @Test
    void evaluate() {
        assertEquals(new RationalScalar(1, 2), mon1.evaluate(new IntegerScalar(1)));
        assertEquals(new RationalScalar(4, 2), mon1.evaluate(new IntegerScalar(2)));
        assertEquals(new RationalScalar(81, 4), mon4.evaluate(new IntegerScalar(3)));
    }

    @Test
    void derivative() {///////////////DONE
        Monomial result = mon1.derivative();
        assertEquals(new Monomial(1, new RationalScalar(1,1)), result);

        Monomial result2 = mon4.derivative();
        assertEquals(new Monomial(2, new RationalScalar(9, 4)), result2);
    }

    @Test
    void sign() {////////////////DONE
        assertEquals(1, mon1.sign());
        assertEquals(-1, monNeg.sign());
    }

    @Test
    void testEquals() {////////////////////DONE
        assertTrue(mon1.equals(mon2));
        assertFalse(mon1.equals(mon4));
        assertTrue(mon3.equals(new Monomial(2, new IntegerScalar(1))));
    }

    @Test
    void testToString() {///////////////DONE
        assertEquals("1/2x^2", mon1.toString());
        assertEquals("3/4x^3", mon4.toString());
        assertEquals("-1/2x^2", monNeg.toString());
        assertEquals("-1/2", monexp0.toString());
        assertEquals("-1/2x", monexp1.toString());

    }
}