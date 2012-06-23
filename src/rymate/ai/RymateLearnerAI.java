/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rymate.ai;

import org.pircbotx.PircBotX;

/**
 *
 * @author Ryan
 */
public class RymateAI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PircBotX bot = new PircBotX();

        //Setup this bot
        bot.setName("Rymate-Bot"); //Set the nick of the bot. CHANGE IN YOUR CODE
        bot.setLogin("rymate-bot"); //login part of hostmask, eg name:login@host
        bot.setVerbose(true); //Print everything, which is what you want to do 90% of the time
        bot.setAutoNickChange(true); //Automatically change nick when the current one is in use

        //This class is a listener, so add it to the bots known listeners
        bot.getListenerManager().addListener(new AIBot());

        try {
            //Connect to the freenode IRC network
            bot.connect("irc.freenode.org");
            bot.joinChannel("#overviewer");
            bot.joinChannel("#rymate");
            bot.joinChannel("#zte-crescent");
        } //In your code you should catch and handle each exception seperately,
        //but here we just lump them all togeather for simpliciy
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
