package it.exolab.tesina.auction.service.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.exolab.tesina.auction.model.Role;
import it.exolab.tesina.auction.repository.RoleRepo;

public class RoleService {
	private RoleRepo roleRepo;

	@Autowired(required = true)
	public void setInvoiceRepo(RoleRepo roleRepo) {
		this.roleRepo = roleRepo;
	}

	public Role find(int id) {
		return roleRepo.findOne(id);
	}

	public List<Role> findAll() {
		return (List<Role>) roleRepo.findAll();
	}

	public void save(Role model) {
		this.roleRepo.save(model);
	}

	public void delete(int id) {
		roleRepo.delete(id);
	}

}
