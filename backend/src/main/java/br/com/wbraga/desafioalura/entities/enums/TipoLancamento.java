package br.com.wbraga.desafioalura.entities.enums;

public enum TipoLancamento {
	
	RECEITA(1),
	DESPESA(-1);

	private int code;
	
	private TipoLancamento (int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static TipoLancamento valueOf(int code) {
		for (TipoLancamento value : TipoLancamento.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalAccessError("Favor informar um valor valido para o tipo de Lancamento (Receita/Despesa)");
	}
}
