public class Main {
    public static void main(String [] args){
        EmailTopiv topic = new EmailTopiv();
        Observer obs1 = new EmailTopicSubscriber("first observer");
        Observer obs2 = new EmailTopicSubscriber("second observer");
        Observer obs3 = new EmailTopicSubscriber("third observer");
        topic.register(obs1);
        topic.register(obs2);
        topic.register(obs3);
        // Attaching observer to subject
        //obs1.setSubsect(topic);
        //obs2.setSubsect(topic);
        //obs3.setSubsect(topic);
        // check for update
        obs1.update();
        //Provider
        topic.postMessage("Hello Subscribers");

        topic.unregister(obs1);
        topic.postMessage("Hello Subscribers");

    }
}
