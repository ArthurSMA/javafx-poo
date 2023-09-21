package com.example;

class PessoaJuridica extends Pessoa {
    @Override
    public void sacar(float valor) {
        this.saldo = saldo + valor / 1.5f;
    }
}
