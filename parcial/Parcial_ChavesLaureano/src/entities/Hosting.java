package entities;

import java.util.ArrayList;

public abstract class Hosting {

	private boolean usesCdn;
	private boolean usesVps;
	private ArrayList<Site> sites;
	
	public boolean isUsesCdn() {
		return usesCdn;
	}
	
	public boolean isUsesVps() {
		return usesVps;
	}
	
	
	
	
}
