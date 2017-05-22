/**
 * Created by Kyle on 11/7/2015.
 */
public class FileTreeNode<E> {
    public String name;
    public FileTreeNode<E> leftChild;
    public FileTreeNode<E> rightChild;

    public FileTreeNode (String newItem) {
        name = newItem;
        leftChild = null;
        rightChild = null;
    }//end default constructor

    public FileTreeNode (String newItem,
                         FileTreeNode<E> newLeft, FileTreeNode<E> newRight){
        name = newItem;
        leftChild = newLeft;
        rightChild = newRight;
    }//end constructor
}//end FileTreeNode
