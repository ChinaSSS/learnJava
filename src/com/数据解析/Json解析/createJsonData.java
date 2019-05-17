package com.数据解析.Json解析;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//生成json数据对象
public class createJsonData {


    //一个json对象和java对象之间的转换
    @Test
    public void gson() throws FileNotFoundException {
        //将json数据解析成特定对象
        Gson gson = new Gson();
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/one.json");
        InputStreamReader reader = new InputStreamReader(is);
        Dog dog = gson.fromJson(reader,Dog.class);
        System.out.println(dog.toString());

        //将对象变成json数据
        Dog dog1 = new Dog("new dog",33);
        String json = gson.toJson(dog1);
        System.out.println(json);
    }

    @Test
    public void create(){

        //创建对象数据
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("aaa",22));
        dogs.add(new Dog("good",33));
        dogs.add(new Dog("man",66));
        dogs.add(new Dog("bbb",444));
        dogs.add(new Dog("eeee",42));
        //创建json对象组
        JsonArray array = new JsonArray();
        //往json组里添加数据
        for(Dog d:dogs){
            JsonObject object = new JsonObject();
            object.addProperty("name",d.getName());
            object.addProperty("age",d.getAge());
            array.add(object);
        }
        System.out.println(array);
    }

    @Test
    //一组java对象和json对象之间的转换
    public void ggson(){
        Gson gson = new Gson();
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/people.json");
        InputStreamReader reader = new InputStreamReader(is);
        TypeToken<List<People>> typeToken = new TypeToken<List<People>>(){};
        List<People> peoples = gson.fromJson(reader, typeToken.getType());
        System.out.println(peoples);

        //将一组java对象转换成json对象
        String json = gson.toJson(peoples, typeToken.getType());
        System.out.println(json);
    }

}
