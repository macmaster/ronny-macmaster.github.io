/********************Car2D***************************************
 * Java Car Class
 * Defines a Car class to keep track of Car attributes
 * 
 * Section : F 2:00 - 3:30pm
 * Author: Ronny Macmaster
 * Date: 3/27/16
 * EID: rpm953
 ***************************************************************/

package assignment5;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

public class Car2D{
	// top-left corner coordinates of car's square space
	private static int height, width; // car height, width
	private int x, y; // x-coordinate, y-coordinate
	private String num; // racecar number
	private Polygon roof; // burnt orange car roof
	private Rectangle body; // burnt orange car body
	private Ellipse2D.Double frontTire; // black front wheel
	private Ellipse2D.Double rearTire; // black front wheel

	// debug
	// private Rectangle outline;

	public Car2D(String num, int x, int y){
		// initialize car data
		this.x = x;
		this.y = y;
		height = 35;
		width = 70;
		this.num = num;
		roof = new Polygon();
		body = new Rectangle();
		frontTire = new Ellipse2D.Double();
		rearTire = new Ellipse2D.Double();

		// build car parts
		buildCar();
	}

	/******************buildCar()**************************************
	 * Initializes the Car Body Bounds
	 * Uses Shape classes from the Abstract Windows Toolkit
	 * 
	 * Input: none
	 * Precondition: none 
	 *****************************************************************/
	private void buildCar(){
		// debug
		//outline = new Rectangle(x, y, width, height);

		// build roof
		roof.addPoint(x + 1 * width / 4, y);
		roof.addPoint(x + 3 * width / 4, y);
		roof.addPoint(x + 7 * width / 8, y + height / 4);
		roof.addPoint(x + 1 * width / 8, y + height / 4);

		// build body
		body.setRect(x, y + height / 4, width, height * 5 / 12);

		// build front tire
		frontTire.setFrame(x + width * 1 / 8, y + height * 2 / 3, width / 6, height / 3);

		// build rear tire
		rearTire.setFrame(x + width * 11 / 16, y + height * 2 / 3, width / 6, height / 3);
	}

	/******************draw()**************************************
	 * Draws Car2D Body Parts one at a time
	 * Each Body part is a shape to be drawn individually
	 * 
	 * @param g2: Graphics object for painting
	 * Precondition: none 
	 *****************************************************************/
	public void draw(Graphics2D g2){
		// debug
		// g2.draw(outline);

		// colors
		Color burntOrange = new Color(191, 87, 0);
		Color black = Color.black;
		g2.setColor(burntOrange);
		g2.fill(body);
		g2.fill(roof);

		g2.setColor(black);
		g2.fill(rearTire);
		g2.fill(frontTire);

		// draw images
		g2.draw(roof);
		g2.draw(body);
		g2.draw(frontTire);
		g2.draw(rearTire);
		g2.drawString(num, x + width * 5 / 12, y + height * 7 / 12);

	}

	/******************translate()*************************************
	 * Translates Each Body Part by dx and dy
	 * Each Body Part is a shape
	 * 
	 * @param dx: change of position in the x direction
	 * @param dy: change of position in the y direction
	 * Precondition: none 
	 *****************************************************************/
	public void translate(int dx, int dy){
		// translate wheel frames
		Rectangle rearFrame = rearTire.getBounds();
		Rectangle frontFrame = frontTire.getBounds();
		rearFrame.translate(dx, dy);
		frontFrame.translate(dx, dy);

		// translate car parts
		x += dx;
		y += dy;
		body.translate(dx, dy);
		roof.translate(dx, dy);
		rearTire.setFrame(rearFrame);
		frontTire.setFrame(frontFrame);
	}

	/** getX()
	 * @return: x position of car Object */
	public int getX(){
		return x;
	}
	/** getY()
	 * @return: y position of car Object */
	public int getY(){
		return y;
	}

	/** getNum()
	 * @return: number string on car's body*/
	public String getNum(){
		return num;
	}

	/** getWidth()
	 * @return: width of a car Object */
	public static int getWidth(){
		return width;
	}

	/** getHeight()
	 * @return: height of a car Object */
	public static int getHeight(){
		return height;
	}

}
