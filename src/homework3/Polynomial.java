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
            Term newTerm = new Term();
            newTerm.setCoefficient(t.getCoefficient());
            newTerm.setExponent(t.getExponent());
            mFullPolynomial.add(newTerm);
        }

    }

    public int getNumTerms() {
        return mFullPolynomial.size();
    }

    // If term with exponent exists add to term instead of list
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
