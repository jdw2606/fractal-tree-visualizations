import java.awt.*;
import javax.swing.*;

public class Canvas extends JFrame {
	
	MyCanvas canvas;
	JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 360, 1);

	
	Canvas() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(slider, BorderLayout.SOUTH);
		canvas = new MyCanvas(slider);
		this.add(canvas, BorderLayout.CENTER);
		
		slider.addChangeListener(e -> canvas.repaint());

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
