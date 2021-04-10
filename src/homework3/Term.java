package homework3;

public class Term implements Comparable {
    private int mCoefficient;
    private int mExponent;

    /**
     * Constructor Function
     * If given no values to initialize coefficient and exponent are set to one
     */
    public Term() {
        mCoefficient = 1;
        mExponent = 1;
    }

    /**
     * Set the coefficent to the given value and default the exponent to zero
     * @param coefficient
     */
    public Term(int coefficient) {
        mCoefficient = coefficient;
        mExponent = 0;
    }

    /**
     * Set the coefficient and exponent to the given values
     * @param number
     * @param exponent
     */
    public Term(int number, int exponent) {
        mCoefficient = number;
        mExponent = exponent;
    }

    /**
     * Parse the given string to get the given coefficient
     * and exponent. A valid string is expected (this is
     * checked in the driver by a RegEx). A valid string
     * looks like "+3x^3" or "-2x^-4" or "4"
     * @param termStr
     */
    public Term(String termStr) {

        // If empty assume coefficient and exponent are zero
        if (termStr.equals("")) {
            mCoefficient = 0;
            mExponent = 0;
            return;
        }

        // If an x exists then there is a coefficient and an exponent
        int xIndex = termStr.indexOf('x');
        String[] termArr = termStr.split("x");

        // Parse the coefficient
        if (termArr[0].equals("+")) {
            mCoefficient = 1;
        } else if (termArr[0].equals("-")) {
            mCoefficient = -1;
        } else {
            mCoefficient = Integer.parseInt(termArr[0]);
        }

        // Parse the Exponent
        if (termArr.length > 1) {
            termArr[1] = termArr[1].replace("^", "");
            mExponent = Integer.parseInt(termArr[1]);
        } else if (xIndex != -1) {
            mExponent = 1;
        } else {
            mExponent = 0;
        }
    }

    /**
     * Copy Constructor
     * @param other - valid term
     */
    public Term(Term other) {
        mCoefficient = other.mCoefficient;
        mExponent = other.mExponent;
    }

    /**
     *
     * @return - the Coefficient
     */
    public int getCoefficient() {
        return mCoefficient;
    }

    /**
     *
     * @return - the Exponent
     */
    public int getExponent() {
        return mExponent;
    }

    /**
     * Set the value of the coefficient
     * @param coefficient - int
     */
    public void setCoefficient(int coefficient) {
        mCoefficient = coefficient;
    }

    /**
     * Set the value of the exponent
     * @param exponent - int
     */
    public void setExponent(int exponent) {
        mExponent = exponent;
    }

    /**
     * Set both the coefficient and exponent
     * @param coefficient - int
     * @param exponent - int
     */
    public void setAll(int coefficient, int exponent) {
        mCoefficient = coefficient;
        mExponent = exponent;
    }

    /**
     * Describes how Terms can be compared to one another.
     * Terms with larger exponents are considered larger than
     * terms with smaller exponents
     * @param o - Object (ideally this object should be a Term)
     * @return - int - the comparison value
     */
    public int compareTo(Object o) {
        if (!(o instanceof Term)) {
            return -1;
        }

        Term other = (Term) o;

        return this.mExponent - other.mExponent;
    }

    /**
     * Clone method
     * @return
     */
    @Override
    public Object clone() {
        return new Term(mCoefficient, mExponent);
    }

    /**
     *
     * @param o - Object (expecting a Term
     * @return - boolean for whether or not the two Objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Term term = (Term) o;
        return mCoefficient == term.mCoefficient &&
                mExponent == term.mExponent;
    }

    /**
     * Format the Term as a string
     * Ex: "3x^2" or "-x" or "4x^-5"
     * @return - String
     */
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

        if (mCoefficient != 1 && mCoefficient != -1 ||
           mCoefficient == 1 && mExponent == 0) {
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
