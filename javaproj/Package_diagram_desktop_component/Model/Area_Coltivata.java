package Package_diagram_desktop_component.Model;

public class Area_Coltivata {

	Sezione sezione;
	Coltivazione coltivazione;
	Ambiente ambiente;
	private int fila;
	private int posizione;
	private float estensione;
	private String tipo_di_terreno;

	public void getColtivazione() {
		// TODO - implement Area_Coltivata.getColtivazione
		throw new UnsupportedOperationException();
	}

	public void modificaAmbiente() {
		// TODO - implement Area_Coltivata.modificaAmbiente
		throw new UnsupportedOperationException();
	}

	public String getTipoColtivazione() {
		// TODO - implement Area_Coltivata.getTipoColtivazione
		throw new UnsupportedOperationException();
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getPosizione() {
		return posizione;
	}

	public void setPosizione(int posizione) {
		this.posizione = posizione;
	}

	public float getEstensione() {
		return estensione;
	}

	public void setEstensione(float estensione) {
		this.estensione = estensione;
	}

	public String getTipo_di_terreno() {
		return tipo_di_terreno;
	}

	public void setTipo_di_terreno(String tipo_di_terreno) {
		this.tipo_di_terreno = tipo_di_terreno;
	}

}