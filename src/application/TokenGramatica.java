/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Objects;

/**
 *
 * @author tcloss
 */
public class TokenGramatica {
    private TipoToken token;
    private String pattern;

    public TokenGramatica(TipoToken token, String pattern) {
        this.token = token;
        this.pattern = pattern;
    }

    public TipoToken getToken() {
        return token;
    }

    public void setToken(TipoToken token) {
        this.token = token;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.token);
        hash = 29 * hash + Objects.hashCode(this.pattern);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass()==String.class){
            if(obj.toString().matches(this.pattern)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "TokenGramatica{" + "token=" + token + '}';
    }
    
    
    
}
