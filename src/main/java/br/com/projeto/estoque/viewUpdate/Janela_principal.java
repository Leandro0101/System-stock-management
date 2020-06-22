				package br.com.projeto.estoque.viewUpdate;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
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
import java.util.List;

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
import javax.swing.JTextPane;
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

import br.com.projeto.estoque.controller.ControllerAtualizarFornecedor;
import br.com.projeto.estoque.controller.ControllerAuxiliar;
import br.com.projeto.estoque.controller.ControllerGlobal;
import br.com.projeto.estoque.controller.ControllerPermissao;
import br.com.projeto.estoque.controller.ControllerSupervisor;
import br.com.projeto.estoque.controller.ControllerTableModels;
import br.com.projeto.estoque.controller.ControllerValidationFornecedor;

@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
public class Janela_principal extends JFrame {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private ControllerTableModels ctb;

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
	private JFormattedTextField cpf_atual_supervisor_AtualizacaoSupervisor = new JFormattedTextField();
	private JFormattedTextField login_atual_supervisor_AtualizacaoSupervisor = new JFormattedTextField();
	private JFormattedTextField novo_login_supervisor_AtualizacaoSupervisor = new JFormattedTextField();

	private JPanel contentPane;
	private JTable table_fornecedores;
	private JTable table_produtos;
	private JTable table_movimentacoes;
	private JTable table_registros_supervisores;
	private JTable table_supervisores;

	private JTextField tfCidadeAtualizarFornecedor;
	private JTextField tfNomeAtualizarFornecedor;
	private JTextField tfRazaoSocialAtualizarFornecedor;
	private JTextField tfNumeroAtualizarFornecedor;
	private JTextField tfLogradouroAtualizarFornecedor;
	private JTextField tfComplementoAtualizarFornecedor;
	private JFormattedTextField tfCnpjAtualizarFornecedor;

	private JFormattedTextField tfIdAtualizarFornecedor;
	private JFormattedTextField tfTelefoneAtualizarFornecedor;
	private JFormattedTextField tfCepAtualizarFornecedor;
	private JFormattedTextField tfBairroAtualizarFornecedor;
	private JFormattedTextField tfEmailAtualizarFornecedor;

	private JComboBox cbEstadoAtualizarFornecedor;
	private JComboBox cbGrupoCadastrar;
	private JComboBox cbGrupoAtualizar;
	private JComboBox cbUnidadeGrupoCadastrar;
	private JComboBox cbUnidadeGrupoAtualizar;
	private JComboBox cbEstadoCadastrarFornecedor;

	private JSpinner spQuantidadeCadastrarProduto;
	private JSpinner spQuantidadeAtualizarProduto;

	private JEditorPane epDescricaoCadastrarProduto;
	private JEditorPane epDescricaoAtualizarProduto;

	private JDateChooser dcFabricacaoCadastrarProduto;
	private JDateChooser dcVencimentoCadastrarProduto;
	private JDateChooser dcFabricacaoAtualizarProduto;
	private JDateChooser dcVencimentoAtualizarProduto;

	private JTextField tfCidadeCadastrarFornecedor;
	private JTextField tfNomeCadastrarFornecedor;
	private JTextField tfRazaoSocialCadastrarFornecedor;
	private JTextField tfNumeroCadastrarFornecedor;
	private JTextField tfLogradouroCadastrarFornecedor;
	private JTextField tfComplementoCadastrarFornecedor;
	private JButton btnLimparFornecedor;
	private JProgressBar progressBar_tabelas_superior;
	private JTextField textField_1;
	private JTextField tfNomeGrupoAtualizar;
	private JTextField tfMedidaGrupoAtualizar;
	private JTextField tfNomeGrupoCadastrar;
	private JTextField tfMedidaGrupoCadastrar;
	private JFormattedTextField tfEmailCadastrarFornecedor = new JFormattedTextField();
	private JFormattedTextField tfTelefoneCadastrarFornecedor = new JFormattedTextField();
	private JFormattedTextField tfCepCadastrarFornecedor = new JFormattedTextField();
	private JFormattedTextField tfCnpjCadastrarFornecedor = new JFormattedTextField();
	private JFormattedTextField tfBairroCadastrarFornecedor = new JFormattedTextField();
	private JFormattedTextField formattedTextField_1_2_2_1 = new JFormattedTextField();
	private JFormattedTextField c_email_af_1 = new JFormattedTextField();
	private JFormattedTextField c_cnpj_af_1 = new JFormattedTextField();
	private JFormattedTextField tfCodigoGrupoCadastrar = new JFormattedTextField();
	private JFormattedTextField tfPrecoCadastrarProduto = new JFormattedTextField();
	private JFormattedTextField tfCodigoGrupoAtualizar = new JFormattedTextField();
	private JFormattedTextField tfPrecoAtualizarProduto = new JFormattedTextField();
	private JFormattedTextField tfIdAtualizarProduto = new JFormattedTextField();

	private JButton botao_limpar_dados_deleteSupervisor = new JButton("Limpar");
	private JButton btnBuscarProduto;
	private JButton btnResetarAtualizarProduto;
	private JButton btnLimparAtualizarProduto;
	private JButton btnAtualizarProduto;

	private JButton btnBuscarFornecedor;
	private JButton btnResetarAtualizarFornecedor;
	private JButton btnLimparAtualizarFornecedor;
	private JButton btnAtualizarFornecedor;
	
	
	JLabel usuario_atual_atualizar_gerente = new JLabel("");
	JLabel usuario_atual_deletarSupervisor = new JLabel("");
	JLabel usuario_atual_cadastrarSupervisor = new JLabel("");
	

	ControllerSupervisor ctrlSuper = new ControllerSupervisor();
	ControllerAuxiliar ctrlAux = new ControllerAuxiliar();
	ControllerPermissao ctrlPermissao = new ControllerPermissao();

	MaskFormatter ms;
	DefaultFormatterFactory df;
	private JTextField textField;
	private JTextField textField_2;
	JMenuItem mntmNewMenuItem;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
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
	public Janela_principal() {
		
		ctrlAux.setarLoginUsuarioAtual_na_telaPrincipal(usuario_atual_cadastrarSupervisor,
				usuario_atual_atualizar_gerente, usuario_atual_deletarSupervisor);
		
		setTitle("SAGE - MENU");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1216, 603);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("Relatório");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem = new JMenuItem("Novo");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Janela_relatorio jr = new Janela_relatorio();
				jr.setVisible(true);
			}
		});

		mnNewMenu_1.add(mntmNewMenuItem);

		JMenu mnNewMenu = new JMenu("Denifições");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 13));
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

		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Light Arc");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IntelliJTheme.install(Janela_principal.class.getResourceAsStream("/themes/Arc.json"));
				SwingUtilities.updateComponentTreeUI(new Janela_principal());
				Janela_principal t = new Janela_principal();
				repaint();
				validate();
				t.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_9);

		JMenuItem mntmNewMenuItem_10 = new JMenuItem("High Contrast");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IntelliJTheme.install(Janela_principal.class.getResourceAsStream("/themes/HighContrast.json"));
				SwingUtilities.updateComponentTreeUI(new Janela_principal());
				Janela_principal t = new Janela_principal();
				repaint();
				validate();
				t.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Palenight Contrast");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IntelliJTheme.install(Janela_principal.class.getResourceAsStream("/themes/PalenightContrast.json"));
				SwingUtilities.updateComponentTreeUI(new Janela_principal());
				Janela_principal t = new Janela_principal();
				repaint();
				validate();
				t.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Darker");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IntelliJTheme.install(Janela_principal.class.getResourceAsStream("/themes/Darker.json"));
				SwingUtilities.updateComponentTreeUI(new Janela_principal());
				Janela_principal t = new Janela_principal();
				repaint();
				validate();
				t.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_1);

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
		// tabbedPane_acoes_gerente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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

		btn_atualizar_tudo_AtualizacaoSupervisor.setBounds(385, 429, 106, 34);
		panel_update_gerente.add(btn_atualizar_tudo_AtualizacaoSupervisor);

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

		cpf_atual_supervisor_AtualizacaoSupervisor.setEditable(false);
		cpf_atual_supervisor_AtualizacaoSupervisor.setColumns(10);
		cpf_atual_supervisor_AtualizacaoSupervisor.setBounds(306, 124, 253, 25);

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

		btn_atualizar_login_AtualizacaoSupervisor.setBounds(243, 429, 128, 34);
		panel_update_gerente.add(btn_atualizar_login_AtualizacaoSupervisor);

		JLabel lblUsurioAtual = new JLabel("USUÁRIO ATUAL:");
		lblUsurioAtual.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsurioAtual.setForeground(Color.BLACK);
		lblUsurioAtual.setBounds(20, 11, 106, 25);
		panel_update_gerente.add(lblUsurioAtual);

		
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

		tfEmailCadastrarFornecedor.setColumns(10);
		tfEmailCadastrarFornecedor.setBounds(207, 50, 351, 25);
		layeredPane_2_1_1_1_1.add(tfEmailCadastrarFornecedor);

		JLabel lblNewLabel_2_1_1_1_1_4_1 = new JLabel("Nome:");
		lblNewLabel_2_1_1_1_1_4_1.setBounds(21, 86, 176, 25);
		layeredPane_2_1_1_1_1.add(lblNewLabel_2_1_1_1_1_4_1);

		JLabel lblNewLabel_2_1_1_1_1_1_1_1 = new JLabel("CEP:");
		lblNewLabel_2_1_1_1_1_1_1_1.setBounds(207, 86, 151, 25);
		layeredPane_2_1_1_1_1.add(lblNewLabel_2_1_1_1_1_1_1_1);

		JLabel lblNewLabel_2_1_1_1_1_2_1_1 = new JLabel("Estado:");
		lblNewLabel_2_1_1_1_1_2_1_1.setBounds(368, 86, 56, 25);
		layeredPane_2_1_1_1_1.add(lblNewLabel_2_1_1_1_1_2_1_1);

		String[] estados = new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG",
				"PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" };
		cbEstadoCadastrarFornecedor = new JComboBox(estados);
		cbEstadoCadastrarFornecedor.setBounds(368, 110, 56, 25);
		layeredPane_2_1_1_1_1.add(cbEstadoCadastrarFornecedor);

		JLabel lblNewLabel_2_1_1_1_1_3_1_1 = new JLabel("Cidade:");
		lblNewLabel_2_1_1_1_1_3_1_1.setBounds(434, 86, 124, 25);
		layeredPane_2_1_1_1_1.add(lblNewLabel_2_1_1_1_1_3_1_1);

		tfCidadeCadastrarFornecedor = new JTextField();
		tfCidadeCadastrarFornecedor.setColumns(10);
		tfCidadeCadastrarFornecedor.setBounds(434, 110, 124, 25);
		layeredPane_2_1_1_1_1.add(tfCidadeCadastrarFornecedor);

		tfNomeCadastrarFornecedor = new JTextField();
		tfNomeCadastrarFornecedor.setColumns(10);
		tfNomeCadastrarFornecedor.setBounds(21, 110, 176, 25);
		layeredPane_2_1_1_1_1.add(tfNomeCadastrarFornecedor);

		JLabel lblNewLabel_1_1 = new JLabel("Razão Social:");
		lblNewLabel_1_1.setBounds(21, 148, 248, 14);
		layeredPane_2_1_1_1_1.add(lblNewLabel_1_1);

		tfRazaoSocialCadastrarFornecedor = new JTextField();
		tfRazaoSocialCadastrarFornecedor.setColumns(10);
		tfRazaoSocialCadastrarFornecedor.setBounds(21, 165, 248, 25);
		layeredPane_2_1_1_1_1.add(tfRazaoSocialCadastrarFornecedor);

		JLabel lblTelefone_1_1 = new JLabel("Telefone:");
		lblTelefone_1_1.setBounds(279, 148, 145, 14);
		layeredPane_2_1_1_1_1.add(lblTelefone_1_1);

		ms = null;
		try {
			ms = new MaskFormatter("(##)####-####");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		df = new DefaultFormatterFactory(ms);
		tfTelefoneCadastrarFornecedor.setFormatterFactory(df);
		tfTelefoneCadastrarFornecedor.setBounds(279, 165, 145, 25);
		layeredPane_2_1_1_1_1.add(tfTelefoneCadastrarFornecedor);

		ms = null;
		try {
			ms = new MaskFormatter("##.###.###/####-##");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		df = new DefaultFormatterFactory(ms);
		tfCnpjCadastrarFornecedor.setFormatterFactory(df);
		tfCnpjCadastrarFornecedor.setBounds(21, 50, 176, 25);
		layeredPane_2_1_1_1_1.add(tfCnpjCadastrarFornecedor);

		ms = null;
		try {
			ms = new MaskFormatter("#####-###");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		df = new DefaultFormatterFactory(ms);
		tfCepCadastrarFornecedor.setFormatterFactory(df);
		tfCepCadastrarFornecedor.setBounds(207, 110, 151, 25);
		layeredPane_2_1_1_1_1.add(tfCepCadastrarFornecedor);

		JLabel lblBairro_1_1 = new JLabel("Bairro:");
		lblBairro_1_1.setBounds(436, 146, 122, 14);
		layeredPane_2_1_1_1_1.add(lblBairro_1_1);

		tfBairroCadastrarFornecedor.setBounds(434, 165, 124, 25);
		layeredPane_2_1_1_1_1.add(tfBairroCadastrarFornecedor);

		JLabel lblNmerodomiclio_1_1 = new JLabel("Número (Domicílio)");
		lblNmerodomiclio_1_1.setBounds(21, 201, 124, 14);
		layeredPane_2_1_1_1_1.add(lblNmerodomiclio_1_1);

		tfNumeroCadastrarFornecedor = new JTextField();
		tfNumeroCadastrarFornecedor.setColumns(10);
		tfNumeroCadastrarFornecedor.setBounds(21, 218, 124, 25);
		layeredPane_2_1_1_1_1.add(tfNumeroCadastrarFornecedor);

		JLabel lblLogradouro_1_2_1 = new JLabel("Logradouro:");
		lblLogradouro_1_2_1.setBounds(155, 201, 403, 14);
		layeredPane_2_1_1_1_1.add(lblLogradouro_1_2_1);

		tfLogradouroCadastrarFornecedor = new JTextField();
		tfLogradouroCadastrarFornecedor.setColumns(10);
		tfLogradouroCadastrarFornecedor.setBounds(155, 218, 403, 25);
		layeredPane_2_1_1_1_1.add(tfLogradouroCadastrarFornecedor);

		JLabel lblLogradouro_1_1_1_1 = new JLabel("Complemento:");
		lblLogradouro_1_1_1_1.setBounds(21, 254, 537, 14);
		layeredPane_2_1_1_1_1.add(lblLogradouro_1_1_1_1);

		tfComplementoCadastrarFornecedor = new JTextField();
		tfComplementoCadastrarFornecedor.setColumns(10);
		tfComplementoCadastrarFornecedor.setBounds(21, 271, 537, 25);
		layeredPane_2_1_1_1_1.add(tfComplementoCadastrarFornecedor);

		btnLimparFornecedor = new JButton("Limpar");
		btnLimparFornecedor.setBounds(389, 406, 105, 34);
		panel_add_fornecedor.add(btnLimparFornecedor);

		JButton btnCadastrarFornecedor = new JButton("Cadastrar");
		btnCadastrarFornecedor.setBounds(504, 406, 99, 34);
		panel_add_fornecedor.add(btnCadastrarFornecedor);

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

		tfEmailAtualizarFornecedor = new JFormattedTextField();
		tfEmailAtualizarFornecedor.setEnabled(false);
		tfEmailAtualizarFornecedor.setColumns(10);
		tfEmailAtualizarFornecedor.setBounds(207, 50, 351, 25);
		layeredPane_2_1_1_1.add(tfEmailAtualizarFornecedor);

		JLabel lblNewLabel_2_1_1_1_1_4 = new JLabel("Nome:");
		lblNewLabel_2_1_1_1_1_4.setBounds(21, 86, 176, 25);
		layeredPane_2_1_1_1.add(lblNewLabel_2_1_1_1_1_4);

		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("CEP:");
		lblNewLabel_2_1_1_1_1_1_1.setBounds(207, 86, 151, 25);
		layeredPane_2_1_1_1.add(lblNewLabel_2_1_1_1_1_1_1);

		JLabel lblNewLabel_2_1_1_1_1_2_1 = new JLabel("Estado:");
		lblNewLabel_2_1_1_1_1_2_1.setBounds(368, 86, 56, 25);
		layeredPane_2_1_1_1.add(lblNewLabel_2_1_1_1_1_2_1);

		cbEstadoAtualizarFornecedor = new JComboBox();
		cbEstadoAtualizarFornecedor.setEnabled(false);
		cbEstadoAtualizarFornecedor.setModel(new DefaultComboBoxModel(
				new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB",
						"PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cbEstadoAtualizarFornecedor.setBounds(368, 110, 56, 25);
		layeredPane_2_1_1_1.add(cbEstadoAtualizarFornecedor);

		JLabel lblNewLabel_2_1_1_1_1_3_1 = new JLabel("Cidade:");
		lblNewLabel_2_1_1_1_1_3_1.setBounds(434, 86, 124, 25);
		layeredPane_2_1_1_1.add(lblNewLabel_2_1_1_1_1_3_1);

		tfCidadeAtualizarFornecedor = new JTextField();
		tfCidadeAtualizarFornecedor.setEnabled(false);
		tfCidadeAtualizarFornecedor.setColumns(10);
		tfCidadeAtualizarFornecedor.setBounds(434, 110, 124, 25);
		layeredPane_2_1_1_1.add(tfCidadeAtualizarFornecedor);

		tfNomeAtualizarFornecedor = new JTextField();
		tfNomeAtualizarFornecedor.setEnabled(false);
		tfNomeAtualizarFornecedor.setColumns(10);
		tfNomeAtualizarFornecedor.setBounds(21, 110, 176, 25);
		layeredPane_2_1_1_1.add(tfNomeAtualizarFornecedor);

		JLabel lblNewLabel_1 = new JLabel("Razão Social:");
		lblNewLabel_1.setBounds(21, 148, 248, 14);
		layeredPane_2_1_1_1.add(lblNewLabel_1);

		tfRazaoSocialAtualizarFornecedor = new JTextField();
		tfRazaoSocialAtualizarFornecedor.setEnabled(false);
		tfRazaoSocialAtualizarFornecedor.setColumns(10);
		tfRazaoSocialAtualizarFornecedor.setBounds(21, 165, 248, 25);
		layeredPane_2_1_1_1.add(tfRazaoSocialAtualizarFornecedor);

		JLabel lblTelefone_1 = new JLabel("Telefone:");
		lblTelefone_1.setBounds(279, 148, 145, 14);
		layeredPane_2_1_1_1.add(lblTelefone_1);

		ms = null;
		try {
			ms = new MaskFormatter("(##)####-####");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		df = new DefaultFormatterFactory(ms);
		tfTelefoneAtualizarFornecedor = new JFormattedTextField();
		tfTelefoneAtualizarFornecedor.setEnabled(false);
		tfTelefoneAtualizarFornecedor.setBounds(279, 165, 145, 25);
		tfTelefoneAtualizarFornecedor.setFormatterFactory(df);
		layeredPane_2_1_1_1.add(tfTelefoneAtualizarFornecedor);

		ms = null;
		try {
			ms = new MaskFormatter("##.###.###/####-##");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		df = new DefaultFormatterFactory(ms);
		tfCnpjAtualizarFornecedor = new JFormattedTextField();
		tfCnpjAtualizarFornecedor.setEnabled(false);
		tfCnpjAtualizarFornecedor.setBounds(21, 50, 176, 25);
		tfCnpjAtualizarFornecedor.setFormatterFactory(df);
		layeredPane_2_1_1_1.add(tfCnpjAtualizarFornecedor);

		ms = null;
		try {
			ms = new MaskFormatter("#####-###");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		df = new DefaultFormatterFactory(ms);
		tfCepAtualizarFornecedor = new JFormattedTextField();
		tfCepAtualizarFornecedor.setEnabled(false);
		tfCepAtualizarFornecedor.setBounds(207, 110, 151, 25);
		tfCepAtualizarFornecedor.setFormatterFactory(df);
		layeredPane_2_1_1_1.add(tfCepAtualizarFornecedor);

		JLabel lblBairro_1 = new JLabel("Bairro:");
		lblBairro_1.setBounds(436, 146, 122, 14);
		layeredPane_2_1_1_1.add(lblBairro_1);

		tfBairroAtualizarFornecedor = new JFormattedTextField();
		tfBairroAtualizarFornecedor.setEnabled(false);
		tfBairroAtualizarFornecedor.setBounds(434, 165, 124, 25);
		layeredPane_2_1_1_1.add(tfBairroAtualizarFornecedor);

		JLabel lblNmerodomiclio_1 = new JLabel("Número (Domicílio)");
		lblNmerodomiclio_1.setBounds(21, 201, 124, 14);
		layeredPane_2_1_1_1.add(lblNmerodomiclio_1);

		tfNumeroAtualizarFornecedor = new JTextField();
		tfNumeroAtualizarFornecedor.setEnabled(false);
		tfNumeroAtualizarFornecedor.setColumns(10);
		tfNumeroAtualizarFornecedor.setBounds(21, 218, 124, 25);
		layeredPane_2_1_1_1.add(tfNumeroAtualizarFornecedor);

		JLabel lblLogradouro_1_2 = new JLabel("Logradouro:");
		lblLogradouro_1_2.setBounds(155, 201, 403, 14);
		layeredPane_2_1_1_1.add(lblLogradouro_1_2);

		tfLogradouroAtualizarFornecedor = new JTextField();
		tfLogradouroAtualizarFornecedor.setEnabled(false);
		tfLogradouroAtualizarFornecedor.setColumns(10);
		tfLogradouroAtualizarFornecedor.setBounds(155, 218, 403, 25);
		layeredPane_2_1_1_1.add(tfLogradouroAtualizarFornecedor);

		JLabel lblLogradouro_1_1_1 = new JLabel("Complemento:");
		lblLogradouro_1_1_1.setBounds(21, 254, 537, 14);
		layeredPane_2_1_1_1.add(lblLogradouro_1_1_1);

		tfComplementoAtualizarFornecedor = new JTextField();
		tfComplementoAtualizarFornecedor.setEnabled(false);
		tfComplementoAtualizarFornecedor.setColumns(10);
		tfComplementoAtualizarFornecedor.setBounds(21, 271, 537, 25);
		layeredPane_2_1_1_1.add(tfComplementoAtualizarFornecedor);

		JLabel lblPesquisarId_2 = new JLabel("Pesquisar pelo ID:");
		lblPesquisarId_2.setBounds(393, 11, 182, 25);
		panel_update_fornecedor.add(lblPesquisarId_2);

		tfIdAtualizarFornecedor = new JFormattedTextField();
		tfIdAtualizarFornecedor.setText("0");
		tfIdAtualizarFornecedor.setColumns(10);
		tfIdAtualizarFornecedor.setBounds(393, 37, 86, 23);
		panel_update_fornecedor.add(tfIdAtualizarFornecedor);

		btnBuscarFornecedor = new JButton("Buscar");
		btnBuscarFornecedor.setBounds(489, 36, 86, 25);
		panel_update_fornecedor.add(btnBuscarFornecedor);

		btnLimparAtualizarFornecedor = new JButton("Limpar");
		btnLimparAtualizarFornecedor.setEnabled(false);
		btnLimparAtualizarFornecedor.setBounds(389, 406, 105, 34);
		panel_update_fornecedor.add(btnLimparAtualizarFornecedor);

		btnAtualizarFornecedor = new JButton("Atualizar");
		btnAtualizarFornecedor.setEnabled(false);
		btnAtualizarFornecedor.setBounds(504, 406, 99, 34);
		panel_update_fornecedor.add(btnAtualizarFornecedor);

		btnResetarAtualizarFornecedor = new JButton("Resetar");
		btnResetarAtualizarFornecedor.setEnabled(false);
		btnResetarAtualizarFornecedor.setBounds(306, 36, 77, 25);
		panel_update_fornecedor.add(btnResetarAtualizarFornecedor);

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

		dcFabricacaoCadastrarProduto = new JDateChooser();
		dcFabricacaoCadastrarProduto.setBounds(397, 106, 140, 24);
		layeredPane_3.add(dcFabricacaoCadastrarProduto);

		dcVencimentoCadastrarProduto = new JDateChooser();
		dcVencimentoCadastrarProduto.setBounds(397, 165, 140, 24);
		layeredPane_3.add(dcVencimentoCadastrarProduto);

		JLabel lblNewLabel_4 = new JLabel("Nome:");
		lblNewLabel_4.setBounds(48, 33, 189, 20);
		layeredPane_3.add(lblNewLabel_4);

		tfNomeGrupoCadastrar = new JTextField();
		tfNomeGrupoCadastrar.setEnabled(false);
		tfNomeGrupoCadastrar.setColumns(10);
		tfNomeGrupoCadastrar.setBounds(48, 52, 189, 24);
		layeredPane_3.add(tfNomeGrupoCadastrar);

		JLabel lblNewLabel_2_3 = new JLabel("Descrição do Produto:");
		lblNewLabel_2_3.setBounds(48, 85, 189, 20);
		layeredPane_3.add(lblNewLabel_2_3);

		tfCodigoGrupoCadastrar.setEnabled(false);
		tfCodigoGrupoCadastrar.setBounds(247, 52, 100, 24);
		layeredPane_3.add(tfCodigoGrupoCadastrar);

		JLabel lblCdigo_1 = new JLabel("Código:");
		lblCdigo_1.setBounds(247, 33, 100, 20);
		layeredPane_3.add(lblCdigo_1);

		JLabel lblPreo_1 = new JLabel("Preço:");
		lblPreo_1.setBounds(357, 33, 94, 20);
		layeredPane_3.add(lblPreo_1);

		tfPrecoCadastrarProduto.setBounds(357, 52, 94, 24);
		layeredPane_3.add(tfPrecoCadastrarProduto);

		List<String> vazio = ControllerAuxiliar.preencherGrupos();
		vazio.add(0, "...");
		cbGrupoCadastrar = new JComboBox(vazio.toArray());
		cbGrupoCadastrar.setBounds(247, 106, 140, 24);
		layeredPane_3.add(cbGrupoCadastrar);

		tfMedidaGrupoCadastrar = new JTextField();
		tfMedidaGrupoCadastrar.setEnabled(false);
		tfMedidaGrupoCadastrar.setColumns(10);
		tfMedidaGrupoCadastrar.setBounds(247, 165, 76, 24);
		layeredPane_3.add(tfMedidaGrupoCadastrar);

		JLabel lblDataDeFabricao_1 = new JLabel("Data de Fabricação:");
		lblDataDeFabricao_1.setBounds(397, 87, 140, 20);
		layeredPane_3.add(lblDataDeFabricao_1);

		JLabel lblPreo_1_1_1 = new JLabel("Data de Vencimento:");
		lblPreo_1_1_1.setBounds(397, 141, 140, 20);
		layeredPane_3.add(lblPreo_1_1_1);

		cbUnidadeGrupoCadastrar = new JComboBox();
		cbUnidadeGrupoCadastrar.setEnabled(false);
		cbUnidadeGrupoCadastrar.setBounds(333, 165, 54, 24);
		layeredPane_3.add(cbUnidadeGrupoCadastrar);

		epDescricaoCadastrarProduto = new JEditorPane();
		epDescricaoCadastrarProduto.setBounds(48, 108, 187, 81);
		layeredPane_3.add(epDescricaoCadastrarProduto);

		spQuantidadeCadastrarProduto = new JSpinner();
		spQuantidadeCadastrarProduto.setBounds(473, 52, 64, 24);
		layeredPane_3.add(spQuantidadeCadastrarProduto);

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
		
				dcFabricacaoAtualizarProduto = new JDateChooser();
				dcFabricacaoAtualizarProduto.setForeground(SystemColor.control);
				dcFabricacaoAtualizarProduto.setBounds(397, 106, 140, 24);
				layeredPane.add(dcFabricacaoAtualizarProduto);
				
						dcVencimentoAtualizarProduto = new JDateChooser();
						dcVencimentoAtualizarProduto.setForeground(SystemColor.control);
						dcVencimentoAtualizarProduto.setBounds(397, 165, 140, 24);
						layeredPane.add(dcVencimentoAtualizarProduto);
						
								JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(48, 33, 189, 20);
		layeredPane.add(lblNewLabel);
		
				tfNomeGrupoAtualizar = new JTextField();
				tfNomeGrupoAtualizar.setEnabled(false);
				tfNomeGrupoAtualizar.setColumns(10);
				tfNomeGrupoAtualizar.setBounds(48, 52, 189, 24);
				layeredPane.add(tfNomeGrupoAtualizar);
				
						JLabel lblNewLabel_2 = new JLabel("Descrição do Produto:");
		lblNewLabel_2.setBounds(48, 85, 189, 20);
		layeredPane.add(lblNewLabel_2);
		
				tfCodigoGrupoAtualizar.setEnabled(false);
				tfCodigoGrupoAtualizar.setBounds(247, 52, 100, 24);
				layeredPane.add(tfCodigoGrupoAtualizar);
				
						JLabel lblCdigo = new JLabel("Código:");
		lblCdigo.setBounds(247, 33, 100, 20);
		layeredPane.add(lblCdigo);
		
				JLabel lblPreo = new JLabel("Preço:");
		lblPreo.setBounds(357, 33, 94, 20);
		layeredPane.add(lblPreo);
		tfPrecoAtualizarProduto.setEnabled(false);
		
				tfPrecoAtualizarProduto.setBounds(357, 52, 94, 24);
				layeredPane.add(tfPrecoAtualizarProduto);
				
						cbGrupoAtualizar = new JComboBox(vazio.toArray());
						cbGrupoAtualizar.setEnabled(false);
						cbGrupoAtualizar.setBounds(247, 106, 140, 24);
						layeredPane.add(cbGrupoAtualizar);
						
								tfMedidaGrupoAtualizar = new JTextField();
								tfMedidaGrupoAtualizar.setEnabled(false);
								tfMedidaGrupoAtualizar.setColumns(10);
								tfMedidaGrupoAtualizar.setBounds(247, 165, 76, 24);
								layeredPane.add(tfMedidaGrupoAtualizar);
								
										JLabel lblDataDeFabricao = new JLabel("Data de Fabricação:");
		lblDataDeFabricao.setBounds(397, 87, 140, 20);
		layeredPane.add(lblDataDeFabricao);
		
				JLabel lblPreo_1_1 = new JLabel("Data de Vencimento:");
		lblPreo_1_1.setBounds(397, 141, 140, 20);
		layeredPane.add(lblPreo_1_1);
		
				cbUnidadeGrupoAtualizar = new JComboBox();
				cbUnidadeGrupoAtualizar.setEnabled(false);
				cbUnidadeGrupoAtualizar.setBounds(333, 165, 54, 24);
				layeredPane.add(cbUnidadeGrupoAtualizar);
				
						epDescricaoAtualizarProduto = new JEditorPane();
						epDescricaoAtualizarProduto.setEnabled(false);
						epDescricaoAtualizarProduto.setBounds(48, 108, 187, 81);
						layeredPane.add(epDescricaoAtualizarProduto);
						
								spQuantidadeAtualizarProduto = new JSpinner();
								spQuantidadeAtualizarProduto.setEnabled(false);
								spQuantidadeAtualizarProduto.setBounds(473, 52, 64, 24);
								layeredPane.add(spQuantidadeAtualizarProduto);
								
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
		
				tfIdAtualizarProduto.setText("0");
		tfIdAtualizarProduto.setColumns(10);
		tfIdAtualizarProduto.setBounds(393, 36, 86, 23);
		panel_update_produto.add(tfIdAtualizarProduto);
		
				btnBuscarProduto = new JButton("Buscar");
		btnBuscarProduto.setBounds(489, 35, 86, 25);
		panel_update_produto.add(btnBuscarProduto);
		
				btnAtualizarProduto = new JButton("Atualizar");
		btnAtualizarProduto.setEnabled(false);
		btnAtualizarProduto.setBounds(504, 406, 99, 34);
		panel_update_produto.add(btnAtualizarProduto);
		
				btnLimparAtualizarProduto = new JButton("Limpar");
		btnLimparAtualizarProduto.setEnabled(false);
		btnLimparAtualizarProduto.setBounds(393, 406, 105, 34);
		panel_update_produto.add(btnLimparAtualizarProduto);
		
				btnResetarAtualizarProduto = new JButton("Resetar");
		btnResetarAtualizarProduto.setEnabled(false);
		btnResetarAtualizarProduto.setBounds(306, 35, 77, 25);
		panel_update_produto.add(btnResetarAtualizarProduto);
		
				// ------------------ActionListeners de Atualizar o Produto
		// MÉTODO DE PREENCHER OS DADOS DO PRODUTO NA TELA DE ATUALIZAR BASEADO NO ID

//		btnBuscarProduto.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				ControllerAtualizarProduto cap = new ControllerAtualizarProduto();
//				cap.buscarProduto(btnBuscarProduto, btnResetarAtualizarProduto, tfIdAtualizarProduto,
//						tfPrecoAtualizarProduto, spQuantidadeAtualizarProduto, epDescricaoAtualizarProduto,
//						cbGrupoAtualizar, dcFabricacaoAtualizarProduto, dcVencimentoAtualizarProduto,
//						btnLimparAtualizarProduto, btnAtualizarProduto);
//			}
//		});
		
				// MÉTODO DE PREENCHER DADOS DO GRUPO DA TELA DE ATUALIZAR PRODUTOS BASEADO NO
		// GRUPO ESCOLHIDO
//		cbGrupoAtualizar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (cbGrupoAtualizar.getSelectedIndex() != 0) {
//					ControllerAuxiliar.preencherCamposGrupo(cbGrupoAtualizar, tfNomeGrupoAtualizar,
//							tfCodigoGrupoAtualizar, tfMedidaGrupoAtualizar, cbUnidadeGrupoAtualizar);
//				} else {
//					ControllerAuxiliar.resetarCamposGrupoProduto(tfNomeGrupoAtualizar, tfCodigoGrupoAtualizar,
//							tfMedidaGrupoAtualizar, cbUnidadeGrupoAtualizar);
//				}
//			}
//		});
		
				// BOTÃO DE ATUALIZAR O PRODUTO
//		btnAtualizarProduto.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if(ctrlPermissao.chamarVerificacao()==true) {
//					ControllerAtualizarProduto cap = new ControllerAtualizarProduto();
//					cap.atualizarProduto(tfIdAtualizarProduto, tfPrecoAtualizarProduto, spQuantidadeAtualizarProduto,
//							epDescricaoAtualizarProduto, cbGrupoAtualizar, dcFabricacaoAtualizarProduto,
//							dcVencimentoAtualizarProduto);
//				}
//		
//			}
//		});
		
				// BOTÃO DE LIMPAR NA TELA DE ATUALIZAR PRODUTO
//		btnLimparAtualizarProduto.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				ControllerAuxiliar.resetarTodosOsCampos(tfPrecoAtualizarProduto, spQuantidadeAtualizarProduto,
//						epDescricaoAtualizarProduto, dcFabricacaoAtualizarProduto, dcVencimentoAtualizarProduto,
//						cbGrupoAtualizar);
//			}
//		});
//		
				// BOTÃO DE RESETAR O ID E DESABILITAR OS CAMPOS DA TELA DE ATUALIZAR PRODUTOS
//		btnResetarAtualizarProduto.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				ControllerAtualizarProduto cap = new ControllerAtualizarProduto();
//				cap.desabilitarAtualizacao(btnBuscarProduto, btnResetarAtualizarProduto, tfIdAtualizarProduto,
//						tfPrecoAtualizarProduto, spQuantidadeAtualizarProduto, epDescricaoAtualizarProduto,
//						cbGrupoAtualizar, dcFabricacaoAtualizarProduto, dcVencimentoAtualizarProduto,
//						btnLimparAtualizarProduto, btnAtualizarProduto);
//			}
//		});
		

//		btnBuscarProduto.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				ControllerAtualizarProduto cap = new ControllerAtualizarProduto();
//				cap.buscarProduto(btnBuscarProduto, btnResetarAtualizarProduto, tfIdAtualizarProduto,
//						tfPrecoAtualizarProduto, spQuantidadeAtualizarProduto, epDescricaoAtualizarProduto,
//						cbGrupoAtualizar, dcFabricacaoAtualizarProduto, dcVencimentoAtualizarProduto,
//						btnLimparAtualizarProduto, btnAtualizarProduto);
//			}
//		});
		
				// MÉTODO DE PREENCHER DADOS DO GRUPO DA TELA DE ATUALIZAR PRODUTOS BASEADO NO
		// GRUPO ESCOLHIDO
//		cbGrupoAtualizar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (cbGrupoAtualizar.getSelectedIndex() != 0) {
//					ControllerAuxiliar.preencherCamposGrupo(cbGrupoAtualizar, tfNomeGrupoAtualizar,
//							tfCodigoGrupoAtualizar, tfMedidaGrupoAtualizar, cbUnidadeGrupoAtualizar);
//				} else {
//					ControllerAuxiliar.resetarCamposGrupoProduto(tfNomeGrupoAtualizar, tfCodigoGrupoAtualizar,
//							tfMedidaGrupoAtualizar, cbUnidadeGrupoAtualizar);
//				}
//			}
//		});
//		
				// BOTÃO DE ATUALIZAR O PRODUTO
//		btnAtualizarProduto.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if(ctrlPermissao.chamarVerificacao()==true) {
//					ControllerAtualizarProduto cap = new ControllerAtualizarProduto();
//					cap.atualizarProduto(tfIdAtualizarProduto, tfPrecoAtualizarProduto, spQuantidadeAtualizarProduto,
//							epDescricaoAtualizarProduto, cbGrupoAtualizar, dcFabricacaoAtualizarProduto,
//							dcVencimentoAtualizarProduto);
//				}
//		
//			}
//		});
//		
				// BOTÃO DE LIMPAR NA TELA DE ATUALIZAR PRODUTO
//		btnLimparAtualizarProduto.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				ControllerAuxiliar.resetarTodosOsCampos(tfPrecoAtualizarProduto, spQuantidadeAtualizarProduto,
//						epDescricaoAtualizarProduto, dcFabricacaoAtualizarProduto, dcVencimentoAtualizarProduto,
//						cbGrupoAtualizar);
//			}
//		});
		
				// BOTÃO DE RESETAR O ID E DESABILITAR OS CAMPOS DA TELA DE ATUALIZAR PRODUTOS
//		btnResetarAtualizarProduto.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				ControllerAtualizarProduto cap = new ControllerAtualizarProduto();
//				cap.desabilitarAtualizacao(btnBuscarProduto, btnResetarAtualizarProduto, tfIdAtualizarProduto,
//						tfPrecoAtualizarProduto, spQuantidadeAtualizarProduto, epDescricaoAtualizarProduto,
//						cbGrupoAtualizar, dcFabricacaoAtualizarProduto, dcVencimentoAtualizarProduto,
//						btnLimparAtualizarProduto, btnAtualizarProduto);
//			}
//		});


		// ADICIONAR CAMPOS DE DELETAR PRODUTO NESSE PANEL
		JPanel panel_delete_produto = new JPanel();
		tabbedPane_acoes_produto.addTab("Deletar Produto",
				new ImageIcon(getClass().getResource("/sage_icons/cart_minus_round [#1162].png")), panel_delete_produto,
				null);
		panel_delete_produto.setLayout(null);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new TitledBorder(null, "Dados do Produto", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		layeredPane_1.setBounds(20, 71, 583, 221);
		panel_delete_produto.add(layeredPane_1);
		
		JDateChooser dcFabricacaoAtualizarProduto_1 = new JDateChooser();
		dcFabricacaoAtualizarProduto_1.setEnabled(false);
		dcFabricacaoAtualizarProduto_1.setForeground(SystemColor.menu);
		dcFabricacaoAtualizarProduto_1.setBounds(397, 106, 140, 24);
		layeredPane_1.add(dcFabricacaoAtualizarProduto_1);
		
		JDateChooser dcVencimentoAtualizarProduto_1 = new JDateChooser();
		dcVencimentoAtualizarProduto_1.setEnabled(false);
		dcVencimentoAtualizarProduto_1.setForeground(SystemColor.menu);
		dcVencimentoAtualizarProduto_1.setBounds(397, 165, 140, 24);
		layeredPane_1.add(dcVencimentoAtualizarProduto_1);
		
		JLabel lblNewLabel_6 = new JLabel("Nome:");
		lblNewLabel_6.setBounds(48, 33, 189, 20);
		layeredPane_1.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBounds(48, 52, 189, 24);
		layeredPane_1.add(textField);
		
		JLabel lblNewLabel_2_4 = new JLabel("Descrição do Produto:");
		lblNewLabel_2_4.setBounds(48, 85, 189, 20);
		layeredPane_1.add(lblNewLabel_2_4);
		
		JFormattedTextField tfCodigoGrupoAtualizar_1 = new JFormattedTextField();
		tfCodigoGrupoAtualizar_1.setEnabled(false);
		tfCodigoGrupoAtualizar_1.setBounds(247, 52, 100, 24);
		layeredPane_1.add(tfCodigoGrupoAtualizar_1);
		
		JLabel lblCdigo_2 = new JLabel("Código:");
		lblCdigo_2.setBounds(247, 33, 100, 20);
		layeredPane_1.add(lblCdigo_2);
		
		JLabel lblPreo_2 = new JLabel("Preço:");
		lblPreo_2.setBounds(357, 33, 94, 20);
		layeredPane_1.add(lblPreo_2);
		
		JFormattedTextField tfPrecoAtualizarProduto_1 = new JFormattedTextField();
		tfPrecoAtualizarProduto_1.setEnabled(false);
		tfPrecoAtualizarProduto_1.setBounds(357, 52, 94, 24);
		layeredPane_1.add(tfPrecoAtualizarProduto_1);
		
		JComboBox cbGrupoAtualizar_1 = new JComboBox(new Object[]{});
		cbGrupoAtualizar_1.setEnabled(false);
		cbGrupoAtualizar_1.setBounds(247, 106, 140, 24);
		layeredPane_1.add(cbGrupoAtualizar_1);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(247, 165, 76, 24);
		layeredPane_1.add(textField_2);
		
		JLabel lblDataDeFabricao_2 = new JLabel("Data de Fabricação:");
		lblDataDeFabricao_2.setBounds(397, 87, 140, 20);
		layeredPane_1.add(lblDataDeFabricao_2);
		
		JLabel lblPreo_1_1_2 = new JLabel("Data de Vencimento:");
		lblPreo_1_1_2.setBounds(397, 141, 140, 20);
		layeredPane_1.add(lblPreo_1_1_2);
		
		JComboBox cbUnidadeGrupoAtualizar_1 = new JComboBox();
		cbUnidadeGrupoAtualizar_1.setEnabled(false);
		cbUnidadeGrupoAtualizar_1.setBounds(333, 165, 54, 24);
		layeredPane_1.add(cbUnidadeGrupoAtualizar_1);
		
		JEditorPane epDescricaoAtualizarProduto_1 = new JEditorPane();
		epDescricaoAtualizarProduto_1.setEnabled(false);
		epDescricaoAtualizarProduto_1.setBounds(48, 108, 187, 81);
		layeredPane_1.add(epDescricaoAtualizarProduto_1);
		
		JSpinner spQuantidadeAtualizarProduto_1 = new JSpinner();
		spQuantidadeAtualizarProduto_1.setEnabled(false);
		spQuantidadeAtualizarProduto_1.setBounds(473, 52, 64, 24);
		layeredPane_1.add(spQuantidadeAtualizarProduto_1);
		
		JLabel lblNewLabel_2_2_4 = new JLabel("Grupo:");
		lblNewLabel_2_2_4.setBounds(247, 85, 140, 20);
		layeredPane_1.add(lblNewLabel_2_2_4);
		
		JLabel lblNewLabel_2_2_1_2 = new JLabel("Quantidade:");
		lblNewLabel_2_2_1_2.setBounds(473, 33, 64, 20);
		layeredPane_1.add(lblNewLabel_2_2_1_2);
		
		JLabel lblNewLabel_2_2_2_3 = new JLabel("Medida:");
		lblNewLabel_2_2_2_3.setBounds(245, 141, 88, 20);
		layeredPane_1.add(lblNewLabel_2_2_2_3);
		
		JLabel lblNewLabel_2_2_2_1_2 = new JLabel("Unidade:");
		lblNewLabel_2_2_2_1_2.setBounds(306, 134, 54, 20);
		layeredPane_1.add(lblNewLabel_2_2_2_1_2);
		
		JFormattedTextField tfIdAtualizarProduto_1 = new JFormattedTextField();
		tfIdAtualizarProduto_1.setText("0");
		tfIdAtualizarProduto_1.setColumns(10);
		tfIdAtualizarProduto_1.setBounds(393, 36, 86, 23);
		panel_delete_produto.add(tfIdAtualizarProduto_1);
		
		JButton btnBuscarProduto_1 = new JButton("Buscar");
		btnBuscarProduto_1.setBounds(489, 35, 86, 25);
		panel_delete_produto.add(btnBuscarProduto_1);
		
		JLabel lblPesquisarId_2_2_1 = new JLabel("Pesquisar pelo ID:");
		lblPesquisarId_2_2_1.setBounds(393, 11, 182, 25);
		panel_delete_produto.add(lblPesquisarId_2_2_1);
		
		JButton btnResetarAtualizarProduto_1 = new JButton("Resetar");
		btnResetarAtualizarProduto_1.setEnabled(false);
		btnResetarAtualizarProduto_1.setBounds(306, 35, 77, 25);
		panel_delete_produto.add(btnResetarAtualizarProduto_1);
		
		JButton btnLimparAtualizarProduto_1 = new JButton("Limpar");
		btnLimparAtualizarProduto_1.setEnabled(false);
		btnLimparAtualizarProduto_1.setBounds(393, 403, 105, 34);
		panel_delete_produto.add(btnLimparAtualizarProduto_1);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setEnabled(false);
		btnDeletar.setBounds(504, 403, 99, 34);
		panel_delete_produto.add(btnDeletar);
		
		JPanel panel = new JPanel();
		tabbedPane_area.addTab("Área do Grupo", null, panel, null);
		panel.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 618, 525);
		panel.add(tabbedPane);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Cadastrar Grupo", null, panel_1, null);
		panel_1.setLayout(null);

		JLayeredPane layeredPane_4 = new JLayeredPane();
		layeredPane_4.setBorder(new TitledBorder(null, "Dados do grupo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		layeredPane_4.setBounds(26, 73, 557, 225);
		panel_1.add(layeredPane_4);

		JLabel lblNewLabel_7 = new JLabel("Nome");
		lblNewLabel_7.setBounds(28, 33, 227, 14);
		layeredPane_4.add(lblNewLabel_7);

		textField_3 = new JTextField();
		textField_3.setBounds(28, 58, 227, 26);
		layeredPane_4.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_7_1 = new JLabel("Quantidade Máxima");
		lblNewLabel_7_1.setBounds(265, 33, 127, 14);
		layeredPane_4.add(lblNewLabel_7_1);

		JSpinner spinner = new JSpinner();
		spinner.setBounds(265, 58, 127, 26);
		layeredPane_4.add(spinner);

		JLabel lblNewLabel_7_1_1 = new JLabel("Quantidade Mínima");
		lblNewLabel_7_1_1.setBounds(402, 33, 127, 14);
		layeredPane_4.add(lblNewLabel_7_1_1);

		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(402, 58, 127, 26);
		layeredPane_4.add(spinner_1);

		JLabel lblNewLabel_7_2 = new JLabel("Descrição");
		lblNewLabel_7_2.setBounds(28, 95, 227, 14);
		layeredPane_4.add(lblNewLabel_7_2);

		JLabel lblNewLabel_7_2_1 = new JLabel("Categoria");
		lblNewLabel_7_2_1.setBounds(265, 95, 127, 14);
		layeredPane_4.add(lblNewLabel_7_2_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"grupo 1", "grupo 2"}));
		comboBox.setBounds(265, 115, 127, 26);
		layeredPane_4.add(comboBox);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 115, 227, 87);
		layeredPane_4.add(scrollPane);

		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);

		JButton bt_limpar_af_2_1 = new JButton("Limpar");
		bt_limpar_af_2_1.setBounds(389, 435, 105, 34);
		panel_1.add(bt_limpar_af_2_1);

		JButton bt_atualizar_af_2_1 = new JButton("Cadastrar");
		bt_atualizar_af_2_1.setBounds(504, 435, 99, 34);
		panel_1.add(bt_atualizar_af_2_1);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Atualizar Grupo", null, panel_2, null);
		panel_2.setLayout(null);

		JLayeredPane layeredPane_4_1 = new JLayeredPane();
		layeredPane_4_1.setBorder(new TitledBorder(null, "Dados do grupo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		layeredPane_4_1.setBounds(26, 75, 557, 225);
		panel_2.add(layeredPane_4_1);

		JLabel lblNewLabel_7_3 = new JLabel("Nome");
		lblNewLabel_7_3.setBounds(28, 33, 227, 14);
		layeredPane_4_1.add(lblNewLabel_7_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(28, 58, 227, 26);
		layeredPane_4_1.add(textField_4);

		JLabel lblNewLabel_7_1_2 = new JLabel("Quantidade Máxima");
		lblNewLabel_7_1_2.setBounds(265, 33, 127, 14);
		layeredPane_4_1.add(lblNewLabel_7_1_2);

		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(265, 58, 127, 26);
		layeredPane_4_1.add(spinner_2);

		JLabel lblNewLabel_7_1_1_1 = new JLabel("Quantidade Mínima");
		lblNewLabel_7_1_1_1.setBounds(402, 33, 127, 14);
		layeredPane_4_1.add(lblNewLabel_7_1_1_1);

		JSpinner spinner_1_1 = new JSpinner();
		spinner_1_1.setBounds(402, 58, 127, 26);
		layeredPane_4_1.add(spinner_1_1);

		JLabel lblNewLabel_7_2_2 = new JLabel("Descrição");
		lblNewLabel_7_2_2.setBounds(28, 95, 227, 14);
		layeredPane_4_1.add(lblNewLabel_7_2_2);

		JLabel lblNewLabel_7_2_1_1 = new JLabel("Categoria");
		lblNewLabel_7_2_1_1.setBounds(265, 95, 127, 14);
		layeredPane_4_1.add(lblNewLabel_7_2_1_1);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(265, 115, 127, 26);
		layeredPane_4_1.add(comboBox_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(28, 115, 225, 85);
		layeredPane_4_1.add(scrollPane_1);

		JTextPane textPane_1 = new JTextPane();
		scrollPane_1.setViewportView(textPane_1);

		JButton bt_atualizar_af_2_1_1 = new JButton("Atualizar");
		bt_atualizar_af_2_1_1.setBounds(504, 414, 99, 34);
		panel_2.add(bt_atualizar_af_2_1_1);

		JButton bt_limpar_af_2_1_1 = new JButton("Limpar");
		bt_limpar_af_2_1_1.setBounds(389, 414, 105, 34);
		panel_2.add(bt_limpar_af_2_1_1);

		JButton btnResetarAtualizarFornecedor_1 = new JButton("Resetar");
		btnResetarAtualizarFornecedor_1.setEnabled(false);
		btnResetarAtualizarFornecedor_1.setBounds(314, 36, 77, 25);
		panel_2.add(btnResetarAtualizarFornecedor_1);

		JFormattedTextField tfIdAtualizarFornecedor_1 = new JFormattedTextField();
		tfIdAtualizarFornecedor_1.setText("0");
		tfIdAtualizarFornecedor_1.setColumns(10);
		tfIdAtualizarFornecedor_1.setBounds(401, 37, 86, 23);
		panel_2.add(tfIdAtualizarFornecedor_1);

		JButton btnBuscarFornecedor_1 = new JButton("Buscar");
		btnBuscarFornecedor_1.setBounds(497, 36, 86, 25);
		panel_2.add(btnBuscarFornecedor_1);

		JLabel lblPesquisarId_2_3 = new JLabel("Pesquisar pelo ID:");
		lblPesquisarId_2_3.setBounds(401, 11, 182, 25);
		panel_2.add(lblPesquisarId_2_3);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Deletar Grupo", null, panel_3, null);
		panel_3.setLayout(null);

		JLayeredPane layeredPane_4_2 = new JLayeredPane();
		layeredPane_4_2.setBorder(new TitledBorder(null, "Dados do grupo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		layeredPane_4_2.setBounds(26, 70, 557, 225);
		panel_3.add(layeredPane_4_2);

		JLabel lblNewLabel_7_4 = new JLabel("Nome");
		lblNewLabel_7_4.setBounds(28, 33, 227, 14);
		layeredPane_4_2.add(lblNewLabel_7_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(28, 58, 227, 26);
		layeredPane_4_2.add(textField_5);

		JLabel lblNewLabel_7_1_3 = new JLabel("Quantidade Máxima");
		lblNewLabel_7_1_3.setBounds(265, 33, 127, 14);
		layeredPane_4_2.add(lblNewLabel_7_1_3);

		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(265, 58, 127, 26);
		layeredPane_4_2.add(spinner_3);

		JLabel lblNewLabel_7_1_1_2 = new JLabel("Quantidade Mínima");
		lblNewLabel_7_1_1_2.setBounds(402, 33, 127, 14);
		layeredPane_4_2.add(lblNewLabel_7_1_1_2);

		JSpinner spinner_1_2 = new JSpinner();
		spinner_1_2.setBounds(402, 58, 127, 26);
		layeredPane_4_2.add(spinner_1_2);

		JLabel lblNewLabel_7_2_3 = new JLabel("Descrição");
		lblNewLabel_7_2_3.setBounds(28, 95, 227, 14);
		layeredPane_4_2.add(lblNewLabel_7_2_3);

		JLabel lblNewLabel_7_2_1_2 = new JLabel("Categoria");
		lblNewLabel_7_2_1_2.setBounds(265, 95, 127, 14);
		layeredPane_4_2.add(lblNewLabel_7_2_1_2);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(265, 115, 127, 26);
		layeredPane_4_2.add(comboBox_2);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(28, 115, 225, 85);
		layeredPane_4_2.add(scrollPane_2);

		JTextPane textPane_2 = new JTextPane();
		scrollPane_2.setViewportView(textPane_2);

		JButton bt_atualizar_af_2_1_2 = new JButton("Deletar");
		bt_atualizar_af_2_1_2.setBounds(504, 417, 99, 34);
		panel_3.add(bt_atualizar_af_2_1_2);

		JButton bt_limpar_af_2_1_2 = new JButton("Limpar");
		bt_limpar_af_2_1_2.setBounds(389, 417, 105, 34);
		panel_3.add(bt_limpar_af_2_1_2);

		JButton btnResetarAtualizarFornecedor_2 = new JButton("Resetar");
		btnResetarAtualizarFornecedor_2.setEnabled(false);
		btnResetarAtualizarFornecedor_2.setBounds(314, 34, 77, 25);
		panel_3.add(btnResetarAtualizarFornecedor_2);

		JFormattedTextField tfIdAtualizarFornecedor_2 = new JFormattedTextField();
		tfIdAtualizarFornecedor_2.setText("0");
		tfIdAtualizarFornecedor_2.setColumns(10);
		tfIdAtualizarFornecedor_2.setBounds(401, 35, 86, 23);
		panel_3.add(tfIdAtualizarFornecedor_2);

		JButton btnBuscarFornecedor_2 = new JButton("Buscar");
		btnBuscarFornecedor_2.setBounds(497, 34, 86, 25);
		panel_3.add(btnBuscarFornecedor_2);

		JLabel lblPesquisarId_2_4 = new JLabel("Pesquisar pelo ID:");
		lblPesquisarId_2_4.setBounds(401, 9, 182, 25);
		panel_3.add(lblPesquisarId_2_4);

		JTabbedPane tabbedPane_listagem = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_listagem.setBounds(652, 49, 548, 475);
		panel_superior.add(tabbedPane_listagem);

		JPanel panel_listar_movimentacoes = new JPanel();
		tabbedPane_listagem.addTab("Produtos", null, panel_listar_movimentacoes, null);
		panel_listar_movimentacoes.setLayout(null);
		
		JPanel panel_listar_p_movimentacoes = new JPanel();
		tabbedPane_listagem.addTab("Movimentações", null, panel_listar_p_movimentacoes, null);
		panel_listar_p_movimentacoes.setLayout(null);

		JScrollPane scrollPane_m = new JScrollPane();
		scrollPane_m.setBounds(10, 11, 517, 425);
		panel_listar_movimentacoes.add(scrollPane_m);
		
		JPanel panel_listar_supervisores = new JPanel();
		tabbedPane_listagem.addTab("Supervisores", null, panel_listar_supervisores, null);
		panel_listar_supervisores.setLayout(null);
		
		JPanel panel_listar_registros = new JPanel();
		panel_listar_registros.setLayout(null);
		tabbedPane_listagem.addTab("Supervisores - registros", null, panel_listar_registros, null);

		
		JScrollPane scrollPane_supervisor = new JScrollPane();
		scrollPane_supervisor.setBounds(10, 11, 517, 425);
		panel_listar_supervisores.add(scrollPane_supervisor);
		table_supervisores = new JTable();
		scrollPane_supervisor.setViewportView(table_supervisores);
		
		
		JScrollPane scrollPane_p_movimentacoes = new JScrollPane();
		scrollPane_p_movimentacoes.setBounds(10, 11, 517, 425);
		panel_listar_p_movimentacoes.add(scrollPane_p_movimentacoes);
		
		
		table_produtos = new JTable();
		table_movimentacoes = new JTable();
		scrollPane_p_movimentacoes.setViewportView(table_movimentacoes);
		scrollPane_m.setViewportView(table_produtos);

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

		JScrollPane scrollPane_r = new JScrollPane();
		scrollPane_r.setBounds(10, 11, 517, 425);
		panel_listar_registros.add(scrollPane_r);

		table_registros_supervisores = new JTable();
		// ControllerTableModels.popularTableRegistrosGerente(table_registros_supervisores_supervisores);
		scrollPane_r.setViewportView(table_registros_supervisores);

		JSeparator separator_vertical = new JSeparator();
		separator_vertical.setOrientation(SwingConstants.VERTICAL);
		separator_vertical.setBounds(633, 0, 11, 553);
		panel_superior.add(separator_vertical);

		JButton btn_atualizar_tabelas_superior = new JButton("Atualizar listas");
		btn_atualizar_tabelas_superior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctb = new ControllerTableModels(table_registros_supervisores, table_fornecedores, table_produtos,
						table_movimentacoes, table_supervisores);
				new Atualizar().start();
			}
		});
		btn_atualizar_tabelas_superior.setBounds(652, 11, 125, 27);
		panel_superior.add(btn_atualizar_tabelas_superior);

		progressBar_tabelas_superior = new JProgressBar();
		progressBar_tabelas_superior.setBounds(799, 21, 385, 10);
		panel_superior.add(progressBar_tabelas_superior);
		
		new ControllerTableModels(table_registros_supervisores, table_fornecedores, table_produtos, table_movimentacoes, table_supervisores);

		// ControllerTableModels.popularTabelaProdutos(table_produtos);
		// new ControllerTableModels(table_registros_supervisores_supervisores, table_gerentes,
		// table_fornecedores, table_produtos, table_movimentacoes);
		// setLocationRelativeTo(null);

		// ----------ActionListeners de Cadastrar o Produto
		// MÉTODO DE PREENCHER OS DADOS DO GRUPO DA TELA DE CADASTRAR PRODUTOS BASEADO
		// NO GRUPO ESCOLHIDO
//		cbGrupoCadastrar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (cbGrupoCadastrar.getSelectedIndex() != 0) {
//					ControllerAuxiliar.preencherCamposGrupo(cbGrupoCadastrar, tfNomeGrupoCadastrar,
//							tfCodigoGrupoCadastrar, tfMedidaGrupoCadastrar, cbUnidadeGrupoCadastrar);
//				} else {
//					ControllerAuxiliar.resetarCamposGrupoProduto(tfNomeGrupoCadastrar, tfCodigoGrupoCadastrar,
//							tfMedidaGrupoCadastrar, cbUnidadeGrupoCadastrar);
//				}
//			}
//		});

		// MÉTODO QUE PEGA OS DADOS DOS INPUTS E CHAMA O CONTROLLER PARA CADASTRAR O
		// PRODUTO
//		bt_atualizar_af_2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				if(ctrlPermissao.chamarVerificacao()==true) {
//					ControllerValidationProduto cvp = new ControllerValidationProduto();
//					cvp.enviarDadosParaCadastrar(tfPrecoCadastrarProduto, spQuantidadeCadastrarProduto,
//							epDescricaoCadastrarProduto, dcFabricacaoCadastrarProduto, dcVencimentoCadastrarProduto,
//							cbGrupoCadastrar);
//				}
//
//			}
//		});

		// MÉTODO DE LIMPAR OS DADOS DA TELA DE CADASTRAR PRODUTOS

//		bt_limpar_af_2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				ControllerAuxiliar.resetarTodosOsCampos(tfPrecoCadastrarProduto, spQuantidadeCadastrarProduto,
//						epDescricaoCadastrarProduto, dcFabricacaoCadastrarProduto, dcVencimentoCadastrarProduto,
//						cbGrupoCadastrar);
//			}
//		});

//		bt_limpar_af_2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				ControllerAuxiliar.resetarTodosOsCampos(tfPrecoCadastrarProduto, spQuantidadeCadastrarProduto,
//						epDescricaoCadastrarProduto, dcFabricacaoCadastrarProduto, dcVencimentoCadastrarProduto,
//						cbGrupoCadastrar);
//			}
//		});


		// ------------------ActionListeners de Cadastrar Fornecedores

		// ESSE BOTÃO CHAMA O MÉTODO DE CADASTRAR O FORNECEDOR
		btnCadastrarFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ctrlPermissao.chamarVerificacao()==true) {
					ControllerValidationFornecedor cvf = new ControllerValidationFornecedor();
					cvf.enviarDadosParaCadastro(tfNomeCadastrarFornecedor, tfCnpjCadastrarFornecedor,
							tfRazaoSocialCadastrarFornecedor, tfTelefoneCadastrarFornecedor, tfEmailCadastrarFornecedor,
							tfCepCadastrarFornecedor, cbEstadoCadastrarFornecedor, tfCidadeCadastrarFornecedor,
							tfBairroCadastrarFornecedor, tfNumeroCadastrarFornecedor, tfLogradouroCadastrarFornecedor,
							tfComplementoCadastrarFornecedor);
				}

			}
		});

		// ESSE BOTÃO CHAMA O MÉTODO DE LIMPAR OS DADOS DO FORNECEDOR NA SUA VIEW DE
		// CADASTRO
		btnLimparFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerAuxiliar.limparCamposFornecedor(tfNomeCadastrarFornecedor, tfCnpjCadastrarFornecedor,
						tfRazaoSocialCadastrarFornecedor, tfTelefoneCadastrarFornecedor, tfEmailCadastrarFornecedor,
						tfCepCadastrarFornecedor, cbEstadoCadastrarFornecedor, tfCidadeCadastrarFornecedor,
						tfBairroCadastrarFornecedor, tfNumeroCadastrarFornecedor, tfLogradouroCadastrarFornecedor,
						tfComplementoCadastrarFornecedor);
			}
		});

		// ------------------ActionListeners de Atualizar Fornecedores

		// ESSE BOTÃO CHAMA O MÉTODO DE BUSCAR O FORNECEDOR PELO ID
		btnBuscarFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerAtualizarFornecedor caf = new ControllerAtualizarFornecedor();
				caf.buscarFornecedor(btnBuscarFornecedor, btnResetarAtualizarFornecedor, tfIdAtualizarFornecedor,
						tfNomeAtualizarFornecedor, tfCnpjAtualizarFornecedor, tfRazaoSocialAtualizarFornecedor,
						tfTelefoneAtualizarFornecedor, tfEmailAtualizarFornecedor, tfCepAtualizarFornecedor,
						cbEstadoAtualizarFornecedor, tfCidadeAtualizarFornecedor, tfBairroAtualizarFornecedor,
						tfNumeroAtualizarFornecedor, tfLogradouroAtualizarFornecedor, tfComplementoAtualizarFornecedor,
						btnLimparAtualizarFornecedor, btnAtualizarFornecedor);
			}
		});

		// ESSE BOTÃO CHAMA O MÉTODO DE RESETAR OS INPUTS DA VIEW DE ATUALIZAR O
		// FORNECEDOR
		btnResetarAtualizarFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerAtualizarFornecedor caf = new ControllerAtualizarFornecedor();
				caf.desabilitarAtualizacaoFornecedor(btnBuscarFornecedor, btnResetarAtualizarFornecedor,
						tfIdAtualizarFornecedor, tfNomeAtualizarFornecedor, tfCnpjAtualizarFornecedor,
						tfRazaoSocialAtualizarFornecedor, tfTelefoneAtualizarFornecedor, tfEmailAtualizarFornecedor,
						tfCepAtualizarFornecedor, cbEstadoAtualizarFornecedor, tfCidadeAtualizarFornecedor,
						tfBairroAtualizarFornecedor, tfNumeroAtualizarFornecedor, tfLogradouroAtualizarFornecedor,
						tfComplementoAtualizarFornecedor, btnLimparAtualizarFornecedor, btnAtualizarFornecedor);
			}
		});

		// ESSE BOTÃO CHAMA O MÉTODO DE LIMPAR OS INPUTS NA TELA DE ATUALIZAR O
		// FORNECEDOR
		btnLimparAtualizarFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerAuxiliar.limparCamposFornecedor(tfNomeAtualizarFornecedor, tfCnpjAtualizarFornecedor,
						tfRazaoSocialAtualizarFornecedor, tfTelefoneAtualizarFornecedor, tfEmailAtualizarFornecedor,
						tfCepAtualizarFornecedor, cbEstadoAtualizarFornecedor, tfCidadeAtualizarFornecedor,
						tfBairroAtualizarFornecedor, tfNumeroAtualizarFornecedor, tfLogradouroAtualizarFornecedor,
						tfComplementoAtualizarFornecedor);
			}
		});

		// ESSE BOTÃO CHAMA O MÉTODO DE ATUALIZAR O FORNECEDOR
		btnAtualizarFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ctrlPermissao.chamarVerificacao()==true) {
					ControllerAtualizarFornecedor caf = new ControllerAtualizarFornecedor();
					caf.atualizarFornecedor(tfIdAtualizarFornecedor, tfNomeAtualizarFornecedor, tfCnpjAtualizarFornecedor,
							tfRazaoSocialAtualizarFornecedor, tfTelefoneAtualizarFornecedor, tfEmailAtualizarFornecedor,
							tfCepAtualizarFornecedor, cbEstadoAtualizarFornecedor, tfCidadeAtualizarFornecedor,
							tfBairroAtualizarFornecedor, tfNumeroAtualizarFornecedor, tfLogradouroAtualizarFornecedor,
							tfComplementoAtualizarFornecedor);
				}

			}
		});

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
				if(ctrlPermissao.chamarVerificacao()==true) {
					ctrlSuper.mostrarDadosDoSupervisor(id_pesquisa_deleteSupervisor, cpf_supervisor_deleteSupervisor,
							login_supervisor_deleteSupervisor);
				}

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
				if(ctrlPermissao.chamarVerificacao()==true) {
					ctrlSuper.excluirContaSupervisor(id_pesquisa_deleteSupervisor, cpf_gerente_deleteSupervisor.getText(),
							senha_gerente_deleteSupervisor.getText());

					ctrlAux.limparCampos(cpf_gerente_deleteSupervisor, senha_gerente_deleteSupervisor,
							cpf_supervisor_deleteSupervisor, id_pesquisa_deleteSupervisor,
							login_supervisor_deleteSupervisor, senha_gerente_deleteSupervisor);
				}
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
				if(ctrlPermissao.chamarVerificacao()==true) {
					ctrlSuper.cadastrarSupervisor(cpf_supervisor_criarSupervisor.getText(),
							senha_supervisor_criarSupervisor.getText(),
							confirmacaoSenha_supervisor_criarSupervisor.getText(),
							login_supervisor_criarSupervisor.getText(), login_supervisor_criarSupervisor,
							cpf_supervisor_criarSupervisor, senha_supervisor_criarSupervisor,
							confirmacaoSenha_supervisor_criarSupervisor);
				}

			}
		});

		// MÉTODO LIMPAR CAMPOS DO PAINEL DE ATUALIZAÇÃO DO SUPERVISOR

		botao_limpar_dados_AtualizacaoSupervisor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ctrlAux.limparCampos(cpf_gerente_AtualizacaoSupervisor, id_pesquisa_supervisor_AtualizacaoSupervisor,
						nova_senha_supervisor_AtualizacaoSupervisor, senha_gerente_AtualizacaoSupervisor,
						cpf_atual_supervisor_AtualizacaoSupervisor,
						login_atual_supervisor_AtualizacaoSupervisor, novo_login_supervisor_AtualizacaoSupervisor);

			}
		});

		// MÉTODO QUE MOSTRAr OS DADOS DO SUPERVISOR NO PAINEL DE ATUALIZAÇÃO DE
		// SUPERVISOR

		buscar_supervisor_AtualizacaoSupervisor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ctrlPermissao.chamarVerificacao()==true) {
					ctrlSuper.mostrarDadosDoSupervisor(id_pesquisa_supervisor_AtualizacaoSupervisor,
							cpf_atual_supervisor_AtualizacaoSupervisor, login_atual_supervisor_AtualizacaoSupervisor);
				}

			}
		});

		// MÉTODO DE ATUALIZAÇÃO DE SENHA DO SUPERVISOR DO PAINEL DE ATUALIZAÇÃO DO
		// SUPERVISOR

		btn_atualizar_senha_AtualizacaoSupervisor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ctrlPermissao.chamarVerificacao()==true) {
					if (ctrlSuper.atualizarSupervisorSenha(id_pesquisa_supervisor_AtualizacaoSupervisor,
							nova_senha_supervisor_AtualizacaoSupervisor.getText(), cpf_gerente_AtualizacaoSupervisor,
							senha_gerente_AtualizacaoSupervisor) == true) {

						ctrlAux.limparCampos(cpf_gerente_AtualizacaoSupervisor,
								id_pesquisa_supervisor_AtualizacaoSupervisor, nova_senha_supervisor_AtualizacaoSupervisor,
								senha_gerente_AtualizacaoSupervisor,
								cpf_atual_supervisor_AtualizacaoSupervisor, login_atual_supervisor_AtualizacaoSupervisor,
								novo_login_supervisor_AtualizacaoSupervisor);
					}
				}
			}
		});
		
		// MÉTODO DE ATUALIZAÇÃO DO LOGIN DO SUPERVISOR
		btn_atualizar_login_AtualizacaoSupervisor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ctrlPermissao.chamarVerificacao()==true) {
					if (ctrlSuper.atualizarSupervisorLogin(id_pesquisa_supervisor_AtualizacaoSupervisor,
							novo_login_supervisor_AtualizacaoSupervisor.getText(), cpf_gerente_AtualizacaoSupervisor,
							senha_gerente_AtualizacaoSupervisor) == true) {

						ctrlAux.limparCampos(cpf_gerente_AtualizacaoSupervisor,
								id_pesquisa_supervisor_AtualizacaoSupervisor, nova_senha_supervisor_AtualizacaoSupervisor,
								senha_gerente_AtualizacaoSupervisor,
								cpf_atual_supervisor_AtualizacaoSupervisor, login_atual_supervisor_AtualizacaoSupervisor,
								novo_login_supervisor_AtualizacaoSupervisor);
					}
					
				}
		
			}
		});

		// MÉTODO DE ATUALIZAÇÃO DE TODOS OS DADOS DO SUPERVISOR
		btn_atualizar_tudo_AtualizacaoSupervisor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(ctrlPermissao.chamarVerificacao()==true) {
					if (ctrlSuper.atualizarSupervisor(
							nova_senha_supervisor_AtualizacaoSupervisor.getText(),
							id_pesquisa_supervisor_AtualizacaoSupervisor,
							novo_login_supervisor_AtualizacaoSupervisor.getText(), cpf_gerente_AtualizacaoSupervisor,
							senha_gerente_AtualizacaoSupervisor) == true) {

						ctrlAux.limparCampos(cpf_gerente_AtualizacaoSupervisor,
								id_pesquisa_supervisor_AtualizacaoSupervisor, nova_senha_supervisor_AtualizacaoSupervisor,
								senha_gerente_AtualizacaoSupervisor,
								cpf_atual_supervisor_AtualizacaoSupervisor, login_atual_supervisor_AtualizacaoSupervisor,
								novo_login_supervisor_AtualizacaoSupervisor);

					}

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

	}

	public class Atualizar extends Thread {
		public void run() {
			try {
				progressBar_tabelas_superior.setStringPainted(true);
				while (progressBar_tabelas_superior.getValue() < 100) {
					sleep(5);
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