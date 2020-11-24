package com.ibercode.aia.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibercode.aia.api.RoomService;
import com.ibercode.aia.api.RoomSize;
import com.ibercode.aia.models.Room;

@Service
public class RoomServiceImpl implements RoomService {

	private double totalArea;
	private double livingroomArea;
	private double kitchenArea;
	private double dormitoryArea;
	private double bathroomArea;
	private double hallArea;
	
	@Autowired
	private RoomSize roomSize;

	@Override
	public List<Room> getRooms() {
		
		List<Room> rooms = new ArrayList<>();
		
		totalArea = 100000.0;
		livingroomArea = totalArea * .35;
		dormitoryArea = totalArea * .25;
		kitchenArea = totalArea * .15;
		bathroomArea = totalArea * .10;
		hallArea = totalArea * .05;
		
		Room livingroom = roomSize.getRoom(livingroomArea, "Livingroom");
		Room kitchen = roomSize.getRoom(kitchenArea, "Kitchen");
		Room dormitory = roomSize.getRoom(dormitoryArea, "Dormitory");
		Room bathroom = roomSize.getRoom(bathroomArea, "Bathroom");
		Room hall = roomSize.getRoom(hallArea, "Hall"); 
		
		rooms.add(livingroom);
		rooms.add(kitchen);
		rooms.add(dormitory);
		rooms.add(bathroom);
		rooms.add(hall);
		
		return rooms;
	}

}
