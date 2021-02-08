package homework3;

import java.util.ArrayList;
import java.util.Collections;

public class Polynomial {
    private ArrayList<Term> mFullPolynomial;

    public Polynomial() {
        mFullPolynomial = new ArrayList<>();
    }

    public Polynomial(Polynomial other) {
        mFullPolynomial = new ArrayList<>();
        for (Term t : other.mFullPolynomial) {
            mFullPolynomial.add(new Term(t.getCoefficient(), t.getExponent()));
        }

    }

    public int getNumTerms() {
        return mFullPolynomial.size();
    }

    // If term with exponent exists add to term instead of list
    public void addTerm(Term term) {
        int index = 0;
        for (Term t : mFullPolynomial) {
            if (term.getExponent() == t.getExponent()) {
                if (t.getCoefficient() + term.getCoefficient() == 0) {
                    mFullPolynomial.remove(index);
                    return;
                }
                t.setCoefficient(t.getCoefficient() + term.getCoefficient());
                return;
            }
            index++;
        }
        mFullPolynomial.add(term);
        Collections.sort(mFullPolynomial, Collections.reverseOrder());
    }

    public Term getTerm(int index) {
        return mFullPolynomial.get(index);
    }

    public void clear() {
        mFullPolynomial.clear();
    }

    public void add(Polynomial other) {
        for (Term t : other.mFullPolynomial) {
            this.addTerm(t);
        }

    }

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
