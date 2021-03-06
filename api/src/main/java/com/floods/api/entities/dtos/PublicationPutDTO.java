package com.floods.api.entities.dtos;

import com.floods.api.enums.CategoryType;
import com.floods.api.enums.HelpType;
import com.floods.api.enums.PublicationType;

public class PublicationPutDTO {
    private long id;
    private UserNoPasswordDTO user;
    private PublicationType publicationType;
    private HelpType helpType;
    private CategoryType category;
    private String title;
    private String city;
    private String date;
    private String description;
    private boolean urgent;
    private boolean hidden;

    public PublicationPutDTO(long id, UserNoPasswordDTO user, PublicationType publicationType, HelpType helpType, CategoryType category, String title, String city, String date, String description, boolean urgent, boolean hidden) {
        this.id = id;
        this.user = user;
        this.publicationType = publicationType;
        this.helpType = helpType;
        this.category = category;
        this.title = title;
        this.city = city;
        this.date = date;
        this.description = description;
        this.urgent = urgent;
        this.hidden = hidden;
    }

    @Override
    public String toString() {
        return "PublicationPutDTO{" +
                "id=" + id +
                ", user=" + user +
                ", publicationType=" + publicationType +
                ", helpType=" + helpType +
                ", category=" + category +
                ", title='" + title + '\'' +
                ", city='" + city + '\'' +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", urgent=" + urgent +
                ", hidden=" + hidden +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserNoPasswordDTO getUser() {
        return user;
    }

    public void setUser(UserNoPasswordDTO user) {
        this.user = user;
    }

    public PublicationType getPublicationType() {
        return publicationType;
    }

    public void setPublicationType(PublicationType publicationType) {
        this.publicationType = publicationType;
    }

    public HelpType getHelpType() {
        return helpType;
    }

    public void setHelpType(HelpType helpType) {
        this.helpType = helpType;
    }

    public CategoryType getCategory() {
        return category;
    }

    public void setCategory(CategoryType category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}
