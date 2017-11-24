import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class VentanaPrincipal {
	JFrame ventana;
	JPanel panelSuperior;
	JPanel panelInferior;
	JLabel lienzo;
	BufferedImage canvas;
	
	GridBagConstraints settings;
	Color colorAnterior=Color.WHITE;
	Color[]colores= {Color.BLACK,Color.BLUE,Color.GREEN,Color.GRAY,Color.RED};
	JSlider slider;
	int tamanyo;
	
	public VentanaPrincipal() {
		ventana=new JFrame("Slider");
		ventana.setBounds(100, 50, 400, 500);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void inicializar() {
		ventana.setVisible(true);
		inicializarComponentes();
		inicializarListeners();
		
	}
	private void inicializarComponentes() {
		ventana.setLayout(new GridBagLayout());
		panelSuperior=new JPanel();
		settings=new GridBagConstraints();
		settings.gridx=0;
		settings.gridy=0;
		settings.fill=GridBagConstraints.BOTH;
		settings.weighty=1;
		settings.weightx=1;
		ventana.add(panelSuperior,settings);
		
		panelInferior=new JPanel();
		panelInferior.setBorder(BorderFactory.createTitledBorder(BorderFactory.createDashedBorder(null, 10, 5), "Controles"));
		settings=new GridBagConstraints();
		settings.gridx=0;
		settings.gridy=1;
		settings.fill=GridBagConstraints.BOTH;
		settings.ipady=50;
		settings.weightx=1;		
		ventana.add(panelInferior, settings);
		
		
		lienzo = new JLabel();
		lienzo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lienzo.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		canvas = new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB);
		lienzo.setIcon(new ImageIcon(canvas));
		Graphics graficos = canvas.getGraphics();
		graficos.setColor(Color.WHITE);
		graficos.fillRect(0, 0, 400, 400);
		graficos.dispose();
		lienzo.repaint();
		
		panelSuperior.setLayout(new GridBagLayout());
		settings=new GridBagConstraints();
		settings.gridx=0;
		settings.gridy=0;
		panelSuperior.add(lienzo,settings);
		
		
		slider=new JSlider(JSlider.HORIZONTAL, 0, 300, 150);
		settings=new GridBagConstraints();
		settings.gridx=0;
		settings.gridy=1;
		settings.insets=new Insets(10, 0, 0, 0);
		panelInferior.add(slider,settings);
		slider.setOpaque(false);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMinorTickSpacing(20);
		slider.setMajorTickSpacing(100);
		pinta();

	
		
	}
	private void pinta() {
		canvas = new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB);
		lienzo.setIcon(new ImageIcon(canvas));
		Graphics graficos = canvas.getGraphics();
		graficos.setColor(Color.WHITE);
		graficos.fillRect(0, 0, 400, 400);
		graficos.dispose();
		Color color=obtenerColor();
		graficos=canvas.getGraphics();
		graficos.setColor(color);
		//graficos.fillRect(x,y,width,heigth)
		int tamanyo=slider.getValue();
		graficos.fillRect(canvas.getWidth()/2-tamanyo/2, canvas.getHeight()/2-tamanyo/2,tamanyo, tamanyo);
		graficos.dispose();
		
	}
	private void inicializarListeners() {
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				pinta();
				
			}
		});
		
	}
	protected Color obtenerColor() {
		Color generado;
		Random rd=new Random();
		generado=colores[rd.nextInt(colores.length)];
		while(generado==colorAnterior) {
			generado=colores[rd.nextInt(colores.length)];
		}
		colorAnterior=generado;
		return generado;
	}

}
