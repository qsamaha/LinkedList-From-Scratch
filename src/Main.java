public class Main {


    public static void main(String[] args) {
        String y = "yo";
        MyLinkedList linkedList = new MyLinkedList(null);
        linkedList.add(new Node("Yessir"));
        linkedList.add(new Node("200"));
        linkedList.add(new Node(y));



        linkedList.traverse(linkedList.getRoot());

        System.out.println("========================================");

        linkedList.delete(new Node("200"));

        System.out.println("========================================");

        linkedList.traverse(linkedList.getRoot());



    }
}
