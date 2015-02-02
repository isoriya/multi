package com.tenxp.concurrent.unmodifiable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UnmodifiableMap {
	public static void unmodifiableMap() {
		System.out.println("========================= UnmodifiableMap ========================");
		  
	      Map<Integer , String> list = new HashMap<Integer , String>();
	      
	      list.put(1, "신정호");
	      list.put(2, "전우균");
	      list.put(3, "박승규");
	      list.put(4, "강동호");
	      
	      System.out.println("Initial list: "+ list);
	      
	      Map<Integer , String> immutablelist = Collections.unmodifiableMap(list);
	      
	      new Thread(new Reader(immutablelist)).start();
	      new Thread(new Putter(immutablelist)).start();
	      new Thread(new Replace(immutablelist)).start();
	      new Thread(new Remover(immutablelist)).start();
	}
	
	static class Reader implements Runnable{
		private Map<Integer , String> immutablelist;
		public Reader(Map<Integer , String> immutablelist){
			this.immutablelist = immutablelist;//reference copy
		}
		
		public void run() {
			System.out.println("item Reader :: "+ this.immutablelist);
		}
	}
	
	static class Putter implements Runnable{
		private Map<Integer , String> immutablelist;
		public Putter(Map<Integer , String> immutablelist){
			this.immutablelist = immutablelist;//reference copy
		}
		
		public void run() {
			try{
				this.immutablelist.put(5, "신군");
				System.out.println("item Putter :: "+ this.immutablelist);
			}catch(Exception e){
				System.out.println("item Putter exception :: "+ e);
			}
		}
	}
	
	static class Replace implements Runnable{
		private Map<Integer , String> immutablelist;
		public Replace(Map<Integer , String> immutablelist){
			this.immutablelist = immutablelist;//reference copy
		}
		
		public void run() {
			try{
				this.immutablelist.replace(1, " shingoon");
				System.out.println("item Replace :: "+ this.immutablelist);
			}catch(Exception e){
				System.out.println("item Replace exception :: "+ e);
			}
		}
	}
	
	static class Remover implements Runnable{
		private Map<Integer , String> immutablelist;
		public Remover(Map<Integer , String> immutablelist){
			this.immutablelist = immutablelist;//reference copy
		}
		
		public void run() {
			try{
				this.immutablelist.clear();
				System.out.println("item Remover :: "+ this.immutablelist);
			}catch(Exception e){
				System.out.println("item Remover exception :: "+ e);
			}
		}
	}
}
