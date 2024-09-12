package nvntrau.com;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeCustomTag extends SimpleTagSupport {

    private String color;
    private String size;

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MMM - dd - yyy HH:mm");
        String formattedDate = formatter.format(date);
        out.write("<span style=\"color: " + color + "; font-size: " + size + ";\">" + formattedDate + "</span>");
    }

}
