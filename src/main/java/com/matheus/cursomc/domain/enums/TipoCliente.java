package com.matheus.cursomc.domain.enums;

public enum TipoCliente {

	PESSOA_FISICA(1, "Pessoa Física"), // (1) -> código numérico
	PESSOA_JURIDICA(2, "Pessoa Jurídica");
	
	private int cod;
	private String descr;
	
	private TipoCliente(int cod, String descr) {
		this.cod = cod;
		this.descr = descr;
	}

	public int getCod() {
		return cod;
	}

	public String getDescr() {
		return descr;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		if(cod==null) 
			return null;
		
		for(TipoCliente x : TipoCliente.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
