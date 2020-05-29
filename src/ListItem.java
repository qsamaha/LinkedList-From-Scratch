public abstract class ListItem {
    ListItem nextListItem = null;
    ListItem previousListItem = null;
    protected Object object;

    public ListItem(Object object){
        this.object = object;

    }

    abstract ListItem nextListItem();
    abstract ListItem setNextListItem(ListItem nextListItem);
    abstract ListItem previousListItem();
    abstract ListItem setPreviousListItem(ListItem previousListItem);

    abstract int compareTo(ListItem Item);

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
