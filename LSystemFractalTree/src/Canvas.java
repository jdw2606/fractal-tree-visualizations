import java.awt.*;
import javax.swing.*;

public class Canvas extends JFrame {
	
	MyCanvas canvas;
	JButton button;

	
	Canvas() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button = new JButton("Next State");
		canvas = new MyCanvas(button);
		this.add(button, BorderLayout.SOUTH);
		this.add(canvas, BorderLayout.CENTER);
		
		//button.addChangeListener(e -> canvas.repaint());

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
