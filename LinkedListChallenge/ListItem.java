package com.company;

public abstract class ListItem {
    protected ListItem rightLink=null;
    protected ListItem leftLink=null;
    //you can have variables of the same type you are working in
    //also leftlink is previous rightlink is next
    protected Object value; //keeps data as flexible as possible
    //protected because need to be accessed from concrete subclass

    public ListItem(Object value) {
        this.value = value;
    }

    abstract ListItem next();
    abstract ListItem setNext(ListItem item);
    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem item);
    abstract int compareTo(ListItem item);

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
