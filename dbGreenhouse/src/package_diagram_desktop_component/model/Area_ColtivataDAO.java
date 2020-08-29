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

public class Area_ColtivataDAO {
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
	
	public static Area_Coltivata createArea_Coltivata() {
		return new package_diagram_desktop_component.model.Area_Coltivata();
	}
	
	public static boolean save(package_diagram_desktop_component.model.Area_Coltivata area_Coltivata) throws PersistentException {
		try {
			package_diagram_desktop_component.model.GreenhousePersistentManager.instance().saveObject(area_Coltivata);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(package_diagram_desktop_component.model.Area_Coltivata area_Coltivata) throws PersistentException {
		try {
			package_diagram_desktop_component.model.GreenhousePersistentManager.instance().deleteObject(area_Coltivata);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(package_diagram_desktop_component.model.Area_Coltivata area_Coltivata)throws PersistentException {
		try {
			if (area_Coltivata.getSezione() != null) {
				area_Coltivata.getSezione().aree.remove(area_Coltivata);
			}
			
			if (area_Coltivata.getColtivazione() != null) {
				area_Coltivata.getColtivazione().setArea(null);
			}
			
			return delete(area_Coltivata);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(package_diagram_desktop_component.model.Area_Coltivata area_Coltivata, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (area_Coltivata.getSezione() != null) {
				area_Coltivata.getSezione().aree.remove(area_Coltivata);
			}
			
			if (area_Coltivata.getColtivazione() != null) {
				area_Coltivata.getColtivazione().setArea(null);
			}
			
			try {
				session.delete(area_Coltivata);
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
	
	public static boolean refresh(package_diagram_desktop_component.model.Area_Coltivata area_Coltivata) throws PersistentException {
		try {
			package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession().refresh(area_Coltivata);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(package_diagram_desktop_component.model.Area_Coltivata area_Coltivata) throws PersistentException {
		try {
			package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession().evict(area_Coltivata);
			return true;
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
}
