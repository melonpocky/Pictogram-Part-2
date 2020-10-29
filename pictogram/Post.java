package com.example.pictogram;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.Date;

@ParseClassName("Post")
public class Post extends ParseObject{

    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_USER = "user";
    public static final String KEY_CREATED = "createdAt";


    public String getDescription()
    {
        return getString(KEY_DESCRIPTION);
    }
    public void setDescription(String description)
    {
        put(KEY_DESCRIPTION, description);
    }

    public ParseFile getImage()
    {
        return getParseFile(KEY_IMAGE);
    }
    public void setImage(ParseFile parseFile)
    {
        put(KEY_IMAGE, parseFile);
    }

    public ParseUser getUser()
    {
        return getParseUser(KEY_USER);
    }
    public void setUser(ParseUser parseUser)
    {
        put(KEY_USER, parseUser);
    }

/*
    public ParseObject getTime()
    {
        return getParseObject(KEY_CREATED);
    }
    public void setTime(String createdTime)
    {
        put(KEY_CREATED, createdTime);
    }
*/

    public ParseFile getMedia() { return getParseFile("media");}
    public void setMedia(ParseFile parseFile) {
        put("media", parseFile);
    }


}
