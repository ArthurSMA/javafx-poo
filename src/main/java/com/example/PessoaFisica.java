package com.example;

class PessoaFisica extends Pessoa {
	@Override
	public void sacar(float valor) {
		this.saldo = saldo + valor*1.75f;
	}
}
