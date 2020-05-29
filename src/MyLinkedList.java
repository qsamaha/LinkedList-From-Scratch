public class MyLinkedList implements NodeList {
    private int nodeCounter = 0;
    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean add(ListItem newItem) {

        if(this.root == null) {
            // The list was empty, so this item becomes the head of the list
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;
        while(currentItem != null) {
            int comparison = (currentItem.compareTo(newItem));
            if(comparison <0) {
                // newItem is greater, move right if possible
                if(currentItem.nextListItem() != null) {
                    currentItem = currentItem.nextListItem();
                } else {
                    // there is no next, so insert at end of list
                    currentItem.setNextListItem(newItem).setPreviousListItem(currentItem);
                    return true;
                }
            } else if(comparison >0) {
                // newItem is less, insert before
                if(currentItem.previousListItem() != null) {
                    currentItem.previousListItem().setNextListItem(newItem).setPreviousListItem(currentItem.previousListItem());
                    newItem.setNextListItem(currentItem).setPreviousListItem(newItem);
                } else {
                    // the node with a previous is the root
                    newItem.setNextListItem(this.root).setPreviousListItem(newItem);
                    this.root = newItem;
                }
                return true;
            } else {
                // equal
                System.out.println(newItem.getObject() + " is already present, not added.");
                return false;
            }
        }

        return false;
    }



    @Override
    public boolean delete(ListItem item) {
        if(item != null) {
            System.out.println("Deleting item " + item.getObject());
        }

        ListItem currentItem = this.root;
        while(currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if(comparison == 0) {
                // found the item to delete
                if(currentItem == this.root) {
                    this.root = currentItem.nextListItem();
                } else {
                    currentItem.previousListItem().setNextListItem(currentItem.nextListItem());
                    if(currentItem.nextListItem() != null) {
                        currentItem.nextListItem().setPreviousListItem(currentItem.previousListItem());
                    }
                }
                return true;
            } else if(comparison <0) {
                currentItem = currentItem.nextListItem();
            } else { // comparison > 0
                // We are at an item greater than the one to be deleted
                // so the item is not in the list
                return false;
            }
        }

        // We have reached the end of the list
        // Without finding the item to delete
        return false;
    }

    @Override
    public int size() {
        return nodeCounter;
    }

    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty");
        } else {
            while (root != null) {
                System.out.println(root.getObject());
                root = root.nextListItem;
            }
        }
    }
}

