package io.felipeandrade.gsw2.common;

public class Range<T extends Comparable<T>> {

    private T lowerLimit;
    private T higherLimit;
    private boolean includeLowerLimit;
    private boolean includeHigherLimit;

    public Range(T lowerLimit, T higherLimit) {
        this(lowerLimit, true, higherLimit, true);
    }

    public Range(T limitA, boolean includeLimitA, T limitB, boolean includeLimitB) {
        if (limitA.compareTo(limitB) == 0) {
            if (!includeLimitA) {
                assignBLower(limitA, includeLimitA, limitB, includeLimitB);
            } else {
                assigALower(limitA, includeLimitA, limitB, includeLimitB);
            }
        } else if (limitA.compareTo(limitB) < 0) {
            assigALower(limitA, includeLimitA, limitB, includeLimitB);
        } else {
            assignBLower(limitA, includeLimitA, limitB, includeLimitB);
        }
    }

    private void assigALower(T limitA, boolean includeLimitA, T limitB, boolean includeLimitB) {
        this.lowerLimit = limitA;
        this.includeLowerLimit = includeLimitA;
        this.higherLimit = limitB;
        this.includeHigherLimit = includeLimitB;
    }

    private void assignBLower(T limitA, boolean includeLimitA, T limitB, boolean includeLimitB) {
        this.lowerLimit = limitB;
        this.includeLowerLimit = includeLimitB;
        this.higherLimit = limitA;
        this.includeHigherLimit = includeLimitA;
    }

    public boolean isInRange(T otherValue) {
        int lowerComp = lowerLimit.compareTo(otherValue);
        int higherComp = higherLimit.compareTo(otherValue);

        if (lowerComp < 0) return false;
        if (higherComp > 0) return false;

        if (lowerComp > 0 && higherComp < 0) {
            return true;
        }

        if (lowerComp == 0) {
            if (includeLowerLimit) return true;
            else {
                return higherComp < 0;
            }
        }

        return includeHigherLimit;
    }


    public T getUp() {
        return this.higherLimit;
    }

    public T getDown() {
        return this.lowerLimit;
    }
}
