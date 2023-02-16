package site.wtfu.framework.pattern.mediator;

public class ChatRoom {

    public static void showMessage(User user, String  message){
        System.out.println(user.getName() + " : " + message);
    }
}
