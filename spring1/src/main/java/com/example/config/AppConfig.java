package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.Alien;
import com.example.Computer;
import com.example.Desktop;
import com.example.Laptop;

@Configuration
@ComponentScan("com.example")
public class AppConfig {



    //Commenting below because we are using @Component in all individual classes

    // @Bean
    // public Alien alien(Computer com){ 
    //     //alien(@Autowired Computer com) autowired optional
    //     //alien(@Qualifier("lap") Computer com) to specify or to qualify which computer instance to choose
    //     Alien obj = new Alien();
    //     obj.setAge(21);
    //     obj.setcom(com);
    //     return obj;
    // }



    // // @Bean(name = {"com1","beast"})
    // // name used to give names to the bean, defaukt is the method name
    // @Bean
    // // @Scope("prototype")
    // public Desktop desktop(){
    //     return new Desktop();
    // }

    // @Bean
    // @Primary
    // public Laptop lap(){
    //     return new Laptop();
    // }
}
