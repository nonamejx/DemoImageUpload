package com.demoupload.bean;

public class Image {
	private int id;
	private String name;
	private String description;

	public Image() {
	}

	public Image(String name) {
		this.name = name;
	}

	public Image(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Image(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Image [" + id + ", " + name + ", " + description + "]";
	}

}
