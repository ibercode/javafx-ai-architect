package com.ibercode.aia.models;

public class Room {

	private String name;
	private double length;
	private double width;
	private double startX;
	private double startY;

	public Room() {
		super();
	}

	public Room(String name) {
		super();
		this.name = name;
	}

	public Room(String name, double length, double width) {
		super();
		this.name = name;
		this.length = length;
		this.width = width;
	}

	public double getStartX() {
		return startX;
	}

	public void setStartX(double startX) {
		this.startX = startX;
	}

	public double getStartY() {
		return startY;
	}

	public void setStartY(double startY) {
		this.startY = startY;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public String toString() {
		return "Room [name=" + name + ", length=" + length + ", width=" + width + ", startX=" + startX + ", startY="
				+ startY + "]";
	}


}
