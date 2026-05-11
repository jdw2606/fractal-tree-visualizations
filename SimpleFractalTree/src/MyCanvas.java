import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.JSlider;

public class MyCanvas extends JPanel{
	int x = 800;
	int y = 800;
	int len = 200;
	JSlider slider;


	public MyCanvas(JSlider slider) {
		this.setPreferredSize(new Dimension(x, y));
		this.slider = slider;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		super.paintComponent(g2D);		
		g2D.setStroke(new BasicStroke(3));
		g.translate(x/2, y);
		branch(g2D, len);
	}
	
	public void branch(Graphics2D g, double len) {
		if (len < 10) {
			return;
		}
		
		g.drawLine(0, 0, 0, (int)-len);
		g.translate(0, -len);
		
		g.rotate(Math.toRadians(slider.getValue()));
		branch(g, len * 0.67);
	
		g.rotate(Math.toRadians(-slider.getValue() * 2));
		branch(g, len * 0.67);
		
		g.rotate(Math.toRadians(slider.getValue()));
		g.translate(0, len);
		
	}
}