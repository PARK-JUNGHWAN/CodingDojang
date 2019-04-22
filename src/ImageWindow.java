package senior;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


class MyImage extends Panel{
	Image img;//Image 클래스가 이미지를 담당한다.
	MyImage(String path){//생성자를 통해 이미지의 경로를 받는다.
		img = Toolkit.getDefaultToolkit().getImage(path);
	}
	//paint()메서드를 바꾼다.(오버라이드한다)
	@Override
	public void paint(Graphics arg0) {
		//내가 가지고 있는 이미지를 불러와서 출력
		arg0.drawImage(img, 0, 0, 
				img.getWidth(this),img.getHeight(this),this);
	}//이미지를 출력할 패널
	
}

public class ImageWindow extends Frame 
	implements WindowListener{
	public ImageWindow(String str) {
		super(str);
		this.setLayout(new GridLayout(1,2));
		this.add(new MyImage("src\\senior\\five.png"));
		this.add(new MyImage("src\\senior\\dice5.png"));
		this.setSize(400, 400);
		this.addWindowListener(this);;
		this.setVisible(true);
	}
	public void windowActivated(WindowEvent arg0) {	}
	public void windowClosed(WindowEvent arg0) {	}
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);
	}
	public void windowDeactivated(WindowEvent arg0) {	}
	public void windowDeiconified(WindowEvent arg0) {	}
	public void windowIconified(WindowEvent arg0) {	}
	public void windowOpened(WindowEvent e) {	}

	public static void main(String[] args) {
		new ImageWindow("이미지 윈도우");
	}

}








