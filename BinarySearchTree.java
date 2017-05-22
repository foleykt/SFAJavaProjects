/**
 * Created by Kyle on 11/7/2015.
 */
public class BinarySearchTree<E> {
    private DirTreeNode<E> root;

    public BinarySearchTree(){
        root = null;
    }//end default constructor

    public boolean isEmpty(){
        return root == null;
    }//end isEmpty

    public void clearTree(){
        root = null;
    }//end clearTree

    public void traversePrint(){
        //call traverse method since main will not be able to access root
        //traverse will print the entire tree starting at root
        traverse(root);
    }//end traversePrint

    protected void traverse (DirTreeNode<E> startNode){
        if (startNode != null) {
            traverse(startNode.leftChild);
            System.out.print("Directory " + startNode.name + "\nFiles: ");
            if (startNode.file == null){
                System.out.print("none");
            }
            else{
                showFiles(startNode.file);
            }//end if
            traverse(startNode.rightChild);
        }
        else{
            System.out.println();
            System.out.println();
        }//end if
    }//end traverse

    public void insertDir (String newItem){
        root = insert(root, newItem);
    }//end insertDir

    protected DirTreeNode<E> insert (DirTreeNode<E> newNode, String newItem){
        DirTreeNode<E> newRoot;
        if (newNode == null){
            newNode = new DirTreeNode<E>(newItem);
            return newNode;
        }//end if

        String key = newNode.name;

        if (newItem.compareTo(key) < 0){
            newRoot = insert(newNode.leftChild, newItem);
            newNode.leftChild = newRoot;
            return newNode;
        }
        else {
            newRoot = insert(newNode.rightChild, newItem);
            newNode.rightChild = newRoot;
            return newNode;
        }//end if
    }//end insert

    protected FileTreeNode<E> insertFile(FileTreeNode<E> newNode, String newFile){
        FileTreeNode<E> newRoot;

        if (newNode == null){
            newNode = new FileTreeNode<E>(newFile);
            return newNode;
        }//end if

        String key = newNode.name;
        if (newFile.compareTo(key) < 0){
            newRoot = insertFile(newNode.leftChild, newFile);
            newNode.leftChild = newRoot;
            return newNode;
        }
        else{
            newRoot = insertFile(newNode.rightChild, newFile);
            newNode.rightChild = newRoot;
            return newNode;
        }//end if
    }//end insertFile

    public void insertFile (String dir, String file){
        //System.out.println("Root is: " + root.name + " in insertFile");
        //System.out.println("Root's left is: " + root.leftChild);
        //System.out.println("Root's right is: " + root.rightChild);
        //System.out.println("Root's file is: " + root.file.name);
        root = findDir(root, dir, file);
    }//end insertFile

    protected DirTreeNode<E> findDir(DirTreeNode<E> newNode, String dir, String file){

        if (newNode == null){
            System.out.println("Directory " + dir + " does not exist. File " + file + " will not be created.");
            return newNode;
        }
        else if(newNode.name.equals(dir)){
            newNode.file = insertFile(newNode.file, file);
            return newNode;
        }//end if

        String key = newNode.name;
        if (dir.compareTo(key) < 0){
            findDir(newNode.leftChild, dir, file);
            return newNode;
        }
        else{
            findDir(newNode.rightChild, dir, file);
            return newNode;
        }//end if
    }//end findDir

    public void getFiles (String dir){
        DirTreeNode<E> location = findDir(root, dir);
        if (location != null){
            showDir(location, dir);
        }//end if
    }//end getFiles

    protected DirTreeNode<E> findDir(DirTreeNode<E> newNode, String dir){

        if (newNode == null){
            System.out.println("Directory " + dir + ", does not exist.");
            return newNode;
        }
        else if (newNode.name.equals(dir)){
            return newNode;
        }//end if

        String key = newNode.name;
        if (dir.compareTo(key) < 0) {
            findDir(newNode.leftChild, dir);
            return newNode;
        }
        else{
            findDir(newNode.rightChild, dir);
            return newNode;
        }//end if
    }//end findDir

    protected void showDir(DirTreeNode<E> startNode, String dir){
        if (startNode != null) {
            showDir(startNode.leftChild, dir);
            if (startNode.name.equals(dir)){
                System.out.print("Directory: " + startNode.name + ":\nFiles: ");
                if (startNode.file == null){
                    System.out.print("none");
                }
                else{
                    showFiles(startNode.file);
                }//end if
            }//end if
            showDir(startNode.rightChild, dir);
        }//end if
    }//end showDir

    protected void showFiles(FileTreeNode<E> startNode){
        if (startNode != null){
            showFiles(startNode.leftChild);
            System.out.print(startNode.name + ", ");
            showFiles(startNode.rightChild);
        }
       /* else{
            System.out.println("Something went wrong. Oops!");
        }//end if
        */
    }//end showFiles
}//end BinarySearchTree
