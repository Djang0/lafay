package be.lreenaers.lafay.web.controls;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import be.lreenaers.lafay.beans.Enchainable;
import be.lreenaers.lafay.beans.Niveau;
import be.lreenaers.lafay.factories.DAOFactory;
import be.lreenaers.lafay.web.utils.EntityPicklist;

@ManagedBean(name = "niveauCtrl")
@SessionScoped
public class NiveauCtrl extends Controler<Niveau> {
	private EntityPicklist<Enchainable> pickG;

	public NiveauCtrl() {
		super(Niveau.class);
		this.entityClassList.setWrappedData(this.dao.all());
		this.pickG = new EntityPicklist<Enchainable>(
				DAOFactory.getEnchainableDAO());
	}

	public DualListModel<Enchainable> getPickCreate() {
		return this.pickG.getPicks(this.entityClass.getEnchainables());
	}

	public DualListModel<Enchainable> getPickEdit() {
		return this.pickG.getPicks(this.entityClassEdit.getEnchainables());
	}

	public void onTransferCreate(TransferEvent event) {
		List<Enchainable> g = this.pickG.getTransfered(event,
				this.entityClass.getEnchainables());
		this.entityClass.setEnchainables(g);
	}

	public void onTransferEdit(TransferEvent event) {
		List<Enchainable> g = this.pickG.getTransfered(event,
				this.entityClassEdit.getEnchainables());
		this.entityClassEdit.setEnchainables(g);
	}

	@Override
	public void selectDAO() {
		this.dao = DAOFactory.getNiveauDAO();

	}

	public void setPickCreate(DualListModel<Enchainable> pickEditPerms) {
		this.pickG.setPicks(pickEditPerms);
		this.entityClass.setEnchainables(this.pickG.getTarget());
	}

	public void setPickEdit(DualListModel<Enchainable> pickEditPerms) {
		this.pickG.setPicks(pickEditPerms);
		this.entityClassEdit.setEnchainables(this.pickG.getTarget());
	}
}
