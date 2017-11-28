package de.doubleslash.dojo.bowlinggame;

class RollCounter {

    private int next = 1;

    int getNext() {
        return next++;
    }

}
