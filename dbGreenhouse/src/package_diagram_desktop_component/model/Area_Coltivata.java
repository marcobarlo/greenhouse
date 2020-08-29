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

public class Area_Coltivata {
	public Area_Coltivata() {
	}
	
	public static Area_Coltivata loadArea_ColtivataByORMID(int attribute) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return loadArea_ColtivataByORMID(session, attribute);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Area_Coltivata getArea_ColtivataByORMID(int attribute) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return getArea_ColtivataByORMID(session, attribute);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Area_Coltivata loadArea_ColtivataByORMID(int attribute, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return loadArea_ColtivataByORMID(session, attribute, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Area_Coltivata getArea_ColtivataByORMID(int attribute, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return getArea_ColtivataByORMID(session, attribute, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Area_Coltivata loadArea_ColtivataByORMID(PersistentSession session, int attribute) throws PersistentException {
		try {
			return (Area_Coltivata) session.load(package_diagram_desktop_component.model.Area_Coltivata.class, new Integer(attribute));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Area_Coltivata getArea_ColtivataByORMID(PersistentSession session, int attribute) throws PersistentException {
		try {
			return (Area_Coltivata) session.get(package_diagram_desktop_component.model.Area_Coltivata.class, new Integer(attribute));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Area_Coltivata loadArea_ColtivataByORMID(PersistentSession session, int attribute, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Area_Coltivata) session.load(package_diagram_desktop_component.model.Area_Coltivata.class, new Integer(attribute), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Area_Coltivata getArea_ColtivataByORMID(PersistentSession session, int attribute, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Area_Coltivata) session.get(package_diagram_desktop_component.model.Area_Coltivata.class, new Integer(attribute), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryArea_Coltivata(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return queryArea_Coltivata(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryArea_Coltivata(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return queryArea_Coltivata(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Area_Coltivata[] listArea_ColtivataByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return listArea_ColtivataByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Area_Coltivata[] listArea_ColtivataByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return listArea_ColtivataByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryArea_Coltivata(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From package_diagram_desktop_component.model.Area_Coltivata as Area_Coltivata");
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
	
	public static List queryArea_Coltivata(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From package_diagram_desktop_component.model.Area_Coltivata as Area_Coltivata");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Area_Coltivata", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Area_Coltivata[] listArea_ColtivataByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryArea_Coltivata(session, condition, orderBy);
			return (Area_Coltivata[]) list.toArray(new Area_Coltivata[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Area_Coltivata[] listArea_ColtivataByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryArea_Coltivata(session, condition, orderBy, lockMode);
			return (Area_Coltivata[]) list.toArray(new Area_Coltivata[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Area_Coltivata loadArea_ColtivataByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return loadArea_ColtivataByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Area_Coltivata loadArea_ColtivataByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return loadArea_ColtivataByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Area_Coltivata loadArea_ColtivataByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Area_Coltivata[] area_Coltivatas = listArea_ColtivataByQuery(session, condition, orderBy);
		if (area_Coltivatas != null && area_Coltivatas.length > 0)
			return area_Coltivatas[0];
		else
			return null;
	}
	
	public static Area_Coltivata loadArea_ColtivataByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Area_Coltivata[] area_Coltivatas = listArea_ColtivataByQuery(session, condition, orderBy, lockMode);
		if (area_Coltivatas != null && area_Coltivatas.length > 0)
			return area_Coltivatas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateArea_ColtivataByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return iterateArea_ColtivataByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateArea_ColtivataByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return iterateArea_ColtivataByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateArea_ColtivataByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From package_diagram_desktop_component.model.Area_Coltivata as Area_Coltivata");
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
	
	public static java.util.Iterator iterateArea_ColtivataByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From package_diagram_desktop_component.model.Area_Coltivata as Area_Coltivata");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Area_Coltivata", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Area_Coltivata loadArea_ColtivataByCriteria(Area_ColtivataCriteria area_ColtivataCriteria) {
		Area_Coltivata[] area_Coltivatas = listArea_ColtivataByCriteria(area_ColtivataCriteria);
		if(area_Coltivatas == null || area_Coltivatas.length == 0) {
			return null;
		}
		return area_Coltivatas[0];
	}
	
	public static Area_Coltivata[] listArea_ColtivataByCriteria(Area_ColtivataCriteria area_ColtivataCriteria) {
		return area_ColtivataCriteria.listArea_Coltivata();
	}
	
	public static Area_Coltivata createArea_Coltivata() {
		return new package_diagram_desktop_component.model.Area_Coltivata();
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
			if(getSezione() != null) {
				getSezione().aree.remove(this);
			}
			
			if(getColtivazione() != null) {
				getColtivazione().setArea(null);
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
			if(getSezione() != null) {
				getSezione().aree.remove(this);
			}
			
			if(getColtivazione() != null) {
				getColtivazione().setArea(null);
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
	
	private void this_setOwner(Object owner, int key) {
		if (key == package_diagram_desktop_component.model.ORMConstants.KEY_AREA_COLTIVATA_SEZIONE) {
			this.sezione = (package_diagram_desktop_component.model.Sezione) owner;
		}
		
		else if (key == package_diagram_desktop_component.model.ORMConstants.KEY_AREA_COLTIVATA_COLTIVAZIONE) {
			this.coltivazione = (package_diagram_desktop_component.model.Coltivazione) owner;
		}
		
		else if (key == package_diagram_desktop_component.model.ORMConstants.KEY_AREA_COLTIVATA_AMBIENTE) {
			this.ambiente = (package_diagram_desktop_component.model.Ambiente) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int attribute;
	
	private package_diagram_desktop_component.model.Sezione sezione;
	
	private int ID;
	
	private int fila;
	
	private int posizione;
	
	private float estensione;
	
	private String tipo_di_terreno;
	
	private package_diagram_desktop_component.model.Ambiente ambiente;
	
	private package_diagram_desktop_component.model.Coltivazione coltivazione;
	
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
	
	public void setFila(int value) {
		this.fila = value;
	}
	
	public int getFila() {
		return fila;
	}
	
	public void setPosizione(int value) {
		this.posizione = value;
	}
	
	public int getPosizione() {
		return posizione;
	}
	
	public void setEstensione(float value) {
		this.estensione = value;
	}
	
	public float getEstensione() {
		return estensione;
	}
	
	public void setTipo_di_terreno(String value) {
		this.tipo_di_terreno = value;
	}
	
	public String getTipo_di_terreno() {
		return tipo_di_terreno;
	}
	
	public void setSezione(package_diagram_desktop_component.model.Sezione value) {
		if (sezione != null) {
			sezione.aree.remove(this);
		}
		if (value != null) {
			value.aree.add(this);
		}
	}
	
	public package_diagram_desktop_component.model.Sezione getSezione() {
		return sezione;
	}
	
	/**
	 * This method is for internal use only.
	 */
	private void setORM_Sezione(package_diagram_desktop_component.model.Sezione value) {
		this.sezione = value;
	}
	
	private package_diagram_desktop_component.model.Sezione getORM_Sezione() {
		return sezione;
	}
	
	public void setColtivazione(package_diagram_desktop_component.model.Coltivazione value) {
		if (this.coltivazione != value) {
			package_diagram_desktop_component.model.Coltivazione lcoltivazione = this.coltivazione;
			this.coltivazione = value;
			if (value != null) {
				coltivazione.setArea(this);
			}
			if (lcoltivazione != null && lcoltivazione.getArea() == this) {
				lcoltivazione.setArea(null);
			}
		}
	}
	
	public package_diagram_desktop_component.model.Coltivazione getColtivazione() {
		return coltivazione;
	}
	
	public void setAmbiente(package_diagram_desktop_component.model.Ambiente value) {
		this.ambiente = value;
	}
	
	public package_diagram_desktop_component.model.Ambiente getAmbiente() {
		return ambiente;
	}
	
	public void modificaAmbiente() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void getTipoColtivazione() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getAttribute());
	}
	
}
