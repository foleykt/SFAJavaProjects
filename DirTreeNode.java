/**
 * Created by Kyle on 11/7/2015.
 */
public class DirTreeNode<E> {
    public String name;
    public FileTreeNode<E> file;
    public DirTreeNode<E> leftChild;
    public DirTreeNode<E> rightChild;

    public DirTreeNode (String newItem) {
        name = newItem;
        file = null;
        leftChild = null;
        rightChild = null;
    }//end default constructor

    public DirTreeNode (String newItem, FileTreeNode<E> newFile,
                         DirTreeNode<E> newLeft, DirTreeNode<E> newRight){
        name = newItem;
        file = newFile;
        leftChild = newLeft;
        rightChild = newRight;
    }//end constructor
}//end DirTreeNode
