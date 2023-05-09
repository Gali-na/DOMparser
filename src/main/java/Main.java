import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DOMpars domPars = new DOMpars();

        try {
           ArrayList <Human> humans= domPars.persDOM();
           for (Human human: humans){
               System.out.println(human.toString());
           }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }



    }
}