package gameworld;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import engine.fieldsetting.Settable;
import engine.gameobject.GameObject;
import engine.gameobject.GameObjectSimpleTest;
import engine.gameobject.PointSimple;
import engine.gameobject.test.TestTower;
import engine.gameobject.units.Buffable;
import engine.gameobject.weapon.firingstrategy.Buffer;
import engine.interactions.InteractionEngine;
import engine.pathfinding.EndOfPathException;
import engine.pathfinding.Path;


public class FixedWorld extends AbstractWorld {
	private double myPathWidth = 17;

	@Override
	public boolean isPlacable (Node n, PointSimple pixelCoords) {
		n.setLayoutX(pixelCoords.getX());
		n.setLayoutY(pixelCoords.getY());
		int i = 0;
		Circle c = new Circle(myPathWidth);
		while(true){
			try {
				PointSimple pathPoint = myPath.getNextLocation(i, 10, new PointSimple(c.getCenterX(),c.getCenterY()));
				c.setCenterX(pathPoint.getX()+28);
				c.setCenterY(pathPoint.getY()+28);
				if(c.intersects(n.getBoundsInParent())){
					return false;
				}
			} catch (EndOfPathException e) {
				break;
			}
			i+=20;
		}
		return true;
	}

	@Settable
	public void setPathWidth(double width){
		myPathWidth = width;
	}
}
