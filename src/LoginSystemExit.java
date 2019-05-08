package senior;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginSystemExit extends WindowAdapter {

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);
	}
}
