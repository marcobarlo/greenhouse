package packagediagramdesktopcomponent.Connection;

public class MexAllarme {

		private int idAmbiente;
		private String mex;
		private String tipo;
		private int idColt, idSez;
		public int getIdAmbiente() {
			return idAmbiente;
		}
		public String getMex() {
			return mex;
		}
		public MexAllarme(int id , String m)
		{
			idAmbiente = id;
			mex = m;
		}
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		public int getIdColt() {
			return idColt;
		}
		public void setIdColt(int idColt) {
			this.idColt = idColt;
		}
		public int getIdSez() {
			return idSez;
		}
		public void setIdSez(int idSez) {
			this.idSez = idSez;
		}
		
}
