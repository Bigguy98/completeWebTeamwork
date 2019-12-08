/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vutha
 */
public class SecurityUtil {
    public static String encode(String value) {
        String sha1 ="";
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
	    digest.update(value.getBytes("utf8"));
            sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SecurityUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(SecurityUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sha1;
        
    }
    
}
