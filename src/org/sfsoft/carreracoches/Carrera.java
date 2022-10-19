package src.org.sfsoft.carreracoches;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Scanner;

/**
 * Clase principal donde se muestra el transcurso de la carrera
 * mediante barras de progreso y PropertyChangeListeners
 * @author Santiago Faci
 * @version curso 2014-2015
*/
public class Carrera {
	private JFrame frmCarrea;

	private JProgressBar pbCaballo1;
	private JProgressBar pbCaballo2;
	private JProgressBar pbCaballo3;
	private JProgressBar pbCaballo4;
	private JProgressBar pbCaballo5;
	private JProgressBar pbCaballo6;
	private JProgressBar pbCaballo7;
	private JProgressBar pbCaballo8;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JTextField tfDistancia;
	private JButton btCorrer;
	private JLabel lblDistancia;
	private JLabel lbMarcador;
	private JLabel progresoCaballo1;

	private static int NUM_CABALLOS;
	private static String[] NOMBRE = new String[]{"Genovevo", "Liberto", "Burdeo", "Macario", "Zafiro", "Picasso", "Fervoroso", "Carbonero"};

	private JProgressBar[] pbCaballo = new JProgressBar[]{pbCaballo1, pbCaballo2, pbCaballo3, pbCaballo4, pbCaballo5, pbCaballo6, pbCaballo7, pbCaballo8};
	private JLabel[] lblNewLabel = new JLabel[]{lblNewLabel_1, lblNewLabel_2, lblNewLabel_3, lblNewLabel_4, lblNewLabel_5, lblNewLabel_6, lblNewLabel_7, lblNewLabel_8};

	public static int dameCaballos() {
		Scanner sc = new Scanner(System.in);

		// Entrada de datos numéricos
		// byte, short y float
		try {
			System.out.println("Introduce el numero de caballos:");
			NUM_CABALLOS = sc.nextInt();
			if (NUM_CABALLOS > 8) {
				Exception e;
				System.out.println("No es un valor válido");
			}
		} catch (Exception e) {
			System.out.println("No es un valor válido");
		}
		sc.close();
		return NUM_CABALLOS;
	}

	private void correr(String [] args) {
		int length = dameCaballos();
		int distancia = Integer.parseInt(tfDistancia.getText());

		Caballos[] caballos = new Caballos[length];

		for (int i = 0; i < length; i++) {
			Caballos caballo = new Caballos((int) (Math.random() * 40 + 1), distancia, lbMarcador, NOMBRE[i]);
			caballos[i] = caballo;
		}

		caballos[0].addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent event) {
				if (event.getPropertyName().equals("progress")) {

					pbCaballo[0].setValue((Integer) event.getNewValue());
					progresoCaballo1.setText(
							event.getNewValue() + " %");
				}
				if (event.getPropertyName().equals("ganador")) {
					for (int j = 1; j < length; j++) {

						caballos[j].cancel(true);
					}
				}
			}
		});

		for (int i = 1; i < length; i++) {
			int finalI = i;

			caballos[i].addPropertyChangeListener(new PropertyChangeListener() {
				@Override
				public void propertyChange(PropertyChangeEvent event) {
					if (event.getPropertyName().equals("progress")) {
						pbCaballo[finalI].setValue((Integer) event.getNewValue());
					}
					if (event.getPropertyName().equals("ganador")) {
						for (int j = 0; j < length; j++) {
							if (j != finalI) {
								caballos[j].cancel(true);
							}
						}
					}
				}
			});
		}

		for (int i = 0; i < length; i++) {
			caballos[i].execute();
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Carrera window = new Carrera();
					window.frmCarrea.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Carrera() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCarrea = new JFrame();
		frmCarrea.setTitle("Carrera");
		frmCarrea.setBounds(100, 100, 450, 300);
		frmCarrea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCarrea.getContentPane().setLayout(null);
		frmCarrea.getContentPane().add(getPbCaballo1());
		frmCarrea.getContentPane().add(getPbCaballo2());
		frmCarrea.getContentPane().add(getPbCaballo3());
		frmCarrea.getContentPane().add(getPbCaballo4());
		frmCarrea.getContentPane().add(getPbCaballo5());
		frmCarrea.getContentPane().add(getPbCaballo6());
		frmCarrea.getContentPane().add(getPbCaballo7());
		frmCarrea.getContentPane().add(getPbCaballo8());
		frmCarrea.getContentPane().add(getLblNewLabel_1());
		frmCarrea.getContentPane().add(getLblNewLabel_2());
		frmCarrea.getContentPane().add(getLblNewLabel_3());
		frmCarrea.getContentPane().add(getLblNewLabel_4());
		frmCarrea.getContentPane().add(getLblNewLabel_5());
		frmCarrea.getContentPane().add(getLblNewLabel_6());
		frmCarrea.getContentPane().add(getLblNewLabel_7());
		frmCarrea.getContentPane().add(getLblNewLabel_8());
		frmCarrea.getContentPane().add(getTfDistancia());
		frmCarrea.getContentPane().add(getBtCorrer());
		frmCarrea.getContentPane().add(getLblDistancia());
		frmCarrea.getContentPane().add(getLbMarcador());
		frmCarrea.getContentPane().add(getProgresoCaballo1());
	}


	public JProgressBar getPbCaballo1() {
		if (pbCaballo1 == null) {
			pbCaballo1 = new JProgressBar();
			pbCaballo1.setBounds(10, 65, 422, 19);
		}
		return pbCaballo1;
	}

	public JProgressBar getPbCaballo2() {
		if (pbCaballo2 == null) {
			pbCaballo2 = new JProgressBar();
			pbCaballo2.setBounds(10, 137, 422, 19);
		}
		return pbCaballo2;
	}

	public JProgressBar getPbCaballo3() {
		if (pbCaballo3 == null) {
			pbCaballo3 = new JProgressBar();
			pbCaballo3.setBounds(10, 209, 422, 19);
		}
		return pbCaballo3;
	}

	public JProgressBar getPbCaballo4() {
		if (pbCaballo4 == null) {
			pbCaballo4 = new JProgressBar();
			pbCaballo4.setBounds(10, 281, 422, 19);
		}
		return pbCaballo4;
	}

	public JProgressBar getPbCaballo5() {
		if (pbCaballo5 == null) {
			pbCaballo5 = new JProgressBar();
			pbCaballo5.setBounds(10, 353, 422, 19);
		}
		return pbCaballo5;
	}

	public JProgressBar getPbCaballo6() {
		if (pbCaballo6 == null) {
			pbCaballo6 = new JProgressBar();
			pbCaballo6.setBounds(10, 425, 422, 19);
		}
		return pbCaballo6;
	}

	public JProgressBar getPbCaballo7() {
		if (pbCaballo7 == null) {
			pbCaballo7 = new JProgressBar();
			pbCaballo7.setBounds(10, 497, 422, 19);
		}
		return pbCaballo7;
	}

	public JProgressBar getPbCaballo8() {
		if (pbCaballo8 == null) {
			pbCaballo8 = new JProgressBar();
			pbCaballo8.setBounds(10, 569, 422, 19);
		}
		return pbCaballo8;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Caballo 1");
			lblNewLabel_1.setBounds(10, 43, 46, 14);
		}
		return lblNewLabel_1;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Caballo 2");
			lblNewLabel_2.setBounds(10, 114, 46, 14);
		}
		return lblNewLabel_2;
	}
	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Caballo 3");
			lblNewLabel_3.setBounds(10, 185, 46, 14);
		}
		return lblNewLabel_3;
	}

	public JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("Caballo 4");
			lblNewLabel_4.setBounds(10, 256, 46, 14);
		}
		return lblNewLabel_4;
	}

	public JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("Caballo 5");
			lblNewLabel_5.setBounds(10, 327, 46, 14);
		}
		return lblNewLabel_5;
	}

	public JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("Caballo 3");
			lblNewLabel_6.setBounds(10, 398, 46, 14);
		}
		return lblNewLabel_6;
	}

	public JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("Caballo 3");
			lblNewLabel_7.setBounds(10, 469, 46, 14);
		}
		return lblNewLabel_7;
	}
	public JLabel getLblNewLabel_8() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel("Caballo 3");
			lblNewLabel_8.setBounds(10, 540, 46, 14);
		}
		return lblNewLabel_8;
	}
	public JTextField getTfDistancia() {
		if (tfDistancia == null) {
			tfDistancia = new JTextField();
			tfDistancia.setBounds(247, 12, 86, 20);
			tfDistancia.setColumns(10);
		}
		return tfDistancia;
	}
	public JButton getBtCorrer() {
		if (btCorrer == null) {
			btCorrer = new JButton("Correr");
			btCorrer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					correr();
				}
			});
			btCorrer.setBounds(343, 11, 89, 23);
		}
		return btCorrer;
	}
	public JLabel getLblDistancia() {
		if (lblDistancia == null) {
			lblDistancia = new JLabel("Distancia");
			lblDistancia.setBounds(176, 15, 72, 14);
		}
		return lblDistancia;
	}
	public JLabel getLbMarcador() {
		if (lbMarcador == null) {
			lbMarcador = new JLabel("");
			lbMarcador.setBounds(147, 241, 144, 14);
		}
		return lbMarcador;
	}
	public JLabel getProgresoCaballo1() {
		if (progresoCaballo1 == null) {
			progresoCaballo1 = new JLabel("");
			progresoCaballo1.setBounds(65, 40, 46, 14);
		}
		return progresoCaballo1;
	}


}
