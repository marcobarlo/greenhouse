package packagediagramdesktopcomponent.Connection;

public class MexAllarme {

		private int idAmbiente;
		private String mex;
		private String tipoColtivazione;
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
		public String getTipoColtivazione() {
			return tipoColtivazione;
		}
		public void setTipoColtivazione(String tipo) {
			this.tipoColtivazione = tipo;
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
