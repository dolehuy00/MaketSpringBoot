package Springweb;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class SpringwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringwebApplication.class, args);
                
              //  VegetableModel m = new VegetableModel();
                //List<Vegetable> list = m.getAll();
                //list.forEach(System.out::println);
                
	}

}
