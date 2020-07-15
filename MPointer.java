import java.awt.*;
import java.awt.event.*;

import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class MPointer extends Frame {
	static int Ptx;
	static int Pty;
	static float Jiga;
	static float M = 7000000;
	int size = 2;
	float ratio;
	Color color1 = Color.RED;
	Color color2 = Color.BLUE;
	Color newColor;

	public MPointer(String title) { 
		super(title);
		setBounds(0, 0, 450, 400);
		setVisible(true);
		this.addWindowListener(new WindowAdapter() { 
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	@Override
	public void update(Graphics g) { 
		paint(g);
	}

	public void paint(Graphics g) {

		System.out.println("[±×·ÁÁúÁÂÇ¥] xÁÂÇ¥ :" + Ptx + " " + "yÁÂÇ¥ : " + Pty);

		float pJiga = Jiga;
		if (pJiga >= M) {
			pJiga = M;
		}

		System.out.println("Jiga : " + Jiga + " pJiga : " + pJiga + " "
				+ "M : " + M);

		ratio = pJiga / M;

		int redcomponent = (int) (color1.getRed() * ratio);
		int bluecomponent = (int) (color2.getBlue() * (1 - ratio));

		System.out.println("Ratio : " + ratio + "  Blue : " + bluecomponent
				+ " " + "Red : " + redcomponent);

		newColor = new Color(redcomponent, 0, bluecomponent);

		g.setColor(newColor);
		g.fillOval(Ptx, Pty, size, size);

	}

	public static void main(String[] args) throws Exception {
		MPointer f = new MPointer("°ø½ÃÁö°¡ Á¡¹¦µµ");

		try {
			ExcelReadSample sample = new ExcelReadSample();
			List<Map<String, Object>> res = new ArrayList<Map<String, Object>>();

			for (int i = 1; i <= 25; i++) {
				res = sample.excelRead(new File("D:\\" + i + ".xls"));

				for (Map<String, Object> map : res) {

					for (Map.Entry<String, Object> entry : map.entrySet()) {
						String key = entry.getKey();
						Object value = entry.getValue();
						map.put(key, value);
						Ptx = Integer.parseInt(map.get("X").toString());
						Pty = Integer.parseInt(map.get("Y").toString());
						Jiga = Float.parseFloat(map.get("Jiga").toString());
					}
					f.repaint();
					try {
						Thread.sleep(1);
					} catch (Exception e) {
					}
				}
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
