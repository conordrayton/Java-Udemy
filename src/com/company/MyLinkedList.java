package com.company;

public class MyLinkedList implements NodeList {
    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            // the list was empty , so this newItem becomes the head of the list
            this.root = newItem;
            return true;
        }
        // start comparing from the head of the list
        ListItem currentItem = this.root;
        while (currentItem != null) { // if you reach a null no more comparisons in the list
            int comparison = currentItem.compareTo(newItem);
            if (comparison < 0) {
                //newItem is greater, move right if possible
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                    //continue processing
                } else {
                    // there is no next, so insert at end of the list
//                  currentItem.setNext(newItem);
//                  newItem.setPrevious(currentItem);
                    currentItem.setNext(newItem).setPrevious(currentItem);
                    // a short cut doing both but in the same line because setNext
                    //also returns the new item which we then setPrevious(currentItem);
                    return true;
                }
            } else if (comparison > 0) {
                //newItem is less, insert before
                if (currentItem.previous() != null) {
//                  currentItem.previous().setNext(newItem);
//                  newItem.setPrevious(currentItem.previous());
                    currentItem.previous().setNext(newItem).setPrevious(currentItem.previous());
                    // again another short cut
//                  newItem.setNext(currentItem);
//                  currentItem.setPrevious(newItem);
                    newItem.setNext(currentItem).setPrevious(newItem);
                    //another shortcut
                    //essentially inserting the new item before the current one
                } else {
                    //the node without a previous is the root new item becomes the new root
//                  newItem.setNext(this.root);
//                  this.root.setPrevious(newItem);
//                  another shortcut
                    newItem.setNext(this.root).setPrevious(newItem);
                    this.root = newItem;
                }
                return true;
                //both cases if or else something was succesfully added.
            } else {
                //equal
                System.out.println(newItem.getValue() + " is already present. not added");
                return false;
            }

        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        //traverse through the list until you find what you want gone
        //then you set the previous link to where the one deleted pointed to
        // and you set that links previous to the one the deleted link was pointing to
        if(item !=null) {
            System.out.println("deleting item " + item.getValue());
        }
            ListItem currentItem = this.root;
            while (currentItem != null) {
                int comparison = currentItem.compareTo(item);
                // trying to find the item
                if (comparison == 0) {
                    //found the item to delete
                    if (currentItem == this.root) {
                        this.root = currentItem.next();
                        //setting the new root to the next item in the list
                        //because all operations begin at the root setting the next node
                        // to the root effectively deletes the current node
                    } else {
                        // effectively changing the current Items pointers
                        currentItem.previous().setNext(currentItem.next());
                        //what is the previous entry and setting it to the current items next
                        // effectively bypassing the current record
                        if (currentItem.next() != null) {
                            currentItem.next().setPrevious(currentItem.previous());
                            // doing the same thing if the current item's next is not null
                            // effectively bypassing the record again
                        }
                    }
                    return true;
                } else if (comparison < 0) {
                    currentItem = currentItem.next();
                    //continue looking
                } else {
                    // comparison > 0
                    // we are at an item greater than the one to be deleted
                    // so the item is not in the list
                    // remember the search starts at root so if it was there we would have passed it
                    return false;
                }
            }
        return false;
            //reached the end of the list without finding anything to delete
    }

    @Override
    public void Traverse(ListItem root) {
        if (root == null) {
            System.out.println("the list is empty");
        } else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
       }
//        if(root!=null){
//            System.out.println(root.getValue());
//            Traverse(root.next());
            // making the Traverse method a recursive call
            // however not a good idea because of the depth of the recursion would cause a crash
            // could have 9,000,000,000,000,000,000 nodes with 63 depth in a binary search tree
        }
    }



