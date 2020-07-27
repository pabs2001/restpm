package com.pabs.jee.restpm.skills;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;





/**
 * Entity implementation class for Entity: Skill
 *
 */
@Entity
@XmlRootElement
@Table(name = "skills")
@NamedQueries({
    @NamedQuery(name = Skill.FIND_ALL, query = "SELECT s FROM Skill s ORDER BY s.name ASC"),
    @NamedQuery(name = Skill.FIND_BY_NAME, query = "SELECT s FROM Skill s WHERE s.name = :name")
})
public class Skill implements Serializable {

    public static final String FIND_ALL = "Skill.findAll";
    public static final String FIND_BY_NAME = "Skill.findByName";
	
	private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;  
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "level")
    private Long level;
    
    @Column(name = "comments")
    private String comments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getLevel() {
		return level;
	}

	public void setLevel(Long level) {
		this.level = level;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}
