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

public class AmbienteDAO {
	public static Ambiente loadAmbienteByORMID(int attribute) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return loadAmbienteByORMID(session, attribute);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ambiente getAmbienteByORMID(int attribute) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return getAmbienteByORMID(session, attribute);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ambiente loadAmbienteByORMID(int attribute, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return loadAmbienteByORMID(session, attribute, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ambiente getAmbienteByORMID(int attribute, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return getAmbienteByORMID(session, attribute, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ambiente loadAmbienteByORMID(PersistentSession session, int attribute) throws PersistentException {
		try {
			return (Ambiente) session.load(package_diagram_desktop_component.model.Ambiente.class, new Integer(attribute));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ambiente getAmbienteByORMID(PersistentSession session, int attribute) throws PersistentException {
		try {
			return (Ambiente) session.get(package_diagram_desktop_component.model.Ambiente.class, new Integer(attribute));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ambiente loadAmbienteByORMID(PersistentSession session, int attribute, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ambiente) session.load(package_diagram_desktop_component.model.Ambiente.class, new Integer(attribute), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ambiente getAmbienteByORMID(PersistentSession session, int attribute, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ambiente) session.get(package_diagram_desktop_component.model.Ambiente.class, new Integer(attribute), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAmbiente(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return queryAmbiente(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAmbiente(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return queryAmbiente(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ambiente[] listAmbienteByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return listAmbienteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ambiente[] listAmbienteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return listAmbienteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAmbiente(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From package_diagram_desktop_component.model.Ambiente as Ambiente");
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
	
	public static List queryAmbiente(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From package_diagram_desktop_component.model.Ambiente as Ambiente");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ambiente", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ambiente[] listAmbienteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryAmbiente(session, condition, orderBy);
			return (Ambiente[]) list.toArray(new Ambiente[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ambiente[] listAmbienteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryAmbiente(session, condition, orderBy, lockMode);
			return (Ambiente[]) list.toArray(new Ambiente[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ambiente loadAmbienteByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return loadAmbienteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ambiente loadAmbienteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return loadAmbienteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ambiente loadAmbienteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Ambiente[] ambientes = listAmbienteByQuery(session, condition, orderBy);
		if (ambientes != null && ambientes.length > 0)
			return ambientes[0];
		else
			return null;
	}
	
	public static Ambiente loadAmbienteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Ambiente[] ambientes = listAmbienteByQuery(session, condition, orderBy, lockMode);
		if (ambientes != null && ambientes.length > 0)
			return ambientes[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateAmbienteByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return iterateAmbienteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAmbienteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession();
			return iterateAmbienteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAmbienteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From package_diagram_desktop_component.model.Ambiente as Ambiente");
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
	
	public static java.util.Iterator iterateAmbienteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From package_diagram_desktop_component.model.Ambiente as Ambiente");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ambiente", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ambiente createAmbiente() {
		return new package_diagram_desktop_component.model.Ambiente();
	}
	
	public static boolean save(package_diagram_desktop_component.model.Ambiente ambiente) throws PersistentException {
		try {
			package_diagram_desktop_component.model.GreenhousePersistentManager.instance().saveObject(ambiente);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(package_diagram_desktop_component.model.Ambiente ambiente) throws PersistentException {
		try {
			package_diagram_desktop_component.model.GreenhousePersistentManager.instance().deleteObject(ambiente);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(package_diagram_desktop_component.model.Ambiente ambiente) throws PersistentException {
		try {
			package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession().refresh(ambiente);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(package_diagram_desktop_component.model.Ambiente ambiente) throws PersistentException {
		try {
			package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession().evict(ambiente);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ambiente loadAmbienteByCriteria(AmbienteCriteria ambienteCriteria) {
		Ambiente[] ambientes = listAmbienteByCriteria(ambienteCriteria);
		if(ambientes == null || ambientes.length == 0) {
			return null;
		}
		return ambientes[0];
	}
	
	public static Ambiente[] listAmbienteByCriteria(AmbienteCriteria ambienteCriteria) {
		return ambienteCriteria.listAmbiente();
	}
}
