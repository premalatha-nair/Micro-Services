public interface MessageService {

    void sendMessage(String msg, String rec);
}

class EmailServiceImpl implements MessageService {

    @Override
    public void sendMessage(String msg, String rec) {
        // logic to send email
        System.out.println("Email sent to " + rec + " with Message=" + msg);
    }

}

class SMSServiceImpl implements MessageService {

    @Override
    public void sendMessage(String msg, String rec) {
        // logic to send SMS
        System.out.println("SMS sent to " + rec + " with Message=" + msg);
    }

}

public interface Consumer {

    void processMessages(String msg, String rec);
}

class MyDIApplication implements Consumer {

    private MessageService service;

    public MyDIApplication(MessageService svc) {
        this.service = svc;
    }

    @Override
    public void processMessages(String msg, String rec) {
        // do some msg validation, manipulation logic etc
        this.service.sendMessage(msg, rec);
    }

}

public interface MessageServiceInjector {

    public Consumer getConsumer();
}

class EmailServiceInjector implements MessageServiceInjector {

    @Override
    public Consumer getConsumer() {
        return new MyDIApplication(new EmailServiceImpl());
    }

}

class SMSServiceInjector implements MessageServiceInjector {

    @Override
    public Consumer getConsumer() {
        return new MyDIApplication(new SMSServiceImpl());
    }
}

class MyMessageDITest {

    public static void main(String[] args) {
        String msg = "Hello customer";
        String email = "customer1@abc.com";
        String phone = "4088888888";
        MessageServiceInjector injector = null;
        Consumer app = null;

        // Send email
        injector = new EmailServiceInjector();
        app = injector.getConsumer();
        app.processMessages(msg, email);

        // Send SMS
        injector = new SMSServiceInjector();
        app = injector.getConsumer();
        app.processMessages(msg, phone);
    }

}
