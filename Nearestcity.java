/*
* Date : 02/14/2021
* Question : https://aonecode.com/amazon-online-assessment-nearest-cities
*/

import java.util.*;
import java.io.*;

public class Nearestcity {

    public static String[] findNearestCities(int numOfCities, String[] points, int[] xCoordinates, int[] yCoordinates,
                                             int numOfQueriedPoints, String[] queries) {

        //adding cities to hashmap
        HashMap<String, Integer> map = new HashMap<>();
        for(int i =0; i<points.length; i++)
            map.put(points[i],i);

        //Priorityqueue to store the city with x and y coordinates values
        PriorityQueue<Map.Entry<String,Integer>> citypq[] = new PriorityQueue[numOfCities];
        for(int i=0; i<citypq.length; i++){
            citypq[i] = new PriorityQueue<>(
                    (a,b) -> a.getValue()-b.getValue()!=0 ? a.getValue()-b.getValue() :
                            a.getKey().compareTo(b.getKey())
            );
        }

        //compare xcoordinates of the cities
        for(int i=0; i<xCoordinates.length;i++){
            for(int j=0; j<yCoordinates.length; j++){
                if(i == j)
                    continue;

                if(xCoordinates[i] == xCoordinates[j]){
                    int x = Math.abs(xCoordinates[i] - xCoordinates[j]);
                    int y = Math.abs(yCoordinates[i] - yCoordinates[j]);
                    int result = x+y;

                    HashMap<String,Integer> map1 = new HashMap<>();
                    map1.put(points[j],result);

                    for(Map.Entry<String,Integer> ele : map1.entrySet())
                        citypq[i].offer(ele);
                }
            }
        }

        //compare ycoordinates of the cities
        for(int i=0; i<xCoordinates.length;i++){
            for(int j=0; j<yCoordinates.length; j++){
                if(i == j)
                    continue;

                if(yCoordinates[i] == yCoordinates[j]){
                    int x = Math.abs(xCoordinates[i] - xCoordinates[j]);
                    int y = Math.abs(yCoordinates[i] - yCoordinates[j]);
                    int result = x+y;

                    HashMap<String,Integer> map1 = new HashMap<>();
                    map1.put(points[j],result);

                    for(Map.Entry<String,Integer> ele : map1.entrySet())
                        citypq[i].offer(ele);
                }
            }
        }
        
        //print the result
        String res[] = new String[numOfCities];
        for(int i=0; i<queries.length;i++){
            int index = map.get(queries[i]);
            if(!citypq[index].isEmpty()){
                Map.Entry<String,Integer> e = citypq[index].peek();
                res[i] = e.getKey();
            }
            else res[i] = "NONE";
        }
        return res;
    }
}
