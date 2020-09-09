package life.pifrans.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import life.pifrans.daos.GenericImplementationDAO;
import life.pifrans.daos.UserDAO;
import life.pifrans.models.User;

@Named
@RequestScoped
public class UserBean {
	
	private UserDAO dao =  new UserDAO();
	//private GenericImplementationDAO<User, Long> dao = new GenericImplementationDAO<>();
	private User user = new User();

	public String send() {
		user = dao.find(user.getName(), user.getPassword());
		if (user == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!", "Erro de login!"));
			return null;
		} else {
			return "/main.jsf";
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
