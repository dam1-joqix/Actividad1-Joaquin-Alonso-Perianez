import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class VentanaPrincipal {
	JFrame ventana;
	JPanel panelSuperior;
	JPanel panelRGB;
	JLabel lienzo;
	BufferedImage canvas;

	GridBagConstraints settings;
	Color colorAnterior = Color.WHITE;
	Color[] colores = { Color.BLACK, Color.BLUE, Color.GREEN, Color.GRAY, Color.RED };
	JSlider sliderR;
	JSlider sliderG;
	JSlider sliderB;
	JSlider sliderVertical;
	JSlider sliderHorizontal;
	JSlider sliderAncho;
	JSlider sliderAlto;
	JLabel labelR, labelG, labelB, labelTamanyo;
	int tamanyo;

	public VentanaPrincipal() {
		ventana = new JFrame("Actividad 1");
		ventana.setBounds(100, 50, 600, 950);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void inicializar() {
		ventana.setVisible(true);
		inicializarComponentes();
		inicializarListeners();
		/**
		 * Se llama aquí al metodo pinta para que pinte al empezar
		 * 
		 */
		pinta();

	}

	private void inicializarComponentes() {
		labelR = new JLabel("R");
		labelG = new JLabel("G");
		labelB = new JLabel("B");
		labelTamanyo = new JLabel("Tamaño");
		labelR.setForeground(Color.RED);
		labelG.setForeground(Color.GREEN);
		labelB.setForeground(Color.BLUE);
		ventana.setLayout(new GridBagLayout());//asignamos el layout a la ventana
		panelSuperior = new JPanel();//creamos el panel superior
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;
		settings.fill = GridBagConstraints.BOTH;
		settings.weighty = 1;
		settings.weightx = 1;
		ventana.add(panelSuperior, settings);//añade el panel superior a la ventana

		panelRGB = new JPanel();
		panelRGB.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createDashedBorder(null, 10, 5), "Controles"));
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 1;
		settings.fill = GridBagConstraints.BOTH;
		settings.ipady = 50;
		settings.weightx = 1;
		ventana.add(panelRGB, settings);//añade el panel inferior a la ventana

		lienzo = new JLabel();
		lienzo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lienzo.setHorizontalAlignment(SwingConstants.CENTER);

		canvas = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
		lienzo.setIcon(new ImageIcon(canvas));
		Graphics graficos = canvas.getGraphics();
		graficos.setColor(Color.WHITE);
		graficos.fillRect(0, 0, 500, 500);
		graficos.dispose();
		lienzo.repaint();

		panelSuperior.setLayout(new GridBagLayout());
		sliderVertical = new JSlider(JSlider.VERTICAL, 0, 500, 250);
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;
		settings.fill = GridBagConstraints.BOTH;
		panelSuperior.add(sliderVertical, settings);//añadimos el slider vertical

		settings = new GridBagConstraints();
		settings.gridx = 1;
		settings.gridy = 0;
		panelSuperior.add(lienzo, settings);//añadimos el lienzo

		Insets insets = new Insets(0, 5, 0, 5);

		sliderHorizontal = new JSlider(JSlider.HORIZONTAL, 0, 500, 250);
		settings = new GridBagConstraints();
		settings.gridx = 1;
		settings.gridy = 1;
		settings.fill = GridBagConstraints.BOTH;
		panelSuperior.add(sliderHorizontal, settings);//añadimos el slider horizontal
		panelRGB.setLayout(new GridBagLayout());
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;
		settings.insets = insets;
		panelRGB.add(labelR, settings);//añadimos el label R
		sliderR = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 1;
		settings.insets = new Insets(10, 0, 0, 0);
		settings.insets = insets;
		panelRGB.add(sliderR, settings);//añadimos el slider R
		sliderR.setOpaque(false);
		sliderR.setPaintTicks(true);
		sliderR.setPaintLabels(true);
		sliderR.setMinorTickSpacing(20);
		sliderR.setMajorTickSpacing(100);
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 2;
		settings.insets = insets;
		panelRGB.add(labelG, settings);//añadimos el label g
		sliderG = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 3;
		settings.insets = insets;
		panelRGB.add(sliderG, settings);//añadimos el slider g
		sliderG.setOpaque(false);
		sliderG.setPaintTicks(true);
		sliderG.setPaintLabels(true);
		sliderG.setMinorTickSpacing(20);
		sliderG.setMajorTickSpacing(100);
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 4;
		settings.insets = insets;
		panelRGB.add(labelB, settings);//añadimos el label b
		sliderB = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 5;
		settings.insets = insets;
		panelRGB.add(sliderB, settings);//añadimos el slider b
		sliderB.setOpaque(false);
		sliderB.setPaintTicks(true);
		sliderB.setPaintLabels(true);
		sliderB.setMinorTickSpacing(20);
		sliderB.setMajorTickSpacing(100);

		sliderVertical.setOpaque(false);
		sliderVertical.setPaintTicks(true);
		sliderVertical.setPaintLabels(true);
		sliderVertical.setMinorTickSpacing(20);
		sliderVertical.setMajorTickSpacing(100);
		sliderHorizontal.setOpaque(false);
		sliderHorizontal.setPaintTicks(true);
		sliderHorizontal.setPaintLabels(true);
		sliderHorizontal.setMinorTickSpacing(20);
		sliderHorizontal.setMajorTickSpacing(100);
		sliderAncho = new JSlider(JSlider.HORIZONTAL, 0, 500, 250);
		sliderAncho.setOpaque(false);
		sliderAncho.setPaintTicks(true);
		sliderAncho.setPaintLabels(true);
		sliderAncho.setMinorTickSpacing(20);
		sliderAncho.setMajorTickSpacing(100);
		settings = new GridBagConstraints();
		settings.gridx = 1;
		settings.gridy = 0;
		settings.insets = insets;
		panelRGB.add(labelTamanyo, settings);//añadimos el label tamaño
		settings = new GridBagConstraints();
		settings.gridx = 1;
		settings.gridy = 1;
		settings.insets = insets;
		panelRGB.add(new JLabel("Ancho"), settings);//añadimos el label ancho
		settings = new GridBagConstraints();
		settings.gridx = 1;
		settings.gridy = 2;
		settings.insets = insets;
		panelRGB.add(sliderAncho, settings);//añadimos slider ancho
		sliderAlto = new JSlider(JSlider.HORIZONTAL, 0, 500, 250);
		sliderAlto.setOpaque(false);
		sliderAlto.setPaintTicks(true);
		sliderAlto.setPaintLabels(true);
		sliderAlto.setMinorTickSpacing(20);
		sliderAlto.setMajorTickSpacing(100);
		settings = new GridBagConstraints();
		settings.gridx = 1;
		settings.gridy = 3;
		settings.insets = insets;
		panelRGB.add(new JLabel("Alto"), settings);//añadimos el label alto
		settings = new GridBagConstraints();
		settings.gridx = 1;
		settings.gridy = 4;
		settings.insets = insets;
		panelRGB.add(sliderAlto, settings);//añadimos el slider Alto

	}

	/**
	 * Primero pinta un cuadrado blanco en todo el canvas despues obtiene el color
	 * de los valores de los sliders R G B, el tamaño de los slider ancho y alto y
	 * la posición de los sliders vertical y horizontal y llama al metodo fillRect
	 * con los valores obtenidos
	 */
	private void pinta() {
		repinta();// quedamos el canvas a blanco
		Graphics graficos = canvas.getGraphics();// obtenemos los gráficos
		graficos.setColor(obtenerColor());// obtenemos el color
		int ancho = sliderAncho.getValue();// obtenemos el ancho
		int posx = sliderHorizontal.getValue();// obtenemos la posicion horizontal
		int posy = 0;
		int alto = sliderAlto.getValue();// obtenemos el alto
		if (sliderVertical.getValue() == 250) {
			// si la posicion vertical es 250 se mantiene
			posy = sliderVertical.getValue();
		} else {
			// si no es 250 se invierte (si es 0 será 500 y si es 500 será 0)
			if (sliderVertical.getValue() < 250) {
				posy = 250 + (250 - sliderVertical.getValue());
			} else {
				posy = 250 - (sliderVertical.getValue() - 250);
			}

		}
		/**
		 * pintamos el "Rect" con los valores obtenidos para que las posiciones sean con
		 * respecto del centro a la posicion se le resta el ancho partido de 2 en el
		 * caso de la posición horizontal y el alto partido de dos en el caso de la
		 * posición vertical el ancho y el alto seran los valores obtenidos en sus
		 * correspondientes sliders
		 **/
		graficos.fillRect(posx - ancho / 2, posy - alto / 2, ancho, alto);
		graficos.dispose();

	}

	/**
	 * Este metodo crea un BufferedImage en el canvas se le asigna al lienzo y pinta
	 * en el un cuadrado blanco
	 */
	private void repinta() {
		canvas = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
		lienzo.setIcon(new ImageIcon(canvas));
		Graphics graficos = canvas.getGraphics();
		graficos.setColor(Color.WHITE);
		graficos.fillRect(0, 0, 500, 500);
		graficos.dispose();

	}

	/**
	 * A todos los sliders se le añade un ChangeListener para que llamen al metodo
	 * pìnta al cambiar sus valores
	 */
	private void inicializarListeners() {
		sliderR.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				pinta();

			}
		});
		sliderG.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				pinta();

			}
		});
		sliderB.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				pinta();

			}
		});
		sliderHorizontal.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				pinta();

			}
		});
		sliderAncho.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				pinta();

			}
		});
		sliderVertical.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				pinta();

			}
		});
		sliderAlto.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				pinta();

			}
		});
	}

	/**
	 * Este metodo genera un color rgb con los valores de los sliders para cada
	 * color
	 * 
	 * @return color generado
	 */
	private Color obtenerColor() {
		Color generado;
		generado = new Color(sliderR.getValue(), sliderG.getValue(), sliderB.getValue());
		return generado;
	}

}
