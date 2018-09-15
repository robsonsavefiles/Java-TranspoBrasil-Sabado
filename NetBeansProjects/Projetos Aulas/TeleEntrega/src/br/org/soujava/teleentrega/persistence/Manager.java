package br.org.soujava.teleentrega.persistence;

import br.org.soujava.teleentrega.model.Cliente;
import br.org.soujava.teleentrega.model.Item;
import br.org.soujava.teleentrega.model.Pedido;
import java.net.URL;
import java.util.Collection;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class Manager {
  private static Manager instance = new Manager();
  protected URL url  ;
  protected Configuration cfg ;
  protected SessionFactory sf ;
  protected Session session ;
  private boolean aberta;
  public static void main(String args[]) throws Exception {
    Manager.getInstance().open();
    Manager.getInstance().testIt();
    Collection<Cliente> clientes = Manager.getInstance().getClientes();
    Cliente c1 = (Cliente) clientes.iterator().next();
    Pedido p1 = new Pedido();
    p1.setObservacoes("teste");
    p1.setCliente(c1);
    Item i1 = new Item();
    Item i2 = new Item();
    i1.setPedido(p1);
    i2.setPedido(p1);
    i1.setDescricao("i1");
    i2.setDescricao("i2");
    p1.getItens().add(i1);
    p1.getItens().add(i2);
    Manager.getInstance().save(p1);
  }
  public void testIt() throws Exception {
    Collection<Cliente> clientes = getClientes();
    for(Cliente cliente : clientes) {
      System.out.println(cliente.getNome());
    }
   
  }
  public Collection<Cliente> getClientes() {
    String hql1 = "from Cliente";
    Query q1 = session.createQuery(hql1);
    Collection<Cliente> clientes = (Collection<Cliente>) q1.list();
    return clientes;
  }
  public Collection<Pedido> getPedidos() {
    String hql1 = "from Pedido";
    Query q1 = session.createQuery(hql1);
    Collection<Pedido> pedidos = (Collection<Pedido>) q1.list();
    return pedidos;
  }
  
  public void save(Object objeto) {
    Transaction t = session.beginTransaction();
    session.saveOrUpdate(objeto);
    t.commit();
    
  }
  public void delete(Object objeto) {
    Transaction t = session.beginTransaction();
    session.delete(objeto);
    t.commit();
    
  }
  public static Manager getInstance() {
    return instance;
  }
  public Manager() {
    open();
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
      url = Manager.class.getResource("hibernate-config.xml");
      cfg = new Configuration();
      cfg.configure(url);
      sf = cfg.buildSessionFactory();
      session = sf.openSession();
      session.setFlushMode(FlushMode.COMMIT);
      aberta=true;
      return "";
    } catch(HibernateException e) {
      System.out.println("ERRO FATAL: camada de persistencia DataManager / Hibernate - " + e.getMessage());
      e.printStackTrace();
      aberta=false;
      return e.getMessage();
    }
    
  }
  
}
