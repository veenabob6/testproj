package main.java.com.veena.hello.dvo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by veenanairv on 4/12/2017.
 */
@Entity
@Table(name = "actor_info", schema = "sakila", catalog = "")
public class ActorInfo {
    private short actorId;
    private String firstName;
    private String lastName;
    private String filmInfo;

    @Basic
    @Column(name = "actor_id", nullable = false)
    public short getActorId() {
        return actorId;
    }

    public void setActorId(short actorId) {
        this.actorId = actorId;
    }

    @Basic
    @Column(name = "first_name", nullable = false, length = 45)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = false, length = 45)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "film_info", nullable = true, length = -1)
    public String getFilmInfo() {
        return filmInfo;
    }

    public void setFilmInfo(String filmInfo) {
        this.filmInfo = filmInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActorInfo actorInfo = (ActorInfo) o;

        if (actorId != actorInfo.actorId) return false;
        if (firstName != null ? !firstName.equals(actorInfo.firstName) : actorInfo.firstName != null) return false;
        if (lastName != null ? !lastName.equals(actorInfo.lastName) : actorInfo.lastName != null) return false;
        if (filmInfo != null ? !filmInfo.equals(actorInfo.filmInfo) : actorInfo.filmInfo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) actorId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (filmInfo != null ? filmInfo.hashCode() : 0);
        return result;
    }
}
