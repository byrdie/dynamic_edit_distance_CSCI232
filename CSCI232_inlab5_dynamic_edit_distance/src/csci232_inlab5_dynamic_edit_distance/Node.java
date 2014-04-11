/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package csci232_inlab5_dynamic_edit_distance;

/**
 *
 * @author byrdie
 */
public class Node implements Comparable<Node>{
    public int value;
    public int operation;   //1 for add, 2 for delete, 3 for sub, 0 for none
    
    public Node(int v, int o){
        value = v;
        operation = o;
    }
    
    @Override
    public int compareTo(Node node){
        return Integer.compare(value, node.value);        
    }
}
