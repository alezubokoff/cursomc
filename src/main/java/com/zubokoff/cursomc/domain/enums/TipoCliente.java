package com.zubokoff.cursomc.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Fisíca"), PESSOAJURIDICA(2, "Pessoa Jurídica");

	private int cod;
	private String nome;

	private TipoCliente(int cod, String nome) {
		this.cod = cod;
		this.nome = nome;
	}

	public int getCod() {
		return cod;
	}

	public String getNome() {
		return nome;
	}

	public static TipoCliente toEnum(Integer cod) {
		if (cod == null)
			return null;
		
		for(TipoCliente t : TipoCliente.values()) {
			if (cod.equals(t.cod))
				return t;
		}
		throw new IllegalArgumentException("Id inválido " + cod);
	}
}
