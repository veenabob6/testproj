package main.java.com.veena.hello.dvo;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Actor {
	private int actor_id;
	private String first_name;
	private String last_name;
    private short actorId;
    private String firstName;
    private String lastName;
    private Timestamp lastUpdate;
   // private Collection<FilmActor> filmActorsByActorId;

	public int getActor_id() {
		return actor_id;
	}

	public void setActor_id(int actor_id) {
		this.actor_id = actor_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

    @Id
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
    @Column(name = "last_update", nullable = false)
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Actor actor = (Actor) o;

        if (actorId != actor.actorId) return false;
        if (firstName != null ? !firstName.equals(actor.firstName) : actor.firstName != null) return false;
        if (lastName != null ? !lastName.equals(actor.lastName) : actor.lastName != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(actor.lastUpdate) : actor.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) actorId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }

//    @OneToMany(mappedBy = "actorByActorId")
//    public Collection<FilmActor> getFilmActorsByActorId() {
//        return filmActorsByActorId;
//    }
//
//    public void setFilmActorsByActorId(Collection<FilmActor> filmActorsByActorId) {
//        this.filmActorsByActorId = filmActorsByActorId;
//    }
}
