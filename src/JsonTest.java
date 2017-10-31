import jsonmodel.B;
import jsonmodel.KakaoModel;
import jsonmodel.Message;
import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.PropertyNamingStrategy;
import org.codehaus.jackson.map.introspect.AnnotatedField;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;

import java.io.IOException;

public class JsonTest {
//    static class A {
//        private String banana1;
//        private String apple;
//
//        public void setApple(String apple) {
//            this.apple = apple;
//        }
//
//        public String getBanana1() {
//            return banana1;
//        }
//
//        public void setBanana1(String banana1) {
//            this.banana1 = banana1;
//        }
//
//        public String getApple() {
//            return apple;
//        }
//    }
//
//    static class B {
//        public String tiger;
//        public String lion;
//    }
//
//    static class Message {
//        public A myname;
//        public B title;
//    }
//
//    static class KakaoModel {
//        public Message message;
//    }

    public static void main(String[] args) {
//        Message m = new Message();
//
//        m.myname = new A();
//        m.myname.banana1 = "a1";
//        m.myname.apple = "a2";
//
//        m.title = new B();
//        m.title.tiger = "b1";
//        m.title.lion = "b2";
//
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.setPropertyNamingStrategy(new UpperCaseStrategy());
//
//        try {
//            String json = mapper.writeValueAsString(m);
//            System.out.println(json);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        B b = new B();
        b.setC("my_string");

        Message m = new Message();
        m.setA("Astring");
        m.setB(b);

        KakaoModel model = new KakaoModel();
        model.setMessage(m);

        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(new UpperCaseStrategy());

        try {
            String json = mapper.writeValueAsString(model);
            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class UpperCaseStrategy extends PropertyNamingStrategy {
        @Override
        public String nameForField(MapperConfig<?> config, AnnotatedField field, String defaultName) {
            return defaultName.toUpperCase();
        }

        @Override
        public String nameForGetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
            return defaultName.toUpperCase();
        }

        @Override
        public String nameForSetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
            return defaultName.toUpperCase();
        }
    }
}
