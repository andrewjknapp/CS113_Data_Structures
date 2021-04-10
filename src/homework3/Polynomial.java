package homework3;

import java.util.ArrayList;
import java.util.Collections;

public class Polynomial {
    private ArrayList<Term> mFullPolynomial;

    /**
     * Initializes a new ArrayList to store terms for Polynomial
     */
    public Polynomial() {
        mFullPolynomial = new ArrayList<>();
    }

    /**
     * Copy Constructor
     *
     * @param other - Polynomial
     */
    public Polynomial(Polynomial other) {
        mFullPolynomial = new ArrayList<>();
        for (Term t : other.mFullPolynomial) {
            Term newTerm = new Term();
            newTerm.setCoefficient(t.getCoefficient());
            newTerm.setExponent(t.getExponent());
            mFullPolynomial.add(newTerm);
        }

    }

    /**
     * Getter for size of Polynomial list
     * @return
     */
    public int getNumTerms() {
        return mFullPolynomial.size();
    }

    // If term with exponent exists add to term instead of list

    /**
     * addTerm adds the given term to the current polynomial. The polynomial
     * is traversed to see if there is already a term with the exponent of the
     * new term. If that is found then the coefficient of the existing and new
     * term are added and that is saved. If that exponent is not found then the
     * term is added to the polynomial.
     * The polynomial is then sorted
     * @param term - Term: a valid term has an mExponent and mCoefficient.
     *
     */
    public void addTerm(Term term) {
        int index = 0;
        for (Term t : this.mFullPolynomial) {
            if (term.getExponent() == t.getExponent()) {
                if (t.getCoefficient() + term.getCoefficient() == 0) {
                    this.mFullPolynomial.remove(index);
                    return;
                }
                t.setCoefficient(t.getCoefficient() + term.getCoefficient());
                return;
            }
            index++;
        }
        this.mFullPolynomial.add(new Term(term.getCoefficient(), term.getExponent()));
        Collections.sort(this.mFullPolynomial, Collections.reverseOrder());
    }

    /**
     *
     * @param index - int the index of the polynomial to get
     * @return - the requested term based on the index
     */
    public Term getTerm(int index) {
        return mFullPolynomial.get(index);
    }

    /**
     * Empty the existing polynomial
     */
    public void clear() {
        mFullPolynomial.clear();
    }

    /**
     * Add every term from the other polynomial to
     * the current polynomial
     * @param other - a valid polynomial
     */
    public void add(Polynomial other) {
        for (Term t : other.mFullPolynomial) {
            this.addTerm(t);
        }

    }

    /**
     *
     * @return - The formatted polynomial in the format 4x^2-3x^2+2
     */
    @Override
    public String toString() {
        if (mFullPolynomial.size() == 0) {
            return "0";
        }
        String output = "";
        for (Term t : mFullPolynomial) {
            output += t.toString();
        }

        if (output.charAt(0) == '+') {
            output = output.substring(1);
        }
        return output;
    }
}
