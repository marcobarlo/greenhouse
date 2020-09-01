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

public class ImpiegatoDAO {
	public static Impiegato loadImpiegatoByORMID(int attribute) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return loadImpiegatoByORMID(session, attribute);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Impiegato getImpiegatoByORMID(int attribute) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return getImpiegatoByORMID(session, attribute);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Impiegato loadImpiegatoByORMID(int attribute, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return loadImpiegatoByORMID(session, attribute, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Impiegato getImpiegatoByORMID(int attribute, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return getImpiegatoByORMID(session, attribute, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Impiegato loadImpiegatoByORMID(PersistentSession session, int attribute) throws PersistentException {
		try {
			return (Impiegato) session.load(package_diagram_desktop_component.model.Impiegato.class, new Integer(attribute));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Impiegato getImpiegatoByORMID(PersistentSession session, int attribute) throws PersistentException {
		try {
			return (Impiegato) session.get(package_diagram_desktop_component.model.Impiegato.class, new Integer(attribute));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Impiegato loadImpiegatoByORMID(PersistentSession session, int attribute, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Impiegato) session.load(package_diagram_desktop_component.model.Impiegato.class, new Integer(attribute), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Impiegato getImpiegatoByORMID(PersistentSession session, int attribute, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Impiegato) session.get(package_diagram_desktop_component.model.Impiegato.class, new Integer(attribute), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryImpiegato(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return queryImpiegato(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryImpiegato(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return queryImpiegato(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Impiegato[] listImpiegatoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return listImpiegatoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Impiegato[] listImpiegatoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return listImpiegatoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryImpiegato(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From package_diagram_desktop_component.model.Impiegato as Impiegato");
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
	
	public static List queryImpiegato(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From package_diagram_desktop_component.model.Impiegato as Impiegato");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Impiegato", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Impiegato[] listImpiegatoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryImpiegato(session, condition, orderBy);
			return (Impiegato[]) list.toArray(new Impiegato[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Impiegato[] listImpiegatoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryImpiegato(session, condition, orderBy, lockMode);
			return (Impiegato[]) list.toArray(new Impiegato[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Impiegato loadImpiegatoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return loadImpiegatoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Impiegato loadImpiegatoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return loadImpiegatoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Impiegato loadImpiegatoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Impiegato[] impiegatos = listImpiegatoByQuery(session, condition, orderBy);
		if (impiegatos != null && impiegatos.length > 0)
			return impiegatos[0];
		else
			return null;
	}
	
	public static Impiegato loadImpiegatoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Impiegato[] impiegatos = listImpiegatoByQuery(session, condition, orderBy, lockMode);
		if (impiegatos != null && impiegatos.length > 0)
			return impiegatos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateImpiegatoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return iterateImpiegatoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateImpiegatoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return iterateImpiegatoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateImpiegatoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From package_diagram_desktop_component.model.Impiegato as Impiegato");
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
	
	public static java.util.Iterator iterateImpiegatoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From package_diagram_desktop_component.model.Impiegato as Impiegato");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Impiegato", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Impiegato createImpiegato() {
		return new package_diagram_desktop_component.model.Impiegato();
	}
	
	public static boolean save(package_diagram_desktop_component.model.Impiegato impiegato) throws PersistentException {
		try {
			package_diagram_desktop_component.model.GreenhousePersistentManager.instance().saveObject(impiegato);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(package_diagram_desktop_component.model.Impiegato impiegato) throws PersistentException {
		try {
			package_diagram_desktop_component.model.GreenhousePersistentManager.instance().deleteObject(impiegato);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(package_diagram_desktop_component.model.Impiegato impiegato) throws PersistentException {
		try {
			package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession().refresh(impiegato);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(package_diagram_desktop_component.model.Impiegato impiegato) throws PersistentException {
		try {
			package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession().evict(impiegato);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Impiegato loadImpiegatoByCriteria(ImpiegatoCriteria impiegatoCriteria) {
		Impiegato[] impiegatos = listImpiegatoByCriteria(impiegatoCriteria);
		if(impiegatos == null || impiegatos.length == 0) {
			return null;
		}
		return impiegatos[0];
	}
	
	public static Impiegato[] listImpiegatoByCriteria(ImpiegatoCriteria impiegatoCriteria) {
		return impiegatoCriteria.listImpiegato();
	}
}