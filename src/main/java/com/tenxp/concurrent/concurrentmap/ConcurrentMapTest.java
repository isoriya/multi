package com.tenxp.concurrent.concurrentmap;

import java.util.*;
import java.util.concurrent.*;
 
public class ConcurrentMapTest {
 
 public static void main(String args[]) {
	 
     //ConcurrentHashMap
     Map<String,String> myMap = new ConcurrentHashMap<String,String>();
     myMap.put("1", "1");
     myMap.put("2", "1");
     myMap.put("3", "1");
     myMap.put("4", "1");
     myMap.put("5", "1");
     myMap.put("6", "1");
     System.out.println("ConcurrentHashMap : "+myMap);
     Iterator<String> it = myMap.keySet().iterator();

     while(it.hasNext()){
         String key = it.next();
         if(key.equals("3")) myMap.put(key+"new", "new3");
     }
     System.out.println("ConcurrentHashMap after iterator: "+myMap);


     myMap = new HashMap<String,String>();
     myMap.put("1", "1");
     myMap.put("2", "1");
     myMap.put("3", "1");
     myMap.put("4", "1");
     myMap.put("5", "1");
     myMap.put("6", "1");
     System.out.println("HashMap before iterator: "+myMap);
     Iterator<String> it1 = myMap.keySet().iterator();

     while(it1.hasNext()){
         String key = it1.next();
         if(key.equals("3")){
        	 myMap.put(key+"new", "new3");
        	 break;
         }
     }
     System.out.println("HashMap after iterator: "+myMap);

 }

}

