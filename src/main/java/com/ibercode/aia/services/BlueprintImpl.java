package com.ibercode.aia.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibercode.aia.api.Blueprint;
import com.ibercode.aia.api.RoomService;
import com.ibercode.aia.models.Room;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

@Service
public class BlueprintImpl implements Blueprint {
	
	private boolean firstShape;
	private double x;
	private double y;
	private double upWallX ;
	private double rightWallX;
	private double rightWallY;
	private double downWallY;
	private List<Room> addedRooms = new ArrayList<>();

	@Autowired
	private RoomService areaService;

	@Override
	public void draw(Pane pane) {
		
		firstShape = true;
		List<Room> rooms = areaService.getRooms();
		addedRooms.clear();

		rooms.stream().forEach(room -> {
			System.out.println("-------------");
			//CHOOSE RADNOM ROOM
			
			if(firstShape) {
				setFirstShapeXY(room);
			} else {
				
				//chooseNeighbour(addedRooms);
				
				Random r = new Random();
				int jwall = r.nextInt(4) + 1;
				
				Room neighbour = chooseNeighbour(addedRooms);
				
				switch(jwall) {
				case 1:
					jwall1(room, neighbour);
					break;
				case 2:
					jwall2(room, neighbour);
					break;
				case 3:
					jwall3(room, neighbour);
					break;
				case 4:
					jwall4(room, neighbour);
					break;
				}
			}

			Polygon polygon = new Polygon();
			polygon.getPoints().addAll(new Double[] {
					x, y,
					upWallX, y,
					rightWallX, rightWallY,
					x, downWallY });
			setColor(polygon);

			Text roomName = getRoomTitle(room, x, y);
			
			pane.getChildren().add(polygon);
			pane.getChildren().add(roomName);

			
		});

		//end stream
		System.out.println(addedRooms);
	}


	private Room chooseNeighbour(List<Room> allRooms) {
		
		Random random = new Random();
		int roomNo = random.nextInt(allRooms.size());
		
		Room room = allRooms.get(roomNo);
		x = room.getStartX();
		y = room.getStartY();
		return room;
	}


	private void jwall4(Room room, Room nr) {
		Random r = new Random();
		int anchorPoint = r.nextInt(2) + 1;
		
		if(anchorPoint == 1) {
			System.out.println("Drawing " + room.getName() + "AP:" + anchorPoint +  "X:" + x + " Y " + y);
			x = nr.getStartX() - room.getLength();
			y = nr.getStartY();
			upWallX = x + room.getLength();
			rightWallX = x + room.getLength();
			rightWallY = y + room.getWidth();
			downWallY = y + room.getWidth();
			room.setStartX(x);
			room.setStartY(y);
			addedRooms.add(room);
			
			
		} else {
			System.out.println("Drawing " + room.getName() + "AP:" + anchorPoint +  "X:" + x + " Y " + y);
			x = nr.getStartX() - room.getLength(); 
			y = nr.getStartY() + nr.getWidth() - room.getWidth();
			upWallX = x + room.getLength();
			rightWallX = x +  room.getLength();
			rightWallY = y + room.getWidth();
			downWallY = y + room.getWidth();
			room.setStartX(x);
			room.setStartY(y);
			addedRooms.add(room);
		}
		
	}

	private void jwall3(Room room, Room nr) {
		Random r = new Random();
		int anchorPoint = r.nextInt(2) + 1;
		
		if(anchorPoint == 1) {
			
			System.out.println("Drawing " + room.getName() + "AP:" + anchorPoint +  "X:" + x + " Y " + y);
			x = nr.getStartX();
			y = nr.getStartY() + nr.getWidth();
			upWallX = x + room.getLength();
			rightWallX = x + room.getLength();
			rightWallY = y + room.getWidth();
			downWallY = y + room.getWidth();
			room.setStartX(x);
			room.setStartY(y);
			addedRooms.add(room);
		} else {
			
			System.out.println("Drawing " + room.getName() + "AP:" + anchorPoint +  "X:" + x + " Y " + y);
			x = nr.getStartX() + nr.getLength() - room.getLength();
			y = nr.getStartY() + nr.getWidth();
			upWallX = x + room.getLength();
			rightWallX = x + room.getLength();
			rightWallY = y + room.getWidth();
			downWallY = y + room.getWidth();
			room.setStartX(x);
			room.setStartY(y);
			addedRooms.add(room);
		}
		
	}

	private void jwall2(Room room, Room nr) {
		Random r = new Random();
		int anchorPoint = r.nextInt(2) + 1;
		
		if(anchorPoint == 1) {
			
			System.out.println("Drawing " + room.getName() + "AP:" + anchorPoint +  "X:" + x + " Y " + y);
			x = nr.getStartX() + nr.getLength();
			y = nr.getStartY();
			upWallX = x + room.getLength();
			rightWallX = x + room.getLength();
			rightWallY = y + room.getWidth();
			downWallY = y + room.getWidth();
			room.setStartX(x);
			room.setStartY(y);
			addedRooms.add(room);
		} else {
			
			System.out.println("Drawing " + room.getName() + "AP:" + anchorPoint +  "X:" + x + " Y " + y);
			x = nr.getStartX() + nr.getLength();
			y = nr.getStartY() + nr.getWidth() - room.getWidth();
			upWallX = x + room.getLength();
			rightWallX = x + room.getLength();
			rightWallY = y + room.getWidth();
			downWallY = y + room.getWidth();
			room.setStartX(x);
			room.setStartY(y);
			addedRooms.add(room);
		}
	}

	private void jwall1(Room room, Room nr) {
		
		Random r = new Random();
		int anchorPoint = r.nextInt(2) + 1;
		
		if(anchorPoint == 1) {
			
			System.out.println("Drawing " + room.getName() + " AP:" + anchorPoint 
					 +  "X:" + x + " Y " + y);
			x = nr.getStartX();
			y = nr.getStartY() - room.getWidth();
			upWallX = x + room.getLength();
			rightWallX = x + room.getLength();
			rightWallY = y + room.getWidth();
			downWallY = y + room.getWidth();
			room.setStartX(x);
			room.setStartY(y);
			addedRooms.add(room);
		} else {
			
			System.out.println("Drawing " + room.getName() + "AP:" + anchorPoint +  "X:" + x + " Y " + y);
			x = nr.getStartX() + nr.getLength() - room.getLength();
			y = nr.getStartY() - room.getWidth();
			upWallX = x + room.getLength();
			rightWallX = x + room.getLength();
			rightWallY = y + room.getWidth();
			downWallY = y + room.getWidth();
			room.setStartX(x);
			room.setStartY(y);
			addedRooms.add(room);
		}
		
		
	}


	private void setFirstShapeXY(Room room) {
		System.out.println("Drawing " + room.getName());
		x = 300;
		y = 300;
		upWallX = x + room.getLength();
		rightWallX = x + room.getLength();
		rightWallY = y + room.getWidth();
		downWallY = y + room.getWidth();
		firstShape = false;
		room.setStartX(x);
		room.setStartY(y);
		addedRooms.add(room);
	}

	private Text getRoomTitle(Room room, double tx , double ty) {
		Text roomName = new Text();
		roomName.setText(room.getName());
		roomName.setX(tx + 20.0);
		roomName.setY(ty + 20.0);
		setColor(roomName);
		return roomName;
	}

	private void setColor(Shape roomName) {
		roomName.setStroke(Color.WHITE);
		roomName.setFill(Color.TRANSPARENT);
	}
	
}
