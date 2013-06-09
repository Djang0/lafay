package be.lreenaers.lafay.beans;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Id;

public class Bean {
	@Id private ObjectId id;
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
}
