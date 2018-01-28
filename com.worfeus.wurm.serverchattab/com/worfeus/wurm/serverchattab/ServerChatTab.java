/**
 * Created by Wim on 1/23/2018.
 */

package com.worfeus.wurm.serverchattab;


import com.wurmonline.server.players.Player;
import com.wurmonline.server.Message;

import java.util.Iterator;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
//import org.gotti.wurmunlimited.modloader.classhooks.HookManager;
import javassist.ClassPool;
import javassist.CtClass;
import org.gotti.wurmunlimited.modloader.classhooks.HookManager;
import org.gotti.wurmunlimited.modloader.interfaces.Configurable;
import org.gotti.wurmunlimited.modloader.interfaces.Initable;
import org.gotti.wurmunlimited.modloader.interfaces.PreInitable;
//import org.gotti.wurmunlimited.modloader.interfaces.ServerStartedListener;
import org.gotti.wurmunlimited.modloader.interfaces.PlayerLoginListener;
import org.gotti.wurmunlimited.modloader.interfaces.WurmServerMod;
//import org.gotti.wurmunlimited.modloader.interfaces.MessagePolicy;

public class ServerChatTab implements WurmServerMod, Initable, PreInitable, Configurable, PlayerLoginListener {
    private static final Logger logger = Logger.getLogger("ServerChatTab");
    String propertyLines[] = new String[10];

    public ServerChatTab() {
    }

    public void configure(Properties properties) {
        //this.disableWeeds = Boolean.valueOf(properties.getProperty("disableWeeds", Boolean.toString(this.disableWeeds))).booleanValue();
        //this.extraHarvest = Integer.valueOf(properties.getProperty("extraHarvest", Integer.toString(this.extraHarvest))).intValue();
        //this.logger.log(Level.INFO, "disableWeeds: " + this.disableWeeds);
        //this.logger.log(Level.INFO, "extraHarvest: " + this.extraHarvest);
        propertyLines[0] = String.valueOf(properties.getProperty("TabLine1", "Welcome to the Server Info Tab")).trim();
        propertyLines[1] = String.valueOf(properties.getProperty("TabLine2", "")).trim();
        propertyLines[2] = String.valueOf(properties.getProperty("TabLine3", "")).trim();
        propertyLines[3] = String.valueOf(properties.getProperty("TabLine4", "")).trim();
        propertyLines[4] = String.valueOf(properties.getProperty("TabLine5", "")).trim();
        propertyLines[5] = String.valueOf(properties.getProperty("TabLine6", "")).trim();
        propertyLines[6] = String.valueOf(properties.getProperty("TabLine7", "")).trim();
        propertyLines[7] = String.valueOf(properties.getProperty("TabLine8", "")).trim();
        propertyLines[8] = String.valueOf(properties.getProperty("TabLine9", "")).trim();
        propertyLines[9] = String.valueOf(properties.getProperty("TabLine10", "")).trim();
    }

    public void preInit(){

    }

    public void init(){

    }

    public void onPlayerLogin(Player player){
        int vRed = 229;
        int vGreen = 176;
        int vBlue = 17;

        try {

            for( int i = 0; i < propertyLines.length; i++)
            {
                String element = propertyLines[i];
                if (element.equalsIgnoreCase("<BLANK>"))
                {
                    player.getCommunicator().sendMessage(new Message(null, (byte) 0, "Server Info","", vRed, vGreen, vBlue));
                }
                else
                {
                    if (element.equalsIgnoreCase("<EMPTY>") == false)
                    {
                        player.getCommunicator().sendMessage(new Message(null, (byte) 0, "Server Info", element, vRed, vGreen, vBlue));
                    }
                }

            }

            //player.getCommunicator().sendMessage(new Message(null, (byte) 0, "Server Info", "Welcome to the server info tab", vRed, vGreen, vBlue));
            //player.getCommunicator().sendMessage(new Message(null, (byte) 0, "Server Info", "", vRed, vGreen, vBlue));
            //player.getCommunicator().sendMessage(new Message(null, (byte) 0, "Server Info", "Live Map: http://warpware.com/gaming/wu/Rynak/RynakPrime/index.html", vRed, vGreen, vBlue));
            //player.getCommunicator().sendMessage(new Message(null, (byte) 0, "Server Info", "Website: https://rynak.enjin.com/", vRed, vGreen, vBlue));

        } catch (Throwable var6) {
            logException("Error loading ServerChatTab mod", var6);
            throw new RuntimeException(var6);
        }
    }

    //@Override
    //public MessagePolicy onPlayerMessage(Communicator communicator, String message, String title) {
    //    if (title.equals("ServerInfo") && !message.startsWith("#") && !message.startsWith("/")) {
    //        return MessagePolicy.DISCARD;
    //    } else {
    //        return MessagePolicy.PASS;
    //    }
   // }


    public static void logException(String msg, Throwable e) {
        if(logger != null) {
            logger.log(Level.SEVERE, msg, e);
        }

    }

    public static void logWarning(String msg) {
        if(logger != null) {
            logger.log(Level.WARNING, msg);
        }

    }

    public static void logInfo(String msg) {
        if(logger != null) {
            logger.log(Level.INFO, msg);
        }

    }



}
