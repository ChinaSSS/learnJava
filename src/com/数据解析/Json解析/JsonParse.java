package com.数据解析.Json解析;

import com.google.gson.stream.JsonReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonParse {


    @Test
    public void parseJson(){

        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/people.json");
        JsonReader jsonReader = new JsonReader(new InputStreamReader(is));
        List<People> peoples = new ArrayList<>();
        People people = null;
        try {
            //开始解析数组
            jsonReader.beginArray();

            while(jsonReader.hasNext()){
                //解析单个对象

                jsonReader.beginObject();
                people = new People();
                while (jsonReader.hasNext()){
                    switch (jsonReader.nextName()){
                        case "name":
                            people.setName(jsonReader.nextString());
                            break;
                        case "age":
                            people.setAge(jsonReader.nextInt());
                            break;
                        case "sex":
                            people.setSex(jsonReader.nextString());
                            break;
                        case "tel":
                            people.setTel(jsonReader.nextInt());
                            break;
                    }
                }

                jsonReader.endObject();
                peoples.add(people);

            }
            //结束解析数组
            jsonReader.endArray();
            for (People p : peoples){
                System.out.println(p.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
