public class EmailTopicSubscriber implements Observer{
    private String name;
    private Subject topic;

    public EmailTopicSubscriber(String name) {
        this.name = name;

    }

    @Override
    public void update() {
        String msg = (String)topic.getUpdate(this);
        if(msg == null)
            System.out.println(name + " no new messages on this topic!");
        else
            System.out.println(name + " retrieving message " + msg);

    }

    @Override
    public void setSubsect(Subject s) {
        this.topic = s;
    }
}
