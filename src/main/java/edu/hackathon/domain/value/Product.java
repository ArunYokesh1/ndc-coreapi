/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package edu.hackathon.domain.value;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 *
 * @since May 28, 2016
 * @version 1.0
 */
public class Product {

    @JsonProperty("imageLogo")
    private String imageLogo;

    /**
     * 
     * @return The imageLogo
     */
    @JsonProperty("imageLogo")
    public String getImageLogo() {
        return imageLogo;
    }

    /**
     * 
     * @param imageLogo The imageLogo
     */
    @JsonProperty("imageLogo")
    public void setImageLogo(String imageLogo) {
        this.imageLogo = imageLogo;
    }

}
