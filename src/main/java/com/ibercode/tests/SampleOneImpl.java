package com.ibercode.tests;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibercode.aia.api.RoomService;
import com.ibercode.aia.models.Room;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

@Service
public class SampleOneImpl implements SampleOne{
	
	@Autowired
	private LineService lineService;
	@Autowired
	private RoomService areaService;

	@Override
	public void draw(Pane pane) {
		
		List<Room> rooms = areaService.getRooms();
		
		rooms.stream()
			.forEach(room ->{
				Line l1 = new Line(100, 400, 100 + room.getLength(), 400);
				l1.setStroke(Color.WHITE);
				Line l2 = new Line(100 + room.getLength(),400,100 + room.getLength(), 400 + room.getWidth() );
				l2.setStroke(Color.WHITE);
				pane.getChildren().add(l1);
				pane.getChildren().add(l2);
			});
		
		
		lineService.getAllNodes().stream()
		.forEach(node -> {
			pane.getChildren().add(node);
		});
		
	}

}
