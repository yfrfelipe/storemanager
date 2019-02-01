/* Copyright (C) Yrineu Rodrigues - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Yrineu Rodrigues <yfrfelipe@gmail.com>, September 2018
 */

package br.com.storemanager.main;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class WebConfigurator implements WebMvcConfigurer {

    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/login").setViewName("login");
    }
}
