package org.example.Graphs;

import java.util.*;

public class GraphsDS {


    public static List<ArrayList<Edge>> createWeightedGraph(){
        int vertexCount = 6;
        List<ArrayList<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < vertexCount; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new Edge(0, 1,2));
        graph.get(0).add(new Edge(0, 2,4));
        graph.get(1).add(new Edge(1, 2,1));
        graph.get(1).add(new Edge(1, 3,7));
        graph.get(2).add(new Edge(2, 4,3));
        graph.get(3).add(new Edge(3, 5,1));
        graph.get(4).add(new Edge(4, 3,2));
        graph.get(4).add(new Edge(4, 5,5));

        return graph;

    }



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
    getSmallGraph(int vertexCount) {
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

    public static void printTheNeighbour(List<ArrayList<Edge>> graph, int vertexCount) {
        int i = 0;
        while (i < vertexCount) {
            int finalI = i;
            graph.get(i).forEach(edge -> System.out.println("I am vertext" + finalI + "'s neighbour:" + edge.getDestination()));
            i++;
        }
    }

    public static List<ArrayList<Edge>> smallCyclicGraph() {
        List<ArrayList<Edge>> graphDs = new ArrayList<>();
        ArrayList<Edge> vertex1 = new ArrayList<Edge>();
        vertex1.add(new Edge(0, 1));
        vertex1.add(new Edge(0, 2));
        ArrayList<Edge> vertex2 = new ArrayList<Edge>();
        vertex2.add(new Edge(1, 0));
        vertex2.add(new Edge(1, 2));
        ArrayList<Edge> vertex3 = new ArrayList<Edge>();
        vertex3.add(new Edge(2, 0));
        vertex3.add(new Edge(2, 1));
        graphDs.add(vertex1);
        graphDs.add(vertex2);
        graphDs.add(vertex3);
        return graphDs;
    }

    public static void main(String[] args) {
        GraphsDS gpDs = new GraphsDS();

        List<ArrayList<Edge>> graphDs = createWeightedGraph();
        boolean[] visited = new boolean[graphDs.size()];
        int[] distanceMatrix = new int[graphDs.size()];
        System.out.println("distance matrix size:::"+distanceMatrix.length);
        dijestrasAlgorithmTofindtheShortestPath(graphDs,visited,distanceMatrix,5);

        //bfsTest(graphDs);

        //  printTheNeighbour(graphDs);
      /* ;
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
        gpDs.printAllPathsUsingDFS(graphDs,vis,0, 2,"0");*/

    }

    static class NodeData implements Comparable<NodeData> {
        int vertex;
        int distance;

        public NodeData(int vertex, int
                distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(NodeData o) {
            return this.distance - o.distance;
        }
    }

    public static void dijestrasAlgorithmTofindtheShortestPath(List<ArrayList<Edge>> graphDs, boolean[] visited, int[] distance, int src) {
        PriorityQueue<NodeData> pq = new PriorityQueue<NodeData>();
        for (int i = 0; i < graphDs.size(); i++) {
            if (i != src) {
                distance[i] = Integer.MAX_VALUE;
            }
        }
            pq.add(new NodeData(src, 0));

            while (!pq.isEmpty()) {
                NodeData node = pq.remove();
                if (!visited[node.vertex]) {
                    visited[node.vertex]=true;
                    graphDs.get(node.vertex).forEach(edge -> {
                        int u = node.vertex;
                        int v = edge.getDestination();
                        int weight = edge.getWeight();

                        if (distance[u] + weight < distance[v]) {
                            distance[v] = distance[u] + weight;
                            pq.add(new NodeData(edge.getDestination(),distance[v]));
                        }

                    });
                }
            }
        for(int i=0;i<distance.length;i++) {
            System.out.print(distance[i]+" ");
        }
        }






    public static void dfsTest(List<ArrayList<Edge>> sampleGraph, Boolean[] visitedGraph, int currentVertex) {
        if (visitedGraph[currentVertex]) {
            return;
        }
        System.out.println(currentVertex);
        visitedGraph[currentVertex] = true;
        sampleGraph.get(currentVertex).forEach(v -> {
            dfsTest(sampleGraph, visitedGraph, v.getDestination());
        });

    }

    public static void bfsTest(List<ArrayList<Edge>> sampleGraph) {
        boolean[] visitedGraph = new boolean[sampleGraph.size()];
        Queue<Integer> graphQueue = new LinkedList<>();
        graphQueue.add(0);
        int vertex = 0;

        while (!graphQueue.isEmpty()) {
            if (!visitedGraph[graphQueue.peek()]) {
                vertex = graphQueue.remove();
                System.out.print(vertex + " ");
                visitedGraph[vertex] = true;
                sampleGraph.get(vertex).forEach(v -> {
                    graphQueue.add(v.getDestination());
                });
            } else {
                graphQueue.remove();
            }

        }


    }


    public void depthFirstSearch(List<ArrayList<Edge>> graphDS, boolean[] visited, int currentVertex) {

        if (visited[currentVertex] == true) {
            return;
        }
        System.out.println(currentVertex);
        visited[currentVertex] = true;
        graphDS.get(currentVertex).forEach(edge -> {
            depthFirstSearch(graphDS, visited, edge.getDestination());
        });
    }

    public void printAllPathsUsingDFS(List<ArrayList<Edge>> graphDS, boolean[] visited, int currentVertex, int target, String path) {
        if (currentVertex == target) {
            System.out.println(path);
            return;
        }
        graphDS.get(currentVertex).forEach(edge -> {

            if (visited[currentVertex] == false) {
                visited[currentVertex] = true;
                printAllPathsUsingDFS(graphDS, visited, edge.getDestination(), target, path + "-->" + edge.getDestination());
                visited[currentVertex] = false;
            }
        });


    }

    public static boolean cycleDetection(List<ArrayList<Edge>> graphDs, boolean[] visited, int current, int parent) {
        visited[current] = true;

        for (int i = 0; i < graphDs.get(current).size(); i++) {
            Edge e = graphDs.get(current).get(i);
            if (e.getDestination() != parent && visited[e.getDestination()]) {
                System.out.println("cycle dectected..");
                return true;
            } else if (e.getDestination() != parent && !visited[e.getDestination()]) {
                if (cycleDetection(graphDs, visited, e.getDestination(), current)) {
                    return true;
                }
            }
        }

        return false;
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
