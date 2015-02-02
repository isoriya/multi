package com.tenxp.concurrent.unmodifiable;

import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

public class UnmodifiableSortedMap {
	public static void unmodifiableSortedMap() {
		System.out.println("========================= unmodifiableSortedMap ========================");
		  
		
		SortedMap<Integer , String> list = new TreeMap<Integer , String>();
		list.put(4, "강동호");
		list.put(3, "박승규");
		list.put(1, "신정호");
		list.put(2, "전우균");
		list.put(1, "신정호");
		
		System.out.println("Initial list: "+ list);
		  
		SortedMap<Integer , String> immutablelist = Collections.unmodifiableSortedMap(list);
		  
		new Thread(new OrignalDataPutter(list)).start();
		new Thread(new Reader(immutablelist)).start();
		new Thread(new Putter(immutablelist)).start();
		new Thread(new Replace(immutablelist)).start();
		new Thread(new Remover(immutablelist)).start();
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	static class OrignalDataPutter implements Runnable{
		private SortedMap<Integer , String> normalList;
		public OrignalDataPutter(SortedMap<Integer , String> normalList){
			this.normalList = normalList;//reference copy
		}
		
		public void run() {
			try {
				Thread.sleep(1000);//딜레이
				this.normalList.put(6, "우구리");
				System.out.println("item OrignalDataPutter put 6 , 우구리 ");
				Thread.sleep(1000);//딜레이
				this.normalList.put(5, "신군");
				System.out.println("item OrignalDataPutter put 5 , 신군 ");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("item OrignalDataPutter :: "+ this.normalList);
		}
	}
	
	static class Reader implements Runnable{
		private SortedMap<Integer , String> immutablelist;
		public Reader(SortedMap<Integer , String> immutablelist){
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
		private SortedMap<Integer , String> immutablelist;
		public Putter(SortedMap<Integer , String> immutablelist){
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
		private SortedMap<Integer , String> immutablelist;
		public Replace(SortedMap<Integer , String> immutablelist){
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
		private SortedMap<Integer , String> immutablelist;
		public Remover(SortedMap<Integer , String> immutablelist){
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
