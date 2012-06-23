/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rymate.ai;

import org.pircbotx.hooks.Listener;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
import org.yaml.snakeyaml.Yaml;

/**
 *
 * @author Ryan
 */
public class CommandsBot extends ListenerAdapter implements Listener {

    //command persistance will be yml. Why? Because easily readable, that's why.
    Yaml yaml;
    
    public CommandsBot() {
    }
    
    @Override
    public void onMessage(MessageEvent event) throws Exception {
        if ((event.getMessage().startsWith("!test"))) {
            event.respond("Test Sucessful!");
        }
    }
    
}
