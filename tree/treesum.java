import java.util.*;

public class treesum{
    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
   
    public static int tsum( Node node ){ 
 
      int sum = 0;
      for( int i=0; i<node.children.size(); i++ ){
          Node child = node.children.get( i );
          int childsum = tsum( child );
          sum += childsum; 
      }

      return sum + node.data;

    }

    public static Node construct(int[] arr){
       Stack<Node> st = new Stack<>();
       Node root=null;
       for( int i =0; i<arr.length; i++){
           if( arr[ i ] == -1){
               st.pop();
           }
           else{
               Node t = new Node();
               t.data = arr[ i ];
               if(st.size()>0){
                   st.peek().children.add( t );
               }else{
                   root = t;
               }
               st.push( t );
           }
       }
         return root;

    }

    public static void displaytree(Node node){
        String str = node.data+" -> ";
        for(Node child:node.children){
            str+=child.data+",";
        }
        str+=".";
        System.out.println( str );
         for(Node child:node.children){
             displaytree(child);
         }
    }
    public static void main(String[] args){
      int[] arr = { 10,20,-1,30,40,-1,500,-1,550,-1,-1,100,-1,150,200,-1,140,-1,-1,-1};
        Node root = construct( arr );
        // displaytree(root);
        int ans = tsum( root );
        System.out.println( ans );
    }
}