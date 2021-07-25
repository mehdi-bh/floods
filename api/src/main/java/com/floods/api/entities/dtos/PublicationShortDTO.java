package com.floods.api.entities.dtos;

import com.floods.api.enums.CategoryType;
import com.floods.api.enums.HelpType;
import com.floods.api.enums.PublicationType;

public class PublicationShortDTO {
    private long id;
    private long idUser;
    private PublicationType publicationType;
    private HelpType helpType;
    private CategoryType category;
    private String title;
    private String city;
    private String date;
    private boolean urgent;

    public PublicationShortDTO(long id, long idUser, PublicationType publicationType, HelpType helpType, CategoryType category, String title, String city, String date, boolean urgent) {
        this.id = id;
        this.idUser = idUser;
        this.publicationType = publicationType;
        this.helpType = helpType;
        this.category = category;
        this.title = title;
        this.city = city;
        this.date = date;
        this.urgent = urgent;
    }

    @Override
    public String toString() {
        return "PublicationShortDTO{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", publicationType=" + publicationType +
                ", helpType=" + helpType +
                ", category=" + category +
                ", title='" + title + '\'' +
                ", city='" + city + '\'' +
                ", date='" + date + '\'' +
                ", urgent=" + urgent +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
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

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }
}
