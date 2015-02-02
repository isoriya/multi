package com.tenxp.concurrent.unmodifiable;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.tenxp.concurrent.unmodifiable.UnmodifiableSortedMap.OrignalDataPutter;


public class UnmodifiableSet {
	public static void unmodifiableSet() {
		System.out.println("========================= unmodifiableSet ========================");
		  
	      Map<Integer , String> list = new HashMap<Integer , String>();
	      
	      list.put(1, "신정호");
	      list.put(2, "전우균");
	      list.put(3, "박승규");
	      list.put(4, "강동호");
	      
	      System.out.println("Initial list: "+ list.keySet());
	      
	      Set<Integer> immutablelist = Collections.unmodifiableSet(list.keySet());
	      
	      new Thread(new OrignalDataPutter(list.keySet())).start();
	      new Thread(new Reader(immutablelist)).start();
	      new Thread(new Putter(immutablelist)).start();
	      new Thread(new Remover(immutablelist)).start();
	}
	
	static class OrignalDataPutter implements Runnable{
		private Set<Integer> normalList;
		public OrignalDataPutter(Set<Integer> normalList){
			this.normalList = normalList;//reference copy
		}
		
		public void run() {
			try {
				Thread.sleep(1000);//딜레이
				this.normalList.add(6);
				System.out.println("item OrignalDataPutter add 6");
				Thread.sleep(1000);//딜레이
				this.normalList.add(5);
				System.out.println("item OrignalDataPutter add 5");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("item OrignalDataPutter final :: "+ this.normalList);
		}
	}
	
	
	static class Reader implements Runnable{
		private Set<Integer> immutablelist;
		public Reader(Set<Integer> immutablelist){
			this.immutablelist = immutablelist;//reference copy
		}
		
		public void run() {
			try {
				System.out.println("item Reader before:: "+ this.immutablelist);
				Thread.sleep(1000);//딜레이
				System.out.println("item Reader after 1:: "+ this.immutablelist);
				Thread.sleep(1000);//딜레이
				System.out.println("item Reader after 2:: "+ this.immutablelist);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	static class Putter implements Runnable{
		private Set<Integer> immutablelist;
		public Putter(Set<Integer> immutablelist){
			this.immutablelist = immutablelist;//reference copy
		}
		
		public void run() {
			try{
				this.immutablelist.add(6);
				System.out.println("item Putter :: "+ this.immutablelist);
			}catch(Exception e){
				System.out.println("item Putter exception :: "+ e);
			}
		}
	}
	

	static class Remover implements Runnable{
		private Set<Integer> immutablelist;
		public Remover(Set<Integer> immutablelist){
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
