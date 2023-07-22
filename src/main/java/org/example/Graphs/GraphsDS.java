package org.example.Graphs;

import java.util.ArrayList;

public class GraphsDS {


    public static ArrayList<Edge>[]  createGraph(){
        int vertexCount = 4;
        ArrayList<Edge> graph[] = new ArrayList[vertexCount];

        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,2));
        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,3));
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));
        graph[2].add(new Edge(2,0));
        graph[3].add(new Edge(3,2));
        graph[3].add(new Edge(3,1));

        return graph;
    }

    public static void printTheNeighbour(ArrayList<Edge>[] graph){
       graph[2].forEach(edge -> System.out.println("I am vertext 2's neighbour:"+edge.getDestination()));
    }
    public static void main(String[] args){

        ArrayList<Edge>[] graphDs = createGraph();
        printTheNeighbour(graphDs);


    }

}
