package ca.uqac.archi.action;

import ca.uqac.archi.dao.EmployeDAO;
import ca.uqac.archi.model.Employe;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import freemarker.core.ParseException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Ianis
 */
public class ManageUsersAction extends ActionSupport implements SessionAware {
    public static EmployeDAO employeDAO = new EmployeDAO();

    private int id = 0;

    private String action;
    private List<Employe> listEmployees;
    private Map<String, Object> session;

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Map<String, Object> getSession() {
        return session;
    }
    private Employe employe = new Employe();

    @Override
    public String execute() {
        if(!(Boolean)session.get("admin"))
        {
             return "noadmin";
             
        }
        
        if(id != 0){//si l'id est défini c'est qu'on est sur la page modifier user
            employe = employeDAO.find(id);
        } else {//sinon on est sur la page du CRUD
            listEmployees = employeDAO.getAllEmployees();
        }

        action = "manageusers";//permet de mettre la classe css active sur le bon menu

        return SUCCESS;
    }

    public String add() throws ParseException {
        if(!(Boolean)session.get("admin"))
        {
             return "noadmin";
             
        }
        
          try {
            employeDAO.create(employe);
          } 
          catch (Exception e) {
            e.printStackTrace();
            }
        
        

        listEmployees = this.getListEmployees();
        id = 0;
        employe = new Employe(); //empty employe object, that will be read by manageusers.jsp (via this.getEmploye()) to prevent refilling form...
        return SUCCESS;
    }

    public String update() throws ParseException {
        if(!(Boolean)session.get("admin"))
        {
             return "noadmin";
             
        }
        try {
            employeDAO.update(employe);
        } catch (Exception e) {
            e.printStackTrace();
        }

        listEmployees = this.getListEmployees();
        id = 0;
        employe = new Employe(); //empty employe object, that will be read by manageusers.jsp (via this.getEmploye()) to prevent refilling form...
        return SUCCESS;
    }

    public String delete() {
        
        if(!(Boolean)session.get("admin"))
        {
             return "noadmin";
             
        }
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        id = Integer.parseInt(request.getParameter("id"));
        
        try {
            employeDAO.delete(employeDAO.find(id));
        } catch (Exception e) {
            e.printStackTrace();
        }

        listEmployees = this.getListEmployees();
        id = 0;
        employe = new Employe(); //empty employe object, that will be read by manageusers.jsp (via this.getEmploye()) to prevent refilling form...

        return SUCCESS;
    }

    public List<Employe> getListEmployees() {
        return listEmployees;
    }

    public void setListEmployees(List<Employe> listEmployees) {
        this.listEmployees = listEmployees;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
