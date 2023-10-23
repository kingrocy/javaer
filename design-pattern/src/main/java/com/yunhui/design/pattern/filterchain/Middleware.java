package com.yunhui.design.pattern.filterchain;

/**
 *
 * Created on 2022-06-24
 */
public abstract class Middleware {
    private Middleware next;

    /**
     * Builds chains of middleware objects.
     */
    public Middleware linkWith(Middleware next) {
        this.next = next;
        return next;
    }

    /**
     * Subclasses will implement this method with concrete checks.
     */
    public boolean check(String email, String password) {
        boolean b = doCheck(email, password);
        if (needNext()) {
            return checkNext(email, password);
        }
        return b;
    }


    public boolean needNext() {
        return true;
    }

    public abstract boolean doCheck(String email, String password);


    /**
     * Runs check on the next object in chain or ends traversing if we're in
     * last object in chain.
     */
    protected boolean checkNext(String email, String password) {
        if (next == null) {
            return true;
        }
        return next.check(email, password);
    }
}
