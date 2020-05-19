/**
* Project #2: Binary Search Tree Experiment
* File: BinaryTree.java
* Programmers: David Kopp
* Date: 11/1/13
* Description: This program reads a text file and creates a collection(array data-structure) of unknown type by using the new command, while also calling the 
*					a shape or text object's constructors. Then after the objects are created and placed into the array an iterator is used to traverse 
*					the array and to call the objects draw methods associated with each object's class.
**/

public class BSTElement implements Comparable<BSTElement> {

private Integer key;

public BSTElement(int aKey) {
key = new Integer(aKey); 
}

public Integer getKey() {
return key;
}

// Override for compareTo
public int compareTo(BSTElement other) {
int result = key.compareTo(other.key);

if (result < 0) {
return -1;
}

else if (result == 0) {
return 0;
}

else {
return 1;
}
}

// public String toString() {
// return Integer.toString(key);
// }
}