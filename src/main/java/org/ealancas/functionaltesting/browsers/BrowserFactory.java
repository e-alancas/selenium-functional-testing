package org.ealancas.functionaltesting.browsers;

/**
 * <h2>BrowserFactory</h2>
 * The BrowserFactory class is part of the simple factory pattern
 * applied to create and manage multiple browsers such as chrome
 * and others.
 * <p>
 * Contains the logic for serving the right browser by name.
 *
 * <p>Usage example:</p>
 * <pre>{@code
 *     // Create a Chrome instance
 *     Browser chrome = new BrowserFactory().getBrowser("CHROME");
 *
 *     // Returns the driver to be used
 *     chrome.getDriver();
 * }</pre>
 *
 * @author Eliecer Alan
 * @author ealancascante@gmail.com
 * @author <a href="https://github.com/e-alancas">GitHub profile</a>
 * @version 1.0
 * @since 2023-08-25
 */
public class BrowserFactory {

    /**
     *
     * @param browserName The name of the browser. Options are:
     *                    <ul>
     *                      <li>Chrome</li>
     *                    </ul>
     * @return Browser instance
     */
    public Browser getBrowser (String browserName) {
        if (browserName == null){
            return null;
        }

        switch (browserName.toLowerCase()) {
            case "chrome":
                return new Chrome();
            default:
                return null;
        }
    }
}
