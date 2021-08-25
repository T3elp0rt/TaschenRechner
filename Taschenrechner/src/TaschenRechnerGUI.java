import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import java.awt.Canvas;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.Component;
import javax.swing.Box;
import java.awt.List;
import java.awt.Label;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

public class TaschenRechnerGUI {

	private JFrame frame;
	private JTextField tfAnzeige;
	private JTextArea tfVerlauf;
	private boolean neueZahl;
	private boolean komma;
	private Recheneinheit recheneinheit = new Recheneinheit();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaschenRechnerGUI window = new TaschenRechnerGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TaschenRechnerGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 390, 416);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton bZero = new JButton("0");
		bZero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bZahl_ActionPerformed(e, 0);
			}
		});
		bZero.setBounds(10, 323, 48, 48);
		frame.getContentPane().add(bZero);

		JButton bKomma = new JButton(",");
		bKomma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bKomma_ActionPerformed(e);
			}
		});
		bKomma.setBounds(68, 323, 48, 48);
		frame.getContentPane().add(bKomma);

		JButton bPlusMinus = new JButton("+/-");
		bPlusMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bVorzeichenWechsel_ActionPerformed(e);
			}
		});
		bPlusMinus.setBounds(126, 323, 48, 48);
		frame.getContentPane().add(bPlusMinus);

		JButton bEquals = new JButton("=");
		bEquals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bGleich_ActionPerformed(arg0);
			}
		});
		bEquals.setBounds(184, 323, 48, 48);
		frame.getContentPane().add(bEquals);

		JButton bSeven = new JButton("7");
		bSeven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bZahl_ActionPerformed(e, 7);
			}
		});
		bSeven.setBounds(10, 264, 48, 48);
		frame.getContentPane().add(bSeven);

		JButton bEight = new JButton("8");
		bEight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bZahl_ActionPerformed(e, 8);
			}
		});
		bEight.setBounds(68, 264, 48, 48);
		frame.getContentPane().add(bEight);

		JButton bNine = new JButton("9");
		bNine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bZahl_ActionPerformed(e, 9);
			}
		});
		bNine.setBounds(126, 264, 48, 48);
		frame.getContentPane().add(bNine);

		JButton bDivision = new JButton("/");
		bDivision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bDiv_ActionPerformed(e);
			}
		});
		bDivision.setBounds(184, 264, 48, 48);
		frame.getContentPane().add(bDivision);

		JButton bFour = new JButton("4");
		bFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bZahl_ActionPerformed(e, 4);
			}
		});
		bFour.setBounds(10, 205, 48, 48);
		frame.getContentPane().add(bFour);

		JButton bFive = new JButton("5");
		bFive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bZahl_ActionPerformed(e, 5);
			}
		});
		bFive.setBounds(68, 205, 48, 48);
		frame.getContentPane().add(bFive);

		JButton bSix = new JButton("6");
		bSix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bZahl_ActionPerformed(e, 6);
			}
		});
		bSix.setBounds(126, 205, 48, 48);
		frame.getContentPane().add(bSix);

		JButton bMultiply = new JButton("*");
		bMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bMultiply_ActionPerformed(e);
			}
		});
		bMultiply.setBounds(184, 205, 48, 48);
		frame.getContentPane().add(bMultiply);

		JButton bOne = new JButton("1");
		bOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bZahl_ActionPerformed(e, 1);
			}
		});
		bOne.setBounds(10, 146, 48, 48);
		frame.getContentPane().add(bOne);

		JButton bTwo = new JButton("2");
		bTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bZahl_ActionPerformed(e, 2);
			}
		});
		bTwo.setBounds(68, 146, 48, 48);
		frame.getContentPane().add(bTwo);

		JButton bThree = new JButton("3");
		bThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bZahl_ActionPerformed(e, 3);
			}
		});
		bThree.setBounds(126, 146, 48, 48);
		frame.getContentPane().add(bThree);

		JButton bMinus = new JButton("-");
		bMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bMinus_ActionPerformed(e);
			}
		});
		bMinus.setBounds(184, 146, 48, 48);
		frame.getContentPane().add(bMinus);

		JButton bClear = new JButton("AC");
		bClear.setFont(new Font("Tahoma", Font.PLAIN, 10));
		bClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bAC_ActionPerformed(e);
			}
		});
		bClear.setBounds(10, 87, 48, 48);
		frame.getContentPane().add(bClear);

		JButton bSquareRoot = new JButton("Sqrt");
		bSquareRoot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bSQRT_ActionPerformed(e);
			}
		});
		bSquareRoot.setFont(new Font("Tahoma", Font.PLAIN, 8));
		bSquareRoot.setBounds(68, 87, 48, 48);
		frame.getContentPane().add(bSquareRoot);

		JButton bPercent = new JButton("%");
		bPercent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bProzent_ActionPerformed(e);
			}
		});
		bPercent.setBounds(126, 87, 48, 48);
		frame.getContentPane().add(bPercent);

		JButton bPlus = new JButton("+");
		bPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bPlus_ActionPerformed(e);
			}
		});
		bPlus.setBounds(184, 87, 48, 48);
		frame.getContentPane().add(bPlus);

		tfAnzeige = new JTextField();
		tfAnzeige.setBounds(10, 11, 227, 65);
		frame.getContentPane().add(tfAnzeige);
		tfAnzeige.setColumns(10);

		JFormattedTextField frmtdtxtfldVerlauf = new JFormattedTextField();
		frmtdtxtfldVerlauf.setEditable(false);
		frmtdtxtfldVerlauf.setText("Verlauf:");
		frmtdtxtfldVerlauf.setBounds(247, 11, 123, 20);
		frame.getContentPane().add(frmtdtxtfldVerlauf);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\SandroM\\Downloads\\Download.jpg"));
		lblNewLabel.setBounds(494, 343, 270, 178);
		frame.getContentPane().add(lblNewLabel);

		tfVerlauf = new JTextArea();
		tfVerlauf.setEditable(false);
		tfVerlauf.setBounds(247, 54, 117, 317);
		frame.getContentPane().add(tfVerlauf);
	}

	public double gibAnzeigeAlsZahl() {

		return Double.parseDouble(tfAnzeige.getText());

	}

	public void bZahl_ActionPerformed(ActionEvent evt, int Zahl) {

		String anzeigeText = tfAnzeige.getText();

		if (anzeigeText.equals("0") || anzeigeText.equals("0.0") || neueZahl) {

			tfAnzeige.setText("" + Zahl);

			neueZahl = false;

			tfVerlauf.append("" + Zahl);

		} else {

			tfAnzeige.setText(anzeigeText + Zahl);
			tfVerlauf.append("" + Zahl);

		}

	}

	public void bKomma_ActionPerformed(ActionEvent evt) {

		String anzeigeText = tfAnzeige.getText();

		if (neueZahl) {

			tfAnzeige.setText("0.");

			neueZahl = false;

			komma = true;

		} else if (!komma) {

			tfAnzeige.setText(anzeigeText + ".");

			komma = true;

		}

	}

	public void bPlus_ActionPerformed(ActionEvent evt) {

		String anzeigeText = tfAnzeige.getText();

		double zahl = gibAnzeigeAlsZahl();

		recheneinheit.verarbeiteGrundrechenoperator(zahl);

		tfAnzeige.setText("" + recheneinheit.gibZahlspeicher());

		recheneinheit.speichereGrundrechenoperator("+");

		tfVerlauf.append(" + ");

		neueZahl = true;

		komma = false;

	}

	public void bMinus_ActionPerformed(ActionEvent evt) {

		double zahl = gibAnzeigeAlsZahl();

		recheneinheit.verarbeiteGrundrechenoperator(zahl);

		tfAnzeige.setText("" + recheneinheit.gibZahlspeicher());

		recheneinheit.speichereGrundrechenoperator("-");

		tfVerlauf.append(" - ");

		neueZahl = true;

		komma = false;

	}

	public void bSQRT_ActionPerformed(ActionEvent evt) {

		double zahl = gibAnzeigeAlsZahl();

		double ergebnis = recheneinheit.liefereQuadratwurzel(zahl);

		tfAnzeige.setText("" + ergebnis);

		neueZahl = true;

		tfVerlauf.append(" SQRT = " + ergebnis + " \n");

		komma = false;

	}

	public void bAC_ActionPerformed(ActionEvent evt) {

		recheneinheit.zuruecksetzen();

		tfAnzeige.setText("0");

	}

	// GLEICH___________________________________________________________________________________________________
	public void bGleich_ActionPerformed(ActionEvent evt) {

		double zahl = gibAnzeigeAlsZahl();

		recheneinheit.verarbeiteGrundrechenoperator(zahl);

		tfAnzeige.setText("" + recheneinheit.gibZahlspeicher());

		verlaufsFormatierer();

		recheneinheit.speichereGrundrechenoperator("");

		neueZahl = true;

	}
	// __________________________________________________________________________________________________________

	public void bDiv_ActionPerformed(ActionEvent e) {

		double zahl = gibAnzeigeAlsZahl();

		recheneinheit.verarbeiteGrundrechenoperator(zahl);

		tfAnzeige.setText("" + recheneinheit.gibZahlspeicher());

		recheneinheit.speichereGrundrechenoperator("/");

		tfVerlauf.append(" / ");

		neueZahl = true;

		komma = false;
	}

	public void bMultiply_ActionPerformed(ActionEvent e) {

		double zahl = gibAnzeigeAlsZahl();

		recheneinheit.verarbeiteGrundrechenoperator(zahl);

		tfAnzeige.setText("" + recheneinheit.gibZahlspeicher());

		recheneinheit.speichereGrundrechenoperator("*");

		tfVerlauf.append(" * ");

		neueZahl = true;

		komma = false;
	}

	public void bVorzeichenWechsel_ActionPerformed(ActionEvent e) {

		double zahl = gibAnzeigeAlsZahl();

		double ergebnis = recheneinheit.liefereGegenzahl(zahl);

		tfAnzeige.setText("" + ergebnis);

		neueZahl = true;

		komma = false;
	}

	public void verlaufsFormatierer() {

		tfVerlauf.append(" = " + recheneinheit.gibZahlspeicher() + "\n");

	}

	public void bProzent_ActionPerformed(ActionEvent e) {

		double zahl = gibAnzeigeAlsZahl();

		double ergebnis = recheneinheit.liefereProzentwert(zahl);

		tfAnzeige.setText("" + ergebnis);

		neueZahl = true;

		tfVerlauf.append(" % = " + ergebnis + " \n");

		komma = false;

	}
}
