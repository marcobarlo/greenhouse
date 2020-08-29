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

public class ColtivazioneDAO {
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
	
	public static Coltivazione createColtivazione() {
		return new package_diagram_desktop_component.model.Coltivazione();
	}
	
	public static boolean save(package_diagram_desktop_component.model.Coltivazione coltivazione) throws PersistentException {
		try {
			package_diagram_desktop_component.model.GreenhousePersistentManager.instance().saveObject(coltivazione);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(package_diagram_desktop_component.model.Coltivazione coltivazione) throws PersistentException {
		try {
			package_diagram_desktop_component.model.GreenhousePersistentManager.instance().deleteObject(coltivazione);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(package_diagram_desktop_component.model.Coltivazione coltivazione)throws PersistentException {
		try {
			if (coltivazione.getDescrizione() != null) {
				coltivazione.getDescrizione().coltivazioni.remove(coltivazione);
			}
			
			if (coltivazione.getArea() != null) {
				coltivazione.getArea().setColtivazione(null);
			}
			
			return delete(coltivazione);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(package_diagram_desktop_component.model.Coltivazione coltivazione, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (coltivazione.getDescrizione() != null) {
				coltivazione.getDescrizione().coltivazioni.remove(coltivazione);
			}
			
			if (coltivazione.getArea() != null) {
				coltivazione.getArea().setColtivazione(null);
			}
			
			try {
				session.delete(coltivazione);
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
	
	public static boolean refresh(package_diagram_desktop_component.model.Coltivazione coltivazione) throws PersistentException {
		try {
			package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession().refresh(coltivazione);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(package_diagram_desktop_component.model.Coltivazione coltivazione) throws PersistentException {
		try {
			package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession().evict(coltivazione);
			return true;
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
}
