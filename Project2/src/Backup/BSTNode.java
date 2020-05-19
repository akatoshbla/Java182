class BSTNode<E> {

protected E item;
protected BSTNode<E> leftChild;
protected BSTNode<E> rightChild;

public BSTNode(E newItem) {
item = newItem;
leftChild = null;
rightChild = null;

}

public BSTNode(E newItem, BSTNode<E> left, BSTNode<E> right) {
item = newItem;
leftChild = left;
rightChild = right;

}

}


