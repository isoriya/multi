package com.tenxp.concurrent.unmodifiable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;

import com.tenxp.concurrent.unmodifiable.UnmodifiableSortedMap.OrignalDataPutter;

public class UnmodifiableCollection {
	public static void unmodifiableCollection() {
		System.out.println("========================= unmodifiableCollection ========================");
  
		List<String> list = new ArrayList<String>();
	      list.add("신정호");
	      list.add("전우균");
	      list.add("박승규");
	      list.add("강동호");
	      
	      System.out.println("Initial list: "+ list);
	      
	      Collection<String> immutablelist = Collections.unmodifiableCollection(list);
	      
	      new Thread(new OrignalDataPutter(list)).start();
	      new Thread(new Reader(immutablelist)).start();
	      new Thread(new Putter(immutablelist)).start();
	      new Thread(new Remover(immutablelist)).start();
	      
	      try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	static class OrignalDataPutter implements Runnable{
		private Collection<String> normalList;
		public OrignalDataPutter(Collection<String> normalList){
			this.normalList = normalList;//reference copy
		}
		
		public void run() {
			try {
				Thread.sleep(1000);//딜레이
				this.normalList.add("우구리");
				System.out.println("item OrignalDataPutter add 우구리");
				Thread.sleep(1000);//딜레이
				this.normalList.add("신군");
				System.out.println("item OrignalDataPutter add 신군");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("item OrignalDataPutter final:: "+ this.normalList);
		}
	}
	
	
	static class Reader implements Runnable{
		private Collection<String> immutablelist;
		public Reader(Collection<String> immutablelist){
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
		private Collection<String> immutablelist;
		public Putter(Collection<String> immutablelist){
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
		private Collection<String> immutablelist;
		public Remover(Collection<String> immutablelist){
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
