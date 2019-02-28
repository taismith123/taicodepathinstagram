package com.example.taicodepathinstagram;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Post")
public class Post extends ParseObject {
    // Ensure that your subclass has a public default constructor

    public final static String KEY_DESCRIPTION = "description";
    public final static String KEY_IMAGE = "image";
    public final static String KEY_USER = "user";
    public final static String KEY_CREATED_AT = "createdAt";

    public String getDescription(){
        return getString(KEY_DESCRIPTION);
    }

    public void  setDescription(String description) {
        put(KEY_DESCRIPTION, description);
    }

    public ParseFile getImage() {
        return getParseFile(KEY_IMAGE);
    }

    public void setImage(ParseFile parseFile) {
       put(KEY_IMAGE, parseFile);
    }


    public ParseUser getUser () {
      return getParseUser(KEY_USER);
    }

    public void setUser(ParseUser parseUser){
        put(KEY_USER,parseUser);
    }
}
