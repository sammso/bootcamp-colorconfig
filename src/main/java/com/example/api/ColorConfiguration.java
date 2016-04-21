package com.example.api;

import aQute.bnd.annotation.metatype.*;

@Meta.OCD(id = "com.example.api.ColorConfiguration")
public interface ColorConfiguration {
    @Meta.AD(
            deflt = "blue",
            required = false
            )
    public String favoriteColor();
    @Meta.AD(
            deflt = "red|green|blue",
            required = false
            )
    public String[] validLanguages();
    @Meta.AD(required = false)
    public int itemsPerPage();
}