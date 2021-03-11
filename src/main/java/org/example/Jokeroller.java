package org.example;


import org.json.simple.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class Jokeroller {
    String joke1 = "What kind of sugar put lady gaga in tea?  Ra-ra-ga-ga :D ||";
    String joke2 = "Why betoween coudnt find his tishrt? because it was Hayden :D ||";
    String joke3 = "what's a witches favourite activity?  spelling :D ||";

    @GetMapping("/joke/{jokeNumber}")
    public ResponseEntity<String> getJokes(@PathVariable int jokeNumber){
        try {
            String jokeFinal = "";
            switch(jokeNumber) {
                case 1:
                    jokeFinal = joke1;
                    break;
                case 2:
                    jokeFinal = joke2;
                    break;
                case 3:
                    jokeFinal = joke3;
                    break;
                default:
            }
            String result = jokeFinal;
            JSONObject resultik = new JSONObject();
            resultik.put("result",result);
            return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(resultik.toJSONString());

        } catch (NumberFormatException e){
            JSONObject obj = new JSONObject();
            obj.put("Error:","INCORRECT BODY...");
            return ResponseEntity.status(400).contentType(MediaType.APPLICATION_JSON).body(obj.toJSONString());
        }
    }

    // všetky ftipy
    @GetMapping("/jokes")
    public ResponseEntity<String> getAllJokes(){
        try {
            String jokeFinal = joke1 + " " + joke2 + " " + joke3;

            String result = jokeFinal;
            JSONObject resultik = new JSONObject();
            resultik.put("result",result);

            return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(resultik.toJSONString());

        } catch (NumberFormatException e){
            JSONObject obj = new JSONObject();
            obj.put("Error:","INCORRECT BODY...");
            return ResponseEntity.status(400).contentType(MediaType.APPLICATION_JSON).body(obj.toJSONString());
        }
    }

    // RANDOM ftip
    @GetMapping("/joke")
    public ResponseEntity<String> getRandomJoke(){
        try {
            Random rn = new Random();
            int answer = rn.nextInt(3) + 1;
            String jokeFinal = " ";
            switch(answer) {
                case 1:
                    jokeFinal = joke1;
                    break;
                case 2:
                    jokeFinal = joke2;
                    break;
                case 3:
                    jokeFinal = joke3;
                    break;
                default:
                    // code block
            }

            String result = jokeFinal;
            JSONObject resultik = new JSONObject();
            resultik.put("result",result);

            return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(resultik.toJSONString());

        } catch (NumberFormatException e){
            JSONObject obj = new JSONObject();
            obj.put("Error:","INCORRECT BODY...");
            return ResponseEntity.status(400).contentType(MediaType.APPLICATION_JSON).body(obj.toJSONString());
        }
    }

}
