import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class pingClass {
    public static void main(String[] args) {
        String token = "INSERT TOKEN HERE";
        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        // javatac public invite: https://discord.com/invite/WA2KFhv
        api.addMessageCreateListener(ping ->{
           if(ping.getMessageContent().equals("ping!")){
               ping.getChannel().sendMessage("pong!");
           }

           if(ping.getMessage().getMentionedUsers().contains(api.getYourself())){
               ping.getChannel().sendMessage(ping.getMessageAuthor().asUser().get().getMentionTag());
           }
        });

    }
}
