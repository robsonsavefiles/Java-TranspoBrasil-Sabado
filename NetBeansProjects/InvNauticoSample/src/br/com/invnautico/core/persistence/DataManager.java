/*
 * DataManager.java
 *
 * Created on 1 de Fevereiro de 2006, 10:25
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.invnautico.core.persistence;

import br.com.invnautico.core.model.INBrand;
import br.com.invnautico.core.model.INCategory;
import br.com.invnautico.core.model.INEquipment;
import br.com.invnautico.core.model.INLocation;
import br.com.invnautico.core.model.INMembership;
import java.net.URL;
import java.util.Collection;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/**
 *
 * @author vsenger
 */
public class DataManager {
    private static DataManager instance = new DataManager();
    protected URL url  ;
    protected Configuration cfg ;
    protected SessionFactory sf ;
    protected Session session ;
    private boolean aberta;
    
    public static DataManager getInstance() {
        return instance;
    }
    public void close()  {
        session.close();
        sf.close();
        aberta=false;
    }
    public boolean isOpen(){
        return aberta;
    }
    public String open() {
        try {
            url = DataManager.class.getResource("hibernate-config.xml");
            cfg = new Configuration();
            cfg.configure(url);
            sf = cfg.buildSessionFactory();
            session = sf.openSession();
            session.setFlushMode(FlushMode.COMMIT);
            aberta=true;
            return "";
        }
        catch(HibernateException e) {
            System.out.println("ERRO FATAL: camada de persistencia DataManager / Hibernate - " + e.getMessage());
            e.printStackTrace();
            aberta=false;
            return e.getMessage();
        }
        
    }
    private DataManager() {
        
    }
    public Collection<INEquipment> getEquipamentos() {
        String hql1 = "from INEquipment e order by e.nome";
        Query q1 = session.createQuery(hql1);
        Collection<INEquipment> r = (Collection<INEquipment>) q1.list();
        return r;
    }
    
    public Collection<INBrand> getMarcas() {
        String hql1 = "from INBrand b order by b.descricao";
        Query q1 = session.createQuery(hql1);
        Collection<INBrand> r = (Collection<INBrand>) q1.list();
        return r;
        
    }
    
    public Collection<INCategory> getCategorias() {
        String hql1 = "from INCategory c order by c.descricao";
        Query q1 = session.createQuery(hql1);
        Collection<INCategory> r = (Collection<INCategory>) q1.list();
        return r;
        
    }
    public Collection<INLocation> getLocais() {
        String hql1 = "from INLocation l order by l.descricao";
        Query q1 = session.createQuery(hql1);
        Collection<INLocation> r = (Collection<INLocation>) q1.list();
        return r;
    }

    public Collection<INMembership> getMemberships() {
        String hql1 = "from INMembership l order by l.nome";
        Query q1 = session.createQuery(hql1);
        Collection<INMembership> r = (Collection<INMembership>) q1.list();
        return r;
    }

    public void save(Object entity) {
        Transaction t = session.beginTransaction();
        session.saveOrUpdate(entity);
        t.commit();
    }
    public void delete(Object entity) {
        Transaction t = session.beginTransaction();
        session.delete(entity);
        t.commit();
    }
}
