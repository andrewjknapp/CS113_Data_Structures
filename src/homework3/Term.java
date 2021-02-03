package homework3;

import java.util.Objects;

public class Term implements Comparable {
    private int mCoefficient;
    private int mExponent;

    public Term() {
        mCoefficient = 1;
        mExponent = 1;
    }

    public Term(int coefficient) {
        mCoefficient = coefficient;
        mExponent = 0;
    }

    public Term(String termStr) {
        if (termStr.equals("")) {
            mCoefficient = 0;
            mExponent = 0;
            return;
        }
        int xIndex = termStr.indexOf('x');
        String[] termArr = termStr.split("x");

        if (termArr[0].equals("+")) {
            mCoefficient = 1;
        } else if (termArr[0].equals("-")) {
            mCoefficient = -1;
        } else {
            mCoefficient = Integer.parseInt(termArr[0]);
        }

        if (termArr.length > 1) {
            termArr[1] = termArr[1].replace("^", "");
            mExponent = Integer.parseInt(termArr[1]);
        } else if (xIndex != -1) {
            mExponent = 1;
        } else {
            mExponent = 0;
        }
    }

    public Term(Term other) {
        mCoefficient = other.mCoefficient;
        mExponent = other.mExponent;
    }

    public Term(int number, int exponent) {
        mCoefficient = number;
        mExponent = exponent;
    }

    public int getCoefficient() {
        return mCoefficient;
    }

    public int getExponent() {
        return mExponent;
    }

    public void setCoefficient(int coefficient) {
        mCoefficient = coefficient;
    }

    public void setExponent(int exponent) {
        mExponent = exponent;
    }

    public void setAll(int coefficient, int exponent) {
        mCoefficient = coefficient;
        mExponent = exponent;
    }


    public int compareTo(Object o) {
        if (!(o instanceof Term)) {
            return -1;
        }

        Term other = (Term) o;

        return this.mExponent - other.mExponent;
    }

    @Override
    public Object clone() {
        return new Term(mCoefficient, mExponent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Term term = (Term) o;
        return mCoefficient == term.mCoefficient &&
                mExponent == term.mExponent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mCoefficient, mExponent);
    }

    @Override
    public String toString() {
        String output = "";

        if (mCoefficient == 0) {
            return "";
        }

        if (mCoefficient > 0) {
            output += "+";
        } else if (mCoefficient == -1) {
            output += "-";
        }

        if (mCoefficient != 1 && mCoefficient != -1) {
            output += Integer.toString(mCoefficient);
        }

        if (mExponent != 0) {
            output+= "x";

            if (mExponent != 1) {
                output += "^";
                output += Integer.toString(mExponent);
            }
        }

        return output;
    }
}
