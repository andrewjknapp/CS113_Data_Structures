package homework3;

import java.util.ArrayList;
import java.util.Collections;

public class Polynomial {
    private ArrayList<Term> mFullPolynomial;

    public Polynomial() {
        mFullPolynomial = new ArrayList<>();
    }

    public Polynomial(Polynomial other) {
        mFullPolynomial.addAll(other.mFullPolynomial);
    }

    public int getNumTerms() {
        return mFullPolynomial.size();
    }

    // If term with exponent exists add to term instead of list
    public void addTerm(Term term) {
        for (Term t : mFullPolynomial) {
            if (term.getExponent() == t.getExponent()) {
                t.setCoefficient(t.getCoefficient() + term.getCoefficient());
                return;
            }
        }
        mFullPolynomial.add(term);
        Collections.sort(mFullPolynomial);
    }

    public Term getTerm(int index) {
        return mFullPolynomial.get(index);
    }

    public void clear() {
        mFullPolynomial.clear();
    }

    public String add(Polynomial other) {
        return "";
    }




}
