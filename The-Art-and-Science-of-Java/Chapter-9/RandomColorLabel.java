
import acm.program.*;
import acm.util.RandomGenerator;
import acm.graphics.*;
import java.awt.*;

public class RandomColorLabel extends GraphicsProgram {
	
	public void run() {
		
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		/* Creating a new canvas with the dimensions of the image */
		
		GCanvas gc = new GCanvas();
		gc.setVisible(true);
		
		gc.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		while (true) {
			
			/* Creating the label */
			
			String stringContent="";
			
			/* Calling rgen to set the content of the label */
			
			int roll =  rgen.nextInt(1,7);
			
			switch (roll) {
			case 1: 
				stringContent = "RED";
				break;
			case 2: 
				stringContent = "ORANGE";
				break;
			case 3: 
				stringContent = "YELLOW";
				break;
			case 4:  
				stringContent = "GREEN";
				break;
			case 5:  
				stringContent = "CYAN";
				break;
			case 6: 
				stringContent = "BLUE";
				break;
			case 7:  
				stringContent = "MAGENTA";
				break;
			default: 
				stringContent = "BLACK";
				break;
			}

			GLabel label = new GLabel(stringContent);
			label.setFont("SansSerifs-bold-30");
			/* Coloring the label */
			
			boolean ok = false;
			Color labelColor = Color.BLACK;
			
			while (!ok) {
				
				int colorRoll = rgen.nextInt(1,7);
				
				if (colorRoll!=roll) {
					
					switch (colorRoll) {
					case 1: 
						labelColor = Color.RED;
						break;
					case 2: 
						labelColor = Color.ORANGE;
						break;
					case 3: 
						labelColor = Color.YELLOW;
						break;
					case 4: 
						labelColor = Color.GREEN; 
						break;
					case 5: 
						labelColor = Color.CYAN; 
						break;
					case 6: 
						labelColor = Color.BLUE;
						break;
					case 7: 
						labelColor = Color.MAGENTA; 
						break;
					default: 
						labelColor = Color.BLACK;
						break;
					}

					label.setColor(labelColor);
					
					ok=true;
					
				}
				
			}
						
			GPoint labelLocation = new GPoint(rgen.nextDouble(0,gc.getWidth()-label.getWidth() ),
					rgen.nextDouble(label.getAscent(),  gc.getHeight()-label.getDescent()));
					
			add(label,labelLocation);
			
			pause(PAUSE_TIME);
			
			remove(label);
			
		}
		
		
	}

	
	RandomGenerator rgen = new RandomGenerator();
	
	/* Constants */
	
	private static final int WINDOW_WIDTH = 800;
	private static final int WINDOW_HEIGHT = 450;
	private static final int PAUSE_TIME = 1000;
}
