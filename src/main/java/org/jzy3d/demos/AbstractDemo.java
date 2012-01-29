package org.jzy3d.demos;

import org.jzy3d.chart.Chart;

public abstract class AbstractDemo implements IDemo{
	@Override
	public String getName() {
		return this.getClass().getSimpleName();
	}
	
	@Override
	public String getPitch(){
		return "";
	}
	
	@Override
	public boolean isInitialized(){
	    return chart!=null;
	}
	
	@Override
	public Chart getChart(){
        return chart;
    }
    
    protected Chart chart;
}
