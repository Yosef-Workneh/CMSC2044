package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road> {

 Set<Town> towns;
 Set<Road> roads;

 
Map<String, Town> P_Town;
  

public Graph() {
   
   this.towns = new HashSet<>();
   this.roads = new HashSet<>();
   this.P_Town = new HashMap<>();
}


@Override
   public Road getEdge(Town sourceVertex, Town destinationVertex) {

	for (Road road : roads) {

	if ((sourceVertex.equals(road.getSource()) || sourceVertex.equals(road.getDestination()))&&
       (destinationVertex.equals(road.getDestination()) || destinationVertex.equals(road.getSource()))
       )
	{
		return road;

	}
}

return null;

}

@Override


public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
   
	if (containsEdge(sourceVertex, destinationVertex)) {

		return null;
}
   if (!containsVertex(sourceVertex) || !containsVertex(destinationVertex)) {

	   throw new IllegalArgumentException();}
   
   if (sourceVertex == null || destinationVertex == null || description == null) {
throw new NullPointerException();

   
   }
Road road = new Road(sourceVertex, destinationVertex, weight, description);

      roads.add(road);

      return road;
  
}

@Override

 public boolean addVertex(Town v) {

	towns.add(v);
if (containsVertex(v)) {

	return false;
}

if (v == null) {
	
	throw new NullPointerException();
}

  return true;
}

@Override
public boolean containsEdge(Town sourceVertex, Town destinationVertex) {

	for (Road road : roads) {
if ((sourceVertex.equals(road.getSource()) || sourceVertex.equals(road.getDestination()))

		&& (destinationVertex.equals(road.getDestination()) || destinationVertex.equals(road.getSource()))) {

	return true;
}

	}

	return false;
}

@Override
public boolean containsVertex(Town v) {

	for (Town t : towns) {

		if (t.equals(v)) {

			return true;
}}

	return false;
}

@Override

public Set<Road> edgeSet() {

	return roads;
}

@Override

public Set<Road> edgesOf(Town vertex) {

	Set<Road> x = new HashSet<>();
   
	if (!containsVertex(vertex)) {

		throw new IllegalArgumentException();
}

	if (vertex == null) {

	throw new NullPointerException();
}

	for (Road road : roads) {

		if (road.getSource().equals(vertex) || road.getDestination().equals(vertex)) {
x.add(road);

		}
}
return x;
}

@Override

public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {

	Road removeEdge = new Road(sourceVertex, destinationVertex, weight, description);

	Road e = null;

	for (Road r : roads) {

	if (r.equals(removeEdge)) {

		e = r;

		break;
}

	}if (e != null) {

		
	roads.remove(e);
}

	return e;
}
 
@Override

public boolean removeVertex(Town v) {

	Town town = null;

   for (Town t : towns) {

	   if (t.equals(v)) {

		   town = t;
}
}

   if (town != null) {

	   towns.remove(town);

	   return true;
}
return false;
}

@Override
public Set<Town> vertexSet() {

	return towns;
}

@Override
public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {

	ArrayList <String> p = new ArrayList<>();

	dijkstraShortestPath(sourceVertex);

	Town t = destinationVertex;

	while (!t.equals(sourceVertex)) {

	if (!P_Town.containsKey(t.getName())) {

		p.clear();

		break;
}

	Town pT = P_Town.get(t.getName());


	Road road = getEdge(pT, t);


	p.add(0, pT.getName() + " via " + road.getName() + " to " + t.getName() + " " + road.getWeight() + " mi ");

	t = pT;
}

	return p;
}

@Override
public void dijkstraShortestPath(Town sourceVertex) {

	Set<Town> town = new HashSet<>();

	List<Town> town2 = new ArrayList<>();

	HashMap<String, Integer> cost = new HashMap<>();

	P_Town.clear();


	for (Town t : towns) {

		town2.add(t);


		cost.put(t.getName(), Integer.MAX_VALUE);

		P_Town.put(t.getName(), null);
}

	cost.put(sourceVertex.getName(), 0);

	System.out.println(town2);

	System.out.println(cost + "\n");

	while (!town2.isEmpty()) {

		int lowestIndex = 0;

for (int i = 1; i < town2.size(); i++) {

	Town Vertex2 = town2.get(i);

if (cost.get(Vertex2.getName()) < cost.get(town2.get(lowestIndex).getName())) {
lowestIndex = i;
}

}

Town lowestCostVertex = town2.remove(lowestIndex);
town.add(lowestCostVertex);


if (cost.get(lowestCostVertex.getName()) == Integer.MAX_VALUE) {
return;
}

for (Road r : edgesOf(lowestCostVertex)) {

	Town n = r.getDestination();

if (n.equals(lowestCostVertex)) {
n = r.getSource();

}

if (town.contains(n)) {
continue;

}

int adjCost = cost.get(lowestCostVertex.getName()) + r.getWeight();

if (adjCost < cost.get(n.getName())) {
cost.put(n.getName(), adjCost);
P_Town.put(n.getName(), lowestCostVertex);
}


}
}
}



}
