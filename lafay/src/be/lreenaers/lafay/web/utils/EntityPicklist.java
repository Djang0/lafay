package be.lreenaers.lafay.web.utils;

import java.util.List;

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import be.lreenaers.lafay.DAOs.DAO;

public class EntityPicklist<C> {
	private DAO<C> dao;
	private DualListModel<C> picks;
	private List<C> source;
	private List<C> target;

	public EntityPicklist(DAO<C> dao) {
		this.dao = dao;
		source = this.dao.all();
	}

	public DualListModel<C> getPicks(List<C> trgt) {
		this.target = trgt;
		this.source = this.dao.all();
		this.source.removeAll(this.target);
		this.picks = new DualListModel<C>(this.source, this.target);
		return this.picks;
	}

	public List<C> getTarget() {
		return this.picks.getTarget();
	}

	@SuppressWarnings("unchecked")
	public List<C> getTransfered(TransferEvent event, List<C> lst) {
		for (Object item : event.getItems()) {
			C cls = (C) item;
			if (event.isAdd()) {
				lst.add(cls);
			} else {
				lst.remove(cls);
			}
		}
		return lst;
	}

	public void setPicks(DualListModel<C> pickz) {
		this.picks = pickz;
	}
}
