package com.zubokoff.cursomc.domain.enums;

public enum EstadoPagamento {

	PENDENTE(1, "Pendente"), QUITADO(2, "Cancelado"), CANCELADO(3, "Cancelado");

	private int cod;
	private String nome;

	private EstadoPagamento(int cod, String nome) {
		this.cod = cod;
		this.nome = nome;
	}

	public int getCod() {
		return cod;
	}

	public String getNome() {
		return nome;
	}

	public static EstadoPagamento toEnum(Integer cod) {
		if (cod == null)
			return null;

		for (EstadoPagamento t : EstadoPagamento.values()) {
			if (cod.equals(t.cod))
				return t;
		}
		throw new IllegalArgumentException("Id inválido " + cod);
	}
}
