package com.oreilly.sdata;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="classic", types={Book.class})
public interface ClassicProjection {

	public String getTitle();
	
	public int getPageCount();
}
