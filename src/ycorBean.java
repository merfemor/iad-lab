import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

import static org.primefaces.component.menubutton.MenuButton.PropertyKeys.value;

@ManagedBean(name=ycorBean.BEAN_NAME)
@SessionScoped
public class ycorBean implements Serializable{
    public static final String BEAN_NAME = "slider";
    public String getBeanName() { return BEAN_NAME; }
    private String axis;
    private boolean clickableRail;
    private String length;
    private int minValue;
    private int maxValue;
    private int sliderValue;
    private int stepPercent;
    private boolean showLabels;

    public ycorBean() {
        initialaziInstanceVariables();
        this.sliderValue = -2;
    }

    private void initialaziInstanceVariables() {
        this.axis = "x";
        this.clickableRail =true;
        this.length = "100";
        this.minValue = -2;
        this.maxValue = 2;
        this.sliderValue = 0;
        this.stepPercent = 25;
        this.showLabels = true;
    }

    public String getAxis() {
        return axis;
    }

    public void setAxis(String axis) {
        this.axis = axis;
    }

    public boolean getshowLabels(){
        return this.showLabels;
    }

    public void setshowLabels(){
        this.showLabels = showLabels;
    }

    public boolean isClickableRail() {
        return clickableRail;
    }

    public void setClickableRail(boolean clickableRail) {
        this.clickableRail = clickableRail;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getSliderValue() {
        return sliderValue;
    }

    public void setSliderValue(int sliderValue) {
        this.sliderValue = sliderValue;
    }

    public int getStepPercent() {
        return stepPercent;
    }

    public void setStepPercent(int stepPercent) {
        this.stepPercent = stepPercent;
    }
}
