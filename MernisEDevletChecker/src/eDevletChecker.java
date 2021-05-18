import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;

public class eDevletChecker {

	private JFrame frame;
	private JTextField txtAd;
	private JTextField txtSoyad;
	private JTextField txtTc;
	private JTextField TxtDogumYili;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					eDevletChecker window = new eDevletChecker();
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
	public eDevletChecker() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("E-Devlet Doðrulama Sistemi");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\forle\\Downloads\\1_d6T_icon.ico"));
		frame.setBounds(300, 300, 600, 350);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
	
		frame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\forle\\eclipse-workspace\\MernisEDevletChecker\\img\\6.png")));
		
		
		JLabel L1;
		L1 = new JLabel();
		
		
		JLabel lblAd = new JLabel("Ad:");
		lblAd.setForeground(Color.YELLOW);
		lblAd.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
		lblAd.setBounds(215, 100, 97, 14);
		frame.getContentPane().add(lblAd);
		
		JLabel lblSoyad = new JLabel("Soyad :");
		lblSoyad.setForeground(Color.YELLOW);
		lblSoyad.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
		lblSoyad.setBounds(215, 125, 97, 14);
		frame.getContentPane().add(lblSoyad);
		
		JLabel lblTcNo = new JLabel("TC. No :");
		lblTcNo.setForeground(Color.YELLOW);
		lblTcNo.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
		lblTcNo.setBounds(215, 152, 97, 17);
		frame.getContentPane().add(lblTcNo);
		
		JLabel lblDogumyili = new JLabel("Do\u011Fum Y\u0131l\u0131 :");
		lblDogumyili.setForeground(Color.YELLOW);
		lblDogumyili.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
		lblDogumyili.setBounds(215, 180, 97, 14);
		frame.getContentPane().add(lblDogumyili);
		
		JLabel lblNewLabel_4 = new JLabel("E-Devlet Do\u011Frulama Sistemi");
		lblNewLabel_4.setForeground(Color.YELLOW);
		lblNewLabel_4.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
		lblNewLabel_4.setBounds(120, 16, 234, 18);
		frame.getContentPane().add(lblNewLabel_4);
		
		txtAd = new JTextField();
		txtAd.setBounds(240, 98, 115, 20);
		frame.getContentPane().add(txtAd);
		txtAd.setColumns(10);
		
		txtSoyad = new JTextField();
		txtSoyad.setBounds(265, 125, 115, 20);
		frame.getContentPane().add(txtSoyad);
		txtSoyad.setColumns(10);
		
		txtTc = new JTextField();
		txtTc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char chr = e.getKeyChar();
				
				if (!Character.isDigit(chr)) {
					e.consume();
				}
				
				if (txtTc.getText().length() > 10) {
					e.consume();
				}
				
			}
		});
		txtTc.setBounds(270, 153, 110, 20);
		frame.getContentPane().add(txtTc);
		txtTc.setColumns(10);
		
		TxtDogumYili = new JTextField();
		TxtDogumYili.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char chr = e.getKeyChar();
				
				if (!Character.isDigit(chr)) {
					e.consume();
				}
				
				if (TxtDogumYili.getText().length() > 3) {
					e.consume();
				}
			}
		});
		TxtDogumYili.setBounds(300, 180, 60, 20);
		frame.getContentPane().add(TxtDogumYili);
		TxtDogumYili.setColumns(10);
		
		JButton btnDogrula = new JButton("Doðrula");
		btnDogrula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtAd.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Ad bölümü boþ olamaz! \nLütfen Tüm Alanlarý Doldurun!", "Eksik Bilgi!", 
							JOptionPane.ERROR_MESSAGE);	
				}
				
				else if (txtSoyad.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Soyad bölümü boþ olamaz! \nLütfen Tüm Alanlarý Doldurun!", "Eksik Bilgi!", 
							JOptionPane.ERROR_MESSAGE);	
				}
				
				else if (txtTc.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Tc bölümü boþ olamaz! \nLütfen Tüm Alanlarý Doldurun!", "Eksik Bilgi!", 
							JOptionPane.ERROR_MESSAGE);	
				}
				
				else if (TxtDogumYili.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Doðum yýlý bölümü boþ olamaz! \nLütfen Tüm Alanlarý Doldurun!", "Eksik Bilgi!", 
							JOptionPane.ERROR_MESSAGE);	
				}
				
				
				else {
					KPSPublicSoapProxy client = new KPSPublicSoapProxy();
					
					boolean result = true;
					
					try {
						result = client.TCKimlikNoDogrula(Long.parseLong(txtTc.getText()), txtAd.getText().toUpperCase(new Locale("tr")),
								txtSoyad.getText().toUpperCase(new Locale("tr")), Integer.parseInt(TxtDogumYili.getText().trim()));	
					} 
					
					catch (RemoteException exception) {
						exception.printStackTrace();
					}
					
					
					if (result == true) {
						JOptionPane.showMessageDialog(null, "Doðrulama Baþarýlý!", "Baþarýlý!", JOptionPane.INFORMATION_MESSAGE);
						txtAd.setText(null);
						txtSoyad.setText(null);
						txtTc.setText(null);
						TxtDogumYili.setText(null);
						
					}
					
					else {
						JOptionPane.showMessageDialog(null, "Doðrulama BAÞARISIZ! \nLütfen Bilgilerinizi Kontrol Ediniz!", "Doðrulama Hatasý!",
								JOptionPane.ERROR_MESSAGE);
					}
					
				}
	
			}
		});
		
		btnDogrula.setBounds(38, 280, 89, 23);
		frame.getContentPane().add(btnDogrula);
		
		frame.getRootPane().setDefaultButton(btnDogrula);
		
		JButton btnCikis = new JButton("\u00C7\u0131k\u0131\u015F");
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (JOptionPane.showConfirmDialog(new JFrame("Çýkýþ"), "Programdan çýkýþ yapmak istiyor musunuz ?", "E-Devlet Doðrulama Sistemi",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
				
			}
		});
		btnCikis.setBounds(366, 280, 89, 23);
		frame.getContentPane().add(btnCikis);
		
		JButton btnSifirla = new JButton("S\u0131f\u0131rla");
		btnSifirla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAd.setText(null);
				txtSoyad.setText(null);
				txtTc.setText(null);
				TxtDogumYili.setText(null);
				
			}
		});
		btnSifirla.setBounds(172, 280, 89, 23);
		frame.getContentPane().add(btnSifirla);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(28, 270, 427, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(28, 40, 427, 2);
		frame.getContentPane().add(separator_1);
	}
}
