package packagediagramdesktopcomponent.Connection;

public class MexAllarme {

		private int idAmbiente;
		private String mex;
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
}
