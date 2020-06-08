package br.com.projeto.estoque.viewUpdate;

import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.IntelliJTheme;
import com.toedter.calendar.JDateChooser;

import br.com.projeto.estoque.controller.ControllerAuxiliar;
import br.com.projeto.estoque.controller.ControllerGlobal;
import br.com.projeto.estoque.controller.ControllerSupervisor;
import br.com.projeto.estoque.util.GerenteAtual;
import br.com.projeto.estoque.view.Janela_entrada;

import java.awt.Color;

public class Janela_principal extends JFrame {

	private static final long serialVersionUID = 1L;

	// CAMPOS DO PAINEL DE DELEÇÃO DO SUPERVISOR
	private JFormattedTextField cpf_gerente_deleteSupervisor;
	private JPasswordField senha_gerente_deleteSupervisor;
	private JFormattedTextField cpf_supervisor_deleteSupervisor;
	private JFormattedTextField id_pesquisa_deleteSupervisor;
	private JFormattedTextField login_supervisor_deleteSupervisor = new JFormattedTextField();

	// CAMPOS DO PAINEL DE CRIAÇÃO/CADASTRO DO SUPERVISOR
	private JFormattedTextField cpf_supervisor_criarSupervisor;
	private JFormattedTextField login_supervisor_criarSupervisor = new JFormattedTextField();
	private JPasswordField confirmacaoSenha_supervisor_criarSupervisor;
	private JPasswordField senha_supervisor_criarSupervisor;

	// CAMPOS DO PAINEL DE ATUALIZAÇÃO DO SUPERVISOR
	private JFormattedTextField cpf_gerente_AtualizacaoSupervisor;
	private JFormattedTextField id_pesquisa_supervisor_AtualizacaoSupervisor;
	private JPasswordField nova_senha_supervisor_AtualizacaoSupervisor;
	private JPasswordField senha_gerente_AtualizacaoSupervisor;
	private JFormattedTextField novo_cpf_supervisor_AtualizacaoSupervisor;
	private JFormattedTextField cpf_atual_supervisor_AtualizacaoSupervisor = new JFormattedTextField();
	private JFormattedTextField login_atual_supervisor_AtualizacaoSupervisor = new JFormattedTextField();
	private JFormattedTextField novo_login_supervisor_AtualizacaoSupervisor = new JFormattedTextField();

	private JPanel contentPane;
	private JTable table_gerentes;
	private JTable table_fornecedores;
	private JTable table_movimentacoes;
	private JTable table_registros;

	private JTextField c_cidade_af;
	private JTextField c_nome_af;
	private JTextField c_razaosocial_af;
	private JTextField c_numero_af;
	private JTextField c_logradouro_af;
	private JTextField c_complemento_af;
	private JFormattedTextField c_cnpj_af;

	private JFormattedTextField formattedTextField_1_2_2;
	private JFormattedTextField c_telefone_af;
	private JFormattedTextField c_cep_af;
	private JFormattedTextField c_bairro_af;
	private JFormattedTextField c_email_af;

	private JComboBox c_estado_af;
	private JTextField c_cidade_cf;
	private JTextField c_nome_cf;
	private JTextField c_razaosocial_cf;
	private JTextField c_numero_cf;
	private JTextField c_logradouro_cf;
	private JTextField c_complemento_cf;
	private JButton bt_limpar_cf;
	private JProgressBar progressBar_tabelas_superior;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JFormattedTextField c_email_cf = new JFormattedTextField();
	private JFormattedTextField c_telefone_af_1 = new JFormattedTextField();
	private JFormattedTextField c_cep_cf = new JFormattedTextField();
	private JFormattedTextField c_cnpj_cf = new JFormattedTextField();
	private JFormattedTextField c_bairro_cf = new JFormattedTextField();
	private JFormattedTextField formattedTextField_1_2_2_1 = new JFormattedTextField();
	private JFormattedTextField c_email_af_1 = new JFormattedTextField();
	private JFormattedTextField c_cnpj_af_1 = new JFormattedTextField();
	private JFormattedTextField formattedTextField_2 = new JFormattedTextField();
	private JFormattedTextField formattedTextField_1_1 = new JFormattedTextField();
	private JFormattedTextField formattedTextField = new JFormattedTextField();
	private JFormattedTextField formattedTextField_1 = new JFormattedTextField();
	private JFormattedTextField formattedTextField_1_2_2_2 = new JFormattedTextField();
	private JButton botao_limpar_dados_deleteSupervisor = new JButton("Limpar");

	ControllerSupervisor ctrlSuper = new ControllerSupervisor();
	ControllerAuxiliar ctrlAux = new ControllerAuxiliar();

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// IntelliJTheme.install(Janela_principal.class.getResourceAsStream("/themas/Dark.json"));
					UIManager.setLookAndFeel(new FlatDarkLaf());
					Janela_principal frame = new Janela_principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("deprecation")
	public Janela_principal() {
		setTitle("MENU");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1216, 603);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu_1 = new JMenu("Registros");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_1);

		JMenu mnNewMenu_2 = new JMenu("Gerentes");
		// mnNewMenu_2.setIcon(new
		// ImageIcon(getClass().getResource("/sage_icons/profile_round [#1342].png")));
		mnNewMenu_1.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem = new JMenuItem("Gerar Relatório");
		mnNewMenu_2.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Visualizar");
		mnNewMenu_2.add(mntmNewMenuItem_1);

		JMenu mnNewMenu_3 = new JMenu("Supervisores");
		// mnNewMenu_3.setIcon( new
		// ImageIcon(getClass().getResource("/sage_icons/profile_image_round
		// [#1326].png")));
		mnNewMenu_1.add(mnNewMenu_3);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Gerar Relatório");
		mnNewMenu_3.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Visualizar");
		mnNewMenu_3.add(mntmNewMenuItem_4);

		JMenu mnNewMenu_4 = new JMenu("Movimentações");
		// mnNewMenu_2.setIcon(new
		// ImageIcon(getClass().getResource("/sage_icons/cart_round [#1166].png")));
		mnNewMenu_1.add(mnNewMenu_4);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Gerar Relatório");
		mnNewMenu_4.add(mntmNewMenuItem_5);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Visualizar");
		mnNewMenu_4.add(mntmNewMenuItem_6);

		JMenu mnNewMenu = new JMenu("Denifições");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnNewMenu);

		JMenu mnNewMenu_5 = new JMenu("Alterar Tema");
		mnNewMenu.add(mnNewMenu_5);

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Dark");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel(new FlatDarkLaf());
				} catch (UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				SwingUtilities.updateComponentTreeUI(new Janela_principal());
				Janela_principal t = new Janela_principal();
				repaint();
				validate();
				t.setVisible(true);
				dispose();

			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_7);

		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Light");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel(new FlatIntelliJLaf());
				} catch (UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				}
				SwingUtilities.updateComponentTreeUI(new Janela_principal());
				Janela_principal t = new Janela_principal();
				repaint();
				validate();
				t.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_8);

		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Dark Purple");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IntelliJTheme.install(Janela_principal.class.getResourceAsStream("/themas/DarkPurple.json"));
				SwingUtilities.updateComponentTreeUI(new Janela_principal());
				Janela_principal t = new Janela_principal();
				repaint();
				validate();
				t.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_9);

		JMenuItem mntmNewMenuItem_10 = new JMenuItem("LightGray");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IntelliJTheme.install(Janela_principal.class.getResourceAsStream("/themas/LightGray.json"));
				SwingUtilities.updateComponentTreeUI(new Janela_principal());
				Janela_principal t = new Janela_principal();
				repaint();
				validate();
				t.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_10);

		JMenuItem btn_sair = new JMenuItem("Sair");

		mnNewMenu.add(btn_sair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_superior = new JPanel();
		panel_superior.setBounds(0, 0, 1210, 553);
		contentPane.add(panel_superior);
		panel_superior.setLayout(null);

		JTabbedPane tabbedPane_area = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_area.setBounds(0, 0, 623, 553);
		panel_superior.add(tabbedPane_area);

		JPanel panel_area_gerente = new JPanel();
		tabbedPane_area.addTab("Área do Supervisor", null, panel_area_gerente, null);
		panel_area_gerente.setLayout(null);

		JTabbedPane tabbedPane_acoes_gerente = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_acoes_gerente.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		tabbedPane_acoes_gerente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tabbedPane_acoes_gerente.setBounds(0, 0, 618, 525);
		panel_area_gerente.add(tabbedPane_acoes_gerente);

		// ADICIONAR CAMPOS DE CADASTRAR gerente NESSE PANEL
		JPanel panel_add_gerente = new JPanel();
		tabbedPane_acoes_gerente.addTab("Cadastrar Supervisor",
				new ImageIcon(getClass().getResource("/sage_icons/profile_plus_round [#1343].png")), panel_add_gerente,
				null);
		panel_add_gerente.setLayout(null);

		JButton limpar_dados_criarSupervisor = new JButton("Limpar");

		limpar_dados_criarSupervisor.setBounds(383, 406, 105, 34);
		panel_add_gerente.add(limpar_dados_criarSupervisor);

		JButton btnNewButton = new JButton("Cadastrar");

		btnNewButton.setBounds(498, 406, 105, 34);
		panel_add_gerente.add(btnNewButton);

		JLayeredPane layeredPane_2_1 = new JLayeredPane();
		layeredPane_2_1.setBorder(
				new TitledBorder(null, "Dados do novo Supervisor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		layeredPane_2_1.setBounds(20, 47, 583, 158);
		panel_add_gerente.add(layeredPane_2_1);

		senha_supervisor_criarSupervisor = new JPasswordField();
		senha_supervisor_criarSupervisor.setColumns(10);
		senha_supervisor_criarSupervisor.setBounds(21, 111, 253, 25);
		layeredPane_2_1.add(senha_supervisor_criarSupervisor);

		JLabel lblNewLabel_2_1_1 = new JLabel("Senha:");
		lblNewLabel_2_1_1.setBounds(21, 87, 253, 25);
		layeredPane_2_1.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_5_1 = new JLabel("CPF:");
		lblNewLabel_5_1.setBounds(307, 26, 253, 25);
		layeredPane_2_1.add(lblNewLabel_5_1);

		cpf_supervisor_criarSupervisor = new JFormattedTextField();
		cpf_supervisor_criarSupervisor.setColumns(10);
		cpf_supervisor_criarSupervisor.setBounds(307, 50, 253, 25);
		layeredPane_2_1.add(cpf_supervisor_criarSupervisor);

		confirmacaoSenha_supervisor_criarSupervisor = new JPasswordField();
		confirmacaoSenha_supervisor_criarSupervisor.setColumns(10);
		confirmacaoSenha_supervisor_criarSupervisor.setBounds(307, 111, 253, 25);
		layeredPane_2_1.add(confirmacaoSenha_supervisor_criarSupervisor);

		JLabel lblConfirmaoDeSenha = new JLabel("\r\nConfirmação de senha:");
		lblConfirmaoDeSenha.setBounds(307, 87, 253, 25);
		layeredPane_2_1.add(lblConfirmaoDeSenha);

		login_supervisor_criarSupervisor.setBounds(21, 51, 253, 25);
		layeredPane_2_1.add(login_supervisor_criarSupervisor);
		login_supervisor_criarSupervisor.setColumns(10);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(21, 31, 253, 25);
		layeredPane_2_1.add(lblLogin);

		JLabel label = new JLabel("USUÁRIO ATUAL:");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(20, 11, 106, 25);
		panel_add_gerente.add(label);

		JLabel usuario_atual_cadastrarSupervisor = new JLabel("");
		usuario_atual_cadastrarSupervisor.setFont(new Font("Tahoma", Font.ITALIC, 11));
		usuario_atual_cadastrarSupervisor.setBounds(143, 11, 169, 25);
		panel_add_gerente.add(usuario_atual_cadastrarSupervisor);

		// ADICIONAR CAMPOS DE ATUALIZAR gerente NESSE PANEL
		JPanel panel_update_gerente = new JPanel();
		tabbedPane_acoes_gerente.addTab("Atualizar Supervisor",
				new ImageIcon(getClass().getResource("/sage_icons/profile_round [#1342].png")), panel_update_gerente,
				null);
		panel_update_gerente.setLayout(null);

		JButton botao_limpar_dados_AtualizacaoSupervisor = new JButton("Limpar");

		botao_limpar_dados_AtualizacaoSupervisor.setBounds(30, 429, 78, 34);
		panel_update_gerente.add(botao_limpar_dados_AtualizacaoSupervisor);

		JButton btn_atualizar_tudo_AtualizacaoSupervisor = new JButton("Atualizar Tudo");

		btn_atualizar_tudo_AtualizacaoSupervisor.setBounds(359, 429, 106, 34);
		panel_update_gerente.add(btn_atualizar_tudo_AtualizacaoSupervisor);

		JButton btn_atualizar_cpf_AtualizacaoSupervisor = new JButton("Atualizar CPF");

		btn_atualizar_cpf_AtualizacaoSupervisor.setBounds(243, 429, 106, 34);
		panel_update_gerente.add(btn_atualizar_cpf_AtualizacaoSupervisor);

		JButton btn_atualizar_senha_AtualizacaoSupervisor = new JButton("Atualizar Senha");

		btn_atualizar_senha_AtualizacaoSupervisor.setBounds(118, 429, 115, 34);
		panel_update_gerente.add(btn_atualizar_senha_AtualizacaoSupervisor);

		JLayeredPane botao_atualizar_senha_AtualizacaoSupervisor = new JLayeredPane();
		botao_atualizar_senha_AtualizacaoSupervisor.setBorder(
				new TitledBorder(null, "Dados do Supervisor", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		botao_atualizar_senha_AtualizacaoSupervisor.setBounds(20, 152, 583, 262);
		panel_update_gerente.add(botao_atualizar_senha_AtualizacaoSupervisor);

		JLabel lblPesquisarId = new JLabel("Pesquisar pelo ID:");
		lblPesquisarId.setBounds(20, 42, 182, 25);
		botao_atualizar_senha_AtualizacaoSupervisor.add(lblPesquisarId);
		// lblPesquisarId.setFont(new Font("Bahnschrift", Font.PLAIN, 14));

		id_pesquisa_supervisor_AtualizacaoSupervisor = new JFormattedTextField();
		id_pesquisa_supervisor_AtualizacaoSupervisor.setBounds(20, 69, 86, 25);
		botao_atualizar_senha_AtualizacaoSupervisor.add(id_pesquisa_supervisor_AtualizacaoSupervisor);
		id_pesquisa_supervisor_AtualizacaoSupervisor.setText("0");
		id_pesquisa_supervisor_AtualizacaoSupervisor.setColumns(10);
		// formattedTextField_1_2.setBackground(SystemColor.controlHighlight);

		JButton buscar_supervisor_AtualizacaoSupervisor = new JButton("Buscar");

		buscar_supervisor_AtualizacaoSupervisor.setBounds(116, 69, 86, 25);
		botao_atualizar_senha_AtualizacaoSupervisor.add(buscar_supervisor_AtualizacaoSupervisor);
		// passwordField.setBackground(SystemColor.controlHighlight);

		JLabel lblNewLabel_3 = new JLabel("Nova Senha:");
		lblNewLabel_3.setBounds(20, 150, 253, 25);
		botao_atualizar_senha_AtualizacaoSupervisor.add(lblNewLabel_3);
		// lblNewLabel_3.setFont(new Font("Bahnschrift", Font.PLAIN, 14));

		nova_senha_supervisor_AtualizacaoSupervisor = new JPasswordField();
		nova_senha_supervisor_AtualizacaoSupervisor.setBounds(20, 175, 253, 25);
		botao_atualizar_senha_AtualizacaoSupervisor.add(nova_senha_supervisor_AtualizacaoSupervisor);
		nova_senha_supervisor_AtualizacaoSupervisor.setColumns(10);
		nova_senha_supervisor_AtualizacaoSupervisor.setEditable(true);
		// lblNewLabel_5.setFont(new Font("Bahnschrift", Font.PLAIN, 14));

		JLabel lblNewLabel_3_1 = new JLabel("Novo CPF:");
		lblNewLabel_3_1.setBounds(306, 150, 253, 25);
		botao_atualizar_senha_AtualizacaoSupervisor.add(lblNewLabel_3_1);
		// lblNewLabel_3_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));

		novo_cpf_supervisor_AtualizacaoSupervisor = new JFormattedTextField();
		novo_cpf_supervisor_AtualizacaoSupervisor.setBounds(306, 175, 253, 25);
		botao_atualizar_senha_AtualizacaoSupervisor.add(novo_cpf_supervisor_AtualizacaoSupervisor);
		novo_cpf_supervisor_AtualizacaoSupervisor.setColumns(10);
		novo_cpf_supervisor_AtualizacaoSupervisor.setEditable(true);

		cpf_atual_supervisor_AtualizacaoSupervisor.setEditable(false);
		cpf_atual_supervisor_AtualizacaoSupervisor.setColumns(10);
		cpf_atual_supervisor_AtualizacaoSupervisor.setBounds(306, 124, 253, 25);
		try {
			novo_cpf_supervisor_AtualizacaoSupervisor
					.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		botao_atualizar_senha_AtualizacaoSupervisor.add(cpf_atual_supervisor_AtualizacaoSupervisor);

		JLabel lblSenhaAtual = new JLabel("Login atual:");
		lblSenhaAtual.setBounds(20, 97, 253, 25);
		botao_atualizar_senha_AtualizacaoSupervisor.add(lblSenhaAtual);

		login_atual_supervisor_AtualizacaoSupervisor.setEditable(false);
		login_atual_supervisor_AtualizacaoSupervisor.setColumns(10);
		login_atual_supervisor_AtualizacaoSupervisor.setBounds(20, 126, 253, 25);
		botao_atualizar_senha_AtualizacaoSupervisor.add(login_atual_supervisor_AtualizacaoSupervisor);

		JLabel lblCpfAtual = new JLabel("CPF atual:");
		lblCpfAtual.setBounds(306, 102, 253, 25);
		botao_atualizar_senha_AtualizacaoSupervisor.add(lblCpfAtual);

		novo_login_supervisor_AtualizacaoSupervisor.setColumns(10);
		novo_login_supervisor_AtualizacaoSupervisor.setBounds(20, 226, 253, 25);
		botao_atualizar_senha_AtualizacaoSupervisor.add(novo_login_supervisor_AtualizacaoSupervisor);

		JLabel lblNovoLogin = new JLabel("Novo Login:");
		lblNovoLogin.setBounds(20, 203, 253, 25);
		botao_atualizar_senha_AtualizacaoSupervisor.add(lblNovoLogin);

		JLayeredPane layeredPane_2 = new JLayeredPane();
		layeredPane_2.setBorder(new TitledBorder(null, "Confirme Seus Dados de Gerente", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		layeredPane_2.setBounds(20, 38, 583, 113);
		panel_update_gerente.add(layeredPane_2);

		senha_gerente_AtualizacaoSupervisor = new JPasswordField();
		senha_gerente_AtualizacaoSupervisor.setColumns(10);
		senha_gerente_AtualizacaoSupervisor.setBounds(21, 50, 253, 25);
		layeredPane_2.add(senha_gerente_AtualizacaoSupervisor);

		JLabel lblNewLabel_2_1 = new JLabel("Sua Senha:");
		lblNewLabel_2_1.setBounds(21, 26, 253, 25);
		layeredPane_2.add(lblNewLabel_2_1);

		JLabel lblNewLabel_5 = new JLabel("Seu CPF:");
		lblNewLabel_5.setBounds(307, 26, 253, 25);
		layeredPane_2.add(lblNewLabel_5);

		cpf_gerente_AtualizacaoSupervisor = new JFormattedTextField();
		cpf_gerente_AtualizacaoSupervisor.setColumns(10);
		cpf_gerente_AtualizacaoSupervisor.setBounds(307, 50, 253, 25);
		layeredPane_2.add(cpf_gerente_AtualizacaoSupervisor);

		JButton btn_atualizar_login_AtualizacaoSupervisor = new JButton("Atualizar Login");
		btn_atualizar_login_AtualizacaoSupervisor.setBounds(475, 429, 128, 34);
		panel_update_gerente.add(btn_atualizar_login_AtualizacaoSupervisor);

		JLabel lblUsurioAtual = new JLabel("USUÁRIO ATUAL:");
		lblUsurioAtual.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsurioAtual.setForeground(Color.BLACK);
		lblUsurioAtual.setBounds(20, 11, 106, 25);
		panel_update_gerente.add(lblUsurioAtual);

		JLabel usuario_atual_atualizar_gerente = new JLabel("");
		usuario_atual_atualizar_gerente.setFont(new Font("Tahoma", Font.ITALIC, 11));
		usuario_atual_atualizar_gerente.setBounds(143, 11, 169, 25);
		panel_update_gerente.add(usuario_atual_atualizar_gerente);
		// c_cpfAtual.setBackground(SystemColor.controlHighlight);

		// ADICIONAR CAMPOS DE DELETAR gerente NESSE PANEL
		JPanel panel_delete_supervisor = new JPanel();
		tabbedPane_acoes_gerente.addTab("Deletar Supervisor",
				new ImageIcon(getClass().getResource("/sage_icons/profile_round [#1346].png")), panel_delete_supervisor,
				null);
		panel_delete_supervisor.setLayout(null);

		JLayeredPane layeredPane_2_2 = new JLayeredPane();
		layeredPane_2_2.setBorder(new TitledBorder(null, "Confirme Seus Dados de Gerente", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		layeredPane_2_2.setBounds(20, 39, 583, 113);
		panel_delete_supervisor.add(layeredPane_2_2);

		senha_gerente_deleteSupervisor = new JPasswordField();
		senha_gerente_deleteSupervisor.setColumns(10);
		senha_gerente_deleteSupervisor.setBounds(21, 50, 253, 25);
		layeredPane_2_2.add(senha_gerente_deleteSupervisor);

		JLabel lblNewLabel_2_1_2 = new JLabel("Sua Senha:");
		lblNewLabel_2_1_2.setBounds(21, 26, 253, 25);
		layeredPane_2_2.add(lblNewLabel_2_1_2);

		JLabel lblNewLabel_5_2 = new JLabel("Seu CPF:");
		lblNewLabel_5_2.setBounds(307, 26, 253, 25);
		layeredPane_2_2.add(lblNewLabel_5_2);

		cpf_gerente_deleteSupervisor = new JFormattedTextField();
		cpf_gerente_deleteSupervisor.setColumns(10);
		cpf_gerente_deleteSupervisor.setBounds(307, 50, 253, 25);
		layeredPane_2_2.add(cpf_gerente_deleteSupervisor);

		JLayeredPane layeredPane_1_1 = new JLayeredPane();
		layeredPane_1_1.setBorder(
				new TitledBorder(null, "Dados do Supervisor", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		layeredPane_1_1.setBounds(20, 152, 583, 190);
		panel_delete_supervisor.add(layeredPane_1_1);

		JLabel lblPesquisarId_1 = new JLabel("Pesquisar ID:");
		lblPesquisarId_1.setBounds(20, 33, 182, 25);
		layeredPane_1_1.add(lblPesquisarId_1);

		id_pesquisa_deleteSupervisor = new JFormattedTextField();
		id_pesquisa_deleteSupervisor.setText("0");
		id_pesquisa_deleteSupervisor.setColumns(10);
		id_pesquisa_deleteSupervisor.setBounds(20, 69, 86, 25);
		layeredPane_1_1.add(id_pesquisa_deleteSupervisor);

		id_pesquisa_deleteSupervisor.setText("0");

		JButton botao_pesquisa_deleteSupervisor = new JButton("Buscar");

		botao_pesquisa_deleteSupervisor.setBounds(116, 69, 86, 25);
		layeredPane_1_1.add(botao_pesquisa_deleteSupervisor);

		JLabel lblNewLabel_3_2 = new JLabel("Login");
		lblNewLabel_3_2.setBounds(20, 103, 253, 27);
		layeredPane_1_1.add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_1_1 = new JLabel("CPF:");
		lblNewLabel_3_1_1.setBounds(306, 103, 253, 27);
		layeredPane_1_1.add(lblNewLabel_3_1_1);

		cpf_supervisor_deleteSupervisor = new JFormattedTextField();
		cpf_supervisor_deleteSupervisor.setEditable(false);
		cpf_supervisor_deleteSupervisor.setColumns(10);
		cpf_supervisor_deleteSupervisor.setBounds(306, 131, 253, 25);
		layeredPane_1_1.add(cpf_supervisor_deleteSupervisor);

		login_supervisor_deleteSupervisor.setEditable(false);
		login_supervisor_deleteSupervisor.setColumns(10);
		login_supervisor_deleteSupervisor.setBounds(20, 133, 253, 25);
		layeredPane_1_1.add(login_supervisor_deleteSupervisor);

		botao_limpar_dados_deleteSupervisor.setBounds(383, 406, 105, 34);
		panel_delete_supervisor.add(botao_limpar_dados_deleteSupervisor);

		JButton botao_deletar_deleteSupervisor = new JButton("Deletar");

		botao_deletar_deleteSupervisor.setBounds(498, 406, 105, 34);
		panel_delete_supervisor.add(botao_deletar_deleteSupervisor);

		JLabel usuario_atual_deletarSupervisor = new JLabel("");
		usuario_atual_deletarSupervisor.setFont(new Font("Tahoma", Font.ITALIC, 11));
		usuario_atual_deletarSupervisor.setBounds(146, 11, 169, 25);
		panel_delete_supervisor.add(usuario_atual_deletarSupervisor);

		JLabel label_2 = new JLabel("USUÁRIO ATUAL:");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(23, 11, 106, 25);
		panel_delete_supervisor.add(label_2);

		JPanel panel_area_fornecedor = new JPanel();
		tabbedPane_area.addTab("Área do Fornecedor", null, panel_area_fornecedor, null);
		panel_area_fornecedor.setLayout(null);

		JTabbedPane tabbedPane_acoes_fornecedor = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_acoes_fornecedor.setBounds(0, 0, 618, 525);
		panel_area_fornecedor.add(tabbedPane_acoes_fornecedor);

		// ADICIONAR CAMPOS DE CADASTRAR FORNECEDOR NESSE PANEL
		JPanel panel_add_fornecedor = new JPanel();
		tabbedPane_acoes_fornecedor.addTab("Cadastrar Fornecedor",
				new ImageIcon(getClass().getResource("/sage_icons/profile_image_plus_round [#1327].png")),
				panel_add_fornecedor, null);
		panel_add_fornecedor.setLayout(null);

		JLayeredPane layeredPane_2_1_1_1_1 = new JLayeredPane();
		layeredPane_2_1_1_1_1.setBorder(
				new TitledBorder(null, "Dados do novo Fornecedor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		layeredPane_2_1_1_1_1.setBounds(20, 71, 583, 324);
		panel_add_fornecedor.add(layeredPane_2_1_1_1_1);

		JLabel lblNewLabel_2_1_1_1_2_1 = new JLabel("CNPJ:");
		lblNewLabel_2_1_1_1_2_1.setBounds(21, 26, 176, 25);
		layeredPane_2_1_1_1_1.add(lblNewLabel_2_1_1_1_2_1);

		JLabel lblNewLabel_5_1_1_1_1 = new JLabel("Email:");
		lblNewLabel_5_1_1_1_1.setBounds(207, 26, 351, 25);
		layeredPane_2_1_1_1_1.add(lblNewLabel_5_1_1_1_1);

		c_email_cf.setColumns(10);
		c_email_cf.setBounds(207, 50, 351, 25);
		layeredPane_2_1_1_1_1.add(c_email_cf);

		JLabel lblNewLabel_2_1_1_1_1_4_1 = new JLabel("Nome:");
		lblNewLabel_2_1_1_1_1_4_1.setBounds(21, 86, 176, 25);
		layeredPane_2_1_1_1_1.add(lblNewLabel_2_1_1_1_1_4_1);

		JLabel lblNewLabel_2_1_1_1_1_1_1_1 = new JLabel("CEP:");
		lblNewLabel_2_1_1_1_1_1_1_1.setBounds(207, 86, 151, 25);
		layeredPane_2_1_1_1_1.add(lblNewLabel_2_1_1_1_1_1_1_1);

		JLabel lblNewLabel_2_1_1_1_1_2_1_1 = new JLabel("Estado:");
		lblNewLabel_2_1_1_1_1_2_1_1.setBounds(368, 86, 56, 25);
		layeredPane_2_1_1_1_1.add(lblNewLabel_2_1_1_1_1_2_1_1);

		JComboBox c_estado_cf = new JComboBox();
		c_estado_cf.setModel(new DefaultComboBoxModel(
				new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB",
						"PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		c_estado_cf.setBounds(368, 110, 56, 25);
		layeredPane_2_1_1_1_1.add(c_estado_cf);

		JLabel lblNewLabel_2_1_1_1_1_3_1_1 = new JLabel("Cidade:");
		lblNewLabel_2_1_1_1_1_3_1_1.setBounds(434, 86, 124, 25);
		layeredPane_2_1_1_1_1.add(lblNewLabel_2_1_1_1_1_3_1_1);

		c_cidade_cf = new JTextField();
		c_cidade_cf.setColumns(10);
		c_cidade_cf.setBounds(434, 110, 124, 25);
		layeredPane_2_1_1_1_1.add(c_cidade_cf);

		c_nome_cf = new JTextField();
		c_nome_cf.setColumns(10);
		c_nome_cf.setBounds(21, 110, 176, 25);
		layeredPane_2_1_1_1_1.add(c_nome_cf);

		JLabel lblNewLabel_1_1 = new JLabel("Razão Social:");
		lblNewLabel_1_1.setBounds(21, 148, 248, 14);
		layeredPane_2_1_1_1_1.add(lblNewLabel_1_1);

		c_razaosocial_cf = new JTextField();
		c_razaosocial_cf.setColumns(10);
		c_razaosocial_cf.setBounds(21, 165, 248, 25);
		layeredPane_2_1_1_1_1.add(c_razaosocial_cf);

		JLabel lblTelefone_1_1 = new JLabel("Telefone:");
		lblTelefone_1_1.setBounds(279, 148, 145, 14);
		layeredPane_2_1_1_1_1.add(lblTelefone_1_1);

		c_telefone_af_1.setBounds(279, 165, 145, 25);
		layeredPane_2_1_1_1_1.add(c_telefone_af_1);

		c_cnpj_cf.setBounds(21, 52, 176, 25);
		layeredPane_2_1_1_1_1.add(c_cnpj_cf);

		c_cep_cf.setBounds(207, 110, 151, 25);
		layeredPane_2_1_1_1_1.add(c_cep_cf);

		JLabel lblBairro_1_1 = new JLabel("Bairro:");
		lblBairro_1_1.setBounds(436, 146, 122, 14);
		layeredPane_2_1_1_1_1.add(lblBairro_1_1);

		c_bairro_cf.setBounds(434, 165, 124, 25);
		layeredPane_2_1_1_1_1.add(c_bairro_cf);

		JLabel lblNmerodomiclio_1_1 = new JLabel("Número (Domicílio)");
		lblNmerodomiclio_1_1.setBounds(21, 201, 124, 14);
		layeredPane_2_1_1_1_1.add(lblNmerodomiclio_1_1);

		c_numero_cf = new JTextField();
		c_numero_cf.setColumns(10);
		c_numero_cf.setBounds(21, 218, 124, 25);
		layeredPane_2_1_1_1_1.add(c_numero_cf);

		JLabel lblLogradouro_1_2_1 = new JLabel("Logradouro:");
		lblLogradouro_1_2_1.setBounds(155, 201, 403, 14);
		layeredPane_2_1_1_1_1.add(lblLogradouro_1_2_1);

		c_logradouro_cf = new JTextField();
		c_logradouro_cf.setColumns(10);
		c_logradouro_cf.setBounds(155, 218, 403, 25);
		layeredPane_2_1_1_1_1.add(c_logradouro_cf);

		JLabel lblLogradouro_1_1_1_1 = new JLabel("Complemento:");
		lblLogradouro_1_1_1_1.setBounds(21, 254, 537, 14);
		layeredPane_2_1_1_1_1.add(lblLogradouro_1_1_1_1);

		c_complemento_cf = new JTextField();
		c_complemento_cf.setColumns(10);
		c_complemento_cf.setBounds(21, 271, 537, 25);
		layeredPane_2_1_1_1_1.add(c_complemento_cf);

		bt_limpar_cf = new JButton("Limpar");
		bt_limpar_cf.setBounds(389, 406, 105, 34);
		panel_add_fornecedor.add(bt_limpar_cf);

		JButton bt_cadastrar_cf = new JButton("Cadastrar");
		bt_cadastrar_cf.setBounds(504, 406, 99, 34);
		panel_add_fornecedor.add(bt_cadastrar_cf);

		// ADICIONAR CAMPOS DE ALTERAR FORNECEDOR NESSE PANEL
		JPanel panel_update_fornecedor = new JPanel();
		tabbedPane_acoes_fornecedor.addTab("Atualizar Fornecedor",
				new ImageIcon(getClass().getResource("/sage_icons/profile_image_round [#1326].png")),
				panel_update_fornecedor, null);
		panel_update_fornecedor.setLayout(null);

		JLayeredPane layeredPane_2_1_1_1 = new JLayeredPane();
		layeredPane_2_1_1_1.setBorder(
				new TitledBorder(null, "Dados do novo Fornecedor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		layeredPane_2_1_1_1.setBounds(20, 71, 583, 324);
		panel_update_fornecedor.add(layeredPane_2_1_1_1);

		JLabel lblNewLabel_2_1_1_1_2 = new JLabel("CNPJ:");
		lblNewLabel_2_1_1_1_2.setBounds(21, 26, 176, 25);
		layeredPane_2_1_1_1.add(lblNewLabel_2_1_1_1_2);

		JLabel lblNewLabel_5_1_1_1 = new JLabel("Email:");
		lblNewLabel_5_1_1_1.setBounds(207, 26, 351, 25);
		layeredPane_2_1_1_1.add(lblNewLabel_5_1_1_1);

		c_email_af = new JFormattedTextField();
		c_email_af.setEnabled(false);
		c_email_af.setColumns(10);
		c_email_af.setBounds(207, 50, 351, 25);
		layeredPane_2_1_1_1.add(c_email_af);

		JLabel lblNewLabel_2_1_1_1_1_4 = new JLabel("Nome:");
		lblNewLabel_2_1_1_1_1_4.setBounds(21, 86, 176, 25);
		layeredPane_2_1_1_1.add(lblNewLabel_2_1_1_1_1_4);

		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("CEP:");
		lblNewLabel_2_1_1_1_1_1_1.setBounds(207, 86, 151, 25);
		layeredPane_2_1_1_1.add(lblNewLabel_2_1_1_1_1_1_1);

		JLabel lblNewLabel_2_1_1_1_1_2_1 = new JLabel("Estado:");
		lblNewLabel_2_1_1_1_1_2_1.setBounds(368, 86, 56, 25);
		layeredPane_2_1_1_1.add(lblNewLabel_2_1_1_1_1_2_1);

		c_estado_af = new JComboBox();
		c_estado_af.setEnabled(false);
		c_estado_af.setModel(new DefaultComboBoxModel(
				new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB",
						"PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		c_estado_af.setBounds(368, 110, 56, 25);
		layeredPane_2_1_1_1.add(c_estado_af);

		JLabel lblNewLabel_2_1_1_1_1_3_1 = new JLabel("Cidade:");
		lblNewLabel_2_1_1_1_1_3_1.setBounds(434, 86, 124, 25);
		layeredPane_2_1_1_1.add(lblNewLabel_2_1_1_1_1_3_1);

		c_cidade_af = new JTextField();
		c_cidade_af.setEnabled(false);
		c_cidade_af.setColumns(10);
		c_cidade_af.setBounds(434, 110, 124, 25);
		layeredPane_2_1_1_1.add(c_cidade_af);

		c_nome_af = new JTextField();
		c_nome_af.setEnabled(false);
		c_nome_af.setColumns(10);
		c_nome_af.setBounds(21, 110, 176, 25);
		layeredPane_2_1_1_1.add(c_nome_af);

		JLabel lblNewLabel_1 = new JLabel("Razão Social:");
		lblNewLabel_1.setBounds(21, 148, 248, 14);
		layeredPane_2_1_1_1.add(lblNewLabel_1);

		c_razaosocial_af = new JTextField();
		c_razaosocial_af.setEnabled(false);
		c_razaosocial_af.setColumns(10);
		c_razaosocial_af.setBounds(21, 165, 248, 25);
		layeredPane_2_1_1_1.add(c_razaosocial_af);

		JLabel lblTelefone_1 = new JLabel("Telefone:");
		lblTelefone_1.setBounds(279, 148, 145, 14);
		layeredPane_2_1_1_1.add(lblTelefone_1);

		c_telefone_af = new JFormattedTextField();
		c_telefone_af.setEnabled(false);
		c_telefone_af.setBounds(279, 165, 145, 25);
		layeredPane_2_1_1_1.add(c_telefone_af);

		c_cnpj_af = new JFormattedTextField();
		c_cnpj_af.setEnabled(false);
		c_cnpj_af.setBounds(21, 52, 176, 25);
		layeredPane_2_1_1_1.add(c_cnpj_af);

		c_cep_af = new JFormattedTextField();
		c_cep_af.setEnabled(false);
		c_cep_af.setBounds(207, 110, 151, 25);
		layeredPane_2_1_1_1.add(c_cep_af);

		JLabel lblBairro_1 = new JLabel("Bairro:");
		lblBairro_1.setBounds(436, 146, 122, 14);
		layeredPane_2_1_1_1.add(lblBairro_1);

		c_bairro_af = new JFormattedTextField();
		c_bairro_af.setEnabled(false);
		c_bairro_af.setBounds(434, 165, 124, 25);
		layeredPane_2_1_1_1.add(c_bairro_af);

		JLabel lblNmerodomiclio_1 = new JLabel("Número (Domicílio)");
		lblNmerodomiclio_1.setBounds(21, 201, 124, 14);
		layeredPane_2_1_1_1.add(lblNmerodomiclio_1);

		c_numero_af = new JTextField();
		c_numero_af.setEnabled(false);
		c_numero_af.setColumns(10);
		c_numero_af.setBounds(21, 218, 124, 25);
		layeredPane_2_1_1_1.add(c_numero_af);

		JLabel lblLogradouro_1_2 = new JLabel("Logradouro:");
		lblLogradouro_1_2.setBounds(155, 201, 403, 14);
		layeredPane_2_1_1_1.add(lblLogradouro_1_2);

		c_logradouro_af = new JTextField();
		c_logradouro_af.setEnabled(false);
		c_logradouro_af.setColumns(10);
		c_logradouro_af.setBounds(155, 218, 403, 25);
		layeredPane_2_1_1_1.add(c_logradouro_af);

		JLabel lblLogradouro_1_1_1 = new JLabel("Complemento:");
		lblLogradouro_1_1_1.setBounds(21, 254, 537, 14);
		layeredPane_2_1_1_1.add(lblLogradouro_1_1_1);

		c_complemento_af = new JTextField();
		c_complemento_af.setEnabled(false);
		c_complemento_af.setColumns(10);
		c_complemento_af.setBounds(21, 271, 537, 25);
		layeredPane_2_1_1_1.add(c_complemento_af);

		JLabel lblPesquisarId_2 = new JLabel("Pesquisar pelo ID:");
		lblPesquisarId_2.setBounds(393, 11, 182, 25);
		panel_update_fornecedor.add(lblPesquisarId_2);

		formattedTextField_1_2_2 = new JFormattedTextField();
		formattedTextField_1_2_2.setText("0");
		formattedTextField_1_2_2.setColumns(10);
		formattedTextField_1_2_2.setBounds(393, 37, 86, 23);
		panel_update_fornecedor.add(formattedTextField_1_2_2);

		JButton btnNewButton_1_2 = new JButton("Buscar");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c_cnpj_af.setEnabled(true);
				cpf_supervisor_criarSupervisor.setEnabled(true);
				c_telefone_af.setEnabled(true);
				c_cep_af.setEnabled(true);
				c_bairro_af.setEnabled(true);
				c_email_af.setEnabled(true);
				cpf_supervisor_deleteSupervisor.setEnabled(true);
				c_nome_af.setEnabled(true);
				c_razaosocial_af.setEnabled(true);
				c_numero_af.setEnabled(true);
				c_logradouro_af.setEnabled(true);
				c_complemento_af.setEnabled(true);
				c_cidade_af.setEnabled(true);
				c_estado_af.setEnabled(true);

			}
		});
		btnNewButton_1_2.setBounds(489, 35, 86, 25);
		panel_update_fornecedor.add(btnNewButton_1_2);

		JButton bt_limpar_af = new JButton("Limpar");
		bt_limpar_af.setBounds(389, 406, 105, 34);
		panel_update_fornecedor.add(bt_limpar_af);

		JButton bt_atualizar_af = new JButton("Atualizar");
		bt_atualizar_af.setBounds(504, 406, 99, 34);
		panel_update_fornecedor.add(bt_atualizar_af);

		// ADICIONAR CAMPOS DE DELETAR FORNECEDOR NESSE PANEL
		JPanel panel_delete_fornecedor = new JPanel();
		tabbedPane_acoes_fornecedor.addTab("Deletar Fornecedor",
				new ImageIcon(getClass().getResource("/sage_icons/profile_image_minus_round [#1329].png")),
				panel_delete_fornecedor, null);
		panel_delete_fornecedor.setLayout(null);

		JLabel lblPesquisarId_2_1 = new JLabel("Pesquisar pelo ID:");
		lblPesquisarId_2_1.setBounds(393, 11, 182, 25);
		panel_delete_fornecedor.add(lblPesquisarId_2_1);

		formattedTextField_1_2_2_1.setText("0");
		formattedTextField_1_2_2_1.setColumns(10);
		formattedTextField_1_2_2_1.setBounds(393, 37, 86, 23);
		panel_delete_fornecedor.add(formattedTextField_1_2_2_1);

		JButton btnNewButton_1_2_1 = new JButton("Buscar");
		btnNewButton_1_2_1.setBounds(489, 35, 86, 25);
		panel_delete_fornecedor.add(btnNewButton_1_2_1);

		JLayeredPane layeredPane_2_1_1_1_2 = new JLayeredPane();
		layeredPane_2_1_1_1_2.setBorder(
				new TitledBorder(null, "Dados do novo Fornecedor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		layeredPane_2_1_1_1_2.setBounds(20, 71, 583, 173);
		panel_delete_fornecedor.add(layeredPane_2_1_1_1_2);

		JLabel lblNewLabel_2_1_1_1_2_2 = new JLabel("CNPJ:");
		lblNewLabel_2_1_1_1_2_2.setBounds(21, 26, 176, 25);
		layeredPane_2_1_1_1_2.add(lblNewLabel_2_1_1_1_2_2);

		JLabel lblNewLabel_5_1_1_1_2 = new JLabel("Email:");
		lblNewLabel_5_1_1_1_2.setBounds(21, 86, 525, 25);
		layeredPane_2_1_1_1_2.add(lblNewLabel_5_1_1_1_2);

		c_email_af_1.setEnabled(false);
		c_email_af_1.setColumns(10);
		c_email_af_1.setBounds(21, 110, 536, 25);
		layeredPane_2_1_1_1_2.add(c_email_af_1);

		JLabel lblNewLabel_2_1_1_1_1_4_2 = new JLabel("Nome:");
		lblNewLabel_2_1_1_1_1_4_2.setBounds(207, 26, 339, 25);
		layeredPane_2_1_1_1_2.add(lblNewLabel_2_1_1_1_1_4_2);

		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(207, 50, 350, 25);
		layeredPane_2_1_1_1_2.add(textField_1);

		c_cnpj_af_1.setEnabled(false);
		c_cnpj_af_1.setBounds(21, 52, 176, 25);
		layeredPane_2_1_1_1_2.add(c_cnpj_af_1);

		JButton bt_limpar_af_1 = new JButton("Limpar");
		bt_limpar_af_1.setBounds(389, 406, 105, 34);
		panel_delete_fornecedor.add(bt_limpar_af_1);

		JButton bt_atualizar_af_1 = new JButton("Deletar");
		bt_atualizar_af_1.setBounds(504, 406, 99, 34);
		panel_delete_fornecedor.add(bt_atualizar_af_1);

		JPanel panel_area_produto = new JPanel();
		tabbedPane_area.addTab("Área do Produto", null, panel_area_produto, null);
		panel_area_produto.setLayout(null);

		JTabbedPane tabbedPane_acoes_produto = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_acoes_produto.setBounds(0, 0, 618, 525);
		panel_area_produto.add(tabbedPane_acoes_produto);

		// ADICIONAR CAMPOS DE CADASTRAR PRODUTO NESSE PANEL
		JPanel panel_add_produto = new JPanel();
		tabbedPane_acoes_produto.addTab("Cadastrar Produto",
				new ImageIcon(getClass().getResource("/sage_icons/cart_plus_round [#1158].png")), panel_add_produto,
				null);
		panel_add_produto.setLayout(null);

		JLayeredPane layeredPane_3 = new JLayeredPane();
		layeredPane_3
				.setBorder(new TitledBorder(null, "Dados do Produto", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		layeredPane_3.setBounds(20, 71, 583, 221);
		panel_add_produto.add(layeredPane_3);

		JDateChooser dcFabricacao_1 = new JDateChooser();
		dcFabricacao_1.setForeground(SystemColor.menu);
		dcFabricacao_1.setBounds(397, 106, 140, 24);
		layeredPane_3.add(dcFabricacao_1);

		JDateChooser dcVencimento_1 = new JDateChooser();
		dcVencimento_1.setForeground(SystemColor.menu);
		dcVencimento_1.setBounds(397, 165, 140, 24);
		layeredPane_3.add(dcVencimento_1);

		JLabel lblNewLabel_4 = new JLabel("Nome:");
		lblNewLabel_4.setBounds(48, 33, 189, 20);
		layeredPane_3.add(lblNewLabel_4);

		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(48, 52, 189, 24);
		layeredPane_3.add(textField_3);

		JLabel lblNewLabel_2_3 = new JLabel("Descrição:");
		lblNewLabel_2_3.setBounds(48, 85, 189, 20);
		layeredPane_3.add(lblNewLabel_2_3);

		formattedTextField_2.setEnabled(false);
		formattedTextField_2.setBounds(247, 52, 100, 24);
		layeredPane_3.add(formattedTextField_2);

		JLabel lblCdigo_1 = new JLabel("Código:");
		lblCdigo_1.setBounds(247, 33, 100, 20);
		layeredPane_3.add(lblCdigo_1);

		JLabel lblPreo_1 = new JLabel("Preço:");
		lblPreo_1.setBounds(357, 33, 94, 20);
		layeredPane_3.add(lblPreo_1);

		formattedTextField_1_1.setBounds(357, 52, 94, 24);
		layeredPane_3.add(formattedTextField_1_1);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setEditable(true);
		comboBox_2.setBounds(247, 106, 140, 24);
		layeredPane_3.add(comboBox_2);

		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setColumns(10);
		textField_4.setBounds(247, 165, 76, 24);
		layeredPane_3.add(textField_4);

		JLabel lblDataDeFabricao_1 = new JLabel("Data de Fabricação:");
		lblDataDeFabricao_1.setBounds(397, 87, 140, 20);
		layeredPane_3.add(lblDataDeFabricao_1);

		JLabel lblPreo_1_1_1 = new JLabel("Data de Vencimento:");
		lblPreo_1_1_1.setBounds(397, 141, 140, 20);
		layeredPane_3.add(lblPreo_1_1_1);

		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setEnabled(false);
		comboBox_1_1.setBounds(333, 165, 54, 24);
		layeredPane_3.add(comboBox_1_1);

		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(48, 108, 187, 81);
		layeredPane_3.add(editorPane_1);

		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(473, 52, 64, 24);
		layeredPane_3.add(spinner_1);

		JLabel lblNewLabel_2_2_3 = new JLabel("Grupo:");
		lblNewLabel_2_2_3.setBounds(247, 85, 140, 20);
		layeredPane_3.add(lblNewLabel_2_2_3);

		JLabel lblNewLabel_2_2_1_1 = new JLabel("Quantidade:");
		lblNewLabel_2_2_1_1.setBounds(473, 33, 64, 20);
		layeredPane_3.add(lblNewLabel_2_2_1_1);

		JLabel lblNewLabel_2_2_2_2 = new JLabel("Medida:");
		lblNewLabel_2_2_2_2.setBounds(245, 141, 88, 20);
		layeredPane_3.add(lblNewLabel_2_2_2_2);

		JLabel lblNewLabel_2_2_2_1_1 = new JLabel("Unidade:");
		lblNewLabel_2_2_2_1_1.setBounds(306, 134, 54, 20);
		layeredPane_3.add(lblNewLabel_2_2_2_1_1);

		JButton bt_atualizar_af_2 = new JButton("Cadastrar");
		bt_atualizar_af_2.setBounds(504, 406, 99, 34);
		panel_add_produto.add(bt_atualizar_af_2);

		JButton bt_limpar_af_2 = new JButton("Limpar");
		bt_limpar_af_2.setBounds(389, 406, 105, 34);
		panel_add_produto.add(bt_limpar_af_2);

		// ADICIONAR CAMPOS DE ALTERAR PRODUTO NESSE PANEL
		JPanel panel_update_produto = new JPanel();
		tabbedPane_acoes_produto.addTab("Atualizar Produto",
				new ImageIcon(getClass().getResource("/sage_icons/cart_round [#1166].png")), panel_update_produto,
				null);
		panel_update_produto.setLayout(null);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane
				.setBorder(new TitledBorder(null, "Dados do Produto", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		layeredPane.setBounds(20, 71, 583, 221);
		panel_update_produto.add(layeredPane);

		JDateChooser dcFabricacao = new JDateChooser();
		dcFabricacao.setForeground(SystemColor.control);
		dcFabricacao.setBounds(397, 106, 140, 24);
		layeredPane.add(dcFabricacao);

		JDateChooser dcVencimento = new JDateChooser();
		dcVencimento.setForeground(SystemColor.control);
		dcVencimento.setBounds(397, 165, 140, 24);
		layeredPane.add(dcVencimento);

		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(48, 33, 189, 20);
		layeredPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBounds(48, 52, 189, 24);
		layeredPane.add(textField);

		JLabel lblNewLabel_2 = new JLabel("Descrição:");
		lblNewLabel_2.setBounds(48, 85, 189, 20);
		layeredPane.add(lblNewLabel_2);

		formattedTextField.setEnabled(false);
		formattedTextField.setBounds(247, 52, 100, 24);
		layeredPane.add(formattedTextField);

		JLabel lblCdigo = new JLabel("Código:");
		lblCdigo.setBounds(247, 33, 100, 20);
		layeredPane.add(lblCdigo);

		JLabel lblPreo = new JLabel("Preço:");
		lblPreo.setBounds(357, 33, 94, 20);
		layeredPane.add(lblPreo);

		formattedTextField_1.setBounds(357, 52, 94, 24);
		layeredPane.add(formattedTextField_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setBounds(247, 106, 140, 24);
		layeredPane.add(comboBox);

		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(247, 165, 76, 24);
		layeredPane.add(textField_2);

		JLabel lblDataDeFabricao = new JLabel("Data de Fabricação:");
		lblDataDeFabricao.setBounds(397, 87, 140, 20);
		layeredPane.add(lblDataDeFabricao);

		JLabel lblPreo_1_1 = new JLabel("Data de Vencimento:");
		lblPreo_1_1.setBounds(397, 141, 140, 20);
		layeredPane.add(lblPreo_1_1);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEnabled(false);
		comboBox_1.setBounds(333, 165, 54, 24);
		layeredPane.add(comboBox_1);

		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(48, 108, 187, 81);
		layeredPane.add(editorPane);

		JSpinner spinner = new JSpinner();
		spinner.setBounds(473, 52, 64, 24);
		layeredPane.add(spinner);

		JLabel lblNewLabel_2_2 = new JLabel("Grupo:");
		lblNewLabel_2_2.setBounds(247, 85, 140, 20);
		layeredPane.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_2_1 = new JLabel("Quantidade:");
		lblNewLabel_2_2_1.setBounds(473, 33, 64, 20);
		layeredPane.add(lblNewLabel_2_2_1);

		JLabel lblNewLabel_2_2_2 = new JLabel("Medida:");
		lblNewLabel_2_2_2.setBounds(245, 141, 88, 20);
		layeredPane.add(lblNewLabel_2_2_2);

		JLabel lblNewLabel_2_2_2_1 = new JLabel("Unidade:");
		lblNewLabel_2_2_2_1.setBounds(306, 134, 54, 20);
		layeredPane.add(lblNewLabel_2_2_2_1);

		JLabel lblPesquisarId_2_2 = new JLabel("Pesquisar pelo ID:");
		lblPesquisarId_2_2.setBounds(393, 11, 182, 25);
		panel_update_produto.add(lblPesquisarId_2_2);

		formattedTextField_1_2_2_2.setText("0");
		formattedTextField_1_2_2_2.setColumns(10);
		formattedTextField_1_2_2_2.setBounds(393, 36, 86, 23);
		panel_update_produto.add(formattedTextField_1_2_2_2);

		JButton btnNewButton_1_2_2 = new JButton("Buscar");
		btnNewButton_1_2_2.setBounds(489, 35, 86, 25);
		panel_update_produto.add(btnNewButton_1_2_2);

		JButton bt_atualizar_af_3 = new JButton("Atualizar");
		bt_atualizar_af_3.setBounds(504, 406, 99, 34);
		panel_update_produto.add(bt_atualizar_af_3);

		JButton bt_limpar_af_3 = new JButton("Limpar");
		bt_limpar_af_3.setBounds(393, 406, 105, 34);
		panel_update_produto.add(bt_limpar_af_3);

		// ADICIONAR CAMPOS DE DELETAR PRODUTO NESSE PANEL
		JPanel panel_delete_produto = new JPanel();
		tabbedPane_acoes_produto.addTab("Deletar Produto",
				new ImageIcon(getClass().getResource("/sage_icons/cart_minus_round [#1162].png")), panel_delete_produto,
				null);
		panel_delete_produto.setLayout(null);

		JTabbedPane tabbedPane_listagem = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_listagem.setBounds(652, 49, 548, 475);
		panel_superior.add(tabbedPane_listagem);

		JPanel panel_listar_movimentacoes = new JPanel();
		tabbedPane_listagem.addTab("Produtos", null, panel_listar_movimentacoes, null);
		panel_listar_movimentacoes.setLayout(null);

		JScrollPane scrollPane_m = new JScrollPane();
		scrollPane_m.setBounds(10, 11, 517, 425);
		panel_listar_movimentacoes.add(scrollPane_m);

		table_movimentacoes = new JTable();
		// ControllerTableModels.popularTabelaMovimentacoes(table_movimentacoes);
		scrollPane_m.setViewportView(table_movimentacoes);

		JPanel panel_listar_fornecedores = new JPanel();
		tabbedPane_listagem.addTab("Fornecedores", null, panel_listar_fornecedores, null);
		panel_listar_fornecedores.setLayout(null);

		JScrollPane scrollPane_f = new JScrollPane();
		scrollPane_f.setBounds(10, 11, 517, 425);
		panel_listar_fornecedores.add(scrollPane_f);

		table_fornecedores = new JTable() {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		// ControllerTableModels.popularTabelaFornecedores(table_fornecedores);
		scrollPane_f.setViewportView(table_fornecedores);

		JPanel panel_listar_registros = new JPanel();
		panel_listar_registros.setLayout(null);
		tabbedPane_listagem.addTab("Supervisores", null, panel_listar_registros, null);

		JScrollPane scrollPane_r = new JScrollPane();
		scrollPane_r.setBounds(10, 11, 517, 425);
		panel_listar_registros.add(scrollPane_r);

		table_registros = new JTable();
		// ControllerTableModels.popularTableRegistrosGerente(table_registros);
		scrollPane_r.setViewportView(table_registros);

		JPanel panel_listar_gerentes = new JPanel();
		tabbedPane_listagem.addTab("Gerentes", null, panel_listar_gerentes, null);
		panel_listar_gerentes.setLayout(null);

		JScrollPane scrollPane_s = new JScrollPane();
		scrollPane_s.setBounds(10, 11, 517, 425);
		panel_listar_gerentes.add(scrollPane_s);

		table_gerentes = new JTable();
		scrollPane_s.setViewportView(table_gerentes);

		JSeparator separator_vertical = new JSeparator();
		separator_vertical.setOrientation(SwingConstants.VERTICAL);
		separator_vertical.setBounds(633, 0, 11, 553);
		panel_superior.add(separator_vertical);

		JButton btn_atualizar_tabelas_superior = new JButton("Atualizar listas");
		btn_atualizar_tabelas_superior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Atualizar().start();
			}
		});
		btn_atualizar_tabelas_superior.setBounds(652, 11, 125, 27);
		panel_superior.add(btn_atualizar_tabelas_superior);

		progressBar_tabelas_superior = new JProgressBar();
		progressBar_tabelas_superior.setBounds(799, 21, 385, 10);
		panel_superior.add(progressBar_tabelas_superior);

		// ControllerTableModels.popularTabelaProdutos(table_produtos);
		// new ControllerTableModels(table_registros, table_gerentes,
		// table_fornecedores, table_produtos, table_movimentacoes);
		// setLocationRelativeTo(null);

		// ESSES MÉTODOS IRÃO PERMITIR APENAS NÚMEROS PARA SEUS RESPECTIVOS CAMPOS
		id_pesquisa_deleteSupervisor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				id_pesquisa_deleteSupervisor.setText(id_pesquisa_deleteSupervisor.getText().replaceAll("[^0-9]", "0"));
			}
		});

		id_pesquisa_supervisor_AtualizacaoSupervisor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				id_pesquisa_supervisor_AtualizacaoSupervisor
						.setText(id_pesquisa_supervisor_AtualizacaoSupervisor.getText().replaceAll("[^0-9]", "0"));
			}
		});

		// MÉTODO DE MOSTRAR OS DADOS DOS CAMPOS DO PAINEL DE DELEÇÃO DO SUPERVISOR

		botao_pesquisa_deleteSupervisor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlSuper.mostrarDadosDoSupervisor(id_pesquisa_deleteSupervisor, cpf_supervisor_deleteSupervisor,
						login_supervisor_deleteSupervisor);
			}
		});
		// MÉTODO DE LIMPAR OS DADOS DOS CAMPOS DO PAINEL DE DELEÇÃO DO SUPERVISOR

		botao_limpar_dados_deleteSupervisor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlAux.limparCampos(cpf_gerente_deleteSupervisor, senha_gerente_deleteSupervisor,
						cpf_supervisor_deleteSupervisor, id_pesquisa_deleteSupervisor,
						login_supervisor_deleteSupervisor, senha_gerente_deleteSupervisor);

			}
		});

		// MÉTODO DE DELEÇÃO DO SUPERVISOR
		botao_deletar_deleteSupervisor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlSuper.excluirContaSupervisor(id_pesquisa_deleteSupervisor, cpf_gerente_deleteSupervisor.getText(),
						senha_gerente_deleteSupervisor.getText());

				ctrlAux.limparCampos(cpf_gerente_deleteSupervisor, senha_gerente_deleteSupervisor,
						cpf_supervisor_deleteSupervisor, id_pesquisa_deleteSupervisor,
						login_supervisor_deleteSupervisor, senha_gerente_deleteSupervisor);

			}
		});

		// MÉTODO DE LIMPAR OS CAMPOS NO PAINEL DE CADASTRO DO SUPERVISOR

		limpar_dados_criarSupervisor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlAux.limparCampos(cpf_supervisor_criarSupervisor, confirmacaoSenha_supervisor_criarSupervisor,
						senha_supervisor_criarSupervisor, login_supervisor_criarSupervisor);
			}
		});

		// MÉTODO PARA O CADASTRO DE SUPERVISOR

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlSuper.cadastrarSupervisor(cpf_supervisor_criarSupervisor.getText(),
						senha_supervisor_criarSupervisor.getText(),
						confirmacaoSenha_supervisor_criarSupervisor.getText(),
						login_supervisor_criarSupervisor.getText(), login_supervisor_criarSupervisor,
						cpf_supervisor_criarSupervisor, senha_supervisor_criarSupervisor,
						confirmacaoSenha_supervisor_criarSupervisor);
			}
		});

		// MÉTODO LIMPAR CAMPOS DO PAINEL DE ATUALIZAÇÃO DO SUPERVISOR

		botao_limpar_dados_AtualizacaoSupervisor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ctrlAux.limparCampos(cpf_gerente_AtualizacaoSupervisor, id_pesquisa_supervisor_AtualizacaoSupervisor,
						nova_senha_supervisor_AtualizacaoSupervisor, senha_gerente_AtualizacaoSupervisor,
						novo_cpf_supervisor_AtualizacaoSupervisor, cpf_atual_supervisor_AtualizacaoSupervisor,
						login_atual_supervisor_AtualizacaoSupervisor, novo_login_supervisor_AtualizacaoSupervisor);

			}
		});

		// MÉTODO QUE MOSTRAr OS DADOS DO SUPERVISOR NO PAINEL DE ATUALIZAÇÃO DE
		// SUPERVISOR

		buscar_supervisor_AtualizacaoSupervisor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlSuper.mostrarDadosDoSupervisor(id_pesquisa_supervisor_AtualizacaoSupervisor,
						cpf_atual_supervisor_AtualizacaoSupervisor, login_atual_supervisor_AtualizacaoSupervisor);
			}
		});

		// MÉTODO DE ATUALIZAÇÃO DE SENHA DO SUPERVISOR DO PAINEL DE ATUALIZAÇÃO DO
		// SUPERVISOR

		btn_atualizar_senha_AtualizacaoSupervisor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ctrlSuper.atualizarSupervisorSenha(id_pesquisa_supervisor_AtualizacaoSupervisor,
						nova_senha_supervisor_AtualizacaoSupervisor.getText(), cpf_gerente_AtualizacaoSupervisor,
						senha_gerente_AtualizacaoSupervisor) == true) {

					ctrlAux.limparCampos(cpf_gerente_AtualizacaoSupervisor,
							id_pesquisa_supervisor_AtualizacaoSupervisor, nova_senha_supervisor_AtualizacaoSupervisor,
							senha_gerente_AtualizacaoSupervisor, novo_cpf_supervisor_AtualizacaoSupervisor,
							cpf_atual_supervisor_AtualizacaoSupervisor, login_atual_supervisor_AtualizacaoSupervisor,
							novo_login_supervisor_AtualizacaoSupervisor);
				}
			}
		});

		// MÉTODO DE ATUALIZAÇÃO DE CPF DO SUPERVISOR

		btn_atualizar_cpf_AtualizacaoSupervisor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ctrlSuper.atualizarSupervisorCpf(id_pesquisa_supervisor_AtualizacaoSupervisor,
						novo_cpf_supervisor_AtualizacaoSupervisor.getText(), cpf_gerente_AtualizacaoSupervisor,
						senha_gerente_AtualizacaoSupervisor) == true) {

					ctrlAux.limparCampos(cpf_gerente_AtualizacaoSupervisor,
							id_pesquisa_supervisor_AtualizacaoSupervisor, nova_senha_supervisor_AtualizacaoSupervisor,
							senha_gerente_AtualizacaoSupervisor, novo_cpf_supervisor_AtualizacaoSupervisor,
							cpf_atual_supervisor_AtualizacaoSupervisor, login_atual_supervisor_AtualizacaoSupervisor,
							novo_login_supervisor_AtualizacaoSupervisor);
				}
			}
		});

		// MÉTODO DE ATUALIZAÇÃO DE TODOS OS DADOS DO SUPERVISOR
		btn_atualizar_tudo_AtualizacaoSupervisor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (ctrlSuper.atualizarSupervisor(novo_cpf_supervisor_AtualizacaoSupervisor.getText(),
						nova_senha_supervisor_AtualizacaoSupervisor.getText(),
						id_pesquisa_supervisor_AtualizacaoSupervisor,
						novo_login_supervisor_AtualizacaoSupervisor.getText(), cpf_gerente_AtualizacaoSupervisor,
						senha_gerente_AtualizacaoSupervisor) == true) {

					ctrlAux.limparCampos(cpf_gerente_AtualizacaoSupervisor,
							id_pesquisa_supervisor_AtualizacaoSupervisor, nova_senha_supervisor_AtualizacaoSupervisor,
							senha_gerente_AtualizacaoSupervisor, novo_cpf_supervisor_AtualizacaoSupervisor,
							cpf_atual_supervisor_AtualizacaoSupervisor, login_atual_supervisor_AtualizacaoSupervisor,
							novo_login_supervisor_AtualizacaoSupervisor);

				}

			}
		});

		// MÉTODO DE REGISTRAR A SAÍDA DO USUÁRIO AO CLICAR NO BOTÃO DE SAIR

		btn_sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerGlobal controllerGlob = new ControllerGlobal();
				controllerGlob.registrarSaidaUsuario();
				Janela_login jlogin = new Janela_login();
				jlogin.setVisible(true);
				dispose();
			}
		});
		
		//ESSE BLOCO DE INICIALIZAÇÃO SERVE PARA MOSTRAR O LOGIN DO GERENTE ATUAL DO SISTEMA
		//SE FOR UM GERENTE QUE ESTIVER ACESSANDO, LOGICAMENTE
		//OBS: BLOCO DE INICIALIZAÇÃO É EXECUTADO ATÉ MESMO ANTES DO CONSTRUTOR DE UMA CLASSE

		{
			try {
			usuario_atual_deletarSupervisor.setText(GerenteAtual.getGerente().getLogin());
			usuario_atual_cadastrarSupervisor.setText(GerenteAtual.getGerente().getLogin());
			usuario_atual_atualizar_gerente.setText(GerenteAtual.getGerente().getLogin());
			}catch(NullPointerException e){
				System.out.println("");
			}

		}

	}

	public class Atualizar extends Thread {
		public void run() {
			try {
				progressBar_tabelas_superior.setStringPainted(true);
				while (progressBar_tabelas_superior.getValue() < 100) {
					sleep(10);
					progressBar_tabelas_superior.setValue(progressBar_tabelas_superior.getValue() + 1);
				}
				sleep(500);
				progressBar_tabelas_superior.setValue(0);
				progressBar_tabelas_superior.setStringPainted(false);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	@SuppressWarnings("unused")
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
