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
package package_diagram_desktop_component.model;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class Coltivazione {
	public Coltivazione() {
	}
	
	public static Coltivazione loadColtivazioneByORMID(int attribute) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return loadColtivazioneByORMID(session, attribute);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Coltivazione getColtivazioneByORMID(int attribute) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return getColtivazioneByORMID(session, attribute);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Coltivazione loadColtivazioneByORMID(int attribute, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return loadColtivazioneByORMID(session, attribute, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Coltivazione getColtivazioneByORMID(int attribute, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return getColtivazioneByORMID(session, attribute, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Coltivazione loadColtivazioneByORMID(PersistentSession session, int attribute) throws PersistentException {
		try {
			return (Coltivazione) session.load(package_diagram_desktop_component.model.Coltivazione.class, new Integer(attribute));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Coltivazione getColtivazioneByORMID(PersistentSession session, int attribute) throws PersistentException {
		try {
			return (Coltivazione) session.get(package_diagram_desktop_component.model.Coltivazione.class, new Integer(attribute));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Coltivazione loadColtivazioneByORMID(PersistentSession session, int attribute, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Coltivazione) session.load(package_diagram_desktop_component.model.Coltivazione.class, new Integer(attribute), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Coltivazione getColtivazioneByORMID(PersistentSession session, int attribute, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Coltivazione) session.get(package_diagram_desktop_component.model.Coltivazione.class, new Integer(attribute), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryColtivazione(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return queryColtivazione(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryColtivazione(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return queryColtivazione(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Coltivazione[] listColtivazioneByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return listColtivazioneByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Coltivazione[] listColtivazioneByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return listColtivazioneByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryColtivazione(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From package_diagram_desktop_component.model.Coltivazione as Coltivazione");
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
		StringBuffer sb = new StringBuffer("From package_diagram_desktop_component.model.Coltivazione as Coltivazione");
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
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return loadColtivazioneByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Coltivazione loadColtivazioneByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
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
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return iterateColtivazioneByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateColtivazioneByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return iterateColtivazioneByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateColtivazioneByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From package_diagram_desktop_component.model.Coltivazione as Coltivazione");
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
		StringBuffer sb = new StringBuffer("From package_diagram_desktop_component.model.Coltivazione as Coltivazione");
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
		return new package_diagram_desktop_component.model.Coltivazione();
	}
	
	public boolean save() throws PersistentException {
		try {
			package_diagram_desktop_component.model.GreenhousePersistentManager.instance().saveObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete() throws PersistentException {
		try {
			package_diagram_desktop_component.model.GreenhousePersistentManager.instance().deleteObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean refresh() throws PersistentException {
		try {
			package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession().refresh(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict() throws PersistentException {
		try {
			package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession().evict(this);
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
		if (key == package_diagram_desktop_component.model.ORMConstants.KEY_COLTIVAZIONE_IMPIEGATO) {
			return ORM_impiegato;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == package_diagram_desktop_component.model.ORMConstants.KEY_COLTIVAZIONE_AREA) {
			this.area = (package_diagram_desktop_component.model.Area_Coltivata) owner;
		}
		
		else if (key == package_diagram_desktop_component.model.ORMConstants.KEY_COLTIVAZIONE_DESCRIZIONE) {
			this.descrizione = (package_diagram_desktop_component.model.Descrizione_Coltivazione) owner;
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
	
	private int attribute;
	
	private package_diagram_desktop_component.model.Descrizione_Coltivazione descrizione;
	
	private int ID;
	
	private String stato;
	
	private java.util.Date data_prossima_operazione;
	
	private package_diagram_desktop_component.model.Area_Coltivata area;
	
	private java.util.Set ORM_impiegato = new java.util.HashSet();
	
	private void setAttribute(int value) {
		this.attribute = value;
	}
	
	public int getAttribute() {
		return attribute;
	}
	
	public int getORMID() {
		return getAttribute();
	}
	
	public void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
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
	
	public void setArea(package_diagram_desktop_component.model.Area_Coltivata value) {
		if (this.area != value) {
			package_diagram_desktop_component.model.Area_Coltivata larea = this.area;
			this.area = value;
			if (value != null) {
				area.setColtivazione(this);
			}
			if (larea != null && larea.getColtivazione() == this) {
				larea.setColtivazione(null);
			}
		}
	}
	
	public package_diagram_desktop_component.model.Area_Coltivata getArea() {
		return area;
	}
	
	public void setDescrizione(package_diagram_desktop_component.model.Descrizione_Coltivazione value) {
		if (descrizione != null) {
			descrizione.coltivazioni.remove(this);
		}
		if (value != null) {
			value.coltivazioni.add(this);
		}
	}
	
	public package_diagram_desktop_component.model.Descrizione_Coltivazione getDescrizione() {
		return descrizione;
	}
	
	/**
	 * This method is for internal use only.
	 */
	private void setORM_Descrizione(package_diagram_desktop_component.model.Descrizione_Coltivazione value) {
		this.descrizione = value;
	}
	
	private package_diagram_desktop_component.model.Descrizione_Coltivazione getORM_Descrizione() {
		return descrizione;
	}
	
	private void setORM_Impiegato(java.util.Set value) {
		this.ORM_impiegato = value;
	}
	
	private java.util.Set getORM_Impiegato() {
		return ORM_impiegato;
	}
	
	public final package_diagram_desktop_component.model.ImpiegatoSetCollection impiegato = new package_diagram_desktop_component.model.ImpiegatoSetCollection(this, _ormAdapter, package_diagram_desktop_component.model.ORMConstants.KEY_COLTIVAZIONE_IMPIEGATO, package_diagram_desktop_component.model.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public void getAreaColtivata() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void modificaAmbiente() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void getTipo() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getAttribute());
	}
	
}
