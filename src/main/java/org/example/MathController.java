package org.example;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {

    @PostMapping(path = "/add")
    public ResponseEntity<String> addTwoNumbers(@RequestBody String input){
        try {
            JSONObject object = (JSONObject) new JSONParser().parse(input);
          // obyčajný výpis z json tých dát
           // System.out.println(object.get("a"));
           // System.out.println(object.get("b"));

            int a = Integer.parseInt(String.valueOf(object.get("a")));
            int b = Integer.parseInt(String.valueOf(object.get("b")));
            int result = a+b;
           // return "{\"result\":"+result+"}";// takto nie prosím NIKDY
           JSONObject resultik = new JSONObject();
           resultik.put("result",result);

           return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(resultik.toJSONString());
           //return resultik.toJSONString();
           // System.out.println(result);


        } catch (ParseException e) {
            e.printStackTrace();
        } catch (NumberFormatException e){
            JSONObject obj = new JSONObject();
            obj.put("Error:","INCORRECT BODY...");
            return ResponseEntity.status(400).contentType(MediaType.APPLICATION_JSON).body(obj.toJSONString());

        }


        return null;
    }

    @GetMapping(path = "/mul")
    public ResponseEntity<String> mulTwoNumbers(@RequestParam (value = "a") int aa, @RequestParam(value = "b") int bb){
        //System.out.println(aa * bb);
        int result = (aa*bb);
        JSONObject obj = new JSONObject();
        obj.put("result",result);

        return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(obj.toJSONString());
    }


}
