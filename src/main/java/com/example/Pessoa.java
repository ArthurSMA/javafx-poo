package com.example;

class Pessoa {
	String nome;
	String tipoPessoa;
	float saldo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

  public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public void sacar(float valor) {
		this.saldo = saldo - valor;
	}

	public void depositar(float valor) {
		this.saldo = saldo + valor;
	}
}