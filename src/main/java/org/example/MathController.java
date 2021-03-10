package org.example;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @PostMapping(path = "/add")
    public String addTwoNumbers(@RequestBody String input){
        try {
            JSONObject object = (JSONObject) new JSONParser().parse(input);
          // obyčajný výpis z json tých dát
           // System.out.println(object.get("a"));
           // System.out.println(object.get("b"));

            int a = Integer.parseInt(String.valueOf(object.get("a")));
            int b = Integer.parseInt(String.valueOf(object.get("b")));
            int result = a+b;
            System.out.println(result);


        } catch (ParseException e) {
            e.printStackTrace();
        }


        return null;
    }
}
