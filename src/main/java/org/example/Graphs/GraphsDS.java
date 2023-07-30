package org.example.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphsDS {


    public static List<ArrayList<Edge>> createGraph() {
        int vertexCount = 6;
        List<ArrayList<Edge>> graph = new ArrayList<>();

        for (int i = 0; i <= vertexCount; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new Edge(0, 1));
        graph.get(0).add(new Edge(0, 2));

        graph.get(1).add(new Edge(1, 0));
        graph.get(1).add(new Edge(1, 3));

        graph.get(2).add(new Edge(2, 0));
        graph.get(2).add(new Edge(2, 4));

        graph.get(3).add(new Edge(3, 1));
        graph.get(3).add(new Edge(3, 4));
        graph.get(3).add(new Edge(3, 5));

        graph.get(4).add(new Edge(4, 2));
        graph.get(4).add(new Edge(4, 3));
        graph.get(4).add(new Edge(4, 5));

        graph.get(5).add(new Edge(5, 3));
        graph.get(5).add(new Edge(5, 4));
        graph.get(5).add(new Edge(5, 6));

        graph.get(6).add(new Edge(6, 5));

        return graph;
    }


    public List<ArrayList<Edge>>
    getSmallGraph(int vertexCount){
        List<ArrayList<Edge>> graph = new ArrayList<>();

        for (int i = 0; i <= vertexCount; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new Edge(0, 1));

        graph.get(1).add(new Edge(1, 0));
        graph.get(1).add(new Edge(1, 2));

        graph.get(2).add(new Edge(2, 1));


        return graph;
    }
    public static void printTheNeighbour(List<ArrayList<Edge>> graph) {
        int vertexCount = 3;
        int i = 0;
        while (i < vertexCount) {
            int finalI = i;
            graph.get(i).forEach(edge -> System.out.println("I am vertext" + finalI + "'s neighbour:" + edge.getDestination()));
            i++;
        }
    }

    public static void main(String[] args) {
        GraphsDS gpDs = new GraphsDS();
        List<ArrayList<Edge>> graphDs = createGraph();
      //  printTheNeighbour(graphDs);
        boolean visitedList[] = new boolean[graphDs.size()];
        for (int i = 0; i < visitedList.length; i++) {
            if (visitedList[i] == false) {
                breadthFirstSearchAlgorithm(graphDs, visitedList, i);
            }
        }
        boolean vis[] = new boolean[graphDs.size()];
        System.out.println("Depth First Search Algorithm ...");
        gpDs.depthFirstSearch(graphDs,vis,0);

        System.out.println("Find all the paths of between source and destination");
        vis = new boolean[graphDs.size()];
        gpDs.printAllPathsUsingDFS(graphDs,vis,0, 2,"0");

    }


    public void depthFirstSearch(List<ArrayList<Edge>> graphDS, boolean[] visited, int currentVertex) {

        if (visited[currentVertex]==true) {
            return;
        }
        System.out.println(currentVertex);
        visited[currentVertex] = true;
        graphDS.get(currentVertex).forEach(edge -> {
            depthFirstSearch(graphDS, visited, edge.getDestination());
        });
    }

    public void printAllPathsUsingDFS(List<ArrayList<Edge>> graphDS,boolean[] visited,int currentVertex,int target,String path){
        if(currentVertex==target){
            System.out.println(path);
            return;
        }
        graphDS.get(currentVertex).forEach(edge -> {

            if(visited[currentVertex]==false) {
                visited[currentVertex]=true;
                printAllPathsUsingDFS(graphDS, visited, edge.getDestination(),target,path+"-->"+edge.getDestination());
                visited[currentVertex]=false;
            }
        });


    }

    public static void breadthFirstSearchAlgorithm(List<ArrayList<Edge>> graphDS, boolean[] visitedList, int start) {
        System.out.println("============================Breadth First Search Algorithm ====================================================");
        Queue<Integer> vertexQueue = new LinkedList<>();


        //Step 1: Load the start Point into the Queue
        vertexQueue.add(start);
        int vertex = 0;
        while (!vertexQueue.isEmpty()) {
            if (!visitedList[vertexQueue.peek()]) {
                vertex = vertexQueue.remove();
                System.out.println(vertex);
                visitedList[vertex] = true;
                graphDS.get(vertex).forEach(neighbour -> {
                    vertexQueue.add(neighbour.getDestination());
                });

            } else {
                vertexQueue.remove();
            }
        }


    }

}
