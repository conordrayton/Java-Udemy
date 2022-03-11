package com.company;

public interface NodeList {
    ListItem getRoot();
    //root is the starting node also called the head
    boolean addItem(ListItem item);
    boolean removeItem(ListItem item);
    void Traverse(ListItem root);
}
