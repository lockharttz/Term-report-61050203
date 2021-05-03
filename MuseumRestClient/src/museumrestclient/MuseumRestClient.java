/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumrestclient;

import util.MuseumClient;
import util.ThaiartsClient;

/**
 *
 * @author Oom
 */
public class MuseumRestClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MuseumClient pro = new MuseumClient();
        System.out.println(pro.getJson());
         ThaiartsClient thai = new ThaiartsClient();
        System.out.println(thai.getJson());
    }
    
}
