package Calculator.Scalars;

public interface Scalar {
    Scalar add(Scalar s);

    Scalar addInt(IntegerScalar s);

    Scalar addRat(RationalScalar s);

    Scalar mul(Scalar s);

    Scalar mulInt(IntegerScalar s);

    Scalar mulRat(RationalScalar s);

    Scalar neg();

    Scalar power(int exponent);

    int sign();

    boolean equals(Object other);




}
