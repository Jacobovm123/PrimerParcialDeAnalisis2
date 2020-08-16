/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.Instant;

/**
 *
 * @author jacob
 */
public class ValidadorDeToken {
 
       public static boolean isValidate(Tokens_Model token){
        String iss="https://accounts.google.com";
        String client_ID="27541583904-heskbclek74h13abqe3cqurmvpanv71n.apps.googleusercontent.com";

        String claims=JWTDecoder.getClaims(token.id_token);
        Google_Token_Claims_Model claimsGoogle=new com.google.gson.Gson().fromJson(claims,Google_Token_Claims_Model.class);

        return claimsGoogle.iss.equals(iss) && Long.parseLong(claimsGoogle.exp) > Instant.now().getEpochSecond() && claimsGoogle.aud.equals(client_ID);
    }
}
