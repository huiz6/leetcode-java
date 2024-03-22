package org.example.no208;

import java.util.Arrays;

public class TireNode {

    private final TireNode[] childNodes;

    private boolean val;

    public TireNode() {
        val = false;
        childNodes = new TireNode[26];
        Arrays.fill(childNodes, null);
    }

    public void setVal(boolean val) {
        this.val = val;
    }

    public boolean isVal() {
        return this.val;
    }

    public TireNode[] getChildNodes() {
        return this.childNodes;
    }

}
