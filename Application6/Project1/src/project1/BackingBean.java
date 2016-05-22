package project1;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;

@ManagedBean(name = "firstback")
@RequestScoped
@Generated(value = "1untitled1.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class BackingBean {
    private HtmlOutputText outputText1;
    private HtmlCommandButton commandButton1;
    private HtmlInputText inputText1;
    private HtmlForm form1;

    public BackingBean() {
    }

    public void setOutputText1(HtmlOutputText outputText1) {
        this.outputText1 = outputText1;
    }

    public HtmlOutputText getOutputText1() {
        return outputText1;
    }

    public void setCommandButton1(HtmlCommandButton commandButton1) {
        this.commandButton1 = commandButton1;
    }

    public HtmlCommandButton getCommandButton1() {
        return commandButton1;
    }

    public void setInputText1(HtmlInputText inputText1) {
        this.inputText1 = inputText1;
    }

    public HtmlInputText getInputText1() {
        return inputText1;
    }

    public void setForm1(HtmlForm form1) {
        this.form1 = form1;
    }

    public HtmlForm getForm1() {
        return form1;
    }

    public Object commandButton1_action() {
        // Add event code here...
        outputText1.setValue("Hallo " + inputText1.getValue());
        return null;
    }
}
