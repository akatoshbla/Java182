/**
* Project #2: Binary Search Tree Experiment
* File: BinaryTree.java
* Programmers: David Kopp
* Date: 11/1/13
* Description: This program reads a text file and creates a collection(array data-structure) of unknown type by using the new command, while also calling the 
*					a shape or text object's constructors. Then after the objects are created and placed into the array an iterator is used to traverse 
*					the array and to call the objects draw methods associated with each object's class.
*/

public class BSTree<E> {

protected BSTNode<E> root;

public BSTree() {

}

public BSTree(E rootItem) {
root = null;

}

public BSTree(E rootItem, BSTree<E> leftTree, BSTree<E> rightTree) {
root = new BSTNode<E>(rootItem, null, null);
attachLeftSubtree(leftTree);
attachRightSubtree(rightTree);

}

public boolean isEmpty() {
return root == null;

}

public void makeEmpty() {
root = null;

}

public void setRootItem(E newItem) {
if (root != null) {
root.item = newItem;

}

else {
root = new BSTNode<E>(newItem, null, null);

}
}

public void attachLeft(E newItem) {
if (!isEmpty() && root.leftChild == null) {
root.leftChild = new BSTNode<E>(newItem, null, null);

}
}

public void attachRight(E newItem) {
if (!isEmpty() && root.rightChild == null) {
root.rightChild = new BSTNode<E>(newItem, null, null);

}
}

public void attachLeftSubtree(BSTree<E> leftTree) {
root.leftChild = leftTree.root;
leftTree.makeEmpty();

}

public void attachRightSubtree(BSTree<E> rightTree) {
root.rightChild = rightTree.root;
rightTree.makeEmpty();

}

protected BSTree(BSTNode<E> rootNode) {
root = rootNode;

}

public BSTree<E> detachLeftSubtree() {
BSTree<E> leftTree;
leftTree = new BSTree<E>(root.leftChild);
root.leftChild = null;
return leftTree;

}

public BSTree<E> detachRightSubtree() {
BSTree<E> rightTree;
rightTree = new BSTree<E>(root.rightChild);
root.rightChild = null;
return rightTree;

}


}