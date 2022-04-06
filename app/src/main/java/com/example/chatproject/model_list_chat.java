package com.example.chatproject;

public class
model_list_chat
{
    private String id;
    private String description;

    public model_list_chat(String description)
    {
        this.description = description;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
