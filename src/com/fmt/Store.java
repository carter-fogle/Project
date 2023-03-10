package com.fmt;

import java.util.Comparator;

/**
 * This class represents an Store
 *  
 * @author Carter Fogle
 * @date 24-02-23
 * 
 */

public class Store{
	
	private final String anc;
	private final Person manager;
	private final Address address;
	
	
	/**
	 * Constructor for type <code>Store</code>
	 * 
	 * @param anc
	 * @param manc
	 * @param address
	 */
	public Store(String anc, Person manager, Address address) {
		this.anc = anc;
		this.manager = manager;
		this.address = address;
	}
	
	public Store(String anc) {
		this(anc, null, null);
	}

	public String getAnc() {
		return anc;
	}

	public Address getAddress() {
		return address;
	}
	
	public static final Comparator<Store> BY_ANC = new Comparator<>() {
		@Override
		public int compare(Store s1, Store s2) {
			return -(s1.getAnc().compareTo(s2.getAnc()));
		}
	};

	@Override
	public String toString() {
		return anc + "," + manager.getAnc() + "," + address.toString();
	}
}
