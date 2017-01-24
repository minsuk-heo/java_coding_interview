package Graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 *       A
 *      /\
 *     B  C
 *    /  /\
 *   D  E  F
 *
 *
 * Created by minsukheo on 1/22/17.
 */
public class BreadthFirstSearch {
    public static void main(String[] args) {
        Vertex A = new Vertex();
        A.setVal('A');
        Vertex B = new Vertex();
        B.setVal('B');
        Vertex C = new Vertex();
        C.setVal('C');
        Vertex D = new Vertex();
        D.setVal('D');
        Vertex E = new Vertex();
        E.setVal('E');
        Vertex F = new Vertex();
        F.setVal('F');

        List<Vertex> edges = new ArrayList<Vertex>();
        edges.add(B);
        edges.add(C);
        A.setEdges(edges);


        List<Vertex> B_edges = new ArrayList<Vertex>();
        B_edges.add(A);
        B_edges.add(D);
        B.setEdges(B_edges);


        List<Vertex> C_edges = new ArrayList<Vertex>();
        C_edges.add(A);
        C_edges.add(E);
        C_edges.add(F);
        C.setEdges(C_edges);


        List<Vertex> D_edges = new ArrayList<Vertex>();
        D_edges.add(B);
        D.setEdges(D_edges);


        List<Vertex> E_edges = new ArrayList<Vertex>();
        E_edges.add(C);
        E.setEdges(E_edges);


        List<Vertex> F_edges = new ArrayList<Vertex>();
        F_edges.add(C);
        F.setEdges(F_edges);

        List<Vertex> adjacencyList = new ArrayList<Vertex>();
        adjacencyList.add(A);
        adjacencyList.add(B);
        adjacencyList.add(C);
        adjacencyList.add(D);
        adjacencyList.add(E);
        adjacencyList.add(F);

        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.run(adjacencyList);
    }

    private void run(List<Vertex> adjacencyList) {
        // create visiÎtedNode
        List<Vertex> visitedNode = new ArrayList<Vertex>();
        // create current
        Vertex current;
        // have queue
        List<Vertex> queue = new ArrayList<Vertex>();

        // enqueue first item to queue
        queue.add(adjacencyList.remove(0));
        // while queue is empty
        while(!queue.isEmpty()) {
            // dequeue item from queue and store in current
            current = queue.remove(0);
            // add current vertex's adjacency nodes in queue
            Iterator iter = current.getEdges().iterator();
            while(iter.hasNext()) {
                Vertex v= (Vertex)iter.next();
                if(!visitedNode.contains(v)) {
                    queue.add(v);
                }

            }
            //store current in visited node
            visitedNode.add(current);
        }
        Iterator iter = visitedNode.iterator();
        while(iter.hasNext()) {
            Vertex node = (Vertex)iter.next();
            System.out.println(node.val);
        }

    }

}

class Vertex {
    char val;
    List<Vertex> edges;

    public char getVal() {
        return val;
    }

    public void setVal(char val) {
        this.val = val;
    }

    public List<Vertex> getEdges() {
        return edges;
    }

    public void setEdges(List<Vertex> edges) {
        this.edges = edges;
    }
}