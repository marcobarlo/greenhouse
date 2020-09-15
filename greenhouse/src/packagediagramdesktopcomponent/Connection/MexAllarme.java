package packagediagramdesktopcomponent.Connection;

public class MexAllarme {

		private int idAmbiente;
		private String mex;
		private String tipoColtivazione;
		private int idColt;
		private int idSez;
		
		protected MexAllarme()
		{
			mex="Errore generico";
		}
		
		protected MexAllarme(int id)
		{
			idAmbiente = id;
			mex="Errore generico";
		}
		
		public static MexAllarme buildAllarme(int code, int idAmb)
		{
			switch(code)
			{
			case 1:
				return new Allarme1(idAmb);
			case 2:
	    		return new Allarme2(idAmb);
	    	case 3:
	    		return new Allarme3(idAmb);
	    	case 4:
	    		return new Allarme4(idAmb);
	    	case 5:
	    		return new Allarme5(idAmb);
	    	case 6:
	    		return new Allarme6(idAmb);
	    	default: return new MexAllarme(idAmb);
			}
		}
		public static MexAllarme buildAllarme(int code, int idAmb, float delta)
		{
			switch(code)
			{
				case 4:
					return new Allarme4(idAmb,delta);
				case 5:
					return new Allarme5(idAmb,delta);
				case 6:
					return new Allarme6(idAmb,delta);
			 	default: return new MexAllarme(idAmb);
			}
		}
		
		public int getSensoreMalfunzionante()		//-1 nessuno , 1 temp ,2 umi , 3 irr
		{
			return -1;
		}
		
		public int getIdAmbiente() {
			return idAmbiente;
		}
		public String getMex() {
			return mex;
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
