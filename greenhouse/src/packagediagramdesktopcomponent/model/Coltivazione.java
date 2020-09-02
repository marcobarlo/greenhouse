/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package packagediagramdesktopcomponent.model;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class Coltivazione {
	public Coltivazione() {
	}
	
	public Coltivazione(int id) 
	{
		
	}
	
	public static Coltivazione loadColtivazioneByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = packagediagramdesktopcomponent.model.GreenhousePersistentManager.instance().getSession();
			return loadColtivazioneByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Coltivazione getColtivazioneByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = packagediagramdesktopcomponent.model.GreenhousePersistentManager.instance().getSession();
			return getColtivazioneByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Coltivazione loadColtivazioneByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = packagediagramdesktopcomponent.model.GreenhousePersistentManager.instance().getSession();
			return loadColtivazioneByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Coltivazione getColtivazioneByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = packagediagramdesktopcomponent.model.GreenhousePersistentManager.instance().getSession();
			return getColtivazioneByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Coltivazione loadColtivazioneByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Coltivazione) session.load(packagediagramdesktopcomponent.model.Coltivazione.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Coltivazione getColtivazioneByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Coltivazione) session.get(packagediagramdesktopcomponent.model.Coltivazione.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Coltivazione loadColtivazioneByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Coltivazione) session.load(packagediagramdesktopcomponent.model.Coltivazione.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Coltivazione getColtivazioneByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Coltivazione) session.get(packagediagramdesktopcomponent.model.Coltivazione.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryColtivazione(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = packagediagramdesktopcomponent.model.GreenhousePersistentManager.instance().getSession();
			return queryColtivazione(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryColtivazione(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = packagediagramdesktopcomponent.model.GreenhousePersistentManager.instance().getSession();
			return queryColtivazione(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Coltivazione[] listColtivazioneByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = packagediagramdesktopcomponent.model.GreenhousePersistentManager.instance().getSession();
			return listColtivazioneByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Coltivazione[] listColtivazioneByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = packagediagramdesktopcomponent.model.GreenhousePersistentManager.instance().getSession();
			return listColtivazioneByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryColtivazione(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From packagediagramdesktopcomponent.model.Coltivazione as Coltivazione");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryColtivazione(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From packagediagramdesktopcomponent.model.Coltivazione as Coltivazione");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Coltivazione", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Coltivazione[] listColtivazioneByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryColtivazione(session, condition, orderBy);
			return (Coltivazione[]) list.toArray(new Coltivazione[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Coltivazione[] listColtivazioneByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryColtivazione(session, condition, orderBy, lockMode);
			return (Coltivazione[]) list.toArray(new Coltivazione[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Coltivazione loadColtivazioneByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = packagediagramdesktopcomponent.model.GreenhousePersistentManager.instance().getSession();
			return loadColtivazioneByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Coltivazione loadColtivazioneByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = packagediagramdesktopcomponent.model.GreenhousePersistentManager.instance().getSession();
			return loadColtivazioneByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Coltivazione loadColtivazioneByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Coltivazione[] coltivaziones = listColtivazioneByQuery(session, condition, orderBy);
		if (coltivaziones != null && coltivaziones.length > 0)
			return coltivaziones[0];
		else
			return null;
	}
	
	public static Coltivazione loadColtivazioneByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Coltivazione[] coltivaziones = listColtivazioneByQuery(session, condition, orderBy, lockMode);
		if (coltivaziones != null && coltivaziones.length > 0)
			return coltivaziones[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateColtivazioneByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = packagediagramdesktopcomponent.model.GreenhousePersistentManager.instance().getSession();
			return iterateColtivazioneByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateColtivazioneByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = packagediagramdesktopcomponent.model.GreenhousePersistentManager.instance().getSession();
			return iterateColtivazioneByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateColtivazioneByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From packagediagramdesktopcomponent.model.Coltivazione as Coltivazione");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateColtivazioneByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From packagediagramdesktopcomponent.model.Coltivazione as Coltivazione");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Coltivazione", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Coltivazione loadColtivazioneByCriteria(ColtivazioneCriteria coltivazioneCriteria) {
		Coltivazione[] coltivaziones = listColtivazioneByCriteria(coltivazioneCriteria);
		if(coltivaziones == null || coltivaziones.length == 0) {
			return null;
		}
		return coltivaziones[0];
	}
	
	public static Coltivazione[] listColtivazioneByCriteria(ColtivazioneCriteria coltivazioneCriteria) {
		return coltivazioneCriteria.listColtivazione();
	}
	
	public static Coltivazione createColtivazione() {
		return new packagediagramdesktopcomponent.model.Coltivazione();
	}
	
	public boolean save() throws PersistentException {
		try {
			packagediagramdesktopcomponent.model.GreenhousePersistentManager.instance().saveObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete() throws PersistentException {
		try {
			packagediagramdesktopcomponent.model.GreenhousePersistentManager.instance().deleteObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean refresh() throws PersistentException {
		try {
			packagediagramdesktopcomponent.model.GreenhousePersistentManager.instance().getSession().refresh(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict() throws PersistentException {
		try {
			packagediagramdesktopcomponent.model.GreenhousePersistentManager.instance().getSession().evict(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate()throws PersistentException {
		try {
			if(getDescrizione() != null) {
				getDescrizione().coltivazioni.remove(this);
			}
			
			if(getArea() != null) {
				getArea().setColtivazione(null);
			}
			
			return delete();
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(org.orm.PersistentSession session)throws PersistentException {
		try {
			if(getDescrizione() != null) {
				getDescrizione().coltivazioni.remove(this);
			}
			
			if(getArea() != null) {
				getArea().setColtivazione(null);
			}
			
			try {
				session.delete(this);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == packagediagramdesktopcomponent.model.ORMConstants.KEY_COLTIVAZIONE_IMPIEGATO) {
			return ORM_impiegato;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == packagediagramdesktopcomponent.model.ORMConstants.KEY_COLTIVAZIONE_AREA) {
			this.area = (packagediagramdesktopcomponent.model.AreaColtivata) owner;
		}
		
		else if (key == packagediagramdesktopcomponent.model.ORMConstants.KEY_COLTIVAZIONE_DESCRIZIONE) {
			this.descrizione = (packagediagramdesktopcomponent.model.DescrizioneColtivazione) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private String stato;
	
	private java.util.Date data_prossima_operazione;
	
	private packagediagramdesktopcomponent.model.DescrizioneColtivazione descrizione;
	
	private packagediagramdesktopcomponent.model.AreaColtivata area;
	
	private java.util.Set ORM_impiegato = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setStato(String value) {
		this.stato = value;
	}
	
	public String getStato() {
		return stato;
	}
	
	public void setData_prossima_operazione(java.util.Date value) {
		this.data_prossima_operazione = value;
	}
	
	public java.util.Date getData_prossima_operazione() {
		return data_prossima_operazione;
	}
	
	public void setArea(packagediagramdesktopcomponent.model.AreaColtivata value) {
		if (this.area != value) {
			packagediagramdesktopcomponent.model.AreaColtivata larea = this.area;
			this.area = value;
			if (value != null) {
				area.setColtivazione(this);
			}
			if (larea != null && larea.getColtivazione() == this) {
				larea.setColtivazione(null);
			}
		}
	}
	
	public packagediagramdesktopcomponent.model.AreaColtivata getArea() {
		return area;
	}
	
	public void setDescrizione(packagediagramdesktopcomponent.model.DescrizioneColtivazione value) {
		if (descrizione != null) {
			descrizione.coltivazioni.remove(this);
		}
		if (value != null) {
			value.coltivazioni.add(this);
		}
	}
	
	public packagediagramdesktopcomponent.model.DescrizioneColtivazione getDescrizione() {
		return descrizione;
	}
	
	/**
	 * This method is for internal use only.
	 */
	private void setORM_Descrizione(packagediagramdesktopcomponent.model.DescrizioneColtivazione value) {
		this.descrizione = value;
	}
	
	private packagediagramdesktopcomponent.model.DescrizioneColtivazione getORM_Descrizione() {
		return descrizione;
	}
	
	private void setORM_Impiegato(java.util.Set value) {
		this.ORM_impiegato = value;
	}
	
	private java.util.Set getORM_Impiegato() {
		return ORM_impiegato;
	}
	
	public final packagediagramdesktopcomponent.model.ImpiegatoSetCollection impiegato = new packagediagramdesktopcomponent.model.ImpiegatoSetCollection(this, _ormAdapter, packagediagramdesktopcomponent.model.ORMConstants.KEY_COLTIVAZIONE_IMPIEGATO, packagediagramdesktopcomponent.model.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public AreaColtivata getAreaColtivata() {
		return area;
	}
	
	public boolean modificaAmbiente(Float temperatura, Float umidita, Float irradianza) {
		return this.area.modificaAmbiente(temperatura, umidita, irradianza);
	}
	
	public String getTipo() {
		return descrizione.getTipo();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
