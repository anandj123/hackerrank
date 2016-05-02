import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NavierStokes {

	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				new NavierStokes().displayGUI();
				
			}
		};
		EventQueue.invokeLater(runnable);
	}

	protected void displayGUI() {
		JFrame frame = new JFrame("Navier Stokes experiment");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(new chamber(), BorderLayout.CENTER);
		
		frame.setContentPane(panel);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
		
		
	}
}

@SuppressWarnings("serial")
class chamber extends JPanel {
	private static final int SIZE = 400;
	
	private static int N; // number of particles in the chamber for Navier stokes
	
	public chamber() {
		N = 50;
	}
	
	@Override
    public Dimension getPreferredSize () {
        return new Dimension ( SIZE, SIZE );
    }
	
	@Override
    protected void paintComponent ( Graphics g ) {
		super.paintComponent ( g );
		
		int size_of_box = SIZE/(N);
		
		for (int j=0;j<N;j++){
			for (int i=0;i<N;i++){
//				g.setColor(Color.WHITE);
//				g.drawRect(i*size_of_box, j*size_of_box, size_of_box, size_of_box);
				g.setColor(Color.RED);
				g.fillOval(i*size_of_box + (size_of_box/4), j*size_of_box + (size_of_box/4), size_of_box/2, size_of_box/2);
			}
		}
//        g.drawRect ( 50, RADIUS, X, Y );
//        g.drawRect ( 100, RADIUS, X, Y );
//        g.drawRect ( 150, RADIUS, X, Y );
//        g.drawRect ( 200, RADIUS, X, Y );
//        g.drawRect ( 250, RADIUS, X, Y );
//
//        g.setColor ( Color.RED );
//        g.fillOval ( moveXBy, RADIUS, X, Y ) ;
    }
	
	
}
