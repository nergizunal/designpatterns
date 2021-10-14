import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;

public class EmailTopiv implements Subject{
    private  String message;
    private List<Observer> obs;

    public EmailTopiv() {
        this.obs = new ArrayList<>();
    }

    @Override
    public void register(Observer o) {
        if(o == null)
            throw new NullPointerException("Null Object!");
        else if(!obs.contains(o)) {
            this.obs.add(o);
            o.setSubsect(this);
        }
    }

    @Override
    public void unregister(Observer o) {
            if(obs.contains(o))
                this.obs.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer o : obs)
            o.update();
    }

    @Override
    public Object getUpdate(Observer o) {
            return this.message;
    }
    public void postMessage(String message){
        System.out.println("Message posted to my topic : " + message);
        this.message = message;
        this.notifyObservers();
    }
}
