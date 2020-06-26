﻿package br.com.projeto.estoque.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import org.apache.commons.lang3.StringUtils;

import com.toedter.calendar.JDateChooser;

import br.com.projeto.estoque.model.Categoria;
import br.com.projeto.estoque.model.Fornecedor;
import br.com.projeto.estoque.model.Grupo;
import br.com.projeto.estoque.model.Produto;
import br.com.projeto.estoque.model.Status;
import br.com.projeto.estoque.util.GerenteAtual;
import br.com.projeto.estoque.util.JPAUtil;
import br.com.projeto.estoque.util.SupervisorAtual;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class ControllerAuxiliar {
	private static EntityManager manager;

	public void setarLoginUsuarioAtual_na_telaPrincipal(JLabel usuario_atual_cadastrarSupervisor,
			JLabel usuario_atual_atualizar_gerente, JLabel usuario_atual_deletarSupervisor) {
		if (GerenteAtual.getGerente() != null) {
			usuario_atual_cadastrarSupervisor.setText(GerenteAtual.getGerente().getLogin());
			usuario_atual_atualizar_gerente.setText(GerenteAtual.getGerente().getLogin());
			usuario_atual_deletarSupervisor.setText(GerenteAtual.getGerente().getLogin());
		} else {
			usuario_atual_cadastrarSupervisor.setText(SupervisorAtual.getSupervisor().getLogin());
			usuario_atual_atualizar_gerente.setText(SupervisorAtual.getSupervisor().getLogin());
			usuario_atual_deletarSupervisor.setText(SupervisorAtual.getSupervisor().getLogin());
		}
	}

	public void limparCampos(JFormattedTextField campoJformattedTextField, JPasswordField campoJpasswordField,
			JPasswordField campoJpasswordField2, JFormattedTextField campoJformattedTextField2) {
		campoJformattedTextField.setText("");
		campoJpasswordField.setText("");
		campoJpasswordField2.setText("");
		campoJformattedTextField2.setText("");
	}

	public static boolean verificarValorNull(JFormattedTextField valor) {
		if (valor.equals("")) {
			return true;
		} else {
			return false;
		}
	}

	public void limparCampos(JFormattedTextField campoFormattedTextField, JPasswordField campoJPasswordField,
			JFormattedTextField campoFormattedTextField2, JFormattedTextField campoFormattedTextField3,
			JFormattedTextField campoFormattedTextField4, JPasswordField campoJPasswordField2) {

		campoFormattedTextField.setText("");
		campoJPasswordField.setText("");
		campoJPasswordField2.setText("");
		campoFormattedTextField2.setText("");
		campoFormattedTextField3.setText("");
		campoFormattedTextField4.setText("");
	}

	// MÉTODO DESTINADO EXCLUSIVAMENTE PARA O PAINEL DE ATUALIZAÇÃO DOS SUPERVISORES
	public void limparCampos(JFormattedTextField cpf_gerente_AtualizacaoSupervisor,
			JFormattedTextField id_pesquisa_supervisor_AtualizacaoSupervisor,
			JPasswordField nova_senha_supervisor_AtualizacaoSupervisor,
			JPasswordField senha_gerente_AtualizacaoSupervisor,

			JFormattedTextField cpf_atual_supervisor_AtualizacaoSupervisor,
			JFormattedTextField login_atual_supervisor_AtualizacaoSupervisor,
			JFormattedTextField novo_login_supervisor_AtualizacaoSupervisor) {

		cpf_gerente_AtualizacaoSupervisor.setText("");
		id_pesquisa_supervisor_AtualizacaoSupervisor.setText("");
		nova_senha_supervisor_AtualizacaoSupervisor.setText("");
		senha_gerente_AtualizacaoSupervisor.setText("");

		cpf_atual_supervisor_AtualizacaoSupervisor.setText("");
		login_atual_supervisor_AtualizacaoSupervisor.setText("");
		novo_login_supervisor_AtualizacaoSupervisor.setText("");

	}

	// Esse método confere se todos os dados das views de Cadastrar e Atualizar
	// Fornecedores estão preenchidos
	public static boolean conferirDadosFornecedor(JTextField tfNome, JFormattedTextField tfCnpj,
			JTextField tfRazaoSocial, JTextField tfTelefone, JTextField tfEmail, JFormattedTextField tfCep,
			JComboBox cbEstado, JTextField tfCidade, JTextField tfBairro, JTextField tfNumero,
			JTextField tfLogradouro) {
		if (StringUtils.isBlank(tfNome.getText()) || StringUtils.isBlank(tfCnpj.getText())
				|| StringUtils.isBlank(tfRazaoSocial.getText()) || StringUtils.isBlank(tfTelefone.getText())
				|| StringUtils.isBlank(tfEmail.getText()) || StringUtils.isBlank(tfCep.getText())
				|| (cbEstado.getSelectedIndex() < 0 || StringUtils.isBlank(tfCidade.getText())
						|| StringUtils.isBlank(tfBairro.getText()) || StringUtils.isBlank(tfNumero.getText())
						|| StringUtils.isBlank(tfLogradouro.getText()))) {
			JOptionPane.showMessageDialog(null, "Algum dos campos está vazio! Cheque e tente novamente.", "Campo vazio",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	// Esse método limpa os dados das views de Cadastrar e Atualizar Fornecedores
	public static void limparCamposFornecedor(JTextField tfNome, JFormattedTextField tfCnpj, JTextField tfRazaoSocial,
			JTextField tfTelefone, JTextField tfEmail, JFormattedTextField tfCep, JComboBox cbEstado,
			JTextField tfCidade, JTextField tfBairro, JTextField tfNumero, JTextField tfLogradouro,
			JTextField tfComplemento) {
		tfNome.setText("");
		tfCnpj.setText("");
		tfRazaoSocial.setText("");
		tfTelefone.setText("");
		tfEmail.setText("");
		tfCep.setText("");
		cbEstado.setSelectedIndex(0);
		tfCidade.setText("");
		tfBairro.setText("");
		tfNumero.setText("");
		tfLogradouro.setText("");
		tfComplemento.setText("");
	}

	// Preenche os campos das views de Cadastrar e Atualizar Produtos, baseado no
	// grupo escolhido
	public static void preencherCamposGrupo(JComboBox cbGrupo, JTextField tfNome, JTextField tfCodigo,
			JTextField tfQtdMin, JTextField tfSubtotal, JTextField tfQtdMax) {
		manager = new JPAUtil().getEntityManager();

		Query query = manager.createQuery("select g from Grupo g where g.nome=:nomeGrupo");
		query.setParameter("nomeGrupo", cbGrupo.getSelectedItem().toString());
		Grupo grupo = (Grupo) query.getSingleResult();
		tfNome.setText(grupo.getNome());
		tfCodigo.setText(grupo.getCodigo());
		tfQtdMin.setText(grupo.getQtdMinima() + "");
		tfSubtotal.setText(grupo.getSubtotal() + "");
		tfQtdMax.setText(grupo.getQtdMaxima() + "");

		manager.close();
	}

	// Preenche os campos do Produto e seu Grupo na view de Movimentação
	public static void preencherCamposProdutoEGrupo(JComboBox cbProduto, JTextField tfQtdAtual, JTextField tfQtdMin,
			JTextField tfSubtotal, JTextField tfQtdMax) {

		manager = new JPAUtil().getEntityManager();
		Query query = manager
				.createQuery("select p from Produto p where p.descricao=:descricaoProduto and p.status = 'ATIVO'");
		query.setParameter("descricaoProduto", cbProduto.getSelectedItem().toString());
		Produto produto = (Produto) query.getSingleResult();
		tfQtdAtual.setText(produto.getQuantidade() + "");
		tfQtdMin.setText(produto.getGrupo().getQtdMinima() + "");
		tfSubtotal.setText(produto.getGrupo().getSubtotal() + "");
		tfQtdMax.setText(produto.getGrupo().getQtdMaxima() + "");
		manager.close();
	}

	// Esse método reseta todos os campos referentes ao grupo. É chamado quando o
	// usuário não seleciona nenhum grupo nas telas de Cadastrar e Atualizar
	// Produtos
	public static void resetarCamposGrupoProduto(JTextField tfNome, JTextField tfCodigo, JTextField tfQtdMin,
			JTextField tfSubtotal, JTextField tfQtdMax) {
		tfNome.setText("");
		tfCodigo.setText("");
		tfQtdMin.setText("");
		tfSubtotal.setText("");
		tfQtdMax.setText("");
	}

	// Esse método reseta os campos do Produto e do Grupo na interface das
	// Movimentações
	public static void resetarCamposProdutoEGrupo(JTextField tfQtdAtual, JTextField tfQtdMin, JTextField tfSubtotal,
			JTextField tfQtdMax) {
		tfQtdAtual.setText("");
		tfQtdMin.setText("");
		tfSubtotal.setText("");
		tfQtdMax.setText("");
	}

	// Esse método checa se existe algum campo vazio nas views de Cadastrar e
	// Atualizar os Produtos
	public static boolean dadosConferem(JFormattedTextField tfPreco, JSpinner spQuantidade, JEditorPane epDescricao,
			JDateChooser dcDataFabricacao, JDateChooser dcDataVencimento, JComboBox cbGrupo, JTextField tfMedida,
			JComboBox cbUnidade) {
		if (StringUtils.isBlank(tfPreco.getText()) || StringUtils.isBlank(spQuantidade.getValue().toString())
				|| StringUtils.isBlank(epDescricao.getText()) || cbGrupo.getSelectedIndex() == 0
				|| StringUtils.isBlank(tfMedida.getText()) || cbUnidade.getSelectedIndex() < 0) {
			JOptionPane.showMessageDialog(null, "Algum dos campos está vazio! Preencha e tente novamente.",
					"Campo Vazio", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (dcDataFabricacao.getDate() == null) {
			JOptionPane.showMessageDialog(null, "A data de fabricação inserida é inválida!",
					"Data de fabricação inválida", JOptionPane.ERROR_MESSAGE);
			dcDataFabricacao.transferFocus();
			return false;
		} else if (dcDataVencimento.getDate() == null) {
			JOptionPane.showMessageDialog(null, "A data de vencimento inserida é inválida!",
					"Data de vencimento inválida", JOptionPane.ERROR_MESSAGE);
			dcDataVencimento.transferFocus();
			return false;
		} else {
			return true;
		}
	}

	// Esse método reseta todos os campos, e coloca a JComboBox do grupo para não
	// selecionar nenhum, consequentemente chamando
	// o método de resetar os campos do grupo nas interfaces de Cadastrar e
	// Atualizar Produtos
	public static void resetarTodosOsCampos(JFormattedTextField tfPreco, JSpinner spQuantidade, JEditorPane epDescricao,
			JDateChooser dcDataFabricacao, JDateChooser dcDataVencimento, JComboBox cbGrupo, JTextField tfMedida,
			JComboBox cbUnidade) {
		tfPreco.setText("");
		spQuantidade.setValue(0);
		epDescricao.setText("");
		dcDataFabricacao.setDate(null);
		dcDataVencimento.setDate(null);
		cbGrupo.setSelectedIndex(0);
		tfMedida.setText("");
		cbUnidade.setSelectedIndex(0);
	}

	// Preenche as Categorias de uma JComboBox
	public static List<String> preencherCategorias() {
		manager = new JPAUtil().getEntityManager();
		Query query = manager.createQuery("select nome from Categoria c");
		List<String> categorias = query.getResultList();
		manager.close();
		return categorias;
	}

	// Preenche os Grupos de uma JComboBox
	public static List<String> preencherGrupos() {
		manager = new JPAUtil().getEntityManager();
		Query query = manager.createQuery("select nome from Grupo g order by g.id");
		List<String> grupos = query.getResultList();
		manager.close();
		return grupos;
	}

	// Preenche os Fornecedores de uma JComboBox
	public static List<String> preencherFornecedores() {
		manager = new JPAUtil().getEntityManager();
		Query query = manager.createQuery("select nome from Fornecedor f where f.status = :fAtivo order by f.id");
		query.setParameter("fAtivo", Status.ATIVO);
		List<String> fornecedores = query.getResultList();
		manager.close();
		return fornecedores;
	}

	// Pega o ID do Produto de uma JComboBox
	public static Integer pegarIdProdutoSelecionado(JComboBox cbProduto) {
		manager = new JPAUtil().getEntityManager();
		Integer idProduto = 0;
		Query query = manager.createQuery("select p from Produto p where p.descricao=:descricaoProduto");
		query.setParameter("descricaoProduto", cbProduto.getSelectedItem());
		List<Produto> produtos = query.getResultList();
		for (Produto produto : produtos) {
			idProduto = produto.getId();
		}
		manager.close();
		return idProduto;
	}

	// Pega o ID da Categoria de uma JComboBox
	public static Integer pegarIdCategoriaSelecionada(JComboBox cbCategoria) {
		manager = new JPAUtil().getEntityManager();
		Integer idCategoria = 0;
		Query query = manager.createQuery("select c from Categoria c where c.nome=:nomeCategoria");
		query.setParameter("nomeCategoria", cbCategoria.getSelectedItem());
		List<Categoria> categorias = query.getResultList();
		for (Categoria categoria : categorias) {
			idCategoria = categoria.getId();
		}
		manager.close();
		return idCategoria;
	}

	// Pega o ID do Grupo de uma JComboBox
	public static Integer pegarIdGrupoSelecionado(JComboBox cbGrupo) {
		manager = new JPAUtil().getEntityManager();
		Integer idGrupo = 0;
		Query query = manager.createQuery("select g from Grupo g where g.nome=:nomeGrupo");
		query.setParameter("nomeGrupo", cbGrupo.getSelectedItem());
		List<Grupo> grupos = query.getResultList();
		for (Grupo grupo : grupos) {
			idGrupo = grupo.getId();
		}
		manager.close();
		return idGrupo;
	}

	// Pega o ID do Fornecedor de uma JComboBox
	public static Integer pegarIdFornecedorSelecionado(JComboBox cbFornecedor) {
		manager = new JPAUtil().getEntityManager();
		Integer idFornecedor = 0;
		Query query = manager.createQuery("select f from Fornecedor f where f.nome=:nomeFornecedor");
		query.setParameter("nomeFornecedor", cbFornecedor.getSelectedItem());
		List<Fornecedor> fornecedores = query.getResultList();
		for (Fornecedor fornecedor : fornecedores) {
			idFornecedor = fornecedor.getId();
		}
		manager.close();
		return idFornecedor;
	}

	// Confere se as datas inseridas fazem sentido
	public static boolean dataErrada(JDateChooser dcDataFabricacao, JDateChooser dcDataVencimento) {
		if (dcDataFabricacao.getDate().after(Calendar.getInstance().getTime())) {
			JOptionPane.showMessageDialog(null,
					"A data de fabricação inserida é inválida! Ela deve ser anterior à data atual.",
					"Data de fabricação inválida", JOptionPane.ERROR_MESSAGE);
			return true;
		} else if (dcDataVencimento.getDate().before(Calendar.getInstance().getTime())) {
			JOptionPane.showMessageDialog(null,
					"A data de vencimento inserida é inválida! Ela deve ser posterior à data atual.",
					"Data de vencimento inválida", JOptionPane.ERROR_MESSAGE);
			return true;
		} else if (dcDataFabricacao.getDate().after(dcDataVencimento.getDate())) {
			JOptionPane.showMessageDialog(null, "A data de fabricação não pode ser posterior à data de vencimento!",
					"Data inserida inválida", JOptionPane.ERROR_MESSAGE);
			return true;
		}
		return false;
	}

	// Método chamado para repopular os Fornecedores sempre que o usuário clicar na
	// JComboBox de seleionar Fornecedor na tela de Cadastrar Produtos
	public static void repopularFornecedores(JComboBox cbFornecedor) {
		cbFornecedor.removeAllItems();

		for (Fornecedor fornecedor : ControllerFornecedor.listarApenasFornecedoresAtivos()) {
			cbFornecedor.addItem(fornecedor.getNome());
		}
	}

	// Converte Date para Calendar
	public static Calendar toCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		try {
			date = (Date) df.parse(date.toString());
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		cal.setTime(date);
		return cal;
	}
}
