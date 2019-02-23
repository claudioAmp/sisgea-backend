package ob.unibanca.sicf.mantenimientosgenerales.service.enumeracion;

public enum Modo {
	
	INSERT("INSERT"),
	UPDATE("UPDATE"),
	DELETE("DELETE");
	
	private String valor;
	
	Modo(final String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return this.valor;
	}
}
