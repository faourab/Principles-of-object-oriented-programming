import Calculator.Scalars.*;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {
    @Test
    void testBuild() {/////////////////////DONE
        Polynomial poly = Polynomial.build("3 4/2 -2");
        HashMap<Integer, Monomial> expectedMonomials = new HashMap<>();
        expectedMonomials.put(0, new Monomial(0, new IntegerScalar(3)));
        expectedMonomials.put(1, new Monomial(1, new RationalScalar(4, 2)));
        expectedMonomials.put(2, new Monomial(2, new IntegerScalar(-2)));
        Polynomial expected = new Polynomial(expectedMonomials);
        assertEquals(expected, poly);
        Polynomial poly1 = Polynomial.build("0 0 0");
        HashMap<Integer, Monomial> expectedMonomials1 = new HashMap<>();
        expectedMonomials.put(0, new Monomial(0, new IntegerScalar(0)));
        expectedMonomials.put(1, new Monomial(1, new IntegerScalar(0)));
        expectedMonomials.put(2, new Monomial(2, new IntegerScalar(0)));
        Polynomial expected1 = new Polynomial(expectedMonomials1);
        assertEquals("0", poly1.toString());
    }

    @Test
    void testAdd() {/////////////////////DONE
        Polynomial p1 = Polynomial.build("3 2 1");
        Polynomial p2 = Polynomial.build("1 1 1");
        Polynomial result = p1.add(p2);
        HashMap<Integer, Monomial> expectedMonomials = new HashMap<>();
        expectedMonomials.put(0, new Monomial(0, new IntegerScalar(4)));
        expectedMonomials.put(1, new Monomial(1, new IntegerScalar(3)));
        expectedMonomials.put(2, new Monomial(2, new IntegerScalar(2)));
        Polynomial expected = new Polynomial(expectedMonomials);
        assertEquals(expected.toString(), result.toString());
    }

    @Test
    void testMul() {/////////////////////DONE
        Polynomial p1 = Polynomial.build("1 1");
        Polynomial p2 = Polynomial.build("1 1");
        Polynomial result = p1.mul(p2);
        HashMap<Integer, Monomial> expectedMonomials = new HashMap<>();
        expectedMonomials.put(0, new Monomial(0, new IntegerScalar(1)));
        expectedMonomials.put(1, new Monomial(1, new IntegerScalar(2)));
        expectedMonomials.put(2, new Monomial(2, new IntegerScalar(1)));
        Polynomial expected = new Polynomial(expectedMonomials);
        assertEquals(expected, result);
    }

    @Test
    void testEvaluate() {/////////////////////DONE
        Polynomial p = Polynomial.build("3 4 2");
        Scalar result = p.evaluate(new IntegerScalar(2));
        Scalar expected = new IntegerScalar(19); // 3 + 4*2 + 2*2^2 = 3 + 8 + 8 = 19
        assertEquals(expected, result);
    }

    @Test
    void testDerivative() {/////////////////////DONE
        Polynomial p = Polynomial.build("3 2 1");
        Polynomial result = p.derivative();
        HashMap<Integer, Monomial> expectedMonomials = new HashMap<>();
        expectedMonomials.put(0, new Monomial(0, new IntegerScalar(2)));
        expectedMonomials.put(1, new Monomial(1, new IntegerScalar(2)));
        Polynomial expected = new Polynomial(expectedMonomials);
        assertEquals(expected, result);
    }

    @Test
    void testToString() {/////////////////////DONE
        Polynomial p = Polynomial.build("3 -2 1");
        assertEquals("3 - 2x + x^2", p.toString());
    }

    @Test
    void testEquals() {
        Polynomial p1 = Polynomial.build("3 2 1");
        Polynomial p2 = Polynomial.build("3 2 1");
        assertEquals(p1, p2);
    }
}
