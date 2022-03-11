package com.company;

public class Node extends ListItem {

    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return this.rightLink;
    }

    @Override
    ListItem setNext(ListItem item) {
       this.rightLink=item;
       return this.rightLink;
    }
    //^ like a setter but also returns the value as well

    @Override
    ListItem previous() {
        return this.leftLink;
    }

    @Override
    ListItem setPrevious(ListItem item) {
        this.leftLink=item;
        return this.leftLink;
    }

    @Override
    int compareTo(ListItem item) {
        if(item!=null){
            return ((String) super.getValue()).compareTo((String)item.getValue());
            //String in parenthesis is type casting
        } else {
            return -1;
            //if null -1 any value will be greater than null
            //if the parameter should sort before the object
            //return zero if they are equal
            //positive if the paramater should sort after the object
        }
    }
}
