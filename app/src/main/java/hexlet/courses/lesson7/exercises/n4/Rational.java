package hexlet.courses.lesson7.exercises.n4;

public class Rational implements RationalInterface {

    private final int numer;
    private final int denom;

    Rational(int numer, int denom) {
        var gcd = gcd(numer, denom);

        this.numer = numer / gcd;
        this.denom = denom / gcd;
    }

    public static int gcd(int numer, int denom) {
        var i = Math.min(Math.abs(numer), Math.abs(denom));

        while (i >= 0) {
            if (numer % i == 0 && denom % i == 0) {
                break;
            }

            i--;
        }

        return i;
    }

    @Override
    public int getNumer() {
        return numer;
    }

    @Override
    public int getDenom() {
        return denom;
    }

    @Override
    public String toString() {
        return numer + "/" + denom;
    }

    @Override
    public Rational add(Rational rational) {
        return new Rational(
                numer * rational.getDenom() + rational.getNumer() * denom,
                denom * rational.getDenom()
        );
    }

    @Override
    public Rational sub(Rational rational) {
        return new Rational(
                numer * rational.getDenom() - rational.getNumer() * denom,
                denom * rational.getDenom()
        );
    }
}
