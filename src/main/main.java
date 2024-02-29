package main;

import javax.swing.JFrame;

public class main {

	public static void main(String[] args) {
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//to close the window ki nenzlo "X"
        window.setResizable(false);//fix the window size
        window.setTitle("sara's adventure World");
        
        GamePannel gamePannel=new GamePannel();
        window.add(gamePannel);
        window.pack();//the window will be sized to fit l gamePannel li 3malneh
        
        
        window.setLocationRelativeTo(null);//bch l window tji f center par defaut
        window.setVisible(true);//so we can see it
        
        gamePannel.startGameThread();
        
	}

}
