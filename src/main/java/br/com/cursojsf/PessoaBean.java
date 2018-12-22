package br.com.cursojsf;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dao.DaoGeneric;
import br.com.entidades.Pessoa;

@ViewScoped
@ManagedBean(name = "pessoaBean")
public class PessoaBean {
	private Pessoa pessoa = new Pessoa();
	private String teste;
	private List<Pessoa> pessoas;

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public String getTeste() {
		return teste;
	}

	public void setTeste(String teste) {
		this.teste = teste;
	}

	private DaoGeneric<Pessoa> daoPessoa = new DaoGeneric<Pessoa>();

	public DaoGeneric<Pessoa> getDaoPessoa() {
		return daoPessoa;
	}

	public void setDaoPessoa(DaoGeneric<Pessoa> daoPessoa) {
		this.daoPessoa = daoPessoa;
	}

	public String salvar() {
		pessoa = daoPessoa.merge(pessoa);
		carregarPessoas();
		return "";
	}

	public String novo() {
		pessoa = new Pessoa();
		return "";
	}

	public String delete() {
		daoPessoa.deletePorId(pessoa);
		pessoa = new Pessoa();
		carregarPessoas();
		return "";
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@PostConstruct
	public void carregarPessoas() {
		pessoas = daoPessoa.gerListEntity(Pessoa.class);
	}
}
