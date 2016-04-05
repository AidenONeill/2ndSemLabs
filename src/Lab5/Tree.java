package Lab5;


public class Tree implements Comparable<Tree>
{
	public Node root;// first node of tree
	public int frequency=0;


	public Tree()                  
	{  
		root  =  new Node(); //create a new empty node anything a new tree is created
	}            

	public Tree(Tree t1, Tree t2)//method to take in two tress
	{
		root = new Node();								//set a new default node
		root.leftChild = t1.root;						//set t1 to left child of new root
		root.rightChild = t2.root;						//set t2 to right child of new root
		this.frequency = t1.frequency+t2.frequency; 	//Update frequency to t1+t2
	}


	public int compareTo(Tree object)
	{ 
		if(frequency-object.frequency>0)//compare the cumulative frequencies of the tree
		{ 
			return 1;
		}
		else if(frequency-object.frequency<0)
		{
			return -1;   //return 1 or -1 depending on whether these frequencies are bigger or smaller
		}else
		{
			return 0;   //return 0 if they're the same
		}
	}


	String path= ""; //tracks the path to the letter we want
	public String getCode(char letter)//we want the code for this letter
	{

		inOrder(root,letter,"");///calls inorder method to traverse the tree
		return path;

	}
	public void inOrder(Node root, char letter, String path)//recursive method for inOrder traversal of a tree
	{
		if (root != null)
		{
			if (root.letter == letter)//Check to see if the letter stored in the node is the letter wanted  //base case
			{
				this.path = path;//if so set the path to current letter
			}
			else
			{
				inOrder(root.leftChild, letter, path + "0");//check left child, add 0 to current path
				inOrder(root.rightChild, letter, path + "1");//check right child, add 1 to current path
			}
		}
	}
}



