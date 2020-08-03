package interfaces;

public enum CorLinha {
	AMARELA(1),
	VERDE(2),
	VERMELHA(3),
	AZUL(4);
	
	public int idLinha;

	CorLinha(int _idLinha) {
		idLinha = _idLinha;
	}
	
	public int getIdLinha() { return idLinha; }
}
