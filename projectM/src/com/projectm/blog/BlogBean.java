package com.projectm.blog;

import java.util.Date;

/**
 * Created by max on 3/16/17.
 */
public class BlogBean {

    private String header;
    private String text;
    private String outDate;

    public BlogBean() {}

    public BlogBean(String outDate, String header, String text) {
        this.outDate = outDate;
        this.header = header;
        this.text = text;
    }

    public String getDate() {
        return outDate;
    }
    public String getHeader() {
        return header;
    }
    public String getText() {
        return text;
    }
    public void setDate(String outDate) {
        this.outDate = outDate;
    }
    public void setHeader(String header) {
        this.header = header;
    }
    public void setText(String text) {
        this.text = text;
    }

}
