package com.ibercode.tests;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;

@Service
public class LineService {

	public List<Node> getAllNodes() {

		List<Node> nodes = new ArrayList<>();

		nodes.addAll(getLines());
		nodes.add(getArc());
		nodes.add(getCircle());
		nodes.add(getPolyline());
		nodes.add(getEllipse());

		return nodes;
	}

	private Node getEllipse() {
		Ellipse ellipse = new Ellipse();
		ellipse.setCenterX(150.0f);
		ellipse.setCenterY(150.0f);
		ellipse.setRadiusX(20.0f);
		ellipse.setRadiusY(45.0f);
		ellipse.setStroke(Color.WHITE);
		ellipse.setFill(Color.TRANSPARENT);
		return ellipse;
	}

	private List<Line> getLines() {
		List<Line> lines = new ArrayList<>();

		Line l1 = new Line(100, 400, 200, 400);
		l1.setStroke(Color.WHITE);
		Line l2 = new Line(200, 400, 200, 500);
		l2.setStroke(Color.WHITE);
		Line l3 = new Line(200, 500, 100, 500);
		l3.setStroke(Color.WHITE);
		Line l4 = new Line(100, 500, 100, 400);
		l4.setStroke(Color.WHITE);
		lines.add(l1);
		lines.add(l2);
		lines.add(l3);
		lines.add(l4);

		return lines;
	}

	private Node getPolyline() {
		Polyline polyline = new Polyline();
		polyline.getPoints()
				.addAll(new Double[] { 300.0, 300.0, 400.0, 400.0, 400.0, 450.0, 300.0, 450.0, 300.0, 320.0 });
		polyline.setStroke(Color.WHITE);
		return polyline;
	}

	private Node getCircle() {
		Circle circle = new Circle(500, 500, 100);
		circle.setStroke(Color.WHITE);
		circle.setFill(Color.TRANSPARENT);
		return circle;
	}

	private Node getArc() {
		Arc arc = new Arc();

		arc.setCenterX(300);
		arc.setCenterY(150);
		arc.setRadiusX(90);
		arc.setRadiusY(90);
		arc.setStartAngle(0);
		arc.setLength(90);
		arc.setType(ArcType.OPEN);
		arc.setFill(Color.TRANSPARENT);
		arc.setStroke(Color.WHITE);
		return arc;
	}

}
