package life.pifrans.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import life.pifrans.daos.GenericImplementationDAO;
import life.pifrans.models.User;

@Named
@RequestScoped
public class UserBean {
	@Inject
	private GenericImplementationDAO<User, Long> dao2;
	@Inject
	private User user;

	public String send() {
		try {
			user = dao2.findByQueryResultSingle("SELECT u FROM User u WHERE u.name = '" + user.getName() + "' AND u.password = '" + user.getPassword() + "'");
			return "/main.jsf";
		} catch (NoResultException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!", "Erro de login!"));
			System.err.println(e.toString());
			return null;
		} catch (Exception e) {
			System.err.println(e.toString());
			return null;
		}
	}

	public String save() {
		if (user == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não foi salvo!", "Erro ao salvar usuário!"));
			return null;
		} else {
			try {
				user.setPermission("USER");
				user = dao2.save(user);
				return "/login.jsf";
			} catch (PersistenceException e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "E-mail já cadastrado!", "Erro ao salvar usuário!"));
				System.err.println("#-#" + e.toString());
				return null;
			} catch (Exception e) {
				System.err.println("*-*" + e.toString());
				return null;
			}
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}


// SELECT u FROM User u WHERE u.name =: name AND u.password =: password