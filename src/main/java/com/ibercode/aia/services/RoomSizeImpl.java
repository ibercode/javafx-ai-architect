package com.ibercode.aia.services;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.ibercode.aia.api.RoomSize;
import com.ibercode.aia.models.Room;

@Service
public class RoomSizeImpl implements RoomSize {

	@Override
	public Room getRoom(double area, String name) {

		Room room = new Room(name);
		double roomSqrt = Math.sqrt(area);

		int random = getRandom(name);

		double lengthLr = roomSqrt * (100 - random) / 100;
		double widthLr = area / lengthLr;

		Random r = new Random();
		int coin = r.nextInt((1 - 0) + 1) + 0;

		System.out.println("COIN " + coin);

		if (coin == 1) {
			room.setLength(lengthLr);
			room.setWidth(widthLr);
		}

		if (coin == 0) {
			room.setLength(widthLr);
			room.setWidth(lengthLr);
		}

		return room;
	}

	private int getRandom(String name) {
		int random = 0;
		Random r = new Random();
		switch (name) {
		case "Livingroom":
			random = r.nextInt((20 - 0) + 1) + 0;
			break;
		case "Kitchen":
			random = r.nextInt((30 - 0) + 1) + 0;
			break;
		case "Dormitory":
			random = r.nextInt((25 - 0) + 1) + 0;
			break;
		case "Bathroom":
			random = r.nextInt((15 - 0) + 1) + 0;
			break;
		case "Hall":
			random = r.nextInt((50 - 0) + 1) + 0;
			break;
		}
		
		return random;
	}
}
