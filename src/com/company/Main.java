package com.company;

public class Main {

    public static void main(String[] args) {

        MyLinkedList list=new MyLinkedList(null);
        list.Traverse(list.getRoot());
	String stringData="Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";
	//using stringData as Aussie cities Udemy Instructor is australian
	String[] data=stringData.split(" ");
	for(String s : data){
	    //creates new item with value set to the string s
        //splits the stringData into separate entries split by a space
        list.addItem(new Node(s));
        System.out.println("/////////");
        list.Traverse(list.getRoot());
    }
	list.Traverse(list.getRoot());
	list.removeItem(new Node("Adelaide"));
	list.Traverse(list.getRoot());

    }
}
