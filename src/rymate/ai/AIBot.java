/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rymate.ai;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jibble.jmegahal.JMegaHal;
import org.pircbotx.hooks.Listener;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

/**
 *
 * @author Ryan
 */
public class AIBot extends ListenerAdapter implements Listener {

    JMegaHal hal;

    public AIBot() {
        hal = new JMegaHal();
        try {
            hal.addDocument(new File("out.txt").toURI().toString());
        } catch (IOException ex) {
            Logger.getLogger(AIBot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void onMessage(MessageEvent event) throws Exception {
        if ((event.getMessage().startsWith("!gtfo")) && "rymate1234".equals(event.getUser().getNick())) {
            event.respond("kthxbai");
            event.getBot().disconnect();
        } else if ((event.getMessage().startsWith("!gtfo")) && event.getUser().getNick() != "rymate1234") {
            event.respond("Ahem.");
        }
        
        if ((event.getMessage().startsWith("!getMessage"))) {
            event.respond(hal.getSentence());
        }
        if (event.getMessage().startsWith("!converse ")) {
            String message = event.getMessage();
            message = message.replace("!converse ", "");
            event.getBot().sendMessage(event.getChannel(), hal.getSentence(message));
            hal.add(message);
        }
        
        if ((event.getMessage().startsWith("!ask"))) {
            event.getBot().sendMessage(event.getChannel(), "Got a question to ask the channel? Just go ahead and ask it! Don't ask to ask, if someone is there and they can answer, they will!");
        } 
        
        if ((event.getMessage().startsWith("!botsnack"))) {
            event.respond("Om nom nom nom. Thanks! :D");
        } 
        
        if (!event.getMessage().startsWith("!")) {
            try {
                // Create file 
                FileWriter fstream = new FileWriter("out.txt", true);
                BufferedWriter out = new BufferedWriter(fstream);
                out.write(event.getMessage() + ". \n");
                out.close();
                hal.add(event.getMessage()+ ".");
            } catch (Exception e) {//Catch exception if any
                System.err.println("Error: " + e.getMessage());
            }
        }
        
    }
}
