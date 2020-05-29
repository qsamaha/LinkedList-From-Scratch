public class Node extends ListItem {
    public Node(Object object) {
        super(object);
    }

    public Node createNode(Object object) {
        return new Node(object);
    }

    @Override
    ListItem nextListItem() {
        return this.nextListItem;
    }

    @Override
    ListItem setNextListItem(ListItem nextListItem) {
        this.nextListItem = nextListItem;
        return this.nextListItem;
    }

    @Override
    ListItem previousListItem() {
        return this.previousListItem;
    }

    @Override
    ListItem setPreviousListItem(ListItem previousListItem) {
        this.previousListItem = previousListItem;
        return this.previousListItem;
    }

    @Override
    int compareTo(ListItem item) {
        if (item != null) {
            return ((String) super.getObject()).compareTo((String) item.getObject());
        } else {
            return -1;
        }
    }

}
