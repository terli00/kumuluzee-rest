package com.kumuluz.ee.rest.test.entities;

import com.kumuluz.ee.rest.annotations.RestIgnore;
import com.kumuluz.ee.rest.test.entities.enums.ProjectStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author Tilen Faganel
 */
@Entity
@RestIgnore({"projectIgnoreField"})
@Table(name = "projects")
@NamedQueries({@NamedQuery(name = "Project.getAll", query = "SELECT p FROM Project p")})
public class Project implements Serializable {

    @Id
    private Integer id;

    @Column(name = "public_id")
    private UUID publicId;

    private String name;

    private String description;

    private ProjectStatus status;

    @OneToOne(mappedBy = "project")
    private ProjectLocation projectLocation;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UUID getPublicId() {
        return publicId;
    }

    public void setPublicId(UUID publicId) {
        this.publicId = publicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ProjectLocation getProjectLocation() {
        return projectLocation;
    }

    public void setProjectLocation(ProjectLocation projectLocation) {
        this.projectLocation = projectLocation;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", projectLocation=" + projectLocation +
                '}';
    }
}
