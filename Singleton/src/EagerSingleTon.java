public class EagerSingleTon {
        String name;
        private static  EagerSingleTon uniqueInstance = new EagerSingleTon();
        private  EagerSingleTon(){}
        public static  EagerSingleTon getInstance(){
            return  uniqueInstance;
        }
    }


