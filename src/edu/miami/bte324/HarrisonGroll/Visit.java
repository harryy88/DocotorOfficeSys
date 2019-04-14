package edu.miami.bte324.HarrisonGroll;

import java.util.Date;

public interface Visit<V, T> {
	//V = Visitor, T = Host
	
	public V getV(); 
	
	public T getT();
	
	public Date getDate(); 
}
