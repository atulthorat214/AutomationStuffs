package com.RestAssuared;

import java.util.HashSet;
import java.util.Iterator;

public class set {
	
	public static void main(String[] args)
	
	{
		
		
		HashSet<Car> hashset=new HashSet<Car>();
		
		for(int i=0;i<=50;i++)
		{
			hashset.add(new Car("H-"+i));
		}
		
		
		Iterator<Car> itr=hashset.iterator();
		
		while(itr.hasNext())
		{
			
			System.out.println(itr.next());
		}
		
	}

}
