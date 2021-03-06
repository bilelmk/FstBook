/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBeans;

import entities.Utilisateur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author SADOK
 */
@Stateless
public class UtilisateurFacade extends AbstractFacade<Utilisateur> {

    @PersistenceContext(unitName = "Tp8PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UtilisateurFacade() {
        super(Utilisateur.class);
    }
    public Utilisateur findByEmail(String email) {
        Query query=em.createNamedQuery("Utilisateur.findByEmail", Utilisateur.class);
        query.setParameter("email",email);
        return  (Utilisateur) query.getSingleResult();
    }
    
     public Utilisateur findById(int id) {
        Query query=em.createNamedQuery("Utilisateur.findbyId", Utilisateur.class);
        query.setParameter("id",id);
        return  (Utilisateur) query.getSingleResult();
    }

}
