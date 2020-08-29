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

public class Descrizione_ColtivazioneDAO {
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
	
	public static Descrizione_Coltivazione createDescrizione_Coltivazione() {
		return new package_diagram_desktop_component.model.Descrizione_Coltivazione();
	}
	
	public static boolean save(package_diagram_desktop_component.model.Descrizione_Coltivazione descrizione_Coltivazione) throws PersistentException {
		try {
			package_diagram_desktop_component.model.GreenhousePersistentManager.instance().saveObject(descrizione_Coltivazione);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(package_diagram_desktop_component.model.Descrizione_Coltivazione descrizione_Coltivazione) throws PersistentException {
		try {
			package_diagram_desktop_component.model.GreenhousePersistentManager.instance().deleteObject(descrizione_Coltivazione);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(package_diagram_desktop_component.model.Descrizione_Coltivazione descrizione_Coltivazione)throws PersistentException {
		try {
			package_diagram_desktop_component.model.Coltivazione[] lColtivazionis = descrizione_Coltivazione.coltivazioni.toArray();
			for(int i = 0; i < lColtivazionis.length; i++) {
				lColtivazionis[i].setDescrizione(null);
			}
			return delete(descrizione_Coltivazione);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(package_diagram_desktop_component.model.Descrizione_Coltivazione descrizione_Coltivazione, org.orm.PersistentSession session)throws PersistentException {
		try {
			package_diagram_desktop_component.model.Coltivazione[] lColtivazionis = descrizione_Coltivazione.coltivazioni.toArray();
			for(int i = 0; i < lColtivazionis.length; i++) {
				lColtivazionis[i].setDescrizione(null);
			}
			try {
				session.delete(descrizione_Coltivazione);
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
	
	public static boolean refresh(package_diagram_desktop_component.model.Descrizione_Coltivazione descrizione_Coltivazione) throws PersistentException {
		try {
			package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession().refresh(descrizione_Coltivazione);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(package_diagram_desktop_component.model.Descrizione_Coltivazione descrizione_Coltivazione) throws PersistentException {
		try {
			package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession().evict(descrizione_Coltivazione);
			return true;
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
}
