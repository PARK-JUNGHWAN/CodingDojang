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
	Image img;//Image Ŭ������ �̹����� ����Ѵ�.
	MyImage(String path){//�����ڸ� ���� �̹����� ��θ� �޴´�.
		img = Toolkit.getDefaultToolkit().getImage(path);
	}
	//paint()�޼��带 �ٲ۴�.(�������̵��Ѵ�)
	@Override
	public void paint(Graphics arg0) {
		//���� ������ �ִ� �̹����� �ҷ��ͼ� ���
		arg0.drawImage(img, 0, 0, 
				img.getWidth(this),img.getHeight(this),this);
	}//�̹����� ����� �г�
	
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
		new ImageWindow("�̹��� ������");
	}

}








