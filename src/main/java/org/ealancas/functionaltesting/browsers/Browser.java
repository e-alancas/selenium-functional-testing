package org.ealancas.functionaltesting.browsers;

import org.openqa.selenium.WebDriver;

/**
 * <h2>Browser</h2>
 * The Browser interface is part of the simple factory pattern
 * applied to create and manage multiple browsers such as chrome
 * and others.
 * <p>
 * This contains all the needed functions and methods needed
 * by the browsers at a general level
 *
 *
 * @author Eliecer Alan
 * @author ealancascante@gmail.com
 * @author <a href="https://github.com/e-alancas">GitHub profile</a>
 * @version 1.0
 * @since 2023-08-25
 */

public interface Browser {
    /**
     * getDriver function definition that will be implemented in
     * all specific browser classes.
     * @return org.openqa.selenium.WebDriver instance
     */
    public WebDriver getDriver();
}
