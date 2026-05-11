import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class MyCanvas extends JPanel{
	int x = 800;
	int y = 800;
	int len = 100;
	int deg = 30;
	
	Character axiam = 'F';
	String start = "F";
	String rule = "F-[F+]+F[F-F+F]+F-[F-F]";
	String LSystem = start;

	JButton button;

	public MyCanvas(JButton button) {
		this.setPreferredSize(new Dimension(x, y));
		this.button = button;
		button.addActionListener(e -> {
			LSystem = nextLSystem(LSystem);
			repaint();
		});

	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2D = (Graphics2D) g;
		g2D.setStroke(new BasicStroke(3));
		g2D.setColor(Color.BLACK);
		
		g.translate(x/2, y);
		branch(g2D, len, LSystem);
		len *= 0.6;
	}
	
	public String nextLSystem(String str) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < str.length(); i ++) {
			if (str.charAt(i) == axiam) {
				result.append(rule);
			} else {
				result.append(str.charAt(i));
			}
		}
		System.out.println(result);
		return result.toString();
	}
	
	public void branch(Graphics2D g, double len, String LSystem) {
		Stack<AffineTransform> stack = new Stack<>();
		if (len < 1) {
			return;
		}
		for (int i = 0; i < LSystem.length(); i ++) {
			Character current = LSystem.charAt(i);
			double degDisp = 0;
			
			if (current == 'F') {
				g.drawLine(0, 0, 0, (int)-len);
				g.translate(0, -len);
			} else if (current == '+') {
				g.rotate(Math.toRadians(deg));
				degDisp += deg;
			} else if (current == '-') {
				g.rotate(Math.toRadians(-deg));
				degDisp -= deg;
			} else if (current == '[') {
				stack.push(g.getTransform());
				
			} else if (current == ']') {
				if (!stack.isEmpty()) {
					g.setTransform(stack.pop());
				}
			}
		}
	}
}