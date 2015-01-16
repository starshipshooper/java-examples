/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threatconnect_api;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author adnan
 *
 */
public class ThreatconnectProgram {
    
    static final BigInteger API_KEY = new BigInteger("42381729235048937575");
    static final String SECRET_KEY = "SECRET KEY HERE";
    static final String path = "/v1/indicators";
    /**
     * @param args the command line arguments
     *
     */
    public static void main(String[] args) {
        generate_headers();
    }

    public static void generate_headers() {
        SecretKeySpec keySpec;
        Long timestamp = System.currentTimeMillis() / 1000L;
        String signature = String.format("%s:%s:%d", path, "GET", timestamp);
        byte[] hmac_signature;
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            keySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "HmacSHA256");
            sha256_HMAC.init(keySpec);
            hmac_signature = sha256_HMAC.doFinal();
            String hash = Base64.encodeBase64String(sha256_HMAC.doFinal(signature.getBytes()));
            System.out.println("Encoded Signature: " + hash);
            String authorization = String.format("TC %d:%s", API_KEY, hash);
            URL threatconnect = new URL(String.format("https://api.threatconnect.com%s", path));
            HttpURLConnection connection = (HttpURLConnection) threatconnect.openConnection();
            connection.setRequestProperty("accept", "application/json");
            connection.setRequestProperty("timestamp", timestamp.toString());
            connection.setRequestProperty("authorization", authorization);
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            connection.connect();
            System.out.println(authorization);
            System.out.println(connection.getResponseCode());
            System.out.println(threatconnect.toString());
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ThreatconnectProgram.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Algorithm doesn't exist");
        } catch (InvalidKeyException ex) {
            Logger.getLogger(ThreatconnectProgram.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Key is invalid");
        } catch (MalformedURLException ex) {
            Logger.getLogger(ThreatconnectProgram.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ThreatconnectProgram.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("URL given is bad.");
        }
       

    }


}
