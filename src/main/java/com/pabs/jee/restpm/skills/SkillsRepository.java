package com.pabs.jee.restpm.skills;

import java.util.List;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class SkillsRepository {
    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    /**
     * Find all the Contacts and sort them alphabetically by last name.
     *
     * @return List of Contacts
     */
    List<Skill> findAllOrderedByName() {
        TypedQuery<Skill> query = em.createNamedQuery(Skill.FIND_ALL, Skill.class);
        List<Skill> skills = query.getResultList();
        return skills;
    }

    /**
     * Find just one Contact by it's ID.
     *
     * @param id
     * @return Contact
     */
    Skill findById(Long id) {
        return em.find(Skill.class, id);
    }

    /**
     * Find just one Contact by the email that is passed in. If there is more then one, only the first will be returned.
     *
     * @param email
     * @return Contact
     */
    Skill findByName(String name) {
        TypedQuery<Skill> query = em.createNamedQuery(Skill.FIND_BY_NAME, Skill.class).setParameter("name", name);
        Skill contact = query.getSingleResult();
        return contact;
    }


}
