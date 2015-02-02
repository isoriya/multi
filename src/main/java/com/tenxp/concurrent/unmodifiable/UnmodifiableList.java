package com.tenxp.concurrent.unmodifiable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnmodifiableList {
	public static void unmodifiableList() {
		System.out.println("========================= UnmodifiableList ========================");
		  
	      List<String> list = new ArrayList<String>();
	      list.add("신정호");
	      list.add("전우균");
	      list.add("박승규");
	      list.add("강동호");
	      
	      System.out.println("Initial list: "+ list);
	      
	      List<String> immutablelist = Collections.unmodifiableList(list);
	      
	      new Thread(new Reader(immutablelist)).start();
	      new Thread(new Putter(immutablelist)).start();
	      new Thread(new Remover(immutablelist)).start();
	}
	
	static class Reader implements Runnable{
		private List<String> immutablelist;
		public Reader(List<String> immutablelist){
			this.immutablelist = immutablelist;//reference copy
		}
		
		public void run() {
			System.out.println("item Reader :: "+ this.immutablelist);
		}
	}
	
	static class Putter implements Runnable{
		private List<String> immutablelist;
		public Putter(List<String> immutablelist){
			this.immutablelist = immutablelist;//reference copy
		}
		
		public void run() {
			try{
				this.immutablelist.add("신군");
				System.out.println("item Putter :: "+ this.immutablelist);
			}catch(Exception e){
				System.out.println("item Putter exception :: "+ e);
			}
		}
	}
	
	static class Remover implements Runnable{
		private List<String> immutablelist;
		public Remover(List<String> immutablelist){
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
