package org.ealancas.functionaltesting.browsers;

public class BrowserFactory {
    public Browser getBrowser (String browserName) {
        if (browserName == null){
            return null;
        }

        if (browserName.equalsIgnoreCase("CHROME")){
            return new Chrome();
        }
        return null;
    }
}
