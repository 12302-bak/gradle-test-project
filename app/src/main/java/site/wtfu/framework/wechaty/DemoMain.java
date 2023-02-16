package site.wtfu.framework.wechaty;

import io.github.wechaty.Wechaty;
import io.github.wechaty.user.Room;
import io.github.wechaty.utils.QrcodeUtils;
import org.apache.commons.lang3.StringUtils;

public class DemoMain {

    public static void main(String[] args) {
        System.setProperty("socksProxyHost", "127.0.0.1");
        System.setProperty("socksProxyPort", "1089");
        Wechaty bot = Wechaty.instance("puppet_padlocal_67828a56d0cb40b9857fcc04135c6309");
        bot.onScan((qrcode, statusScanStatus, data) -> System.out.println(QrcodeUtils.getQr(qrcode)))
                .onLogin(user -> System.out.println(user))
                .onMessage(message -> {
                    Room room = message.room();
                    String text = message.text();
                    if (StringUtils.equals(text, "#ding")) {
                        if (room != null) {
                            room.say("dong");
                        }
                    }})
                .start(true);

        System.out.println("process finished with  exit code 1");
    }

}
