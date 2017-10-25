import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.event.SlideEndEvent;

@ManagedBean
public class rradBean {

    private int number1 = 2;

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public void onInputChanged(ValueChangeEvent event) {
        FacesMessage message = new FacesMessage("Input Changed", "Value: " + event.getNewValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void onSlideEnd(SlideEndEvent event) {
        FacesMessage message = new FacesMessage("Slide Ended", "Value: " + event.getValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}