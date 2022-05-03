package org.example;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class FactAboutCat {
    @JsonProperty
    private String id;

    @JsonProperty("text")
    private String factText;

    @JsonProperty
    private String type;

    @JsonProperty
    private String user;

    @JsonProperty
    private int upvotes;

    public FactAboutCat() {
    }

    public FactAboutCat(String id, String factText, String type, String user, int upvotes) {
        this.id = id;
        this.factText = factText;
        this.type = type;
        this.user = user;
        this.upvotes = upvotes;
    }

    public String getId() {
        return id;
    }

    @JsonSetter
    public void setId(String id) {
        this.id = id;
    }

    public String getFactText() {
        return factText;
    }
    @JsonSetter
    public void setFactText(String factText) {
        this.factText = factText;
    }

    public String getType() {
        return type;
    }
    @JsonSetter
    public void setType(String type) {
        this.type = type;
    }

    public String getUser() {
        return user;
    }
    @JsonSetter
    public void setUser(String user) {
        this.user = user;
    }

    public int getUpvotes() {
        return upvotes;
    }

    @JsonSetter
    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    @Override
    public String toString() {
        return "FactAboutCat{" +
                "id='" + id + '\'' +
                ", factText='" + factText + '\'' +
                ", type='" + type + '\'' +
                ", user='" + user + '\'' +
                ", upvotes='" + upvotes + '\'' +
                '}';
    }
}
