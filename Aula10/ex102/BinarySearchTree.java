

import java.util.ArrayList;
import java.util.Iterator;


public class BinarySearchTree<T extends Comparable<? super T>> implements Iterable<T> {
// o elemento do tipo T deve ser comparável para efectuar pesquisas
// mas como pode herdar a implementação de compareTo() é mais correcto
// usar <? super T>

    public static void main(String[] args) {
        BinarySearchTree<String> teste= new BinarySearchTree<>();
        System.out.println("inserir I: "+teste.insert("I"));
        System.out.println("inserir s: "+teste.insert("s"));
        System.out.println("inserir t: "+teste.insert("t"));
        System.out.println("inserir o: "+teste.insert("o"));
        System.out.println("inserir e: "+teste.insert("e"));
        System.out.println("inserir u: "+teste.insert("u"));
        System.out.println("inserir m: "+teste.insert("m"));
        System.out.println("inserir t: "+teste.insert("t"));
        System.out.println("inserir e: "+teste.insert("e"));
        System.out.println("inserir s: "+teste.insert("s"));
        System.out.println("inserir t: "+teste.insert("t"));
        System.out.println("inserir e: "+teste.insert("e"));
        System.out.println();
        
        System.out.println("contem I: "+teste.contains("I"));
        
        System.out.println("contem v: "+teste.contains("v"));
        
        System.out.println("numNodes: "+teste.numNodes);
        
        System.out.println("remover I: "+teste.remove("I"));
        
        System.out.println("numNodes: "+teste.numNodes);
        
        System.out.println("remover e: "+teste.remove("e"));
        
        System.out.println("numNodes: "+teste.numNodes);
        
        System.out.println("remover v: "+teste.remove("v"));

        System.out.println("numNodes: "+teste.numNodes);
        
        System.out.println("elementos: ");
        
        for(String t:teste){
            System.out.println(t);
        }
        
        
                
    }
    
    public int size(){
        return numNodes;
    }
    
    private static class BSTNode<T> {

        T element;
        BSTNode<T> left;
        BSTNode<T> right;

        BSTNode(T theElement) {
            element = theElement;
            left = right = null;
        }
    }
    private BSTNode<T> root;
    private int numNodes;

    public BinarySearchTree() {
        root = null;
        numNodes = 0;
    }

    public boolean insert(T value) {
        int prevNumNodes=numNodes;
        root = insert(value, root);
        return prevNumNodes!=numNodes;
    }
    
    private BSTNode<T> insert(T value,BSTNode<T> node){
        if(node==null){
            numNodes++;
            return new BSTNode<T>(value);
            
        }
        if(node.element.compareTo(value)>0){
            node.left=insert(value,node.left);
        }else if(node.element.compareTo(value)<0){
            node.right=insert(value,node.right);
        }
        return node;
            
    }

    private BSTNode<T> insertNode(BSTNode<T> target,BSTNode<T> node){
        if(node==null){
            return target; 
        }
        if(node.element.compareTo(target.element)>0){
            node.left=insertNode(target,node.left);
        }else{
            node.right=insertNode(target,node.right);
        }
        return node;
            
    }
    
    public boolean remove(T value) {
        if(numNodes==0)
            return false;
        
        if(root.element.compareTo(value)==0){
            ArrayList<T> arr=new ArrayList<>();
            fillArray(root.left,arr );
            root=root.right;
            for(int i=1;i<arr.size();i++){
                insert(arr.get(i));
                numNodes--;
            }
            numNodes--;
            return true;
        }
        
        BSTNode<T> tmp=findParent(value,root);
        if(tmp==null)
            return false;
        ArrayList<T> arr=new ArrayList<>();
        if(tmp.left!=null && tmp.left.element.compareTo(value)==0){
            fillArray(tmp.left,arr);
            tmp.left=null;
        }else{
            fillArray(tmp.right,arr);
            tmp.right=null;
        }
        
        for(int i=1; i<arr.size() ;i++){
            insert(arr.get(i));
            numNodes--;
        }
        
        numNodes--;
        
        return true;
    }
    
    public boolean contains(T value) {
        return valueOf(find(value, root)) != null;
    }
    
    private T valueOf(BSTNode<T> n){
        if(n!=null)
            return n.element;
        return null;
    }
    
    private BSTNode<T> find(T value, BSTNode<T> n){
        if(n==null)
            return null;
        if(n.element.compareTo(value)==0)
            return n;
        if(n.element.compareTo(value)>0)
            return find(value,n.left);
        return find(value,n.right);
        
    }
    
    private BSTNode<T> findParent(T value, BSTNode<T> n){
        if(n.left==null && n.right==null)
            return null;
       if(n.left!=null) 
            if(n.left.element.compareTo(value)==0)
                return n;
        if(n.right!=null)
            if( n.right.element.compareTo(value)==0)
                return n;
        if(n.element.compareTo(value)>0)
            return findParent(value,n.left);
        return findParent(value,n.right);
        
    }
    
    
    private Object[] toArray(){
        
        ArrayList<T> tmp = new ArrayList<>();
        fillArray(root,tmp);
        
        return tmp.toArray();
    }
    
    private void fillArray(BSTNode<T> n,ArrayList<T> arr){
        
        if(n==null)
            return;
        arr.add(n.element);
        fillArray(n.left, arr);
        fillArray(n.right, arr);
    }
    
    public Iterator<T> iterator() {
        return new Iterator<T> (){
            private int i=0;
            private Object[] arr=toArray();
            public boolean hasNext(){
                return i<arr.length;
            }
            public T next(){
                return (T)arr[i++];
            }
            public boolean remove(T v){
                return BinarySearchTree.this.remove(v);
            }
            
        };
    }
}