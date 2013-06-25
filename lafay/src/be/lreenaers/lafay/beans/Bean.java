package be.lreenaers.lafay.beans;

import java.io.Serializable;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
@Entity
public class Bean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id protected ObjectId id;
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public boolean equals(Object o){
		return ((Bean) o).getId().toString().equals(this.id.toString());
	}
}
