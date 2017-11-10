package com.oreilly.sdata;

import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class Library {

	private String libraryId;

	private String name;

	@JsonDeserialize(using=PointDeserializer.class)
	private Point coords;

	public String getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(String libraryId) {
		this.libraryId = libraryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Point getCoords() {
		return coords;
	}

	public void setCoords(Point coords) {
		this.coords = coords;
	}

	@Override
	public String toString() {
		return "Library [libraryId=" + libraryId + ", name=" + name + ", coords=" + coords + "]";
	}

}
