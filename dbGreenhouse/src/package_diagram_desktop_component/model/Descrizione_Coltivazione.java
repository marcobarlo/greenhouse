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

public class Descrizione_Coltivazione {
	public Descrizione_Coltivazione() {
	}
	
	public static Descrizione_Coltivazione loadDescrizione_ColtivazioneByORMID(int attribute) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return loadDescrizione_ColtivazioneByORMID(session, attribute);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Descrizione_Coltivazione getDescrizione_ColtivazioneByORMID(int attribute) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return getDescrizione_ColtivazioneByORMID(session, attribute);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Descrizione_Coltivazione loadDescrizione_ColtivazioneByORMID(int attribute, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return loadDescrizione_ColtivazioneByORMID(session, attribute, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Descrizione_Coltivazione getDescrizione_ColtivazioneByORMID(int attribute, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return getDescrizione_ColtivazioneByORMID(session, attribute, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Descrizione_Coltivazione loadDescrizione_ColtivazioneByORMID(PersistentSession session, int attribute) throws PersistentException {
		try {
			return (Descrizione_Coltivazione) session.load(package_diagram_desktop_component.model.Descrizione_Coltivazione.class, new Integer(attribute));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Descrizione_Coltivazione getDescrizione_ColtivazioneByORMID(PersistentSession session, int attribute) throws PersistentException {
		try {
			return (Descrizione_Coltivazione) session.get(package_diagram_desktop_component.model.Descrizione_Coltivazione.class, new Integer(attribute));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Descrizione_Coltivazione loadDescrizione_ColtivazioneByORMID(PersistentSession session, int attribute, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Descrizione_Coltivazione) session.load(package_diagram_desktop_component.model.Descrizione_Coltivazione.class, new Integer(attribute), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Descrizione_Coltivazione getDescrizione_ColtivazioneByORMID(PersistentSession session, int attribute, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Descrizione_Coltivazione) session.get(package_diagram_desktop_component.model.Descrizione_Coltivazione.class, new Integer(attribute), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDescrizione_Coltivazione(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return queryDescrizione_Coltivazione(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDescrizione_Coltivazione(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return queryDescrizione_Coltivazione(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Descrizione_Coltivazione[] listDescrizione_ColtivazioneByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return listDescrizione_ColtivazioneByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Descrizione_Coltivazione[] listDescrizione_ColtivazioneByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return listDescrizione_ColtivazioneByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDescrizione_Coltivazione(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From package_diagram_desktop_component.model.Descrizione_Coltivazione as Descrizione_Coltivazione");
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
	
	public static List queryDescrizione_Coltivazione(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From package_diagram_desktop_component.model.Descrizione_Coltivazione as Descrizione_Coltivazione");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Descrizione_Coltivazione", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Descrizione_Coltivazione[] listDescrizione_ColtivazioneByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryDescrizione_Coltivazione(session, condition, orderBy);
			return (Descrizione_Coltivazione[]) list.toArray(new Descrizione_Coltivazione[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Descrizione_Coltivazione[] listDescrizione_ColtivazioneByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryDescrizione_Coltivazione(session, condition, orderBy, lockMode);
			return (Descrizione_Coltivazione[]) list.toArray(new Descrizione_Coltivazione[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Descrizione_Coltivazione loadDescrizione_ColtivazioneByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return loadDescrizione_ColtivazioneByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Descrizione_Coltivazione loadDescrizione_ColtivazioneByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return loadDescrizione_ColtivazioneByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Descrizione_Coltivazione loadDescrizione_ColtivazioneByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Descrizione_Coltivazione[] descrizione_Coltivaziones = listDescrizione_ColtivazioneByQuery(session, condition, orderBy);
		if (descrizione_Coltivaziones != null && descrizione_Coltivaziones.length > 0)
			return descrizione_Coltivaziones[0];
		else
			return null;
	}
	
	public static Descrizione_Coltivazione loadDescrizione_ColtivazioneByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Descrizione_Coltivazione[] descrizione_Coltivaziones = listDescrizione_ColtivazioneByQuery(session, condition, orderBy, lockMode);
		if (descrizione_Coltivaziones != null && descrizione_Coltivaziones.length > 0)
			return descrizione_Coltivaziones[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateDescrizione_ColtivazioneByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return iterateDescrizione_ColtivazioneByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDescrizione_ColtivazioneByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return iterateDescrizione_ColtivazioneByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDescrizione_ColtivazioneByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From package_diagram_desktop_component.model.Descrizione_Coltivazione as Descrizione_Coltivazione");
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
	
	public static java.util.Iterator iterateDescrizione_ColtivazioneByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From package_diagram_desktop_component.model.Descrizione_Coltivazione as Descrizione_Coltivazione");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Descrizione_Coltivazione", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Descrizione_Coltivazione loadDescrizione_ColtivazioneByCriteria(Descrizione_ColtivazioneCriteria descrizione_ColtivazioneCriteria) {
		Descrizione_Coltivazione[] descrizione_Coltivaziones = listDescrizione_ColtivazioneByCriteria(descrizione_ColtivazioneCriteria);
		if(descrizione_Coltivaziones == null || descrizione_Coltivaziones.length == 0) {
			return null;
		}
		return descrizione_Coltivaziones[0];
	}
	
	public static Descrizione_Coltivazione[] listDescrizione_ColtivazioneByCriteria(Descrizione_ColtivazioneCriteria descrizione_ColtivazioneCriteria) {
		return descrizione_ColtivazioneCriteria.listDescrizione_Coltivazione();
	}
	
	public static Descrizione_Coltivazione createDescrizione_Coltivazione() {
		return new package_diagram_desktop_component.model.Descrizione_Coltivazione();
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
			package_diagram_desktop_component.model.Coltivazione[] lColtivazionis = coltivazioni.toArray();
			for(int i = 0; i < lColtivazionis.length; i++) {
				lColtivazionis[i].setDescrizione(null);
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
			package_diagram_desktop_component.model.Coltivazione[] lColtivazionis = coltivazioni.toArray();
			for(int i = 0; i < lColtivazionis.length; i++) {
				lColtivazionis[i].setDescrizione(null);
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
		if (key == package_diagram_desktop_component.model.ORMConstants.KEY_DESCRIZIONE_COLTIVAZIONE_COLTIVAZIONI) {
			return ORM_coltivazioni;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int attribute;
	
	private int ID;
	
	private String tipo;
	
	private String descrizione;
	
	private java.util.Set ORM_coltivazioni = new java.util.HashSet();
	
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
	
	public void setTipo(String value) {
		this.tipo = value;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setDescrizione(String value) {
		this.descrizione = value;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	private void setORM_Coltivazioni(java.util.Set value) {
		this.ORM_coltivazioni = value;
	}
	
	private java.util.Set getORM_Coltivazioni() {
		return ORM_coltivazioni;
	}
	
	public final package_diagram_desktop_component.model.ColtivazioneSetCollection coltivazioni = new package_diagram_desktop_component.model.ColtivazioneSetCollection(this, _ormAdapter, package_diagram_desktop_component.model.ORMConstants.KEY_DESCRIZIONE_COLTIVAZIONE_COLTIVAZIONI, package_diagram_desktop_component.model.ORMConstants.KEY_COLTIVAZIONE_DESCRIZIONE, package_diagram_desktop_component.model.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void ricercaColtivazione() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getAttribute());
	}
	
}
